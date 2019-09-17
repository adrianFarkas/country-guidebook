import React, {Component} from 'react';
import "../css/eu-map.css";
import {
    ComposableMap,
    ZoomableGroup,
    Geographies,
    Geography
} from "react-simple-maps"

const include = [
    "AUT", "BEL", "BGR", "HRV", "CYP", "CZE", "DNK", "EST", "FIN", "FRA", "DEU", "GRC", "HUN", "IRL",
    "ITA", "LVA", "LTU", "LUX", "MLT", "NLD", "POL", "PRT", "ROU", "SVK", "SVN", "ESP", "SWE", "GBR"
];

class EuMap extends Component {
    constructor(props) {
        super(props);
        this.handleClick = this.handleClick.bind(this);
    }

    handleClick(geography) {
        window.location.href = '/countries/'+geography.properties.name;
    };
    render() {
        return (
            <div className="wrapper" >
                <ComposableMap
                    projectionConfig={{ scale: 1200 }}
                    width={1400}
                    height={1400}
                    style={{
                        width: "100%",
                        height: "auto",
                    }}
                >
                    <ZoomableGroup center={[ 10, 45 ]} disablePanning>
                        <Geographies geography="/static/world-50m.json">
                            {(geographies, projection) =>
                                geographies.map((geography, i) =>
                                    include.indexOf(geography.id) !== -1 && (
                                        <Geography
                                            key={i}
                                            geography={geography}
                                            projection={projection}
                                            className="geo"
                                            onClick={this.handleClick}
                                        />
                                    ))
                            }
                        </Geographies>
                    </ZoomableGroup>
                </ComposableMap>
            </div>

        )
    }
}

export default EuMap;