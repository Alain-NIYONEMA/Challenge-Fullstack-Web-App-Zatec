<%--
  Created by IntelliJ IDEA.
  User: Alain-NIYONEMA
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<div class="ztc-alain-nav-top">

    <a class="" href="#back" onclick="onBack()">
        <i class="fa fa-arrow-left"></i>
        Back
    </a>

    <a class="" href="#refresh" onclick="onLoadHouses()">
        <i class="fa fa-refresh"></i>
        Refresh
    </a>

    <jsp:include page='/src/components/search.jsp'>
        <jsp:param name="" value=""/>
    </jsp:include>

</div>
