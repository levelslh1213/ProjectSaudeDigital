/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import static java.lang.System.out;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;


/**
 *
 * @author E181
 */
public class Controller {
    private String servidor;
    private String banco;
    private String usuario;
    private String senha;
    
    public String getServidor() {
        return servidor;
    }

    public void setServidor(String servidor) {
        this.servidor = servidor;
    }

    public String getBanco() {
        return banco;
    }

    public void setBanco(String banco) {
        this.banco = banco;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
    
    public Controller(){
        insertConnectionInfo();
    }
    
    public void insertConnectionInfo(){
        setServidor("DESKTOP-L1OEKT3");
        setBanco("SAUDE_DIGITAL");
        setUsuario("sa");
        setSenha("orion");
    }
    
    public Connection connectDB() throws ClassNotFoundException{
        Connection connect = null;
        
        String url="jdbc:sqlserver://"+getServidor()+":databaseName="+getBanco()+":user="+getUsuario()+":password="+getSenha();
        
        try {
            Class.forName("com.microsoft.jdbc.SQLServerDriver");
            connect = DriverManager.getConnection(url);
        } catch (ClassNotFoundException e) {
            out.print(e);
        } catch (SQLException se){
            out.print(se);
        }
       return connect; 
    }
    
    public boolean beginTransaction() {
        return true;
    }
}
