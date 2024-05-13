package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import clases.Empleado;
import modelo.Usuario;  // Asumiendo que podría necesitar información de usuario en algún contexto.

public class EmpleadoDali {
    private Connection con;
    private Conexion cn = new Conexion();
    private PreparedStatement ps;
    private ResultSet rs;

    public void abrirConexion() throws SQLException {
        con = cn.getConnection();
    }

    public void cerrarConexion() {
        try {
            if (con != null) {
                con.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Método para registrar un nuevo empleado en la base de datos
    public int registrar(Empleado empleado, Usuario us) {
        int resultado = 0;
        String sql = "INSERT INTO vendedor (dni, nombre_vendedor,correo) VALUES (?, ?, ?)";
        try {
            abrirConexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, empleado.getDni());
            ps.setString(2, empleado.getNombreVendedor());
            ps.setString(3, us.getCorreo());
            resultado = ps.executeUpdate();
            return resultado;
        } catch (SQLException e) {
            e.printStackTrace();
            return 0;
        } finally {
            cerrarConexion();
        }
    }

    // Método para buscar un empleado por correo
   /* public Empleado buscarPorCorreo(String correo) {
        Empleado empleado = null;
        String sql = "SELECT * FROM empleados WHERE correo = ?";
        try {
            abrirConexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, correo);
            rs = ps.executeQuery();
            if (rs.next()) {
                empleado = new Empleado(
                        rs.getString("correo"),
                        rs.getString("nombre"),
                        rs.getString("direccion")
                );
            }
        } catch (SQLException e) {
      */
}