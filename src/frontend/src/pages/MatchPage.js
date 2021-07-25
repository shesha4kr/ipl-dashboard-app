import { useState, useEffect } from "react";
import { useParams } from "react-router-dom";
import { LatestMatchDetail } from "../components/LatestMatchDetail";
import { YearSelector } from "../components/YearSelector";
import "./../css/MatchPage.css";

export const MatchPage = () => {
  console.log("Inside MatchPage");
  const { teamName, year } = useParams();
  const [matches, setMatches] = useState([]);
  const [isLoading, setLoading] = useState(true);
  const url = `http://localhost:8080/team/${teamName}/matches?year=${year}`;

  const fetchTeamDetailsByYear = async () => {
    console.log("Inside fetch");
    const responseInJson = await fetch(url);
    console.log("After JSON fetch");
    const response = await responseInJson.json();
    console.log("After DATA fetch");
    setLoading(false);
    setMatches(response);
  };

  useEffect(() => {
    fetchTeamDetailsByYear();
  }, [teamName, year]);

  if (isLoading) return <h1>{`Fetching Match Details for ${teamName}...`}</h1>;

  if (matches.length === 0)
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
      <div>
        <YearSelector teamName={teamName} />
      </div>

      <div>
        <h1 className="match-details-header">{`Matches of ${teamName} in ${year}`}</h1>

        {matches.map((match) => {
          return (
            <div className="each-match">
              <LatestMatchDetail match={match} teamName={teamName} />
            </div>
          );
        })}
      </div>
    </div>
  );

  // const { teamName, year } = useParams();
  // const [isLoading, setLoading] = useState(true);
  // const [matches, setMatches] = useState([]);
  // const url = `http://localhost:8080/team/${teamName}/matches?year=${year}`;

  // useEffect(() => {
  //   fetchTeamDetailsByYear();
  // }, []);

  // const fetchTeamDetailsByYear = async () => {
  //   console.log("Inside fetch");
  //   const responseInJson = await fetch(url);
  //   console.log("After JSON fetch");
  //   const response = await responseInJson.json();
  //   console.log("After DATA fetch");
  //   setLoading(false);
  //   setMatches(response);
  // };

  // // if (isLoading) return <h1>Fetching Info...</h1>;

  // // if (matches.length === 0) return <h1>No Records Found</h1>;

  // return (
  //   <div className="match-page">
  //     <div>
  //       <YearSelector teamName={teamName} />
  //     </div>

  //     <div>
  //       {matches.map((match) => {
  //         return (
  //           <div key={match.matchId}>
  //             <LatestMatchDetail match={match} teamName={teamName} />
  //           </div>
  //         );
  //       })}
  //     </div>
  //   </div>
  // );
};
