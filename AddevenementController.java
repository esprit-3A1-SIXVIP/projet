/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.GUI;

import com.esprit.Entite.Evenement;
import com.esprit.Service.ServiceEvenement;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextField;
import com.jfoenix.controls.JFXTimePicker;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;


/**
 * FXML Controller class
 *
 * @author Soreilla
 */
public class AddevenementController implements Initializable {

    @FXML
    private JFXTextField txtportee;
    @FXML
    private JFXTextField txtlieu;
    @FXML
    private JFXTextField txtprix;
    @FXML
    private JFXTextField txtnom;
    @FXML
    private JFXDatePicker dateP;
    @FXML
    private JFXTimePicker timeheure;
    @FXML
    private JFXButton btn;
    @FXML
    private JFXButton btnE;
    @FXML
    private JFXButton btnSp;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }    
    @FXML
    private void addEvent(ActionEvent event) {
        
        /*long millis =System.currentTimeMillis();
        java.sql.Date date= new java.sql.Date(millis+70200);
        java.sql.Time time= new java.sql.Time(millis);*/

    String descriptionEvenement = txtnom.getText();
     String lieuEvenement =txtlieu.getText();
  LocalDate dateEvenement= dateP.getValue();
     LocalTime heureEvenement =timeheure.getValue();
     String porteeEvenement =txtportee.getText();
   Float prixEvenement=0.0f;
  
   Evenement std = new Evenement();
   std.setDescriptionEvenement(descriptionEvenement);
   std.setLieuEvenement(lieuEvenement);
   std.setDateEvenement(dateEvenement);
   std.setHeureEvenement(heureEvenement);
   std.setPorteeEvenement(porteeEvenement);
   std.setPrixEvenement(prixEvenement);
  ServiceEvenement ser = new ServiceEvenement();
        try {
            ser.ajouter(std);
        } catch(SQLException ex){
            System.out.println(ex);
        }
       
    }

    @FXML
    private void toGOespace(ActionEvent event) {
        
        try {
                    FXMLLoader top=new FXMLLoader(getClass().getResource("readEvenement.fxml"));

            Parent root =top.load();
                    ReadEvenementController dpc=top.getController();
                    
                    
                    txtnom.getScene().setRoot(root);

        } catch (IOException ex) {
        System.out.println(ex.getMessage());
        }
    }

    @FXML
    private void vueSponsor(ActionEvent event) {
         try {
                    FXMLLoader top=new FXMLLoader(getClass().getResource("viewevenement.fxml"));

            Parent root =top.load();
                    ViewevenementController dpc=top.getController();
                    
                    
                    txtnom.getScene().setRoot(root);

        } catch (IOException ex) {
        System.out.println(ex.getMessage());
        }
    }
    
    
}
