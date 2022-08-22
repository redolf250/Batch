package com.redolf.application.batch.backend.configs.mapper;

import com.redolf.application.batch.backend.configs.entity.CustomerDTO;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CustomMapper implements RowMapper<CustomerDTO> {
    @Override
    public CustomerDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
        CustomerDTO customerDTO = new CustomerDTO();
        customerDTO.setId(rs.getInt("customer_id"));
        customerDTO.setContactNo(rs.getString("contact"));
        customerDTO.setCountry(rs.getString("country"));
        customerDTO.setDob(rs.getString("dob"));
        customerDTO.setEmail(rs.getString("email"));
        customerDTO.setGender(rs.getString("gender"));
        customerDTO.setFirstName(rs.getString("first_name"));
        customerDTO.setLastName(rs.getString("last_name"));
        return customerDTO;
    }
}
