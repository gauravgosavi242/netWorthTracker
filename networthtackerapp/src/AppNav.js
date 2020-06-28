import React, { Component } from 'react';
import  {Nav, NavItem, Navbar, NavbarBrand, NavLink} from 'reactstrap';
import Tracker from './Tracker';
class AppNav extends Component {
    state = {  }
    render() { 
        return ( <div>
            <Navbar color="dark" dark expand="md">
              <NavbarBrand href="/">Networth Tracker App</NavbarBrand>
                <Nav className="ml-auto" navbar>
                    <NavItem>
                    <NavLink href="/">Home</NavLink>
                  </NavItem>
                  <NavItem>
                    <NavLink href="/tracker">Tracker</NavLink>
                  </NavItem>
                  <NavItem>
                    <NavLink href="/actuator/health">Health</NavLink>
                  </NavItem>
                  <NavItem>
                    <NavLink href="https://github.com/gauravgosavi242">About me</NavLink>
                  </NavItem>
                  <NavItem>
                    <NavLink href="/signin/">Sign In</NavLink>
                  </NavItem>
                </Nav>
            </Navbar>
          </div> );
    }
}
 
export default AppNav;