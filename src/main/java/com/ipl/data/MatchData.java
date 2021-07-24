package com.ipl.data;

public class MatchData {

	private String matchId;
	private String city;
	private String date;
	private String manOfMatch;
	private String venue;
	private String isNeutralVenue;
	private String firstInnTeam;
	private String secondInnTeam;
	private String tossWinner;
	private String tossDecision;
	private String matchWinner;
	private String result;
	private String resultMargin;
	private String eliminator;
	private String method;
	private String umpire1;
	private String umpire2;

	public String getMatchId() {
		return matchId;
	}

	public void setMatchId(String matchId) {
		this.matchId = matchId;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
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

	public String getIsNeutralVenue() {
		return isNeutralVenue;
	}

	public void setIsNeutralVenue(String isNeutralVenue) {
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

	public String getmatchWinner() {
		return matchWinner;
	}

	public void setmatchWinner(String matchWinner) {
		this.matchWinner = matchWinner;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public String getResultMargin() {
		return resultMargin;
	}

	public void setResultMargin(String resultMargin) {
		this.resultMargin = resultMargin;
	}

	public String getEliminator() {
		return eliminator;
	}

	public void setEliminator(String elimininator) {
		this.eliminator = elimininator;
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
		return "MatchInput [matchId=" + matchId + ", city=" + city + ", date=" + date + ", manOfMatch=" + manOfMatch
				+ ", venue=" + venue + ", isNeutralVenue=" + isNeutralVenue + ", team1=" + firstInnTeam + ", team2=" + secondInnTeam
				+ ", tossWinner=" + tossWinner + ", tossDecision=" + tossDecision + ", matchWinner=" + matchWinner
				+ ", result=" + result + ", resultMargin=" + resultMargin + ", elimininator=" + eliminator
				+ ", method=" + method + ", umpire1=" + umpire1 + ", umpire2=" + umpire2 + "]";
	}

}
