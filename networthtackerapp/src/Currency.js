import React, { Component } from "react";
import AppNav from "./AppNav";
class Currency extends Component {
  state = {
    isLoading: true,
    supportedCurr: [],
  };

  async componentDidMount() {
    const response = await fetch("/currency/all");
    const body = await response.json();
    console.log(body);
    this.setState({ supportedCurr: body, isLoading: false });
  }
  render() {
    const { supportedCurr, isLoading } = this.state;
    if(isLoading){
        return(<div>Loading, please wait...</div>)
    }

    return (
      <div>
        <AppNav />
        <h3>Supported Currencies</h3>
        {
            supportedCurr.currencyDtos.map(currency => 
                <div id = {currency.id}> 
                    {currency.currencyCode }
                </div>)
        }
      </div>
    );
  }
}

export default Currency;
