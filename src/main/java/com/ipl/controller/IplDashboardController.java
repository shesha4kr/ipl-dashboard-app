package com.ipl.controller;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ipl.data.MatchPageForUI;
import com.ipl.entity.Team;
import com.ipl.repository.IMatchRepository;
import com.ipl.repository.ITeamRepository;

@RestController
@CrossOrigin
public class IplDashboardController {

	@Autowired
	ITeamRepository teamRepo;

	@Autowired
	IMatchRepository matchRepo;

	@GetMapping("/team/{teamName}")
	public Team getTeamsByTeamName(@PathVariable String teamName) {
		Team team = teamRepo.findByTeamName(teamName);
		if (team == null) {
			return team;
		}
		System.out.println("TEAM:" + team);
		Pageable page = PageRequest.of(0, 4);
		team.setMatches(matchRepo.findByFirstInnTeamOrSecondInnTeamOrderByDateDesc(teamName, teamName, page));
		return team;
	}

	@RequestMapping(method = RequestMethod.GET, value = "/team/{teamName}/matches")
	public MatchPageForUI getMatchesForATeamByYear(@PathVariable String teamName, @RequestParam int year) {
		LocalDate startDate = LocalDate.of(year, 1, 1);
		LocalDate endDate = LocalDate.of(year + 1, 1, 1);
		MatchPageForUI matchPage = new MatchPageForUI();
		matchPage.setYears(matchRepo.getActiveYearsForATeam(teamName, teamName));
		System.out.println("YEARS:" + matchPage.getYears());

		List<String> oppositions = new ArrayList<>();
		oppositions.addAll(matchRepo.getAllOppositionTeamsFromFirstInnTeamColumn(teamName));

		List<String> oppositionsListFromSecInnTeamColumn = matchRepo
				.getAllOppositionTeamsFromSecondInnTeamColumn(teamName);

		for (String team : oppositionsListFromSecInnTeamColumn) {
			if (!oppositions.contains(team)) {
				oppositions.add(team);
			}
		}

		matchPage.setOppositionTeams(oppositions);
		matchPage.setMatches(matchRepo.getMatchesForATeamByYear2(teamName, teamName, startDate, endDate));

		return matchPage;
	}

}
