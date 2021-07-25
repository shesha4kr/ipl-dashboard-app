package com.ipl.entity;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Match {

	@Id
	private long matchId;
	private String city;
	private LocalDate date;
	private Integer year;
	private String manOfMatch;
	private String venue;
	private Boolean isNeutralVenue;
	private String firstInnTeam;
	private String secondInnTeam;
	private String tossWinner;
	private String tossDecision;
	private String matchWinner;
	private String result;
	private Integer resultMargin;
	private String eliminator;
	private String method;
	private String umpire1;
	private String umpire2;

	public Match() {
		super();
	}

	public Match(long matchId, String city, LocalDate date, Integer year, String manOfMatch, String venue, Boolean isNeutralVenue,
			String tossWinner, String tossDecision, String matchWinner, String result, Integer resultMargin,
			String eliminator, String method, String umpire1, String umpire2) {
		super();
		this.matchId = matchId;
		this.city = city;
		this.date = date;
		this.year = year;
		this.manOfMatch = manOfMatch;
		this.venue = venue;
		this.isNeutralVenue = isNeutralVenue;
		this.tossWinner = tossWinner;
		this.tossDecision = tossDecision;
		this.matchWinner = matchWinner;
		this.result = result;
		this.resultMargin = resultMargin;
		this.eliminator = eliminator;
		this.method = method;
		this.umpire1 = umpire1;
		this.umpire2 = umpire2;
	}

	public Integer getYear() {
		return year;
	}

	public void setYear(Integer year) {
		this.year = year;
	}

	public long getMatchId() {
		return matchId;
	}

	public void setMatchId(long matchId) {
		this.matchId = matchId;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public String getManOfMatch() {
		return manOfMatch;
	}

	public void setManOfMatch(String manOfMatch) {
		this.manOfMatch = manOfMatch;
	}

	public String getVenue() {
		return venue;
	}

	public void setVenue(String venue) {
		this.venue = venue;
	}

	public Boolean getIsNeutralVenue() {
		return isNeutralVenue;
	}

	public void setIsNeutralVenue(Boolean isNeutralVenue) {
		this.isNeutralVenue = isNeutralVenue;
	}

	public String getFirstInnTeam() {
		return firstInnTeam;
	}

	public void setFirstInnTeam(String firstInnTeam) {
		this.firstInnTeam = firstInnTeam;
	}

	public String getSecondInnTeam() {
		return secondInnTeam;
	}

	public void setSecondInnTeam(String secondInnTeam) {
		this.secondInnTeam = secondInnTeam;
	}

	public String getTossWinner() {
		return tossWinner;
	}

	public void setTossWinner(String tossWinner) {
		this.tossWinner = tossWinner;
	}

	public String getTossDecision() {
		return tossDecision;
	}

	public void setTossDecision(String tossDecision) {
		this.tossDecision = tossDecision;
	}

	public String getMatchWinner() {
		return matchWinner;
	}

	public void setMatchWinner(String matchWinner) {
		this.matchWinner = matchWinner;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public Integer getResultMargin() {
		return resultMargin;
	}

	public void setResultMargin(Integer resultMargin) {
		this.resultMargin = resultMargin;
	}

	public String getEliminator() {
		return eliminator;
	}

	public void setEliminator(String eliminator) {
		this.eliminator = eliminator;
	}

	public String getMethod() {
		return method;
	}

	public void setMethod(String method) {
		this.method = method;
	}

	public String getUmpire1() {
		return umpire1;
	}

	public void setUmpire1(String umpire1) {
		this.umpire1 = umpire1;
	}

	public String getUmpire2() {
		return umpire2;
	}

	public void setUmpire2(String umpire2) {
		this.umpire2 = umpire2;
	}

	@Override
	public String toString() {
		return "Match [matchId=" + matchId + ", city=" + city + ", date=" + date + ", manOfMatch=" + manOfMatch
				+ ", venue=" + venue + ", isNeutralVenue=" + isNeutralVenue + ", team1=" + firstInnTeam + ", team2=" + secondInnTeam
				+ ", tossWinner=" + tossWinner + ", tossDecision=" + tossDecision + ", matchWinner=" + matchWinner
				+ ", result=" + result + ", resultMargin=" + resultMargin + ", eliminator=" + eliminator
				+ ", method=" + method + ", umpire1=" + umpire1 + ", umpire2=" + umpire2 + "]";
	}

}
