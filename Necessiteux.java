/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pidev.Entite;

import java.util.Date;


/**
 *
 * @author USER
 */
public class Necessiteux extends Beneficiaire{
    private String besoin;

    public Necessiteux(int beneficiaireId, String nomBeneficiaire, String prenomBeneficiaire, String email, java.sql.Date dateNaissance, String ville, int telephone, String adresseGPS, String role,String besoin) {
        super(beneficiaireId, nomBeneficiaire, prenomBeneficiaire, email, dateNaissance, ville, telephone, adresseGPS, role);
        this.besoin=besoin;
    }
    public Necessiteux(String nomBeneficiaire, String prenomBeneficiaire, String email, java.sql.Date dateNaissance, String ville, int telephone, String adresseGPS, String role,String besoin) {
        super(nomBeneficiaire, prenomBeneficiaire, email, dateNaissance, ville, telephone, adresseGPS, role);
        this.besoin=besoin;
    }
    
}
