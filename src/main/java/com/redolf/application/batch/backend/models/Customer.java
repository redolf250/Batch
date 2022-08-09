package com.redolf.application.batch.backend.models;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

import javax.persistence.*;


@NoArgsConstructor
@Component
@Getter
@Setter
@AllArgsConstructor
@Table(name = "tb_customer")
@Entity
public class Customer {
    @Id
    @Column(name = "userId", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(nullable = false)
    private String username;
    @Column(nullable = false)
    private String email;
    @Column(nullable = false)
    private String password;

}
