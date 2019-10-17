import React from 'react';
import NavigationBar from "./NavigationBar";

function Header(props) {
    const brightness = props.brightness ? props.brightness : 1;

    return (
        <div className="header">
            <NavigationBar />
            <h1>{props.title}</h1>
            <div className="header-text">{props.text}</div>
            <img src={"/static/img/country_headers/" + props.img} style={{ filter: "brightness(" + brightness + ")" }} alt=""/>
        </div>
    );
}

export default Header;