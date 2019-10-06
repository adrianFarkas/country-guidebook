import React from 'react';
import NavigationBar from "../components/NavigationBar";
import EuMap from "../components/EuMap";
import MainContent from "../components/MainContent";
import FilterForm from "../components/filter/FilterForm";
import "../css/app.css"

function App() {

    return (
            <div className="App">
                <NavigationBar text="Country Guide"/>
                <MainContent>
                    <FilterForm />
                    <EuMap />
                </MainContent>
            </div>
    );
}


export default App;
