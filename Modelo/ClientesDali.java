/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import config.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author saman
 */
public class ClientesDali {
    Connection con;
    Conexion cn = new Conexion();
    PreparedStatement ps;
    ResultSet rs;
    int res = 0;

    public void abrirConexion() throws SQLException {
        con = cn.getConexion();
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

    public int enviar(Cliente cliente, Usuario us) {
        int resultado = 0;
        String sql = "INSERT INTO cliente (ruc_cliente, nombre_cliente, direccion_cliente, correo_user) VALUES (?, ?, ?, ?)";
        try {
            abrirConexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, cliente.getRucCliente());
            ps.setString(2, cliente.getNombreCliente());
            ps.setString(3, cliente.getDireccionCliente());
            ps.setString(4, us.getCorreo());
            resultado = ps.executeUpdate();
            return 1;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resultado;
    }

}
