import React, {useEffect} from 'react';
import Header from "../components/Header";
import EuMap from "../components/EuMap";
import MainContent from "../components/MainContent";
import FilterForm from "../components/filter/FilterForm";
import { connect } from 'react-redux';
import { fetchData } from "../actions/index";
import "../css/app.css"
import axios from "axios"


function App(props) {


    useEffect(() => {
        axios.get("http://localhost:8080/all")
            .then(res => props.fetchData(res.data))
    }, []);

    return (
            <div className="App">
                <Header text="Country Guide"/>
                <MainContent>
                    <FilterForm />
                    <EuMap />
                </MainContent>
            </div>
    );
}


export default connect(null, {fetchData})(App);
