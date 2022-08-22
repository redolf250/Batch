package com.redolf.application.batch.frontend.DTO;

import lombok.*;

@ToString
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class DatabaseData {
    private String id;
    private String created_at;
    private String database_name;
    private String driver_name;
    private String hostname;
    private String password;
    private String port;
    private String schema_name;
    private String url;
    private String username;
}
