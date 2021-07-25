import React from "react";
import { Link } from "react-router-dom";
import "./YearSelector.css";

export const YearSelector = ({ teamName, years }) => {
  if (!years) return null;

  return (
    <div className="year-selector">
      <h3>Select Year</h3>
      <ol>
        {years.map((year) => {
          return (
            <Link to={`/team/${teamName}/matches/${year}`}>
              <li>{year}</li>
            </Link>
          );
        })}
      </ol>
    </div>
  );
};
