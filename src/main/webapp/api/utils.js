// Created by IntelliJ IDEA.
// User: Alain-NIYONEMA


// append URL parameters
function appendUrlParameters(url, data) {

    if(data != null) {

        if(!url.includes("?")) {
            url += "?";
        }

        for (const key in data) {
            const value = data[key];
            url += "&"+ key + "=" + value;
        }
    }

    return url;
}


// retrieve a value of a parameter from the url
function getUrlParameter(name) {
    name = name.replace(/[\[]/, '\\[').replace(/[\]]/, '\\]');
    const regex = new RegExp('[\\?&]' + name + '=([^&#]*)');
    const results = regex.exec(location.search);
    return results === null ? '' : decodeURIComponent(results[1].replace(/\+/g, ' '));
}


// check if a variable is empty
function isEmpty(data) {
    return data === undefined || (""+data).trim().length === 0;
}


// get list of related houses
function getRelatedHouses(data) {
    let houses = '';
    data = (""+data).split(",");
    for(let i=0; i<data.length; i++) {
        let house = (""+data[i]).replace("/", ": ");
        let id = house.replace("houses: ", "")
        houses += `<a href="${ROOT_URL}?id=${id}"> ${house} </a>`;
    }
    return houses;
}

// get list of related characters
function getRelatedCharacters(data) {
    let characters = '';
    data = (""+data).split(",");
    for(let i=0; i<data.length; i++) {
        let character = (""+data[i]).replace("/", ": ");
        let id = character.replace("characters: ", "")
        characters += `<a href="${ROOT_URL}?id=${id}"> ${character} </a>`;
    }
    if(data.length > 0) {
        return data.length + " Character" +(data.length > 1 ? 's' : '');
    }
    return characters;
}
