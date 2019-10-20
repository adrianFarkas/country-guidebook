import React, {useContext} from 'react';
import {
    ComposableMap,
    ZoomableGroup,
    Geographies,
    Geography
} from "react-simple-maps"
import {RootContext} from "../contexts/RootContext";

function EuMap(props) {
    const {state} = useContext(RootContext);
    const countryCodes = state.countries.map(country => country["geographic"]["alpha3Code"]);

    return (
            <div className="wrapper">
                <ComposableMap
                    projectionConfig={{scale: 950}}
                    width={1000}
                    height={800}
                    style={{
                        width: "100%",
                        height: "auto",
                    }}
                >
                    <ZoomableGroup center={[10, 50]} disablePanning>
                        <Geographies geography="/static/world-50m.json" disableOptimization>
                            {(geographies, projection) =>
                                geographies.map((geography, i) =>
                                    countryCodes.indexOf(geography.id) !== -1 && (
                                        <Geography
                                            key={i}
                                            geography={geography}
                                            projection={projection}
                                            onClick={handleClick}
                                            className="geo"
                                        />
                                    ))
                            }
                        </Geographies>
                    </ZoomableGroup>
                </ComposableMap>
            </div>
    )
}

function handleClick(geo) {
    const path = "/country/" + geo.id.toLowerCase();
    window.location.href = path;
}

export default EuMap;