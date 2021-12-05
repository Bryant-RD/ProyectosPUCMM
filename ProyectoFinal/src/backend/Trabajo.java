package backend;

import java.util.ArrayList;

public class Trabajo {
	
	public static int codigo = 1;
	private String evento; 
	private String nombre;
	private String tema;
	private float calificacionFinal;
	private ArrayList<Calificacion> calificaciones;
	
	
	public Trabajo(String evento ,String nombre, String tema) {
		super();
		this.evento = evento;
		this.nombre = nombre;
		this.tema = tema;
		this.calificacionFinal = 0;
		calificaciones = new ArrayList<>();
		Trabajo.codigo++;
	}

	public int getCodigo() {
		return codigo;
	}
	
	public void setCodigo(int codigo) {
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

	public String getEvento() {
		return evento;
	}

	public void setEvento(String codEvento) {
		this.evento = codEvento;
	}

}
