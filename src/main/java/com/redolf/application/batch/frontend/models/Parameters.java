package com.redolf.application.batch.frontend.models;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

@ToString
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "tb_batch_parameters")
public class Parameters {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Long maximum_lines;
    private Long minimum_lines;
    private Long gride_size;
    private int number_of_threads;
    private int rows_to_skip;
    private int skip_policy;
    private Long core_pool_size;
    private Long max_pool_size;
    private Long queue_capacity;
    private int retry_limit;
    private Long keep_alive_time;
    private LocalDate date;

    @OneToOne(mappedBy = "parameters",cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    private Summary summary;

    @OneToOne(mappedBy = "parameters",cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    private Schedule schedule;

    @OneToOne(mappedBy = "parameters",cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    private Types type;

    @OneToOne(mappedBy = "parameters",cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    private Status status;

    @OneToOne(mappedBy = "parameters",cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    private BatchCategory category;
}