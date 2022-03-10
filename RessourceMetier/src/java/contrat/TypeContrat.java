/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package contrat;

import Service.ContratService;

/**
 *
 * @author Hasinjaka
 */
public class TypeContrat {
    public String idContrat;
    public String designation;
    public int dureeMax;

    public String getIdContrat() {
        return idContrat;
    }

    public void setIdContrat(String idContrat) {
        this.idContrat = idContrat;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public int getDureeMax() {
        return dureeMax;
    }

    public void setDureeMax(int dureeMax) {
        this.dureeMax = dureeMax;
    }
    
        public static void main(String args[]){
        ContratService cs=new ContratService();
        Object [] liste=cs.listeContrat();
        for(Object contrat : liste){
            TypeContrat c=(TypeContrat)contrat;
            System.out.println(c.getDesignation());
        }
    }
}
