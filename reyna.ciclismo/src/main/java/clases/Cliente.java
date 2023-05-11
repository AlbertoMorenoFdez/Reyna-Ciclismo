package clases;

import java.io.FileWriter;
import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.HashMap;

import utils.DAO;

public class Cliente extends Usuario {
	private String nombre;
	private String direccion;
	private String DNI;
	private short telefono;
	
	

	public Cliente(String email, String contraseña, String nombre, String direccion, String dni) {
		super(email, contraseña);
		this.nombre = nombre;
		this.direccion = direccion;
		this.DNI = dni;
		this.telefono = telefono;
	}
	
	public Cliente(String email, String contraseña, String nombre, String direccion, String dni, short telefono) throws SQLException {
		super(email, contraseña);
		HashMap<String, Object> datosCliente = new HashMap<String, Object>();
		
		datosCliente.put("correo_electronico", super.getEmail());
		datosCliente.put("nombre", nombre);
		datosCliente.put("direccion", direccion);
		datosCliente.put("DNI", dni);
		datosCliente.put("numero_telefono", telefono);
		try {

			if (DAO.insertar("usuarios", datosCliente) == 1) {
				System.out.println("Usuario registrado con éxito.");
				LocalDateTime now = LocalDateTime.now();
				
			// Escribimos en el fichero clientes.log
				String mensajeRegistro = "Usuario " + email + " registrado con éxito en: " + now.toString();
				try {
					FileWriter escritor = new FileWriter("./clientes.log", true);
					escritor.write(mensajeRegistro + "\n");
					escritor.flush();
					escritor.close();
				} catch (IOException e) {
					System.err.println("Error al escribir en el fichero clientes.log: " + e.getMessage());
				}

			}
		} catch (SQLException e) {
			System.err.println(
					"Error al registrar el cliente: " + e.getMessage() + " (Código: " + e.getErrorCode() + ")");
		}
		this.email = super.getEmail();
		this.nombre = nombre;
		this.telefono = telefono;
		this.direccion=direccion;
		this.DNI=dni;
		
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

	public String getDni() {
		return DNI;
	}

	public void setDni(String dni) {
		this.DNI = dni;
	}

	public short getTelefono() {
		return telefono;
	}

	public void setTelefono(short telefono) {
		this.telefono = telefono;
	}

	@Override
	public String toString() {
		return "Cliente [nombre=" + nombre + ", direccion=" + direccion + ", dni=" + DNI + ", telefono=" + telefono
				+ "]";
	}
	
	
	
	
}
