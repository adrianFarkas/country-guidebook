import React, {createContext, useEffect, useReducer} from 'react';
import axios from "axios";
import rootReducer from "../reducers/rootReducer";

export const RootContext = createContext();

export default function RootContextProvider(props) {
    // const [countries, setCountries] = useState([]);
    // const [languages, setLanguages] = useState([]);
    // const [currencies, setCurrencies] = useState([]);
    // const [slider, setSlider] = useState({min: 0, max: 0, values: [0, 0]});
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
        const localData = localStorage.getItem("state");
        return localData ? JSON.parse(localData): initialState;
    });

    useEffect(() => {
        localStorage.setItem("state", JSON.stringify(state));
        const data = JSON.parse(localStorage.getItem("state"));
        if(data.languages.length === 0) fetchData();
    }, [state]);

    const fetchData = () => {
        console.log("fut");
        axios.get("http://localhost:8080/all")
            .then(res => {
                const data = res.data;
                dispatch({type: "STORE_DATA", data})
            });
    };
    //
    // const changeSlider = (newData) => {
    //   setSlider(newData);
    // };
    //
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
                dispatch({type: "FILTER_COUNTRIES", data})
            });

    };

    // const values = {countries, languages, currencies, slider, fetchData, changeSlider, filterCountries};

    return (
        <RootContext.Provider value={{state, dispatch, fetchData, filterCountries}}>
            {props.children}
        </RootContext.Provider>
    )
}