/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fonction;

import connexion.Connexion;
import employe.Employe;
import java.lang.reflect.Field;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Hasinjaka
 */
public class Select {

    public  int countResult(String table)
    {
        int result=0;
        try {
            String requete="select count(*) from "+table+"";
            Connexion con=new Connexion(requete);
            ResultSet res=con.getResultSet();
            res.next();
            result=res.getInt(1);
            
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return result;
    } 

    /*  Fonction generalisée qui retourne une liste et find */
    public Object[] liste(Object o, String table,String[] champ,String[] valeur, String [] colonne, String[] attribut)  
    {
        String where="";
        String request = "select * from "+table+" where 1=1";
        int len=countResult(table);
        System.out.println(len);
        Object[] obj=new Object[len];
        try {
            
            if(champ!=null) 
            {
                for (int u=0;u<champ.length ;u++ )
                {
                    if(valeur!=null){
                        if(valeur[u].isEmpty()==false){
                            where=where.concat(" and ");
                            where=where.concat(champ[u] + " = '"+valeur[u]+"'");    
                        }
                    } 
                }
                request=request.concat(where);
            }

            Connexion con=new Connexion(request);
            ResultSet res=con.getResultSet();
            int count=0;
            while(res.next())
            {
                obj[count]=o.getClass().newInstance();
                for (int i=0;i<colonne.length ;i++ )
                {
                    Field f=o.getClass().getDeclaredField(attribut[i]);
                    if (null!=f.getType().getName())
                        switch (f.getType().getName()) {
                            case "int":
                                f.set(obj[count],res.getInt(colonne[i]));
                                break;
                            case "float":
                                f.set(obj[count],res.getFloat(colonne[i]));
                                break;
                            case "Date":
                                f.set(obj[count],res.getDate(colonne[i]));
                                break;
                            case "String":
                                f.set(obj[count],res.getString(colonne[i]));
                                break;
                            default:
                                f.set(obj[count],res.getString(colonne[i]));
                                break;
                        }
                }
                count++;
            }
        } catch (IllegalAccessException | IllegalArgumentException | InstantiationException | NoSuchFieldException | SecurityException | SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return obj;
    }
    
    public static void main(String [] args){
        Select select=new Select();
        String [] colonne={"prenom"};
        String[] attribut={"prenom"};
        Object[] employe=select.liste(new Employe(),"employe",null,null,colonne,attribut);
        for (Object employe1 : employe) {
            Employe e=(Employe)employe1;
            System.out.println(e.getPrenom());
        }
    }
}
