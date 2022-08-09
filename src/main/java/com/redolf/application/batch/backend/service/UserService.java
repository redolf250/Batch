package com.redolf.application.backend.service;

import com.redolf.application.backend.models.Customer;
import org.springframework.stereotype.Service;

@Service
public interface UserService {

    void saveUser(Customer customer);
}
