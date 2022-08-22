package com.redolf.application.batch.backend.configs.listners;

import com.redolf.application.batch.backend.configs.entity.CustomerDTO;
import lombok.SneakyThrows;
import org.springframework.batch.core.ItemWriteListener;

import java.util.List;

import static com.redolf.application.batch.frontend.utils.CustomLogger.current;
import static com.redolf.application.batch.frontend.utils.CustomLogger.logger;

public class CustomWriteItemListener implements ItemWriteListener<CustomerDTO> {


    @SneakyThrows
    @Override
    public void beforeWrite(List<? extends CustomerDTO> list) {
        logger("Writer in been initialize to start job @ "+current);
    }

    @SneakyThrows
    @Override
    public void afterWrite(List<? extends CustomerDTO> list) {
        logger("Writer work completed @ "+current);
    }

    @SneakyThrows
    @Override
    public void onWriteError(Exception e, List<? extends CustomerDTO> list) {
        logger(e.getMessage()+current);
    }
}
