import React from "react";
import { Link } from "react-router-dom";

export const LatestMatchDetail = ({ match, teamName }) => {
  if (!match) return null;

  const otherTeam =
    match.firstInnTeam === teamName ? match.secondInnTeam : match.firstInnTeam;

  return (
    <div className="LatestMatchDetail">
      <h1>vs</h1>

      <Link to={`/team/${otherTeam}`}>
        <h1>{`${otherTeam}`}</h1>
      </Link>

      <h5>{`${match.tossWinner} elected  to ${match.tossDecision}`}</h5>

      <h5>{`${match.matchWinner} won by ${match.resultMargin} ${match.result}`}</h5>

      <p>{`Man of the Match: ${match.manOfMatch} (${match.matchWinner})`}</p>
      <p>{`Venue: ${match.venue} (${match.city})`}</p>
      <p>{`Played On: ${match.date}`}</p>
    </div>
  );
};
