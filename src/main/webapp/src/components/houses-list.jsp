<%--
  Created by IntelliJ IDEA.
  User: Alain-NIYONEMA
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<div class="ztc-alain-houses">

    <div class="ztc-alain-houses-filter">

        <div class="ztc-alain-houses-filter-match">
            <span>Match:</span>
            <input type="checkbox">
        </div>

        <div class="ztc-alain-houses-filter-size">
            <span>Items:</span>
            <select>
                <option value="3">3</option>
                <option selected value="6">6</option>
                <option value="12">12</option>
            </select>
        </div>

    </div>

    <div class="ztc-alain-houses-list"></div>

    <div class="ztc-alain-load-more">
        <button class="ztc-alain-load-more-btn">
            <i class="fa fa-arrow-down"></i>
            Load More
        </button>
    </div>

</div>
