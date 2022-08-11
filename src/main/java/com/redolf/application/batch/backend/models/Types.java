package com.redolf.application.batch.backend.models;

import com.redolf.application.batch.frontend.enums.Operation;
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
@Table(name="tb_operations")
public class Types {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private Operation operation;

    @OneToOne(cascade = CascadeType.ALL)
    private Parameters parameters;
}
