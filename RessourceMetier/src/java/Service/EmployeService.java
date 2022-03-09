/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import employe.Employe;
import java.util.ArrayList;

/**
 *
 * @author Hasinjaka
 */
public class EmployeService {
    
    public void ajouterEmploye(Employe e){
        e.ajoutDB();
    }
    
    public ArrayList<Employe> getAll(){
        ArrayList<Employe> result=new Employe().getAll();
        return result;
    }
    
    public static void main(String[]ats){
        EmployeService es=new EmployeService();
        ArrayList<Employe> list=es.getAll();
        for(int i=0;i<list.size();i++){
            System.out.println(list.get(i).getNom());
        }
    }
}
