<%--
  Created by IntelliJ IDEA.
  User: Максим
  Date: 04/Feb/18
  Time: 17:14
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
          <%--xmlns:c=http://java.sun.com/jsp/jstl/core--%>
<%--version="2.0">--%>
<%--<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>--%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:directive.page contentType="text/html;
charset=Utf-8" />
<html><head><title>Welcome</title></head>
<body><h3>Welcome</h3>
<hr />
<c:out value="${user}, Hello!"/>
<hr />
<a href="controller">Return to login page</a>
</body></html>
<%--</jsp:root>--%>