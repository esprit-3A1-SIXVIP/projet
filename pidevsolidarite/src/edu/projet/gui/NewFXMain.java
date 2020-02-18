/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.projet.gui;

import java.io.IOException;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.util.Callback;

/**
 *
 * @author med ali
 */
public class NewFXMain extends Application {

    static {
        //       Font.loadFont(NewFXMain.class.getResource("/css/fontawesome-webfont.ttf").toExternalForm(), 10);
    }

    @Override
    public void start(Stage primaryStage) {
//
//        final ListView<Integer> listView = new ListView<>();
//        for (int index = 0; index < 3000; index++) {
//            listView.getItems().add(index);
//        }
//        listView.setCellFactory((ListView<Integer> lv) -> new detail(NewFXMain.this));
//        final StackPane root = new StackPane();
//        root.getChildren().add(listView);
//        final Scene scene = new Scene(root);
//        primaryStage.setScene(scene);
            Parent root;
          try {
              root = FXMLLoader.load(getClass().getResource("FXMLDocument_1.fxml"));
         
            Scene scene = new Scene(root);
            
            primaryStage.setTitle("Hello World!");
            primaryStage.setScene(scene);
        primaryStage.show();
           } catch (IOException ex) {
                ex.printStackTrace();
          }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}
