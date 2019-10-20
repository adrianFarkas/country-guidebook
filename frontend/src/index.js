import React from 'react';
import ReactDOM from 'react-dom';
import App from './pages/App';
import Country from "./pages/Country";
import {Route, BrowserRouter as Router} from "react-router-dom";
import RootContextProvider from "./contexts/RootContext";
import DetailsContextProvider from "./contexts/DetailsContext";

const routing = (

    <Router>
        <RootContextProvider>
            <Route exact path="/" component={App}/>
        </RootContextProvider>
        <DetailsContextProvider>
            <Route path="/country/:countryCode" component={Country}/>
        </DetailsContextProvider>
    </Router>
);

ReactDOM.render(routing, document.getElementById('root'));

