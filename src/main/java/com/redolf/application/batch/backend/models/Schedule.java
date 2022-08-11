package com.redolf.application.batch.backend.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

import javax.persistence.*;

@Component
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "tb_schedule_task")
public class Schedule {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private int id;
    private int minutes;
    private int month;
    private int hours;
    private String day_of_week;
    private int day_of_month;

    @OneToOne(cascade = CascadeType.ALL)
    private Parameters parameters;
}