import React, {useState} from 'react';
import {Nav, Navbar} from "react-bootstrap";
import {FontAwesomeIcon} from "@fortawesome/react-fontawesome";
import {faSignInAlt, faUser} from "@fortawesome/free-solid-svg-icons";
import LoginForm from "./Authentication/LoginForm";
import RegisterForm from "./Authentication/RegistrationForm";
import  { Redirect } from 'react-router-dom';

import Modal from "@material-ui/core/Modal";


function NavigationBar() {

    const token = localStorage.getItem("token");

    const handleLogout= () => {
       localStorage.removeItem("token");
        window.location.pathname="/";

    };
    console.log(token);
    const styles = {
        padding: "0 10px",
        border: "2px solid #ffffff",
        borderRadius: "5px",
        margin: "auto 10px",
    };

    const [openLogin, setOpenLogin] = useState(false);

    const handleOpenLogin = () => {
        setOpenLogin(true);
    };

    const handleCloseLogin = () => {
        setOpenLogin(false);
    };

    const [openRegister, setOpenRegister] = useState(false);

    const handleOpenRegister = () => {
        setOpenRegister(true);
    };

    const handleCloseRegister = () => {
        setOpenRegister(false);
    };


    return (
        <Navbar className="navbar" expand="lg" variant="dark">
            <Modal
                aria-labelledby="simple-modal-title"
                aria-describedby="simple-modal-description"
                open={openLogin}
                onClose={handleCloseLogin}
            >
            <LoginForm/>
            </Modal>
            <Modal
                aria-labelledby="simple-modal-title"
                aria-describedby="simple-modal-description"
                open={openRegister}
                onClose={handleCloseRegister}
            >
                <RegisterForm/>
            </Modal>
            <Navbar.Brand href="/">Home</Navbar.Brand>
            <Navbar.Toggle aria-controls="basic-navbar-nav"/>
            <Navbar.Collapse id="basic-navbar-nav">
                <Nav className="ml-auto">
                    {token===null ?
                        <React.Fragment>
                            <div style={styles}>
                                <Nav.Link onClick={handleOpenLogin} style={{color: "#ffffff"}}><FontAwesomeIcon
                                    icon={faSignInAlt}/> Login</Nav.Link>
                            </div>
                            <div style={styles}>
                                <Nav.Link onClick={handleOpenRegister} style={{color: "#ffffff"}}><FontAwesomeIcon
                                    icon={faUser}/> Register</Nav.Link>
                            </div>
                        </React.Fragment>
                        :
                        <div style={styles}>
                            <Nav.Link onClick={handleLogout} style={{color: "#ffffff"}}><FontAwesomeIcon
                                icon={faUser}/> Logout</Nav.Link>
                        </div>
                    }
                </Nav>

            </Navbar.Collapse>
        </Navbar>
    )
}

export default NavigationBar;