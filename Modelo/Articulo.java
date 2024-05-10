/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

public class Articulo {
	private int id_articulo;
	private String descripcion;
	private double precio_u;
	
	public Articulo(int id_articulo, String descripcion, double precio_u) {
		this.id_articulo = id_articulo;
		this.descripcion = descripcion;
		this.precio_u = precio_u;
	}
	public Articulo() {
	}
	
	public int getId_articulo() {
		return id_articulo;
	}
	public void setId_articulo(int id_articulo) {
		this.id_articulo = id_articulo;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public double getPrecio_u() {
		return precio_u;
	}
	public void setPrecio_u(double precio_u) {
		this.precio_u = precio_u;
	}	
}
