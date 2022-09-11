// Created by IntelliJ IDEA.
// User: Alain-NIYONEMA

const API_URL = "/Challenge_Fullstack_Web_App_Zatec_war_exploded/api/";

async function fetchAPI(data) {

    return await fetch(API_URL, {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json',
        },
        body: JSON.stringify(data),
    })
        .then((response) => response.json())
        .then((data) => {
            console.log('Success:', data);
        })
        .catch((error) => {
            console.error('Error:', error);
        });

}