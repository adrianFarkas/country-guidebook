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
    const [isLoading, setIsLoading] = useState(true);

    useEffect(() => {
        axios.get("http://localhost:8080/country/" + countryCode)
            .then(res => {
                const country = res.data;
                setCountry(country);
                setIsLoading(false);
            })
    }, [countryCode]);

    const mainContent = country.health == null ?
        <ComingSoon />
        :
        <div>
            <CountryRating />
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
