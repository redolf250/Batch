package com.redolf.application.batch.backend.repository;

import com.redolf.application.batch.frontend.models.Summary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SummaryRepository extends JpaRepository<Summary, Integer> {

}