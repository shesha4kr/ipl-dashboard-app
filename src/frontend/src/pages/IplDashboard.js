import { React, useState } from "react";
import { Link } from "react-router-dom";
import { TeamTile } from "../components/TeamTile";
import "../css/IplDashboard.css";
import chennaiLogo from "./../logo-of-ipl-teams/chennai.jpeg";
import delhiLogo from "./../logo-of-ipl-teams/delhi.jpeg";
import punjabLogo from "./../logo-of-ipl-teams/punjab.jpeg";
import kolkataLogo from "./../logo-of-ipl-teams/kolkata.jpeg";
import mumbaiLogo from "./../logo-of-ipl-teams/mumbai.jpeg";
import rajasthanLogo from "./../logo-of-ipl-teams/rajasthan.jpeg";
import rcbLogo from "./../logo-of-ipl-teams/rcb.jpeg";
import hyderabadLogo from "./../logo-of-ipl-teams/hyderabad.jpeg";
import deccanLogo from "./../logo-of-ipl-teams/deccan-chargers.jpeg";
import gujaratLogo from "./../logo-of-ipl-teams/gujarat.jpeg";
import kochiLogo from "./../logo-of-ipl-teams/kochi.jpeg";
import puneWarriorsLogo from "./../logo-of-ipl-teams/pune-warriors.jpeg";
import risingPuneLogo from "./../logo-of-ipl-teams/rising-pune.jpeg";

const iplData = [
  { id: 1, name: "Chennai Super Kings", logo: chennaiLogo },
  { id: 2, name: "Delhi Capitals", logo: delhiLogo },
  { id: 3, name: "Kings XI Punjab", logo: punjabLogo },
  { id: 4, name: "Kolkata Knight Riders", logo: kolkataLogo },
  { id: 5, name: "Mumbai Indians", logo: mumbaiLogo },
  { id: 6, name: "Rajasthan Royals", logo: rajasthanLogo },
  { id: 7, name: "Royal Challengers Bangalore", logo: rcbLogo },
  { id: 8, name: "Sunrisers Hyderabad", logo: hyderabadLogo },
  { id: 9, name: "Deccan Chargers", logo: deccanLogo },
  { id: 10, name: "Gujarat Lions", logo: gujaratLogo },
  { id: 11, name: "Kochi Tuskers Kerala", logo: kochiLogo },
  { id: 12, name: "Pune Warriors", logo: puneWarriorsLogo },
  { id: 13, name: "Rising Pune Supergiants", logo: risingPuneLogo },
];

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
