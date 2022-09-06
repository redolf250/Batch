package com.redolf.application.batch.backend.configs.mapper;

import com.redolf.application.batch.backend.configs.entity.CustomerDTO;
import org.springframework.batch.item.database.ItemPreparedStatementSetter;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CustomPreparedStatementSetter implements ItemPreparedStatementSetter<CustomerDTO> {

    @Override
    public void setValues(CustomerDTO customerDTO, PreparedStatement ps) throws SQLException {
       ps.setInt(1,customerDTO.getId());
       ps.setString(2,customerDTO.getContactNo());
       ps.setString(3,customerDTO.getCountry());
       ps.setString(4,customerDTO.getDob());
       ps.setString(5,customerDTO.getEmail());
       ps.setString(6,customerDTO.getFirstName());
       ps.setString(7,customerDTO.getGender());
       ps.setString(8,customerDTO.getLastName());
    }
}
