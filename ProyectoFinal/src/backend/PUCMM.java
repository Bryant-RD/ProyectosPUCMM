package backend;

import java.util.ArrayList;

public class PUCMM {

	private ArrayList<Persona> personas;
	private ArrayList<Trabajo> trabajos;
	private ArrayList<Comision> comisiones;
	private ArrayList<Evento> eventos;
	private ArrayList<Recursos> recursos;
	private ArrayList <Actividad> actividades;
	public static PUCMM pucmm = null;
	
	public PUCMM() {
		personas = new ArrayList<>();
		trabajos = new ArrayList<>();
		comisiones = new ArrayList<>();
		eventos = new ArrayList<>();
		recursos = new ArrayList<>();
		actividades = new ArrayList<>();
		
	}
	
	public static PUCMM getInstance() {
		
		if(pucmm == null) {
			pucmm = new PUCMM();
		}
		return pucmm;
	}
	
	public void crearEvento(Evento evento) {
		/*Chequear si hay recursos
		 * Tambien si hay jurados disponibles para la comision*/
		
		
		
	}
	
	
	
	
}
