package interfaces;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import clases.Bicicleta;
import clases.Proveedor;
import excepciones.ProveedorNoExisteException;
import utils.DAO;

import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;

public class PantallaModificarBicicleta extends JPanel {
	private Ventana ventana;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private final JTable tablaBicicletas;
	private final DefaultTableModel model;

	public PantallaModificarBicicleta(Ventana v) {

		setBackground(new Color(78, 1, 23));
		this.ventana = v;
		this.tablaBicicletas = new JTable();
		this.model = new DefaultTableModel();
		setSize(800, 700);
		setBackground(new Color(78, 1, 23));
		setLayout(null);

		JLabel etiquetaModificarBicicleta = new JLabel("MODIFICAR BICICLETA");
		etiquetaModificarBicicleta.setBounds(70, 75, 655, 58);
		etiquetaModificarBicicleta.setHorizontalAlignment(SwingConstants.CENTER);
		etiquetaModificarBicicleta.setForeground(new Color(245, 196, 74));
		etiquetaModificarBicicleta.setFont(new Font("Eras Medium ITC", Font.BOLD, 50));
		etiquetaModificarBicicleta.setBackground(new Color(245, 196, 74));
		add(etiquetaModificarBicicleta);

		JLabel lblEligeQueProveedor = new JLabel("Elige que bicicleta quieres modificar");
		lblEligeQueProveedor.setBounds(70, 138, 655, 30);
		lblEligeQueProveedor.setHorizontalAlignment(SwingConstants.CENTER);
		lblEligeQueProveedor.setForeground(new Color(245, 196, 74));
		lblEligeQueProveedor.setFont(new Font("Eras Medium ITC", Font.BOLD, 25));
		lblEligeQueProveedor.setBackground(new Color(245, 196, 74));
		add(lblEligeQueProveedor);

		JLabel lblModificaElO = new JLabel("modifica el campo, o los campos, que quieras");
		lblModificaElO.setBounds(70, 173, 655, 30);
		lblModificaElO.setHorizontalAlignment(SwingConstants.CENTER);
		lblModificaElO.setForeground(new Color(245, 196, 74));
		lblModificaElO.setFont(new Font("Eras Medium ITC", Font.BOLD, 25));
		lblModificaElO.setBackground(new Color(245, 196, 74));
		add(lblModificaElO);

		JLabel lblYPulsaAceptar = new JLabel("y pulsa aceptar para confirmar.");
		lblYPulsaAceptar.setBounds(70, 208, 655, 30);
		lblYPulsaAceptar.setHorizontalAlignment(SwingConstants.CENTER);
		lblYPulsaAceptar.setForeground(new Color(245, 196, 74));
		lblYPulsaAceptar.setFont(new Font("Eras Medium ITC", Font.BOLD, 25));
		lblYPulsaAceptar.setBackground(new Color(245, 196, 74));
		add(lblYPulsaAceptar);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(70, 273, 655, 245);
		add(scrollPane);

		ArrayList<Bicicleta> todasLasBicicletas = null;

		try {
			todasLasBicicletas = Bicicleta.getTodos();
		} catch (SQLException | ProveedorNoExisteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// Crear el modelo de tabla y agregar las columnas correspondientes a los datos
		final DefaultTableModel model = new DefaultTableModel();
		model.addColumn("Marca");
		model.addColumn("Modelo");
		model.addColumn("Color");
		model.addColumn("Descripcion");
		model.addColumn("EAN");
		model.addColumn("Precio");
		model.addColumn("Modalidad");
		model.addColumn("Talla");
		model.addColumn("Proveedor");

		// Agregar las filas con los datos de las bicicletas
		for (Bicicleta bicicleta : todasLasBicicletas) {
			model.addRow(new Object[] { bicicleta.getMarca(), bicicleta.getModelo(), bicicleta.getColor(),
					bicicleta.getDescripcion(), String.valueOf(bicicleta.getEan()),
					String.valueOf(bicicleta.getPrecio()), bicicleta.getModalidad().toString(),
					bicicleta.getTallaBicicleta(), bicicleta.getProveedor().getNombre() });
		}

		// Crear la tabla con el modelo de datos
		final JTable tablaBicicletas = new JTable(model);

		// Establecer la tabla como contenido visible del JScrollPane
		scrollPane.setViewportView(tablaBicicletas);

		JButton botonAtras = new JButton("Cancelar");
		botonAtras.setBounds(70, 600, 170, 39);
		botonAtras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ventana.cambiarAPantalla(PantallaAdministracion.class);
			}
		});
		botonAtras.setForeground(new Color(78, 1, 23));
		botonAtras.setFont(new Font("Eras Medium ITC", Font.PLAIN, 25));
		botonAtras.setBackground(new Color(245, 196, 74));
		add(botonAtras);

		JButton botonAceptar = new JButton("Aceptar");
		botonAceptar.setBounds(552, 600, 173, 39);
		botonAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (tablaBicicletas.getCellEditor() != null) {
					tablaBicicletas.getCellEditor().stopCellEditing();
				}
				// Obtener los datos seleccionados en la tabla
				String marca = (String) model.getValueAt(tablaBicicletas.getSelectedRow(), 0);
				String modelo = (String) model.getValueAt(tablaBicicletas.getSelectedRow(), 1);
				String color = (String) model.getValueAt(tablaBicicletas.getSelectedRow(), 2);
				String descripcion = (String) model.getValueAt(tablaBicicletas.getSelectedRow(), 3);
//					Integer eanInt = (Integer) model.getValueAt(tablaBicicletas.getSelectedRow(), 4);
//					String ean=Integer.toString(eanInt);		
				String eanStr = (String) model.getValueAt(tablaBicicletas.getSelectedRow(), 4);
				Integer eanInt;
				try {
					eanInt = Integer.parseInt(eanStr);
				} catch (NumberFormatException ex) {
					// El valor en la tabla no es un número válido
					// Asigna un valor predeterminado o muestra un mensaje de error según sea
					// necesario
					eanInt = 0; // Por ejemplo, asignamos 0 como valor predeterminado
				}

//					Float precio=(Float) model.getValueAt(tablaBicicletas.getSelectedRow(), 5);
				String precioStr = (String) model.getValueAt(tablaBicicletas.getSelectedRow(), 5);
				Float precioFloat;
				try {
					precioFloat = Float.parseFloat(precioStr);
				} catch (NumberFormatException ex) {
					// El valor en la tabla no es un número válido
					// Asigna un valor predeterminado o muestra un mensaje de error según sea
					// necesario
					precioFloat = 0.0f; // Por ejemplo, asignamos 0.0 como valor predeterminado
				}
				String modalidad = (String) model.getValueAt(tablaBicicletas.getSelectedRow(), 6);
				String tallaBicicleta = (String) model.getValueAt(tablaBicicletas.getSelectedRow(), 7);
				String nombreProveedor = (String) model.getValueAt(tablaBicicletas.getSelectedRow(), 8);

				// Crear los HashMap de datos a modificar y restricciones
				HashMap<String, Object> datosAModificar = new HashMap<>();
				datosAModificar.put("marca", marca);
				datosAModificar.put("modelo", modelo);
				datosAModificar.put("color", color);
				datosAModificar.put("descripcion", descripcion);
				datosAModificar.put("ean", eanInt);
				datosAModificar.put("precio", precioFloat);
				datosAModificar.put("modalidad", modalidad);
				datosAModificar.put("talla_bicicleta", tallaBicicleta);
				datosAModificar.put("nombre_proveedor", nombreProveedor);

				// Agrega las restricciones necesarias para identificar el registro a modificar
				HashMap<String, Object> restricciones = new HashMap<>();
				restricciones.put("ean", eanInt);

				
					try {
						DAO.actualizar("bicicleta", datosAModificar, restricciones);
						DAO.actualizar("productos", datosAModificar, restricciones);
					String mensaje = "La bicicleta se ha actualizado con éxito:\n" + "Marca: " + marca + "\n"
							+ "Modelo: " + modelo + "\n" + "Color: " + color + "\n" + "EAN: " + eanInt + "\n"
							+ "Descripción: " + descripcion + "\n" + "Precio: " + precioFloat + "\n" + "Modalidad: "
							+ modalidad + "\n" + "Talla: " + tallaBicicleta + "\n" + "\n" + "Proveedor: "
							+ nombreProveedor + "\n";
					JOptionPane.showMessageDialog(ventana, mensaje, "Bicicleta modificada correctamente",
							JOptionPane.INFORMATION_MESSAGE);
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
				

			}
		});

		botonAceptar.setForeground(new Color(78, 1, 23));
		botonAceptar.setFont(new Font("Eras Medium ITC", Font.PLAIN, 25));
		botonAceptar.setBackground(new Color(245, 196, 74));
		add(botonAceptar);

	}
}
