// Created by IntelliJ IDEA.
// User: Alain-NIYONEMA


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