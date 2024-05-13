package clases;

public class Clientes {
	private String rucCliente;
	private String nombreCliente;
    private String direccionCliente;
  
	public Clientes() {
	}
	public Clientes(String rucCliente, String nombreCliente, String direccionCliente) {
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
