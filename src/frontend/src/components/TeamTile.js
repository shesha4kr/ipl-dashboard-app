import React from "react";
import "./../css/TeamTile.css";

export const TeamTile = ({ logo, teamName }) => {
  return (
    <div className="team-tile">
      <img src={logo} alt="" width="200px" height="200px" />
      <div>{teamName}</div>
    </div>
  );
};
