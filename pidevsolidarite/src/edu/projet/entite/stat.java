/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.projet.entite;

import java.sql.Date;

/**
 *
 * @author med ali
 */
public class stat {
private Date parDate1;
private Date parDate2;
private String crit1;
private String crit2;
private int int1 ;
private int int2;

    public stat(int id, String titre, String des, int uid) {
     
    }

    public stat(int id, int id1) {
     int1=id;
     int2=id1;
    }

    public Date getParDate1() {
        return parDate1;
    }

    public void setParDate1(Date parDate1) {
        this.parDate1 = parDate1;
    }

    public Date getParDate2() {
        return parDate2;
    }

    public void setParDate2(Date parDate2) {
        this.parDate2 = parDate2;
    }

    public String getCrit1() {
        return crit1;
    }

    public void setCrit1(String crit1) {
        this.crit1 = crit1;
    }

    public String getCrit2() {
        return crit2;
    }

    public void setCrit2(String crit2) {
        this.crit2 = crit2;
    }

    public int getInt1() {
        return int1;
    }

    public void setInt1(int int1) {
        this.int1 = int1;
    }

    public int getInt2() {
        return int2;
    }

    public void setInt2(int int2) {
        this.int2 = int2;
    }

    public stat(int id) {
      int1=id;
    }
        

}
