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
public class Article {
    private int id;
private String titre;
    private String descriptionArticle;
    private int userid;
      user user;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getDescription() {
        return descriptionArticle;
    }

    public void setDescription(String description) {
        this.descriptionArticle = description;
    }

    public int getUserid() {
        return user.getId();
    }

  
    public Article(String titre, String description, int userid) {
        this.titre = titre;
        this.descriptionArticle = description;
        this.userid=user.getId() ;
        this.userid = userid;
    }

    public Article(int id, String titre, String descriptionArticle, int userid) {
        this.id = id;
        this.titre = titre;
        this.descriptionArticle = descriptionArticle;
// this.userid = user.getId();
this.userid = userid;
    }

    @Override
    public String toString() {
        return "Article{" + "id=" + id + ", titre=" + titre + ", descriptionArticle=" + descriptionArticle + ", userid=" + userid + '}';
    }

 
}