/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ressourceh;

import employe.Connexion;
import java.sql.ResultSet;

/**
 *
 * @author Hasinjaka
 */
public class RessourceHService {
    public String login(String email, String mdp){
        String req="select count(*), id from employe where email='"+email+"' and mdp='"+mdp+"'";
        Connexion con=new Connexion(req);
        ResultSet res=con.getResultSet();
        try{
          res.next(); 
          if(res.getInt(1)==1){
            return res.getString(2);
          }
          else{
              return "wrong";
          }
        }
        catch(Exception e){} 
        return null;
    }
    
    
}
