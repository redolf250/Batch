package com.redolf.application.batch.backend.configs.Partition;

import com.redolf.application.batch.frontend.controller.Batch;
import org.jetbrains.annotations.NotNull;
import org.springframework.batch.core.partition.support.Partitioner;
import org.springframework.batch.item.ExecutionContext;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

import static org.apache.commons.codec.language.bm.Rule.ALL;

@Component
@SuppressWarnings(ALL)
public class ColumnRangePartitioner extends Batch implements Partitioner {

    @NotNull
    @Override
    public Map<String, ExecutionContext> partition(int grid_size) {

        Map<String, ExecutionContext> result = new HashMap<>();
        Long minimum = values.getMinimum_field();
        Long maximum = values.getMaximum_field();

        Long targetSize = (maximum - minimum) / grid_size + 1;
        System.out.println("targetSize = " + targetSize);
        int number = 0;
        Long start = minimum;
        Long end = start + targetSize - 1;
        while (start <= maximum){
            ExecutionContext context = new ExecutionContext();
            result.put("partition"+number,context);
            if (end >= start){
                end = maximum;
            }
            context.putLong("minimum_value",start);
            context.putLong("maximum_value",end);
            start +=targetSize;
            end +=targetSize;
            number++;
        }
        System.out.println("partition result: " + result);
        return result;
    }
}
