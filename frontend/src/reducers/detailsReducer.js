const detailsReducer = (state, action) => {
    switch (action.type) {
        case "STORE_DATA":
            return {
                details: action.data,
                rates: action.data.rates
            };
        case "SET_RATES":
            return {
                ...state,
                rates: action.data
            };
        default:
            return state;

    }
};

export default detailsReducer;