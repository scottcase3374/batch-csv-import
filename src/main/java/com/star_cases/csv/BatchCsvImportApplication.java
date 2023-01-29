package com.star_cases.csv;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class BatchCsvImportApplication implements CommandLineRunner
{
    @Autowired
    private JobLauncher jobLauncher;

    @Autowired
    private Job job;

    public static void main(final String[] args)
    {
		final ConfigurableApplicationContext ctx = SpringApplication.run(BatchCsvImportApplication.class, args);

		// Force Java process shutdown after job completes
		System.exit(SpringApplication.exit(ctx));
	}

    @Override
    public void run(final String... args) throws Exception
    {
        final JobParameters params = new JobParametersBuilder()
                .addString("JobID", String.valueOf(System.currentTimeMillis()))
                .toJobParameters();

        jobLauncher.run(job, params);
    }
}
