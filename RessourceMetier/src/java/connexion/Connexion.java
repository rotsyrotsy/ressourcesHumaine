/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package connexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Hasinjaka
 */
public class Connexion {
    
    Connection con;
    Statement stat;
    ResultSet res;
    
    public Connexion(String req){
	try {
            Class.forName("org.postgresql.Driver");
            String user="izahay";
            String password="1234";
            this.con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/ressourceh",user,password);
            this.stat= this.con.createStatement();
            this.res=stat.executeQuery(req);
            if(this.con==null) System.out.println("non connecté");
            else System.out.println("connecté");
     	}
    	catch(SQLException sqle){sqle.printStackTrace();}
       	catch (Exception e) {e.printStackTrace();}

     
	}

    public Connection getConnection() {
        return con;
    }

    public Statement getStatement() {
        return stat;
    }

    public ResultSet getResultSet() {
        return res;
    }
    
    public void closeAll(){
        try{
            if(res!=null){
            res.close();
            }
            if(stat!=null){
            stat.close();
            }
            if(con!=null){
            con.close();
            }
        }
        catch(SQLException e){
            System.out.println(e.getMessage());
        }
        
    }
    
    public static void main(String[] args){
        new Connexion("select*from employe");
    }
}
