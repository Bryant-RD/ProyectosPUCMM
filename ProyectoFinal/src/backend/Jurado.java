package backend;

public class Jurado extends Administrador{
	
	private String area;
	private int anioExp;
	private boolean disponible;

	public Jurado(String nombre, String cedula, String numero, String email, String area, int anioExp, String usuario, String password) {
		super(nombre, cedula, numero, email, usuario, password);
		
		this.area = area;
		this.anioExp = anioExp;
		this.disponible = true; //true es disponible y false no disponible
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

	public boolean isDisponible() {
		return disponible;
	}

	public void setDisponible(boolean disponible) {
		this.disponible = disponible;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public int getAnioExp() {
		return anioExp;
	}

	public void setAnioExp(int anioExp) {
		this.anioExp = anioExp;
	}

}
