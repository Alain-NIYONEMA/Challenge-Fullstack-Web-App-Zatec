<%--
  Created by IntelliJ IDEA.
  User: Alain-NIYONEMA
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<div class="ztc-alain-nav__top">

    <div class="ztc-alain-nav__top-menu">
        <a class="ztc-alain-nav__top-menu-back" onclick="routeViews()">
            <i class="fa fa-arrow-left"></i>
            <span>Back</span>
        </a>

        <a class="ztc-alain-nav__top-menu-refresh" onclick="onLoadHouses()">
            <i class="fa fa-refresh"></i>
            <span>Refresh</span>
        </a>
    </div>

    <div class="ztc-alain-nav__top-logo">
        <div class="ztc-alain-nav__top-logo-box">
            <img src="${pageContext.request.contextPath}/public/logo-white.png" alt=""/>
            <span>ztc-Alain</span>
        </div>
    </div>

    <jsp:include page='/src/components/search.jsp'>
        <jsp:param name="" value=""/>
    </jsp:include>

</div>
