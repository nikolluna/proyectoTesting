package modelo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import clases.Articulo;

public class ArticuloDali {
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

    public int enviar(Articulo articulo, Usuario us) {
        int resultado = 0;
        String sql = "INSERT INTO articulos (correo, descripcion_item, precio) VALUES (?, ?, ?)";
        try {
            abrirConexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, us.getCorreo());
            ps.setString(2, articulo.getDescripcion());
            ps.setDouble(3, articulo.getPrecio_u());
            resultado = ps.executeUpdate();
            return 1;
        } catch (SQLException e) {
            e.printStackTrace();
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

}
