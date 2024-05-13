package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import clases.CabeceraFactura;

public class CabeceraDali implements EnviarCabecera{
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
    public int enviar(CabeceraFactura caf, Usuario us) {
        int resultado = 0;
        String sql = "INSERT INTO cabecera_factura (fecha, ruc_cliente, codigo_vendedor, correo) VALUES (?, ?, ?, ?)";
        try {
            abrirConexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, caf.getFecha());
            ps.setString(2, caf.getRuc_cliente());
            ps.setString(3, caf.getCodigo_vendedor());
            ps.setString(4, us.getCorreo());
            
            resultado = ps.executeUpdate();
            return 1;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resultado;
    }
    
    public int guardar(CabeceraFactura caf, Usuario us) {
        int resultado = 0;
        String sql = "INSERT INTO cabecera_factura (fecha, ruc_cliente, codigo_vendedor, correo, sub_total, igv, total_factura) VALUES (?, ?, ?, ?, 18.86, 4.14,23)";
        try {
            abrirConexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, caf.getFecha());
            ps.setString(2, caf.getRuc_cliente());
            ps.setString(3, caf.getCodigo_vendedor());
            ps.setString(4, us.getCorreo());
            
            resultado = ps.executeUpdate();
            return 1;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resultado;
    }
}
