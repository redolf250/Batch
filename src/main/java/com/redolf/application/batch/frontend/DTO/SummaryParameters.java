package com.redolf.application.batch.frontend.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class SummaryParameters {
    private int id;
    private String file_type;
    private String date;
    private String schema_name;
    private String table_name;
    private String time;
}
