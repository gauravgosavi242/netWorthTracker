import React, { Component } from "react";
import AppNav from "./AppNav";
import ServerTable from "react-strap-table";

class Health extends React.Component {
  state = {
    isLoading: true,
    Health: "",
  };

  async componentDidMount() {
    const response = await fetch("/actuator/health");
    const body = await response.json();
    this.setState({ Health: body, isLoading: false });
  }
  render() {
    const { Health, isLoading } = this.state;
    console.log(this.state.Health);
    if (isLoading) return <div>Loading...</div>;

    return (
      <div>
        <AppNav />
        <h3>{this.state.Health.status}</h3>
      </div>
    );
  }
}
export default Health;
