package excepciones;

public class UsuarioNoExisteException extends Exception {
	public UsuarioNoExisteException(String mensaje) {
		super(mensaje);
	}
}
