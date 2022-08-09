package com.redolf.application.batch.backend.models;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class DatabaseTest {

    private Database database;
    @BeforeEach
    void setUp() {
        database = new Database();
        database.setId(120);
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
    }

    @Test
    void getId() {
        database.getId();
        assertThat(database.getId())
                .isEqualTo(120)
                .isNotNull();
    }

    @Test
    void getDatabase_name() {
        assertThat(database.getDatabase_name())
                .isEqualTo("MySQL")
                .contains("M")
                .endsWith("L")
                .isMixedCase();
    }

    @Test
    void getHostname() {
        assertThat(database.getHostname())
                .isEqualTo("localhost")
                .isLowerCase();
    }

    @Test
    void getPort() {
        assertThat(database.getPort())
                .isEqualTo(3306)
                .isBetween(0,3306);
    }

    @Test
    void getDriver_name() {
        assertThat(database.getDriver_name())
                .isNotNull();
    }

    @Test
    void getUsername() {
        assertThat(database.getUsername())
                .isEqualTo("redolf")
                .isLowerCase()
                .contains("r")
                .hasSize(6);
    }

    @Test
    void getPassword() {
        assertThat(database.getPassword())
                .isLowerCase()
                .endsWith("7")
                .startsWith("0")
                .hasSize(10);
    }

    @Test
    void getSchema_name() {
        assertThat(database.getSchema_name())
                .isNotNull();
    }

    @Test
    void getUrl() {
        assertThat(database.getUrl())
                .startsWith("j")
                .isLowerCase();
    }

    @Test
    void getCreated_at() {
        assertThat(database.getCreated_at())
                .isToday();
    }

    @Test
    void setId() {
    }

    @Test
    void setDatabase_name() {
    }

    @Test
    void setHostname() {
    }

    @Test
    void setPort() {
    }

    @Test
    void setDriver_name() {
    }

    @Test
    void setUsername() {
    }

    @Test
    void setPassword() {
    }

    @Test
    void setSchema_name() {
    }

    @Test
    void setUrl() {
    }

    @Test
    void setCreated_at() {
    }
}