package clases;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashSet;

import excepciones.ProveedorNoExisteException;
import utils.DAO;

public class Alimentacion extends Producto {
	private String calorias;
	
// Constructor para leer toda la tabla de alimentacion.
	public Alimentacion(String marca, String modelo, String color, String descripcion, float precio, Proveedor proveedor,
			String calorias) throws SQLException {
		super(marca, modelo, color, descripcion, precio, proveedor);
		this.calorias = calorias;
		this.getEan();
	}

//Constructor para insertar articulos de alimentacion en la tabla productos.
	public Alimentacion(String marca, String modelo, String color, String descripcion, int ean, float precio,
			String calorias, String nombreProveedor) throws SQLException {
		super(marca, modelo, color, descripcion, ean, precio);
		HashMap<String, Object> datosAlimentacion = new HashMap<String, Object>();
		datosAlimentacion.put("marca", marca);
		datosAlimentacion.put("modelo", modelo);
		datosAlimentacion.put("color", color);
		datosAlimentacion.put("descripcion", descripcion);
		datosAlimentacion.put("ean", ean);
		datosAlimentacion.put("precio", precio);
		datosAlimentacion.put("calorias", calorias);
		datosAlimentacion.put("nombre_proveedor", nombreProveedor);

		DAO.insertar("alimentacion", datosAlimentacion);
		DAO.insertar("productos", datosAlimentacion);

		this.marca = marca;
		this.modelo = modelo;
		this.color = color;
		this.descripcion = descripcion;
		this.EAN = ean;
		this.precio = precio;

		this.calorias = calorias;
		try {
			this.proveedor = new Proveedor(nombreProveedor);
		} catch (ProveedorNoExisteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



//Funcion para leer toda la tabla de alimentación
	public static ArrayList<Alimentacion> getTodos() throws SQLException, ProveedorNoExisteException {
		ArrayList<Alimentacion> todoAlimentacion = new ArrayList<>();

		LinkedHashSet<String> columnasSelect = new LinkedHashSet<>(Arrays.asList("marca", "modelo", "color",
				"descripcion", "ean", "precio", "calorias", "nombre_proveedor"));
		HashMap<String, Object> restricciones = new HashMap<>();

		ArrayList<Object> resultados = DAO.consultar("alimentacion", columnasSelect, restricciones);

		for (int i = 0; i < resultados.size(); i += 8) {
			String marca = (String) resultados.get(i);
			String modelo = (String) resultados.get(i + 1);
			String color = (String) resultados.get(i + 2);
			String descripcion = (String) resultados.get(i + 3);
			int ean = (Integer) resultados.get(i + 4);
			float precio = (float) resultados.get(i + 5);
			String calorias = (String) resultados.get(i + 6);
			String nombreProveedor = (String) resultados.get(i + 7);
			Proveedor proveedor=new Proveedor(nombreProveedor);

			Alimentacion alimentacion = new Alimentacion(marca, modelo, color, descripcion, precio, proveedor,
					calorias);
			alimentacion.setEan(ean);
			alimentacion.setProveedor(proveedor);
			todoAlimentacion.add(alimentacion);
		}

		return todoAlimentacion;
	}

	public String getCalorias() {
		return calorias;
	}

	public void setCalorias(String calorias) {
		this.calorias = calorias;
	}

	@Override
	public String toString() {
		return super.toString() + "Alimentacion [calorias=" + calorias + "]";
	}

}
