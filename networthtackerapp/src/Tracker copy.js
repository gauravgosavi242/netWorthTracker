import React, { Component } from "react";
import AppNav from "./AppNav";
import { Container, Form, FormGroup, Button } from "reactstrap";
import { Table, Input, Label } from "reactstrap";

class Tracker extends Component {
  liabilityItem = {
    id: 2,
    name: "Credit card",
    value: 2000,
  };
  liabilityItems = {
    liabilityItem: [this.liabilityItem],
  };

  assetDto = {
    id: 1,
    name: "house",
    value: 20000,
  };
  assetRequestDto = {
    assetDtos: [this.assetDto],
  };

  requestDto = {
      assetRequestDto:this.assetRequestDto,
      
      currencyCode: "USD"
  }

  networth = {
    value: 18000,
    currency: "USD",
  };

  constructor(props) {
    super(props);
    this.state = {
      isLoading: true,
      currencies: [],
      assetRequestDto: {
        assetDtos: [
          { id: 3, name: "car", value: 1000 },
          { id: 4, name: "house", value: 10000 },
        ],
      },
      liabilityItemsDto: this.liabilityItems,
      networth: this.networth,
      selectedCurrency: "USD",
    };
    this.handleCurrencyChange = this.handleCurrencyChange.bind(this);
    this.handleSubmit = this.handleSubmit.bind(this);
  }

  async componentDidMount() {
    const currencyResponse = await fetch("/currency/all");
    const currencyRespBody = await currencyResponse.json();
    this.setState({
      currencies: currencyRespBody,
      isLoading: false,
      assetRequestDto: {
        assetDtos: [
          { id: 3, name: "car", value: 1000 },
          { id: 4, name: "house", value: 10000 },
        ],
      }
    });
  }

  async handleSubmit(event) {
    const asset = this.state.requestDto;
    await fetch("calculate/USD/currency/v2", {
      method: "PUT",
      headers: {
        'Accept': "application/json",
        'Content-type': "application/json",
      },
      body: JSON.stringify(this.requestDto),
    });
    event.preventDefault();

    console.log(this.state);
    // this.props.history.push("/tracker");
  }

  handleCurrencyChange(e) {
    console.log(e.target.value);
    let currState = { ...this.state };
    let stateVarToBeMutated = { ...this.state.selectedCurrency };
    stateVarToBeMutated = e.target.value;
    currState.selectedCurrency = stateVarToBeMutated;
    this.setState({ currState });
  }

  render() {
    const { currencies, isLoading, assetItemsDto } = this.state;
    var selectedCurrency = document.getElementById("currency");

    if (isLoading) {
      return <div>Loading please wait...</div>;
    }
    let currencyList = currencies.currencyDtos.map((currency) => (
      <option id={currency.id}>{currency.currencyCode}</option>
    ));

    return (
      <div>
        <AppNav />
        <Container>

        <table id="table" border="1">
            <tr>
                <th>First Name</th>
                <th>Last Name</th>
                <th>Value</th>
            </tr>
            <tr>
                <td>A1</td>
                <td>B1</td>
                <td>43</td>
            </tr>
            <tr>
                <td>A2</td>
                <td>B2</td>
                <td>28</td>
            </tr>
            <tr>
                <td>A3</td>
                <td>B3</td>
                <td>15</td>
            </tr>
            <tr>
                <td>A4</td>
                <td>B4</td>
                <td>50</td>
            </tr>
            <tr>
                <td>A5</td>
                <td>B5</td>
                <td>31</td>
            </tr>
            <tr>
                <td>A6</td>
                <td>B6</td>
                <td>85</td>
            </tr>
            <tr>
                <td>A7</td>
                <td>B7</td>
                <td>18</td>
            </tr>
        </table>
        <span id="val"></span>

          <br />
          <h2>Assets </h2>
          <br />
          <label>Currency</label>{" "}
          <select id="currency" onChange={this.handleCurrencyChange}>{currencyList}</select>
          <br />
          <Container>
            <h3>Assets</h3>
            <h4>Cash and investments</h4>

            <Table striped className="mt-4">
              <thead>
                <tr>
                  <th width="10%">#</th>
                  <th width="50%">Description</th>
                  <th width="40%">Amount</th>
                </tr>
              </thead>
              {/* <tbody>{assetrows}</tbody> */}
            </Table>
          </Container>
          <Form onSubmit={this.handleSubmit}>
            <FormGroup>
              <Button
                color="primary"
                type="submit"
                onClick={() => this.handleSubmit}
              >
                Save
              </Button>{" "}
              <Button color="secondary" type="reset">
                Clear
              </Button>{" "}
            </FormGroup>
          </Form>
          <h3>{this.state.selectedCurrency}</h3>
        </Container>
      </div>
    );
  }
}

export default Tracker;
