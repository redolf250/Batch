package com.redolf.application.batch.backend.configs.config;

import com.redolf.application.batch.backend.configs.Partition.ColumnRangePartitioner;
import com.redolf.application.batch.backend.configs.entity.CustomerDTO;
import com.redolf.application.batch.backend.configs.listners.CustomWriteItemListener;
import com.redolf.application.batch.backend.configs.repository.CustomerRepository;
import com.redolf.application.batch.backend.configs.writer.CustomerWriter;
import lombok.AllArgsConstructor;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.JobScope;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.core.partition.PartitionHandler;
import org.springframework.batch.core.partition.support.TaskExecutorPartitionHandler;
import org.springframework.batch.item.data.RepositoryItemWriter;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.LineMapper;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.task.TaskExecutor;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import static com.redolf.application.batch.frontend.controller.Batch.*;

@Configuration
@AllArgsConstructor
public class SpringBatchConfig {

    private JobBuilderFactory jobBuilderFactory;

    private StepBuilderFactory stepBuilderFactory;

    private CustomerWriter writer;

    private CustomerRepository customerRepository;

    @Bean
    @StepScope
    public FlatFileItemReader<CustomerDTO> reader() {
        FlatFileItemReader<CustomerDTO> itemReader = new FlatFileItemReader<>();
        itemReader.setResource(new FileSystemResource(getFile));
        itemReader.setName("csvReader");
        itemReader.setLinesToSkip(values.getRows_to_skip_field());
        itemReader.setLineMapper(lineMapper());
        return itemReader;
    }

    private LineMapper<CustomerDTO> lineMapper() {
        DefaultLineMapper<CustomerDTO> lineMapper = new DefaultLineMapper<>();

        DelimitedLineTokenizer lineTokenizer = new DelimitedLineTokenizer();
        lineTokenizer.setDelimiter(",");
        lineTokenizer.setStrict(false);
        lineTokenizer.setNames("id", "firstName", "lastName", "email", "gender", "contactNo", "country", "dob");

        BeanWrapperFieldSetMapper<CustomerDTO> fieldSetMapper = new BeanWrapperFieldSetMapper<>();
        fieldSetMapper.setTargetType(CustomerDTO.class);

        lineMapper.setLineTokenizer(lineTokenizer);
        lineMapper.setFieldSetMapper(fieldSetMapper);
        return lineMapper;

    }

    @Bean
    public CustomerProcessor processor() {
        return new CustomerProcessor();
    }

    @Bean
    public RepositoryItemWriter<CustomerDTO> writer() {
        RepositoryItemWriter<CustomerDTO> writer = new RepositoryItemWriter<>();
        writer.setRepository(customerRepository);
        writer.setMethodName("save");
        return writer;
    }

    @Bean
    public ColumnRangePartitioner partitioner(){
        return new ColumnRangePartitioner();
    }

    @Bean
    @StepScope
    public PartitionHandler partitionHandler(){
        TaskExecutorPartitionHandler handler = new TaskExecutorPartitionHandler();
        handler.setGridSize(Math.toIntExact(values.getGride_field()));
        handler.setTaskExecutor(taskExecutor());
        handler.setStep(slaveStep());
        return handler;
    }

    @Bean
    public Step slaveStep() {
        return stepBuilderFactory.get("slaveStep").<CustomerDTO, CustomerDTO>chunk(chunkSize)
                .reader(reader())
                .processor(processor())
                .listener(writeItemListener())
                .writer(writer)
                .faultTolerant().skipPolicy(skipPolicy())
                .build();
    }

    @Bean
    public Step masterStep() {
        return stepBuilderFactory.get("masterStep")
                .partitioner(slaveStep().getName(),partitioner())
                .partitionHandler(partitionHandler())
                .build();
    }

    @Bean
    @Primary
    public Job runJob() {
        return jobBuilderFactory.get("importCustomers")
                .flow(masterStep()).end().build();
    }

    @Bean
    @JobScope
    public TaskExecutor taskExecutor() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(Math.toIntExact(values.getCore_size_field()));
        executor.setMaxPoolSize(Math.toIntExact(values.getMax_pool_size()));
        executor.setPrestartAllCoreThreads(true);
        executor.setAllowCoreThreadTimeOut(true);
        executor.setKeepAliveSeconds(Math.toIntExact(values.getAlive_time()));
        executor.setQueueCapacity(Math.toIntExact(values.getCapacity_field()));
        return executor;
    }

    @Bean
    public CustomWriteItemListener writeItemListener(){
        return new CustomWriteItemListener();
    }

    @Bean
    public JobSkipPolicy skipPolicy(){
        return new JobSkipPolicy();
    }
}
