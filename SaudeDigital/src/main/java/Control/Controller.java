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


/**
 *
 * @author E181
 */
public class Controller {
    
    protected String servidor ="DESKTOP-L1OEKT3";
    protected String banco="SAUDE_DIGITAL";
    protected String usuario="sa";
    protected String senha="orion";
    
    public Connection connectDB() throws ClassNotFoundException{
        Connection connect = null;
        
        String url="jdbc:sqlserver://"+servidor+":databaseName="+banco+":user="+usuario+":password="+senha;
        
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
}
