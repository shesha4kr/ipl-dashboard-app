package com.ipl.controller;

import com.ipl.entity.Match;
import com.ipl.entity.Team;
import com.ipl.repository.IMatchRepository;
import com.ipl.repository.ITeamRepository;
import java.time.LocalDate;
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
		if(team == null) {
			return team;
		}
		System.out.println("TEAM:"+team);
		Pageable page = PageRequest.of(0, 4);
		team.setMatches(matchRepo.findByFirstInnTeamOrSecondInnTeamOrderByDateDesc(teamName, teamName, page));
		return team;
	}

	@RequestMapping(method = RequestMethod.GET, value = "/team/{teamName}/matches")
	public List<Match> getMatchesForATeamByYear(@PathVariable String teamName, @RequestParam int year) {
		LocalDate startDate = LocalDate.of(year, 1, 1);
		LocalDate endDate = LocalDate.of(year + 1, 1, 1);
		return matchRepo.getMatchesForATeamByYear2(teamName, teamName, startDate, endDate);
	}

}
