import React, { Component } from "react";
import Tracker from "./Tracker";
import Health from "./Health";
import Home from "./Home";
import Currency from "./Currency";
import { Route, BrowserRouter as Router, Switch } from "react-router-dom";
import { Container } from "reactstrap";

class App extends Component {
  state = {};
  render() {
    return (
      <Container>
        <Router>
          <Switch>
            <Route path="/" exact={true} component={Home} />
            <Route path="/tracker" exact={true} component={Tracker} />
            <Route path="/actuator/health" exact={true} component={Health} />
            <Route path="/currency/all" exact={true} component={Currency} />
          </Switch>
        </Router>
      </Container>
    );
  }
}

export default App;
