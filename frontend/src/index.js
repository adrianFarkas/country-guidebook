import React from 'react';
import ReactDOM from 'react-dom';
import App from './pages/App';
import Country from "./pages/Country";
import {Route, BrowserRouter as Router} from "react-router-dom";
import {createStore} from 'redux';
import {Provider} from 'react-redux';
import rootReducer from './reducers/rootReducer'

const store = createStore(rootReducer);

const routing = (

    <Router>
        <Provider store={store}>
            <Route exact path="/" component={App}/>
        </Provider>
        <Route path="/country/:countryCode" component={Country}/>
    </Router>
);

ReactDOM.render(routing, document.getElementById('root'));

