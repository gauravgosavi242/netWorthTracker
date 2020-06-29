import React, { Component } from "react";
import AppNav from "./AppNav";
import { Container, Form, FormGroup, Button } from "reactstrap";
import { Table,Container,Input,Button,Label, FormGroup, Form} from 'reactstrap';

import Currency from "./Currency";
class Tracker extends Component {
  liabilityItem = {
    id: "2",
    name: "Credit card",
    value: 2000,
  };
  liabilityItems = {
    liabilityItem: [this.liabilityItem],
  };

  assetItem = {
    id: "1",
    name: "house",
    value: 20000,
  };
  assetItems = {
    assetItem: [this.assetItem],
  };

  networth = {
    value: 18000,
    currency: "USD",
  };

  constructor(props){
      super(props)
      this.state={
        isLoading: true,
        currencies: [],
        assetItemsDto: this.assetItems,
        liabilityItemsDto: this.liabilityItems,
        networth: this.networth,
      };
  }

  async componentDidMount() {
    const currencyResponse = await fetch("/currency/all");
    const currencyRespBody = await currencyResponse.json();
    this.setState({ currencies: currencyRespBody, isLoading: false });
  }

  render() {
    const { currencies, isLoading } = this.state;

    if (isLoading) {
      return <div>Loading please wait...</div>;
    }
    let currencyList = currencies.currencyDtos.map((currency) => (
      <option id={currency.id}>{currency.currencyCode}</option>
    ));

    console.log(this.liabilityItemsDto);

    return (
      <div>
        <AppNav />
        <Container>
          <br />
          <h2>Assets </h2>
          <br />
          <label for="Title">Currency</label> <select>{currencyList}</select> 
          <br />
          <h4>Cash and investments</h4>
          <Form>
            <FormGroup>
              <label for="Title">Checking Balance </label>{" "}
              <input
                type="number"
                step=".01"
                lang="nb"
                name="checkingBalance"
                id="checkingBalance"
                onChange={this.handleChange}
              ></input>
            </FormGroup>

            <FormGroup>
              <label for="Title">Saving For Taxes </label>{" "}
              <input
                type="number"
                step=".01"
                lang="nb"
                name="savingForTaxes"
                id="savingForTaxes"
                onChange={this.handleChange}
              ></input>
            </FormGroup>

            <FormGroup>
              <label for="Title">Savings for Fun </label>{" "}
              <input
                type="text"
                name="savingForFun"
                id="savingForFun"
                onChange={this.handleChange}
              ></input>
            </FormGroup>

            <FormGroup>
              <label for="Title">Rainy day fund </label>{" "}
              <input
                type="text"
                name="raninyDayFund"
                id="raninyDayFund"
                onChange={this.handleChange}
              ></input>
            </FormGroup>

            <FormGroup>
              <label for="Title">Saving for Travel </label>{" "}
              <input
                type="text"
                name="savingForTravel"
                id="savingForTravel"
                onChange={this.handleChange}
              ></input>
            </FormGroup>

            <FormGroup>
              <label for="Title">Saving for personal dev </label>{" "}
              <input
                type="text"
                name="savingForPersonalDev"
                id="savingForPersonalDev"
                onChange={this.handleChange}
              ></input>
            </FormGroup>

            <FormGroup>
              <label for="Title">Investment 1 </label>{" "}
              <input
                type="text"
                name="investment1"
                id="investment1"
                onChange={this.handleChange}
              ></input>
            </FormGroup>

            <FormGroup>
              <label for="Title">Investment 2 </label>{" "}
              <input
                type="text"
                name="investment2"
                id="investment2"
                onChange={this.handleChange}
              ></input>
            </FormGroup>

            <FormGroup>
              <label for="Title">Investment 3 </label>{" "}
              <input
                type="text"
                name="investment3"
                id="investment3"
                onChange={this.handleChange}
              ></input>
            </FormGroup>

            <FormGroup>
              <label for="Title">Investment 4 </label>{" "}
              <input
                type="text"
                name="investment4"
                id="investment4"
                onChange={this.handleChange}
              ></input>
            </FormGroup>

            <FormGroup>
              <label for="Title">Investment 5 </label>{" "}
              <input
                type="text"
                name="investment5"
                id="investment5"
                onChange={this.handleChange}
              ></input>
            </FormGroup>

            <h4>Long term assets</h4>
            <FormGroup>
              <label for="Title">Primary Home </label>{" "}
              <input
                type="text"
                name="primaryHome"
                id="primaryHome"
                onChange={this.handleChange}
              ></input>
            </FormGroup>
            <FormGroup>
              <label for="Title">Secondary Home 5 </label>{" "}
              <input
                type="text"
                name="secondaryHome"
                id="secondaryHome"
                onChange={this.handleChange}
              ></input>
            </FormGroup>
            <FormGroup>
              <label for="Title">Other </label>{" "}
              <input
                type="text"
                name="other"
                id="other"
                onChange={this.handleChange}
              ></input>
            </FormGroup>

            <h2>Liabilities</h2>

            <h4>Short term Liabilities</h4>

            <FormGroup>
              <label for="Title">Credit card 1 </label>{" "}
              <input
                type="text"
                name="creditCard1"
                id="creditCard1"
                onChange={this.handleChange}
              ></input>
            </FormGroup>
            <FormGroup>
              <label for="Title">Credit card 2 </label>{" "}
              <input
                type="text"
                name="creditCard2"
                id="creditCard2"
                onChange={this.handleChange}
              ></input>
            </FormGroup>
            <FormGroup>
              <label for="Title">(others...) </label>{" "}
              <input
                type="text"
                name="other"
                id="other"
                onChange={this.handleChange}
              ></input>
            </FormGroup>

            <h4>Long term Debt</h4>

            <FormGroup>
              <label for="Title">Mortgage 1 </label>{" "}
              <input
                type="text"
                name="mortgage1"
                id="mortgage1"
                onChange={this.handleChange}
              ></input>
            </FormGroup>
            <FormGroup>
              <label for="Title">Mortgage 2 </label>{" "}
              <input
                type="text"
                name="mortgage1"
                id="mortgage2"
                onChange={this.handleChange}
              ></input>
            </FormGroup>
            <FormGroup>
              <label for="Title">Line of credit </label>{" "}
              <input
                type="text"
                name="lineOfCredit"
                id="lineOfCredit"
                onChange={this.handleChange}
              ></input>
            </FormGroup>

            <FormGroup>
              <label for="Title">Investment Loan </label>{" "}
              <input
                type="text"
                name="investmentLoan"
                id="investmentLoan"
                onChange={this.handleChange}
              ></input>
            </FormGroup>
            <FormGroup>
              <label for="Title">Student Loan </label>{" "}
              <input
                type="text"
                name="studentLoan"
                id="studentLoan"
                onChange={this.handleChange}
              ></input>
            </FormGroup>
            <FormGroup>
              <label for="Title">Car Loan </label>{" "}
              <input
                type="text"
                name="carLoan"
                id="carLoan"
                onChange={this.handleChange}
              ></input>
            </FormGroup>

            <FormGroup>
              <Button color="primary" type="submit">
                Save
              </Button>{" "}
              <Button color="secondary" type="reset">
                Clear
              </Button>{" "}
            </FormGroup>
          </Form>
        </Container>
      </div>
    );
  }
}

export default Tracker;
