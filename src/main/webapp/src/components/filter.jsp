<%--
  Created by IntelliJ IDEA.
  User: Alain-NIYONEMA
  Project: ztc-Alain
  Company: Zatec
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<div class="ztc-alain-houses-filter">

    <div class="ztc-alain-houses-filter-size">
        <label>
            <span>Items:</span>
            <select>
                <option value="3">3 per Page</option>
                <option selected value="6">6 per Page</option>
                <option value="12">12 per Page</option>
                <option value="15">15 per Page</option>
            </select>
        </label>
    </div>

    <div class="ztc-alain-houses-filter-content">
        <label>
            <span>Filter:</span>
            <select>
                <option selected value="">Title only</option>
                <option value="region">Region only</option>
                <option value="all">Whole contents</option>
            </select>
        </label>
    </div>

    <div class="ztc-alain-houses-filter-match">
        <label>
            <span>Match:</span>
            <input type="checkbox">
        </label>
    </div>

    <div class="ztc-alain-houses-filter-images">
        <label>
            <span>Images:</span>
            <input type="checkbox">
        </label>
    </div>

</div>
