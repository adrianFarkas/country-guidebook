import React from 'react';
import {FontAwesomeIcon} from "@fortawesome/react-fontawesome";

function StatisticCard(props) {
    const {value, title, icon, flexDirection, textAlign} = props;
    const setBackground = () => {
        if (value < 30) return "#d93d3f";
        if (value < 60) return "#d4b03b";
        if (value < 80) return "#3b52d4";
        else return "#45d952";
    };

    const cardStyle = {
        width: "350px",
        height: "100px",
        display: "flex",
        boxShadow: "6px 6px 17px -10px rgba(0, 11, 109, 0.75)",
        flexDirection: flexDirection ? flexDirection : "row",
        alignItems: "center",
        justifyContent: "center",
        textAlign: textAlign ? textAlign : "left",
        backgroundColor: setBackground(),
        color: "#ffffff",
    };

    return (
        <div style={cardStyle} className="statistic-card">
            <div style={{width: "200px"}}>
                <div className="statistic-value"
                     style={{ fontSize: "25px", marginBottom: "10px",fontWeight: "bold",}}>{value}%</div>
                <div className="statistic-title">{title}</div>
            </div>
            <div style={{width: "40px"}} className="placeholder"/>
            <FontAwesomeIcon icon={icon} size={"3x"}/>
        </div>
    );
}

export default StatisticCard;