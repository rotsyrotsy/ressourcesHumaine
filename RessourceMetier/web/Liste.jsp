<%-- 
    Document   : Liste
    Created on : 27 févr. 2022, 07:45:47
    Author     : Hasinjaka
--%>
<%@page import="java.util.ArrayList"%>
<%@page import="employe.Employe"%>
<%
ArrayList<Employe> list=(ArrayList<Employe>)request.getAttribute("liste");

%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello <% out.println(request.getAttribute("nom")); %></h1>
        <% for(int i=0; i<list.size(); i++) { %>
            <%out.println(list.get(i).getNom());%>
        <%}%>
    </body>
</html>
