/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

/**
 *
 * @author amisa
 */
public class Beneficiaire {
     protected int beneficiaireId;
     protected String nomBeneficiaire;
  protected String prenomBeneficiaire;
    protected String email;
    protected String dateNaissance;
    protected String national;
    protected String ville;
    protected String rue;
    protected String telephone;
    protected String adresseGPS;
    protected String role;

    public String getNational() {
        return national;
    }

    public void setNational(String national) {
        this.national = national;
    }

    public int getBeneficiaireId() {
        return beneficiaireId;
    }

    public void setBeneficiaireId(int beneficiaireId) {
        this.beneficiaireId = beneficiaireId;
    }

    public String getNomBeneficiaire() {
        return nomBeneficiaire;
    }

    public void setNomBeneficiaire(String nomBeneficiaire) {
        this.nomBeneficiaire = nomBeneficiaire;
    }

    public String getPrenomBeneficiaire() {
        return prenomBeneficiaire;
    }

    public void setPrenomBeneficiaire(String prenomBeneficiaire) {
        this.prenomBeneficiaire = prenomBeneficiaire;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDateNaissance() {
        return dateNaissance;
    }

    public void setDateNaissance(String dateNaissance) {
        this.dateNaissance = dateNaissance;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public String getRue() {
        return rue;
    }

    public void setRue(String rue) {
        this.rue = rue;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getAdresseGPS() {
        return adresseGPS;
    }

    public void setAdresseGPS(String adresseGPS) {
        this.adresseGPS = adresseGPS;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "Beneficiaire{" + "beneficiaireId=" + beneficiaireId + ", nomBeneficiaire=" + nomBeneficiaire + ", prenomBeneficiaire=" + prenomBeneficiaire + ", email=" + email + ", dateNaissance=" + dateNaissance + ", ville=" + ville + ", rue=" + rue + ", telephone=" + telephone + ", adresseGPS=" + adresseGPS + ", role=" + role + '}';
    }
    
    

    
}
