<%--
  Created by IntelliJ IDEA.
  User: Максим
  Date: 09/Apr/18
  Time: 20:16
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Publications Page</title>
</head>
<body>
<h1>List of Publications</h1>
<%--<c:forEach items="${requestScope.listOfPublications}" var="item">--%>
<%--<tr>--%>
<%--<td>${item.publicationId}</td>--%>
<%--<td>${item.title}</td>--%>
<%--<td>${item.price}</td>--%>
<%--<td>${item.type}</td>--%>
<%--<td>${item.edition}</td>--%>
<%--&lt;%&ndash;<c:if test="${groupName eq 'USER'}">&ndash;%&gt;--%>
<%--&lt;%&ndash;<td>&ndash;%&gt;--%>
<%--&lt;%&ndash;<select class="form-control" name="plan" form="subscribe${formId}">&ndash;%&gt;--%>
<%--&lt;%&ndash;<option value="ONE_MONTH"><fmt:message bundle="${messages}"&ndash;%&gt;--%>
<%--&lt;%&ndash;key="EDITION_PLAN_ONE"/></option>&ndash;%&gt;--%>
<%--&lt;%&ndash;<option value="THREE_MONTHS"><fmt:message bundle="${messages}"&ndash;%&gt;--%>
<%--&lt;%&ndash;key="EDITION_PLAN_THREE"/></option>&ndash;%&gt;--%>
<%--&lt;%&ndash;<option value="SIX_MONTHS"><fmt:message bundle="${messages}"&ndash;%&gt;--%>
<%--&lt;%&ndash;key="EDITION_PLAN_SIX"/></option>&ndash;%&gt;--%>
<%--&lt;%&ndash;<option value="YEAR"><fmt:message bundle="${messages}"&ndash;%&gt;--%>
<%--&lt;%&ndash;key="EDITION_PLAN_YEAR"/></option>&ndash;%&gt;--%>
<%--&lt;%&ndash;</select>&ndash;%&gt;--%>
<%--&lt;%&ndash;</td>&ndash;%&gt;--%>
<%--&lt;%&ndash;</c:if>&ndash;%&gt;--%>
<%--<tr>--%>
<%--</c:forEach>--%>

    <%--<c:if test="${!empty listOfPublications}">--%>
        <table class="tg">
            <tr>
                <th width="80">ID</th>
                <th width="120">First Name</th>
                <th width="120">Last Name</th>
                <th width="120">Position</th>
                <th width="120">Salary</th>
                <th width="60">Edit</th>
                <th width="60">Delete</th>
            </tr>
            <c:forEach items="${listOfPublications}" var="publication">
                <tr>
                        <%--<td><a href="/employeedata/${employee.id}" target="_blank">${employee.id}</a></td>--%>
                    <td>${publication.publicationId}</td>
                    <td>${publication.title}</td>
                    <td>${publication.price}</td>
                    <td>${publication.type}</td>
                    <td>${publication.edition}</td>
                    <%--<td><a href="<c:url value='/edit/${publication.id}'/>">Edit</a></td>--%>
                    <%--<td><a href="<c:url value='/remove/${publication.id}'/>">Delete</a></td>--%>
                </tr>
            </c:forEach>
        </table>
    <%--</c:if>--%>
<%--</form>--%>

</body>
</html>

