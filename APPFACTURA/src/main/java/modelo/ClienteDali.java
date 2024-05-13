package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import clases.Clientes;
import modelo.Usuario;  // Asegúrate de tener esta clase en tu modelo si es necesario para el contexto.

public class ClienteDali {
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

    // Método para enviar información del cliente a la base de datos
    public int enviar(Clientes cliente, Usuario usuario) {
        int resultado = 0;
        System.out.println("Cliente llego");
        String sql = "INSERT INTO cliente (ruc_cliente, nombre_cliente, direccion_cliente, correo_user) VALUES (?, ?, ?, ?)";
        try {
            abrirConexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, cliente.getRucCliente());
            ps.setString(2, cliente.getNombreCliente());
            ps.setString(3, cliente.getDireccionCliente());
            ps.setString(4, usuario.getCorreo());  // Suponiendo que `Usuario` tiene un método getCorreo()
            resultado = ps.executeUpdate();
            return resultado;
        } catch (SQLException e) {
            e.printStackTrace();
            return 0;
        } finally {
            cerrarConexion();
        }
    }

    // Método para buscar un cliente por RUC
    /*public Clientes buscarPorRuc(String rucCliente) {
        Clientes cliente = null;
        String sql = "SELECT * FROM clientes WHERE ruc_cliente = ?";
        try {
            abrirConexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, rucCliente);
            rs = ps.executeQuery();
            if (rs.next()) {
                cliente = new Clientes(
                        rs.getString("ruc_cliente"),
                        rs.getString("nombre_cliente"),
                        rs.getString("direccion_cliente"),
                        rs.getString("correo_user")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            cerrarConexion();
        }
        return cliente;
    }*/
}
