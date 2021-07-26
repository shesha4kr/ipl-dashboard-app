import React from "react";
import ReactDOM from "react-dom";
import { BrowserRouter as Router, Route, Switch } from "react-router-dom";
import { IplDashboard } from "./pages/IplDashboard";
import { TeamPage } from "./pages/TeamPage";
import { MatchPage } from "./pages/MatchPage";
import { ErrorPage } from "./pages/ErrorPage";
import "./css/index.css";

const HandleReactRoute = () => {
  return (
    <Router>
      <Switch>
        <Route exact path="/">
          <IplDashboard />
        </Route>

        <Route exact path="/team/:teamName">
          console.log("Inside Link");
          <TeamPage />
          console.log("Outside Link");
        </Route>

        <Route exact path="/team/:teamName/matches/:year">
          <MatchPage />
        </Route>

        <Route path="*">
          <ErrorPage />
        </Route>
      </Switch>
    </Router>
  );
};

ReactDOM.render(
  <React.StrictMode>
    <HandleReactRoute />
  </React.StrictMode>,
  document.getElementById("root")
);
