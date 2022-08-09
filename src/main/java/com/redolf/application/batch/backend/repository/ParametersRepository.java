package com.redolf.application.batch.backend.repository;

import com.redolf.application.batch.backend.models.Parameters;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface ParametersRepository extends JpaRepository<Parameters, Long> {

    @Query(value = "Select * from tb_batch_parameters where date between ?1 and ?2",nativeQuery = true)
    List<Parameters> findAllParametersBetweenStartAndEnd(LocalDate start, LocalDate end);

    @Query(value = "select count(*) from tb_summary where file_type = ?",nativeQuery = true)
    int findAllByFileType(String file);
}