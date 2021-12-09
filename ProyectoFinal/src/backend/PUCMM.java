package backend;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import visual.MenuJurado;
import visual.test;




public class PUCMM {

	private ArrayList<Persona> personas;
	private ArrayList<Trabajo> trabajos;
	private ArrayList<Comision> comisiones;
	private ArrayList<Evento> eventos;
	private ArrayList<Recursos> recursos;
	public static PUCMM pucmm = null;
	public static Administrador logueado = null;
	
	public PUCMM() {
		personas = new ArrayList<>();
		trabajos = new ArrayList<>();
		comisiones = new ArrayList<>();
		eventos = new ArrayList<>();
		recursos = new ArrayList<>();
		
		Administrador admin = new Administrador("admin", "admin", "admin", "admin", "admin", "admin", "Administrador");
		Jurado jur = new Jurado("jurado", "jurado", "jurado", "jurado", "jurado", 1, "jurado", "jurado", "Jurado");
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
		if(recurso.getDisponibilidad() > cantidad) {
			
			return true;
		} else {
			return false;
		}
		
		
	}
	/*				AQUI 					*/
	
	public void agregarTrabajo(String cedulaPart, Trabajo trabajo) {
		if(verificarTrabajo(cedulaPart, trabajo)) {
			Evento evento = buscarEventoByName(trabajo.getEvento());
			Comision comision = getComisionByCode(evento.getComision().getCodigo());
			comision.getTrabajos().add(trabajo);
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
	
	public void editarParticipante(Participante viejo, Participante nuevo) {
		viejo.setNombre(nuevo.getNombre());
		viejo.setEmail(nuevo.getEmail());
		viejo.setNumero(nuevo.getNumero());
		viejo.setEscuela(nuevo.getEscuela());
		viejo.setMatricula(nuevo.getMatricula());
		
	}
	
	public void editarJurado(Jurado viejo, Jurado nuevo) {
		viejo.setNombre(nuevo.getNombre());
		viejo.setEmail(nuevo.getEmail());
		viejo.setNumero(nuevo.getNumero());
		viejo.setUsuario(nuevo.getUsuario());
		viejo.setPassword(nuevo.getPassword());
		viejo.setArea(nuevo.getArea());
		viejo.setAnioExp(nuevo.getAnioExp());

	}
	
	public void editarAdministrador(Administrador viejo, Administrador nuevo) {
		viejo.setNombre(nuevo.getNombre());
		viejo.setEmail(nuevo.getEmail());
		viejo.setNumero(nuevo.getNumero());
		viejo.setUsuario(nuevo.getUsuario());
		viejo.setPassword(nuevo.getPassword());
	}
	
	
	public  Comision getComisionByCode(String code) {
		Comision comision = null;
		boolean encontrado = false;
		int i = 0;
		while(!encontrado && i < comisiones.size() ){
		  if(comisiones.get(i).getCodigo().equalsIgnoreCase(code)){
			  encontrado = true;
			  comision = comisiones.get(i);
		  }	
		  i++;
		}
		return comision;
	}
	
	public  Comision getComisionByName(String code) {
		Comision comision = null;
		boolean encontrado = false;
		int i = 0;
		while(!encontrado && i < comisiones.size() ){
		  if(comisiones.get(i).getNombre().equalsIgnoreCase(code)){
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
	
	
	public Comision crearComision(String codigo, String nombre, Jurado presidente, String areaConocimiento ,ArrayList<Jurado> jurados) {
		
		presidente.setDisponible(false);
		presidente.getComisiones().add(nombre);
		
		for (Jurado jurado : jurados) {
			jurado.getComisiones().add(nombre);
		}
		
		Comision comision = new Comision(codigo, nombre, presidente, areaConocimiento, jurados);
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
	
	/*				AQUI			*/
	
	public ArrayList<Trabajo> trabajosLogueado() {
		ArrayList<Trabajo> trabajos = new ArrayList<>();
		
		for (int i = 0; i < comisiones.size(); i++) {
			for (int j = 0; j < ((Jurado)logueado).getComisiones().size(); j++) {
				if(comisiones.get(i).getNombre().equalsIgnoreCase(((Jurado)logueado).getComisiones().get(j))) {
					System.out.print("Encontreo una comision");
					System.out.print(comisiones.get(i).getTrabajos().size());
					
					for (int h = 0; h < comisiones.get(i).getTrabajos().size(); h++) {
						trabajos.add(comisiones.get(i).getTrabajos().get(h));
						System.out.print("\nTrabajo: "+h);
					}
					
				}
			}
		}
		
		
		
		return trabajos;
	}
		
	
	public boolean loggin(String usuario, String password) {
		
		Persona aux = null;
		boolean encontrado = false;
		
		for (Persona persona: personas) {

			if(persona.getRol().equalsIgnoreCase("Administrador")) {
				if(((Administrador) persona).getUsuario().equalsIgnoreCase(usuario) && ((Administrador) persona).getPassword().equalsIgnoreCase(password)) {
					logueado = (Administrador) persona;
					test regAdmin = new test();
					regAdmin.setVisible(true);
					return encontrado = true;
				}
			} else if(persona.getRol().equalsIgnoreCase("Jurado")) {
				if(((Jurado)persona).getUsuario().equalsIgnoreCase(usuario) && ((Jurado) persona).getPassword().equalsIgnoreCase(password)) {
					logueado = (Jurado) persona;
					MenuJurado cali = new MenuJurado();
					cali.setVisible(true);
					encontrado = true;
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
		
		Trabajo trabajo = buscarTrabajoByCode(codTrabajo);
		Trabajo trabajoEnComision = buscarTrabajoEnComision(trabajo);
		trabajoEnComision.getCalificaciones().add(cali);
		trabajo.getCalificaciones().add(cali);
		
	}
	
	private Trabajo buscarTrabajoEnComision(Trabajo trabajo) {
		
		Comision comision = getComisionByCode(trabajo.getCodeComision());
				
		Trabajo aux = null;
		boolean encontrado = false;
		int i = 0;
		while(!encontrado && i < comision.getTrabajos().size()) {
			if (comision.getTrabajos().get(i).getCodigo().equalsIgnoreCase(trabajo.getCodigo())) {
				aux = comision.getTrabajos().get(i);
				encontrado = true;
			}
			i++;
		}
		return aux;
	}
	
	public float calCalificacionFinal(String codeTrabajo) {
		float cali = 0;
		
		Trabajo trabajo = buscarTrabajoByCode(codeTrabajo);
		
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
	

	
	public boolean eliminarTrabajo(Trabajo selected) {
		return trabajos.remove(selected);

	}
	
	
	public Trabajo buscarTrabajoByCode(String code) {
		Trabajo aux = null;
		boolean encontrado = false;
		int i = 0;
		while(!encontrado && i < trabajos.size()) {
			if (trabajos.get(i).getCodigo().equalsIgnoreCase(code)) {
				aux = trabajos.get(i);
				encontrado = true;
			}
			i++;
		}
		return aux;
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
