package clases;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DataBase {
    
    Connection conexion;
    Statement manipularDB;
 
    public DataBase (){
        String hostname = "localhost";
        String user_name = "root";
        String database_name = "app_java";
        String puerto = "3306";
        String password = "";
        
        String url = "jdbc:mysql://"+hostname+":"+puerto+"/"+database_name;
        
        try {
            this.conexion = DriverManager.getConnection(url, user_name, password);
            this.manipularDB = this.conexion.createStatement();
            System.out.print("Conexion a DataBase exitosa");
        } catch (SQLException ex) {
            System.out.print("Error en conexion a base de datos: " + ex.getMessage());
        }
    }
    
    public boolean insertarPersona(String cedula, String nombres, String apellidos, String telefono, String direccion, String email){
        
        boolean respuesta = false;
        
        try {
            String consulta = "INSERT INTO personas (cedula, nombres, apellidos, telefono, direccion, email) VALUES('"+cedula+"','"+nombres+"','"+apellidos+"','"+telefono+"','"+direccion+"','"+email+"')";
            int resultado = this.manipularDB.executeUpdate(consulta);
            if (resultado==1){
                respuesta = true;
            }
        } catch (SQLException ex) {
            System.out.print("Error al insertar: " + ex.getMessage());
        }   
        
        return respuesta;        
    }
    
    
    public boolean actualizarPersona(String cedula, String nombres, String apellidos, String telefono, String direccion, String email) {
        boolean respuesta = false;
        try {
            String consulta = "UPDATE personas SET nombres = '" + nombres + "', apellidos = '" + apellidos + "', telefono = '" + telefono + "', direccion = '" + direccion + "', email = '" + email + "' WHERE cedula = '" + cedula + "'";
            int resultado = this.manipularDB.executeUpdate(consulta);
            respuesta = (resultado == 1);
        } catch (SQLException ex) {
            System.out.print("Error al actualizar persona: " + ex.getMessage());
        }
    return respuesta;
    }
    
    public boolean eliminarPersona(String cedula) {
    boolean respuesta = false;
    try {
        String consulta = "DELETE FROM personas WHERE cedula = '" + cedula + "'";
        int resultado = this.manipularDB.executeUpdate(consulta);
        respuesta = (resultado == 1);
    } catch (SQLException ex) {
        System.out.print("Error al eliminar persona: " + ex.getMessage());
    }
    return respuesta;
}


    public ResultSet buscarPersonaPorCedula(int cedula) {
        ResultSet persona = null;
        try {
            String consulta = "SELECT * FROM personas WHERE cedula = " + cedula + "";
            persona = this.manipularDB.executeQuery(consulta);
            if (persona.next()){
                return persona;
            }else{
                return null;
            }
        } catch (SQLException ex) {
            System.out.print("Error al buscar persona: " + ex.getMessage());
        }
        return persona;
    }
    
    public ResultSet listaPersonas(){
        
        ResultSet listado = null;
        try {
            String consulta = "SELECT * FROM personas";
            listado = this.manipularDB.executeQuery(consulta);
            
            listado.next();
            
            if (listado.getRow() == 1){
                return listado;
            }else{
                return null;
            }
        } catch (SQLException ex) {
            System.out.print("Error en SELECT: "+ ex.getMessage());
        }
        
        return listado;
    }
    
}
