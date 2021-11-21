/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Utilitarios.ManipulaData;
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
 * @author E181
 */
public class Paciente extends Pessoa {
    private float peso;
    private float altura;
    private String cor;
    private String escolaridade;
    private String profissao;
    private String estadoCivil;
    private String naturalidade;
    private String estado;
    
    private Connection db;
    private PreparedStatement statement;
    private ResultSet result;
    private String sql;
    
    public float getPeso() {
        return peso;
    }

    public void setPeso(float peso) {
        this.peso = peso;
    }

    public float getAltura() {
        return altura;
    }

    public void setAltura(float altura) {
        this.altura = altura;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public String getEscolaridade() {
        return escolaridade;
    }

    public void setEscolaridade(String escolaridade) {
        this.escolaridade = escolaridade;
    }

    public String getProfissao() {
        return profissao;
    }

    public void setProfissao(String profissao) {
        this.profissao = profissao;
    }

    public String getEstadoCivil() {
        return estadoCivil;
    }

    public void setEstadoCivil(String estadoCivil) {
        this.estadoCivil = estadoCivil;
    }

    public String getNaturalidade() {
        return naturalidade;
    }

    public void setNaturalidade(String naturalidade) {
        this.naturalidade = naturalidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }    
    
    
    public int getNewPrimaryKeyValue() throws ClassNotFoundException{
        sql = "SELECT NEXT VALUE FOR SEQ_ID_PACIENTE AS ID_PACIENTE";
        int retorno = 0;
        try {
            db = new Controller().connectDB();
            statement = db.prepareStatement(sql);
            result = statement.executeQuery();
            result.next();
            retorno = result.getInt("ID_PACIENTE");
            statement.close();
            return retorno;
        } catch (SQLException e) {
            return 0;
        }
    }
    
    public int InsertPersonsInfo(Paciente paciente) throws ClassNotFoundException, ParseException{
        int idPaciente = getNewPrimaryKeyValue();
        
        if(idPaciente == 0){
            return 0;
        }
        else{
            sql = "INSERT INTO PACIENTE (ID_PACIENTE, NOME, DATA_NASCIMENTO, SEXO, RG, CPF, TELEFONE, EMAIL) VALUES(?, ?, ?, ?, ?, ?,?,?)";
            
            try {
                db = new Controller().connectDB();
                statement = db.prepareStatement(sql);
                statement.setInt(1, idPaciente);
                statement.setString(2, paciente.getNome());
                statement.setString(3, paciente.getDataNascimento());
                statement.setString(4, paciente.getSexo());
                statement.setString(5, paciente.getRg());
                statement.setString(6, paciente.getCpf());
                statement.setString(7, paciente.getTelefone());
                statement.setString(8, paciente.getEmail());
                statement.execute();
                statement.close();
                
                return idPaciente;
            } catch (SQLException se) {
                return 0;
            }
        }
    }
    
    public int getPacienteByCpf(String cpf) throws ClassNotFoundException{
        sql = "SELECT ID_PACIENTE FROM PACIENTE WHERE CPF = ?";
        int retorno = 0;
        try {
            db = new Controller().connectDB();
            statement = db.prepareStatement(sql);
            statement.setString(1, cpf);
            result = statement.executeQuery();
            result.next();
            retorno = result.getInt("ID_PACIENTE");
            return retorno;
        } catch (SQLException e) {
            return 0;
        }
    }
    
    public String insertFichaInfoInDB(Paciente paciente, int idEndereco, int idPaciente) throws ClassNotFoundException{
        sql = "UPDATE PACIENTE    SET ID_ENDERECO = ?, PESO = ?, ALTURA = ?, COR = ?, ESCOLARIDADE = ?, ESTADO_CIVIL = ?, NATURALIDADE = ?, ESTADO = ? WHERE ID_PACIENTE = ?";
        try {
            db = new Controller().connectDB();
                statement = db.prepareStatement(sql);
                statement.setInt(1, idEndereco);
                statement.setFloat(2, paciente.getPeso());
                statement.setFloat(3, paciente.getAltura());
                statement.setString(4, paciente.getCor());
                statement.setString(5, paciente.getEscolaridade());
                statement.setString(6, paciente.getEstadoCivil());
                statement.setString(7, paciente.getNaturalidade());
                statement.setString(8, paciente.getEstado());
                statement.setInt(9, idPaciente);
                statement.executeUpdate();
                statement.close();
                return "sucesso";
        } catch (SQLException e) {
            return e.getMessage();
        }
    }
}
