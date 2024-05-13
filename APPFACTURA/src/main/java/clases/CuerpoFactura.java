package clases;

public class CuerpoFactura {
	private int num_fact;
	private int id_articulo;
	private int cantidad;
	private double precio_total;
	public CuerpoFactura(int num_fact, int id_articulo, int cantidad, double precio_total) {
		
		this.num_fact = num_fact;
		this.id_articulo = id_articulo;
		this.cantidad = cantidad;
		this.precio_total = precio_total;
	}
	public CuerpoFactura() {
		
	}
	public int getNum_fact() {
		return num_fact;
	}
	public void setNum_fact(int num_fact) {
		this.num_fact = num_fact;
	}
	public int getId_articulo() {
		return id_articulo;
	}
	public void setId_articulo(int id_articulo) {
		this.id_articulo = id_articulo;
	}
	public int getCantidad() {
		return cantidad;
	}
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	public double getPrecio_total() {
		return precio_total;
	}
	public void setPrecio_total(double precio_total) {
		this.precio_total = precio_total;
	}
	
	
	
}
