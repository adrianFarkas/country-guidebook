import React, {Component} from 'react';

import Header from "../components/Header";
import CountryDetailes from "../components/countryComponents/CountryDetailes";


class Country extends Component {



    render() {
        let countryCode = this.props.match.params.countryCode;
        return (
                <div>
                    <Header></Header>
                    <CountryDetailes countryCode = {countryCode}></CountryDetailes>
                </div>
        );
    }

}

export default Country;