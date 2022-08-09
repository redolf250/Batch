package com.redolf.application.batch.backend.repository;

import com.redolf.application.batch.backend.models.Datasource_;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;

@SpringBootTest
class DatasourceRepositoryTest {

    @Autowired
    private DatasourceRepository datasourceRepository;

    private Datasource_ datasource;

    @BeforeEach
    void setUp() {
        datasource = new Datasource_();
        datasource.setDatabase_name("MS SQL");
        datasource.setHostname("localhost");
        datasource.setPort(7000);
        datasource.setDriver_name("org.mssql.Driver");
        datasource.setSchema_name("inventory");
        datasource.setUsername("redolf");
        datasource.setPassword("0552588647");
        datasource.setUrl("jdbc:mysql://localhost:3306/stock");
        datasource.setCreated_at(LocalDate.now());
    }

    @AfterEach
    void tearDown() {
        System.out.println("Running tests in tearDown method");
    }

    @Test
    void save(){
        datasourceRepository.save(datasource);
    }


}