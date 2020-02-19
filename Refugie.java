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
public class Refugie extends Beneficiaire {
    private String nationalite;

    @Override
    public String toString() {
        super.toString();
        return "Refugie{" + "nationalite=" + nationalite + '}';
    }

    public void setNationalite(String nationalite) {
        this.nationalite = nationalite;
    }

    public String getNationalite() {
        return nationalite;
    }

    public Refugie(int beneficiaireId, String nomBeneficiaire, String prenomBeneficiaire, String email, java.sql.Date dateNaissance, String ville, int telephone, String adresseGPS, String role,String nationalite) {
        super(beneficiaireId, nomBeneficiaire, prenomBeneficiaire, email, dateNaissance, ville, telephone, adresseGPS, role);
        this.nationalite=nationalite;
    }
        public Refugie(String nomBeneficiaire, String prenomBeneficiaire, String email, java.sql.Date dateNaissance, String ville, int telephone, String adresseGPS, String role,String nationalite) {
        super(nomBeneficiaire, prenomBeneficiaire, email, dateNaissance, ville, telephone, adresseGPS, role);
        this.nationalite=nationalite;
    }

 
}
