package excepciones;

public class ContraseñaInvalidaException extends Exception {
	public ContraseñaInvalidaException(String mensaje) {
		super(mensaje);
	}
}
