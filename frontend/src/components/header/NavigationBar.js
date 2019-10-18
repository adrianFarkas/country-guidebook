import React, {useState} from 'react';
import {Nav, Navbar} from "react-bootstrap";
import {FontAwesomeIcon} from "@fortawesome/react-fontawesome";
import {faSignInAlt, faSignOutAlt, faUser} from "@fortawesome/free-solid-svg-icons";
import AuthFrom from "../Authentication/AuthForm"
import Modal from "@material-ui/core/Modal";


function NavigationBar() {

    const token = localStorage.getItem("token");

    const handleLogout = () => {
        localStorage.removeItem("token");
        window.location.reload();

    };

    const styles = {
        padding: "0 10px",
        border: "2px solid #d5d5d5",
        borderRadius: "5px",
        margin: "auto 10px",
    };

    const [openLogin, setOpenLogin] = useState(false);
    const [openRegister, setOpenRegister] = useState(false);

    const handleModalOpen = (formType) => {
        formType === "login" ? setOpenLogin(true) : setOpenRegister(true);
    };

    const handleModalClose = (formType) => {
        formType === "login" ? setOpenLogin(false) : setOpenRegister(false);
    };


    return (
        <Navbar className="navbar" expand="lg" variant="dark">
            <Modal
                aria-labelledby="simple-modal-title"
                aria-describedby="simple-modal-description"
                open={openLogin}
                onClose={() => handleModalClose("login")}
                tabIndex={-1}
            >
                <AuthFrom login={true}/>
            </Modal>
            <Modal
                aria-labelledby="simple-modal-title"
                aria-describedby="simple-modal-description"
                open={openRegister}
                onClose={() => handleModalClose("register")}
                tabIndex={-1}
            >
                <AuthFrom login={false}/>
            </Modal>
            <Navbar.Brand href="/">Home</Navbar.Brand>
            <Navbar.Toggle aria-controls="basic-navbar-nav"/>
            <Navbar.Collapse id="basic-navbar-nav">
                <Nav className="ml-auto">
                    {token === null ?
                        <React.Fragment>
                            <div className="login-btn" style={styles}>
                                <Nav.Link onClick={() => handleModalOpen("login")}
                                          style={{color: "#d5d5d5"}}><FontAwesomeIcon
                                    icon={faSignInAlt}/> Login</Nav.Link>
                            </div>
                            <div className="register-btn" style={styles}>
                                <Nav.Link onClick={() => handleModalOpen("register")}
                                          style={{color: "#505050"}}><FontAwesomeIcon
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