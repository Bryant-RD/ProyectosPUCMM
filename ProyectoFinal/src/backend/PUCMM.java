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
		
		Administrador admin = new Administrador("admin", "admin", "admin", "admin", "admin", "admin");
		personas.add(admin);
		
	}
	
	public static PUCMM getInstance() {
		
		if(pucmm == null) {
			pucmm = new PUCMM();
		}
		return pucmm;
	}
	

	
	public void crearEvento(Evento evento) {
		eventos.add(evento);
		
	}
	
	
	
	public  Comision getComisionByName(String name) {
		Comision comision = null;
		boolean encontrado = false;
		int i = 0;
		while(!encontrado && i < comisiones.size() ){
		  if(comisiones.get(i).getNombre().equalsIgnoreCase(name)){
			  encontrado = true;
			  comision = comisiones.get(i);
		  }	
		  i++;
		}
		return comision;
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
	
	
	public Comision crearComision(String nombre, Jurado presidente, String areaConocimiento ,ArrayList<Jurado> jurados) {
		
		Comision comision = new Comision(nombre, presidente, areaConocimiento, jurados);
		comisiones.add(comision);
		
		return comision;
		
	}
	
	public boolean agregarJuradoComision(Jurado jurado) {
		//Metodo verificar si hay jurados disponibles para la comision
		
		if(jurado.isDisponible()) {
			jurado.setDisponible(false);
			return true;

		} else {
			
			JOptionPane.showMessageDialog(null, "Este jurado no esta disponible: " + jurado.getNombre());
			return false;
		}
		
	}
	
	public Jurado getJuradoByCedula(String cedula) {
		Jurado jurado = null;
		boolean encontrado = false;
		int i = 0;
		while(!encontrado && i< personas.size() ){
		  if(personas.get(i).getCedula().equalsIgnoreCase(cedula) && personas.get(i) instanceof Jurado){
			  encontrado = true;
			  jurado = (Jurado) personas.get(i);
		  }	
		  i++;
		}
		return jurado;
	}
		
	
	public boolean loggin(String usuario, String password) {
		
		Persona aux = null;
		boolean encontrado = false;
		
		for (Persona persona: personas) {
			if (((Administrador) persona).getUsuario().equalsIgnoreCase(usuario)) {
				aux = persona;
				if(((Administrador)aux).getPassword().equalsIgnoreCase(password)) {
					if(aux instanceof Jurado) {
						logueado = aux;
					} else {
						logueado = aux;

					}
					encontrado =  true;
				}
			}
		}
	
		return encontrado;
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
	
	public Trabajo buscarTrabajoByCod(String codigoTrabajo) {
			
			Trabajo aux = null;
			
			for (Trabajo trabajo: trabajos) {
				if (trabajo.getCodigo().equalsIgnoreCase(codigoTrabajo)) {
					aux = trabajo;
				}
			}
			if(aux != null) {
				return aux;
			} else {
	//			JOptionPane.showMessageDialog(null, "Trabajo.", "Error!", JOptionPane.ERROR_MESSAGE);
				return null;
			}
		}
	
	public boolean eliminarTrabajo(Trabajo selected) {
		return trabajos.remove(selected);

	}
	

	// COMENTARIO DE PRUEBA
	
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
	
	public ArrayList<Recursos> getRecursos() {
		return recursos;
	}


	public void setRecursos(ArrayList<Recursos> recursos) {
		this.recursos = recursos;
	}
	
	public ArrayList<Trabajo> getTrabajo() {
		return trabajos;
	}


	public void setTrabajo(ArrayList<Trabajo> trabajos) {
		this.trabajos = trabajos;
	}
	
	
	
}
