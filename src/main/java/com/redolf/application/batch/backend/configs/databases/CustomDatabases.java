package com.redolf.application.batch.backend.configs.databases;


import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class CustomDatabases {

    @Bean()
    public DataSource datasource(){
        return DataSourceBuilder.create()
                .username("root")
                .password("0552588647")
                .driverClassName("com.mysql.cj.jdbc.Driver")
                .url("jdbc:mysql://localhost:3306/batch")
                .build();
    }
}
