import React, {Component} from 'react';

class FilterDropdown extends Component {
    render() {
        return (
            <div className="selection">
                <label className="label">Sort by</label>
                <select className="options">
                    <option value="1">Option 1</option>
                    <option value="2">Option 2</option>
                    <option value="3">Option 3</option>
                    <option value="4">Option 4</option>
                    <option value="5">Option 5</option>
                </select>
            </div>
        );
    }
}

export default FilterDropdown;