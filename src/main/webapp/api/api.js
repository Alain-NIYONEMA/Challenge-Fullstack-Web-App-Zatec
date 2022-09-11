// Created by IntelliJ IDEA.
// User: Alain-NIYONEMA

async function getHouse(id) {
    const data = { id: `${id}` };
    return await fetchAPI('POST', data);
}

async function getHouses() {
    const data = { };
    return await fetchAPI('GET', data);
}

async function searchHouses(keyword) {
    const data = { name: `${keyword}` };
    return await fetchAPI('POST', data);
}