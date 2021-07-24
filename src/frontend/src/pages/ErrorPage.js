import { Link } from "react-router-dom";

export const ErrorPage = () => {
  return (
    <div>
      <h1>Oops!! Seems like you entered wrong URL</h1>
      <Link to="/">
        <p>Go To HomePage</p>
      </Link>
    </div>
  );
};
