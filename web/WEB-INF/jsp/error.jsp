<%--
  Created by IntelliJ IDEA.
  User: Максим
  Date: 04/Feb/18
  Time: 17:15
  To change this template use File | Settings | File Templates.

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

</body>
</html>
--%>

<%--<jsp:root xmlns:jsp="http://java.sun.com/JSP/Page"--%>
          <%--xmlns:c=--%>
                  <%--"http://java.sun.com/jsp/jstl/core" version="2.0">--%>
    <jsp:directive.page contentType=

                                "text/html; charset=Utf-8" />
    <html><head><title>Error</title></head>
    <body>
    <h3>Error</h3>
    <hr />
    <jsp:expression>
        (request.getAttribute("errorMessage") != null)
        ? (String) request.getAttribute("errorMessage")
        : "unknown error"</jsp:expression>
    <hr />
    <a href="controller">Return to login page</a>
    </body></html>
<%--</jsp:root>--%>