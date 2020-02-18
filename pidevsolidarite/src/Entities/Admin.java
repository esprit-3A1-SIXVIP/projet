/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

import java.util.UUID;

/**
 *
 * @author amisa
 */
public class Admin extends User{

//    public Admin(UUID userId, String login, String password, String nomUser, String prenomUser, String email, int telephone, String ville, String rue, String pays, String role) {
//        super(userId, login, password, nomUser, prenomUser, email, telephone, ville, rue, pays, role);
//    } 

 
  

    

  

    public Admin(String login, String password, String nomUser, String prenomUser, String email, int telephone, String ville, String rue, String pays, String role) {
        super(login, password, nomUser, prenomUser, email, telephone, ville, rue, pays, role);
    }

    @Override
    public String toString() {
        return "Admin{" +super.toString()+ '}';
    }

   
    
    
}
