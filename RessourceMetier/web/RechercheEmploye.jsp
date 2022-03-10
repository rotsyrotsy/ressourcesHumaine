<%-- 
    Document   : RechercheEmploye
    Created on : 9 mars 2022, 21:58:46
    Author     : Hasinjaka
--%>

<%@page import="employe.EmployeView"%>
<%@page import="contrat.TypeContrat"%>
<%@page import="poste.Poste"%>
<%@page import="employe.Employe"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
    Object [] liste=null;
    if(request.getParameter("recherche")!=null){
        liste=(Object[])request.getAttribute("liste");
    }
    
    Object[] listeContrat=(Object[])request.getAttribute("listeContrat");
    Object[] listePoste=(Object[])request.getAttribute("listePoste");
%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    
        <h1>Gestion Employe</h1>
        <form method="get" action="RechercheController">
            <p><label>Matricule</label><input type="text" name="matricule"></p>
            <p><label>Date d'embauche</label><input type="date" name="dateembauche"></p>
            <p><label>Poste</label>
                <select name="poste">
                    <% for(Object poste : listePoste){ Poste p=(Poste)poste; %>
                       <option value="<%out.println(p.getNom());%>"><%out.println(p.getNom());%></option>
                    <%}%>
                </select>
            </p>
            <p><label>Type de Contrat</label>
                <select name="contrat">
                    <% for(Object contrat : listeContrat){ TypeContrat c=(TypeContrat)contrat; %>
                       <option value="<% out.println(c.getDesignation());%>"><%out.println(c.getDesignation());%></option>
                    <%}%>
                </select>
            </p>
            <p><label>Salaire</label><input type="text" name="salaire">Ariary</p>
            <p><input type="submit" value="CHERCHER"></p>
        </form>
        
            <table border='1'>
                <tr>
                    <td>Matricule</td>
                    <td>E-Mail</td>
                    <td>Poste</td>
                    <td>Contrat</td>
                    <td>Date d'Embauche</td>
                    <td>Salaire</td>
                </tr>
                <% if(request.getParameter("recherche")!=null){ %>
                <% for(Object employe: liste){ EmployeView e=(EmployeView)employe;%>
                <tr>
                    <td><%out.println(e.getMatricule());%></td>
                    <td><%out.println(e.getEmail());%></td>
                    <td><%out.println(e.getPoste());%></td>
                    <td><%out.println(e.getContrat());%></td>
                    <td><%out.println(e.getDateEmbauche());%></td>
                    <td><%out.println(e.getSalaire());%></td>
                </tr>
                <%}%>
                <%}%>
            </table>
        
    
</html>
