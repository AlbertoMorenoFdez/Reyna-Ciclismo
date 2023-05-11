package clases;

public class Proveedor {
	private String nombre;
	private String direccion;
	private String CIF;
	private String emailProveedor;
	private short telefonoProveedor;
	
	public Proveedor(String nombre, String direccion, String cif, String emailProveedor, short telefonoProveedor) {
		super();
		this.nombre = nombre;
		this.direccion = direccion;
		this.CIF=cif;
		this.emailProveedor = emailProveedor;
		this.telefonoProveedor = telefonoProveedor;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getCIF() {
		return CIF;
	}

	public void setCIF(String cif) {
		this.CIF = cif;
	}

	public String getEmailProveedor() {
		return emailProveedor;
	}

	public void setEmailProveedor(String emailProveedor) {
		this.emailProveedor = emailProveedor;
	}

	public short getTelefonoProveedor() {
		return telefonoProveedor;
	}

	public void setTelefonoProveedor(short telefonoProveedor) {
		this.telefonoProveedor = telefonoProveedor;
	}

	@Override
	public String toString() {
		return "Proveedor [nombre=" + nombre + ", direccion=" + direccion + ", CIF=" + CIF + ", emailProveedor="
				+ emailProveedor + ", telefonoProveedor=" + telefonoProveedor + "]";
	}
	
	
	
}
