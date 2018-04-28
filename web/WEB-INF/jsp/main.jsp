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
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html><head><title>Welcome</title></head>
<body><h3>Welcome</h3>

<hr />
<c:out value="${name}, Hello!"/>
<hr />

<h1>List of Your Subscriptions </h1>
<table class="tg">
    <tr>
        <th width="120">Publications</th>
        <%--<th width="120">время до конца подписки</th>--%>
    </tr>
    <c:forEach items="${listOfSubscriptions}" var="subscription">
        <tr>
                <%--<td><a href="/employeedata/${employee.id}" target="_blank">${employee.id}</a></td>--%>
            <td>${subscription.publication.title}</td>

                <%--<td><a href="<c:url value='/edit/${publication.id}'/>">Edit</a></td>--%>
            <td>
                    <%--<a href="<c:url value='/main'/>">Buy</a></td>--%>
                <%--<form action="application" method="get">--%>
                    <%--<button type="Submit" name="command" value="buyPage"> Buy</button>--%>

                <%--</form>--%>
            </td>
        </tr>
    </c:forEach>
</table>

<form action="application">
    <input type="hidden" name="command" value="logout" />
    <br/>
    <input type="submit" value="Logout">
</form>
<%--<a href="controller">Return to login page</a>--%>
</body></html>
