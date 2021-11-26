package backend;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import visual.MenuAdministracion;



public class PUCMM {

	private ArrayList<Persona> personas;
	private ArrayList<Trabajo> trabajos;
	private ArrayList<Comision> comisiones;
	private ArrayList<Evento> eventos;
	private ArrayList<Recursos> recursos;
	public static PUCMM pucmm = null;
	public static Persona logueado = null;
	
	public PUCMM() {
		personas = new ArrayList<>();
		trabajos = new ArrayList<>();
		comisiones = new ArrayList<>();
		eventos = new ArrayList<>();
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
	
	public ArrayList<Jurado> agregarJuradoComision(Jurado jurado, ArrayList<Jurado> jurados) {
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
		
	
	public void loggin(String usuario, String password) {
		
		Persona aux = null;
		
		for (Persona persona: personas) {
			if (((Administrador) persona).getUsuario().equalsIgnoreCase(usuario)) {
				aux = persona;
				if(((Administrador)aux).getPassword().equalsIgnoreCase(password)) {
					if(aux instanceof Jurado) {
						logueado = aux;
												
//						return aux;
					} else {
						logueado = aux;
						MenuAdministracion reg = new MenuAdministracion();
						reg.setVisible(true);
					}
					
				}
			}
		}
	
//		return aux;
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


	public Evento buscarEventoByName(String nombre) {
		Evento aux = null;
		boolean encontrado = false;
		int i = 0;
		while(!encontrado && i < eventos.size()) {
			if (eventos.get(i).getNombre().equalsIgnoreCase(nombre)) {
				aux = eventos.get(i);
				encontrado = true;
			}
			i++;
		}
		return aux;
	}
	
	public Persona buscarPersonaByCedula(String cedulaPersona) {
		
		Persona aux = null;
		
		for (Persona persona: personas) {
			if (persona.getCedula().equalsIgnoreCase(cedulaPersona)) {
				aux = persona;
			}
		}
		if(aux != null) {
			return aux;
		} else {
//			JOptionPane.showMessageDialog(null, "Persona no encontrada.", "Error!", JOptionPane.ERROR_MESSAGE);
			return null;
		}
	}
	
	public boolean eliminarPersona(Persona selected) {
		return personas.remove(selected);

	}
	

	
	
	/*                   SET's & Get's                           */
	
	public ArrayList<Evento> getEventos() {
		return eventos;
	}

	public void setEventos(ArrayList<Evento> eventos) {
		this.eventos = eventos;
	}
	
	public ArrayList<Persona> getPersona() {
		return personas;
	}


	public void setPersona(ArrayList<Persona> personas) {
		this.personas = personas;
	}
}
