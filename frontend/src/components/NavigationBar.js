import React from 'react';
import {Nav, Navbar} from "react-bootstrap";
import {FontAwesomeIcon} from "@fortawesome/react-fontawesome";
import {faSignInAlt, faUser} from "@fortawesome/free-solid-svg-icons";

function NavigationBar() {
    const styles = {
        padding: "0 10px",
        border: "2px solid #d5d5d5",
        borderRadius: "5px",
        margin: "auto 10px",
    };
    return (
        <Navbar className="navbar" expand="lg" variant="dark">
            <Navbar.Brand href="/">Home</Navbar.Brand>
            <Navbar.Toggle aria-controls="basic-navbar-nav"/>
            <Navbar.Collapse id="basic-navbar-nav">
                <Nav className="ml-auto">
                    <div className="login-btn" style={styles}>
                        <Nav.Link href="#login" style={{color: "#d5d5d5"}}><FontAwesomeIcon
                            icon={faSignInAlt}/> Login</Nav.Link>
                    </div>
                    <div className="register-btn" style={styles}>
                        <Nav.Link href="#register" style={{color: "#505050"}}><FontAwesomeIcon
                            icon={faUser}/> Register</Nav.Link>
                    </div>
                </Nav>

            </Navbar.Collapse>
        </Navbar>
    )
}

export default NavigationBar;