// Created by IntelliJ IDEA.
// User: Alain-NIYONEMA

async function getHouse(id) {

    const data = {
        id: `${id}`
    };

    return await fetchAPI(API_URL,'GET', data);
}


async function getHouses(keyword, page=1, pageSize=10) {

    const data = {
        name: `${keyword}`,
        page: `${page}`,
        pageSize:`${pageSize}`
    };

    return await fetchAPI(API_URL, 'GET', data);
}


async function searchHouses(keyword, page=1, pageSize=10) {

    const data = {
        name: `${keyword}`,
        page: `${page}`,
        pageSize: `${pageSize}`
    };

    return await fetchAPI(API_URL, 'POST', data);
}
