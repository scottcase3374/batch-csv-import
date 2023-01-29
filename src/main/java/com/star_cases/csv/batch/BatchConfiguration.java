package com.star_cases.csv.batch;


import java.io.IOException;
import java.net.URL;
import javax.sql.DataSource;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.repository.support.JobRepositoryFactoryBean;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.database.BeanPropertyItemSqlParameterSourceProvider;
import org.springframework.batch.item.database.builder.JdbcBatchItemWriterBuilder;
import org.springframework.batch.item.file.builder.FlatFileItemReaderBuilder;
import org.springframework.batch.item.file.builder.MultiResourceItemReaderBuilder;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.InputStreamResource;
import org.springframework.transaction.PlatformTransactionManager;

import jakarta.validation.constraints.NotNull;

@Configuration
@EnableBatchProcessing
public class BatchConfiguration
{
	@Bean
	InputStreamResource dataStreamRes(final @Value("${dataUrl}") String dataURL) throws IOException
	{
		return new InputStreamResource(new URL(dataURL).openStream());
	}

    @Bean
    ItemWriter<GlobalTerrorism> writer(final @NotNull DataSource dataSource)
    {
      return new JdbcBatchItemWriterBuilder<GlobalTerrorism>()
        .itemSqlParameterSourceProvider(new BeanPropertyItemSqlParameterSourceProvider<>())
        .sql("INSERT INTO public.global_terrorism\n"
                + "(globalterrorism_id,"
                + " addnotes, alternative, alternative_txt, approxdate, attacktype1, attacktype1_txt, attacktype2, attacktype2_txt, attacktype3, attacktype3_txt,"
                + " city, claim2, claim3, claimed, claimmode, claimmode2, claimmode2_txt, claimmode3, claimmode3_txt, claimmode_txt,"
                + " compclaim, corp1, corp2, corp3, country, country_txt, crit1, crit2, crit3, dbsource,"
                + " divert, doubtterr, eventid, extended, gname, gname2, gname3, gsubname, gsubname2, gsubname3,"
                + " guncertain1, guncertain2, guncertain3, hostkidoutcome, hostkidoutcome_txt, iday, imonth, individual, int_any, int_ideo, "
                + " int_log, int_misc, ishostkid, iyear, kidhijcountry, latitude, \"location\", longitude, motive, multiple, "
                + " natlty1, natlty1_txt, natlty2, natlty2_txt, natlty3, natlty3_txt, ndays, nhostkid, nhostkidus, nhours, "
                + " nkill, nkillter, nkillus, nperpcap, nperps, nreleased, nwound, nwoundte, nwoundus, propcomment,"
                + " property, propextent, propextent_txt, propvalue, provstate, ransom, ransomamt, ransomamtus, ransomnote, ransompaid,"
                + " ransompaidus, region, region_txt, related, resolution, scite1, scite2, scite3, specificity, success, "
                + " suicide, summary, target1, target2, target3, targsubtype1, targsubtype1_txt, targsubtype2, targsubtype2_txt, targsubtype3, "
                + " targsubtype3_txt, targtype1, targtype1_txt, targtype2, targtype2_txt, targtype3, targtype3_txt, vicinity, weapdetail, weapsubtype1, "
                + " weapsubtype1_txt, weapsubtype2, weapsubtype2_txt, weapsubtype3, weapsubtype3_txt, weapsubtype4, weapsubtype4_txt, weaptype1, weaptype1_txt, weaptype2,"
                + " weaptype2_txt, weaptype3, weaptype3_txt, weaptype4, weaptype4_txt)"

                + "VALUES("
                + ":globalterrorism_id, "
                + ":addnotes, :alternative, :alternative_txt, :approxdate, :attacktype1, :attacktype1_txt, :attacktype2, :attacktype2_txt, :attacktype3, :attacktype3_txt,"
                + ":city, :claim2, :claim3, :claimed, :claimmode, :claimmode2, :claimmode2_txt, :claimmode3, :claimmode3_txt, :claimmode_txt, "
                + ":compclaim, :corp1, :corp2, :corp3, :country, :country_txt, :crit1, :crit2, :crit3, :dbsource,"
                + ":divert, :doubtterr, :eventid, :extended, :gname, :gname2, :gname3, :gsubname, :gsubname2, :gsubname3,"
                + ":guncertain1, :guncertain2, :guncertain3, :hostkidoutcome, :hostkidoutcome_txt, :iday, :imonth, :individual, :int_any, :int_ideo,"
                + ":int_log, :int_misc, :ishostkid, :iyear, :kidhijcountry, :latitude, :location, :longitude, :motive, :multiple,"
                + ":natlty1, :natlty1_txt, :natlty2, :natlty2_txt, :natlty3, :natlty3_txt, :ndays, :nhostkid, :nhostkidus, :nhours,"
                + ":nkill, :nkillter, :nkillus, :nperpcap, :nperps, :nreleased, :nwound, :nwoundte, :nwoundus, :propcomment,"
                + ":property, :propextent, :propextent_txt, :propvalue, :provstate, :ransom, :ransomamt, :ransomamtus, :ransomnote, :ransompaid,"
                + ":ransompaidus, :region, :region_txt, :related, :resolution, :scite1, :scite2, :scite3, :specificity, :success,"
                + ":suicide, :summary, :target1, :target2, :target3, :targsubtype1, :targsubtype1_txt, :targsubtype2, :targsubtype2_txt, :targsubtype3,"
                + ":targsubtype3_txt, :targtype1, :targtype1_txt, :targtype2, :targtype2_txt, :targtype3, :targtype3_txt, :vicinity, :weapdetail, :weapsubtype1,"
                + ":weapsubtype1_txt, :weapsubtype2, :weapsubtype2_txt, :weapsubtype3, :weapsubtype3_txt, :weapsubtype4, :weapsubtype4_txt, :weaptype1, :weaptype1_txt, :weaptype2,"
                + " :weaptype2_txt, :weaptype3, :weaptype3_txt, :weaptype4, :weaptype4_txt"
                + ");"
                )
        .dataSource(dataSource)
        .build();
    }

    @Bean
    ItemReader<GlobalTerrorism> reader(final InputStreamResource dataStreamRes)
    {
      return new MultiResourceItemReaderBuilder<GlobalTerrorism>()
        .name("GlobalTerrorismItemReader")
        .resources(dataStreamRes)
        .delegate(
        		new FlatFileItemReaderBuilder<GlobalTerrorism>()
        		.name("GlobalTerrorismgItemReader")
        		.delimited()
        		.names(
	                "eventid",
	                "iyear","imonth", "iday", "approxdate",
	                "extended",
	                "resolution",
	                "country", "country_txt",
	                "region", "region_txt", "provstate",
	                "city",
	                "latitude","longitude",
	                "specificity","vicinity","location",
	                "summary",
	                "crit1", "crit2", "crit3",
	                "doubtterr","alternative", "alternative_txt",
	                "multiple",
	                "success",
	                "suicide",
	                "attacktype1", "attacktype1_txt", "attacktype2", "attacktype2_txt", "attacktype3", "attacktype3_txt",
	                "targtype1", "targtype1_txt", "targsubtype1", "targsubtype1_txt", "corp1", "target1", "natlty1", "natlty1_txt",
	                "targtype2", "targtype2_txt", "targsubtype2", "targsubtype2_txt", "corp2", "target2", "natlty2", "natlty2_txt",
	                "targtype3", "targtype3_txt", "targsubtype3", "targsubtype3_txt", "corp3", "target3", "natlty3", "natlty3_txt",
	                "gname", "gsubname", "gname2", "gsubname2", "gname3", "gsubname3",
	                "motive", "guncertain1", "guncertain2", "guncertain3",
	                "individual", "nperps", "nperpcap",
	                "claimed","claimmode", "claimmode_txt", "claim2", "claimmode2", "claimmode2_txt", "claim3",  "claimmode3", "claimmode3_txt",
	                "compclaim",
	                "weaptype1", "weaptype1_txt", "weapsubtype1", "weapsubtype1_txt",
	                "weaptype2", "weaptype2_txt", "weapsubtype2", "weapsubtype2_txt",
	                "weaptype3", "weaptype3_txt", "weapsubtype3", "weapsubtype3_txt",
	                "weaptype4", "weaptype4_txt", "weapsubtype4", "weapsubtype4_txt",
	                "weapdetail",
	                "nkill", "nkillus", "nkillter", "nwound", "nwoundus", "nwoundte",
	                "property", "propextent", "propextent_txt", "propvalue", "propcomment",
	                "ishostkid", "nhostkid", "nhostkidus",
	                "nhours", "ndays",
	                "divert",
	                "kidhijcountry",
	                "ransom", "ransomamt", "ransomamtus", "ransompaid", "ransompaidus", "ransomnote",
	                "hostkidoutcome", "hostkidoutcome_txt", "nreleased",
	                "addnotes",
	                "scite1", "scite2", "scite3",
	                "dbsource",
	                "int_log", "int_ideo", "int_misc", "int_any", "related"
	                )
	        .fieldSetMapper(new BeanWrapperFieldSetMapper<GlobalTerrorism>()
	            {{
	              setTargetType(GlobalTerrorism.class);
	            }}).linesToSkip(1) // Skip the row header
	        .build())
        .build();
    }

    @Bean
    Job importGlobalTerrorismDataJob(final @NotNull JobRepository repository,
    		final @NotNull Step step,
    		final @NotNull JobCompletionNotificationListener jobCompletionNotificationListener)
    {
      return new JobBuilder("importGlobalTerrorismDataJob", repository)
        .listener(jobCompletionNotificationListener)
        .start(step)
        .build();
    }

    @Bean
    Step step(final @NotNull JobRepository repository,
    		final @NotNull ItemReader<GlobalTerrorism> reader,
    		final @NotNull ItemWriter<GlobalTerrorism> writer,
    		final @NotNull PlatformTransactionManager transactionManager,
    		final @NotNull @Value("${my.batch.chunk-size}") int chunkSize)
    {
      return new StepBuilder("step1", repository)
    		  .<GlobalTerrorism, GlobalTerrorism>chunk(chunkSize, transactionManager)
    		  .reader(reader)
    		  .processor( itemProcessor())
    		  .writer( writer)
    		  .build();
    }

    @Bean
    JobRepository repository(final @NotNull DataSource dataSource,
    					final @NotNull PlatformTransactionManager transactionManager) throws Exception
    {
        final JobRepositoryFactoryBean jobFactory = new JobRepositoryFactoryBean();

        jobFactory.setDataSource(dataSource);
        jobFactory.setTransactionManager(transactionManager);
        jobFactory.setIsolationLevelForCreate("ISOLATION_SERIALIZABLE");
        jobFactory.setTablePrefix("BATCH_");
        jobFactory.setMaxVarCharLength(50000); // Until I am sure of actual need.
        jobFactory.afterPropertiesSet();
        return jobFactory.getObject();
    }

    @Bean
    ItemProcessor<GlobalTerrorism, GlobalTerrorism> itemProcessor()
    {
    	return new GlobalTerrorismItemProcessor();
    }
}
