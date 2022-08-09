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
@Table(name="tb_category")
public class BatchCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int category_id;
    private String category_name;

    @OneToOne
    private Parameters parameters;
}
