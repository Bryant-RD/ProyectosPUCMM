package backend;

import java.util.ArrayList;

public class Participante extends Persona {
	

	private String matricula;
	private String escuela;
	private ArrayList <Trabajo> trabajos; 
	
	
	public Participante(String nombre, String cedula, String numero, String email, String matricula, String escuela, String codEvento ,String codigoTrabajo ,String nombreTrabajo, String tema, String rol) {
		super(nombre, cedula, numero, email, rol);

		this.matricula = matricula;
		this.escuela = escuela;
		trabajos = new ArrayList<>();
		
		Trabajo trabajo = new Trabajo(codigoTrabajo, codEvento ,nombreTrabajo, tema);
		trabajos.add(trabajo);
		PUCMM.getInstance().registrarTrabajo(trabajo);
	}

	public String getMatricula() {
		return matricula;
	}
	
	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}
	
	public String getEscuela() {
		return escuela;
	}
	
	public void setEscuela(String escuela) {
		this.escuela = escuela;
	}
	
	public ArrayList<Trabajo> getTrabajos() {
		return trabajos;
	}
	
	public void setTrabajos(ArrayList<Trabajo> trabajos) {
		this.trabajos = trabajos;
	}

}
