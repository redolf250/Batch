package com.redolf.application.batch.backend.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name="tb_status")
public class Status {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int status_id;
    private String status;

    @OneToOne(fetch = FetchType.EAGER)
    private Parameters parameters;
}
