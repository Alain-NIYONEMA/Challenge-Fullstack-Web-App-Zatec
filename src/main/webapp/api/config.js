// Created by IntelliJ IDEA.
// User: Alain-NIYONEMA

const API_URL = ROOT_URL + "/api";

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
