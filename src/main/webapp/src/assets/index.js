// Created by IntelliJ IDEA.
// User: Alain-NIYONEMA


// initialize PARAMETERS
let keyword = "";
let page = 1;
let pageSize = 6;


// initialize VIEWS
const viewBack = document.querySelector(".ztc-alain-nav__top-menu-back");
const viewRefresh = document.querySelector(".ztc-alain-nav__top-menu-refresh");


// load initial data
onLoadHouses();


// onSubmit "SEARCH"
document.querySelector(".ztc-alain-search-form").addEventListener("submit", function (e) {
    e.preventDefault();

    // switch views
    routeViews();
    
    // call 'search' function
    onSearchHouses();

});


// onClick "LOAD-MORE"
document.querySelector(".ztc-alain-load-more-btn").addEventListener("click", function () {

    // call 'loadMore' function
    onLoadMoreHouses();

});


// onChange "FILTER"
document.querySelector(".ztc-alain-houses-filter-size select").addEventListener("change", function () {

    // update "pageSize" value
    pageSize = this.value;

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
    document.querySelector(".ztc-alain-load-more-btn").style.disaply = "none";

    // fetch API
    getHouses(keyword, page, pageSize)
        .then((data) => {

            const houses = data;

            // build items views
            const housesHTML = houses.map((itemHouse, index) => {
                    return viewHouseItemCard(itemHouse, index);
                }
            ).join('');

            // update view list
            document.querySelector(".ztc-alain-houses-list").innerHTML += housesHTML;

            // remove loader
            document.querySelector(".ztc-alain-houses-list").classList.remove("ztc-alain-loader");
            document.querySelector(".ztc-alain-load-more-btn").style.disaply = "block";

        })
        .catch((error) => {
            console.error('Houses-Error:', error);
        });

}


// on "SEARCH" Houses
function onSearchHouses() {

    // reset page number
    page = 1;

    // get typed keyword
    keyword = document.querySelector(".ztc-alain-search-form input").value;

    // clean view items
    document.querySelector(".ztc-alain-houses-list").innerHTML = "";

    // show a loader
    document.querySelector(".ztc-alain-houses-list").classList.add("ztc-alain-loader");
    document.querySelector(".ztc-alain-load-more-btn").style.disaply = "none";

    // fetch API
    searchHouses(keyword, page, pageSize)
        .then((data) => {

            const houses = data;

            // build items views
            const housesHTML = houses.map((itemHouse, index) => {
                    return viewHouseItemCard(itemHouse, index);
                }
            ).join('');

            // update view list
            document.querySelector(".ztc-alain-houses-list").innerHTML = housesHTML;

            // remove loader
            document.querySelector(".ztc-alain-houses-list").classList.remove("ztc-alain-loader");
            document.querySelector(".ztc-alain-load-more-btn").style.disaply = "block";

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
    document.querySelector(".ztc-alain-load-more-btn").style.disaply = "none";

    // fetch API
    getHouses(keyword, page, pageSize)
        .then((data) => {

            const houses = data;

            // build items views
            const housesHTML = houses.map((itemHouse, index) => {
                    return viewHouseItemCard(itemHouse, index);
                }
            ).join('');

            // append to view list
            document.querySelector(".ztc-alain-houses-list").innerHTML += housesHTML;

            // remove loader
            document.querySelector(".ztc-alain-load-more").classList.remove("ztc-alain-loader");
            document.querySelector(".ztc-alain-load-more-btn").style.disaply = "block";

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
                    ${itemHouse.name}
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
                    <a onclick="viewHouse('${index + 1}')">
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
                ${itemHouse.name}
            </div>
            <div class="ztc-alain-house__item-image">
                <img class="ztc-alain-house__item-img" src="${ROOT_URL}/public/logo-dark.png" alt=""/>
            </div>
            <div class="ztc-alain-house-item__content">
                <div class="ztc-alain-house__item-title">
                    ${itemHouse.name}
                </div>
                <div class="ztc-alain-house__item-details">
                    ${itemHouse.coatOfArms}
                    <div>
                        <span>EATS:</span>
                        ${itemHouse.seats}
                    </div>
                    <div>
                        <span>HEIR:</span>
                        ${itemHouse.heir}
                    </div>
                </div>
            </div>
            <div class="ztc-alain-house__item-footer">
                <div class="ztc-alain-house__item-region">
                    ${itemHouse.region}
                </div>
                <div class="ztc-alain-house__item-button">
                    ${itemHouse.founded}
                </div>
            </div>
        </div>
    `;
}


function viewHouse(id) {

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
        .then((data) => {

            const itemHouse = data;

            // build item view
            const houseHTML = viewHouseItem(itemHouse, id);

            // update view
            document.querySelector(".ztc-alain-house").innerHTML = houseHTML;

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

    // switch layouts
    document.querySelector(".ztc-alain-house").style.display = "none";
    document.querySelector(".ztc-alain-houses").style.display = "block";
    viewBack.style.display = "none";
    viewRefresh.style.display = "block";

}
history.pushState({ state: 1 }, '');
