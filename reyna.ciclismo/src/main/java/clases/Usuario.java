package clases;

import java.io.FileWriter;

import java.io.IOException;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Map.Entry;

import excepciones.ContraseñaInvalidaException;
import excepciones.NombreConNumeroException;

import excepciones.UsuarioNoExisteException;
import utils.DAO;

public class Usuario {
	protected String email;
	private String contraseña;
	private String nombre;
	private String direccion;
	private String DNI;
	private Integer telefono;
	private boolean esAdmin;

	
	public Usuario(String email, String nombre, Integer telefono, String dni, String direccion)
			throws SQLException, NombreConNumeroException {
		this.email = email;
		this.setNombre(nombre);
		this.telefono = (int) telefono;
		this.DNI = dni;
		this.direccion = direccion;

	}
// Funcion para registrar usuarios
	public Usuario(String email, String nombre, Integer telefono, String contraseña, String dni, String direccion) throws SQLException, NombreConNumeroException
			{
		// Validar el nombre para verificar si contiene números
	    String numeros = "0987654321";
	    for (short i = 0; i < nombre.length(); i++) {
	        if (numeros.contains("" + nombre.charAt(i))) {
	            throw new NombreConNumeroException("El nombre " + nombre + " no es válido porque tiene números");
	        }
	    }
		
		HashMap<String, Object> datosCliente = new HashMap<String, Object>();

		datosCliente.put("correo_electronico", email);
		datosCliente.put("nombre", nombre);
		datosCliente.put("numero_telefono", telefono);
		datosCliente.put("contraseña", contraseña);
		datosCliente.put("DNI", dni);
		datosCliente.put("direccion", direccion);
		
		DAO.insertar("usuarios", datosCliente);

		this.email = email;
		this.setNombre(nombre);
		this.telefono = (int) telefono;
		this.DNI = dni;
		this.direccion = direccion;

	}

	// Funcion para el Login
	public Usuario(String email, String contraseña)
			throws UsuarioNoExisteException, ContraseñaInvalidaException, SQLException {
		ArrayList<Object> datosCliente = null;
		HashMap<String, Object> restricciones = new HashMap<String, Object>();

		restricciones.put("correo_electronico", email);

		datosCliente = DAO.consultar("usuarios", new LinkedHashSet<>(
				Arrays.asList("correo_electronico", "nombre", "numero_telefono", "contraseña", "DNI", "direccion")),
				restricciones);

		if (datosCliente.isEmpty()) {
			throw new UsuarioNoExisteException(email);
		} else {
			String contraseñaRecuperada = (String) datosCliente.get(3);
			if (!contraseña.equals(contraseñaRecuperada)) {
				throw new ContraseñaInvalidaException(contraseña);
			}

			this.nombre = (String) datosCliente.get(1);
			this.direccion = (String) datosCliente.get(5);
			this.email = (String) datosCliente.get(0);
			this.DNI = (String) datosCliente.get(4);
			this.telefono = (Integer) datosCliente.get(2);

			// Escribir en el fichero clientes.log
			LocalDateTime now = LocalDateTime.now();
			String mensajeLogin = "Cliente " + email + " logueado con éxito en: " + now.toString();
			try {
				FileWriter escritor = new FileWriter("./clientes.log", true);
				escritor.write(mensajeLogin + "\n");
				escritor.flush(); // Hace que se escriba de verdad
				escritor.close(); // Hace que el programa se cierre, si se queda abierto no podemos escribir
			} catch (IOException e) {
				System.err.println("Error al escribir en el fichero clientes.log: " + e.getMessage());
			}
		}
	}

	// Funcion para leer toda la tabla de usuarios.
	public static ArrayList<Usuario> getTodos() throws SQLException, NombreConNumeroException {
		ArrayList<Usuario> usuarios = new ArrayList<>();

		LinkedHashSet<String> columnasSelect = new LinkedHashSet<>(
				Arrays.asList("nombre", "direccion", "correo_electronico", "DNI", "numero_telefono"));
		HashMap<String, Object> restricciones = new HashMap<>();

		ArrayList<Object> resultados = DAO.consultar("usuarios", columnasSelect, restricciones);

		for (int i = 0; i < resultados.size(); i += 5) {
			String nombre = (String) resultados.get(i);
			String direccion = (String) resultados.get(i + 1);
			String email = (String) resultados.get(i + 2);
			String dni = (String) resultados.get(i + 3);
			int telefono = (Integer) resultados.get(i + 4);

			Usuario usuario = new Usuario(email, nombre, telefono, dni, direccion);
			usuarios.add(usuario);
		}

		return usuarios;
	}

	public String getNombre() {
		return nombre;
	}

	// Cambiar el nombre del Usuario
	public void setNombre(String nombre) throws NombreConNumeroException, SQLException {
	    // Validar el nombre para verificar si contiene números
	    String numeros = "0987654321";
	    for (short i = 0; i < nombre.length(); i++) {
	        if (numeros.contains("" + nombre.charAt(i))) {
	            throw new NombreConNumeroException("El nombre " + nombre + " no es válido porque tiene números");
	        }
	    }

	    HashMap<String, Object> datosAModificar = new HashMap<>();
	    datosAModificar.put("nombre", nombre);
	    HashMap<String, Object> restricciones = new HashMap<>();
	    restricciones.put("correo_electronico", this.email);

	  
	        DAO.actualizar("usuarios", datosAModificar, restricciones);
	   

	    this.nombre = nombre;
	}

	public String getDireccion() {
		return direccion;
	}

	// Cambiar la direccion del Usuario
	public void setDireccion(String direccion) throws SQLException {
		HashMap<String, Object> datosAModificar = new HashMap<>();
		datosAModificar.put("direccion", direccion);
		HashMap<String, Object> restricciones = new HashMap<>();
		restricciones.put("correo_electronico", this.email);

		try {
			DAO.actualizar("usuarios", datosAModificar, restricciones);
		} catch (SQLException e) {
			throw e;
		}

		this.direccion = direccion;
	}

	public String getDNI() {
		return DNI;
	}

	// Cambiar el DNI del Usuario
	public void setDNI(String dni) throws SQLException {
		HashMap<String, Object> datosAModificar = new HashMap<>();
		datosAModificar.put("DNI", dni);
		HashMap<String, Object> restricciones = new HashMap<>();
		restricciones.put("correo_electronico", this.email);

		try {
			DAO.actualizar("usuarios", datosAModificar, restricciones);
		} catch (SQLException e) {
			throw e;
		}

		this.DNI = dni;
	}

	public Integer getTelefono() {
		return telefono;
	}

	// Cambiar el telefono del Usuario
	public void setTelefono(Integer telefono) throws SQLException {
		HashMap<String, Object> datosAModificar = new HashMap<>();
		datosAModificar.put("numero_telefono", telefono);
		HashMap<String, Object> restricciones = new HashMap<>();
		restricciones.put("correo_electronico", this.email);

		try {
			DAO.actualizar("usuarios", datosAModificar, restricciones);
		} catch (SQLException e) {
			throw e;
		}

		this.telefono = telefono;
	}

	public String getEmail() {
		return email;
	}

	// Cambiar el email del Usuario
	public void setEmail(String email) throws SQLException {
		HashMap<String, Object> datosAModificar = new HashMap<>();
		datosAModificar.put("correo_electronico", email);
		HashMap<String, Object> restricciones = new HashMap<>();
		restricciones.put("correo_electronico", this.email);

		try {
			DAO.actualizar("usuarios", datosAModificar, restricciones);
		} catch (SQLException e) {
			throw e;
		}

		this.email = email;
	}

	public String getContraseña() {
		return contraseña;
	}

	// Cambiar la contraseña del Usuario
	public void setContraseña(String contraseña) throws SQLException {
		HashMap<String, Object> datosAModificar = new HashMap<>();
		datosAModificar.put("contraseña", contraseña);
		HashMap<String, Object> restricciones = new HashMap<>();
		restricciones.put("correo_electronico", this.email);

		try {
			DAO.actualizar("usuarios", datosAModificar, restricciones);
		} catch (SQLException e) {
			throw e;
		}

		this.contraseña = contraseña;
	}

	@Override
	public String toString() {
		return "Usuario [email=" + email + ", contraseña=" + contraseña + "]";
	}

}
