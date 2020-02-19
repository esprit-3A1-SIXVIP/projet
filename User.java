/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pidev.Entite;


/**
 *
 * @author House
 */
public class User {
    private int userID;
    private String login;
    private String password;
    private String nomUser;
    private String prenomUser;
    private String email;
    private int telephone;
    private String role;
    private String nomOrganisation;
    private String ville;
    private String rue;
    private String pays;
    private String domaine;

    public User(int userID, String login, String password, String email, String role) {
        this.userID = userID;
        this.login = login;
        this.password = password;
        this.email = email;
        this.role = role;
    }

   
    public User(int userID, String login, String password, String nomUser, String prenomUser, String email, int telephone, String role, String nomOrganisation, String ville, String rue, String pays, String domaine) {
        this.userID = userID;
        this.login = login;
        this.password = password;
        this.nomUser = nomUser;
        this.prenomUser = prenomUser;
        this.email = email;
        this.telephone = telephone;
        this.role = role;
        this.nomOrganisation = nomOrganisation;
        this.ville = ville;
        this.rue = rue;
        this.pays = pays;
        this.domaine = domaine;
    }

    public String getNomOrganisation() {
        return nomOrganisation;
    }

    public void setNomOrganisation(String nomOrganisation) {
        this.nomOrganisation = nomOrganisation;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public String getRue() {
        return rue;
    }

    public void setRue(String rue) {
        this.rue = rue;
    }

    public String getPays() {
        return pays;
    }

    public void setPays(String pays) {
        this.pays = pays;
    }

    public String getDomaine() {
        return domaine;
    }

    public void setDomaine(String domaine) {
        this.domaine = domaine;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
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

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "User{" + "userId=" + userID + ", login=" + login + ", password=" + password + ", nomUser=" + nomUser + ", prenomUser=" + prenomUser + ", email=" + email + ", telephone=" + telephone + ", role=" + role + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + this.userID;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final User other = (User) obj;
        if (this.userID != other.userID) {
            return false;
        }
        return true;
    }
    

    
}

