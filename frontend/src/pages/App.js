import React from 'react';
import Header from "../components/Header";
import EuMap from "../components/EuMap";
import FilterForm from "../components/filter/FilterForm";

function App() {
    return (
        <div className="App">
            <Header text="Country Guide"/>
            <FilterForm/>
            <EuMap/>
        </div>
    );
}

export default App;
