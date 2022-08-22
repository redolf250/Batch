package com.redolf.application.batch.backend.configs.writer;

import com.redolf.application.batch.backend.configs.entity.CustomerDTO;
import com.redolf.application.batch.backend.configs.repository.CustomerRepository;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CustomerWriter implements ItemWriter<CustomerDTO> {

    @Autowired
    private CustomerRepository repository;

    @Override
    public void write(List<? extends CustomerDTO> list) {
        System.out.println("Thread name: " + Thread.currentThread().getName());
        repository.saveAll(list);
    }
}
