/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.Entite;

/**
 *
 * @author Soreilla
 */
public  class User {
    private int userId;
    private String login;
    private String password;
    private String nomUser;
    private String prenomUser;
    private String role;
    private String email;
    private int telephone;
    private String nomOrganisation;
    private String rue;
    private String domaine;
    private String pays;
    private String ville;
    private String type;
    public User() {
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNomUser() {
        return nomUser;
    }

    public void setNomUser(String nomUser) {
        this.nomUser = nomUser;
    }

    public String getPrenomUser() {
        return prenomUser;
    }

    public void setPrenomUser(String prenomUser) {
        this.prenomUser = prenomUser;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getTelephone() {
        return telephone;
    }

    public void setTelephone(int telephone) {
        this.telephone = telephone;
    }

    public String getNomOrganisation() {
        return nomOrganisation;
    }

    public String getRue() {
        return rue;
    }

    public String getDomaine() {
        return domaine;
    }

    public String getPays() {
        return pays;
    }

    public String getVille() {
        return ville;
    }

    public String getType() {
        return type;
    }

    public void setNomOrganisation(String nomOrganisation) {
        this.nomOrganisation = nomOrganisation;
    }

    public void setRue(String rue) {
        this.rue = rue;
    }

    public void setDomaine(String domaine) {
        this.domaine = domaine;
    }

    public void setPays(String pays) {
        this.pays = pays;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public void setType(String type) {
        this.type = type;
    }

    public User(int userId, String login, String password, String nomUser, String prenomUser, String role, String email, int telephone) {
        this.userId = userId;
        this.login = login;
        this.password = password;
        this.nomUser = nomUser;
        this.prenomUser = prenomUser;
        this.role = role;
        this.email = email;
        this.telephone = telephone;
    }

    public User(String nomOrganisation, String pays,  String ville, String domaine,String email) {
        this.nomOrganisation = nomOrganisation;
        this.email = email;
        this.domaine = domaine;
        this.pays = pays;
        this.ville = ville;
    }

    public User(int userId) {
        this.userId = userId;
    }
    
    
    @Override
    public String toString() {
        return "User{" + "userId=" + userId + ", login=" + login + ", password=" + password + ", nomUser=" + nomUser + ", prenomUser=" + prenomUser + ", role=" + role + ", email=" + email + ", telephone=" + telephone + '}';
    }
    
    
    
  
    

}
