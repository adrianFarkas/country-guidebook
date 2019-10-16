import React from 'react';
import './style.css';
import axios from "axios";
import  { Redirect } from 'react-router-dom';


class LoginForm extends React.Component {
    constructor() {
        super();
        this.state = {
            fields: {},
            errors: {}
        }

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
        if (this.validateForm()) {
            let send = {
                userName : this.state.fields.userName,
                password : this.state.fields.password,
                email : ""
            }
            let fields = {};
            fields["userName"] = "";
            fields["password"] = "";
            fields["email"] = "";
            this.setState({fields:fields});
            axios.defaults.headers.common = {
                "Content-Type": "application/json"
            };


            axios.post("http://127.0.0.1:8080/auth/login", send)
                .then(res => {
                    let data = res.data;
                    console.log(data);
                    localStorage.setItem("token", data.token);
                    console.log("Bearer " + localStorage.getItem("token"));
                    window.location.pathname="/";


                })
                .catch(error => {
                    let errors = {};
                    errors["wrongCreditentials"] = "Wrong username or password";
                    this.setState({
                        errors: errors
                    });

                });

        }

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



        if (!fields["password"]) {
            formIsValid = false;
            errors["password"] = "*Please enter your password.";
        }

        this.setState({
            errors: errors
        });
        return formIsValid;


    }



    render() {
        return (
            <div id="main-registration-container">
                <div id="register">
                    <h3>Login page</h3>
                    <form method="post"  name="userRegistrationForm"  onSubmit= {this.submituserRegistrationForm} >
                        <label>Name</label>
                        <input type="text" name="userName" value={this.state.fields.userName} onChange={this.handleChange} />
                        <div className="errorMsg">{this.state.errors.username}</div>
                        <label>Password</label>
                        <input type="password" name="password" value={this.state.fields.password} onChange={this.handleChange} />
                        <div className="errorMsg">{this.state.errors.password}</div>
                        <div className="errorMsg">{this.state.errors.wrongCreditentials}</div>
                        <input type="submit" className="button"  value="Login"/>
                    </form>
                </div>
            </div>

        );
    }


}


export default LoginForm;