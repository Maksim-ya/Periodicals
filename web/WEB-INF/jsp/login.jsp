<%--
  Created by IntelliJ IDEA.
  User: Максим
  Date: 04/Feb/18
  Time: 16:53
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

<%@ page language="java" contentType="text/html;
charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<html>
<head><title>Login</title></head>
<jsp:expression> (request.getAttribute("logoutMessage") != null)
    ?(String)request.getAttribute("logoutMessage")
    :""
</jsp:expression>
<hr/>
<body><h3>Login</h3>
<form name="loginForm" method="POST" action="controller">
    <input type="hidden" name="command" value="login"/>
    Login:<br/>
    <input type="text" name="login" value=""><br/>
    Password:<br/>
    <input type="password" name="password" value="">
    <br/>
    <input type="submit" value="Enter">
</form>
<hr/>
</body>
</html>