package com.ipl.batchprocess;

import javax.sql.DataSource;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.database.BeanPropertyItemSqlParameterSourceProvider;
import org.springframework.batch.item.database.JdbcBatchItemWriter;
import org.springframework.batch.item.database.builder.JdbcBatchItemWriterBuilder;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.builder.FlatFileItemReaderBuilder;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;

import com.ipl.data.MatchData;
import com.ipl.entity.Match;

@Configuration
@EnableBatchProcessing
public class BatchConfig {

	private final String[] FIELDS = { "matchId", "city", "date", "manOfMatch", "venue", "isNeutralVenue",
			"firstInnTeam", "secondInnTeam", "tossWinner", "tossDecision", "matchWinner", "result", "resultMargin",
			"eliminator", "method", "umpire1", "umpire2" };

	@Autowired
	public JobBuilderFactory jobBuilderFactory;

	@Autowired
	public StepBuilderFactory stepBuilderFactory;

	@Bean
	public FlatFileItemReader<MatchData> reader() {
		return new FlatFileItemReaderBuilder<MatchData>().name("matchItemReader")
				.resource(new ClassPathResource("IPL_Matches_2008-2020.csv")).delimited().names(FIELDS)
				.fieldSetMapper(new BeanWrapperFieldSetMapper<MatchData>() {
					{
						setTargetType(MatchData.class);
					}
				}).linesToSkip(1).build();
	}

	@Bean
	public MatchDataProcessor processor() {
		return new MatchDataProcessor();
	}

	@Bean
	public JdbcBatchItemWriter<Match> writer(DataSource dataSource) {
		return new JdbcBatchItemWriterBuilder<Match>()
				.itemSqlParameterSourceProvider(new BeanPropertyItemSqlParameterSourceProvider<>())
				.sql("INSERT INTO match (match_id,city,date,year,man_of_match,venue,is_neutral_venue,first_inn_team,second_inn_team,"
						+ "toss_winner,toss_decision,match_winner,result,result_margin,eliminator,method,umpire1,umpire2) "
						+ "VALUES (:matchId,:city,:date,:year,:manOfMatch,:venue,:isNeutralVenue,:firstInnTeam,:secondInnTeam,"
						+ ":tossWinner,:tossDecision,:matchWinner,:result,:resultMargin,:eliminator,:method,:umpire1,:umpire2)")
				.dataSource(dataSource).build();
	}
	
	@Bean
	public Job importUserJob(JobCompletionNotificationListener listener, Step step1) {
	  return jobBuilderFactory.get("importUserJob")
	    .incrementer(new RunIdIncrementer())
	    .listener(listener)
	    .flow(step1)
	    .end()
	    .build();
	}

	@Bean
	public Step step1(JdbcBatchItemWriter<Match> writer) {
	  return stepBuilderFactory.get("step1")
	    .<MatchData, Match> chunk(10)
	    .reader(reader())
	    .processor(processor())
	    .writer(writer)
	    .build();
	}
}
