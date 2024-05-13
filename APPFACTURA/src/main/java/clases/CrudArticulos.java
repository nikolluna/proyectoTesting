package clases;

import java.util.List;

public interface CrudArticulos {
	public List listarDescripcionesArticulos();
	public List listarCuerpo();
	public List listarArticulos();
	public boolean add(CuerpoFactura cfac);
	public boolean eliminar(int id);
}
