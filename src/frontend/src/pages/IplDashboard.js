import { React, useState } from "react";
import { Link } from "react-router-dom";
import "../css/index.css";

const iplData = [
  { id: 1, name: "Chennai Super Kings" },
  { id: 2, name: "Delhi Capitals" },
  { id: 3, name: "Kings XI Punjab" },
  { id: 4, name: "Kolkata Knight Riders" },
  { id: 5, name: "Mumbai Indians" },
  { id: 6, name: "Rajasthan Royals" },
  { id: 7, name: "Royal Challengers Bangalore" },
  { id: 8, name: "Sunrisers Hyderabad" },
  { id: 9, name: "Deccan Chargers" },
  { id: 10, name: "Gujarat Lions" },
  { id: 11, name: "Kochi Tuskers Kerala" },
  { id: 12, name: "Pune Warriors" },
  { id: 13, name: "Rising Pune Supergiants" },
];

export const IplDashboard = () => {
  const [allTeamNames] = useState(iplData);
  console.log("IplDashboard called");

  return (
    <div className="IplDashboard">
      <h1>Welcome to IPL Dashboard</h1>

      {allTeamNames.map((team) => {
        return (
          <div key={team.id}>
            <Link to={`team/${team.name}`}>
              <div>{team.name}</div>
            </Link>
          </div>
        );
      })}
    </div>
  );
};
