package edu.projet.gui;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */



import edu.projet.entite.Article;
import edu.projet.services.ServiceArticle;
import java.net.URL;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.MenuBar;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.ToggleButton;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;

/**
 *
 * @author med ali
 */
public class Controller1  implements Initializable {
;

    @FXML
    private MenuBar menuprc;
    @FXML
    private PieChart typ1;
    private Text txttitre;
    @FXML
    private ListView<Integer> list1;
    @FXML
    private ToggleButton btntheme;
    @FXML
    private Text ajoutAr;
    @FXML
    private ScrollPane cnt1;
    @FXML
    private Pane panecenter;

   
    

    private void typ1aff(MouseEvent event) {
        typ1.setTitle("Stock de fruits"); 
        typ1.getData().setAll(new PieChart.Data("Pommes", 50), new PieChart.Data("Oranges", 30),  
                new PieChart.Data("Poires", 25), new PieChart.Data("Pêches", 42), 
                new PieChart.Data("Citrons", 5), new PieChart.Data("Kiwis", 19));
    }

    void setDetail(String string) {
      txttitre.setText( string);
    }

    

    @Override
    public void initialize(URL location, ResourceBundle resources) {
     charger(new ActionEvent() );
    }

    @FXML
    private void charger(ActionEvent event) {
       List<Integer> list = null ;
    
        ServiceArticle ser = new ServiceArticle();
       try {
             list = ser.readAllid();
        } catch (SQLException ex) {
           Logger.getLogger(Controller1.class.getName()).log(Level.SEVERE, null, ex);
        }
      for(Integer e : list){
           
       
        
    list1.getItems().add(e);
}
     list1.setCellFactory((ListView<Integer> lv) -> new detail());
       }


   
}
