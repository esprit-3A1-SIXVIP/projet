/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import Entities.Refuge;
import Entities.User;
import Utils.connexionBD;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author amisa
 */
public class ServiceRefuge {

    Connection con;
    Statement ste;

    public ServiceRefuge() {
        con = connexionBD.getInstance().getConnection();

    }

    public void ajouter(Refuge r, User u) {
        try {
            ste = con.createStatement();

            String requetajout = "insert into don(`donId` ,`typeDon` ,`rueRefuge`, `villeRefuge`, `paysRefuge`, `disponibiliteRefuge`, `capaciteRefuge`,`coordonneesgps`,userId) values('" + r.getDonId() + "','Refuge','" + r.getRueRefuge() + "','" + r.getVilleRefuge() + "','" + r.getPaysRefuge() + "','" + r.getDisponibiliteRefuge() + "','" + r.getCapaciteRefuge() + "','" + r.getCoordonneegps() + "','" + chercherUser(u) + "');";
            ste.executeUpdate(requetajout);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

    }

    /**
     *
     * @return
     */
    public int chercher(Refuge u) throws SQLException {
        int id = 0;
        ste = con.createStatement();
        ResultSet rs = ste.executeQuery("select * from don where userId='"+chercherUser(u.getU())+"'and  coordonneegps='" + u.getCoordonneegps()+"'");
        while (rs.next()) {
            id = rs.getInt(1);
        }
        return id;
    }

    public int chercherUser(User u) throws SQLException {

        int x = 0;
        ste = con.createStatement();
        ResultSet rs = ste.executeQuery("select * from user where role='user simple'");
        while (rs.next()) {
            x = rs.getInt(1);

        }
        return x;
    }

    public void supprimer(Refuge r) throws SQLException {
        ste = con.createStatement();
        int id = chercher(r);
        String requeteDelete = "Delete From handshake.don Where userId='" + id + "'";
        ste.executeUpdate(requeteDelete);
    }

    public void modifRefuge(String rue, int disponibilite, int capacite, int id) throws SQLException {

        ste = con.createStatement();
        String sql = "Update don set RueRefuge ='"
                + rue + "', CapaciteRefuge="
                + capacite + ",DisponibiliteRefuge=" + disponibilite + " Where donId="
                + id;
        ste.executeUpdate(sql);

    }

    public List<Refuge> readAll() throws SQLException {
        List<Refuge> arr = new ArrayList<>();
        ste = con.createStatement();
        ResultSet rs = ste.executeQuery("select * from don where typeDon='Refuge'");
        while (rs.next()) {
            int donId = rs.getInt(1);
            String rueRefuge = rs.getString("rueRefuge");
            String villeRefuge = rs.getString("villeRefuge");
            String paysRefuge = rs.getString("paysRefuge");
            String coordonneegps = rs.getString("coordonneegps");
            int disponibiliteRefuge = rs.getInt("disponibiliteRefuge");
            int capaciteRefuge = rs.getInt("capaciteRefuge");

            Refuge p = new Refuge(coordonneegps, rueRefuge, villeRefuge, paysRefuge, disponibiliteRefuge, capaciteRefuge);
            arr.add(p);

        }
        return arr;
    }
}
