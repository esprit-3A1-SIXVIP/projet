package edu.projet.gui;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */



import edu.projet.entite.Article;
import edu.projet.entite.stat;
import edu.projet.services.ServiceArticle;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.SubScene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Button;
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
    private Pane panecenter;
    @FXML
    private SubScene scene2;
    @FXML
    private Button btnaffsc;
    @FXML
    private ScrollPane listpane;
  

   
    

    @FXML
    private void typ1aff(MouseEvent event) {
       
        try {
            ServiceArticle ser=new ServiceArticle();
            stat readAllaide = ser.readAllaide();
            stat readAlldon = ser.readAlldon();
             stat readAlle = ser.readAllbenef();
           listpane.setVisible(false);
            typ1.setTitle("aide et don");
            int v1 =readAllaide.getInt1() ;
            int v2= readAlldon.getInt1() ;
            int v3= readAlle.getInt1() ;
            typ1.getData().setAll(
                    new PieChart.Data("aide",v1), 
                    new PieChart.Data("don", v2),
                    new PieChart.Data("beneficiare", v3));
        } catch (SQLException ex) {
            Logger.getLogger(Controller1.class.getName()).log(Level.SEVERE, null, ex);
        }
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
//list1=new ListView<Integer>();
      for(Integer e : list){
           
      
        
    list1.getItems().add(e);
}
     list1.setCellFactory((ListView<Integer> lv) -> new detail());
     list1.refresh();
       }

    void show(boolean b) {
      this.initialize(null, null);
        scene2.setVisible(false);
      scene2.setWidth(0);
      scene2.setHeight(0);
       
        

    }

    @FXML
    private void affich(ActionEvent event) {
        try {
            Parent root1 = FXMLLoader.load(getClass().getResource("subsc.fxml"));
            scene2.setVisible(true);
             scene2.setWidth(800);
             scene2.setHeight(475);
            scene2.setRoot(root1);
        } catch (IOException ex) {
            Logger.getLogger(Controller1.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void affliste(MouseEvent event) {
        listpane.setVisible(true);
        
    }

    @FXML
    private void afcstat2(ActionEvent event) {
        listpane.setVisible(false);
//     
//         /try {
//            ServiceArticle ser=new ServiceArticle();
//            stat readAllaide = ser.readAlldon1();
//            
//           listpane.setVisible(false);
//            typ1.setTitle("les meilleur donateur");
//            int v1 =readAllaide.getInt1() ;
//       ;
//            typ1.getData().setAll(
//                    
//                    new PieChart.Data(,v1), 
//                    new PieChart.Data("don", v2),
//                    new PieChart.Data("beneficiare", v3));
//        } catch (SQLException ex) {
//            Logger.getLogger(Controller1.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        
    }


   
}
