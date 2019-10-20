import React, {useEffect, useState} from 'react';
import '../css/main.css'
import '../css/country.css'
import Header from "../components/header/Header";
import InfoLinks from "../components/InfoLinks";
import Guides from "../components/country-details/Guides";
import axios from "axios";
import {CircularProgress} from "@material-ui/core";
import ComingSoon from "../components/ComingSoon";
import CountryRating from "../components/rating/CountryRating";

function Country(props) {
    const countryCode = props.match.params.countryCode;
    const [country, setCountry] = useState({health: null});
    const [rates, setRates] = useState(null);
    const [isLoading, setIsLoading] = useState(true);

    useEffect(() => {
        axios.get("http://localhost:8080/country/" + countryCode)
            .then(res => {
                const country = res.data;
                setCountry(country);
                setRates(country.rates);
                setIsLoading(false);
            })
    }, [countryCode]);

    const sendRate = (rate) => {
        const token = localStorage.getItem("token");
        axios.defaults.headers.common['Authorization'] = `Bearer ${token}`;
        axios.post(`http://localhost:8080/country/${countryCode}/rate`, rate)
            .then(res => setRates(res.data))
            .catch(err => console.log(err.response.status));
    };

    const mainContent = country.health == null ?
        <ComingSoon/>
        :
        <div>
            <CountryRating rates={rates} sendRate={sendRate}/>
            <InfoLinks/>
            <Guides country={country}/>
        </div>;

    return (
        !isLoading ?
            <div>
                <Header
                    title={country.name}
                    img={country.logo}
                    brightness={0.4}
                />
                {mainContent}
            </div>
            :
            <div style={{width: "0", margin: "25% auto"}}>
                <CircularProgress style={{margin: "0 auto"}}/>
            </div>
    );
}

export default Country;
