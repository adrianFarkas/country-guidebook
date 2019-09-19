import React from 'react';
import {Nav, Navbar} from "react-bootstrap";
import {FontAwesomeIcon} from "@fortawesome/react-fontawesome";
import {faSignInAlt, faUser} from "@fortawesome/free-solid-svg-icons";

function Header(props) {
    return (
        <Navbar className="navbar" bg="dark" expand="lg" variant="dark" >
            <Navbar.Brand href="/">Country Guide</Navbar.Brand>
            <Navbar.Toggle aria-controls="basic-navbar-nav" />
            <Navbar.Collapse id="basic-navbar-nav">
                <Nav className="ml-auto">
                    <Nav.Link href="#register"><FontAwesomeIcon icon={faUser} /> Register</Nav.Link>
                    <Nav.Link href="#login"><FontAwesomeIcon icon={faSignInAlt} /> Login</Nav.Link>
                </Nav>

            </Navbar.Collapse>
        </Navbar>
    )
}

export default Header;