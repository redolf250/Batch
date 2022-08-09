package com.redolf.application.batch.frontend.DTO;


import lombok.*;

@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
@ToString
public class SearchBatch extends BatchParameters {
    private Long id;
    private Long core_pool_size;
    private String date;
    private Long gride_size;
    private Long keep_alive_time;
    private Long max_pool_size;
    private Long maximum_lines;
    private Long minimum_lines;
    private int number_of_threads;
    private Long queue_capacity;
    private int retry_limit;
    private int rows_to_skip;
    private int skip_policy;

}
