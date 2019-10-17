import React, {useEffect, useState} from 'react';
import '../css/main.css'
import '../css/country.css'
import Header from "../components/Header";
import InfoLinks from "../components/InfoLinks";
import Guides from "../components/Guides";
import axios from "axios";
import {CircularProgress} from "@material-ui/core";
import ComingSoon from "../components/ComingSoon";

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
    }, []);

    const mainContent = country.health == null ?
        <ComingSoon />
        :
        <div>
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
