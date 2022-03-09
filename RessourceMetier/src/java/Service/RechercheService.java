/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import connexion.Connexion;
import employe.Employe;
import entreprise.Entreprise;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Hasinjaka
 */
public class RechercheService {
    Entreprise entreprise;
    
    public RechercheService(){
        entreprise=new Entreprise();
    }
    public ArrayList<Employe> recherche(String matricule,String poste, String contrat, String date, String salaire){
        ArrayList<Employe> result=new ArrayList();
        String req="select * from contratEmploye where 1=1 ";
        try {

            if(matricule!=null){
                req.concat("and idEmploye='"+matricule+"'");
            }
            if(poste!=null){
                req.concat("and poste='"+poste+"'");
            }
            if(contrat!=null){
                req.concat("and contrat='"+contrat+"'");
            }
            if(date!=null){
                req.concat("and idEmploye='"+date+"'");
            }
            if(salaire!=null){
                req.concat("and idEmploye='"+salaire+"'");
            }
            Connexion con=new Connexion(req);
            ResultSet res=con.getResultSet();
            while(res.next()){
                Employe e=entreprise.getEmploye(res.getString("idEmploye"));
                result.add(e);      
            }
        } catch (SQLException ex) {
            Logger.getLogger(RechercheService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }
}
