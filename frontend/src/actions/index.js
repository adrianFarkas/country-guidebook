export const fetchData = (data) => {
    return {
        type: 'FETCH_DATA',
        payload: data
    }
};

export const changeSlider = (data) => {
    return {
        type: 'CHANGE_SLIDER',
        payload: data
    }
};

export const filterCountries = (data) => {
    return {
        type: 'COUNTRY_FILTER',
        payload: data
    }
};