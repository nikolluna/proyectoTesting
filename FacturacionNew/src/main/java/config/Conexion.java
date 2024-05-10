/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package config;

import java.sql.Connection;
import java.sql.DriverManager;
/**
 *
 * @author saman
 */
public class Conexion {
    Connection con;
    String url = "jdbc:mysql://localhost:3306/UserApp";
    String user ="root";
    String pass = "12345678";
    
    public Connection getConexion(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection(url,user,pass);
        } catch(Exception e){
          System.out.println(e.getMessage());
        }
        return con;
    }   
    public static void main(String[] args) {
        Conexion conexion = new Conexion();
        Connection con = conexion.getConexion();
        if (con != null) {
            System.out.println("Conexión exitosa");
            // Aquí puedes agregar más código para realizar operaciones con la conexión
            // por ejemplo, consultar datos de la base de datos.
        } else {
            System.out.println("Fallo en la conexión");
        }
    }
}
