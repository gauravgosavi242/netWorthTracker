import React, { Component } from "react";
import AppNav from './AppNav'

class Health extends React.Component {
  state = {
    isLoading: true,
    Health: []
  };

  async componentDidMount() {
    const response = await fetch("/actuator/health");
    const body = response.status;
    this.setState({ Health: body, isLoading: false });
  }
  render() {
    const { Health, isLoading } = this.state;
    if (isLoading) return <div>Loading...</div>;

    return (
      <div>
         <AppNav/> 
        <h3> Healthcheck </h3>
        {<div id="ABS"> {Health}</div>}
      </div>
    );
  }
}
export default Health;
