package backend;

import java.io.Serializable;
import java.util.ArrayList;

public class Trabajo implements Serializable{
	
	private String codigo;
	private String codeComision;
	private String evento; 
	private String nombre;
	private String tema;
	private float calificacionFinal;
	private ArrayList<Calificacion> calificaciones;
	
	
	public Trabajo(String codigo, String codeComision ,String evento ,String nombre, String tema) {
		super();
		this.evento = evento;
		this.nombre = nombre;
		this.codeComision = codeComision;
		this.tema = tema;
		this.calificacionFinal = 0;
		calificaciones = new ArrayList<>();
		this.codigo = codigo;
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

	public String getEvento() {
		return evento;
	}

	public void setEvento(String codEvento) {
		this.evento = codEvento;
	}

	public String getCodeComision() {
		return codeComision;
	}

	public void setCodeComision(String cedulaPropietario) {
		this.codeComision = cedulaPropietario;
	}

}
