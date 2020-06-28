import React, { Component } from "react";
import AppNav from "./AppNav";
import { Container, Form, FormGroup, Button } from "reactstrap";
class Tracker extends Component {
  state = {};
  render() {
    return (
      <div>
        <AppNav />
            <Container>
                <h2>Assets </h2>
                <td></td>
                <Form>
                    <FormGroup>
                        <label for = "Title">Asset1</label>
                        <input type="number" step=".01" lang="nb" name = "asset1" id = "asset1" onChange = {this.handleChange}></input> 
                    </FormGroup>

                    <FormGroup>
                        <label for = "Title">Asset2</label>
                        <input type="number" step=".01" lang="nb" name = "asset2" id = "asset2" onChange = {this.handleChange}></input> 
                    </FormGroup>

                    <FormGroup>
                        <label for = "Title">Asset3</label>
                        <input type ="text" name = "asset3" id = "asset3" onChange = {this.handleChange}></input> 
                    </FormGroup>

                    <FormGroup>
                        <label for = "Title">Asset4</label>
                        <input type ="text" name = "asset4" id = "asset4" onChange = {this.handleChange}></input> 
                    </FormGroup>

                    <FormGroup>
                        <Button color="primary" type="submit">Save</Button> {' '}
                        <Button color="secondary" type="reset">Clear</Button> {' '}
                    </FormGroup>
                </Form>
            </Container>


      </div>
    );
  }
}

export default Tracker;
