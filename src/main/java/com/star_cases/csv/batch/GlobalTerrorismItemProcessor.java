package com.star_cases.csv.batch;

import java.util.UUID;

import org.springframework.batch.item.ItemProcessor;

import jakarta.validation.constraints.NotNull;
import lombok.extern.java.Log;

@Log
public class GlobalTerrorismItemProcessor implements ItemProcessor<GlobalTerrorism, GlobalTerrorism>
{
    @Override
    public GlobalTerrorism process(final @NotNull GlobalTerrorism item) throws Exception
    {
        // All other fields come from the CSV source file, this demonstrates manipulating the data
        // prior to any later processing (none right now) or persistence. Adding what can be used
        // as a unique key for the data - not really needed for this dataset due to 'eventid' column
        // which is already unique in the CSV data though.

        item.setGlobalterrorism_id(UUID.randomUUID());
    	log.info(String.format("item %s", item));
        return item;
    }
}
