<%-- 
    Document   : list
    Created on : 21-01-2022, 09:38:11
    Author     : 
--%>

<%@page import="model.Student"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    <h1> Student List </h1>
    <br/>
</head>
<body>
    <%
        ArrayList<Student> students = (ArrayList<Student>) request.getAttribute("students");
    %>
    <table border="1">
        <tr>
            <td>
                ID
            </td>
            <td>
                Name
            </td>
            <td>
                Gender
            </td>
            <td>
                DOB
            </td>
        </tr>
        <%   for (Student s : students) {
        %>
        <tr>
            <td>
                <%=s.getId()%>
            </td> 
            <td>
                <%=s.getName()%>
            </td>
            <td>
                <input type="checkbox" <% if (s.isGender()) { %> checked <% }%> disabled>
            </td>
            <td>
                <%=s.getDOB()%>
            </td>
            <td>
                <a href="update?id=<%=s.getId() %>">Update</a>
                <a href="#" onclick="showMes(<%=s.getId() %>)">Delete</a>
            </td>
        </tr>
        <%}%>
    </table>
    <a href="create">Create</a>
    
    <script>
        function showMes(id){
            var check = confirm("Are you sure ?");
            if(check === true){
                window.location.href = "delete?id="+id;
            }
        }
    </script>
</body>
</html>
