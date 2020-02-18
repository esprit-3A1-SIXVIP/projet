/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.projet.IService;


import edu.projet.entite.Article;
import edu.projet.entite.stat;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author House
 */
public interface IService<T> {
    void ajouter(T t) throws SQLException;
    boolean delete(T t) throws SQLException;
    boolean deletetar() throws SQLException;
    boolean update(T t) throws SQLException;
    List<T> readAll() throws SQLException;
   List< Integer > readAllid()throws SQLException;
stat readAlldon() throws SQLException;
stat readAllaide() throws SQLException;
stat readAllenement() throws SQLException;
    Article findid(Integer  t )  throws SQLException;  
}

