package clases;

public class Administrador extends Usuario{

	public Administrador(String email, String contraseña) {
		super(email, contraseña);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String getEmail() {
		// TODO Auto-generated method stub
		return super.getEmail();
	}

	@Override
	public void setEmail(String email) {
		// TODO Auto-generated method stub
		super.setEmail(email);
	}

	@Override
	public String getContraseña() {
		// TODO Auto-generated method stub
		return super.getContraseña();
	}

	@Override
	public void setContraseña(String contraseña) {
		// TODO Auto-generated method stub
		super.setContraseña(contraseña);
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}

}
