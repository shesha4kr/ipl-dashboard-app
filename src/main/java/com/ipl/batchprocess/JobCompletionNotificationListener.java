package com.ipl.batchprocess;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.BatchStatus;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.listener.JobExecutionListenerSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ipl.entity.Team;

@Component
public class JobCompletionNotificationListener extends JobExecutionListenerSupport {

	private static final Logger log = LoggerFactory.getLogger(JobCompletionNotificationListener.class);

	private final EntityManager em;

	@Autowired
	public JobCompletionNotificationListener(EntityManager em) {
		this.em = em;
	}

	@Override
	@Transactional
	public void afterJob(JobExecution jobExecution) {
		if (jobExecution.getStatus() == BatchStatus.COMPLETED) {

			log.info("All Records saved in Match table");

			Map<String, Team> teams = new HashMap<>();

			getTotalMatchesOfFirstInnTeam(teams);
			getTotalMatchesOfSecInnTeam(teams);
			setTotalWins(teams);
			setNoResult(teams);
			insertInTeamTable(teams);
			
			log.info("All Records saved in Team table");
		}
	}

	private void getTotalMatchesOfFirstInnTeam(Map<String, Team> teams) {
		em.createQuery("SELECT m.firstInnTeam, count(*) from Match m GROUP BY firstInnTeam", Object[].class)
				.getResultList().stream()
				.map(arrayOfField -> new Team((String) arrayOfField[0], (Long) arrayOfField[1], 0))
				.forEach(team -> teams.put(team.getTeamName(), team));
	}

	private void getTotalMatchesOfSecInnTeam(Map<String, Team> teams) {
		em.createQuery("SELECT m.secondInnTeam, count(*) from Match m GROUP BY secondInnTeam", Object[].class)
				.getResultList().stream().forEach(arrayOfField -> {
					Team team = teams.get(arrayOfField[0]);
					team.setTotalMatches(team.getTotalMatches() + (Long) arrayOfField[1]);
				});
	}

	private void setTotalWins(Map<String, Team> teams) {
		List<Object[]> result = em
				.createQuery("SELECT m.matchWinner, count(*) from Match m GROUP BY matchWinner", Object[].class)
				.getResultList();

		for (Object[] row : result) {
			if (!"NA".equals(row[0])) {
				Team team = teams.get(row[0]);
				team.setTotalWins((Long) row[1]);
			}
		}
	}

	private void setNoResult(Map<String, Team> teams) {
		List<Object[]> result = em
				.createQuery("SELECT m.firstInnTeam, m.secondInnTeam from Match m WHERE m.matchWinner = 'NA'",
						Object[].class)
				.getResultList();

		em.createQuery("SELECT m.firstInnTeam, m.secondInnTeam from Match m WHERE m.matchWinner = 'NA'", Object[].class)
				.getResultList().stream().forEach(arrayOfField -> {
					Team team1 = teams.get(arrayOfField[0]);
					team1.setNoResult(team1.getNoResult() + 1);

					Team team2 = teams.get(arrayOfField[1]);
					team2.setNoResult(team2.getNoResult() + 1);
				});
	}

	private void insertInTeamTable(Map<String, Team> teams) {
		teams.values().forEach(team -> em.persist(team));
	}
}
