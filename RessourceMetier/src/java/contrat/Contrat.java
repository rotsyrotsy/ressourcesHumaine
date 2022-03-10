/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package contrat;

import java.sql.Date;

/**
 *
 * @author Hasinjaka
 */
public class Contrat {
    String id;
    String idEmploye;
    String idTypeContrat;
    Date debut;
    int duree;
    String idPoste;
    float salaireBase;
    float indemnitemax;

    public Contrat(String id, String idEmploye, String idTypeContrat, Date debut, int duree, String idPoste, float salaireBase, float indemnitemax) {
        this.id = id;
        this.idEmploye = idEmploye;
        this.idTypeContrat = idTypeContrat;
        this.debut = debut;
        this.duree = duree;
        this.idPoste = idPoste;
        this.salaireBase = salaireBase;
        this.indemnitemax = indemnitemax;
    }

    
    public String getId() {
        return id;
    }

    public String getIdEmploye() {
        return idEmploye;
    }

    public String getIdTypeContrat() {
        return idTypeContrat;
    }

    public Date getDebut() {
        return debut;
    }

    public int getDuree() {
        return duree;
    }

    public String getIdPoste() {
        return idPoste;
    }

    public float getSalaireBase() {
        return salaireBase;
    }

    public float getIndemnitemax() {
        return indemnitemax;
    }
    
    
}
