
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Javier
 */
public class BaseDeDatos {
    
    private Connection connection;
    private Statement statement;
    private ResultSet resulSet;
    
    public BaseDeDatos(){
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost/test");
            statement = connection.createStatement();
        } catch (SQLException ex) {
            Logger.getLogger(BaseDeDatos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void ejecutar(String sql ){
        try {
            statement.execute(sql);
        } catch (SQLException ex) {
            Logger.getLogger(BaseDeDatos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void main(String[] args){
        BaseDeDatos bd = new BaseDeDatos();
        bd.ejecutar("CREATE TABLE `test`.`TABLA_01` ( "
                + "`CODIGO` INT NOT NULL AUTO_INCREMENT , "
                + "`NOMBRE` VARCHAR(50) NOT NULL , "
                + "`POSICION` VARCHAR(50) NOT NULL , "
                + "`SALARIO` INT NOT NULL , "
                + "PRIMARY KEY (`CODIGO`) )");
    }
    
}
