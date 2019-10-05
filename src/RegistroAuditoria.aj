
public aspect RegistroAuditoria {
	// defina un pointcut con el nombre "metodosDelMundo"
	  // para todas las invocaciones de los métodos (call)
	  // - métodos con cualquier tipo de retorno (*)
	  // - métodos de cualquier clase en el paquete "mundo"
	  // - métodos con cualquier tipo de argumentos
	  pointcut metodosDeControl() : call( * ejemplo.cajero.control..*(..));
	  
	// ejecución antes de ejecutar el método 
	  before(): metodosDeControl() {

	    System.out.println("Ejectando");
	    System.out.println("\t objeto     : " + thisJoinPoint.getTarget());
	    System.out.println("\t método     : " + thisJoinPoint.getSignature());
	    System.out.println("\t argumentos : " + thisJoinPoint.getArgs());
	  }
	  
	  // ejecución al retornar el método
	  after() returning(Object resultado): metodosDeControl() {
		// ejecute el método original
	    
	    System.out.println("Retornando");
	    System.out.println("\t resultado  : " + resultado);
	  }
	  
	  // ejecución al retornar el método
	  after() throwing(Exception e): metodosDeControl() {

	    System.out.println("Retornando con Excepción");
	    System.out.println("\t excepción : " + e.getMessage());
	  }
}