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
public class EmpleadosDali {
    
    private Connection con;
    private Conexion cn = new Conexion();
    private PreparedStatement ps;
    private ResultSet rs;

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
    
     public int registrar(Empleado empleado, Usuario us) {
        int resultado = 0;
        String sql = "INSERT INTO vendedor (dni_vendedor, nombre_vendedor,correo) VALUES (?, ?, ?)";
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

}
