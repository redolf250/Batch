package com.redolf.application.batch.backend.configs.listners;

import com.redolf.application.batch.backend.configs.entity.CustomerDTO;
import org.springframework.batch.core.ItemProcessListener;

import static org.apache.commons.codec.language.bm.Rule.ALL;

@SuppressWarnings(ALL)
public class CustomerProcessorrListener implements ItemProcessListener<CustomerDTO, CustomerDTO> {
    @Override
    public void beforeProcess(CustomerDTO customerDTO) {

    }

    @Override
    public void afterProcess(CustomerDTO customerDTO, CustomerDTO customerDTO2) {

    }

    @Override
    public void onProcessError(CustomerDTO customerDTO, Exception e) {

    }
}
