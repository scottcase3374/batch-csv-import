package com.star_cases.csv.batch;

import java.util.logging.Level;
import org.springframework.batch.core.BatchStatus;
import org.springframework.batch.core.ExitStatus;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobExecutionListener;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import jakarta.validation.constraints.NotNull;
import lombok.extern.java.Log;

@Log
@Component
public class JobCompletionNotificationListener implements JobExecutionListener
{
    private final JdbcTemplate jdbcTemplate;

    public JobCompletionNotificationListener(final @NotNull JdbcTemplate jdbcTemplate)
    {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void afterJob(final @NotNull JobExecution jobExecution)
    {
        if (jobExecution.getStatus() == BatchStatus.COMPLETED)
        {
        	if (log.isLoggable(Level.INFO))
        	{
        		log.info(String.format("Job Completed [%s] completed - total rows [%d]",
                    jobExecution.getJobInstance().getJobName(),
                    jdbcTemplate.queryForObject("SELECT count(*) from global_terrorism", Long.class)));
        	}
        }
        else
        {

        	if (log.isLoggable(Level.SEVERE))
        	{
        		jobExecution.getAllFailureExceptions().listIterator().forEachRemaining(t -> log.severe(t.toString()));

        		jobExecution.setExitStatus(ExitStatus.COMPLETED);

        		log.severe(String.format("Job [%s] status[%s] ended with exit code [%s] description [%s]",
                    jobExecution.getJobInstance().getJobName(),
                    jobExecution.getStatus().toString(),
                    jobExecution.getExitStatus().getExitCode(),
                    jobExecution.getExitStatus().getExitDescription()
                    ));

        	}
        }
    }
}