import { React, useEffect, useState } from "react";
import { LatestMatchDetail } from "../components/LatestMatchDetail";
import { MatchDetail } from "../components/BriefMatchDetail";
import { Link, useParams } from "react-router-dom";
import { PieChart } from "react-minimal-pie-chart";
import { FaHome } from "react-icons/fa";
import "../css/TeamPage.css";

export const TeamPage = () => {
  console.log("Team Page called");

  const { teamName } = useParams();
  const [team, setTeam] = useState({ matches: [{}] });
  const [isLoading, setLoading] = useState(true);
  const [isError, setError] = useState(false);

  const winPercentage = (
    (team.totalWins * 100) /
    (team.totalMatches - team.noResult)
  ).toFixed(2);

  useEffect(() => {
    const url = `${process.env.REACT_APP_URL}/team/${teamName}`;

    console.log("URL:" + url);

    const fetchTeamByTeamName = async () => {
      try {
        const response = await fetch(url);
        const teamFromBE = await response.json();
        setLoading(false);
        setTeam(teamFromBE);
      } catch (error) {
        setLoading(false);
        setError(true);
      }
    };

    fetchTeamByTeamName();
  }, [teamName]);

  if (isLoading) return <h1>Fetching Team...</h1>;

  if (isError) return <h1>Team provided does not exist</h1>;

  return (
    <div className="TeamPage">
      <div className="TeamName">
        <h1>{team.teamName}</h1>
      </div>
      <div className="btn-position">
        <Link to={`/`}>
          <FaHome size="2rem" />
        </Link>
      </div>
      <div className="WinLoss">
        <PieChart
          data={[
            {
              title: `Win% = ${winPercentage}`,
              value: team.totalWins,
              color: "#08bd63",
            },
            {
              title: `Lost% = ${100 - winPercentage}`,
              value: team.totalMatches - team.totalWins - team.noResult,
              color: "#6A2135",
            },
          ]}
        />
        <h2>Win/Loss%</h2>
      </div>
      <div className="LatestMatch">
        <h2 className="header">Latest Match</h2>
        <LatestMatchDetail match={team.matches[0]} teamName={team.teamName} />
      </div>
      {team.matches.slice(1).map((match) => {
        return (
          <div key={match.matchId} className="MatchDetail">
            <MatchDetail match={match} teamName={team.teamName} />
          </div>
        );
      })}
      <Link to={`/team/${team.teamName}/matches/${team.matches[0].year}`}>
        <p style={{ marginTop: "50px" }}>see more</p>
      </Link>
    </div>
  );
};
