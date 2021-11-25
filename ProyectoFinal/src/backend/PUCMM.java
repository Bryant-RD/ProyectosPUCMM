package backend;

import java.util.ArrayList;

import javax.swing.JOptionPane;

public class PUCMM {

	private ArrayList<Persona> personas;
	private ArrayList<Trabajo> trabajos;
	private ArrayList<Comision> comisiones;
	private ArrayList<Evento> eventos;
	private ArrayList<Recursos> recursos;
	public static PUCMM pucmm = null;
	
	public PUCMM() {
		personas = new ArrayList<>();
		trabajos = new ArrayList<>();
		comisiones = new ArrayList<>();
		setEventos(new ArrayList<>());
		recursos = new ArrayList<>();
		
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
	
	public Recursos agregarRecursoEvento(Recursos recurso, int cantidad) { //Funciona
		//Chequear si hay recursos
		
		if(recurso.getDisponibilidad() > cantidad) {
			
			recurso.setDisponibilidad(recurso.getDisponibilidad()-cantidad);
			return recurso;
		} else {
			JOptionPane.showMessageDialog(null, "No hay disponibilidad para este equipo: " + recurso.getNombreEquipo());
			return null;
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

	public ArrayList<Evento> getEventos() {
		return eventos;
	}

	public void setEventos(ArrayList<Evento> eventos) {
		this.eventos = eventos;
	}
	
	
	
	
	
}
