package com.star_cases.csv.batch;

import javax.sql.DataSource;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.BatchConfigurer;
import org.springframework.batch.core.configuration.annotation.DefaultBatchConfigurer;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.repository.support.JobRepositoryFactoryBean;
import org.springframework.batch.item.database.BeanPropertyItemSqlParameterSourceProvider;
import org.springframework.batch.item.database.JdbcBatchItemWriter;
import org.springframework.batch.item.database.builder.JdbcBatchItemWriterBuilder;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.builder.FlatFileItemReaderBuilder;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.FileSystemResource;
import org.springframework.transaction.PlatformTransactionManager;

@Configuration
@EnableBatchProcessing
public class BatchConfiguration
{
    @Autowired
    public DataSource dataSource;

    @Autowired
    public PlatformTransactionManager transactionManager;

    @Bean
    public GlobalTerrorismItemProcessor processor()
    {
      return new GlobalTerrorismItemProcessor();
    }

    @Bean
    public JdbcBatchItemWriter<GlobalTerrorism> writer(DataSource dataSource)
    {
      return new JdbcBatchItemWriterBuilder<GlobalTerrorism>()
        .itemSqlParameterSourceProvider(new BeanPropertyItemSqlParameterSourceProvider<>())
        .sql("INSERT INTO public.globalterrorism\n"
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
    public FlatFileItemReader<GlobalTerrorism> reader()
    {
      return new FlatFileItemReaderBuilder<GlobalTerrorism>()
        .name("GlobalTerrorismItemReader")
        .resource(new FileSystemResource("/datasets/world/globalterrorismdb_0718dist.csv"))
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
        .build();
    }

    @Bean
    public Job importGlobalTerrorismDataJob(JobBuilderFactory jobBuilderFactory, JobCompletionNotificationListener listener, Step step1)
    {
      return jobBuilderFactory.get("importGlobalTerrorismDataJob")
        .incrementer(new RunIdIncrementer())
        .listener(listener)
        .flow(step1)
        .end()
        .build();
    }

    @Bean
    public Step step1(StepBuilderFactory stepBuilderFactory, JdbcBatchItemWriter<GlobalTerrorism> writer)
    {
      return stepBuilderFactory.get("step1")
        .<GlobalTerrorism, GlobalTerrorism> chunk(20000)
        .reader(reader())
        .processor(processor())
        .writer(writer)
        .build();
    }

    public BatchConfigurer batchConfigurer()
    {
        return new DefaultBatchConfigurer()
        {
            @Override
            protected JobRepository createJobRepository() throws Exception
            {
                JobRepositoryFactoryBean factory = new JobRepositoryFactoryBean();
                factory.setDataSource(dataSource);
                factory.setTransactionManager(transactionManager);
                factory.setIsolationLevelForCreate("ISOLATION_SERIALIZABLE");
                factory.setTablePrefix("BATCH_");
                factory.setMaxVarCharLength(50000); // Until I am sure of actual need.
                return factory.getObject();
            }
        };
    }
}
