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
public class Supervisor extends Pessoa {
    private int idDisciplina;
    private String cro;
    
    private Connection db;
    private PreparedStatement statement;
    private ResultSet result;
    private String sql;
    
    public int getIdDisciplina() {
        return idDisciplina;
    }

    public void setIdDisciplina(int idDisciplina) {
        this.idDisciplina = idDisciplina;
    }

    public String getCro() {
        return cro;
    }

    public void setCro(String cro) {
        this.cro = cro;
    }
    
    public int insertSupervisorInDB(Supervisor supervisor, int idEndereco, int idUsuario) throws ClassNotFoundException, ParseException{
        int idSupervisor = getNewPrimaryKeyValue();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy"); 
        
        if(idSupervisor == 0){
            return 0;
        }
        else{
            sql = "INSERT INTO SUPERVISOR(ID_SUPERVISOR, ID_DISCIPLINA, ID_ENDERECO, NOME, DATA_NASCIMENTO, SEXO, RG, CPF, TELEFONE, EMAIL, CRO, ID_USUARIO)"
                + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?)" ;
            
            try {
                db = new Controller().connectDB();
                statement = db.prepareStatement(sql);
                statement.setInt(1, idSupervisor);
                statement.setInt(2, supervisor.getIdDisciplina());
                statement.setInt(3, idEndereco);
                statement.setString(4, supervisor.getNome());
                statement.setString(5, supervisor.getDataNascimento());
                statement.setString(6, supervisor.getSexo());
                statement.setString(7, supervisor.getRg());
                statement.setString(8, supervisor.getCpf());
                statement.setString(9, supervisor.getTelefone());
                statement.setString(10, supervisor.getEmail());
                statement.setString(11, supervisor.getCro());
                statement.setInt(12, idUsuario);
                statement.execute();
                statement.close();
                
                return idSupervisor;
            } catch (SQLException se) {
                return 0;
            }
        }
    }
    
        public int getNewPrimaryKeyValue() throws ClassNotFoundException{
        sql = "SELECT NEXT VALUE FOR SEQ_ID_SUPERVISOR AS ID_SUPERVISOR";
        int retorno = 0;
        try {
            db = new Controller().connectDB();
            statement = db.prepareStatement(sql);
            result = statement.executeQuery();
            result.next();
            retorno = result.getInt("ID_SUPERVISOR");
            statement.close();
            return retorno;
        } catch (SQLException e) {
            return 0;
        }
    }
    
}
