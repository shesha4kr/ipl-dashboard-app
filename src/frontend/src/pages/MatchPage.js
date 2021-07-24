import { useState, useEffect } from "react";
import { useParams } from "react-router-dom";

export const MatchPage = () => {
  console.log("Inside MatchPage");

  const { teamName, year } = useParams();
  const [isLoading, setLoading] = useState(true);
  const [matches, setMatches] = useState([]);
  const url = `http://localhost:8080/team/${teamName}/matches?year=${year}`;

  useEffect(() => {
    fetchTeamDetailsByYear();
  }, [year, teamName, isLoading]);

  const fetchTeamDetailsByYear = async () => {
    const responseInJson = await fetch(url);
    const response = await responseInJson.json();
    if (matches === []) {
      console.log("EMPTY MATCHES");
    } else {
      console.log("No EMPTY MATCHES:" + matches);
    }
    setLoading(false);
    setMatches(response);
  };

  if (isLoading) return <h1>Fetching Info...</h1>;

  if (matches.length === 0) return <h1>No Records Found</h1>;

  return (
    <div>
      {matches.map((match) => {
        const otherTeam =
          match.firstInnTeam === teamName
            ? match.secondInnTeam
            : match.firstInnTeam;
        return (
          <div key={match.matchId}>
            <h1>vs</h1>
            <h2>{otherTeam}</h2>
            <p>{match.date}</p>
          </div>
        );
      })}
    </div>
  );
};
