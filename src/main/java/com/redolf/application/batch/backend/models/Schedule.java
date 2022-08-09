package com.redolf.application.batch.backend.models;

import javax.persistence.*;

@Entity
@Table(name = "tb_schedule_job")
public class ScheduleJob {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;


}