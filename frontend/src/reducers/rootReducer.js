const initialState =  {
    countries: [],
    languages: [],
    currencies: [],
    slider: {
        min: 0,
        max: 0,
        values: [0, 0]
    }
};

const rootReducer = (state = initialState, action) => {
    switch (action.type) {
        case "FETCH_DATA":
            const data = action.payload;
            return {
                ...data,
                slider: getSliderData(data["countries"])
            };
        case "CHANGE_SLIDER":
            return {
              ...state,
              slider: action.payload
            };
        case "COUNTRY_FILTER":
            return {
                ...state,
                countries: action.payload
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