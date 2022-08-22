package com.redolf.application.batch.backend.configs.config;


import com.redolf.application.batch.backend.configs.entity.CustomerDTO;
import com.redolf.application.batch.backend.configs.mapper.CustomPreparedStatementSetter;
import com.redolf.application.batch.backend.configs.writer.CustomerWriter;
import lombok.AllArgsConstructor;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.database.JdbcBatchItemWriter;
import org.springframework.batch.item.xml.StaxEventItemReader;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

public class BatchXMLWriteToDB {

    private JobBuilderFactory jobBuilderFactory;

    private StepBuilderFactory stepBuilderFactory;

    private DataSource datasource;

    @Bean
    public CustomerProcessor<CustomerDTO> processor(){
        return new CustomerProcessor();
    }

    @Bean
    public StaxEventItemReader<CustomerDTO> itemReader(){
        StaxEventItemReader<CustomerDTO> reader = new StaxEventItemReader<>();
        reader.setResource(new ClassPathResource("dataset.xml"));
        reader.setFragmentRootElementName("dataset");

        Map<String, String> map = new HashMap<>();
        map.put("dataset","com.redolf.application.batch.backend.configs.entity.CustomerDTO");
        return reader;
    }

    @Bean
    public CustomerWriter writer(){
        return new CustomerWriter();
    }

    @Bean
    public JdbcBatchItemWriter<CustomerDTO> jdbcBatchItemWriter(){
        JdbcBatchItemWriter<CustomerDTO> writer = new JdbcBatchItemWriter<>();
        writer.setDataSource(datasource);
        writer.setSql("");
        writer.setItemPreparedStatementSetter(new CustomPreparedStatementSetter());
        return writer;
    }

    @Bean("xmlstep")
    public Step step(){
        return stepBuilderFactory.get("step").<CustomerDTO,CustomerDTO>chunk(10)
                .reader(itemReader())
                .processor(processor())
                .writer(jdbcBatchItemWriter())
                .build();
    }

    @Bean("xmljob")
    public Job xmlJob(){
        return jobBuilderFactory.get("")
                .incrementer(new RunIdIncrementer())
                .flow(step())
                .end()
                .build();
    }


}
