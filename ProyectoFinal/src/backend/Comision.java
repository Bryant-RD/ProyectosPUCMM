package backend;

import java.util.ArrayList;

public class Comision {

	private String nombre;
	private Jurado presidente;
	private ArrayList<Jurado> jurados = new ArrayList<>();
	private ArrayList<Trabajo> trabajos;
	private String areaConocimiento;
	
	
	
	public Comision(String nombre, Jurado presidente ,String areaConocimiento, ArrayList<Jurado> jurados) {
		
		this.nombre = nombre;
		this.presidente = presidente;
		this.areaConocimiento = areaConocimiento;
		this.jurados = jurados;
		trabajos = new ArrayList<>();
		
	}
	
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Jurado getPresidente() {
		return presidente;
	}
	public void setPresidente(Jurado presidente) {
		this.presidente = presidente;
	}
	public ArrayList<Jurado> getJurados() {
		return jurados;
	}
	public void setJurados(ArrayList<Jurado> jurados) {
		this.jurados = jurados;
	}
	public ArrayList<Trabajo> getTrabajos() {
		return trabajos;
	}
	public void setTrabajos(ArrayList<Trabajo> trabajos) {
		this.trabajos = trabajos;
	}
	public String getAreaConocimiento() {
		return areaConocimiento;
	}
	public void setAreaConocimiento(String areaConocimiento) {
		this.areaConocimiento = areaConocimiento;
	}

	
}
