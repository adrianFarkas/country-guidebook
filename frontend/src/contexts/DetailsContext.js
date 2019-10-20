import React, {createContext, useReducer} from 'react';
import detailsReducer from "../reducers/detailsReducer";
import axios from "axios";
import {NotificationContainer} from "react-light-notifications";
import "react-light-notifications/lib/main.css";
import {loginAlert, successRate} from "../alerts";

export const DetailsContext = createContext();

export default function DetailsContextProvider(props) {

    const initialSate = {
        details: {},
        rates: [],
    };

    const [country, dispatch] = useReducer(detailsReducer, initialSate);

    const setCountryDetails = (countryCode) => {
        axios.get("http://localhost:8080/country/" + countryCode)
            .then(res => {
                const data = res.data;
                dispatch({type: "STORE_DATA", data});
            })
    };

    const submitRating = (rate) => {
        const countryCode = country.details["geographic"]["alpha3Code"];
        const token = localStorage.getItem("token");
        axios.defaults.headers.common['Authorization'] = `Bearer ${token}`;
        return axios.post(`http://localhost:8080/country/${countryCode}/rate`, rate)
            .then(res => {
                const data = res.data;
                dispatch({type: "SET_RATES", data});
                successRate();
                return res;
            })
            .catch(err => {
                if (err.response.status === 403) loginAlert();
                return err.response;
            });
    };

    return (
        <DetailsContext.Provider value={{country, dispatch, setCountryDetails, submitRating}}>
            {props.children}
            <NotificationContainer/>
        </DetailsContext.Provider>
    );
}

