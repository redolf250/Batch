package com.redolf.application.batch.backend.configs.config;

import org.springframework.batch.core.step.skip.SkipLimitExceededException;
import org.springframework.batch.core.step.skip.SkipPolicy;

import static org.apache.commons.codec.language.bm.Rule.ALL;

@SuppressWarnings(ALL)
public class CustomFaultSkipPolicy implements SkipPolicy {

    @Override
    public boolean shouldSkip(Throwable throwable, int i) throws SkipLimitExceededException {
        return false;
    }
}
