package com.redolf.application.batch.backend.models;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Getter
@Setter
@Table(name = "tb_summary")
public class Summary {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String file_type;
    private String schema_name;
    private String table_name;
    private LocalDate date;
    private LocalTime time;

    @OneToOne(cascade = CascadeType.ALL)
    private Parameters parameters;
}
