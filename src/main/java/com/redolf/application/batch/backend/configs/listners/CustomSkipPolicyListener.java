package com.redolf.application.batch.backend.configs.listners;

import com.redolf.application.batch.backend.configs.entity.CustomerDTO;
import org.springframework.batch.core.SkipListener;

import static org.apache.commons.codec.language.bm.Rule.ALL;

@SuppressWarnings(ALL)
public class CustomSkipPolicyListener implements SkipListener<CustomerDTO, CustomerDTO> {

    @Override
    public void onSkipInRead(Throwable throwable) {

    }

    @Override
    public void onSkipInWrite(CustomerDTO customerDTO, Throwable throwable) {

    }

    @Override
    public void onSkipInProcess(CustomerDTO customerDTO, Throwable throwable) {

    }

}
