package com.ipl.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;

@Entity
public class Team {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long teamId;
	private String teamName;
	private long totalMatches;
	private long totalWins;
	private long noResult;	
	
	@Transient
	private List<Match> matches;
	
	public Team() {
		super();
	}
	
	public Team(String teamName, long totalMatches, long noResult) {
		super();
		this.teamName = teamName;
		this.totalMatches = totalMatches;
		this.noResult = noResult;
	}
	
	
	
	public List<Match> getMatches() {
		return matches;
	}

	public void setMatches(List<Match> matches) {
		this.matches = matches;
	}

	public long getTeamId() {
		return teamId;
	}
	public void setTeamId(long teamId) {
		this.teamId = teamId;
	}
	public String getTeamName() {
		return teamName;
	}
	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}
	public long getTotalMatches() {
		return totalMatches;
	}
	public void setTotalMatches(long totalMatches) {
		this.totalMatches = totalMatches;
	}
	public long getTotalWins() {
		return totalWins;
	}
	public void setTotalWins(long totalWins) {
		this.totalWins = totalWins;
	}
	public long getNoResult() {
		return noResult;
	}
	public void setNoResult(long noResult) {
		this.noResult = noResult;
	}
	@Override
	public String toString() {
		return "Team [teamId=" + teamId + ", teamName=" + teamName + ", totalMatches=" + totalMatches + ", totalWins="
				+ totalWins + ", noResult=" + noResult + "]";
	}
	
	
	
}
