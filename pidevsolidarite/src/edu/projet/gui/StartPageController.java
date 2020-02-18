/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.projet.gui;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author med ali
 */
public class StartPageController implements Initializable {

    @FXML
    private TextField txtnom;
    @FXML
    private TextField txtprenom;
    @FXML
    private Button btnvalider;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void login(ActionEvent event) {

        try {
            FXMLLoader loader;
            loader = new FXMLLoader(getClass().getResource("FXMLDocument_1.fxml"));
            Parent root = loader.load();
            Controller1 c = loader.getController();
            c.setDetail("bienvenue  "
                    
                    + txtprenom.getText()
            );
            txtnom.getScene().setRoot(root);

        } catch (IOException ex) {

        }

    }

}
