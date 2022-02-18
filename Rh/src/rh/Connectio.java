package rh;

import java.sql.*;

public class Connectio{


   Connection con;
	Statement stat;
	ResultSet res;


	public Connectio(String req){
		try {
			Class.forName("org.postgresql.Driver");
            String user="postgres";
            String password="1234";
		 	this.con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres",user,password);
  			this.stat= this.con.createStatement();
  			this.res=stat.executeQuery(req);
              if(this.con==null) {System.out.println("non connecté");}
            else {System.out.println("connecté");}
		//	this.commit=stat.executeQuery("commit");
     	}
    	catch(SQLException sqle){sqle.printStackTrace();}
       	catch (Exception e) {e.printStackTrace();}

     
	}

	public ResultSet getResultset(){
		return this.res;
	}

	
	public Statement getStat(){
		return this.stat;
	}
	public static void main(String[] args) throws Exception{
		Connectio c=new Connectio("select*from c");
	}

}
