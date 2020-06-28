import React, { Component } from "react";
import Tracker from "./Tracker";
import Health from "./Health";
import Home from "./Home"
import { Route, BrowserRouter as Router, Switch } from "react-router-dom";

class App extends Component {
  state = {};
  render() {
    return (
      <Router>
        <switch>
          <Route path="/" exact={true} component={Home} />
          <Route path="/tracker" exact={true} component={Tracker} />
          <Route path="/actuator/health" exact={true} component={Health} />
        </switch>
      </Router>
    );
  }
}

export default App;
