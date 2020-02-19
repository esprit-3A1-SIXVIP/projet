/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.projet.test;


import edu.projet.entite.Article;
import edu.projet.services.ServiceArticle;
import java.sql.*;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author House
 */
public class Test {
    
    public static void main(String[] args) {
        ServiceArticle ser = new ServiceArticle();
        
        Article p1 = new Article(55,"titre1", "article", 1);
        Article p2 = new Article(61,"titre2", "article2", 1);
        
        try {
//         
            ser.ajouter(p2);
            ser.ajouter(p1);
          //  System.out.println(p1);
          p2.setTitre("titremodifier");
          p2.setDescription("dscriptionmodifier");
            ser.update(p2);
        //    ser.delete(p2);
          ser.deletetar();
           // List<Article> list = ser.readAll();
           // System.out.println(  ser.findid(66));
            List<Integer> list1 = ser.readAllid();
     //   System.out.println(list1);
        } catch (SQLException ex) {
            System.out.println(ex);
        }
   
     }
    
}
