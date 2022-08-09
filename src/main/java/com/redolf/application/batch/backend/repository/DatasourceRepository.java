package com.redolf.application.batch.backend.repository;

public interface DatasourceRepository extends org.springframework.data.jpa.repository.JpaRepository<com.redolf.application.batch.backend.models.Datasource, int> ,org.springframework.data.jpa.repository.JpaSpecificationExecutor<com.redolf.application.batch.backend.models.Datasource> {
}