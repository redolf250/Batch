package com.redolf.application.batch.backend.configs.mapper;

import com.redolf.application.batch.backend.configs.entity.CustomerDTO;
import org.springframework.batch.item.database.ItemPreparedStatementSetter;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CustomPreparedStatementSetter implements ItemPreparedStatementSetter<CustomerDTO> {

    @Override
    public void setValues(CustomerDTO customerDTO, PreparedStatement preparedStatement) throws SQLException {

    }
}
