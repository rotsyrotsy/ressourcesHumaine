/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import employe.EmployeView;
import fonction.Select;

/**
 *
 * @author Hasinjaka
 */
public class RechercheService {
    
    public Object [] recherche(String matricule,String poste, String contrat, String date, String salaire){
        Select select=new Select();
        String[]champ={"matricule","poste","designation","dateembauche","salaire"};
        String[]valeur={matricule,poste,contrat,date,salaire};
        String[]colonne={"matricule","email","poste","contrat","dateembauche","salaire"};
        String[]attribut={"matricule","email","poste","contrat","dateEmbauche","salaire"};
        Object[] result=select.liste(new EmployeView(), "ListEmploye", champ, valeur, colonne, attribut);
        
        return result;
    }
}
