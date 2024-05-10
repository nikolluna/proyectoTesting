/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

public class CabeceraFactura {
	private int numfact;
	private String fecha;
	private String  ruc_cliente;
	private String  codigo_vendedor;
	private int usuario;
	private double sub_total;
	private double igv;
	private double total_fact;
	
	public CabeceraFactura() {}

	public CabeceraFactura(int numfact, String fecha, String ruc_cliente, String codigo_vendedor, int usuario,
			double sub_total, double igv, double total_fact) {
		super();
		this.numfact = numfact;
		this.fecha = fecha;
		this.ruc_cliente = ruc_cliente;
		this.codigo_vendedor = codigo_vendedor;
		this.usuario = usuario;
		this.sub_total = sub_total;
		this.igv = igv;
		this.total_fact = total_fact;
	}



	public int getNumfact() {
		return numfact;
	}

	public void setNumfact(int numfact) {
		this.numfact = numfact;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public String getRuc_cliente() {
		return ruc_cliente;
	}

	public void setRuc_cliente(String ruc_cliente) {
		this.ruc_cliente = ruc_cliente;
	}

	public String getCodigo_vendedor() {
		return codigo_vendedor;
	}

	public void setCodigo_vendedor(String codigo_vendedor) {
		this.codigo_vendedor = codigo_vendedor;
	}

	public int getUsuario() {
		return usuario;
	}

	public void setUsuario(int usuario) {
		this.usuario = usuario;
	}

	public double getSub_total() {
		return sub_total;
	}

	public void setSub_total(double sub_total) {
		this.sub_total = sub_total;
	}

	public double getIgv() {
		return igv;
	}

	public void setIgv(double igv) {
		this.igv = igv;
	}

	public double getTotal_fact() {
		return total_fact;
	}

	public void setTotal_fact(double total_fact) {
		this.total_fact = total_fact;
	}
	
}