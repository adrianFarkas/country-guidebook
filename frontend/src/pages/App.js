import React, {Component} from 'react';
import Header from "../components/Header";
import EuMap from "../components/EuMap";

import FilterForm from "../components/filter/FilterForm";

class App extends Component {
    constructor(props){
        super(props);
        this.state = {
            isLoading: true,
            countries: [],
            codes: []
        };
        this.handleClick = this.handleClick.bind(this);
    }


    componentDidMount() {
        fetch("http://localhost:8080/")
            .then(data => data.json())
            .then(res => this.setState({
                countries: res,
                isLoading: false,
                codes: this.getCountryCodes(res)
            }));
    }

    handleClick() {
        this.setState(prevState => prevState.codes = ["HUN"])
    }

    getCountryCodes(countryList) {
        const codes = [];
        countryList.map(country => codes.push(country.alpha3Code));
        return codes;
    }

    render() {
        return (
            <div className="App">
                <Header text="Country Guide"/>
                <FilterForm />
                <EuMap handleClick={this.handleClick} codes={this.state.codes}/>
            </div>
        );
    }
}

export default App;
