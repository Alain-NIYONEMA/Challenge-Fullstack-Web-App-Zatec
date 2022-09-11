// Created by IntelliJ IDEA.
// User: Alain-NIYONEMA


// Parameters
let keyword = "";
let page = 1;
let pageSize = 6;


// load initial data
onLoadHouses();


// onSubmit "SEARCH"
document.querySelector(".ztc-alain-search-form").addEventListener("submit", function (e) {
    e.preventDefault();

    // call 'search' function
    onSearchHouses();

});


// onClick "LOAD-MORE"
document.querySelector(".ztc-alain-load-more-btn").addEventListener("click", function () {

    // call 'loadMore' function
    onLoadMoreHouses();

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
                    return viewHouseItem(itemHouse, index);
                }
            ).join('');

            // update view list
            document.querySelector(".ztc-alain-houses-list").innerHTML += housesHTML;

            // remove loader
            document.querySelector(".ztc-alain-houses-list").classList.remove("ztc-alain-loader");
            document.querySelector(".ztc-alain-load-more-btn").style.disaply = "none";

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
                    return viewHouseItem(itemHouse, index);
                }
            ).join('');

            // update view list
            document.querySelector(".ztc-alain-houses-list").innerHTML = housesHTML;

            // remove loader
            document.querySelector(".ztc-alain-houses-list").classList.remove("ztc-alain-loader");
            document.querySelector(".ztc-alain-load-more-btn").style.disaply = "none";

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
                    return viewHouseItem(itemHouse, index);
                }
            ).join('');

            // append to view list
            document.querySelector(".ztc-alain-houses-list").innerHTML += housesHTML;

            // remove loader
            document.querySelector(".ztc-alain-load-more").classList.remove("ztc-alain-loader");
            document.querySelector(".ztc-alain-load-more-btn").style.disaply = "none";

        })
        .catch((error) => {
            console.error('Houses-Error:', error);
        });

}


// get "VIEW of HOUSE ITEM"
function viewHouseItem(itemHouse, index) {
    return `
        <div class="ztc-alain-house__item">
            <div class="ztc-alain-house__item-image">
                <img class="ztc-alain-house__item-img" src="${ROOT_URL}/public/logo-dark.png" alt=""/>
            </div>
            <div class="ztc-alain-house-item__content">
                <div class="ztc-alain-house__item-title">
                    ${itemHouse.name}
                </div>
                <div class="ztc-alain-house__item-details">
                    ${itemHouse.coatOfArms}
                </div>
            </div>
            <div class="ztc-alain-house__item-footer">
                <div class="ztc-alain-house__item-region">
                    ${itemHouse.region}
                </div>
                <div class="ztc-alain-house__item-button">
                    <a href="#house" onclick="viewHouse('${index}')">
                        Read more
                    </a>
                </div>
            </div>
        </div>
    `;
}

function viewHouse(id) {

    // switch layouts
    document.querySelector(".ztc-alain-houses").style.display = "none";
    document.querySelector(".ztc-alain-house").style.display = "block";

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
    history.go(1);
});
function onBack() {

    // switch layouts
    document.querySelector(".ztc-alain-house").style.display = "none";
    document.querySelector(".ztc-alain-houses").style.display = "block";

}
history.pushState({ state: 1 }, '');
