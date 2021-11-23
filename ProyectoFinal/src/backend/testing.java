package backend;

public class testing {

	public static void main(String[] args) {
		
		Recursos recurso = new Recursos(100, 100, "Audio", "Monitor-62pul");
		
		PUCMM.getInstance().agregarRecurso(recurso);
		PUCMM.getInstance().agregarRecursoEvento(recurso, 5);
		
		System.out.print(PUCMM.getInstance().buscarRecurso(recurso.getNombreEquipo()).getDisponibilidad());
		

	}

}
