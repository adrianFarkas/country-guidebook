import React from "react";
import "../css/main.css"

function MainContent(props) {
    return (
        <div className="cont">
            {props.children}
        </div>
    )
}

export default MainContent