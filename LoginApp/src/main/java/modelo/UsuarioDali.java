package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UsuarioDali implements ValidarUsuario {
    Connection con;
    Conexion cn = new Conexion();
    PreparedStatement ps;
    ResultSet rs;
    int res = 0;
    
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
    
    @Override
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

    @Override
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

    
}
