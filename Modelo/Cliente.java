/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author saman
 */


public class Cliente {
	private String rucCliente;
	private String nombreCliente;
    private String direccionCliente;
  
	public Cliente() {
	}
	public Cliente(String rucCliente, String nombreCliente, String direccionCliente) {
		this.rucCliente = rucCliente;
		this.nombreCliente = nombreCliente;
		this.direccionCliente = direccionCliente;
	}
	public String getRucCliente() {
		return rucCliente;
	}
	public void setRucCliente(String rucCliente) {
		this.rucCliente = rucCliente;
	}
	public String getNombreCliente() {
		return nombreCliente;
	}
	public void setNombreCliente(String nombreCliente) {
		this.nombreCliente = nombreCliente;
	}
	public String getDireccionCliente() {
		return direccionCliente;
	}
	public void setDireccionCliente(String direccionCliente) {
		this.direccionCliente = direccionCliente;
	}

    
    
}
