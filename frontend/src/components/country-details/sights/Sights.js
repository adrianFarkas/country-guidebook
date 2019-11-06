import React, {useContext, useState} from 'react';
import SightCard from "./SightCard";
import '../../../css/sights.css'
import {FontAwesomeIcon} from "@fortawesome/react-fontawesome";
import {faAngleLeft, faAngleRight} from "@fortawesome/free-solid-svg-icons";
import Guide from "../Guide";
import {DetailsContext} from "../../../contexts/DetailsContext";

function Sights(props) {
    const {country} = useContext(DetailsContext);
    const properties = country.details.sights;
    const [index, setIndex] = useState(2);

    const nextProperty = () => {
        const newIndex = index + 1;
        setIndex(newIndex);
    };

    const prevProperty = () => {
        const newIndex = index - 1;
        setIndex(newIndex);
    };

    return (
            <Guide title="Sightseeing" id="Sights">

                <div className="sights">

                    <div className="buttons">
                        <button
                            className="back-btn"
                            onClick={() => prevProperty()}
                            disabled={index === 0}
                        >
                            <FontAwesomeIcon icon={faAngleLeft}/>
                        </button>

                        <button
                            className="next-btn"
                            onClick={() => nextProperty()}
                            disabled={index === properties.length - 1}
                        >
                            <FontAwesomeIcon icon={faAngleRight}/>
                        </button>
                    </div>
                    <div className="col">
                        <div className={`cards-slider active-slide-${index}`}>
                            <div className="cards-slider-wrapper" style={{
                                'transform': `translateX(-${index * (100 / properties.length)}%)`
                            }}>
                                {
                                    properties.map(property => <SightCard key={property.id} property={property}/>)
                                }
                            </div>
                        </div>
                    </div>

                </div>

            </Guide>
    );
}

export default Sights;
