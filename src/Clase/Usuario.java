
package Clase;

import conexion.ConexionMYSQL;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;

        
        
public class Usuario {
    private int _id_usuario;
    private String _apodo;
    private String _clave;
    private int _vigente;
    
    public Usuario() {
        
    }
    /**
     * valida que el usuario y la contraseña sean validos 
     * @param usuario String Nombre de usuario
     * @param clave   String Clave de acceso
     * @return  boolean 
     */
    public static boolean conectar (String usuario, String clave){
        boolean valido = false;
        ConexionMYSQL sql = new ConexionMYSQL();
        
        String query = "SELECT * FROM usuario WHERE";
        query += " apodo = '" + usuario + "' ";
        query += "AND clave = '" + clave + "'";
        System.out.println(query);
        
      try {  
        Statement s = sql.conn.createStatement();
        ResultSet rs = s.executeQuery(query);
        int filas = 0;
        while(rs.next()){
            filas++;
        }
        if (filas == 1){
            valido = true;
        }
    } catch (SQLException ex){
        Logger.getLogger(Usuario.class.getName()).log(Level.SEVERE, null, ex);
        
    }
      return valido;
   }
}
    
