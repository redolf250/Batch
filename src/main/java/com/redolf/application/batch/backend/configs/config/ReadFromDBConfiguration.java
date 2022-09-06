package com.redolf.application.batch.backend.configs.config;

import com.redolf.application.batch.backend.configs.entity.CustomerDTO;
import com.redolf.application.batch.backend.configs.mapper.CustomMapper;
import lombok.AllArgsConstructor;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.database.JdbcCursorItemReader;
import org.springframework.batch.item.file.FlatFileItemWriter;
import org.springframework.batch.item.file.transform.BeanWrapperFieldExtractor;
import org.springframework.batch.item.file.transform.DelimitedLineAggregator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.FileSystemResource;

import javax.sql.DataSource;

import static com.redolf.application.batch.frontend.controller.Batch.filePath;
import static org.apache.commons.codec.language.bm.Rule.ALL;

@Configuration
@AllArgsConstructor
@SuppressWarnings(ALL)
public class ReadFromDBConfiguration{

    private JobBuilderFactory jobBuilderFactory;

    private StepBuilderFactory stepBuilderFactory;

    private DataSource datasource;

    @Bean
    @StepScope
    public JdbcCursorItemReader<CustomerDTO> jdbcCursorItemReader(){
        JdbcCursorItemReader<CustomerDTO> reader = new JdbcCursorItemReader<>();
        reader.setDataSource(datasource);
        reader.setRowMapper(new CustomMapper());
        reader.setSql("select * from customers_info");
        return reader;
    }

    @Bean(value = "reader_processor")
    public CustomerProcessor processor(){
        return new CustomerProcessor();
    }

    @Bean
    @StepScope
    public FlatFileItemWriter<CustomerDTO> itemWriter(){
        FlatFileItemWriter<CustomerDTO> writer = new FlatFileItemWriter<>();
        writer.setResource(new FileSystemResource(filePath));

        DelimitedLineAggregator<CustomerDTO> lineAggregator = new DelimitedLineAggregator<>();
        lineAggregator.setDelimiter(",");

        BeanWrapperFieldExtractor<CustomerDTO> extractor = new BeanWrapperFieldExtractor<>();
        extractor.setNames(new String [] {"id", "firstName", "lastName", "email", "gender", "contactNo", "country", "dob"});
        lineAggregator.setFieldExtractor(extractor);

        writer.setLineAggregator(lineAggregator);

        return writer;
    }

    @Bean("reader_slaveStep")
    public Step slaveStep() {
        return stepBuilderFactory.get("slaveStep").<CustomerDTO, CustomerDTO>chunk(100)
                .reader(jdbcCursorItemReader())
                .processor(processor())
                .writer(itemWriter())
                .build();
    }

    @Bean("readerJob")
    public Job readerJob() {
        return jobBuilderFactory.get("exportCustomers")
                .incrementer(new RunIdIncrementer())
                .flow(slaveStep()).end().build();
    }
}
