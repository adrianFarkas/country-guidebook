import React, {useContext, useEffect} from 'react';
import '../css/main.css'
import '../css/country.css'
import Header from "../components/header/Header";
import InfoLinks from "../components/InfoLinks";
import Guides from "../components/country-details/Guides";
import {CircularProgress} from "@material-ui/core";
import ComingSoon from "../components/ComingSoon";
import CountryRating from "../components/rating/CountryRating";
import {DetailsContext} from "../contexts/DetailsContext";

function Country(props) {
    const countryCode = props.match.params.countryCode;
    const {country, setCountryDetails} = useContext(DetailsContext);

    const {name, logo, health} = country.details;


    useEffect(() => {
        setCountryDetails(countryCode);
    }, [countryCode]);


    const mainContent = health == null ?
        <ComingSoon/>
        :
        <div>
            <CountryRating />
            <InfoLinks/>
            <Guides />
        </div>;

    return (
        name ?
            <div>
                <Header
                    title={name}
                    img={logo}
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
