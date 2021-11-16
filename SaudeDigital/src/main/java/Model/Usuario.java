/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Control.Controller;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 *
 * @author paulo
 */
public class Usuario {
    private String login;
    private String senha;
    
    private Connection db;
    private PreparedStatement statement;
    private ResultSet result;
    private String sql;

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
    
    public int insertUserInDB(Usuario usuario) throws ClassNotFoundException{
        int idUsuario = getNewPrimaryKeyValue();
        
        if(idUsuario == 0){
            return 0;
        }
        else{
            sql = "INSERT INTO USUARIO(ID_USUARIO, LOGIN, SENHA)"
                + "VALUES (?,?,?)" ;
            
            try {
                db = new Controller().connectDB();
                statement = db.prepareStatement(sql);
                statement.setInt(1, idUsuario);
                statement.setString(2, usuario.getLogin());
                statement.setString(3, usuario.getSenha());
                statement.execute();
                statement.close();
                return idUsuario;
            } catch (SQLException se) {
                se.printStackTrace();
                return 0;
            }            
        }
    }
    
    private int getNewPrimaryKeyValue() throws ClassNotFoundException{
        sql = "SELECT NEXT VALUE FOR SEQ_ID_USUARIO AS ID_USUARIO";
        int retorno = 0;
        try {
            db = new Controller().connectDB();
            statement = db.prepareStatement(sql);
            result = statement.executeQuery();
            result.next();
            retorno = result.getInt("ID_USUARIO");
            statement.close();
            return retorno;
        } catch (SQLException e) {
            return 0;
        }
    }
}
