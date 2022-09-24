<%--
  Created by IntelliJ IDEA.
  User: Alain-NIYONEMA
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<div class="ztc-alain-houses">

    <jsp:include page='/src/components/filter.jsp'>
        <jsp:param name="" value=""/>
    </jsp:include>

    <div class="ztc-alain-houses-list"></div>

    <jsp:include page='/src/components/load-more.jsp'>
        <jsp:param name="" value=""/>
    </jsp:include>

</div>
