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
    assetRequestDto: this.assetRequestDto,

    currencyCode: "USD",
  };

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
      },
    });
  }

  async handleSubmit(event) {
    const asset = this.state.requestDto;
    await fetch("calculate/USD/currency/v2", {
      method: "PUT",
      headers: {
        Accept: "application/json",
        "Content-type": "application/json",
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
          <br />
          <label>Currency</label>{" "}
          <select id="currency" onChange={this.handleCurrencyChange}>
            {currencyList}
          </select>
          <br />
          <Container>
            <h3>Net Worth</h3>
            <h3>Assets</h3>
            <h4>Cash and investments</h4>
            <Table striped className="mt-2">
              <thead>
                <tr>
                  <th width="10%">#</th>
                  <th width="50%">Description</th>
                  <th width="40%">Amount</th>
                </tr>
              </thead>
              <tbody>
                <tr>
                  <td>1</td>
                  <td>Checking balance</td>
                  <td>
                    <input
                      type="text"
                      step="0.01"
                      onChange={this.handleChange}
                    />
                  </td>
                </tr>
                <tr>
                  <td>2</td>
                  <td>Savings for taxes</td>
                  <td>
                    <input
                      type="text"
                      step="0.01"
                      onChange={this.handleChange}
                    />
                  </td>
                </tr>
                <tr>
                  <td>3</td>
                  <td>Rainy day fund</td>
                  <td>
                    <input
                      type="text"
                      step="0.01"
                      onChange={this.handleChange}
                    />
                  </td>
                </tr>
                <tr>
                  <td>4</td>
                  <td>Saving for Fun</td>
                  <td>
                    <input
                      type="text"
                      step="0.01"
                      onChange={this.handleChange}
                    />
                  </td>{" "}
                </tr>
                <tr>
                  <td>5</td>
                  <td>Saving for travel</td>
                  <td>
                    <input
                      type="text"
                      step="0.01"
                      onChange={this.handleChange}
                    />
                  </td>
                </tr>
                <tr>
                  <td>6</td>
                  <td>Saving for personal development</td>
                  <td>
                    <input
                      type="text"
                      step="0.01"
                      onChange={this.handleChange}
                    />
                  </td>{" "}
                </tr>
                <tr>
                  <td>7</td>
                  <td>Investment 1</td>
                  <td>
                    <input
                      type="text"
                      step="0.01"
                      onChange={this.handleChange}
                    />
                  </td>
                </tr>
                <tr>
                  <td>8</td>
                  <td>Investment 2</td>
                  <td>
                    <input
                      type="text"
                      step="0.01"
                      onChange={this.handleChange}
                    />
                  </td>{" "}
                </tr>
                <tr>
                  <td>9</td>
                  <td>Investment 3</td>
                  <td>
                    <input
                      type="text"
                      step="0.01"
                      onChange={this.handleChange}
                    />
                  </td>{" "}
                </tr>
                <tr>
                  <td>10</td>
                  <td>Investment 4</td>
                  <td>
                    <input
                      type="text"
                      step="0.01"
                      onChange={this.handleChange}
                    />
                  </td>{" "}
                </tr>
                <tr>
                  <td>11</td>
                  <td>Investment 5</td>
                  <td>
                    <input
                      type="text"
                      step="0.01"
                      onChange={this.handleChange}
                    />
                  </td>
                </tr>
              </tbody>
            </Table>

            <h4>Long term assets</h4>
            <Table striped className="mt-2">
              <thead>
                <tr>
                  <th width="10%">#</th>
                  <th width="50%">Description</th>
                  <th width="40%">Amount</th>
                </tr>
              </thead>
              <tbody>
                <tr>
                  <td>1</td>
                  <td>Primary Home</td>
                  <td>
                    <input
                      type="text"
                      step="0.01"
                      onChange={this.handleChange}
                    />
                  </td>
                </tr>
                <tr>
                  <td>2</td>
                  <td>Secondary Home</td>
                  <td>
                    <input
                      type="text"
                      step="0.01"
                      onChange={this.handleChange}
                    />
                  </td>
                </tr>
                <tr>
                  <td>3</td>
                  <td>Other</td>
                  <td>
                    <input
                      type="text"
                      step="0.01"
                      onChange={this.handleChange}
                    />
                  </td>
                </tr>
              </tbody>
            </Table>
            <h3>Net Assets</h3>

            <h3>Liabilities</h3>
            <h4>Short term liabilities</h4>
            <Table striped className="mt-2">
              <thead>
                <tr>
                  <th width="10%">#</th>
                  <th width="40%">Description</th>
                  <th width="20%">Monthly payment</th>
                  <th width="30%">Amount</th>
                </tr>
              </thead>
              <tbody>
                <tr>
                  <td>1</td>
                  <td>Credit card 1</td>
                  <td>$ 200</td>
                  <td>
                    <input
                      type="text"
                      step="0.01"
                      onChange={this.handleChange}
                    />
                  </td>
                </tr>
                <tr>
                  <td>2</td>
                  <td>Credit card 2</td>
                  <td>$ 150</td>
                  <td>
                    <input
                      type="text"
                      step="0.01"
                      onChange={this.handleChange}
                    />
                  </td>
                </tr>
                <tr>
                  <td>3</td>
                  <td>(other...)</td>
                  <td></td>
                  <td>
                    <input
                      type="text"
                      step="0.01"
                      onChange={this.handleChange}
                    />
                  </td>
                </tr>
              </tbody>
            </Table>

            <h4>Long term debt</h4>
            <Table striped className="mt-2">
              <thead>
                <tr>
                  <th width="10%">#</th>
                  <th width="40%">Description</th>
                  <th width="20%">Monthly payment</th>
                  <th width="30%">Amount</th>
                </tr>
              </thead>
              <tbody>
                <tr>
                  <td>1</td>
                  <td>Mortgage 1</td>
                  <td>$ 2000</td>
                  <td>
                    <input
                      type="text"
                      step="0.01"
                      onChange={this.handleChange}
                    />
                  </td>
                </tr>
                <tr>
                  <td>2</td>
                  <td>Mortgage 2</td>
                  <td>$ 3500</td>
                  <td>
                    <input
                      type="text"
                      step="0.01"
                      onChange={this.handleChange}
                    />
                  </td>
                </tr>
                <tr>
                  <td>3</td>
                  <td>Line of credit</td>
                  <td>$ 500</td>
                  <td>
                    <input
                      type="text"
                      step="0.01"
                      onChange={this.handleChange}
                    />
                  </td>
                </tr>
                <tr>
                  <td>4</td>
                  <td>Investment Loan</td>
                  <td>$ 700</td>
                  <td>
                    <input
                      type="text"
                      step="0.01"
                      onChange={this.handleChange}
                    />
                  </td>
                </tr>
                <tr>
                  <td>5</td>
                  <td>Student Loan</td>
                  <td></td>
                  <td>
                    <input
                      type="text"
                      step="0.01"
                      onChange={this.handleChange}
                    />
                  </td>
                </tr>
                <tr>
                  <td>6</td>
                  <td>Car Loan</td>
                  <td></td>
                  <td>
                    <input
                      type="text"
                      step="0.01"
                      onChange={this.handleChange}
                    />
                  </td>
                </tr>
              </tbody>
            </Table>
            <h3>Net Liabilities</h3>
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
            </FormGroup>
          </Form>
        </Container>
      </div>
    );
  }
}

export default Tracker;
