
package conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionMYSQL {
    private static String driver = "com.mysql.jdbc.Driver";
    private static String database = "almacen";
    private static String hostname = "localhost";
    private static String port = "3306";
    private static String username = "root";
    private static String password = "";
    private static String connectionURL;
    public static Connection conn;
    
    public ConexionMYSQL(){
        this.connectionURL = "jdbc:mysql://";
        this.connectionURL += hostname + ":" + port + "/" + database;
        this.connectionURL += "?autoReconnect=true&useSSL=false";
        this.getConnection();
    }
    public static Connection getConnection(){
    try {
        Class.forName(driver);
        try {
            conn = DriverManager.getConnection(connectionURL, username, password);
        } catch(SQLException e){
            System.out.println("no se puede conectar:"+e.getMessage());
        }
    } catch (ClassNotFoundException ex){
        System.out.print("la clase "+driver+" no existe en el sistema");
    }
    return conn;
    }
}
