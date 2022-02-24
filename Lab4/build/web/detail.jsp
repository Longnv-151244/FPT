<%-- 
    Document   : detail
    Created on : 20-02-2022, 22:53:48
    Author     : dclon
--%>

<%@page import="model.Account"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <c:set var="account" value="${requestScope.account}" />
        <h1>Hello: ${account.displayName} </h1>
    </body>
</html>
