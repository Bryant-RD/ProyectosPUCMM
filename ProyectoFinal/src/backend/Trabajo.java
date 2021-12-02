package backend;

import java.util.ArrayList;

public class Trabajo {
	
	private String codigo;
	private String nombre;
	private String tema;
	private float calificacionFinal;
	private ArrayList<Calificacion> calificaciones;
	
	
	public Trabajo(String codigo, String nombre, String tema) {
		super();
		this.codigo = codigo;
		this.nombre = nombre;
		this.tema = tema;
		this.calificacionFinal = 0;
		calificaciones = new ArrayList<>();
	}

	public String getCodigo() {
		return codigo;
	}
	
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public String getTema() {
		return tema;
	}
	
	public void setTema(String tema) {
		this.tema = tema;
	}
	
	public float getCalificacionFinal() {
		return calificacionFinal;
	}
	
	public void setCalificacionFinal(float calificacionFinal) {
		this.calificacionFinal = calificacionFinal;
	}

	public ArrayList<Calificacion> getCalificaciones() {
		return calificaciones;
	}

	public void setCalificaciones(ArrayList<Calificacion> calificaciones) {
		this.calificaciones = calificaciones;
	}

}
