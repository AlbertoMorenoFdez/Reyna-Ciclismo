package clases;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashSet;

import excepciones.ProveedorNoExisteException;
import utils.DAO;

public class Accesorio extends Producto {
	private String talla;
//Constructor para leer todos los prodcutos de la tabla accesorio.
	public Accesorio(String marca, String modelo, String color, String descripcion, float precio, Proveedor proveedor,
			String talla) throws SQLException {
		super(marca, modelo, color, descripcion, precio, proveedor);
		this.talla = talla;
		this.getEan();
	}	
	
// Constructor para insertar accesorios en las tablas de la BBDD.
	public Accesorio(String marca, String modelo, String color, String descripcion, int ean, float precio, String talla,
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
		        String talla=(String) resultados.get(i+6);
		        String nombreProveedor=(String) resultados.get(i+7);
		        Proveedor proveedor=new Proveedor(nombreProveedor);
		        
		        Accesorio accesorio = new Accesorio(marca, modelo, color, descripcion, precio, proveedor, talla);
		        accesorio.setEan(ean);
		        accesorio.setProveedor(proveedor);
		        accesorios.add(accesorio);
		    }

		    return accesorios;
		}

	public String getTalla() {
		return talla;
	}

	public void setTalla(String talla) {
		this.talla = talla;
	}

	@Override
	public String toString() {
		return super.toString() + "Accesorio [talla=" + talla + "]";
	}

}
