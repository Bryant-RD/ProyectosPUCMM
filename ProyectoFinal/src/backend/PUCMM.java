package backend;

import java.util.ArrayList;

import javax.swing.JOptionPane;

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
		

		 
		
		
	}
	public void agregarRecurso(Recursos recurso) {
		recursos.add(recurso);
	}
	
	public void agregarRecursoEvento(Recursos recurso, int cantidad) { //Funciona
		//Chequear si hay recursos
		
		if(recurso.getDisponibilidad() > cantidad) {
			
//			Recursos recursos = buscarRecurso(recurso.getNombreEquipo());
			recurso.setDisponibilidad(recurso.getDisponibilidad()-cantidad);
		} else {
			JOptionPane.showMessageDialog(null, "No hay disponibilidad para este equipo: " + recurso.getNombreEquipo());
		}
	}
	
	
	public Recursos buscarRecurso(String nomRecurso) {
		Recursos recurso = null;
		boolean encontrado = false;
		int i = 0;
		while(!encontrado && i< recursos.size() ){
		  if(recursos.get(i).getNombreEquipo().equalsIgnoreCase(nomRecurso)){
			  encontrado = true;
			  recurso = recursos.get(i);
		  }	
		  i++;
		}
		return recurso;
	}
	
	
	public Comision crearComision(String codigo, String nombre, Jurado presidente, String areaConocimiento ,ArrayList<Jurado> jurados) {
		
		Comision comision = new Comision(codigo, nombre, presidente, areaConocimiento, jurados);
		comisiones.add(comision);
		
		return comision;
		
	}
	
	private ArrayList<Jurado> agregarJuradoComision(Jurado jurado, ArrayList<Jurado> jurados) {
		//Metodo verificar si hay jurados disponibles para la comision
		
		if(jurado.isDisponible()) {
			jurado.setDisponible(false);
			jurados.add(jurado);
			return jurados;	
		} else {
			
			JOptionPane.showMessageDialog(null, "Este jurado no esta disponible: " + jurado.getNombre());
			return null;
		}
		
	}
	
	

	
	
	public void CrearActividad() {
		
	}
	
	public void RegistrarPersona(Persona persona) {
		personas.add(persona);
	}
	
	public void registrarTrabajo(Trabajo trabajo) {
		trabajos.add(trabajo);
	}
	
	public void Calificar() {
		
	}
	
	public void Ganador() {
		
	}
	
	
	
	
	
}
