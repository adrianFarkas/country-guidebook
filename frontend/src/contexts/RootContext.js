import React, {createContext, useEffect, useReducer} from 'react';
import axios from "axios";
import rootReducer from "../reducers/rootReducer";

export const RootContext = createContext();

export default function RootContextProvider(props) {

    const initialState = {
        countries: [],
        languages: [],
        currencies: [],
        slider: {
            min: 0,
            max: 0,
            values: [0, 0]
        }
    };
    const [state, dispatch] = useReducer(rootReducer, initialState, () => {
        // const localData = localStorage.getItem("state");
        // return localData ? JSON.parse(localData) : initialState;
        return initialState;
    });

    useEffect(() => {
        // localStorage.setItem("state", JSON.stringify(state));
        // const data = JSON.parse(localStorage.getItem("state"));
        // if(data.languages.length === 0) fetchData();
        fetchData();
    }, []);

    const fetchData = () => {
        axios.get("http://localhost:8080/all")
            .then(res => {
                const data = res.data;
                dispatch({type: "STORE_DATA", data})
            });
    };

    const filterCountries = (languages, currency, population) => {
        const data = {
                languages,
                currency,
                "population_min" : population[0],
                "population_max" : population[1]
            };
        axios.post("http://localhost:8080/filter-countries", data)
            .then(res => {
                const data = res.data;
                dispatch({type: "FILTER_COUNTRIES", data});
            });

    };
    
    return (
        <RootContext.Provider value={{state, dispatch, fetchData, filterCountries}}>
            {props.children}
        </RootContext.Provider>
    )
}