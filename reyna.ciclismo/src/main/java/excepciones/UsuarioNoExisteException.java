package excepciones;

public class UsuarioNoExisteException extends Exception {
	public UsuarioNoExisteException(String mensaje) {
		super("El usuario no existe en la base de datos.");
	}
}
