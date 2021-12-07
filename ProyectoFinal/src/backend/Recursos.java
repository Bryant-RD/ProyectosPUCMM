package backend;

public class Recursos {
	
	private int cantidad;
	private int disponibilidad;
	private String tipo;
	private String nombreEquipo;
	
	
	public Recursos(int cantidad, String tipo, String nombreEquipo) {
		this.cantidad = cantidad;
		this.disponibilidad = cantidad;
		this.tipo = tipo;
		this.nombreEquipo = nombreEquipo;
		
	}


	public int getCantidad() {
		return cantidad;
	}


	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}


	public int getDisponibilidad() {
		return disponibilidad;
	}


	public void setDisponibilidad(int disponibilidad) {
		this.disponibilidad = disponibilidad;
	}


	public String getTipo() {
		return tipo;
	}


	public void setTipo(String tipo) {
		this.tipo = tipo;
	}


	public String getNombreEquipo() {
		return nombreEquipo;
	}


	public void setNombreEquipo(String nombreEquipo) {
		this.nombreEquipo = nombreEquipo;
	}
	
	
	
	
	
}
