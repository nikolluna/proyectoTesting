package modelo;

public class Usuario {
	private int id;
	private String correo;
	private String contrasena;
	
	public Usuario() {
	}

	public Usuario(int id, String correo, String contrasena) {
		this.id = id;
		this.correo = correo;
		this.contrasena = contrasena;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCorreo() {
		return correo;
	}
	public void setCorreo(String correo) {
		this.correo = correo;
	}
	public String getContrasena() {
		return contrasena;
	}
	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}
	
	
}
