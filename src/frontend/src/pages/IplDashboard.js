import { React, useState } from "react";
import { Link } from "react-router-dom";
import { TeamTile } from "../components/TeamTile";
import { iplData } from "../data/AllData";
import "../css/IplDashboard.css";

export const IplDashboard = () => {
  const [allTeamNames] = useState(iplData);
  console.log("IplDashboard called");

  return (
    <div>
      <h1 className="heading">Welcome to IPL Dashboard</h1>
      <div className="dashboard">
        {allTeamNames.map((team) => {
          return (
            <div key={team.id}>
              <Link to={`team/${team.name}`}>
                <TeamTile logo={team.logo} teamName={team.name} />
              </Link>
            </div>
          );
        })}
      </div>
    </div>
  );
};
