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
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.input.MouseEvent;
import javafx.util.converter.IntegerStringConverter;
import pidev.DataBase.DataBase;
import pidev.Entite.Beneficiaire;
import pidev.Entite.SendMail;
import pidev.Service.ServiceBeneficiaire;

/**
 * FXML Controller class
 *
 * @author wajih
 */
public class AjouterBeneficiaireController implements Initializable {
    private Statement ste;
    private Connection con;

    @FXML
    private TextField nom;
    @FXML
    private TextField prenom;
    @FXML
    private TextField email;
    @FXML
    private TextField numtel;
    @FXML
    private TextField ville;
    @FXML
    private DatePicker date_naiss;
    @FXML
    private TextField adresseGPS;
    @FXML
    private ComboBox<String> comboBox;
    @FXML
    private Button AjouterBeneficiaire;
    @FXML
    private TableColumn<Beneficiaire, Integer> idtab;
    @FXML
    private TableColumn<Beneficiaire, String> nomtab;
    @FXML
    private TableColumn<Beneficiaire, String> prenomtab;
    @FXML
    private TableColumn<Beneficiaire, String> emailtab;
    @FXML
    private TableColumn<Beneficiaire, Integer> numteltab;
    @FXML
    private TableColumn<Beneficiaire, String> villetab;
    @FXML
    private TableColumn<Beneficiaire, java.sql.Date> datenaisstab;
    @FXML
    private TableColumn<Beneficiaire, String> adressegpstab;
    @FXML
    private TableColumn<Beneficiaire, String> roletab;
    @FXML
    private Button Supprimer;
    @FXML
    private TextField recherche;
    ServiceBeneficiaire stb = new ServiceBeneficiaire();
    
    ObservableList<String> list = FXCollections.observableArrayList("Refugie","Necessiteux");
    private final ObservableList<Beneficiaire> data = FXCollections.observableArrayList();
    @FXML
    private TableView<Beneficiaire> AffichageBeneficiaire;

      public void Aff(){
                        try {
            con = DataBase.getInstance().getConnection();
            ste = con.createStatement();
                        data.clear();

            ResultSet rs = ste.executeQuery("select * from beneficiaire");
            while(rs.next()){
                data.add(new Beneficiaire(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getDate(5),rs.getString(6),rs.getInt(7),rs.getString(8),rs.getString(9)));
            }

        } catch (Exception e) {
                //Logger.getLogger(tab)
        }
               
            idtab.setCellValueFactory(new PropertyValueFactory<>("beneficiaireId"));
            nomtab.setCellValueFactory(new PropertyValueFactory<>("nomBeneficiaire"));
            prenomtab.setCellValueFactory(new PropertyValueFactory<>("prenomBeneficiaire"));
            emailtab.setCellValueFactory(new PropertyValueFactory<>("email"));
            datenaisstab.setCellValueFactory(new PropertyValueFactory<>("dateNaissance"));
            villetab.setCellValueFactory(new PropertyValueFactory<>("ville"));
            numteltab.setCellValueFactory(new PropertyValueFactory<>("telephone"));
            adressegpstab.setCellValueFactory(new PropertyValueFactory<>("adresseGPS"));
            roletab.setCellValueFactory(new PropertyValueFactory<>("role"));

            AffichageBeneficiaire.setItems(data);
            AffichageBeneficiaire.setEditable(true);
            nomtab.setCellFactory(TextFieldTableCell.forTableColumn());
            prenomtab.setCellFactory(TextFieldTableCell.forTableColumn());
            emailtab.setCellFactory(TextFieldTableCell.forTableColumn());
            numteltab.setCellFactory(TextFieldTableCell.forTableColumn(new IntegerStringConverter()));
            villetab.setCellFactory(TextFieldTableCell.forTableColumn());
            adressegpstab.setCellFactory(TextFieldTableCell.forTableColumn());

    }
    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        comboBox.setItems(list);
        Aff();
        RechercheAV();

    }
    
    public void RechercheAV(){
                // Wrap the ObservableList in a FilteredList (initially display all data).
        FilteredList<Beneficiaire> filteredData = new FilteredList<>(data, b -> true);
		
		// 2. Set the filter Predicate whenever the filter changes.
		recherche.textProperty().addListener((observable, oldValue, newValue) -> {
			filteredData.setPredicate(beneficiaire -> {
				// If filter text is empty, display all persons.
								
				if (newValue == null || newValue.isEmpty()) {
					return true;
				}
				
				// Compare first name and last name of every person with filter text.
				String lowerCaseFilter = newValue.toLowerCase();
				
				if (beneficiaire.getNomBeneficiaire().toLowerCase().indexOf(lowerCaseFilter) != -1 ) {
					return true; // Filter matches first name.
				} else if (beneficiaire.getPrenomBeneficiaire().toLowerCase().indexOf(lowerCaseFilter) != -1) {
					return true; // Filter matches last name.
				}
				else if (String.valueOf(beneficiaire.getBeneficiaireId()).indexOf(lowerCaseFilter)!=-1)
				     return true;
				     else  
				    	 return false; // Does not match.
			});
		});
		
		// 3. Wrap the FilteredList in a SortedList. 
		SortedList<Beneficiaire> sortedData = new SortedList<>(filteredData);
		
		// 4. Bind the SortedList comparator to the TableView comparator.
		// 	  Otherwise, sorting the TableView would have no effect.
		sortedData.comparatorProperty().bind(AffichageBeneficiaire.comparatorProperty());
		
		// 5. Add sorted (and filtered) data to the table.
		AffichageBeneficiaire.setItems(sortedData);
    }
    @FXML
    private void AjouterBeneficiaire(MouseEvent event) throws SQLException {
                               con = DataBase.getInstance().getConnection();
             ste = con.createStatement();

                try {
                 int nmt= (int) Integer.valueOf(this.numtel.getText());
                DatePicker tmpdate=(DatePicker) date_naiss;
                String date= (String) tmpdate.getValue().toString();
                date = date.substring(0,4)+'/'+date.substring(5,7)+'/'+date.substring(8);                
                java.util.Date myDate = new java.util.Date(date);
                java.sql.Date sqlDate = new java.sql.Date(myDate.getTime());
                ComboBox tmpcmb = (ComboBox) comboBox;
                
                    String role = (String) tmpcmb.getValue().toString();
                    ServiceBeneficiaire ser =new ServiceBeneficiaire();
                    ser.ajouter(new Beneficiaire(nom.getText(), prenom.getText(),email.getText(),sqlDate,ville.getText(),Integer.valueOf(numtel.getText()),adresseGPS.getText(),role));
                    Aff();
                    RechercheAV();
                    SendMail.sendMail(email.getText(),"Beneficiaire","Beneficiaire Ajouter");

                }
                 catch (SQLException ex) {
                    System.out.println(ex);
                 }
                
                    
    }

    @FXML
    private void Change_Nom(TableColumn.CellEditEvent bb) throws SQLException{
     Beneficiaire beneficiaireselected = AffichageBeneficiaire.getSelectionModel().getSelectedItem();
     beneficiaireselected.setNomBeneficiaire(bb.getNewValue().toString());
     stb.updatetab(beneficiaireselected);
 }
    @FXML
    private void Change_Prenom(TableColumn.CellEditEvent bb) throws SQLException{
     Beneficiaire beneficiaireselected = AffichageBeneficiaire.getSelectionModel().getSelectedItem();
     beneficiaireselected.setPrenomBeneficiaire(bb.getNewValue().toString());
     stb.updatetab(beneficiaireselected);
 }

    @FXML
    private void Change_Email(TableColumn.CellEditEvent bb) throws SQLException{
     Beneficiaire beneficiaireselected = AffichageBeneficiaire.getSelectionModel().getSelectedItem();
     beneficiaireselected.setEmail(bb.getNewValue().toString());
     stb.updatetab(beneficiaireselected);
 }

    @FXML
    private void Change_Numtel(TableColumn.CellEditEvent bb) throws SQLException{
     Beneficiaire beneficiaireselected = AffichageBeneficiaire.getSelectionModel().getSelectedItem();
     beneficiaireselected.setTelephone(Integer.parseInt(bb.getNewValue().toString()));
     stb.updatetab(beneficiaireselected);
 }

    @FXML
    private void Change_Ville(TableColumn.CellEditEvent bb) throws SQLException{
     Beneficiaire beneficiaireselected = AffichageBeneficiaire.getSelectionModel().getSelectedItem();
     beneficiaireselected.setVille(bb.getNewValue().toString());
     stb.updatetab(beneficiaireselected);
 }

    @FXML
    private void Change_AdressGPS(TableColumn.CellEditEvent bb) throws SQLException{
     Beneficiaire beneficiaireselected = AffichageBeneficiaire.getSelectionModel().getSelectedItem();
     beneficiaireselected.setAdresseGPS(bb.getNewValue().toString());
     stb.updatetab(beneficiaireselected);
 }

    @FXML
    private void ButtonSupprimer(ActionEvent event) throws SQLException {
                 AffichageBeneficiaire.setItems(data);

             ObservableList<Beneficiaire> allDemandes,SingleDemandes ;
             allDemandes=AffichageBeneficiaire.getItems();
             SingleDemandes=AffichageBeneficiaire.getSelectionModel().getSelectedItems();
             Beneficiaire A = SingleDemandes.get(0);
             ServiceBeneficiaire STD = new ServiceBeneficiaire(); // STD = Service TAB DEMANDE
             STD.delete(A.getBeneficiaireId());
             SingleDemandes.forEach(allDemandes::remove);
             RechercheAV();
    }
    
}
