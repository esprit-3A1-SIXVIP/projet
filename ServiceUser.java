/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pidev.Service;

import java.sql.SQLException;
import java.util.List;
import pidev.Entite.User;
import pidev.IService.IService;
import pidev.DataBase.DataBase;

import java.sql.SQLException;
import java.util.List;
import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author USER
 */
/**
 *
 * @author House
 */
public class ServiceUser implements IService<User> {

    private Connection con;
    private Statement ste;
    private PreparedStatement pst ;
    private ResultSet res ;

    public ServiceUser() {
        con = DataBase.getInstance().getConnection();
    }

    @Override
    public void ajouter(User t) throws SQLException {
        ste = con.createStatement();
        String requeteInsert = "INSERT INTO `handshake`.`user` (`userId`, `login`, `password`, `email`, `role`) VALUES (NULL, '" + t.getLogin() + "', '" + t.getPassword() + "', '" + t.getEmail() + "', '" +t.getRole()+"');";
        ste.executeUpdate(requeteInsert);
    }
    public void ajouter1(User p) throws SQLException
    {
    PreparedStatement pre=con.prepareStatement("INSERT INTO `handshake`.`user` ( `userId`,`login`, `password`, `email`, `role`) VALUES ( NULL,?, ?, ?, ?);");
    pre.setString(2, p.getLogin());
    pre.setString(3, p.getPassword());
    pre.setString(4, p.getEmail());
    pre.setString(5, p.getRole());
    pre.executeUpdate();
    }
            

    public boolean delete(User t) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public boolean update(User t) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<User> readAll() throws SQLException {
    List<User> arr=new ArrayList<>();
    ste=con.createStatement();
    ResultSet rs=ste.executeQuery("select * from user");
     while (rs.next()) {                
               int userId=rs.getInt("userId");
               String login=rs.getString("login");
               String password=rs.getString("password");
               String email=rs.getString("email");
               String role=rs.getString("role");
               User p=new User(userId, login, password, email, role);
     arr.add(p);
     }
    return arr;
    }

    @Override
    public void delete(int id) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void update(User t, int id) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}

