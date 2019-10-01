import React, {Component} from 'react';
import "../css/eu-map.css";
import {
    ComposableMap,
    ZoomableGroup,
    Geographies,
    Geography
} from "react-simple-maps"
import {Card} from "react-bootstrap";

class EuMap extends Component {

    handleClick(geo) {
        const path = "/country/" + geo.id.toLowerCase();
        window.location.href = path;
    }

    render() {
        return (
            <div className="col col-sm-4 map-border">
                <Card className="map-card">
                <div className="wrapper">
                    <ComposableMap
                        projectionConfig={{scale: 1400}}
                        width={1400}
                        height={1400}
                        style={{
                            width: "100%",
                            height: "auto",
                        }}
                    >
                        <ZoomableGroup center={[10, 45]} disablePanning>
                            <Geographies geography="/static/world-50m.json" disableOptimization>
                                {(geographies, projection) =>
                                    geographies.map((geography, i) =>
                                        this.props.countryCodes.indexOf(geography.id) !== -1 && (
                                            <Geography
                                                key={i}
                                                geography={geography}
                                                projection={projection}
                                                onClick={this.handleClick}
                                                className="geo"
                                            />
                                        ))
                                }
                            </Geographies>
                        </ZoomableGroup>
                    </ComposableMap>
                </div>
                </Card>
            </div>
        )
    }
}

export default EuMap;