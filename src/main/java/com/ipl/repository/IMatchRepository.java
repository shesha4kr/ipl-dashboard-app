package com.ipl.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.ipl.entity.Match;

public interface IMatchRepository extends CrudRepository<Match, Long> {

	/*
	 * select * from match where firstInnTeam = ? OR secondInnTeam = ? ORDER BY DATE
	 * DESC Magic Method
	 */
	List<Match> findByFirstInnTeamOrSecondInnTeamOrderByDateDesc(String firstInnTeam, String secondInnTeam,
			Pageable page);

	// Using Positional Input Parameter
	// @Query("SELECT m from Match m WHERE m.firstInnTeam=? OR m.secondInnTeam=? AND
	// m.date BETWEEN ? AND ?")
	// List<Match> getMatchesForATeamByYear1(String firstInnTeam, String
	// secondInnTeam, LocalDate startDate,
	// LocalDate endDate);

	// SAME QUERY USING NAMED INPUT PARAMETER
	@Query("SELECT m from Match m WHERE (m.firstInnTeam=:firstInnTeam OR m.secondInnTeam=:secondInnTeam) AND m.date BETWEEN :startDate AND :endDate ORDER BY m.date DESC")
	List<Match> getMatchesForATeamByYear2(@Param("firstInnTeam") String firstInnTeam,
			@Param("secondInnTeam") String secondInnTeam, @Param("startDate") LocalDate startDate,
			@Param("endDate") LocalDate endDate);

}
