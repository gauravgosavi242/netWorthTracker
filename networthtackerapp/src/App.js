import React, { Component } from 'react';
import Home from './Home';
import Health from './Health';
import {Route, BrowserRouter as Router, Switch} from 'react-router-dom';

class App extends Component {
  state = {  }
  render() { 
    return ( 
      <Router>
        <switch>
          <Route path ='/' exact = {true} component= {Home}/>
          <Route path ='/actuator/health' exact = {true} component ={Health}/>

        </switch>
      </Router>
     );
  }
}
 
export default App;