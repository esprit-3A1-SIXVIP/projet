/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pidev.Test.Interface;

import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.input.MouseEvent;
import javafx.util.converter.IntegerStringConverter;
import pidev.DataBase.DataBase;
import pidev.Entite.Aide;
import pidev.Service.ServiceAide;

/**
 * FXML Controller class
 *
 * @author wajih
 */
public class AjouterAideController implements Initializable {
        private Statement ste;
    private Connection con;
    @FXML
    private TextField descriptionAide;
    @FXML
    private TextField localisationAide;
    @FXML
    private TextField categorieAide;
        @FXML
    private TableView<Aide> AffichageTabAide;
    @FXML
    private TableColumn<Aide, Integer> idtab;
    @FXML
    private TableColumn<Aide, String> descriptiontab;
    @FXML
    private TableColumn<Aide, String> localisationtab;
    @FXML
    private TableColumn<Aide, String> categorietab;
    @FXML
    private Button Supprimer;
    @FXML
    private TextField recherche;
    private final ObservableList<Aide> data = FXCollections.observableArrayList();
        ServiceAide SA = new ServiceAide(); 
    @FXML
    private Button AjouterAide;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
                Aff();
        RechercheAV();
    }    
     public void Aff(){
                        try {
            con = DataBase.getInstance().getConnection();
            ste = con.createStatement();
                        data.clear();

            ResultSet rs = ste.executeQuery("select * from Aide");
            while(rs.next()){
                data.add(new Aide(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4)));
            }

        } catch (Exception e) {
                //Logger.getLogger(tab)
        }
               
            idtab.setCellValueFactory(new PropertyValueFactory<>("aideID"));
            descriptiontab.setCellValueFactory(new PropertyValueFactory<>("descriptionAide"));
            localisationtab.setCellValueFactory(new PropertyValueFactory<>("localisationAide"));
            categorietab.setCellValueFactory(new PropertyValueFactory<>("categorieAide"));

            AffichageTabAide.setItems(data);
            AffichageTabAide.setEditable(true);
            descriptiontab.setCellFactory(TextFieldTableCell.forTableColumn());
            localisationtab.setCellFactory(TextFieldTableCell.forTableColumn());
            categorietab.setCellFactory(TextFieldTableCell.forTableColumn());

    }
     
      public void RechercheAV(){
                // Wrap the ObservableList in a FilteredList (initially display all data).
        FilteredList<Aide> filteredData = new FilteredList<>(data, b -> true);
		
		// 2. Set the filter Predicate whenever the filter changes.
		recherche.textProperty().addListener((observable, oldValue, newValue) -> {
			filteredData.setPredicate(aide -> {
				// If filter text is empty, display all persons.
								
				if (newValue == null || newValue.isEmpty()) {
					return true;
				}
				
				// Compare first name and last name of every person with filter text.
				String lowerCaseFilter = newValue.toLowerCase();
				
				if (aide.getCategorieAide().toLowerCase().indexOf(lowerCaseFilter) != -1 ) {
					return true; // Filter matches first name.
				} else if (String.valueOf(aide.getAideID()).indexOf(lowerCaseFilter)!=-1)
				     return true;
				     else  
				    	 return false; // Does not match.
			});
		});
		
		// 3. Wrap the FilteredList in a SortedList. 
		SortedList<Aide> sortedData = new SortedList<>(filteredData);
		
		// 4. Bind the SortedList comparator to the TableView comparator.
		// 	  Otherwise, sorting the TableView would have no effect.
		sortedData.comparatorProperty().bind(AffichageTabAide.comparatorProperty());
		
		// 5. Add sorted (and filtered) data to the table.
		AffichageTabAide.setItems(sortedData);
    }
    @FXML
    private void AjouterAide(MouseEvent event) throws SQLException {
                                       con = DataBase.getInstance().getConnection();
             ste = con.createStatement();

                try {
                    ServiceAide ser =new ServiceAide();
                    ser.ajouter(new Aide(descriptionAide.getText(),localisationAide.getText(),categorieAide.getText()));
                    Aff();
                    RechercheAV();
                }
                 catch (SQLException ex) {
                    System.out.println(ex);
                 }
    }
    @FXML
    private void Change_Description(TableColumn.CellEditEvent bb) throws SQLException{
     Aide aideselected = AffichageTabAide.getSelectionModel().getSelectedItem();
     aideselected.setDescriptionAide(bb.getNewValue().toString());
     SA.updatetab(aideselected);
 }

    @FXML
    private void Change_Localisation(TableColumn.CellEditEvent bb) throws SQLException{
     Aide aideselected = AffichageTabAide.getSelectionModel().getSelectedItem();
     aideselected.setLocalisationAide(bb.getNewValue().toString());
     SA.updatetab(aideselected);
    }

    @FXML
    private void Change_Categorie(TableColumn.CellEditEvent bb) throws SQLException{
     Aide aideselected = AffichageTabAide.getSelectionModel().getSelectedItem();
     aideselected.setCategorieAide(bb.getNewValue().toString());
     SA.updatetab(aideselected);
    }

    @FXML
    private void ButtonSupprimer(ActionEvent event) throws SQLException {
                         AffichageTabAide.setItems(data);

             ObservableList<Aide> allDemandes,SingleDemandes ;
             allDemandes=AffichageTabAide.getItems();
             SingleDemandes=AffichageTabAide.getSelectionModel().getSelectedItems();
             Aide A = SingleDemandes.get(0);
             ServiceAide STD = new ServiceAide(); // STD = Service TAB DEMANDE
             SA.delete(A.getAideID());
             SingleDemandes.forEach(allDemandes::remove);
             RechercheAV();

    }

    
}
