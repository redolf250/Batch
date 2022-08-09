package com.redolf.application.batch.backend.models;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ParametersTest {

    private Parameters parameters;

    @BeforeEach
    void setUp() {
        parameters = new Parameters();
        parameters.setDate(LocalDate.now());
        parameters.setGride_size(19L);
        parameters.setCore_pool_size(3L);
        parameters.setMax_pool_size(30L);
        parameters.setMinimum_lines(1L);
        parameters.setMaximum_lines(60000L);
        parameters.setKeep_alive_time(20000L);
        parameters.setNumber_of_threads(19);
        parameters.setRetry_limit(4);
        parameters.setRows_to_skip(2);
        parameters.setSkip_policy(5);
        parameters.setQueue_capacity(5L);
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void getId() {
        assertThat(parameters.getId())
                .isNull();
    }

    @Test()
    void getMaximum_lines() {
        assertThat(parameters.getMaximum_lines())
                .isNotNull()
                .isNotNegative()
                .isGreaterThan(0L);
        assertThat(parameters)
                .isInstanceOf(Parameters.class);
    }

    @Test
    void getMinimum_lines() {
        assertThat(parameters.getMinimum_lines())
                .isNotNull();
    }

    @Test
    void getGride_size() {
        assertThat(parameters.getGride_size())
                .isNotNull();
    }

    @Test
    void getNumber_of_threads() {
        assertThat(parameters.getNumber_of_threads())
                .isNotNull();
    }

    @Test
    void getRows_to_skip() {
        assertThat(parameters.getRows_to_skip())
                .isNotNull();
    }

    @Test
    void getSkip_policy() {
        assertThat(parameters.getSkip_policy())
                .isNotNull();
    }

    @Test
    void getCore_pool_size() {
        assertThat(parameters.getCore_pool_size())
                .isNotNull();
    }

    @Test
    void getMax_pool_size() {
        assertThat(parameters.getMax_pool_size())
                .isNotNull();
    }

    @Test
    void getQueue_capacity() {
        assertThat(parameters.getQueue_capacity())
                .isNotNull();
    }

    @Test
    void getRetry_limit() {
        assertThat(parameters.getRetry_limit())
                .isNotNull();
    }

    @Test
    void getKeep_alive_time() {
        assertThat(parameters.getKeep_alive_time())
                .isNotNull();
    }

    @Test
    void getDate() {
        assertThat(parameters.getDate())
                .isToday();
    }

    @Test
    void setId() {

    }
}