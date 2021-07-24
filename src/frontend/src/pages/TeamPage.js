import { React, useEffect, useState } from "react";
import { LatestMatchDetail } from "../components/LatestMatchDetail";
import { MatchDetail } from "../components/MatchDetail";
import { Link, useParams } from "react-router-dom";
import "../css/TeamPage.css";

export const TeamPage = () => {
  console.log("Team Page called");

  const { teamName } = useParams();
  const [team, setTeam] = useState({ matches: [{}] });
  const [isLoading, setLoading] = useState(true);
  const [isError, setError] = useState(false);

  useEffect(() => {
    fetchTeamByTeamName();
  }, [teamName]);

  const url = `http://localhost:8080/team/${teamName}`;

  const fetchTeamByTeamName = async () => {
    try {
      console.log("Inside Try");
      const response = await fetch(url);
      const teamFromBE = await response.json();
      setLoading(false);
      setTeam(teamFromBE);
      console.log("Outside Try");
    } catch (error) {
      console.log("Inside Catch");
      setLoading(false);
      setError(true);
    }
  };

  if (isLoading) return <h1>Fetching Team...</h1>;

  if (isError) return <h1>Team provided does not exist</h1>;

  return (
    <div className="TeamPage">
      <div className="TeamName">
        <h1>{team.teamName}</h1>
      </div>

      <div className="WinLoss">
        <h1>Win/Total</h1>
      </div>

      <div className="LatestMatch">
        <LatestMatchDetail match={team.matches[0]} teamName={team.teamName} />
      </div>

      {team.matches.slice(1).map((match, index) => {
        return (
          <div key={index} className="MatchDetail">
            <MatchDetail match={match} teamName={team.teamName} />
          </div>
        );
      })}

      <Link to={`/team/${team.teamName}/matches/2020`}>
        <p>see more</p>
      </Link>
    </div>
  );
};
