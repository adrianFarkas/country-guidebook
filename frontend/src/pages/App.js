import React from 'react';
import EuMap from "../components/EuMap";
import MainContent from "../components/MainContent";
import FilterForm from "../components/filter/FilterForm";
import "../css/app.css"
import "../css/main.css"
import Header from "../components/header/Header";

function App() {

    return (
            <div className="App">
                <Header
                    title="Country Guide"
                    text="The place where your journey begins!"
                    img="header.jpg"
                    brightness={0.4}
                />
                <MainContent>
                    <FilterForm />
                    <EuMap />
                </MainContent>
            </div>
    );
}


export default App;
