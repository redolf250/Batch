package com.redolf.application.batch.backend.configs.listners;

import com.redolf.application.batch.backend.configs.entity.CustomerDTO;
import org.springframework.batch.core.ItemReadListener;

public class CustomItemReadListener implements ItemReadListener<CustomerDTO> {

    @Override
    public void beforeRead() {

    }

    @Override
    public void afterRead(CustomerDTO customerDTO) {

    }

    @Override
    public void onReadError(Exception e) {

    }
}
