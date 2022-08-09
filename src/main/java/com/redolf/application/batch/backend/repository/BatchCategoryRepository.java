package com.redolf.application.batch.backend.repository;

import com.redolf.application.batch.backend.models.BatchCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BatchCategoryRepository extends JpaRepository<BatchCategory, Integer> {
}