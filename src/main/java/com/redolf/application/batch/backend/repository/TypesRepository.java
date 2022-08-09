package com.redolf.application.batch.backend.repository;

import com.redolf.application.batch.backend.models.Types;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TypesRepository extends JpaRepository<Types, Integer> {
}