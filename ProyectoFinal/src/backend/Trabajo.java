package backend;

public class Trabajo {
	
	private String codigo;
	private String nombre;
	private String tema;
	private float calificacion;
	
	
	public Trabajo(String codigo, String nombre, String tema) {
		super();
		this.codigo = codigo;
		this.nombre = nombre;
		this.tema = tema;
		this.calificacion = 0;
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
	
	public float getCalificacion() {
		return calificacion;
	}
	
	public void setCalificacion(float calificacion) {
		this.calificacion = calificacion;
	}

}
