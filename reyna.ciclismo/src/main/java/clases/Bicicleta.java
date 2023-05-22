package clases;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashSet;

import enumReyna.ModalidadBicicleta;
import excepciones.ProveedorNoExisteException;
import utils.DAO;

public class Bicicleta extends Producto {
	private ModalidadBicicleta modalidad;
	private String tallaBicicleta;

	public Bicicleta(String marca, String modelo, String color, String descripcion, int ean, float precio,
			ModalidadBicicleta modalidad, String tallaBicicleta, String nombreProveedor)
			throws SQLException, ProveedorNoExisteException {

		super(marca, modelo, color, descripcion, ean, precio);
		HashMap<String, Object> datosBicicleta = new HashMap<String, Object>();
		datosBicicleta.put("marca", marca);
		datosBicicleta.put("modelo", modelo);
		datosBicicleta.put("color", color);
		datosBicicleta.put("descripcion", descripcion);
		datosBicicleta.put("ean", ean);
		datosBicicleta.put("precio", precio);
		datosBicicleta.put("modalidad", modalidad.name());
		datosBicicleta.put("talla_bicicleta", tallaBicicleta);
		datosBicicleta.put("nombre_proveedor", nombreProveedor);

		DAO.insertar("bicicleta", datosBicicleta);
		DAO.insertar("productos", datosBicicleta);

		this.marca = marca;
		this.modelo = modelo;
		this.color = color;
		this.descripcion = descripcion;
		this.EAN = ean;
		this.precio = precio;
		this.modalidad = modalidad;
		this.tallaBicicleta = tallaBicicleta;
		this.proveedor = new Proveedor(nombreProveedor);

	}

	// Funcion para leer toda la tabla de bicicletas
	public static ArrayList<Bicicleta> getTodos() throws SQLException, ProveedorNoExisteException {
		ArrayList<Bicicleta> bicicletas = new ArrayList<>();

		LinkedHashSet<String> columnasSelect = new LinkedHashSet<>(Arrays.asList("marca", "modelo", "color",
				"descripcion", "ean", "precio", "modalidad", "talla_bicicleta", "nombre_proveedor"));
		HashMap<String, Object> restricciones = new HashMap<>();

		ArrayList<Object> resultados = DAO.consultar("bicicleta", columnasSelect, restricciones);

		for (int i = 0; i < resultados.size(); i += 9) {
			String marca = (String) resultados.get(i);
			String modelo = (String) resultados.get(i + 1);
			String color = (String) resultados.get(i + 2);
			String descripcion = (String) resultados.get(i + 3);
			int ean = (Integer) resultados.get(i + 4);
			float precio = (float) resultados.get(i + 5);
			ModalidadBicicleta modalidad = (ModalidadBicicleta) resultados.get(i + 6);
			String tallaBicicleta = (String) resultados.get(i + 7);
			String nombreProveedor = (String) resultados.get(i + 8);

			if (marca != null && modelo != null && color != null && descripcion != null && modalidad != null
					&& tallaBicicleta != null && nombreProveedor != null) {
				Bicicleta bicicleta = new Bicicleta(marca, modelo, color, descripcion, ean, precio, modalidad,
						tallaBicicleta, nombreProveedor);
				bicicletas.add(bicicleta);
			}
		}

		return bicicletas;
	}

	public ModalidadBicicleta getModalidad() {
		return modalidad;
	}

	public void setModalidad(ModalidadBicicleta modalidad) {
		this.modalidad = modalidad;
	}

	public String getTallaBicicleta() {
		return tallaBicicleta;
	}

	public void setTallaBicicleta(String tallaBicicleta) {
		this.tallaBicicleta = tallaBicicleta;
	}

	@Override
	public String toString() {
		return super.toString() + "Bicicicleta [modalidad=" + modalidad + ", tallaBicicleta=" + tallaBicicleta + "]";
	}

}
