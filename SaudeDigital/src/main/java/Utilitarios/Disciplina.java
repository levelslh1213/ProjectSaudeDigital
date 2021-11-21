/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utilitarios;
import Control.Controller;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.sql.Connection;
import java.sql.PreparedStatement;

/**
 *
 * @author paulo
 */
public class Disciplina {    
    public ResultSet disciplinas;
    private Connection db;
    private PreparedStatement statement;
    private ResultSet result;
    private String sql;
    
    
    public Disciplina() throws ClassNotFoundException{
        this.disciplinas = preencherDisciplinas();
    }
    
    
    private ResultSet preencherDisciplinas() throws ClassNotFoundException{
        sql = "SELECT * FROM DISCIPLINA";
        try {
            db = new Controller().connectDB();
            statement = db.prepareStatement(sql);
            result = statement.executeQuery();
            return result;
        } catch (SQLException e) {
            return null;
        }
    }
    
    
}
