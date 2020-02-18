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
public abstract class Don {

 int donId;
    String typeDon;
     User u;
    String cibleDon;

    public Don() 
    {
          this.donId = (int) (Math.random()*(10000-1));
    }

    public Don( String typeDon, User u, String cibleDon) {
       
        this.donId = (int) (Math.random()*(10000-1));
        this.typeDon = typeDon;
        this.u = u;
        this.cibleDon = cibleDon;
    }


    public User getU() {
        return u;
    }

    public void setU(User u) {
        this.u = u;
    }

    public int getDonId() {
        return donId;
    }

    public void setDonId(int donId) {
        this.donId = donId;
    }


   

  

    public String getTypeDon() {
        return typeDon;
    }

    public void setTypeDon(String typeDon) {
        this.typeDon = typeDon;
    }

    public String getCibleDon() {
        return cibleDon;
    }

    public void setCibleDon(String cibleDon) {
        this.cibleDon = cibleDon;
    }

    @Override
    public String toString() {
        return "Don{" + " typeDon=" + typeDon + ", cibleDon=" + cibleDon + '}';
    }

}
