import React, {Component} from 'react';
import axios from "axios";
import GeoGraph from "../countryComponents/GeoGraph";
import {Button} from "react-bootstrap";


class CountryDetailes extends Component {


    constructor(props) {
        super(props);
        this.state = {
            isLoading: true,
            country: null,
        };
    }

    componentDidMount() {
        axios.get("http://localhost:8080/country/"+ this.props.countryCode)
            .then((res => this.setStateData(res)))
    }

    setStateData(response) {
        const countries = response.data;
        this.setState({
            country: countries,
            isLoading: false,
        })
    }

    goback(){
        window.history.back();
    }

    render() {

        return (
            !this.state.isLoading ?
                <div>
                    {
                        console.log(this.state.country)
                    }
                    <Button onClick={this.goback}>Back to Index</Button>
                    <GeoGraph country={this.state.country}></GeoGraph>
                </div>
                : <h3>Loading</h3>
        );
    }

}

export default CountryDetailes;