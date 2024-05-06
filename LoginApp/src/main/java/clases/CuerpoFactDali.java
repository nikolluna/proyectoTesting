package clases;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import modelo.Conexion;

public class CuerpoFactDali implements CrudArticulos{
	Connection con;
    Conexion cn = new Conexion();
    PreparedStatement ps;
    ResultSet rs;
    int res = 0;
    CuerpoFactura cfactura = new CuerpoFactura();
    Articulo art = new Articulo();
    
    
	@Override
	public List listarCuerpo() {
		ArrayList<Articulo> listarticulos = new ArrayList<>();
		String sql = "SELECT * FROM articulos";
		return null;
	}

	@Override
	public List listarArticulos() {
		ArrayList<Articulo> listarticulos = new ArrayList<>();
		String sql = "SELECT * FROM articulos";
		try {
			con = cn.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                res = res + 1;
                Articulo articulo = new Articulo();
                articulo.setId_articulo(rs.getInt("codigo_item"));
                articulo.setDescripcion(rs.getString("descripcion_item"));
                articulo.setPrecio_u(rs.getDouble("precio"));
                listarticulos.add(articulo);
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
		return listarticulos;
	}
	
	@Override
	public List<String> listarDescripcionesArticulos() {
	    ArrayList<String> listaDescripciones = new ArrayList<>();
	    String sql = "SELECT descripcion_item FROM articulos";
	    try {
	        con = cn.getConnection();
	        ps = con.prepareStatement(sql);
	        rs = ps.executeQuery();

	        while (rs.next()) {
	            listaDescripciones.add(rs.getString("descripcion_item"));
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
	    return listaDescripciones;
	}


	@Override
	public boolean add(CuerpoFactura cfac) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean eliminar(int id) {
		// TODO Auto-generated method stub
		return false;
	}

}
