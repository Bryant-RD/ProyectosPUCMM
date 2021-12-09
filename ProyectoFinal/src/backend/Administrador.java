package backend;

import java.io.Serializable;

public class Administrador extends Persona implements Serializable{
	
	private String usuario;
	private String password;
	
	public Administrador(String nombre, String cedula, String numero, String email, String usuario, String password, String rol) {
		super(nombre, cedula, numero, email, rol);
		
		this.usuario = usuario;
		this.password = password;
		
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
