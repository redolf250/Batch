package com.redolf.application.batch.backend.repository;

import com.redolf.application.batch.backend.models.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<Customer, Long> {
}
