package clases;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashSet;

import excepciones.ProductoNoExisteException;
import utils.DAO;

public class Producto {
	protected String marca;
	protected String modelo;
	protected String color;
	protected String descripcion;
	protected int EAN;
	protected float precio;

	protected Proveedor proveedor;
	
	public Producto(String marca, String modelo, String color, String descripcion, float precio, Proveedor proveedor)
			throws SQLException {
		this.marca = marca;
		this.modelo = modelo;
		this.color = color;
		this.descripcion = descripcion;
		this.precio = precio;
	}

// Constructor para insertar productos
	public Producto(String marca, String modelo, String color, String descripcion, int ean, float precio)
			throws SQLException {

		this.marca = marca;
		this.modelo = modelo;
		this.color = color;
		this.descripcion = descripcion;
		this.EAN = ean;
		this.precio = precio;
		this.proveedor = null;
	}
	
	

// Consultar Producto
	public Producto(String modelo) throws ProductoNoExisteException, SQLException {
		ArrayList<Object> datosProducto = null;
		HashMap<String, Object> restricciones = new HashMap<String, Object>();
		restricciones.put("modelo", modelo);

		datosProducto = DAO.consultar("productos",
				new LinkedHashSet<>(Arrays.asList("marca", "modelo", "EAN", "color", "descripcion", "precio",
						"modalidad", "talla_bicicleta", "calorias", "talla_accesorio", "nombre_proveedor", "cantidad")),
				restricciones);

		if (datosProducto.isEmpty()) {
			throw new ProductoNoExisteException(modelo);
		}
		this.marca = (String) datosProducto.get(0);
		this.modelo = (String) datosProducto.get(1);
		this.EAN = (Integer) datosProducto.get(2);
		this.color = (String) datosProducto.get(3);
		this.descripcion = (String) datosProducto.get(4);
		this.precio = ((BigDecimal) datosProducto.get(5)).floatValue();
		this.proveedor = (Proveedor) datosProducto.get(10);

	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public int getEan() {
		return EAN;
	}

	public void setEan(int ean) {
		this.EAN = ean;
	}

	public float getPrecio() {
		return precio;
	}

	public void setPrecio(float precio) {
		this.precio = precio;

	}

	public Proveedor getProveedor() {
		return proveedor;
	}

	public void setProveedor(Proveedor proveedor) {
		this.proveedor = proveedor;
	}

	@Override
	public String toString() {
		return "Producto [marca=" + marca + ", modelo=" + modelo + ", color=" + color + ", descripcion=" + descripcion
				+ ", EAN=" + EAN + ", precio=" + precio + ", proveedor=" + proveedor + "]";
	}

}
