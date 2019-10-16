import React from 'react';
import useForm from "./useForm";
import validate from './LoginFormValidationRules';
import axios from "axios";

const Form = () => {
    const {
        values,
        errors,
        handleChange,
        handleSubmit,
    } = useForm(login, validate);

    function login() {

        const user = {
            name: this.state.name
        };

        axios.post(`https://jsonplaceholder.typicode.com/users`, { user })
            .then(res => {
                console.log(res);
                console.log(res.data);
            })
        console.log('No errors, submit callback called!');
        axios.get("http://localhost:8080/auth/login")
            .then(res => {
                const country = res.data;

            })
    }


    return (
        <div className="section is-fullheight">
            <div className="container">
                <div className="column is-4 is-offset-4">
                    <div className="box">
                        <form onSubmit={handleSubmit} noValidate>
                            <div className="field">
                                <label className="label">Email Address</label>
                                <div className="control">
                                    <input autoComplete="off" className={`input ${errors.email && 'is-danger'}`} type="email" name="email" onChange={handleChange} value={values.email || ''} required />
                                    {errors.email && (
                                        <p className="help is-danger">{errors.email}</p>
                                    )}
                                </div>
                            </div>
                            <div className="field">
                                <label className="label">Password</label>
                                <div className="control">
                                    <input className={`input ${errors.password && 'is-danger'}`} type="password" name="password" onChange={handleChange} value={values.password || ''} required />
                                </div>
                                {errors.password && (
                                    <p className="help is-danger">{errors.password}</p>
                                )}
                            </div>
                            <button type="submit" className="button is-block is-info is-fullwidth">Login</button>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    );
};

export default Form;