import React from 'react';
import ReactDOM from 'react-dom';
import App from './pages/App';
import Country from "./pages/Country";
import {Route, BrowserRouter as Router} from "react-router-dom";


const routing = (
    <Router>
        <Route exact path="/" component={App}/>
        <Route path="/" component={Country}/>
    </Router>
);

ReactDOM.render(routing, document.getElementById('root'));

