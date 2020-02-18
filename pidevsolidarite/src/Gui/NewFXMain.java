/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gui;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 *
 * @author amisa
 */
public class NewFXMain extends Application {

    @Override
    public void start(Stage primaryStage) {

        FXMLLoader p1 = new FXMLLoader(getClass().getResource("login.fxml"));
        Parent root;
        try {
            root = p1.load();
            Scene scene = new Scene(root);
        
            primaryStage.setScene(scene);
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);

    }

}
