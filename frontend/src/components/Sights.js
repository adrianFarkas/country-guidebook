import React, {useState} from 'react';
import SightCard from "./SightCard";
import '../css/sights.css'
import {FontAwesomeIcon} from "@fortawesome/react-fontawesome";
import {faAngleLeft, faAngleRight} from "@fortawesome/free-solid-svg-icons";

function Sights(props) {
    const properties = props.sights;
    const [index, setIndex] = useState(0);

    const nextProperty = () => {
        const newIndex = index + 1;
        setIndex(newIndex);
    };

    const prevProperty = () => {
        const newIndex = index - 1;
        setIndex(newIndex);
    };

    return (
        <div className="detail-card" id="Sights">
            <h1>Sightseeing</h1>
            <hr/>
            <div className="sights">

                <div className="page">

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
            </div>
        </div>
    );
}

export default Sights;
