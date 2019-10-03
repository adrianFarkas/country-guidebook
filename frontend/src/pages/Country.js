import React from 'react';
import '../css/main.css'
import '../css/country.css'
import NavigationBar from "../components/NavigationBar";
import Header from "../components/Header";
import InfoLinks from "../components/InfoLinks";
import Guides from "../components/Guides";

function Country(props) {
    return (
        <div>
            <NavigationBar/>
            <Header />
            <InfoLinks />
            <Guides />
        </div>
    );
}

export default Country;
