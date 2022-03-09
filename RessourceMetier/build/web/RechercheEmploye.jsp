<%-- 
    Document   : RechercheEmploye
    Created on : 9 mars 2022, 21:58:46
    Author     : Hasinjaka
--%>

<%@page import="employe.Employe"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
    if(request.getParameter("recherche")!=null){
        ArrayList<Employe> list=(ArrayList<Employe>)request.getAttribute("liste");
    }
%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Gestion Employe</h1>
        <form method="get" action="RechercheEmploye">
            <p><label>Matricule</label><input type="text" name="matricule"></p>
            <p><label>Date d'embauche</label><input type="date" name="dateembauche"></p>
            <p><label>Poste</label>
                <select name="poste">
                    <option value="comptable">Comptable</option>
                    <option value="comptable">Comptable</option>
                </select>
            </p>
            <p><label>Type de Contrat</label>
                <select name="contrat">
                    <option value="essai">Essai</option>
                    <option value="essai">Temporaire</option>
                </select>
            </p>
            <p><label>Salaire</label><input type="text"name="salaire">Ariary</p>
            <p><input type="submit" value="CHERCHER"</p>
        </form>
        <div>
            <table border='1'>
                <tr>
                    <td>Matricule</td>
                    <td>E-Mail</td>
                    <td>Poste</td>
                    <td>Contrat</td>
                    <td>Date d'Embauche</td>
                    <td>Salaire</td>
                </tr>
                <tr>
                    <td>Matricule</td>
                    <td>E-Mail</td>
                    <td>Poste</td>
                    <td>Contrat</td>
                    <td>Date d'Embauche</td>
                    <td>Salaire</td>
                </tr>
                <tr>
                    <td>Matricule</td>
                    <td>E-Mail</td>
                    <td>Poste</td>
                    <td>Contrat</td>
                    <td>Date d'Embauche</td>
                    <td>Salaire</td>
                </tr>
            </table>
        </div>
    </body>
</html>
