package com.ipl.batchprocess;

import java.time.LocalDate;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemProcessor;

import com.ipl.data.MatchData;
import com.ipl.entity.Match;

public class MatchDataProcessor implements ItemProcessor<MatchData, Match> {

	private static final Logger log = LoggerFactory.getLogger(MatchDataProcessor.class);

	@Override
	public Match process(final MatchData matchData) throws Exception {

		try {
			final Long matchId = Long.parseLong(matchData.getMatchId());
			log.info("MATCH ID:"+matchId);
			final String city = matchData.getCity();
			final LocalDate date = LocalDate.parse(matchData.getDate());
			final Integer year = getYearFromDate(matchData.getDate());
			final String manOfMatch = matchData.getManOfMatch();
			final String venue = matchData.getVenue();
			final Boolean isNeutralVenue = transformIsNuetralVenue(matchData.getIsNeutralVenue());
			final String tossWinner = matchData.getTossWinner();
			final String tossDecision = matchData.getTossDecision();
			final String matchWinner = matchData.getmatchWinner();
			final Integer resultMargin = matchData.getResultMargin().equals("NA") ? null
					: Integer.valueOf(matchData.getResultMargin());
			final String result = matchData.getResult().equals("NA") ? null : matchData.getResult();
			final String isEliminator = matchData.getEliminator();
			final String method = matchData.getMethod().equals("NA") ? "Normal" : matchData.getMethod();
			final String umpire1 = matchData.getUmpire1();
			final String umpire2 = matchData.getUmpire2();

			final Match match = new Match(matchId, city, date, year, manOfMatch, venue, isNeutralVenue, tossWinner,
					tossDecision, matchWinner, result, resultMargin, isEliminator, method, umpire1, umpire2);

			setFirstAndSecondInnTeams(matchData.getFirstInnTeam(), matchData.getSecondInnTeam(), tossWinner,
					tossDecision, match);

			return match;

		} catch (Exception e) {
			log.error("Exception in MatchDataProcessor class", e);
			throw new Exception("Exception in MatchDataProcessor class", e);
		}

	}

	public Boolean transformIsNuetralVenue(String isNeutralVenue) {

		if (isNeutralVenue.equals("0")) {
			return Boolean.FALSE;
		} else if (isNeutralVenue.equals("1")) {
			return Boolean.TRUE;
		}
		return null;
	}

	public void setFirstAndSecondInnTeams(String team1, String team2, String tossWinner, String tossDecision,
			Match match) {
		if (tossDecision.equals("bat")) {
			match.setFirstInnTeam(tossWinner);
			match.setSecondInnTeam(team1.equals(tossWinner) ? team2 : team1);
		} else if (tossDecision.equals("field")) {
			match.setSecondInnTeam(tossWinner);
			match.setFirstInnTeam(team1.equals(tossWinner) ? team2 : team1);
		}
	}
	
	public Integer getYearFromDate (String date) {
		return Integer.valueOf(date.substring(0,4));
	}
}
