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
    
    protected Usuario usuario;
    
    public Profissional() throws ClassNotFoundException{
        this.db = new Controller().connectDB();
    }
    
    public String getCro() {
        return cro;
    }

    public void setCro(String cro) {
        this.cro = cro;
    }  
    
    public int insertProfessionalInDB(Profissional profissional, int idEndereco, int idUsuario) throws ClassNotFoundException, ParseException{
        int idProfissional = getNewPrimaryKeyValue();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy"); 
        
        if(idProfissional == 0){
            return 0;
        }
        else{
            sql = "INSERT INTO PROFISSIONAL(ID_PROFISSIONAL, ID_ENDERECO, NOME, DATA_NASCIMENTO, SEXO, RG, CPF, TELEFONE, EMAIL, CRO, ID_USUARIO)"
                + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)" ;
            
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
                statement.setInt(11, idUsuario);
                statement.execute();
                statement.close();
                
                return idProfissional;
            } catch (SQLException se) {
                return 0;
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
    
    public int getAddressByProfessionalId(int idProfissional) throws ClassNotFoundException{
        sql = "SELECT ID_ENDERECO FROM PROFISSIONAL WHERE ID_PROFISSIONAL = ?";
        int retorno = 0;
        try {
            db = new Controller().connectDB();
            statement = db.prepareStatement(sql);
            statement.setInt(1, idProfissional);
            result = statement.executeQuery();
            result.next();
            retorno = result.getInt("ID_ENDERECO");
            statement.close();
            return retorno;
        } catch (SQLException e) {
            return 0;
        }
    }
    
     public String updateProfissionalInDB(Profissional profissional, int idProfissional) throws ClassNotFoundException{
        sql = "UPDATE PROFISSIONAL   SET CPF =?, CRO = ?, DATA_NASCIMENTO = ?, EMAIL = ?, NOME = ?, RG = ?, SEXO = ?, TELEFONE = ? WHERE ID_PROFISSIONAL = ?";
        try {
            db = new Controller().connectDB();
                statement = db.prepareStatement(sql);
                statement.setString(1, profissional.getCpf());
                statement.setString(2, profissional.getCro());
                statement.setString(3, profissional.getDataNascimento());
                statement.setString(4, profissional.getEmail());
                statement.setString(5, profissional.getNome());
                statement.setString(6, profissional.getRg());
                statement.setString(7, profissional.getSexo());
                statement.setString(8, profissional.getTelefone());
                statement.setInt(9, idProfissional);
                statement.executeUpdate();
                statement.close();
                return "sucesso";
        } catch (SQLException e) {
            return e.getMessage();
        }
    }
     
    public String deleteProfissionalFromDB(int idProfissional) throws ClassNotFoundException{
        sql = "DELETE FROM PROFISSIONAL WHERE ID_PROFISSIONAL = ?";
        try {
            db = new Controller().connectDB();
                statement = db.prepareStatement(sql);
                statement.setInt(1, idProfissional);
                statement.executeUpdate();
                statement.close();
                return "Sucesso";
        } catch (SQLException e) {
            return e.getMessage();
        }
    }
}
