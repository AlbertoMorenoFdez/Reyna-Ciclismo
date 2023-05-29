package clases;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashSet;

import excepciones.NombreConNumeroException;
import excepciones.ProveedorNoExisteException;
import excepciones.UsuarioNoExisteException;
import utils.DAO;

public class Proveedor {
	private String nombre;
	private String direccion;
	private String cif;
	private String emailProveedor;
	private Integer telefonoProveedor;

	public Proveedor(String nombre, String direccion, String emailProveedor, Integer telefonoProveedor) {
		this.nombre = nombre;
		this.direccion = direccion;
		this.emailProveedor = emailProveedor;
		this.telefonoProveedor = telefonoProveedor;
	}

	// Constructor para introducir en la base de datos
	public Proveedor(String nombre, String direccion, String cif, String emailProveedor, Integer telefonoProveedor)
			throws SQLException {
		HashMap<String, Object> datosProveedor = new HashMap<String, Object>();
		datosProveedor.put("correo_electronico", emailProveedor);
		datosProveedor.put("nombre", nombre);
		datosProveedor.put("numero_telefono", telefonoProveedor);
		datosProveedor.put("CIF", cif);
		datosProveedor.put("direccion", direccion);

		DAO.insertar("proveedores", datosProveedor);

		this.nombre = nombre;
		this.direccion = direccion;
		this.cif = cif;
		this.emailProveedor = emailProveedor;
		this.telefonoProveedor = telefonoProveedor;
	}

	// Funcion para consultar el proveedor
	public Proveedor(String nombre) throws  SQLException,ProveedorNoExisteException {
		ArrayList<Object> datosProveedor = null;
		HashMap<String, Object> restricciones = new HashMap<String, Object>();
		restricciones.put("nombre", nombre);

		datosProveedor = DAO.consultar("proveedores",
				new LinkedHashSet<>(
						Arrays.asList("nombre", "direccion", "CIF", "numero_telefono", "correo_electronico")),
				restricciones);

		
		this.nombre = (String) datosProveedor.get(0);
		this.direccion = (String) datosProveedor.get(1);
		this.cif = (String) datosProveedor.get(2);
		this.telefonoProveedor = (Integer) datosProveedor.get(3);
		this.emailProveedor = (String) datosProveedor.get(4);
	}

	// Funcion para leer toda la tabla de proveedores
	public static ArrayList<Proveedor> getTodos() throws SQLException {
		ArrayList<Proveedor> proveedores = new ArrayList<>();

		LinkedHashSet<String> columnasSelect = new LinkedHashSet<>(
				Arrays.asList("nombre", "direccion", "correo_electronico", "CIF", "numero_telefono"));
		HashMap<String, Object> restricciones = new HashMap<>();

		ArrayList<Object> resultados = DAO.consultar("proveedores", columnasSelect, restricciones);

		for (int i = 0; i < resultados.size(); i += 5) {
			String nombre = (String) resultados.get(i);
			String direccion = (String) resultados.get(i + 1);
			String email = (String) resultados.get(i + 2);
			String cif = (String) resultados.get(i + 3);
			int telefono = (Integer) resultados.get(i + 4);

			Proveedor proveedor = new Proveedor(nombre, direccion, email, telefono);
			proveedor.setCIF(cif); // Asignar el valor del CIF recuperado de la base de datos
			proveedores.add(proveedor);
		}

		return proveedores;
	}

	public String getNombre() {
		return nombre;
	}

	// Cambiar el nombre del Proveedor
	public void setNombre(String nombre) throws SQLException {
		HashMap<String, Object> datosAModificar = new HashMap<>();
		datosAModificar.put("nombre", nombre);
		HashMap<String, Object> restricciones = new HashMap<>();
		restricciones.put("CIF", this.cif);

		try {
			DAO.actualizar("proveedores", datosAModificar, restricciones);
		} catch (SQLException e) {
			throw e;
		}

		this.nombre = nombre;
	}

	public String getDireccion() {
		return direccion;
	}

	// Cambiar la direccion del Proveedor
	public void setDireccion(String direccion) throws SQLException {
		HashMap<String, Object> datosAModificar = new HashMap<>();
		datosAModificar.put("direccion", direccion);
		HashMap<String, Object> restricciones = new HashMap<>();
		restricciones.put("CIF", this.cif);

		try {
			DAO.actualizar("proveedores", datosAModificar, restricciones);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.direccion = direccion;
	}

	public String getCIF() {
		return cif;
	}

//	public void setCIF(String cif) throws SQLException{
//		HashMap<String, Object> datosAModificar = new HashMap<>();
//		datosAModificar.put("CIF", cif);
//		HashMap<String, Object> restricciones = new HashMap<>();
//		restricciones.put("CIF", this.cif);
//		
//		try {
//			DAO.actualizar("proveedores", datosAModificar, restricciones);
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//		this.cif = cif;
//		
//	}

	public void setCIF(String cif) {
		this.cif = cif;
	}

	public String getEmailProveedor() {
		return emailProveedor;
	}

	// Cambiar el email del Proveedor
	public void setEmailProveedor(String emailProveedor) throws SQLException {
		HashMap<String, Object> datosAModificar = new HashMap<>();
		datosAModificar.put("correo_electronico", emailProveedor);
		HashMap<String, Object> restricciones = new HashMap<>();
		restricciones.put("CIF", this.cif);

		try {
			DAO.actualizar("proveedores", datosAModificar, restricciones);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.emailProveedor = emailProveedor;
	}

	public Integer getTelefonoProveedor() {
		return telefonoProveedor;
	}

	// Cambiar el telefono del Proveedor
	public void setTelefono(Integer telefonoProveedor) throws SQLException {

		HashMap<String, Object> datosAModificar = new HashMap<>();
		datosAModificar.put("numero_telefono", telefonoProveedor);

		HashMap<String, Object> restricciones = new HashMap<>();
		restricciones.put("CIF", this.cif);

		try {
			DAO.actualizar("proveedores", datosAModificar, restricciones);
		} catch (SQLException e) {
			throw e;
		}

		this.telefonoProveedor = telefonoProveedor;
	}

	@Override
	public String toString() {
		return "Proveedor [nombre=" + nombre + ", direccion=" + direccion + ", CIF=" + cif + ", emailProveedor="
				+ emailProveedor + ", telefonoProveedor=" + telefonoProveedor + "]";
	}

}
