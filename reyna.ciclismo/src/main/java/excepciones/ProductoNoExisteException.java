package excepciones;

public class ProductoNoExisteException extends Exception {
	public ProductoNoExisteException(String mensaje) {
		super("El producto no existe en la base de datos.");
	}
}
