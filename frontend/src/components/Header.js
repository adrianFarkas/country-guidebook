import React from 'react';

function Header(props) {
    return (
        <div className="header">
            <img src="/static/img/lanchid.jpg" alt="budapest"/>
                <h1>{props.country}</h1>
        </div>
    );
}

export default Header;