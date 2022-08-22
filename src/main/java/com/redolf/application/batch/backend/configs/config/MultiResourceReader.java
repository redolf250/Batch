package com.redolf.application.batch.backend.configs.config;

import com.redolf.application.batch.backend.configs.entity.CustomerDTO;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.FlatFileItemWriter;
import org.springframework.batch.item.file.LineMapper;
import org.springframework.batch.item.file.MultiResourceItemReader;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.transform.BeanWrapperFieldExtractor;
import org.springframework.batch.item.file.transform.DelimitedLineAggregator;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;


public class MultiResourceReader {

    public JobBuilderFactory jobBuilderFactory;

    public StepBuilderFactory stepBuilderFactory;

    @Value(value = "src/main/resources/input/customer_.*csv")
    public Resource[] resource;

    @Bean
    public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
        return new PropertySourcesPlaceholderConfigurer();
    }

    @Bean
    public FlatFileItemReader<CustomerDTO> reader() {
        FlatFileItemReader<CustomerDTO> itemReader = new FlatFileItemReader<>();
        itemReader.setName("csvReader");
        itemReader.setLineMapper(lineMapper());
        return itemReader;
    }

    @Bean
    public MultiResourceItemReader<CustomerDTO> multiResourceItemReader(){
        MultiResourceItemReader<CustomerDTO> reader = new MultiResourceItemReader<>();
        reader.setResources(resource);
        reader.setDelegate(reader());
        reader.setName("csvReader");
        return reader;
    }

    @Bean
    public FlatFileItemWriter<CustomerDTO> flatFileItemWriter(){
        FlatFileItemWriter<CustomerDTO> writer = new FlatFileItemWriter<>();
        writer.setAppendAllowed(true);
        writer.setResource(new ClassPathResource("output/customers.csv"));

        DelimitedLineAggregator<CustomerDTO> lineAggregator = new DelimitedLineAggregator<>();
        lineAggregator.setDelimiter(",");

        BeanWrapperFieldExtractor<CustomerDTO> extractor = new BeanWrapperFieldExtractor<>();
        extractor.setNames(new String [] {"id", "firstName", "lastName", "email", "gender", "contactNo", "country", "dob"});
        lineAggregator.setFieldExtractor(extractor);

        writer.setLineAggregator(lineAggregator);
        return writer;
    }
    public LineMapper<CustomerDTO> lineMapper() {
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
    public CustomerProcessor<CustomerDTO> processor() {
        return new CustomerProcessor<>();
    }

    @Bean("multi_reader_slaveStep")
    public Step slaveStep() {
        return stepBuilderFactory.get("slaveStep").<CustomerDTO, CustomerDTO>chunk(10)
                .reader(multiResourceItemReader())
                .processor(processor())
                .writer(flatFileItemWriter())
                .build();
    }

    @Bean("multi_readerJob")
    public Job readerJob() {
        return jobBuilderFactory.get("exportCustomers")
                .incrementer(new RunIdIncrementer())
                .flow(slaveStep()).end().build();
    }
}
