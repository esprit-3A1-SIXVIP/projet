/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

import java.util.UUID;

/**
 *
 * @author amisa
 */
public class Refuge extends Don {

    String rueRefuge;
    String villeRefuge;
    String paysRefuge;
    String coordonneegps;
    int disponibiliteRefuge;
    int capaciteRefuge;

    public Refuge() {
        super();
    }

    public Refuge(String coordonneegps,String rueRefuge, String villeRefuge, String paysRefuge, int disponibiliteRefuge, int capaciteRefuge, String typeDon, User u, String cibleDon) {
        super(typeDon, u, cibleDon);
        this.coordonneegps=coordonneegps;
        this.rueRefuge = rueRefuge;
        this.villeRefuge = villeRefuge;
        this.paysRefuge = paysRefuge;
        this.disponibiliteRefuge = disponibiliteRefuge;
        this.capaciteRefuge = capaciteRefuge;
    }

   

  

 


    public Refuge(String coordonneegps,String rueRefuge, String villeRefuge, String paysRefuge, int disponibiliteRefuge, int capaciteRefuge) {
        this.coordonneegps=coordonneegps;
        this.rueRefuge = rueRefuge;
        this.villeRefuge = villeRefuge;
        this.paysRefuge = paysRefuge;
        this.disponibiliteRefuge = disponibiliteRefuge;
        this.capaciteRefuge = capaciteRefuge;
    }

    public String getCoordonneegps() {
        return coordonneegps;
    }

    public void setCoordonneegps(String coordonneegps) {
        this.coordonneegps = coordonneegps;
    }





    public String getRueRefuge() {
        return rueRefuge;
    }

    public void setRueRefuge(String rueRefuge) {
        this.rueRefuge = rueRefuge;
    }

    public String getVilleRefuge() {
        return villeRefuge;
    }

    public void setVilleRefuge(String villeRefuge) {
        this.villeRefuge = villeRefuge;
    }

    public String getPaysRefuge() {
        return paysRefuge;
    }

    public void setPaysRefuge(String paysRefuge) {
        this.paysRefuge = paysRefuge;
    }

    public int getDisponibiliteRefuge() {
        return disponibiliteRefuge;
    }

    public void setDisponibiliteRefuge(int disponibiliteRefuge) {
        this.disponibiliteRefuge = disponibiliteRefuge;
    }

    public int getCapaciteRefuge() {
        return capaciteRefuge;
    }

    public void setCapaciteRefuge(int capaciteRefuge) {
        this.capaciteRefuge = capaciteRefuge;
    }

    public int getDonId() {
        return donId;
    }

    public void setDonId(int donId) {
        this.donId = donId;
    }



    public User getU() {
        return u;
    }

    public void setU(User u) {
        this.u = u;
    }

 

    @Override
    public String getTypeDon() {
        return typeDon;
    }

    @Override

    public void setTypeDon(String typeDon) {
        this.typeDon = typeDon;
    }

    @Override
    public String getCibleDon() {
        return cibleDon;
    }

    @Override
    public void setCibleDon(String cibleDon) {
        this.cibleDon = cibleDon;
    }

    @Override
    public String toString() {
        return "\nRefuge{" + super.toString() + "rueRefuge=" + rueRefuge + ", villeRefuge=" + villeRefuge + ", paysRefuge=" + paysRefuge + ", disponibiliteRefuge=" + disponibiliteRefuge + ", capaciteRefuge=" + capaciteRefuge + '}';
    }

}
