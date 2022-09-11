<%--
  Created by IntelliJ IDEA.
  User: Alain-NIYONEMA
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<div class="topnav">
    <a class="active" href="#home">Home</a>
    <a href="#about">About</a>
    <a href="#contact">Contact</a>

    <jsp:include page='/src/components/search.jsp'>
        <jsp:param name="" value=""/>
    </jsp:include>

</div>
