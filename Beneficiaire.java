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
public class Beneficiaire {
    
    private int beneficiaireId;

  
    private String nomBeneficiaire;
    private String prenomBeneficiaire;
    private String email;
    private java.sql.Date dateNaissance;
    private String ville;
    private int telephone;
    private String adresseGPS;
    private String role;

    public Beneficiaire(int beneficiaireId, String nomBeneficiaire, String prenomBeneficiaire, String email, java.sql.Date dateNaissance, String ville, int telephone, String adresseGPS, String role) {
        this.beneficiaireId = beneficiaireId;
        this.nomBeneficiaire = nomBeneficiaire;
        this.prenomBeneficiaire = prenomBeneficiaire;
        this.email = email;
        this.dateNaissance = dateNaissance;
        this.ville = ville;
        this.telephone = telephone;
        this.adresseGPS = adresseGPS;
        this.role = role;
    }

      public Beneficiaire(String nomBeneficiaire, String prenomBeneficiaire, String email, java.sql.Date dateNaissance, String ville, int telephone, String adresseGPS, String role) {
        this.nomBeneficiaire = nomBeneficiaire;
        this.prenomBeneficiaire = prenomBeneficiaire;
        this.email = email;
        this.dateNaissance = dateNaissance;
        this.ville = ville;
        this.telephone = telephone;
        this.adresseGPS = adresseGPS;
        this.role = role;
    }

     

    public int getBeneficiaireId() {
        return beneficiaireId;
    }

    public String getNomBeneficiaire() {
        return nomBeneficiaire;
    }

    public String getPrenomBeneficiaire() {
        return prenomBeneficiaire;
    }

    public String getVille() {
        return ville;
    }

    public String getEmail() {
        return email;
    }

    public int getTelephone() {
        return telephone;
    }

    public java.sql.Date getDateNaissance() {
        return dateNaissance;
    }

    public String getRole() {
        return role;
    }


    public String getAdresseGPS() {
        return adresseGPS;
    }

     

    public void setNomBeneficiaire(String nomBeneficiaire) {
        this.nomBeneficiaire = nomBeneficiaire;
    }

    public void setPrenomBeneficiaire(String prenomBeneficiaire) {
        this.prenomBeneficiaire = prenomBeneficiaire;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setTelephone(int telephone) {
        this.telephone = telephone;
    }

    public void setDateNaissance(java.sql.Date dateNaissance) {
        this.dateNaissance = dateNaissance;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public void setAdresseGPS(String adresseGPS) {
        this.adresseGPS = adresseGPS;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 29 * hash + this.beneficiaireId;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Beneficiaire other = (Beneficiaire) obj;
        return this.beneficiaireId == other.beneficiaireId;
    }

    @Override
    public String toString() {
        return "Beneficiaire{" + "beneficiaireID=" + beneficiaireId + ", nomBeneficiaire=" + nomBeneficiaire + ", prenomBeneficiaire=" + prenomBeneficiaire + " ville=" + ville + ", email=" + email + ", telephone=" + telephone + ", dateNaissance=" + dateNaissance + ", role=" + role + ", adresseGPS=" + adresseGPS + '}';
    }
    
    
    
}
