// Created by IntelliJ IDEA.
// User: Alain-NIYONEMA

// end-point of our API
const API_URL = ROOT_URL + "/api";

// function to call our API end-point with a GET or POST method
async function fetchAPI(url, method, data) {

    if(method !== "GET") {

        url = appendUrlParameters(url, data);

        return await fetch(url, {
            method: method,
            headers: {
                'Content-Type': 'application/json',
            },
            body: JSON.stringify(data),
        }).then((response) => {
            return response.json();
        })

    }else {

        url = appendUrlParameters(url, data);

        return await fetch(url, {
            method: 'GET',
            headers: {
                'Content-Type': 'application/json',
            },
        }).then((response) => {
            return response.json();
        })

    }

}
