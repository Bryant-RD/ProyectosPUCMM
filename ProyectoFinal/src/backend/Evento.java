package backend;

import java.util.ArrayList;

public class Evento {

	private String codigo;
	private String nombre;
	private String tema;
	private String fecha;
	private Participante ganador;
	private String local;
	private Comision comision;
	private ArrayList<Persona> integrantes;
	private ArrayList<Trabajo> proyectos;
	private ArrayList<Recursos> recursosUtilizados;
	
	
	
	public Evento(String codigo, String nombre, String tema, String fecha, String local) {
		super();
		this.codigo = codigo;
		this.nombre = nombre;
		this.tema = tema;
		this.fecha = fecha;
		this.ganador = null;
		this.local = local;
		integrantes = new ArrayList<>();
		proyectos = new ArrayList<>();
		recursosUtilizados = new ArrayList<>();
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
	public String getFecha() {
		return fecha;
	}
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	public Participante getGanador() {
		return ganador;
	}
	public void setGanador(Participante ganador) {
		this.ganador = ganador;
	}
	public String getLocal() {
		return local;
	}
	public void setLocal(String local) {
		this.local = local;
	}
	public ArrayList<Persona> getIntegrantes() {
		return integrantes;
	}
	public void setIntegrantes(ArrayList<Persona> integrantes) {
		this.integrantes = integrantes;
	}
	public ArrayList<Trabajo> getProyectos() {
		return proyectos;
	}
	public void setProyectos(ArrayList<Trabajo> proyectos) {
		this.proyectos = proyectos;
	}




	public ArrayList<Recursos> getRecursosUtilizados() {
		return recursosUtilizados;
	}




	public void setRecursosUtilizados(ArrayList<Recursos> recursosUtilizados) {
		this.recursosUtilizados = recursosUtilizados;
	}




	public Comision getComision() {
		return comision;
	}




	public void setComision(Comision comision) {
		this.comision = comision;
	}

	
	
}
