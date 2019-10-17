import React from 'react';

function CorruptionIndex(props) {
    const {value} = props;

    const borderColor = () => {
        if (value < 31) return "#952a2b";
        if (value < 41) return "#d93d3f";
        if (value < 51) return "#d48440";
        if (value < 61) return "#d4b03b";
        if (value < 71) return "#75aeff";
        if (value < 81) return "#3b52d4";
        else return "#45d952";
    };

    const cardStyle = {
        width: "200px",
        height: "200px",
        margin: "0 auto",
        border: "8px solid " + borderColor(),
        backgroundColor: borderColor(),
        borderRadius: "50%",
        textAlign: "center",
        color: "#ffffff"

    };

    return (
        <div style={cardStyle} className="corruption">
            <div style={{margin: "60px auto 0", fontSize: "30px", fontWeight: "bold"}} className="corruption-index">
                {value}
            </div>
            <div style={{margin: "10px auto 0"}} className="corruption-title">
                Corruption Index
            </div>
        </div>
    );
}

export default CorruptionIndex;