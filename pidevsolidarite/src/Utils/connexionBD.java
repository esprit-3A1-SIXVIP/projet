/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author amisa
 */
public class connexionBD {
    //CTRL + SHIFT + O pour générer les imports
  private static String url = "jdbc:mysql://localhost:3306/handshake";
  private static String login = "root";
  private static String passwd = "";
  private static Connection connect;
  public  static connexionBD db;
  private connexionBD() {
         try {
             connect=DriverManager.getConnection(url, login, passwd);
             System.out.println("connexion etablie");
         } catch (SQLException ex) {
             System.out.println(ex);
         }
    }
    
  public Connection  getConnection()
    {
    return connect;
    }     
    public static connexionBD getInstance()
    {if(db==null)
        db=new connexionBD();
    return db;
    }
}
      

