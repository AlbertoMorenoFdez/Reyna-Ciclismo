package excepciones;

public class ProveedorNoExisteException extends Exception{
	public ProveedorNoExisteException(String mensaje) {
        super("El proveedor no existe en la base de datos.");
    }

	

}
