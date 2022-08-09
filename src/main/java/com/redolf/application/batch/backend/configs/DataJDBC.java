package com.redolf.application.batch.backend.configs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;


public class DataJDBC {

    @Bean
    DataSource dataSource(){
        DriverManagerDataSource data = new DriverManagerDataSource();
        data.setPassword("0552588647");
        data.setUsername("root");
        data.setUrl("jdbc:mysql://localhost:3306/batch");
        data.setUrl("com.mysql.cj.jdbc.Driver");
        return data;
    }

    @Bean
    JdbcTemplate getTemplate(){
        return new JdbcTemplate();
    }
}
