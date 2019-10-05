package ejemplo.cajero.control;

import ejemplo.cajero.modelo.Banco;

/**
 * Comando usado para consignar dinero
 */
public class ComandoListarOperaciones implements Comando {

	@Override
	public String getNombre() {
		return "Listar operaciones";
	}

	@Override
	public void ejecutar(Banco contexto) throws Exception {
		
		System.out.println("Listado de operaciones");
		System.out.println();
		
		// la clase Console no funciona bien en Eclipse
		for(String operacion : contexto.getLstOperaciones()) {
			System.out.println(operacion);
		}		
	}

}
