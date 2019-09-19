import React, {Component} from 'react';
import {ThemeProvider} from '@material-ui/styles';
import "../../css/selected_country.css"

class GeoGraph extends Component {




    render() {
        console.log(this.props.country);
        let currencies = this.props.country.currencies.map(function (currency) {
            return <td>{currency}</td>

        });

        let languages = this.props.country.languages.map(function (language){
            return <td>{language}</td>
        });
        const theme = {
            background: 'linear-gradient(45deg, #FE6B8B 30%, #FF8E53 90%)',
        };

        return <div id="mainDiv">
            <ThemeProvider theme={theme}>
                <table>
                    <tr>
                        <td>Country: </td>
                        <td>{this.props.country.name}</td>
                    </tr>
                    <tr>
                        <td>Capital city: </td>
                        <td>{this.props.country.capital}</td>
                    </tr>
                    <tr>
                        <td>Country area: </td>
                        <td>{this.props.country.area} km<sup>2</sup></td>
                    </tr>
                    <tr>
                        <td>Population: </td>
                        <td>{this.props.country.population}</td>
                    </tr>
                    <tr>
                        <td>Sub region: </td>
                        <td>{this.props.country.capital}</td>
                    </tr>
                    <tr>
                        <td>Currencies: </td>
                        {currencies}
                    </tr>
                    <tr>
                        <td>Languages: </td>
                        {languages}
                    </tr>
                    <tr><a href="https://en.wikipedia.org/wiki/Netherlands">Wikipedia Netherlands</a></tr>
                </table>


            </ThemeProvider>

        </div>
    }
}

export default GeoGraph;


