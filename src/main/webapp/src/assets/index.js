// Created by IntelliJ IDEA.
// User: Alain-NIYONEMA


// initialize PARAMETERS
let keyword = "";
let page = 1;
let pageSize = 6;
let match = false;


// initialize VIEWS
const viewBack = document.querySelector(".ztc-alain-nav__top-menu-back");
const viewRefresh = document.querySelector(".ztc-alain-nav__top-menu-refresh");


// load initial data
onLoadHouses();


// onSubmit "SEARCH"
document.querySelector(".ztc-alain-search-form").addEventListener("submit", function (e) {
    e.preventDefault();

    // get typed keyword
    keyword = document.querySelector(".ztc-alain-search-form input").value;

    if(keyword.length < 3) {
        return;
    }

    // switch views
    routeViews();
    
    // call 'search' function
    onSearchHouses();

});


// onChange "SEARCH typing"
document.querySelector(".ztc-alain-search-form input").addEventListener("change", function (e) {
    e.preventDefault();

    // get typed keyword
    keyword = document.querySelector(".ztc-alain-search-form input").value;

    if(keyword.length < 3) {
        document.querySelector(".ztc-alain-search-form button").setAttribute("disabled", true);
    }else {
        document.querySelector(".ztc-alain-search-form button").removeAttribute("disabled");
    }

});


// onClick "LOAD-MORE"
document.querySelector(".ztc-alain-load-more-btn").addEventListener("click", function () {

    // call 'loadMore' function
    onLoadMoreHouses();

});


// onChange "FILTER - Size"
document.querySelector(".ztc-alain-houses-filter-size select").addEventListener("change", function () {

    // update "pageSize" value
    pageSize = parseInt(this.value);

    // call 'loadData' function
    onLoadHouses();

});


// onChange "FILTER - Match"
document.querySelector(".ztc-alain-houses-filter-match input").addEventListener("change", function () {

    // update "pageSize" value
    match = this.checked;

    // call 'loadData' function
    onLoadHouses();

});


// on "LOAD" HOUSES
function onLoadHouses () {

    // reset page number
    page = 1;

    // clear view list
    document.querySelector(".ztc-alain-houses-list").innerHTML = "";

    // show a loader
    document.querySelector(".ztc-alain-houses-list").classList.add("ztc-alain-loader");
    document.querySelector(".ztc-alain-load-more").style.display = "none";

    // fetch API
    getHouses(keyword, page, pageSize, match)
        .then((response) => {

            const counts = parseInt(response.counts);
            const houses = JSON.parse(response.data);

            if(counts > 0) {
                // build items views
                const housesHTML = houses.map((itemHouse, index) => {
                        return viewHouseItemCard(itemHouse, index);
                    }
                ).join('');

                // update view list
                document.querySelector(".ztc-alain-houses-list").innerHTML = housesHTML;
            }else {
                document.querySelector(".ztc-alain-houses-list").innerHTML = `
                    <div class='empty-houses'>
                        <p>No house found</p>
                    </div>
                `;
            }

            // remove loader
            document.querySelector(".ztc-alain-houses-list").classList.remove("ztc-alain-loader");

            // show load more
            if(counts === pageSize) {
                document.querySelector(".ztc-alain-load-more").style.display = "block";
            }

        })
        .catch((error) => {
            console.error('Houses-Error:', error);
        });

}


// on "SEARCH" Houses
function onSearchHouses() {

    // reset page number
    page = 1;

    // clean view items
    document.querySelector(".ztc-alain-houses-list").innerHTML = "";

    // show a loader
    document.querySelector(".ztc-alain-houses-list").classList.add("ztc-alain-loader");
    document.querySelector(".ztc-alain-load-more").style.display = "none";

    // fetch API
    searchHouses(keyword, page, pageSize, match)
        .then((response) => {

            const counts = parseInt(response.counts);
            const houses = JSON.parse(response.data);

            if(counts) {
                // build items views
                const housesHTML = houses.map((itemHouse, index) => {
                        return viewHouseItemCard(itemHouse, index);
                    }
                ).join('');

                // update view list
                document.querySelector(".ztc-alain-houses-list").innerHTML = housesHTML;
            }else {
                document.querySelector(".ztc-alain-houses-list").innerHTML = `
                    <div class='empty-houses'>
                        <p>No house found</p>
                    </div>
                `;
            }

            // remove loader
            document.querySelector(".ztc-alain-houses-list").classList.remove("ztc-alain-loader");

            // show load more
            if(counts === pageSize) {
                document.querySelector(".ztc-alain-load-more").style.display = "block";
            }

        })
        .catch((error) => {
            console.error('Search-Error:', error);
        });

}


// on "LOAD-MORE" Houses
function onLoadMoreHouses () {

    // move to next page
    page++;

    // show a loader
    document.querySelector(".ztc-alain-load-more").classList.add("ztc-alain-loader");
    document.querySelector(".ztc-alain-load-more").style.display = "block";

    // fetch API
    getHouses(keyword, page, pageSize, match)
        .then((response) => {

            const counts = parseInt(response.counts);
            const houses = JSON.parse(response.data);

            if(counts > 0) {
                // build items views
                const housesHTML = houses.map((itemHouse, index) => {
                        return viewHouseItemCard(itemHouse, index);
                    }
                ).join('');

                // append to view list
                document.querySelector(".ztc-alain-houses-list").innerHTML += housesHTML;
            }

            // remove loader
            document.querySelector(".ztc-alain-load-more").classList.remove("ztc-alain-loader");

            // show load more
            if(counts !== pageSize) {
                document.querySelector(".ztc-alain-load-more").style.display = "none";
            }

        })
        .catch((error) => {
            console.error('Houses-Error:', error);
        });

}


// get "VIEW of HOUSE ITEM Card"
function viewHouseItemCard(itemHouse, index) {
    return `
        <div class="ztc-alain-houses__item">
            <div class="ztc-alain-houses__item-image">
                <img class="ztc-alain-houses__item-img" src="${ROOT_URL}/public/logo-dark.png" alt=""/>
            </div>
            <div class="ztc-alain-house-item__content">
                <div class="ztc-alain-houses__item-title">
                    ${itemHouse.id}. ${highlightKeyword(itemHouse.name, keyword)}
                </div>
                <div class="ztc-alain-houses__item-details">
                    ${itemHouse.coatOfArms}
                </div>
            </div>
            <div class="ztc-alain-houses__item-footer">
                <div class="ztc-alain-houses__item-region">
                    ${itemHouse.region}
                </div>
                <div class="ztc-alain-houses__item-button">
                    <a onclick="viewHouse('${itemHouse.id}')">
                        Read more
                        <i class="fa fa-caret-right"></i>
                    </a>
                </div>
            </div>
        </div>
    `;
}


// get "VIEW of HOUSE ITEM"
function viewHouseItem(itemHouse, index) {
    return `
        <div class="ztc-alain-house__item">
            <div class="ztc-alain-house__item-head">
                <div class="ztc-alain-house__item-head-title">
                    ${itemHouse.name}
                </div>
            </div>
            <div class="ztc-alain-house__item-image">
                <img class="ztc-alain-house__item-img" src="${ROOT_URL}/public/images/houses-1.jpg" alt=""/>
            </div>
            <div class="ztc-alain-house-item__content">
                <div class="ztc-alain-house__item-title-1">
               
                </div>
                <div class="ztc-alain-house__item-details">
                    <div>
                        <i class="fa fa-dot-circle-o"></i>
                        <span>Coat Of Arms:</span>
                        <p>${itemHouse.coatOfArms}</p>
                    </div>
                    <div>
                        <i class="fa fa-dot-circle-o"></i>
                        <span>EATS:</span>
                        <p>${itemHouse.seats}</p>
                    </div>
                    <div>
                        <i class="fa fa-dot-circle-o"></i>
                        <span>REGION:</span>
                        <p>${itemHouse.region}</p>
                    </div>
                    <div>
                        <i class="fa fa-dot-circle-o"></i>
                        <span>HEIR:</span>
                        <p>${itemHouse.heir}</p>
                    </div>
                    <div>
                        <i class="fa fa-dot-circle-o"></i>
                        <span>TITLES:</span>
                        <p>${itemHouse.titles}</p>
                    </div>
                    <div>
                        <i class="fa fa-dot-circle-o"></i>
                        <span>CURRENT LORD:</span>
                        <p>${itemHouse.currentLord}</p>
                    </div>
                    <div>
                        <i class="fa fa-dot-circle-o"></i>
                        <span>FOUNDED:</span>
                        <p>${itemHouse.founded}</p>
                    </div>
                    <div>
                        <i class="fa fa-dot-circle-o"></i>
                        <span>HEIR:</span>
                        <p>${itemHouse.heir}</p>
                    </div>
                    <div>
                        <i class="fa fa-dot-circle-o"></i>
                        <span>DIED OUT:</span>
                        <p>${itemHouse.diedOut}</p>
                    </div>
                    <div>
                        <i class="fa fa-dot-circle-o"></i>
                        <span>Ancestral Weapons:</span>
                        <p>${itemHouse.ancestralWeapons}</p>
                    </div>
                    <div>
                        <i class="fa fa-dot-circle-o"></i>
                        <span>Cadet Branches:</span>
                        <p>${itemHouse.cadetBranches}</p>
                    </div>
                    <div>
                        <i class="fa fa-dot-circle-o"></i>
                        <span>Sworn Members:</span>
                        <p>${itemHouse.swornMembers}</p>
                    </div>
                </div>
            </div>
            <div class="ztc-alain-house__item-footer">
                <div class="ztc-alain-house__item-region">
                
                </div>
                <div class="ztc-alain-house__item-button">
                
                </div>
            </div>
        </div>
    `;
}


function viewHouse(id) {

    // change url
    let stateObj = { id: id };
    window.history.pushState(stateObj, "House "+id, ROOT_URL + "?id="+ id);

    // switch layouts
    document.querySelector(".ztc-alain-houses").style.display = "none";
    document.querySelector(".ztc-alain-house").style.display = "block";
    viewBack.style.display = "block";
    viewRefresh.style.display = "none";

    // clear view
    document.querySelector(".ztc-alain-house").innerHTML = "";

    // show a loader
    document.querySelector(".ztc-alain-house").classList.add("ztc-alain-loader");

    // fetch API
    getHouse(id)
        .then((response) => {

            const counts = parseInt(response.counts);
            const itemHouse = JSON.parse(response.data);

            if(counts > 0) {
                // build item view
                const houseHTML = viewHouseItem(itemHouse, id);

                // update view
                document.querySelector(".ztc-alain-house").innerHTML = houseHTML;
            }

            // remove loader
            document.querySelector(".ztc-alain-house").classList.remove("ztc-alain-loader");

        })
        .catch((error) => {
            console.error('House-Error:', error);
        });

}

window.addEventListener('popstate', (event) => {
    routeViews();
    history.go(1);
});
function routeViews() {

    // change url
    // window.location.href = ROOT_URL;
    let stateObj = { id: "" };
    window.history.pushState(stateObj, "Houses", ROOT_URL + "");

    // switch layouts
    document.querySelector(".ztc-alain-house").style.display = "none";
    document.querySelector(".ztc-alain-houses").style.display = "block";
    viewBack.style.display = "none";
    viewRefresh.style.display = "block";

}
history.pushState({ state: 1 }, '');


// got to entered house id from the url
const user_id = getUrlParameter("id");

if(user_id.length > 0) {
    viewHouse(user_id);
}

// Highlight keywords
function highlightKeyword(text, keyword) {
    let highlight = ("" + text).toLowerCase();
    if(keyword.length > 0) {
        const keys = ("" + keyword).toLowerCase().split(" ");
        if (("" + keyword).includes(" b")) {
            const key = "b";
            highlight = highlight.replace(key, "<span>" + key + "</span>");
        }
        for (let i = 0; i < keys.length; i++) {
            const key = keys[i];
            if (key != "b") {
                highlight = highlight.replace(key, "<span>" + key + "</span>");
            }
        }
    }
    return highlight;
}