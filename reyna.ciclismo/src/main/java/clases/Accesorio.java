package clases;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashSet;

import excepciones.ProveedorNoExisteException;
import utils.DAO;

public class Accesorio extends Producto {
	private byte talla;

	public Accesorio(String marca, String modelo, String color, String descripcion, int ean, float precio, byte talla,
			String nombreProveedor) throws SQLException, ProveedorNoExisteException {
		super(marca, modelo, color, descripcion, ean, precio);
		HashMap<String, Object> datosAccesorio = new HashMap<String, Object>();
		datosAccesorio.put("marca", marca);
		datosAccesorio.put("modelo", modelo);
		datosAccesorio.put("color", color);
		datosAccesorio.put("descripcion", descripcion);
		datosAccesorio.put("ean", ean);
		datosAccesorio.put("precio", precio);
		datosAccesorio.put("talla_accesorio", talla);
		datosAccesorio.put("nombre_proveedor", nombreProveedor);

		DAO.insertar("accesorio", datosAccesorio);
		DAO.insertar("productos", datosAccesorio);

		this.marca = marca;
		this.modelo = modelo;
		this.color = color;
		this.descripcion = descripcion;
		this.EAN = ean;
		this.precio = precio;
		this.talla = talla;
		this.proveedor = new Proveedor(nombreProveedor);

	}
	
	// Funcion para leer toda la tabla de accesorio
		public static ArrayList<Accesorio> getTodos() throws SQLException, ProveedorNoExisteException {
		    ArrayList<Accesorio> accesorios = new ArrayList<>();

		    LinkedHashSet<String> columnasSelect = new LinkedHashSet<>(
		            Arrays.asList("marca", "modelo", "color", "descripcion","ean", "precio", "talla_accesorio","nombre_proveedor"));
		    HashMap<String, Object> restricciones = new HashMap<>();

		    ArrayList<Object> resultados = DAO.consultar("accesorio", columnasSelect, restricciones);

		    for (int i = 0; i < resultados.size(); i += 8) {
		        String marca = (String) resultados.get(i);
		        String modelo = (String) resultados.get(i + 1);
		        String color = (String) resultados.get(i + 2);
		        String descripcion = (String) resultados.get(i + 3);
		        int ean = (Integer) resultados.get(i + 4);
		        float precio=(float) resultados.get(i+5);
		        byte talla=(byte) resultados.get(i+6);
		        String nombreProveedor=(String) resultados.get(i+7);
		        
		        Accesorio accesorio = new Accesorio(marca, modelo, color, descripcion, ean, precio, talla, nombreProveedor);
		        accesorios.add(accesorio);
		    }

		    return accesorios;
		}

	public byte getTalla() {
		return talla;
	}

	public void setTalla(byte talla) {
		this.talla = talla;
	}

	@Override
	public String toString() {
		return super.toString() + "Accesorio [talla=" + talla + "]";
	}

}
