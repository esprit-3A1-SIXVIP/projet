/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.GUI;

import com.esprit.Entite.Evenement;
import com.esprit.Service.ServiceEvenement;
import com.jfoenix.controls.JFXButton;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalTime;
import static java.util.Collections.list;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * FXML Controller class
 *
 * @author Soreilla
 */
public class ReadEvenementController implements Initializable {

    @FXML
    private TableView<Evenement> table;
    @FXML
    private TableColumn<Evenement,String> txtnom;
    @FXML
    private TableColumn<Evenement,String> txtlieu;
    @FXML
    private TableColumn<Evenement, LocalDate> dateP;
    @FXML
    private TableColumn<Evenement, LocalTime> timeP;
    @FXML
    private TableColumn<Evenement,String> txtportee;
    @FXML
    private TableColumn<Evenement, Float> txtprix;
    @FXML
    private TableColumn<Evenement, Integer> txtid;
   public ObservableList<Evenement> data =FXCollections.observableArrayList();
    @FXML
    private JFXButton btn;
    @FXML
    private JFXButton btnBack;
 

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }  
    @FXML
    public void readEvent(ActionEvent event){
        ServiceEvenement ser = new ServiceEvenement();
        try {
           data=ser.readAll();
        } catch(SQLException ex){
            System.out.println(ex);
        }
        txtid.setCellValueFactory(new PropertyValueFactory<Evenement,Integer>("evenementId"));
             txtnom.setCellValueFactory(new PropertyValueFactory<Evenement,String>("descriptionEvenement"));
                  txtlieu.setCellValueFactory(new PropertyValueFactory<Evenement,String>("lieuEvenement"));
                       dateP.setCellValueFactory(new PropertyValueFactory<Evenement,LocalDate>("dateEvenement"));
                           timeP.setCellValueFactory(new PropertyValueFactory<Evenement,LocalTime>("heureEvenement"));
                                 txtportee.setCellValueFactory(new PropertyValueFactory<Evenement,String>("porteeEvenement"));
                                      txtprix.setCellValueFactory(new PropertyValueFactory<Evenement,Float>("prixEvenement"));

             table.setItems(data);
             
        
        
    }

    @FXML
    private void back(ActionEvent event) {
         try {
                    FXMLLoader top=new FXMLLoader(getClass().getResource("addevenement.fxml"));

            Parent root =top.load();
                    AddevenementController dpc=top.getController();
                    
                    
                    table.getScene().setRoot(root);

        } catch (IOException ex) {
        System.out.println(ex.getMessage());
        }
    }
    
}
