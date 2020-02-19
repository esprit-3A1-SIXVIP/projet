/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.projet.gui;

import edu.projet.entite.Article;
import edu.projet.services.ServiceArticle;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;

/**
 * FXML Controller class
 *
 * @author med ali
 */
public class SubscController implements Initializable {

    @FXML
    private Button quit;
    @FXML
    private Button savebtn;
    @FXML
    private TextArea desc;
    @FXML
    private TextArea titre;
    @FXML
    private Text msg;
    @FXML
    private AnchorPane pane1;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       
    }    
    
   
        
    @FXML
    private void save(MouseEvent event) {
    msg.setText("");
        Article a1=null;
        String v1=titre.getText();
        String v2=desc.getText();
                a1= new Article(1,v1,v2,1);
        ServiceArticle ser=new ServiceArticle();
        if (titre.getText()==""){
            msg.setText("veuiller inserer un titre");
        }
         if (desc.getText()=="")
         {
             msg.setText("veuiller inserer un la description");
         }
             try {
            ser.ajouter(a1);
        } catch (SQLException ex) {
            Logger.getLogger(SubscController.class.getName()).log(Level.SEVERE, null, ex);
        }
        msg.setText("sauvgarde avec succe");
        
        desc.setText(null);
        titre.setText(null);
    }  

    @FXML
    private void quit(MouseEvent event) {
         FXMLLoader loader = new FXMLLoader(getClass().getResource("FXMLDocument_1.fxml"));
        try {
            Parent root = loader.load();
        } catch (IOException ex) {
            Logger.getLogger(SubscController.class.getName()).log(Level.SEVERE, null, ex);
        }
        Controller1 c;
        c = loader.getController();
        pane1.setVisible(false);
        c.show(Boolean.FALSE);
    }

}
