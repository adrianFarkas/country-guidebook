import React, {createContext, useReducer} from 'react';
import detailsReducer from "../reducers/detailsReducer";
import axios from "axios";


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
        axios.post(`http://localhost:8080/country/${countryCode}/rate`, rate)
            .then(res => {
                const data = res.data;
                dispatch({type: "SET_RATES", data})
            })
            .catch(err => console.log(err.response.status));
    };

    return (
        <DetailsContext.Provider value={{country, dispatch, setCountryDetails, submitRating}}>
            {props.children}
        </DetailsContext.Provider>
    );
}

