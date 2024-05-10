/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import config.Conexion;
import Modelo.Usuario;

public class UsuarioDali {
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
    
    public int validar(Usuario us) {
        String sql = "SELECT * FROM usuario WHERE correo = ? AND contra = ?";
        try {
        	abrirConexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, us.getCorreo());
            ps.setString(2, us.getContrasena());
            rs = ps.executeQuery();

            while (rs.next()) {
                res = res + 1;
                us.setCorreo(rs.getString("correo"));
                us.setContrasena(rs.getString("contra"));
            }
            if (res == 1) {
                return 1;
            } else {
                return 0;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (ps != null) {
                    ps.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return res;
    }

    public int registrar(String correo, String contra) {
        int resultado = 0;
        String sql = "INSERT INTO usuario (correo, contra) VALUES (?, ?)";
        try {
            abrirConexion();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, correo);
            ps.setString(2, contra);
            resultado = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            cerrarConexion();
        }
        return resultado;
    }
    
    public List<Articulo> listarArticulos(Usuario usuario) {
        List<Articulo> articulos = new ArrayList<>();
        System.out.println(usuario.getCorreo());
        String sql = "SELECT * FROM articulos WHERE correo = ?";
        try {
            abrirConexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, usuario.getCorreo());
            rs = ps.executeQuery();
            while (rs.next()) {
                Articulo articulo = new Articulo();
                articulo.setId_articulo(rs.getInt("codigo_item"));
                articulo.setDescripcion(rs.getString("descripcion_item"));
                articulo.setPrecio_u(rs.getDouble("precio"));
                articulos.add(articulo);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } 
        return articulos;
    }
    public Articulo buscarArticuloPorDescripcion(Usuario usuario, String descripcion) {
        Articulo articulo = null;
        System.out.println(usuario.getCorreo());
        String sql = "SELECT * FROM articulos WHERE correo = ? AND descripcion_item = ?";
        try {
            abrirConexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, usuario.getCorreo());
            ps.setString(2, descripcion);
            rs = ps.executeQuery();
            if (rs.next()) {
                articulo = new Articulo();
                articulo.setId_articulo(rs.getInt("codigo_item"));
                articulo.setDescripcion(rs.getString("descripcion_item"));
                articulo.setPrecio_u(rs.getDouble("precio"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } 
        return articulo;
    }    
}