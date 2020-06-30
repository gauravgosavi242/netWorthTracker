import React, { Component } from "react";
import AppNav from "./AppNav";
import ServerTable from "react-strap-table";

class Health extends React.Component {
  state = {
    isLoading: true,
    Health: [],
  };

  async componentDidMount() {
    const response = await fetch("/actuator/health");
    const body = await response.json();
    this.setState({ Health: body, isLoading: false });
  }
  render() {
    const { Health, isLoading } = this.state;
    if (isLoading) return <div>Loading...</div>;

    const url = "https://react-strap-table.com/users";
    const columns = ["id", "name", "email", "created_at"];
    const options = {
      headings: { id: "#", created_at: "Created At" },
      sortable: ["name", "email"],
    };
    return (
      <div>
        <AppNav />
        <ServerTable
          columns={columns}
          url={url}
          options={options}
          bordered
          hover
        />
      </div>
    );
  }
}
export default Health;
