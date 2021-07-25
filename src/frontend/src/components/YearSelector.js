import React from "react";
import { Link } from "react-router-dom";
import "./YearSelector.css";

export const YearSelector = ({ teamName }) => {
  const years = [];
  const startYear = process.env.REACT_APP_START_YEAR;
  const endYear = process.env.REACT_APP_END_YEAR;

  for (let i = startYear; i <= endYear; i++) {
    years.push(i);
  }

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
