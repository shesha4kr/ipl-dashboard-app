package com.ipl.data;

import java.util.List;

import com.ipl.entity.Match;

public class MatchPageForUI {

	private List<Integer> years;
	private List<String> oppositionTeams;
	private List<Match> matches;

	public MatchPageForUI() {
		super();
	}

	public MatchPageForUI(List<Integer> years, List<String> oppositionTeams, List<Match> matches) {
		super();
		this.years = years;
		this.oppositionTeams = oppositionTeams;
		this.matches = matches;
	}

	public List<Integer> getYears() {
		return years;
	}

	public void setYears(List<Integer> years) {
		this.years = years;
	}

	public List<String> getOppositionTeams() {
		return oppositionTeams;
	}

	public void setOppositionTeams(List<String> oppositionTeams) {
		this.oppositionTeams = oppositionTeams;
	}

	public List<Match> getMatches() {
		return matches;
	}

	public void setMatches(List<Match> matches) {
		this.matches = matches;
	}

}
