package edu.projet.gui;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */



import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.MenuBar;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;

/**
 *
 * @author med ali
 */
public class Controller1 implements Initializable {
;

    @FXML
    private MenuBar menuprc;
    @FXML
    private PieChart typ1;
    @FXML
    private Text txttitre;
    @FXML
    private ListView<Integer> list1;

   
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       
for (int index = 0; index < 3000; index++) {
  list1.getItems().add(index);
   }
    }     

    private void typ1aff(MouseEvent event) {
        typ1.setTitle("Stock de fruits"); 
        typ1.getData().setAll(new PieChart.Data("Pommes", 50), new PieChart.Data("Oranges", 30),  
                new PieChart.Data("Poires", 25), new PieChart.Data("Pêches", 42), 
                new PieChart.Data("Citrons", 5), new PieChart.Data("Kiwis", 19));
    }

    void setDetail(String string) {
      txttitre.setText( string);
    }

    @FXML
    private void initialize(KeyEvent event) {
    }
    
}
