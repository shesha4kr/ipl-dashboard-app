import { React } from "react";

export const Filter = () => {
  const iplData = [
    { id: 1, name: "Chennai Super Kings" },
    { id: 2, name: "Delhi Capitals" },
    { id: 3, name: "Kings XI Punjab" },
    { id: 4, name: "Kolkata Knight Riders" },
    { id: 5, name: "Mumbai Indians" },
  ];

  // const handleChange = (event) => {
  //   event.preventDefault();
  //   setTeam(event.target.value);
  // };

  // const [team, setTeam] = useState("Select Team");
  return (
    <form>
      <select id="myList" value="Select Team" readOnly>
        {iplData.map((data) => (
          <option value={data.name} key={data.id}>
            {data.name}
          </option>
        ))}
      </select>
      <p>
        Your selected tutorial site is:
        <input type="text" id="favourite" size="20" />
      </p>
      +
    </form>
  );
};
