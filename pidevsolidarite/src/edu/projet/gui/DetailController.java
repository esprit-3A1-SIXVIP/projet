/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.projet.gui;

import edu.projet.entite.Article;
import edu.projet.services.ServiceArticle;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

import javafx.application.Application;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;

/**
 * FXML Controller class
 *
 * @author med ali
 */
public class DetailController implements Initializable {

    private Label titre;
    @FXML
    private AnchorPane rootPane;
    @FXML
    private GridPane gridPane;
    @FXML
    private Label numberLabel;
    @FXML
    private Label otherLabel;
    @FXML
    private Label descriptionLabel;
    @FXML
    private Hyperlink hyperlink;
    @FXML
    private Hyperlink hyperlink1;
    @FXML
    private Hyperlink hyperlink3;
    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
     numberLabel.setText(null);
        descriptionLabel.setText(null);
        otherLabel.setText(null);
        hyperlink.setText("En savoir plus...");
        hyperlink.disableProperty().bind(applicationProperty().isNull());
        hyperlink.visibleProperty().bind(valueProperty().lessThanOrEqualTo(500));
        hyperlink.managedProperty().bind(hyperlink.visibleProperty());
        
        
    }    

     public DetailController() {
        valueProperty().addListener(valueChangeListener);
    }

    /**
     * Initialisation du contrôleur.
     
     */
  
    /**
    * Cet écouteur est appelé lorsque la propriété value change.
    */
    private final ChangeListener<Number> valueChangeListener = (ObservableValue<? extends Number> observableValue, Number oldValue, Number newValue) -> {
        updateUI(newValue);
    };

    private void updateUI(Number newValue) {
       Article a1 = null;
        final int val = newValue.intValue();
        ServiceArticle ser = new ServiceArticle();
        try {
             a1=  ser.findid(val);
        } catch (SQLException ex) {
            System.out.println("nbr");
        }
       // final int val = newValue.intValue();
     //   final String numberText ="  "+a1.getId(); 
        final String descriptionText = a1.getDescription();
               final String otherText = a1.getTitre();
 
     final String numberText = String.valueOf(newValue);
        //final String descriptionText = String.format("Le nombre %d est un nombre premier.Il ne peut être divisé que par lui-même et par le nombre 1.", val);
       // final String otherText = String.format("En binaire : %s\nEn octal : 0%s\nEn hexadécimal: 0x%s", Integer.toBinaryString(val), Integer.toOctalString(val), Integer.toHexString(val));

        numberLabel.setText(numberText);
        descriptionLabel.setText(descriptionText);
        otherLabel.setText(otherText);
    }

    /**
    * Cette méthode est appelée lorsque l'utilisateur clique sur l'hyperlien.
    */
    @FXML
    private void handleLink(ActionEvent actionEvent) {
        final Application application = getApplication();
        final Integer value = getValue();
        if (application != null && value != null) {
            final int val = getValue();
            final String url = String.format("http://fr.wikipedia.org/wiki/%d (nombre)", val);
            application.getHostServices().showDocument(url);
        }
    }

    /**
    * Contient la valeur à afficher.
    */
    private final IntegerProperty value = new SimpleIntegerProperty(this, "value");

    public final Integer getValue() {
        return value.get();
    }

    public final void setValue(Integer value) {
        this.value.set(value);
    }

    public final IntegerProperty valueProperty() {
        return value;
    }

    /**
    * Contient une référence vers l'application parente.
    */
    private final ObjectProperty<Application> application = new SimpleObjectProperty<>(this, "application");

    public final Application getApplication() {
        return application.get();
    }

    public final void setApplication(Application value) {
        this.application.set(value);
    }

    public final ObjectProperty<Application> applicationProperty() {
        return application;
    }
}
