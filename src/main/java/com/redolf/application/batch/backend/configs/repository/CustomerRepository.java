package com.redolf.application.batch.backend.configs.repository;

import com.redolf.application.batch.backend.configs.entity.CustomerDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<CustomerDTO, Integer> {
}
