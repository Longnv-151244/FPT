<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%-- 
    Document   : student
    Created on : 17-01-2022, 09:44:26
    Author     : 
--%>
<%@page import="java.util.ArrayList"%>
<%@page import="model.Student"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
            ArrayList<Student> std = (ArrayList<Student>) request.getAttribute("data");
            int length = (Integer) request.getAttribute("length");
        %>
        <form action="student">
            Number of Students: 
            <input type="text" name="length" value="<%=length %>" required>
            <input type="submit" value="generate" />
        </form>

        <table border ="2">
            <tr>
                <th>ID</th>
                <th>Name</th> 
                <th>Gender</th>
                <th>DOB</th>
            </tr>
            <% for (Student s : std) {%>
            <tr>
                <td><%=s.getId()%></td>
                <td><%=s.getName()%></td>
                <td><input type="checkbox" <% if (s.isGender()) { %> checked <% } %>></td>
                <td><%=s.getStringDate()%></td>
            </tr>
            <% } %>
        </table>
    </body>
</html>
