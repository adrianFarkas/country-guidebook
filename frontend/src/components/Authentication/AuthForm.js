import React from 'react';
import '../../css/auth.css';
import axios from "axios";


class AuthForm extends React.Component {
    constructor(props) {
        super(props);
        this.state = {
            fields: {},
            errors: {},
            login: this.props.login,
        };

        this.handleChange = this.handleChange.bind(this);
        this.submituserRegistrationForm = this.submituserRegistrationForm.bind(this);

    };

    handleChange(e) {
        let fields = this.state.fields;
        fields[e.target.name] = e.target.value;
        this.setState({
            fields
        });

    }

    submituserRegistrationForm(e) {
        e.preventDefault();
        const {login} = this.props;
        if (this.validateForm()) {
            let send = {
                userName: this.state.fields.userName,
                password: this.state.fields.password,
                email: ""
            };

            login ? send.email = "" : send.email = this.state.fields.email;
            let url = login ? "login" : "register";

            let fields = {};
            fields["userName"] = "";
            fields["password"] = "";
            fields["email"] = "";
            this.setState({fields: fields});
            axios.defaults.headers.common = {
                "Content-Type": "application/json"
            };



            axios.post("http://127.0.0.1:8080/auth/" + url, send)
                .then(res => {

                    let HttpStatus = res.status;
                    if (HttpStatus === 201) {
                            this.showError(res.data);
                    } else {

                        let token = res.data.token;// Cookie.get("token");

                        localStorage.setItem("token", token);
                        window.location.reload();
                    }
                })
                .catch(error => {
                    if (login) {
                        this.showError("Wrong username or password!");
                    }
                    console.log(error)

                });


        }
    }

    showError(errorMessage){
        let errors = {};
        errors["wrongCreditentials"] = errorMessage;
        this.setState({
            errors: errors
        });
    }

    validateForm() {

        let fields = this.state.fields;
        let errors = {};
        let formIsValid = true;

        if (!fields["userName"]) {
            formIsValid = false;
            errors["userName"] = "*Please enter your username.";
        }

        if (typeof fields["userName"] !== "undefined") {
            if (!fields["userName"].match(/^[a-zA-Z ]*$/)) {
                formIsValid = false;
                errors["userName"] = "*Please enter alphabet characters only.";
            }
        }
        if (!this.props.login) {
            if (!fields["email"]) {
                formIsValid = false;
                errors["email"] = "*Please enter your email-ID.";
            }

                  if (typeof fields["email"] !== "undefined") {
                      //regular expression for email validation
                      let pattern = new RegExp(/^(("[\w-\s]+")|([\w-]+(?:\.[\w-]+)*)|("[\w-\s]+")([\w-]+(?:\.[\w-]+)*))(@((?:[\w-]+\.)*\w[\w-]{0,66})\.([a-z]{2,6}(?:\.[a-z]{2})?)$)|(@\[?((25[0-5]\.|2[0-4][0-9]\.|1[0-9]{2}\.|[0-9]{1,2}\.))((25[0-5]|2[0-4][0-9]|1[0-9]{2}|[0-9]{1,2})\.){2}(25[0-5]|2[0-4][0-9]|1[0-9]{2}|[0-9]{1,2})\]?$)/i);
                      if (!pattern.test(fields["email"])) {
                          formIsValid = false;
                          errors["email"] = "*Please enter valid email-ID.";
                      }
                  }

        }


        if (!fields["password"]) {
            formIsValid = false;
            errors["password"] = "*Please enter your password.";
        }

        /*    if (typeof fields["password"] !== "undefined") {
                if (!fields["password"].match(/^.*(?=.{8,})(?=.*\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%&]).*$/)) {
                    formIsValid = false;
                    errors["password"] = "*Please enter secure and strong password.";
                }
            }*/

        this.setState({
            errors: errors
        });
        return formIsValid;


    }


    render() {

        return (

            <div id="container">
                <div id="content-auth">
                    <div className="header_auth">{this.props.login ? "Login" : "Registration"}</div>
                    <div className="form-container">
                        <form method="post" name="userRegistrationForm" onSubmit={this.submituserRegistrationForm}>
                            <label className="form_label">Name</label>
                            <input className="form_input" type="text" name="userName" value={this.state.fields.userName}
                                   onChange={this.handleChange}/>
                            <div className="errorMsg">{this.state.errors.username}</div>
                            {!this.props.login ?
                                <React.Fragment>
                                    <label className="form_label">Email ID:</label>
                                    <input className="form_input" type="text" name="email" value={this.state.fields.email}
                                           onChange={this.handleChange}/>
                                    <div className="errorMsg">{this.state.errors.email}</div>
                                </React.Fragment>
                                : ""}
                            <label className="form_label">Password</label>
                            <input  className="form_input" type="password" name="password" value={this.state.fields.password}
                                    onChange={this.handleChange}/>
                            <div className="errorMsg">{this.state.errors.password}</div>
                            <div className="errorMsg">{this.state.errors.wrongCreditentials}</div>
                            <input type="submit" className="button" value={this.props.login ? "Login" : "Register"}/>
                        </form>
                    </div>
                </div>
            </div>

        );
    }
}

export default AuthForm;