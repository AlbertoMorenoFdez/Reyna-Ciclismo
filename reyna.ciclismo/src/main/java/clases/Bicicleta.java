package clases;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashSet;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

import enumReyna.ModalidadBicicleta;
import excepciones.ProveedorNoExisteException;
import utils.DAO;

public class Bicicleta extends Producto {
	private ModalidadBicicleta modalidad;
	private String tallaBicicleta;
	


	


	
	public Bicicleta(String marca, String modelo, String color, String descripcion, float precio, Proveedor proveedor,
			ModalidadBicicleta modalidad, String tallaBicicleta) throws SQLException {
		super(marca, modelo, color, descripcion, precio, proveedor);
		this.modalidad = modalidad;
		this.tallaBicicleta = tallaBicicleta;
		this.getEan();
	}

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
			String valorModalidad = (String) resultados.get(i + 6);
			ModalidadBicicleta modalidad = null;
			switch (valorModalidad) {
			case "MTB":
				modalidad = ModalidadBicicleta.MTB;
				break;
			case "CARRETERA":
				modalidad = ModalidadBicicleta.CARRETERA;
			case "EBIKE":
				modalidad = ModalidadBicicleta.MTB;
			case "URBAN":
				modalidad = ModalidadBicicleta.MTB;

			}
			String tallaBicicleta = (String) resultados.get(i + 7);
			String nombreProveedor = (String) resultados.get(i + 8);
			Proveedor proveedor=new Proveedor(nombreProveedor);
			

			Bicicleta bicicleta = new Bicicleta(marca, modelo, color, descripcion, precio, proveedor,modalidad,
					tallaBicicleta);
			System.out.println(bicicleta);
			bicicleta.setEan(ean);
			bicicleta.setProveedor(proveedor);
			bicicletas.add(bicicleta);

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

	private ModalidadBicicleta toEnum(String valor) {
		return ModalidadBicicleta.MTB;
	}

	public ImageIcon getImagen() {
		JLabel labelImagen = new JLabel("");
		try {
			BufferedImage imagen=ImageIO.read(new File(".\\imagenes\\ebike.png"));
			Image enIcono=imagen.getScaledInstance(200, 100, imagen.SCALE_SMOOTH);
			labelImagen.setIcon(new ImageIcon(enIcono));
		} catch (IOException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		return null;
	}
}
