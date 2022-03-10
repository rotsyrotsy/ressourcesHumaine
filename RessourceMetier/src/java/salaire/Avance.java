/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package salaire;

import java.sql.Date;

/**
 *
 * @author Hasinjaka
 */
public class Avance {
    String id;
    String idContrat;
    float montant;
    Date date;
    int etat;
    String remarque;

    public Avance(String id, String idContrat, float montant, Date date, int etat, String remarque) {
        this.id = id;
        this.idContrat = idContrat;
        this.montant = montant;
        this.date = date;
        this.etat = etat;
        this.remarque = remarque;
    }
    
    

    public String getId() {
        return id;
    }

    public String getIdContrat() {
        return idContrat;
    }

    public float getMontant() {
        return montant;
    }

    public Date getDate() {
        return date;
    }

    public int getEtat() {
        return etat;
    }

    public String getRemarque() {
        return remarque;
    }
    
    
}
