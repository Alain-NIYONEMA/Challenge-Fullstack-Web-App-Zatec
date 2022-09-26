// Created by IntelliJ IDEA.
// User: Alain-NIYONEMA

// get a specific house from the api basing on it's ID
async function getHouse(id) {

    const data = {
        id: `${id}`
    };

    return await fetchAPI(API_URL,'GET', data);
}

// get a list of houses with a filtering applied with items limit and page size
async function getHouses(keyword, page=1, pageSize=10, match=false, filter="") {

    const data = {
        name: `${keyword}`,
        page: `${page}`,
        pageSize:`${pageSize}`,
        match:`${match}`,
        filter: `${filter}`
    };

    return await fetchAPI(API_URL, 'GET', data);
}

// search for houses basing on the given keyword
async function searchHouses(keyword, page=1, pageSize=10, match=false, filter="") {

    const data = {
        name: `${keyword}`,
        page: `${page}`,
        pageSize: `${pageSize}`,
        match: `${match}`,
        filter: `${filter}`
    };

    return await fetchAPI(API_URL, 'POST', data);
}
