/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package employe;

import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Hasinjaka
 */
public class EmployeController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String nom=request.getParameter("nom");
        String prenom=request.getParameter("prenom");
        String email=request.getParameter("email");
        String dtn=request.getParameter("dtn");
        System.out.println(dtn);
        Date dateNaissance=Date.valueOf(dtn);
        String adresse=request.getParameter("adresse");
        String mdp=request.getParameter("mdp");
        String sexe=request.getParameter("sexe");
        String cin=request.getParameter("cin");
        EmployeService es=new EmployeService();
        Employe e=new Employe(nom,prenom,email,dateNaissance,sexe,adresse,cin,mdp);
        es.ajouterEmploye(e);
        ArrayList<Employe> listeEmploye=es.getAll();
        request.setAttribute("liste",listeEmploye);
//        request.setAttribute("nom",listeEmploye.get(0).getNom());
        RequestDispatcher dispat=request.getRequestDispatcher("Liste.jsp");
	dispat.forward(request,response);
               
    }
}
