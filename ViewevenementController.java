/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.GUI;

import com.esprit.Entite.User;
import com.esprit.Service.ServiceUser;
import com.jfoenix.controls.JFXButton;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
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
public class ViewevenementController implements Initializable {

    @FXML
    private TableView<User> table;
    @FXML
    private TableColumn<User, String> txtnom;
    @FXML
    private TableColumn<User, String> txtpays;
    @FXML
    private TableColumn<User, String> txtville;
    @FXML
    private TableColumn<User, String> txtdomaine;
    @FXML
    private TableColumn<User, String> txtemail;
    @FXML
    private JFXButton btnEnvoyer;
    @FXML
    private JFXButton btnActualiser;
       public ObservableList<User>  data =FXCollections.observableArrayList();
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
    private void goTo(ActionEvent event) {
    }

    @FXML
    private void viewSponsor(ActionEvent event) {
        
        ServiceUser ser = new ServiceUser();
        try {
           data=ser.readAll();
        } catch(SQLException ex){
            System.out.println(ex);
        }
        txtnom.setCellValueFactory( new PropertyValueFactory <User,String>("nomOrganisation"));
                txtpays.setCellValueFactory( new PropertyValueFactory <User,String>("pays"));

                        txtville.setCellValueFactory( new PropertyValueFactory <User,String>("ville"));
        txtdomaine.setCellValueFactory( new PropertyValueFactory <User,String>("domaine"));
         txtemail.setCellValueFactory( new PropertyValueFactory <User,String>("email"));
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
