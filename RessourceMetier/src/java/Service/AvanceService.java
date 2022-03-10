/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import contrat.Contrat;
import java.sql.Date;

/**
 *
 * @author Hasinjaka
 */
public class AvanceService {
    public void insererAvance(String id, float montant, String date, String remarque){
        ContratService cs=new ContratService();
        Contrat c=cs.getContrat(id);
        String request="insert into avance (idContrat,montant,date,etat,remarque) values ('"+c.getId()+"',"+montant+",'"+date+"',0,'"+remarque+"')";
        Connexion con=new Connexion(req);
    }
}
