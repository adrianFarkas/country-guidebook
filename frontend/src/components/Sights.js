import React, {useState} from 'react';
import SightCard from "./SightCard";
import '../css/sights.css'
import {FontAwesomeIcon} from "@fortawesome/react-fontawesome";
import {faAngleLeft, faAngleRight} from "@fortawesome/free-solid-svg-icons";

const data = [
    {
        id: "593e9297e17df20c4a237d42",
        index: 0,
        picture: "/static/img/sights/buda-castle.jpg",
        city: "BP",
        title: "Buda Castle",
    },
    {
        id: "593e9297e17df21c4a237d42",
        index: 1,
        picture: "/static/img/sights/szechenyi-bath.jpg",
        city: "BP",
        title: "Szechenyi Bath",
    },
    {
        id: "593e9297e17df20c4a237d02",
        index: 2,
        picture: "/static/img/sights/buda-hills.jpg",
        city: "BP",
        title: "Buda Hills",
    },
    {
        id: "593e92297e17df20c4a237d02",
        index: 3,
        picture: "/static/img/sights/eger-castle.jpg",
        city: "BP",
        title: "Eger castle",
    },
    {
        id: "593e9297se17df20c4a237d02",
        index: 4,
        picture: "/static/img/sights/danube.jpg",
        city: "Budapest",
        title: "Danube",

    }
];

function Sights(props) {
    const [properties, setProperties] = useState(data);
    const [property, setProperty] = useState(properties[0]);

    const nextProperty = () => {
        const newIndex = property.index + 1;
        setProperty(properties[newIndex]);
    };

    const prevProperty = () => {
        const newIndex = property.index - 1;
        setProperty(properties[newIndex]);
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
                            disabled={property.index === 0}
                        >
                            <FontAwesomeIcon icon={faAngleLeft}/>
                        </button>

                        <button
                            className="next-btn"
                            onClick={() => nextProperty()}
                            disabled={property.index === properties.length - 1}
                        >
                            <FontAwesomeIcon icon={faAngleRight}/>
                        </button>
                    </div>
                    <div className="col">
                        <div className={`cards-slider active-slide-${property.index}`}>
                            <div className="cards-slider-wrapper" style={{
                                'transform': `translateX(-${property.index * (100 / properties.length)}%)`
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
