package com.redolf.application.batch.backend.configs.config;

import org.springframework.batch.core.step.skip.SkipLimitExceededException;
import org.springframework.batch.core.step.skip.SkipPolicy;

import static com.redolf.application.batch.frontend.controller.Batch.*;
import static org.apache.commons.codec.language.bm.Rule.ALL;

@SuppressWarnings(ALL)
public class JobSkipPolicy implements SkipPolicy {
    @Override
    public boolean shouldSkip(Throwable throwable, int failedCount) throws SkipLimitExceededException {
        return failedCount <= values.getSkip_policy_field();
    }
}
