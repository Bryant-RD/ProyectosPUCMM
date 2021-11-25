package backend;

public class Administrador extends Persona{
	
	private String usuario;
	private String password;
	
	public Administrador(String nombre, String cedula, String numero, String email, String usuario, String password) {
		super(nombre, cedula, numero, email);
		
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
