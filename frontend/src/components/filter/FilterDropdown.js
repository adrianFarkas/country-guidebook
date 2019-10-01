import React, {useState} from 'react';
import Select from "@material-ui/core/Select";
import MenuItem from "@material-ui/core/MenuItem";
import InputLabel from "@material-ui/core/InputLabel";
import {Checkbox, FormControl} from "@material-ui/core";

function FilterDropdown(props) {
    const [selected, setSelected] = useState([]);

    const MenuProps = {
        PaperProps: {
            style: {
                maxHeight: 300,
                width: 400,
            },
        },
    };

    const handleChange = event => {
        setSelected(event.target.value);
    };

    const {category, data, name} = props;
    return (
        <div className="selection">
            <FormControl>
                <InputLabel>{capitalizeIfNotISOCode(category)}</InputLabel>
                <Select
                    multiple
                    className="options"
                    name={name}
                    value={selected}
                    renderValue={selected => selected.map(option => capitalizeIfNotISOCode(option)).join(", ")}
                    onChange={handleChange}
                    MenuProps={MenuProps}
                >
                {data.map((option, index) =>
                    <MenuItem key={index} value={option}>
                        <Checkbox style={{color: "#428bca"}} checked={selected.includes(option)} />
                        {capitalizeIfNotISOCode(option)}
                    </MenuItem>)}
                </Select>
            </FormControl>
        </div>
    );
}

function capitalizeIfNotISOCode(letter) {
    if (letter.length > 3) {
        const lowercase = letter.toLowerCase();
        return lowercase.charAt(0).toUpperCase() + lowercase.slice(1)
    }
    return letter;
}


export default FilterDropdown;