/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pidev.Test;

import java.sql.SQLException;
import java.util.List;
import pidev.Entite.Aide;
import pidev.Service.ServiceAide;
import pidev.Entite.Beneficiaire;
import pidev.Service.ServiceBeneficiaire;
import pidev.Entite.User;
import pidev.Service.ServiceUser;

/**
 *
 * @author elhak
 */
public class Test {
    
   public static void main(String[] args) {
       //CREATION TAB DEMANDE
        ServiceAide STD = new ServiceAide(); // STD = Service TAB DEMANDE
        java.util.Date myDate = new java.util.Date("10/10/2009");
        java.sql.Date sqlDate = new java.sql.Date(myDate.getTime());

        Aide a1 = new Aide("a","a","a");
        Aide a2 = new Aide("b","b","b");
        Aide a3 = new Aide("c","c","c");
        
        //CREATION GROUPE
        ServiceBeneficiaire SG = new ServiceBeneficiaire(); // SG = Service Groupe
        
        Beneficiaire b1 = new Beneficiaire("nom","pre","email",sqlDate,"ville",256,"gps","role");
        Beneficiaire b2 = new Beneficiaire("nom1","pre1","email1",sqlDate,"ville1",256,"gps1","role1");
        Beneficiaire b3 = new Beneficiaire("nom2","pre2","email2",sqlDate,"ville2",333,"gps2","role2");


        try {
            //TAB DEMANDE
            //AJOUTER
            
            //STD.ajouter(a1);
            //STD.ajouter(a2);
            //STD.ajouter(a3);                //Te5dem jawha behy
           
            //DELETE
           // STD.delete(26);                 //Te5dem jawha behy
            
            //UPDATE
//            STD.update(a3, 24);            //Te5dem jawha behy

            //AFFICHAGE
//           List<Aide> listTab = STD.readAll();              //AFFICHAGE 3ADI
//           List<Aide> listTab2 = STD.getTrier();            //TRI

//          System.out.println(listTab);                             //AFFICHER
//          System.out.println(listTab2);                            //AFFICHER TRI

           // Tab_Demande p = STD.getById(20);                        //RECHERCHE PAR ID
          //  Tab_Demande c = STD.getByName("b");                     //RECHERCHE AVANCEE
            
           // System.out.println(p);                                  //AFFICHER RECHERCHE PAR ID POUR TAB DEMANDE
         //   System.out.println(c);                                  //AFFICHER RECHERCHE AVANCEE POUR TAB DEMANDE
            //BENEFICIAIRE
            //AJOUTER
            
            SG.ajouter(b1);
            //SG.ajouter(g2);
            //SG.ajouter(g3);                //Te5dem jawha behy
           
            //DELETE
            //SG.delete(1);                 //Te5dem jawha behy
            
            //UPDATE
            //SG.update(a2, 1);            //Te5dem jawha behy
            
            //AFFICHAGE
           List<Beneficiaire> listG = SG.readAll();                  //AFFICHAGE 3ADI
           List<Beneficiaire> listG2 = SG.getTrier();                //TRI
           System.out.println(listG);                          //AFFICHER
           System.out.println(listG2);                         //AFFICHER TRI
            
           // Groupe pp = SG.getById(2);                         //RECHERCHE PAR ID
           // Groupe cc = SG.getByName("a");                     //RECHERCHE AVANCEE
            
           // System.out.println(pp);                            //AFFICHER RECHERCHE PAR ID POUR GROUPE
           // System.out.println(cc);                            //AFFICHER RECHERCHE AVANCEE POUR GROUPE
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }
     
}
