package backend;

public class Actividad extends Evento{
	
	private String tipo;
	private String duracion;

	public Actividad(String codigo, String nombre, String tema, String fecha, Participante ganador, String local) {
		super(codigo, nombre, tema, fecha, local);
	}

}
