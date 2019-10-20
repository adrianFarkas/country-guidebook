import React, {useState} from 'react';
import Rate from "./Rate";

function CountryRating(props) {
    const [hover, setHover] = useState(0);
    const [value, setValue] = useState(0);

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


    const handleChange = (event, newHover) => {
        setHover(newHover)
    };

    const handleClick = () => {
        setValue(hover);
    };

    return (
        <div style={rateBoxStyle}>
            <div style={{fontSize: "20px", fontWeight: "bold"}} className="rate-title">Rate this Country</div>
            <div style={{fontSize: "40px", fontWeight: "bold"}}>3.8</div>
            <div style={{width: "60%", margin: "5px auto 0"}}>
                <Rate
                    value={value}
                    handleChange={handleChange}
                    handleClick={handleClick}
                    hover={hover}
                />
                <Rate value={5} disabled={true} title={"(62)"}/>
                <Rate value={4} disabled={true} title={"(662)"}/>
                <Rate value={3} disabled={true} title={"(236)"}/>
                <Rate value={2} disabled={true} title={"(6)"}/>
                <Rate value={1} disabled={true} title={"(10)"}/>
            </div>
        </div>
    );
}

export default CountryRating;