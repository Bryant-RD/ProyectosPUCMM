package backend;

public class Jurado extends Persona{
	
	private String area;
	private int anioExp;

	public Jurado(String nombre, String cedula, String numero, String email, String area, int anioExp) {
		super(nombre, cedula, numero, email);
		
		this.area = area;
		this.anioExp = anioExp;
	}
	
	
	
	

}
