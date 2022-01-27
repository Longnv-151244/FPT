<%-- 
    Document   : add
    Created on : 25-01-2022, 22:43:00
    Author     : 
--%>

<%@page import="java.time.LocalDateTime"%>
<%@page import="java.time.LocalDate"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.sql.Date"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        
        <% LocalDate currentDate = LocalDate.now(); %>
        
        <form action="create" method="post">
            <table>
                <tr><td>Name:</td><td><input type="text" name="name"></td></tr>
                <tr>
                    <td>Gender</td>
                    <td><input type="radio" id="male" name="gender" value="true" checked>
                          <label for="male">Male</label>
                        <input type="radio" id="fermale" name="gender" value="false">
                          <label for="fermale">Fermale</label>
                    </td>
                </tr>
                <tr><td>DOB:</td><td><input type="date" name="dob" value="<%=currentDate %>"></td></tr>
            </table>
            <input type="submit" value="Create">
        </form>
    </body>
</html>
