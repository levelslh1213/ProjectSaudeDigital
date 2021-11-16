/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Control.Controller;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 *
 * @author paulo
 */
public class Profissional extends Pessoa {
    private String cro;
    
    private Connection db;
    private PreparedStatement statement;
    private ResultSet result;
    private String sql;
    
    public Profissional() throws ClassNotFoundException{
        this.db = new Controller().connectDB();
    }
    
    public String getCro() {
        return cro;
    }

    public void setCro(String cro) {
        this.cro = cro;
    }  
    
    public String insertProfessionalInDB(Profissional profissional, int idEndereco) throws ClassNotFoundException, ParseException{
        int idProfissional = getNewPrimaryKeyValue();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy"); 
        
        if(idProfissional == 0){
            return "";
        }
        else{
            sql = "INSERT INTO PROFISSIONAL(ID_PROFISSIONAL, ID_ENDERECO, NOME, DATA_NASCIMENTO, SEXO, RG, CPF, TELEFONE, EMAIL, CRO)"
                + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)" ;
            
            try {
                db = new Controller().connectDB();
                statement = db.prepareStatement(sql);
                statement.setInt(1, idProfissional);
                statement.setInt(2, idEndereco);
                statement.setString(3, profissional.getNome());
                statement.setString(4, profissional.getDataNascimento());
                statement.setString(5, profissional.getSexo());
                statement.setString(6, profissional.getRg());
                statement.setString(7, profissional.getCpf());
                statement.setString(8, profissional.getTelefone());
                statement.setString(9, profissional.getEmail());
                statement.setString(10, profissional.getCro());
                statement.execute();
                statement.close();
                
                return "aoba";
            } catch (SQLException se) {
                return se.getMessage();
            }
        }
    }
    
    public int getNewPrimaryKeyValue() throws ClassNotFoundException{
        sql = "SELECT NEXT VALUE FOR SEQ_ID_PROFISSIONAL AS ID_PROFISSIONAL";
        int retorno = 0;
        try {
            db = new Controller().connectDB();
            statement = db.prepareStatement(sql);
            result = statement.executeQuery();
            result.next();
            retorno = result.getInt("ID_PROFISSIONAL");
            statement.close();
            return retorno;
        } catch (SQLException e) {
            return 0;
        }
    }
}
