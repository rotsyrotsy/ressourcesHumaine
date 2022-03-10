/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import connexion.Connexion;
import contrat.Contrat;
import contrat.TypeContrat;
import fonction.Select;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import poste.Poste;

/**
 *
 * @author Hasinjaka
 */
public class ContratService {
    public Object[] listeContrat(){
        Select select=new Select();
        String []colonne={"id","designation"};
        String []attribut={"idContrat","designation"};
        Object[]result=select.liste(new TypeContrat(), "typecontrat", null, null, colonne, attribut);
        return result;
    }
    
    public Object[] listePoste(){
        Select select=new Select();
        String []colonne={"id","nom"};
        String []attribut={"idPoste","nom"};
        Object[]result=select.liste(new Poste(), "poste", null, null, colonne, attribut);
        return result;
    }
    
    public Contrat getContrat(String id){
        Contrat c=null;
        try {
            String req="select * from contrat where idEmploye='"+id+"' and debut=(select max(debut) from contrat where idEmploye='"+id+"')";
            Connexion con=new Connexion(req);
            ResultSet res=con.getResultSet();
            res.next();
            c=new Contrat(res.getString(1),res.getString(2),res.getString(3),res.getDate(4),res.getInt(5),res.getString(6),res.getFloat(7),res.getFloat(8));
        } catch (SQLException ex) {
            Logger.getLogger(ContratService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return c;
        
        
    }
}
