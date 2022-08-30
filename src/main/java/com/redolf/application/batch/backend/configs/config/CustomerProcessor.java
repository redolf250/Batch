package com.redolf.application.batch.backend.configs.config;

import com.redolf.application.batch.backend.configs.entity.CustomerDTO;
import org.springframework.batch.item.ItemProcessor;

public class CustomerProcessor implements ItemProcessor<CustomerDTO,CustomerDTO> {

    @Override
    public CustomerDTO process(CustomerDTO customer) throws Exception {
            return customer;
    }
}
