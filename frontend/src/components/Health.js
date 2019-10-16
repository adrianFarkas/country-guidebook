import React from 'react';
import Guide from "./Guide";
import StatisticCard from "./StatisticCard";
import {faHourglassHalf, faStethoscope, faTachometerAlt, faUserMd} from "@fortawesome/free-solid-svg-icons";


function Health(props) {
    const {skill, speed, equipment, satisfaction} = props.health;

    const cardStyle = {
        color: "#ffffff",
        width: "300px"
    };

    return (
        <Guide title="Health Care" id="Health Care">
            <div style={cardStyle}>
                <StatisticCard
                    value={skill}
                    title={"Competency of Staff"}
                    icon={faUserMd}
                />
                <StatisticCard
                    value={speed}
                    title={"Speed of Completing Reports"}
                    icon={faTachometerAlt}
                    flexDirection={"row-reverse"}
                    textAlign={"right"}
                />
                <StatisticCard
                    value={equipment}
                    title={"Equipment for Modern Diagnosis and Treatment"}
                    icon={faStethoscope}
                />
                <StatisticCard
                    value={satisfaction}
                    title={"Satisfaction with Responsiveness"}
                    icon={faHourglassHalf}
                    flexDirection={"row-reverse"}
                    textAlign={"right"}
                />
            </div>
        </Guide>
    );
}

export default Health;