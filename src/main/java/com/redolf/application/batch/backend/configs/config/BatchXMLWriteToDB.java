package com.redolf.application.batch.backend.configs.config;


import com.redolf.application.batch.backend.configs.entity.CustomerDTO;
import com.redolf.application.batch.backend.configs.mapper.CustomPreparedStatementSetter;
import lombok.AllArgsConstructor;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.database.JdbcBatchItemWriter;
import org.springframework.batch.item.xml.StaxEventItemReader;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.ClassPathResource;
import org.springframework.oxm.xstream.XStreamMarshaller;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

@AllArgsConstructor
public class BatchXMLWriteToDB { 

    private JobBuilderFactory jobBuilderFactory;

    private StepBuilderFactory stepBuilderFactory;

    private DataSource datasource;

    @Bean
    public StaxEventItemReader<CustomerDTO> itemReader(){
        StaxEventItemReader<CustomerDTO> reader = new StaxEventItemReader<>();
        reader.setResource(new ClassPathResource("input/dataset.xml"));
        reader.setFragmentRootElementName("record");
        Map<String, String> map = new HashMap<>();
        map.put("record","com.redolf.application.batch.backend.configs.entity.CustomerDTO");
        XStreamMarshaller marshaller = new XStreamMarshaller();
        marshaller.setAliases(map);
        marshaller.setAutodetectAnnotations(true);
        reader.setUnmarshaller(marshaller);
        return reader;
    }

    @Bean
    public JdbcBatchItemWriter<CustomerDTO> jdbcBatchItemWriter(){
        JdbcBatchItemWriter<CustomerDTO> writer = new JdbcBatchItemWriter<>();
        writer.setDataSource(datasource);
        writer.setSql("insert into customers_info_xml(customer_id,contact,country,dob,email," +
                "first_name,gender,last_name) values(?,?,?,?,?,?,?,?)");
        writer.setItemPreparedStatementSetter(new CustomPreparedStatementSetter());
        return writer;
    }

    @Bean
    public CustomerProcessor processor(){
        return new CustomerProcessor();
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
        return jobBuilderFactory.get("xmlJob")
                .incrementer(new RunIdIncrementer())
                .flow(step())
                .end()
                .build();
    }
}
