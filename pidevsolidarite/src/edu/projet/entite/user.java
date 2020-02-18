/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.projet.entite;

/**
 *
 * @author med ali
 */
public class user {
    private int id;
private String login;
    private String pass;
    private String nom;
    private String prenom;

    public user(int id, String login, String pass, String nom, String prenom) {
        this.id = id;
        this.login = login;
        this.pass = pass;
        this.nom = nom;
        this.prenom = prenom;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    @Override
    public String toString() {
        return "user{" + "id=" + id + ", login=" + login + ", pass=" + pass + ", nom=" + nom + ", prenom=" + prenom + '}';
    }

  
}