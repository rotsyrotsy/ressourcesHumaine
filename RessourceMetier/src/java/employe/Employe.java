/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package employe;

import connexion.Connexion;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Employe {
    private String idEmploye;
    private String nom;
    private String prenom;    
    private Date dateNaissance;
    private String sexe;
    private String email;
    private String adresse;
    private String CIN;
    private String mdp;
    
    public Employe(){
    
    }
    public Employe(String idEmploye, String nom, String prenom, String email,Date dateNaissance, String sexe,  String adresse, String CIN, String mdp) {
        this.idEmploye = idEmploye;
        this.nom = nom;
        this.prenom = prenom;
        this.dateNaissance = dateNaissance;
        this.sexe = sexe;
        this.email = email;
        this.adresse = adresse;
        this.CIN = CIN;
        this.mdp = mdp;
    }
    
    public Employe(String nom, String prenom, String email,Date dateNaissance, String sexe,  String adresse, String CIN, String mdp) {
        this.nom = nom;
        this.prenom = prenom;
        this.dateNaissance = dateNaissance;
        this.sexe = sexe;
        this.email = email;
        this.adresse = adresse;
        this.CIN = CIN;
        this.mdp = mdp;
    }
    
    
    public String getIdEmploye() {
        return idEmploye;
    }

    public void setIdEmploye(String idEmploye) {
        this.idEmploye = idEmploye;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public Date getDateNaissance() {
        return dateNaissance;
    }

    public void setDateNaissance(Date dateNaissance) {
        this.dateNaissance = dateNaissance;
    }

    public String getSexe() {
        return sexe;
    }

    public void setSexe(String sexe) {
        this.sexe = sexe;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getCIN() {
        return CIN;
    }

    public void setCIN(String CIN) {
        this.CIN = CIN;
    }

    public String getMdp() {
        return mdp;
    }

    public void setMdp(String mdp) {
        this.mdp = mdp;
    }
    
    
    public void ajoutDB(){
        String req="insert into employe(nom,prenom,email,dtn,sexe,adresse,CIN,mdp) values ('"+this.nom+"','"+this.prenom+"','"+this.email+"','"+this.dateNaissance+"','"+this.sexe+"','"+this.adresse+"','"+this.CIN+"','"+this.mdp+"')";
        System.out.println(req);
        Connexion con=new Connexion(req);
        System.out.println(req);
        con.closeAll();   
    }
    
    public ArrayList<Employe> getAll(){
        ArrayList<Employe> result=new ArrayList();
        String req="select * from employe";
        Connexion con=new Connexion(req);
        ResultSet res=con.getResultSet();
        try{
          while(res.next()){
            Employe e=new Employe(res.getString(1),res.getString(2), res.getString(3),res.getString(4), res.getDate(5),res.getString(6) ,res.getString(7),res.getString(8),res.getString(9));
            
            result.add(e); 
          }  
        }
        catch(SQLException e){
            System.out.println("Exception there: "+e.getMessage()+ " on line "+e.getStackTrace()[0].getLineNumber());
        }
        finally{
            con.closeAll();
        }
        
        return result;
    }
    
    public Date getDate(){
       String req="select dtn from employe";
       Connexion con=new Connexion(req);
       ResultSet res=con.getResultSet();
       
        try {
            res.next();
            return res.getDate(1);
            
        } catch (SQLException ex) {
            Logger.getLogger(Employe.class.getName()).log(Level.SEVERE, null, ex);
        }
       return null;
    }
    
    public static void main(String args[]){
        Employe e=new Employe();
        System.out.println(e.getDate());
        
    }
}
