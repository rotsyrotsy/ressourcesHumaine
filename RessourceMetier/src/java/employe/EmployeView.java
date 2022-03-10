/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package employe;

import java.sql.Date;

/**
 *
 * @author Hasinjaka
 */
public class EmployeView {
    public String matricule;
    public String email;
    public String poste;
    public String contrat;
    public Date dateEmbauche;
    public String salaire;

    public String getMatricule() {
        return matricule;
    }

    public String getEmail() {
        return email;
    }

    public String getPoste() {
        return poste;
    }

    public String getContrat() {
        return contrat;
    }

    public Date getDateEmbauche() {
        return dateEmbauche;
    }

    public String getSalaire() {
        return salaire;
    }
    
}
