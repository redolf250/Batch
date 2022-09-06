package com.redolf.application.batch.backend.configs.parameters;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

import static org.apache.commons.codec.language.bm.Rule.ALL;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Component
@SuppressWarnings(ALL)
public class JobValues {
    private Long minimum_field;
    private Long maximum_field;
    private Long gride_field ;
    private Integer thread_field;
    private Integer rows_to_skip_field ;
    private Integer skip_policy_field ;
    private Long core_size_field;
    private Long max_pool_size;
    private Long capacity_field;
    private Long retry_limit_field ;
    private Long alive_time ;
}
