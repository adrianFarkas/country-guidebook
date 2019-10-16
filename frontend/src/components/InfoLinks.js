import React from 'react';
import LinkCard from "./LinkCard";
import {
    faAtlas,
    faBinoculars,
    faGlobe,
    faHandHoldingUsd,
    faHeartbeat,
    faUserGraduate
} from "@fortawesome/free-solid-svg-icons";

function InfoLinks(props) {
    return (
        <div className="info-links">
            <div className="cards">
                <LinkCard icon={faGlobe} title="Geographic" />
                <LinkCard icon={faUserGraduate} title="Education" />
                <LinkCard icon={faBinoculars} title="Sights" />
                <LinkCard icon={faHeartbeat} title="Health Care" />
                <LinkCard icon={faHandHoldingUsd} title="Finance" />
            </div>
        </div>
    );
}

export default InfoLinks;