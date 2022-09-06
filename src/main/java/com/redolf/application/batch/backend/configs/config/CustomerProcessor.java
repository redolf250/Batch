package com.redolf.application.batch.backend.configs.config;

import com.redolf.application.batch.backend.configs.entity.CustomerDTO;
import org.springframework.batch.item.ItemProcessor;

import static org.apache.commons.codec.language.bm.Rule.ALL;

@SuppressWarnings(ALL)
public class CustomerProcessor implements ItemProcessor<CustomerDTO,CustomerDTO> {

    @Override
    public CustomerDTO process(CustomerDTO customer) throws Exception {
            return customer;
    }
}
