/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Modelo.CabeceraFactura;
import config.Conexion;

public class CabeceraDali{
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
    
   
    public int guardar(CabeceraFactura caf, Usuario us) {
        int resultado = 0;
        String sql = "INSERT INTO cabecera_factura (fecha, ruc_cliente, codigo_vendedor, correo, sub_total, igv, total_factura) VALUES (?, ?, ?, ?, ?, ?,?)";
        try {
            abrirConexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, caf.getFecha());
            ps.setString(2, caf.getRuc_cliente());
            ps.setString(3, caf.getCodigo_vendedor());
            ps.setString(4, us.getCorreo());
            ps.setDouble(5, caf.getSub_total());
            ps.setDouble(6, caf.getIgv());
            ps.setDouble(7, caf.getTotal_fact());
            
            resultado = ps.executeUpdate();
            return 1;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resultado;
    }
}