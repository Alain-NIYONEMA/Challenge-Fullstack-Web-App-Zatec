<%--
  Created by IntelliJ IDEA.
  User: Alain-NIYONEMA
--%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>

    <%-- APPLICATION --%>
    <jsp:include page='/src/app.jsp'>
        <jsp:param name="" value=""/>
    </jsp:include>


    <%-- LAYOUT-HEADER --%>
    <jsp:include page='/src/layouts/header.jsp'>
        <jsp:param name="" value=""/>
    </jsp:include>


    <%-- LAYOUT-MAIN --%>
    <jsp:include page='/src/layouts/main.jsp'>
        <jsp:param name="" value=""/>
    </jsp:include>


    <%-- LAYOUT-FOOTER --%>
    <jsp:include page='/src/layouts/footer.jsp'>
        <jsp:param name="" value=""/>
    </jsp:include>

</html>