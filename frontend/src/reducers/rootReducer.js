const rootReducer = (state, action) => {
    switch (action.type) {
        case "STORE_DATA":
            return {
                ...action.data,
                slider: getSliderData(action.data["countries"])
            };
        case "CHANGE_SLIDER":
            return {
              ...state,
              slider: action.data
            };
        case "FILTER_COUNTRIES":
            return {
                ...state,
                countries: action.data
            };
        default:
            return state;

    }
};

const getSliderData = (countryList) => {
    const population = countryList.map(country => country["geographic"]["population"]);
    const min = Math.min(...population), max = Math.max(...population);
    return {min: min, max: max, values: [min, max]}
};

export default rootReducer;