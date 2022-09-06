package com.redolf.application.batch.backend.configs.config;

import lombok.AllArgsConstructor;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

import static org.apache.commons.codec.language.bm.Rule.ALL;

@Configuration
@AllArgsConstructor
@SuppressWarnings(ALL)
public class BatchXMLReadDB {

    private JobBuilderFactory jobBuilderFactory;

    private StepBuilderFactory stepBuilderFactory;

    private DataSource datasource;

}
