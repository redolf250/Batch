package com.redolf.application.batch.frontend.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class ScheduleParameters {
    private int id;
    private String day_of_week;
    private String day_of_month;
    private int hours;
    private int minutes;
    private int month;


}
