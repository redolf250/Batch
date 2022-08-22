package com.redolf.application.batch.frontend.models;

import lombok.*;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.time.LocalDate;

@Component
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name="tb_datasource", uniqueConstraints = {
        @UniqueConstraint(name = "uniqueDatabaseName",columnNames = {"database_name"})
})
public class Datasource_ {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int id;
    @Column(unique = true,nullable = false)
    private String database_name;
    @Column(nullable = false)
    private String hostname;
    @Column(nullable = false)
    private int port;
    @Column(nullable = false)
    private String driver_name;
    @Column(nullable = false)
    private String username;
    @Column(nullable = false)
    private String password;
    @Column(nullable = false)
    private String schema_name;
    @Column(nullable = false)
    private String url;
    private LocalDate created_at;
}
