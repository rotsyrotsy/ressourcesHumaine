/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entreprise;

import Service.EmployeService;
import employe.Employe;
import java.util.ArrayList;

/**
 *
 * @author Hasinjaka
 */
public class Entreprise {
    ArrayList<Employe> listeEmploye;
    EmployeService employeService;
    public Entreprise(){
        employeService=new EmployeService();
        listeEmploye=employeService.getAll();   
    }
    
    public Employe getEmploye(String idEmploye){
        for(int i=0;i<this.listeEmploye.size();i++){
            if(listeEmploye.get(i).getIdEmploye().equals(idEmploye)){
                return listeEmploye.get(i);
            }
        }
        return null;
    }

    public ArrayList<Employe> getListeEmploye() {
        return listeEmploye;
    }

    public EmployeService getEmployeService() {
        return employeService;
    }
}
