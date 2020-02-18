/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.projet.services;


import com.mysql.jdbc.PreparedStatement;
import edu.projet.IService.IService;
import edu.projet.entite.Article;
import edu.projet.entite.stat;
import edu.projet.utils.DataBase;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author med ali
 */
public class ServiceArticle implements IService<Article> {

    private Connection con;
    private Statement ste;
    PreparedStatement statement;

    public ServiceArticle() {
        con = DataBase.getInstance().getConnection();

    }

    public String ToString() {

        return "";
    }

    public static void main(String[] args) {
        System.out.println();
    }

    @Override
    public List<Article> readAll() throws SQLException {
        List<Article> l1 = new ArrayList<Article>();
        ste = con.createStatement();
        String requeteInsert = "select * from `handshake`.`article` ;";
        ResultSet rs = ste.executeQuery(requeteInsert);
        while (rs.next()) {
            String titre = rs.getString("titre");
            String des = rs.getString("descriptionArticle");
            int id = rs.getInt(1);
            int uid = rs.getInt(5);
            Article a1 = new Article(id, titre, des, uid);
            l1.add(a1);
        }
        return l1;
    }

    @Override
    public void ajouter(Article t) throws SQLException {
        ste = con.createStatement();
        String requeteInsert = "INSERT INTO `handshake`.`article` ( `titre`, `descriptionArticle`) VALUES ( '" + t.getTitre() + "', '" + t.getDescription() + "');";
        int rowsUpdated = ste.executeUpdate(requeteInsert);
    }

    @Override
    public boolean delete(Article t) throws SQLException {
        ste = con.createStatement();
        String requeteInsert = "delete  from `handshake`.`article`  where `articleId` = " + t.getId() + ";";
        int rowsUpdated = ste.executeUpdate(requeteInsert);
        return rowsUpdated > 0;
    }

    @Override
    public boolean deletetar() throws SQLException {
        ste = con.createStatement();
        String requeteInsert = "delete from article ;";
        int rowsUpdated = ste.executeUpdate(requeteInsert);
        return rowsUpdated > 0;
    }

    @Override
    public boolean update(Article t) throws SQLException {
        String sql = "UPDATE article SET titre=?, descriptionArticle=? WHERE articleId=?";

        statement = (PreparedStatement) con.prepareStatement(sql);
        statement.setString(1, t.getTitre());
        statement.setString(2, t.getDescription());
        statement.setInt(3, t.getId());

        int rowsUpdated = statement.executeUpdate();

        return rowsUpdated > 0;

    }

    @Override
    public stat readAlldon() throws SQLException {
          List<stat> l1 = new ArrayList<stat>();
        ste = con.createStatement();
        String requeteInsert = "select * from `handshake`.`article` ;";
        ResultSet rs = ste.executeQuery(requeteInsert);
        while (rs.next()) {
            String titre = rs.getString("titre");
            String des = rs.getString("descriptionArticle");
            int id = rs.getInt(1);
            int uid = rs.getInt(5);
            stat s1 = new stat(id, titre, des, uid);
            l1.add(s1);
        }
        stat s1 = null;
        return s1;
    }

    @Override
    public stat readAllaide() throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public stat readAllenement() throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Article findid(Integer i) throws SQLException {
     ste = con.createStatement();
        String requeteInsert = "select * from `handshake`.`article`  where `articleId` = " + i + ";";
        ResultSet rs = ste.executeQuery(requeteInsert);
       Article a1 = null;
       while (rs.next()) {
            String titre = rs.getString("titre");
            String des = rs.getString("descriptionArticle");
            int id = rs.getInt(1);
            int uid = rs.getInt(5);
            a1 = new Article(id, titre, des, uid);
            
        }
        
        return a1;
       
    }

    @Override
    public List<Integer> readAllid() throws SQLException {
      List<Integer> l1 = new ArrayList<Integer>();
        ste = con.createStatement();
        String requeteInsert = "select articleid from `handshake`.`article` ;";
        ResultSet rs = ste.executeQuery(requeteInsert);
        while (rs.next()) {
            int id = rs.getInt(1);
            l1.add(id);
        }
        return l1;

    }
}
