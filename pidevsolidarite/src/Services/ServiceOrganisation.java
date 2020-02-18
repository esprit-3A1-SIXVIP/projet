/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import Entities.Organisation;
import Utils.connexionBD;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author amisa
 */
public class ServiceOrganisation {

    private Connection con;
    private Statement ste;

    public ServiceOrganisation() {
        con = connexionBD.getInstance().getConnection();

    }

    public void ajouter(Organisation u) throws SQLException {
        ste = con.createStatement();
        String requeteInsert = "INSERT INTO `handshake`.`user` ( `login`, `password`, `nomUser`, `prenomUser`,`email`,`nomOrganisation`, `telephone`, `ville`, `rue`, `pays`,`domaine`, `role`)  VALUES ( '" + u.getLogin() + "', '" + u.getPassword() + "', '" + u.getNomUser() + "', '" + u.getPrenomUser() + "', '" + u.getEmail() + "', '" + u.getNomOrganisation() + "', '" + u.getTelephone() + "', '" + u.getVille() + "', '" + u.getRue() + "', '" + u.getPays() + "', '" + u.getDomaine() + "', 'Organisation ');";
        ste.executeUpdate(requeteInsert);
    }
    
public void modifpassword(String password,int id) throws SQLException{
             
            ste=con.createStatement();
            String sql ="Update user set password ='"
                    +password+"' Where role='Organisation' and userId="
                    +id;
                ste.executeUpdate(sql);
            
    }
public int chercher (Organisation u) throws SQLException
{
        int id=0;
        ste = con.createStatement();
        ResultSet rs = ste.executeQuery("select * from user where role='Organisation' and login='"+u.getLogin()+"'");
        while (rs.next()) {
            id = rs.getInt(1);
      
        }
         return id;
        }
     
   public void supprimer(Organisation u) throws SQLException
   {
        ste = con.createStatement();
       int id=chercher(u);
        String requeteDelete = "Delete From handshake.user Where userId='"+id+"'";
        ste.executeUpdate(requeteDelete);
    }


     public void modifierprofil(String image,int id) throws SQLException
     {
       ste=con.createStatement();
            String sql ="Update user set image ='"
                    +image+"' Where role='Organisation' and  userId="
                    +id;
                ste.executeUpdate(sql);
     }
    public List<Organisation> readAll() throws SQLException {
        List<Organisation> arr = new ArrayList<>();
        ste = con.createStatement();
        ResultSet rs = ste.executeQuery("select * from user where role='Organisation'");
        while (rs.next()) {
            int userId = rs.getInt(1);
            String login = rs.getString("login");
            String password = rs.getString("password");
            String nomUser = rs.getString("nomUser");
            String prenomUser = rs.getString("prenomUser");
            String email = rs.getString("email");
            String nomOrganisation = rs.getString("nomOrganisation");
            int telephone = rs.getInt("telephone");
            String ville = rs.getString("ville");
            String rue = rs.getString("rue");
            String pays = rs.getString("pays");
            String domaine = rs.getString("domaine");
            String role = rs.getString("role");
            Organisation p = new Organisation(nomOrganisation, domaine,  login, password, nomUser, prenomUser, email, telephone, ville, rue, pays, role);
            arr.add(p);
        }
        return arr;
    }
}
