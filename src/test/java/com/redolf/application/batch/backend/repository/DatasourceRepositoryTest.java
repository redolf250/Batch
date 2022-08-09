package com.redolf.application.batch.backend.repository;

import com.redolf.application.batch.backend.models.Database;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class DatabaseRepositoryTest {

    @Autowired
    private DatabaseRepository databaseRepository;

    private Database database;

    @BeforeEach
    void setUp() {
        database = new Database();
        database.setDatabase_name("MySQL");
        database.setHostname("localhost");
        database.setPort(3306);
        database.setDriver_name("com.mysql.jdbc.Driver");
        database.setSchema_name("cars");
        database.setUsername("redolf");
        database.setPassword("0552588647");
        database.setUrl("jdbc:mysql://localhost:3306/cars");
        database.setCreated_at(LocalDate.now());
    }

    @AfterEach
    void tearDown() {
        System.out.println("Running tests in tearDown method");
    }

    @Test
    void save(){
        databaseRepository.save(database);
    }


}