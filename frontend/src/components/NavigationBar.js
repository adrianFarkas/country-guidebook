import React, {useState} from 'react';
import {Nav, Navbar} from "react-bootstrap";
import {FontAwesomeIcon} from "@fortawesome/react-fontawesome";
import {faSignInAlt, faSignOutAlt, faUser} from "@fortawesome/free-solid-svg-icons";
import AuthFrom from "./Authentication/AuthForm"
import Modal from "@material-ui/core/Modal";



function NavigationBar() {

    const token = localStorage.getItem("token");

    const handleLogout= () => {
       localStorage.removeItem("token");
        window.location.pathname="/";

    };

    const styles = {
        padding: "0 10px",
        border: "2px solid #d5d5d5",
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
            <AuthFrom login={true}/>
            </Modal>
            <Modal
                aria-labelledby="simple-modal-title"
                aria-describedby="simple-modal-description"
                open={openRegister}
                onClose={handleCloseRegister}
            >

                <AuthFrom login={false}/>

            </Modal>
            <Navbar.Brand href="/">Home</Navbar.Brand>
            <Navbar.Toggle aria-controls="basic-navbar-nav"/>
            <Navbar.Collapse id="basic-navbar-nav">
                <Nav className="ml-auto">
                    {token===null ?
                        <React.Fragment>
                            <div className="login-btn" style={styles}>
                                <Nav.Link onClick={handleOpenLogin} style={{color: "#d5d5d5"}}><FontAwesomeIcon
                                    icon={faSignInAlt}/> Login</Nav.Link>
                            </div>
                            <div className="register-btn" style={styles}>
                                <Nav.Link onClick={handleOpenRegister} style={{color: "#505050"}}><FontAwesomeIcon
                                    icon={faUser}/> Register</Nav.Link>
                            </div>
                        </React.Fragment>
                        :
                        <div style={styles}>
                            <Nav.Link onClick={handleLogout} style={{color: "#ffffff"}}><FontAwesomeIcon
                                icon={faSignOutAlt}/> Logout</Nav.Link>
                        </div>
                    }
                </Nav>

            </Navbar.Collapse>
        </Navbar>
    )
}

export default NavigationBar;