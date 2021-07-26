import { React } from "react";
import { iplData } from "../data/AllData";

export const Filter = () => {
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
