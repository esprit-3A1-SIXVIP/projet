/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import Entities.User;
import Utils.connexionBD;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 *
 * @author amisa
 */
public class ServiceUser {

    private Connection con;
    private Statement ste;

    public ServiceUser() {
        con = connexionBD.getInstance().getConnection();

    }

    public void ajouter(User u) throws SQLException {

        ste = con.createStatement();
        String requeteInsert = "INSERT INTO `handshake`.`user` ( `userId`,`login`, `password`, `nomUser`, `prenomUser`, `email`, `telephone`, `ville`, `rue`, `pays`, `role`)  VALUES ( '" + u.getUserId() + "','" + u.getLogin() + "', '" + u.getPassword() + "', '" + u.getNomUser() + "', '" + u.getPrenomUser() + "', '" + u.getEmail() + "', '" + u.getTelephone() + "', '" + u.getVille() + "', '" + u.getRue() + "', '" + u.getPays() + "', '" + u.getRole() + "');";

        ste.executeUpdate(requeteInsert);
    }

    public int chercher(User u) throws SQLException {
        int id = 0;
        ste = con.createStatement();
        ResultSet rs = ste.executeQuery("select * from user where login='" + u.getLogin() + "'");
        while (rs.next()) {
            id = rs.getInt(1);

        }
        return id;
    }

    public void supprimer(User u) throws SQLException {
        ste = con.createStatement();
        int id = chercher(u);
        String requeteDelete = "Delete From handshake.user Where userId='" + id + "'";
        ste.executeUpdate(requeteDelete);
    }

    public void modifpassword(String password, int id) throws SQLException {

        ste = con.createStatement();
        String sql = "Update user set password =" + password + " Where userId=" + id;
        ste.executeUpdate(sql);

    }

    public void modifierprofil(String image, User u) throws SQLException {
        ste = con.createStatement();
        String sql = "Update user set profil ='" + image + "' Where userId=" + chercher(u);
        ste.executeUpdate(sql);
    }

    /**
     *
     * @return @throws SQLException
     */
    public List<User> readAll() throws SQLException {
        List<User> arr = new ArrayList<>();
        ste = con.createStatement();
        ResultSet rs = ste.executeQuery("select * from user where role='user simple'");
        while (rs.next()) {
            int userId = rs.getInt(1);
            String login = rs.getString("login");
            String password = rs.getString("password");
            String nomUser = rs.getString("nomUser");
            String prenomUser = rs.getString("prenomUser");
            String email = rs.getString("email");
            int telephone = rs.getInt("telephone");
            String ville = rs.getString("ville");
            String rue = rs.getString("rue");
            String pays = rs.getString("pays");
            String role = rs.getString("role");
            User p = new User(login, password, nomUser, prenomUser, email, telephone, ville, rue, pays, role);
            arr.add(p);
        }
        return arr;
    }

}
