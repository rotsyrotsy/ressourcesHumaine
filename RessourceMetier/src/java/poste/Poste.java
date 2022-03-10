/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package poste;

import Service.ContratService;

/**
 *
 * @author Hasinjaka
 */
public class Poste {
    public String idPoste;
    public String nom;

    public String getIdPoste() {
        return idPoste;
    }

    public String getNom() {
        return nom;
    }
    
    public static void main(String args[]){
        ContratService cs=new ContratService();
        Object [] liste=cs.listePoste();
        for(Object poste : liste){
            Poste p=(Poste)poste;
            System.out.println(p.getNom());
        }
    }
    
}
