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
public class Organisation extends User{
     String nomOrganisation ;
  String domaine;

//    public Organisation(String nomOrganisation, String domaine, UUID userId, String login, String password, String nomUser, String prenomUser, String email, int telephone, String ville, String rue, String pays, String role) {
//        super(userId, login, password, nomUser, prenomUser, email, telephone, ville, rue, pays, role);
//        this.nomOrganisation = nomOrganisation;
//        this.domaine = domaine;
//    }

    public Organisation(String nomOrganisation, String domaine, String login, String password, String nomUser, String prenomUser, String email, int telephone, String ville, String rue, String pays, String role) {
        super(login, password, nomUser, prenomUser, email, telephone, ville, rue, pays, role);
        this.nomOrganisation = nomOrganisation;
        this.domaine = domaine;
    }

    

   

  


  
  



    

    public String getNomOrganisation() {
        return nomOrganisation;
    }

    public void setNomOrganisation(String nomOrganisation) {
        this.nomOrganisation = nomOrganisation;
    }

    public String getDomaine() {
        return domaine;
    }

    public void setDomaine(String domaine) {
        this.domaine = domaine;
    }

    @Override
    public String toString() {
        return "Organisation{" +super.toString()+ "nomOrganisation=" + nomOrganisation + ", domaine=" + domaine + '}';
    }
  
    
}
