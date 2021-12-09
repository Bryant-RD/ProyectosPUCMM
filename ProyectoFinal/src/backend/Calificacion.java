package backend;

import java.io.Serializable;

public class Calificacion implements Serializable{
	
	
	private String nomJurado;
	private float calificacion;
	
	public Calificacion(String nomJurado, float calificacion) {
		
		this.nomJurado = nomJurado;
		this.calificacion = calificacion;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	

	public String getNomJurado() {
		return nomJurado;
	}

	public void setNomJurado(String nomJurado) {
		this.nomJurado = nomJurado;
	}

	public float getCalificacion() {
		return calificacion;
	}

	public void setCalificacion(float calificacion) {
		this.calificacion = calificacion;
	}

}
