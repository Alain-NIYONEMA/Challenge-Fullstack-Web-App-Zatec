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
