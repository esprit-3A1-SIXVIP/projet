/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.Service;


import com.esprit.Entite.User;
import com.esprit.IService.IService;
import com.esprit.Utils.DataBase;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.ObservableList;

/**
 *
 * @author Soreilla
 */
public class ServiceUser implements IService<User>  {
    private Connection con;
    private Statement ste;
    
     public ServiceUser(){
        con=DataBase.getInstance().getConnection();
    }

    @Override
    public void ajouter(User t) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean delete(User t) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean update(User t) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ObservableList<User> readAll() throws SQLException {
        ObservableList<User> arr =FXCollections.observableArrayList();
        ste=con.createStatement();
        ResultSet rs=ste.executeQuery("select nomOrganisation,pays,ville,domaine,email from user\n" +
"where type=\"organisation\";");
        while(rs.next()){
            
            String nomOrganisation= rs.getString("nomOrganisation");
            String ville= rs.getString("ville");
           String pays= rs.getString("pays");
           String domaine= rs.getString("domaine");
           String email= rs.getString("email");
          
           User u = new User(nomOrganisation,ville,domaine,pays,email);
            arr.add(u);
        }
        return arr;
    }
    

    @Override
    public void particper(User a, User b) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<String> readParticipant(User t) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
