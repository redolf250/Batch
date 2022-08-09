package com.redolf.application.batch.backend.models;

import lombok.*;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.time.LocalDate;

@Component
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name="tb_datasource", uniqueConstraints = {
        @UniqueConstraint(name = "uniqueDatabaseName",columnNames = {"database_name"})
})
public class Datasource {

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
    @Column(nullable = false)
    private LocalDate created_at;
}
