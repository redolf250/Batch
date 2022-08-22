package com.redolf.application.batch.backend.models;

import com.redolf.application.batch.frontend.models.Datasource_;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class DatasourceTest {

    private Datasource_ datasource;
    @BeforeEach
    void setUp() {
        datasource = new Datasource_();
        datasource.setId(120);
        datasource.setDatabase_name("MySQL");
        datasource.setHostname("localhost");
        datasource.setPort(3306);
        datasource.setDriver_name("com.mysql.jdbc.Driver");
        datasource.setSchema_name("cars");
        datasource.setUsername("redolf");
        datasource.setPassword("0552588647");
        datasource.setUrl("jdbc:mysql://localhost:3306/cars");
        datasource.setCreated_at(LocalDate.now());
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void getId() {
        datasource.getId();
        assertThat(datasource.getId())
                .isEqualTo(120)
                .isNotNull();
    }

    @Test
    void getDatabase_name() {
        assertThat(datasource.getDatabase_name())
                .isEqualTo("MySQL")
                .contains("M")
                .endsWith("L")
                .isMixedCase();
    }

    @Test
    void getHostname() {
        assertThat(datasource.getHostname())
                .isEqualTo("localhost")
                .isLowerCase();
    }

    @Test
    void getPort() {
        assertThat(datasource.getPort())
                .isEqualTo(3306)
                .isBetween(0,3306);
    }

    @Test
    void getDriver_name() {
        assertThat(datasource.getDriver_name())
                .isNotNull();
    }

    @Test
    void getUsername() {
        assertThat(datasource.getUsername())
                .isEqualTo("redolf")
                .isLowerCase()
                .contains("r")
                .hasSize(6);
    }

    @Test
    void getPassword() {
        assertThat(datasource.getPassword())
                .isLowerCase()
                .endsWith("7")
                .startsWith("0")
                .hasSize(10);
    }

    @Test
    void getSchema_name() {
        assertThat(datasource.getSchema_name())
                .isNotNull();
    }

    @Test
    void getUrl() {
        assertThat(datasource.getUrl())
                .startsWith("j")
                .isLowerCase();
    }

    @Test
    void getCreated_at() {
        assertThat(datasource.getCreated_at())
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