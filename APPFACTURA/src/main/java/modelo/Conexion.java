package modelo;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
    private final String URL = "jdbc:mysql://localhost:3306/UserApp";
    private final String USUARIO = "root";
    private final String CONTRASEÑA = "root";
    private Connection conexion = null;

    public Connection getConnection() {
        if (conexion == null) {
            try {
            	Class.forName("com.mysql.jdbc.Driver");
                conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/UserApp","root","root");
            } catch (ClassNotFoundException e) {
                System.out.println("No se encontró el driver JDBC: " + e.getMessage());
            } catch (SQLException e) {
                System.out.println("Error al intentar conectar: " + e.getMessage());
            }
        }
        return conexion;
    }

    public void cerrarConexion() {
        if (conexion != null) {
            try {
                conexion.close();
            } catch (SQLException e) {
                System.out.println("Error al cerrar la conexión: " + e.getMessage());
            }
        }
    }
}