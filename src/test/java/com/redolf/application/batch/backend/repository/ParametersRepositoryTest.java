package com.redolf.application.batch.backend.repository;

import com.redolf.application.batch.frontend.enums.Operation;
import com.redolf.application.batch.frontend.models.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class ParametersRepositoryTest {

    @Autowired
    private ParametersRepository repository;

    @Autowired
    private SummaryRepository summaryRepository;

    @Autowired
    private ScheduleRepository scheduleRepository;

    @Autowired
    private TypesRepository typesRepository;

    @Autowired
    private StatusRepository statusRepository;

    @Autowired
    private BatchCategoryRepository categoryRepository;

    private Parameters parameters;

    private Summary summary;

    private Schedule schedule;

    private Types types;

    private Status status;

    private BatchCategory category;

    @BeforeEach
    void setUp() {
        parameters = new Parameters();
        parameters.setDate(LocalDate.now());
        parameters.setSummary(summary);
        parameters.setSchedule(schedule);
        parameters.setType(types);
        parameters.setStatus(status);
        parameters.setCategory(category);
        parameters.setGride_size(10L);
        parameters.setCore_pool_size(5L);
        parameters.setMax_pool_size(10L);
        parameters.setMinimum_lines(2L);
        parameters.setMaximum_lines(70000L);
        parameters.setKeep_alive_time(30000L);
        parameters.setNumber_of_threads(15);
        parameters.setRetry_limit(6);
        parameters.setRows_to_skip(8);
        parameters.setSkip_policy(10);
        parameters.setQueue_capacity(7L);

        summary = new Summary();
        summary.setParameters(parameters);
        summary.setFile_type("xml");
        summary.setDate(LocalDate.now());
        summary.setTime(LocalTime.now());
        summary.setSchema_name("students");
        summary.setTable_name("courses");

        schedule = new Schedule();
        schedule.setParameters(parameters);
        schedule.setDay_of_month(7);
        schedule.setDay_of_week("Monday");
        schedule.setHours(2);
        schedule.setMinutes(34);
        schedule.setMonth(5);

        types = new Types();
        types.setParameters(parameters);
        types.setOperation(Operation.WRITE);

        status = new Status();
        status.setStatus("SUCCESSFUL");
        status.setParameters(parameters);

        category = new BatchCategory();
        category.setCategory_name("SINGLE");
        category.setParameters(parameters);
    }

    @AfterEach
    void tearDown() {
        System.out.println("Running tearDown method");
    }

    @Test
    @Disabled
    void saveParameters(){
        repository.save(parameters);
        summaryRepository.save(summary);
        scheduleRepository.save(schedule);
        typesRepository.save(types);
        statusRepository.save(status);
        categoryRepository.save(category);
    }

    @Test
    void getAllParameters(){
        List<Parameters> listItems = repository.findAll();
        for(Parameters parameter : listItems){
            System.out.println(parameter+ "\n");
        }
    }

    @Test
    @Disabled
    void getAllParametersBetweenStartDateAndEndDate(){
        List<Parameters> listItems = repository.findAllParametersBetweenStartAndEnd(LocalDate.of(2022,8,2),LocalDate.of(2022,8,2));
        assertThat(listItems.size()).isGreaterThan(1);
        System.out.println("listItems = " + listItems);
    }

//    @Test
//    void test() {
//        List<Parameters> data = repository.findAll();
//        List<Parameters> list = new ArrayList<>();
//        for (Parameters parameter : data) {
//            list.add(new Parameters(parameter.getId(), parameter.getMaximum_lines(), parameter.getMinimum_lines(),
//                    parameter.getGride_size(), parameter.getNumber_of_threads(), parameter.getRows_to_skip(),
//                    parameter.getSkip_policy(), parameter.getCore_pool_size(), parameter.getMax_pool_size(),
//                    parameter.getQueue_capacity(), parameter.getRetry_limit(), parameter.getKeep_alive_time(),
//                    parameter.getDate(),));
//        }
//        assertThat(list.size()).isGreaterThanOrEqualTo(1);
//    }



}
