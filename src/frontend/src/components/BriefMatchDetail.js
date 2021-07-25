import React from "react";
import { Link } from "react-router-dom";
import "./../css/MatchDetail.css";

export const MatchDetail = ({ match, teamName }) => {
  if (!match) return null;

  const otherTeam =
    match.firstInnTeam === teamName ? match.secondInnTeam : match.firstInnTeam;

  const thisTeamWon = teamName === match.matchWinner ? true : false;

  const isMatchOutcome = match.matchWinner === "NA" ? false : true;
  const dLMethod = match.method === "Normal" ? "" : "by D/L Method";
  let matchResult = "";
  if (isMatchOutcome) {
    matchResult = `${match.matchWinner} won by ${match.resultMargin} ${match.result} ${dLMethod}`;
  } else {
    matchResult = `Match abandoned due to rain`;
  }

  return (
    <div className={isMatchOutcome ? (thisTeamWon ? "match-winner" : "match-looser") : "match-abandoned" }>
      <h4 className="normal">vs</h4>

      <Link to={`/team/${otherTeam}`}>
        <h2 className="normal">{`${otherTeam}`}</h2>
      </Link>

      <div>
        <div className="leftPanel">
          <div className="each-detail">
            <h4>Date</h4>
            <h5>{match.date}</h5>
          </div>
        </div>
      </div>

      <h4 className="normal">{matchResult}</h4>
    </div>
  );
};
