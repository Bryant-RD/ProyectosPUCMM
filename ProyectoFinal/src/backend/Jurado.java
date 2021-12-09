package backend;

import java.io.Serializable;
import java.util.ArrayList;

public class Jurado extends Administrador implements Serializable{
	
	private static final long serialVersionUID = 6121647374382664065L;
	private String area;
	private int anioExp;
	private ArrayList<String> comisiones;
	private boolean disponible;

	public Jurado(String nombre, String cedula, String numero, String email, String area, int anioExp, String usuario, String password, String rol) {
		super(nombre, cedula, numero, email, usuario, password, rol);
		
		this.area = area;
		this.anioExp = anioExp;
		setComisiones(new ArrayList<>());
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

	public ArrayList<String> getComisiones() {
		return comisiones;
	}
	
	public void setComisiones(ArrayList<String> comisiones) {
		this.comisiones = comisiones;
	}

}
