package clases;

public class Usuario {
protected String email;
private String contraseña;

public Usuario(String email, String contraseña) {
	super();
	this.email = email;
	this.contraseña = contraseña;
}

public String getEmail() {
	return email;
}

public void setEmail(String email) {
	this.email = email;
}

public String getContraseña() {
	return contraseña;
}

public void setContraseña(String contraseña) {
	this.contraseña = contraseña;
}

@Override
public String toString() {
	return "Usuario [email=" + email + ", contraseña=" + contraseña + "]";
}


}
