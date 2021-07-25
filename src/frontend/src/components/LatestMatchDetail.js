import React from "react";
import { useState, useEffect } from "react";
import { Link } from "react-router-dom";
import "./../css/LatestMatchDetail.css";

export const LatestMatchDetail = ({ match, teamName }) => {
  if (!match) return null;

  const otherTeam =
    match.firstInnTeam === teamName ? match.secondInnTeam : match.firstInnTeam;

  const thisTeamWon = teamName === match.matchWinner ? true : false;

  const isMatchOutcome = match.matchWinner === "NA" ? false : true;
  const dLMethod = match.method === "Normal" ? "" : "by D/L Method";

  if (isMatchOutcome) {
    var matchResult = `${match.matchWinner} won by ${match.resultMargin} ${match.result} ${dLMethod}`;
  } else {
    matchResult = `Match abandoned due to rain`;
  }

  return (
    <div className= { isMatchOutcome ? thisTeamWon ? "match-winner" : "match-looser" : "match-abandoned" } >
      <div className="latest-match-header">
        <h1>vs</h1>
        <div className="other-team-header">
          <Link to={`/team/${otherTeam}`}>
            <h1>{`${otherTeam}`}</h1>
          </Link>
        </div>
      </div>

      <div className="match-result">
        <h1>{matchResult}</h1>
      </div>

      <div className="match-details-container">
        <div className="leftPanel">
          <div className="each-detail">
            <h3>Date</h3>
            <h5>{match.date}</h5>
          </div>

          <div className="each-detail">
            <h3>Venue</h3>
            <h5>{`${match.venue}, ${match.city}`}</h5>
          </div>

          <div className="each-detail">
            <h3>Player of the Match</h3>
            <h5>
              {isMatchOutcome
                ? `${match.manOfMatch} (${match.matchWinner})`
                : "-"}
            </h5>
          </div>
        </div>

        <div className="rightPanel">
          <div className="each-detail">
            <h3>Toss</h3>
            <h5>{match.firstInnTeam}</h5>
          </div>

          <div className="each-detail">
            <h3>First Innings</h3>
            <h5>{match.tossWinner}</h5>
          </div>

          <div className="each-detail">
            <h3>Second Innings</h3>
            <h5>{match.secondInnTeam}</h5>
          </div>

          <div className="each-detail">
            <h3>Umpires</h3>
            <h5>{`${match.umpire1}, ${match.umpire2}`}</h5>
          </div>
        </div>
      </div>
    </div>
  );
};
