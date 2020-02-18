/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import Entities.Beneficiaire;
import Utils.connexionBD;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author amisa
 */
public class ServiceBeneficiare {

        private Connection con;
        private Statement ste;

    public ServiceBeneficiare() {
        con = connexionBD.getInstance().getConnection();

    }

  
    public void ajouter(Beneficiaire u) throws SQLException {
        ste = con.createStatement();
        String requeteInsert = "INSERT INTO INSERT INTO `beneficiaire`(`nomBeneficiaire`, `prenomBeneficiaire`, `email`, `dateNaissance`, `nationalite`, `ville`, `rue`, `telephone`, `adresseGPS`, `role`)   VALUES ( '" + u.getNomBeneficiaire()+ "', '" + u.getPrenomBeneficiaire()+ "', '" + u.getEmail()+ "', '" + u.getDateNaissance()+ "',  '" + u.getNational()+ "','" + u.getEmail()+ "', '" + u.getVille()+ "', '" + u.getRue()+ "',  '" + u.getTelephone()+ "','" + u.getAdresseGPS()+ "', '" + u.getRole()+ "');";
        ste.executeUpdate(requeteInsert);
    }
    
}
