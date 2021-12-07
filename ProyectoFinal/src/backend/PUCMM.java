package backend;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import visual.Calificaciones;
import visual.test;




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
		Jurado jur = new Jurado("jurado", "jurado", "jurado", "jurado", "jurado", 1, "jurado", "jurado");
		personas.add(jur);
		personas.add(admin);
		
		
		
	}
	
	public static PUCMM getInstance() {
		
		if(pucmm == null) {
			pucmm = new PUCMM();
		}
		return pucmm;
	}
	
	public static PUCMM pucmm() {
		if(pucmm == null) {
			pucmm = new PUCMM();
		}
		return pucmm;
	}

	
	public void crearEvento(Evento evento) {
		eventos.add(evento);
		
		
	}
	
	public boolean verificarRecurso(String nomRecurso, int cantidad) {
		
		Recursos recurso = buscarRecurso(nomRecurso);
		System.out.print(recurso.getDisponibilidad());
		if(recurso.getDisponibilidad() > cantidad) {
			
			return true;
		} else {
			return false;
		}
		
		
	}
	
	public void agregarTrabajo(String cedulaPart, Trabajo trabajo) {
		if(verificarTrabajo(cedulaPart, trabajo)) {
			Evento evento = buscarEventoByName(trabajo.getEvento());
			Persona participante = buscarPersonaByCedula(cedulaPart);
			evento.getProyectos().add(trabajo);
			trabajos.add(trabajo);
			((Participante)participante).getTrabajos().add(trabajo);
		} else {
			JOptionPane.showMessageDialog(null, "El trabajo no pudo ser registrado. verifique los campos.", "Error!", JOptionPane.ERROR_MESSAGE);
		}
		

	}
	
	public boolean verificarTrabajo(String cedulaPart, Trabajo trabajo) {
		Persona participante = buscarPersonaByCedula(cedulaPart);
		if(participante != null) {
			Evento evento = buscarEventoByName(trabajo.getEvento());
			if(evento != null) {
				return true;
			} else {
				JOptionPane.showMessageDialog(null, "Evento no encontrado", "Error!", JOptionPane.ERROR_MESSAGE);
				return false;
			}
		} else {
			JOptionPane.showMessageDialog(null, "Participante no entrado", "Error!", JOptionPane.ERROR_MESSAGE);
			return false;
		}
	}
	
	
	public void editarRecurso(Recursos viejo, Recursos nuevo) {
		viejo.setNombreEquipo(nuevo.getNombreEquipo());
		viejo.setCantidad(nuevo.getCantidad());
		viejo.setTipo(nuevo.getTipo());
	}
	
	public void editarTrabajo(Trabajo viejo, Trabajo nuevo) {
		viejo.setNombre(nuevo.getNombre());
		viejo.setEvento(nuevo.getEvento());
		viejo.setTema(nuevo.getTema());
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
	
	public void agregarRecursoEvento(Recursos recurso, int cantidad, String nombre) { //Funciona
		//Chequear si hay recursos
		
		if(recurso.getDisponibilidad() > cantidad) {
			
			recurso.setDisponibilidad(recurso.getDisponibilidad()-cantidad);
			Evento evento = buscarEventoByName(nombre);
			
			evento.getRecursosUtilizados().add(recurso);
			
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
	
	
	public Comision crearComision(String nombre, Jurado presidente, String areaConocimiento ,ArrayList<Jurado> jurados) {
		
		presidente.setDisponible(false);
		presidente.getComisiones().add(nombre);
		
		for (Jurado jurado : jurados) {
			jurado.getComisiones().add(nombre);
		}
		
		Comision comision = new Comision(nombre, presidente, areaConocimiento, jurados);
		comisiones.add(comision);
		
		return comision;
		
	}
	
	public boolean verificarJurado(Jurado jurado) {
		//Metodo verificar si hay jurados disponibles para la comision
		
		if(jurado.isDisponible()) {
			
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
	
	public ArrayList<Trabajo> trabajosLogueado() {
		ArrayList<Trabajo> trabajos = new ArrayList<>();
		
//		ArrayList<String> comisionesJurado = new ArrayList<>();
		System.out.print(((Jurado) logueado).getComisiones().size());
		
		for (int i = 0; i < comisiones.size(); i++) {
			
//			comisionesJurado.add(((Jurado)logueado).getComisiones().get(i));
//			
			Comision actual = comisiones.get(i);
			if (((Jurado) logueado).getComisiones().get(i).equalsIgnoreCase(actual.getNombre())) {
				for (int j = 0; j < actual.getTrabajos().size(); j++) {
					trabajos.add(actual.getTrabajos().get(i));
				}
			}
//			for (int j = 0; j < comisionesJurado.size(); j++) {
//				if(comisionesJurado.get(j).equalsIgnoreCase(actual.getNombre())) {
//					for (int j2 = 0; j2 < actual.getTrabajos().size(); j2++) {
//						trabajos.add(actual.getTrabajos().get(j2));
//					}
//				}
//			}
		}
		
		
		
		return trabajos;
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
						Calificaciones cali = new Calificaciones();
						cali.setVisible(true);
						
						
					} else {
						logueado = aux;

					}
					encontrado =  true;
//					break;
				}
			}	
			
			if (((Administrador) persona).getUsuario().equalsIgnoreCase(usuario)) {
				aux = persona;
				if(((Administrador)aux).getPassword().equalsIgnoreCase(password)) {
					if(aux instanceof Administrador) {

						test reg = new test();
						reg.setVisible(true);
					} 
					
					logueado = aux;
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
	
	public void calificarTrabajo(String codTrabajo, float calificacion) {
		
		Calificacion cali = new Calificacion(logueado.getNombre(), calificacion);
		
		Trabajo trabajo = buscarTrabajoByName(codTrabajo);
		
		trabajo.getCalificaciones().add(cali);
		
	}
	
	public float calCalificacionFinal(String codeTrabajo) {
		float cali = 0;
		
		Trabajo trabajo = buscarTrabajoByName(codeTrabajo);
		
		for (Calificacion calificacion : trabajo.getCalificaciones()) {
			cali += calificacion.getCalificacion();
		}
		
		cali = cali/trabajo.getCalificaciones().size();
		
		return cali;
	}
	
	public Participante getGanador() {
		
		Participante ganador = null;
		float calificacion = 0;
		for (int i = 0; i < personas.size(); i++) {
			if(personas.get(i) instanceof Participante) {				
				if(((Participante) personas.get(i)).getTrabajos().get(i).getCalificacionFinal() > calificacion) {
					calificacion = ((Participante) personas.get(i)).getTrabajos().get(i).getCalificacionFinal();
					ganador = ((Participante) personas.get(i));
				}
			}
		}
		
		return ganador;
		
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
	
	public Trabajo buscarTrabajoByName(String nombreTrabajo) {
			
			Trabajo aux = null;
			
			for (Trabajo trabajo: trabajos) {
				if (trabajo.getNombre().equalsIgnoreCase(nombreTrabajo)) {
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
	
	// Buscar evento
	
	public Evento searchEventoByCodigo(String codigo) {
		
		Evento miEvento = null;
		boolean finded = false;
		int i = 0;
		while (!finded && i < eventos.size()) {
			if(eventos.get(i).getCodigo().equalsIgnoreCase(codigo)) {
				miEvento = eventos.get(i);
				finded = true;
			}
			
			else {
				i ++;
			}
		}
		return miEvento;

	}
	
	// Remover evento por fecha
	

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
	
	public ArrayList<Comision> getComisiones() {
		return comisiones;
	}


	
}
