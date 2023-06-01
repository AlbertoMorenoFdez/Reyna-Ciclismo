package excepciones;

public class ProveedorNoExisteException extends Exception{
	public ProveedorNoExisteException() {
        super("El proveedor no existe en la base de datos.");
    }

	

}
