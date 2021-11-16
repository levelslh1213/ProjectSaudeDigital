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
/**
 *
 * @author E181
 */
public class Endereco {
    private String rua;
    private String numero;
    private String bairro;
    private String complemento;
    private String cep;
    private String cidade;
    private String estado;
    
    private Connection db;
    private PreparedStatement statement;
    private ResultSet result;
    private String sql;
    
    public Endereco() throws ClassNotFoundException{
        this.db = new Controller().connectDB();
    }
        
    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
        
    public int insertAddressInDB(Endereco endereco) throws ClassNotFoundException{
        int idEndereco = getNewPrimaryKeyValue();
        if(idEndereco == 0){
            return idEndereco;
        }
        else{
            sql = "INSERT INTO ENDERECO(ID_ENDERECO, RUA, NUMERO, BAIRRO, COMPLEMENTO, CEP, CIDADE, ESTADO)"
                + "VALUES (?, ?, ?, ?, ?, ?, ?, ?)" ;
            
            try {
                db = new Controller().connectDB();
                statement = db.prepareStatement(sql);
                statement.setInt(1, idEndereco);
                statement.setString(2, endereco.getRua());
                statement.setString(3, endereco.getNumero());
                statement.setString(4, endereco.getBairro());
                statement.setString(5, endereco.getComplemento());
                statement.setString(6, endereco.getCep());
                statement.setString(7, endereco.getCidade());
                statement.setString(8, endereco.getEstado());
                statement.execute();
                statement.close();
                
                return idEndereco;
            } catch (SQLException e) {
                e.printStackTrace();
                return 0;
            }
        }
    }
    
    private int getNewPrimaryKeyValue() throws ClassNotFoundException{
        sql = "SELECT NEXT VALUE FOR SEQ_ID_ENDERECO AS ID_ENDERECO";
        int retorno = 0;
        try {
            db = new Controller().connectDB();
            statement = db.prepareStatement(sql);
            result = statement.executeQuery();
            result.next();
            retorno = result.getInt("ID_ENDERECO");
            statement.close();
            return retorno;
        } catch (SQLException e) {
            return 0;
        }
    }
}
