import React from "react";
import { Link } from "react-router-dom";

export const MatchDetail = ({ match, teamName }) => {
  if (!match) return null;

  const otherTeam =
    match.firstInnTeam === teamName ? match.secondInnTeam : match.firstInnTeam;

  return (
    <div className="MatchDetail">
      <h4>vs</h4>

      <Link to={`/team/${otherTeam}`}>
        <h5>{`${otherTeam}`}</h5>
      </Link>

      <p>{`${match.matchWinner} won by ${match.resultMargin} ${match.result}`}</p>
    </div>
  );
};
