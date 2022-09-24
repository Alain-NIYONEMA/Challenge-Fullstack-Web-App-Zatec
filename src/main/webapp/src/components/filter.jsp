<%--
  Created by IntelliJ IDEA.
  User: Alain-NIYONEMA
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<div class="ztc-alain-houses-filter">

    <div class="ztc-alain-houses-filter-size">
        <span>Items:</span>
        <select>
            <option value="3">3 per Page</option>
            <option selected value="6">6 per Page</option>
            <option value="12">12 per Page</option>
        </select>
    </div>

    <div class="ztc-alain-houses-filter-content">
        <span>Search:</span>
        <select>
            <option selected value="">Title only</option>
            <option value="region">Region only</option>
            <option value="all">Whole contents</option>
        </select>
    </div>

    <div class="ztc-alain-houses-filter-match">
        <span>Match:</span>
        <input type="checkbox">
    </div>

    <div class="ztc-alain-houses-filter-images">
        <span>Images:</span>
        <input type="checkbox">
    </div>

</div>
