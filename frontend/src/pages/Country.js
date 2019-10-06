import React, {useEffect, useState} from 'react';
import '../css/main.css'
import '../css/country.css'
import NavigationBar from "../components/NavigationBar";
import Header from "../components/Header";
import InfoLinks from "../components/InfoLinks";
import Guides from "../components/Guides";
import axios from "axios";

function Country(props) {
    const countryCode = props.match.params.countryCode;
    const [country, setCountry] = useState(null);
    const [isLoading, setIsLoading] = useState(true);

    useEffect(() => {
        axios.get("http://localhost:8080/country/"+countryCode)
            .then(res => {
                const country = res.data;
                setCountry(country);
                setIsLoading(false);
            })
    }, []);

    return (
        !isLoading ?
            <div>
            <NavigationBar/>
            <Header country={country.name} />
            <InfoLinks />
            <Guides country={country} />
        </div>
            :
            <div>Loading...</div>
    );
}

export default Country;
