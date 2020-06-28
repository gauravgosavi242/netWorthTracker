import React, { Component } from 'react';
import  {Nav, NavItem, Navbar, NavbarBrand, NavbarToggler, NavLink} from 'reactstrap';
class AppNav extends Component {
    state = {  }
    render() { 
        return ( <div>
            <Navbar color="light" light expand="md">
              <NavbarBrand href="/">Networth Tracker</NavbarBrand>
                <Nav className="ml-auto" navbar>
                  <NavItem>
                    <NavLink href="/components/">About Application</NavLink>
                  </NavItem>
                  <NavItem>
                    <NavLink href="/components/">Help</NavLink>
                  </NavItem>
                  <NavItem>
                    <NavLink href="/signin/">Sign IN</NavLink>
                  </NavItem>
                  <NavItem>
                    <NavLink href="https://github.com/gauravgosavi242">About me</NavLink>
                  </NavItem>
                  
                </Nav>
                {/* <NavbarText>Simple Text</NavbarText> */}
            </Navbar>
          </div> );
    }
}
 
export default AppNav;