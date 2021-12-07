package backend;

public class Administrador extends Persona{
	
	private String usuario;
	private String password;
	protected String rol;
	
	public Administrador(String nombre, String cedula, String numero, String email, String usuario, String password) {
		super(nombre, cedula, numero, email);
		
		this.usuario = usuario;
		this.password = password;
		rol = "Administrador";
		
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

	public String getRol() {
		return rol;
	}

	public void setRol(String rol) {
		this.rol = rol;
	}


}
