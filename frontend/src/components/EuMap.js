import React, {Component} from 'react';
import "../css/eu-map.css";
import {
    ComposableMap,
    ZoomableGroup,
    Geographies,
    Geography
} from "react-simple-maps"

class EuMap extends Component {

    render() {
        return (
            <div className="wrapper" >
                <ComposableMap
                    projectionConfig={{ scale: 1400 }}
                    width={1400}
                    height={1400}
                    style={{
                        width: "100%",
                        height: "auto",
                    }}
                >
                    <ZoomableGroup center={[ 10, 45 ]} disablePanning>
                        <Geographies geography="/static/world-50m.json" disableOptimization>
                            {(geographies, projection) =>
                                geographies.map((geography, i) =>
                                    this.props.codes.indexOf(geography.id) !== -1 && (
                                        <Geography
                                            key={i}
                                            geography={geography}
                                            projection={projection}
                                            className="geo"
                                            onClick={this.props.handleClick}
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