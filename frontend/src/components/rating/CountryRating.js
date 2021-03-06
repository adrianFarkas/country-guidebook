import React, {useContext, useEffect, useState} from 'react';
import Rate from "./Rate";
import {DetailsContext} from "../../contexts/DetailsContext";
import axios from "axios";

function CountryRating(props) {
    const {country, submitRating} = useContext(DetailsContext);

    const [hover, setHover] = useState(0);
    const [value, setValue] = useState(0);

    const {rates, details} = country;
    const countryCode = details["geographic"]["alpha3Code"];

    useEffect(() => {
        const token = localStorage.getItem("token");
        if(token === null) return;
        axios.defaults.headers.common['Authorization'] = `Bearer ${token}`;
        axios.get(`http://localhost:8080/country/${countryCode}/rate`)
            .then(res => {
                const data = res.data;
                setValue(data.rate);
            });
    }, [countryCode]);

    const rateBoxStyle = {
        width: "280px",
        height: "280px",
        borderRadius: "20px",
        position: "absolute",
        right: "0",
        margin: "-315px 5px 0",
        background: "rgba(145,145,145,0.6)",
        textAlign: "center"
    };


    const getNumberOfRatesByValue = (number) => {
        return rates.filter(r => r.rate === number).length;
    };

    const getAverageRate = () => {
        if(rates.length === 0) return (0).toFixed(1);
        const ratesValues = rates.map(r => r.rate);
        let sum = ratesValues.reduce((a, b) => a + b, 0);
        return (sum / rates.length).toFixed(1);
    };

    const handleChange = (event, newHover) => {
        setHover(newHover)
    };

    const handleClick = () => {
        submitRating({rate: hover})
            .then(res => res.status === 403 ? setValue(0) : setValue(hover))
    };

    return (
        <div style={rateBoxStyle}>
            <div style={{fontSize: "20px", fontWeight: "bold"}} className="rate-title">Rate this Country</div>
            <div style={{fontSize: "40px", fontWeight: "bold"}}>{getAverageRate()}</div>
            <div style={{width: "60%", margin: "5px auto 0"}}>
                <Rate
                    value={value}
                    handleChange={handleChange}
                    handleClick={handleClick}
                    hover={hover}
                />
                <Rate value={5} disabled={true} title={`(${getNumberOfRatesByValue(5)})`}/>
                <Rate value={4} disabled={true} title={`(${getNumberOfRatesByValue(4)})`}/>
                <Rate value={3} disabled={true} title={`(${getNumberOfRatesByValue(3)})`}/>
                <Rate value={2} disabled={true} title={`(${getNumberOfRatesByValue(2)})`}/>
                <Rate value={1} disabled={true} title={`(${getNumberOfRatesByValue(1)})`}/>
            </div>
        </div>
    );
}

export default CountryRating;