<%-- 
    Document   : edit
    Created on : 25-01-2022, 22:43:25
    Author     : 
--%>
<%@page import="model.Student"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <% Student s = (Student) request.getAttribute("student");%>

        <form action="update" method="post">
            <table>
                <tr><td>ID:</td>
                    <td><input type="text" name="id" value="<%=s.getId()%>">
                    </td>
                </tr>
                <tr><td>Name:</td><td><input type="text" name="name" value="<%=s.getName()%>"></td></tr>
                <tr>
                    <td>Gender</td>
                    <td><input type="radio" id="male" name="gender" value="true" <% if (s.isGender()) { %> checked <% }%>>
                          <label for="male">Male</label>
                        <input type="radio" id="fermale" name="gender" value="false" <% if (!s.isGender()) { %> checked <% }%>>
                          <label for="fermale">Fermale</label>
                    </td>
                </tr>
                <tr><td>DOB:</td><td><input type="date" name="dob" value="<%=s.getDOB()%>"></td></tr>
            </table>
            <input type="submit" value="Create">
        </form>
    </body>
</html>
