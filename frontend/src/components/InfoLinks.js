import React from 'react';
import LinkCard from "./LinkCard";

function InfoLinks(props) {
    return (
        <div className="info-links">
            <div className="cards">
                <LinkCard img="/static/img/education.png" title="Education" />
                <LinkCard img="/static/img/geographic.png" title="Geographic" />
                <LinkCard img="/static/img/health.png" title="Health Care" />
                <LinkCard img="/static/img/finance.png" title="Finance" />
            </div>
        </div>
    );
}

export default InfoLinks;