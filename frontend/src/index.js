import React from 'react';
import ReactDOM from 'react-dom';
import App from './pages/App';
import Country from "./pages/Country";
import {Route, BrowserRouter as Router} from "react-router-dom";
import RootContextProvider from "./contexts/RootContext";

const routing = (

    <Router>
        <RootContextProvider>
            <Route exact path="/" component={App}/>
        </RootContextProvider>
        <Route path="/country/:countryCode" component={Country}/>
    </Router>
);

ReactDOM.render(routing, document.getElementById('root'));

