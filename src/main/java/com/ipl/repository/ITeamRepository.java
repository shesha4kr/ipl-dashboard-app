package com.ipl.repository;

import org.springframework.data.repository.CrudRepository;

import com.ipl.entity.Team;

public interface ITeamRepository extends CrudRepository<Team, Long> {
	
	Team findByTeamName(String teamName);

}
