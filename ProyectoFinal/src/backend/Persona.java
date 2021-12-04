package backend;

public class Persona {  
	
	protected String nombre;
	protected String cedula;
	protected String numero;
	protected String email;
	
	public Persona(String nombre, String cedula, String numero, String email) {
		super();
		this.nombre = nombre;
		this.cedula = cedula;
		this.numero = numero;
		this.email = email;
	}

	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public String getCedula() {
		return cedula;
	}
	
	public void setCedula(String cedula) {
		this.cedula = cedula;
	}
	
	public String getNumero() {
		return numero;
	}
	
	public void setNumero(String numero) {
		this.numero = numero;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
