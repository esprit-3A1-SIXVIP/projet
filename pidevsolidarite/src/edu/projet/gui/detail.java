/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.projet.gui;

import java.io.IOException;
import java.net.URL;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.control.ListCell;

/**
 *
 * @author med ali
 */



public class detail extends ListCell<Integer> {
    
    private Node renderer;
    private DetailController rendererController;
    
    public detail() {
        super();
        // Chargement du FXML.
        try {
            final URL fxmlURL = getClass().getResource("detail.fxml");
            final FXMLLoader fxmlLoader = new FXMLLoader(fxmlURL);
            renderer = (Node) fxmlLoader.load();
            rendererController = (DetailController) fxmlLoader.getController();
          //  rendererController.setApplication(application);
        } catch (IOException ex) {
            System.out.println( ex.getMessage());
        }
    }
    
    @Override
    protected void updateItem(Integer value, boolean empty) {
        super.updateItem(value, empty);
        String text = null;
        Node graphic = null;
        if (!empty && value != null) {
            // Si c'est un nombre premier, on utilise le nœud provenant du FXML.
            if ( renderer != null) {
                graphic = renderer;
                rendererController.setValue(value);
            } else {
                text = String.valueOf(value);
            }
        }
        setText(text);
        setGraphic(graphic);
    }
}

