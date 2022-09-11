// Created by IntelliJ IDEA.
// User: Alain-NIYONEMA

async function getHouse(id) {
    const data = { id: `${id}` };
    return await fetchAPI(data);
}

async function getHouses() {
    return await fetchAPI();
}