package com.redolf.application.batch.backend.configs.databases;


import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;

import javax.sql.DataSource;

public class CustomDatabases {

    @Bean("batch_datasource")
    public DataSource datasource(){
        return DataSourceBuilder.create()
                .build();
    }
}
