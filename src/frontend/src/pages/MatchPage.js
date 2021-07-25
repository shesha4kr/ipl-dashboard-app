import { useState, useEffect } from "react";
import { FaFilter, FaHome } from "react-icons/fa";
import { MdFilter1, MdFilter2 } from "react-icons/md";
import { Link, useParams } from "react-router-dom";
import { Filter } from "../components/Filter";
import { LatestMatchDetail } from "../components/LatestMatchDetail";
import { YearSelector } from "../components/YearSelector";
import "./../css/MatchPage.css";

export const MatchPage = () => {
  console.log("Inside MatchPage");
  const { teamName, year } = useParams();
  const [matchesInfo, setMatchesInfo] = useState({
    matches: [],
    years: [],
    oppositionTeams: [],
  });
  const [isLoading, setLoading] = useState(true);
  const [isFilter, setIsFilter] = useState(false);
  let filter = 2;
  const url = `http://localhost:8080/team/${teamName}/matches?year=${year}`;

  const fetchTeamDetailsByYear = async () => {
    console.log("Inside fetch");
    const responseInJson = await fetch(url);
    console.log("After JSON fetch");
    const response = await responseInJson.json();
    console.log("NEW MATCHES:" + response);
    console.log("After DATA fetch");
    setLoading(false);
    setMatchesInfo(response);
    console.log("MATCH DETAILS:" + matchesInfo);
  };

  useEffect(() => {
    fetchTeamDetailsByYear();
  }, [teamName, year]);

  if (isLoading) return <h1>{`Fetching Match Details for ${teamName}...`}</h1>;

  if (!matchesInfo) return null;

  if (matchesInfo.matches.length === 0)
    return (
      <div className="match-page">
        <div>
          <YearSelector teamName={teamName} />
        </div>
        <h2>{`${teamName} did not play any matches in ${year}. Select trying other year?`}</h2>
      </div>
    );

  return (
    <div className="match-page">
      <div className="year-selector-postion">
        <YearSelector teamName={teamName} years={matchesInfo.years} />
      </div>

      <div>
        <div className="match-details-header">
          <h1>{`Matches of ${teamName} in ${year}`}</h1>

          <div className="filter-position">
            <FaFilter size="1.8rem" />
          </div>

          {filter === 0 ? (
            ""
          ) : filter === 1 ? (
            <MdFilter1
              size="1rem"
              style={{ marginTop: "-10px", marginLeft: "-20px" }}
            />
          ) : (
            <MdFilter2 size="1rem" style={{ marginTop: "-10px" }} />
          )}

          <div className="home-btn-position">
            <Link to={`/`}>
              <FaHome size="2rem" />
            </Link>
          </div>
        </div>

        {matchesInfo.matches.map((match) => {
          return (
            <div className="each-match">
              <LatestMatchDetail match={match} teamName={teamName} />
            </div>
          );
        })}
      </div>

      <div>
        <Filter />
      </div>
    </div>
  );
};
