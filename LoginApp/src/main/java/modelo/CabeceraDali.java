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
    public int enviar(CabeceraFactura caf) {
        int resultado = 0;
        String sql = "INSERT INTO cabecera_factura (fecha, ruc_cliente, codigo_vendedor) VALUES (?, ?, ?)";
        try {
            abrirConexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, caf.getFecha());
            ps.setString(2, caf.getRuc_cliente());
            ps.setLong(3, caf.getCodigo_vendedor());
            
            resultado = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resultado;
    }
}
