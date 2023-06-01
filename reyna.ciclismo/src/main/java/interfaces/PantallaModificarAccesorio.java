package interfaces;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import clases.Accesorio;
import clases.Alimentacion;
import excepciones.ProveedorNoExisteException;
import utils.DAO;

public class PantallaModificarAccesorio extends JPanel {
	Ventana ventana;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private final JTable tablaAlimentacion;
	private final DefaultTableModel model;

	public PantallaModificarAccesorio(Ventana v) {
		this.ventana = v;
		this.tablaAlimentacion = new JTable();
		this.model = new DefaultTableModel();
		setSize(800, 700);
		setBackground(new Color(78, 1, 23));
		setLayout(null);

		JLabel etiquetaModificarBicicleta = new JLabel("MODIFICAR ACCESORIOS");
		etiquetaModificarBicicleta.setHorizontalAlignment(SwingConstants.CENTER);
		etiquetaModificarBicicleta.setForeground(new Color(245, 196, 74));
		etiquetaModificarBicicleta.setFont(new Font("Eras Medium ITC", Font.BOLD, 50));
		etiquetaModificarBicicleta.setBackground(new Color(245, 196, 74));
		etiquetaModificarBicicleta.setBounds(75, 51, 650, 58);
		add(etiquetaModificarBicicleta);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(100, 259, 600, 250);
		add(scrollPane);

		ArrayList<Accesorio> todosLosAccesorios = null;

		try {
			todosLosAccesorios = Accesorio.getTodos();
		} catch (SQLException | ProveedorNoExisteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// Crear el modelo de tabla y agregar las columnas correspondientes a los datos
		final DefaultTableModel model = new DefaultTableModel();
		model.addColumn("Marca");
		model.addColumn("Modelo");
		model.addColumn("EAN");
		model.addColumn("Color");
		model.addColumn("Descripcion");
		model.addColumn("Precio");
		model.addColumn("Talla");
		model.addColumn("Proveedor");

		// Agregar las filas con los datos de la alimentacion
		for (Accesorio accesorio : todosLosAccesorios) {
			model.addRow(new Object[] { accesorio.getMarca(), accesorio.getModelo(), String.valueOf(accesorio.getEan()),
					accesorio.getColor(), accesorio.getDescripcion(), String.valueOf(accesorio.getPrecio()),
					accesorio.getTalla(), accesorio.getProveedor().getNombre() });
		}

		// Crear la tabla con el modelo de datos
		final JTable tablaAccesorios = new JTable(model);

		// Establecer la tabla como contenido visible del JScrollPane
		scrollPane.setViewportView(tablaAccesorios);

		JButton botonAceptar = new JButton("Aceptar");
		botonAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (tablaAccesorios.getCellEditor() != null) {
					tablaAccesorios.getCellEditor().stopCellEditing();
				}

				// Obtener los datos seleccionados en la tabla
				String marca = (String) model.getValueAt(tablaAccesorios.getSelectedRow(), 0);
				String modelo = (String) model.getValueAt(tablaAccesorios.getSelectedRow(), 1);
				String color = (String) model.getValueAt(tablaAccesorios.getSelectedRow(), 3);
				String eanStr = (String) model.getValueAt(tablaAccesorios.getSelectedRow(), 2);
				Integer eanInt;
				try {
					eanInt = Integer.parseInt(eanStr);
				} catch (NumberFormatException ex) {
					// El valor en la tabla no es un número válido
					// Asigna un valor predeterminado o muestra un mensaje de error según sea
					// necesario
					eanInt = 0; // Por ejemplo, asignamos 0 como valor predeterminado
				}
				String descripcion = (String) model.getValueAt(tablaAccesorios.getSelectedRow(), 4);
				String precioStr = (String) model.getValueAt(tablaAccesorios.getSelectedRow(), 5);
				Float precioFloat;
				try {
					precioFloat = Float.parseFloat(precioStr);
				} catch (NumberFormatException ex) {
					// El valor en la tabla no es un número válido
					// Asigna un valor predeterminado o muestra un mensaje de error según sea
					// necesario
					precioFloat = 0.0f; // Por ejemplo, asignamos 0.0 como valor predeterminado
				}
				String tallaAccesorio = (String) model.getValueAt(tablaAccesorios.getSelectedRow(), 6);
				String nombreProveedor = (String) model.getValueAt(tablaAccesorios.getSelectedRow(), 7);

				// Crear los HashMap de datos a modificar y restricciones
				HashMap<String, Object> datosAModificar = new HashMap<>();
				datosAModificar.put("marca", marca);
				datosAModificar.put("modelo", modelo);
				datosAModificar.put("color", color);
				datosAModificar.put("ean", eanInt);
				datosAModificar.put("descripcion", descripcion);
				datosAModificar.put("precio", precioFloat);
				if(tallaAccesorio.equals("")) {
					datosAModificar.put("talla_accesorio", "Sin talla");
				}else {
					datosAModificar.put("talla_accesorio", tallaAccesorio);
				}
				
				datosAModificar.put("nombre_proveedor", nombreProveedor);

				HashMap<String, Object> restricciones = new HashMap<>();
				// Agrega las restricciones necesarias para identificar el registro a modificar
				restricciones.put("ean", eanInt);

				try {
					DAO.actualizar("accesorio", datosAModificar, restricciones);
					DAO.actualizar("productos", datosAModificar, restricciones);
					String mensaje = "El producto se ha actualizado con éxito:\n" + "Marca: " + marca + "\n"
							+ "Modelo: " + modelo + "\n" + "Color: " + color + "\n" + "EAN: " + eanInt + "\n"
							+ "Descripción: " + descripcion + "\n" + "Precio: " + precioFloat + "\n" + "Talla: "
							+ tallaAccesorio + "\n" + "Proveedor: " + nombreProveedor + "\n";
					JOptionPane.showMessageDialog(ventana, mensaje, "Producto modificado correctamente",
							JOptionPane.INFORMATION_MESSAGE);
				} catch (SQLIntegrityConstraintViolationException e1) {
					JOptionPane.showMessageDialog(ventana, "Este EAN ya figura en la base de datos", "¡Ups, algo salió mal!",
							JOptionPane.ERROR_MESSAGE);

				} catch (SQLException e2) {
					JOptionPane.showMessageDialog(ventana, e2.getMessage(), "No se puede conectar a la base de datos",
							JOptionPane.ERROR_MESSAGE);
					e2.printStackTrace();

				} catch (NumberFormatException e3) {
					JOptionPane.showMessageDialog(ventana, "Tienes que poner un número que sea número", "Error",
							JOptionPane.ERROR_MESSAGE);
				}

			}
		});

		botonAceptar.setForeground(new Color(78, 1, 23));
		botonAceptar.setFont(new Font("Eras Medium ITC", Font.PLAIN, 25));
		botonAceptar.setBackground(new Color(245, 196, 74));
		botonAceptar.setBounds(552, 571, 145, 32);
		add(botonAceptar);

		JButton botonAtras = new JButton("Cancelar");
		botonAtras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ventana.cambiarAPantalla(PantallaAdministracion.class);
			}
		});
		botonAtras.setForeground(new Color(78, 1, 23));
		botonAtras.setFont(new Font("Eras Medium ITC", Font.PLAIN, 25));
		botonAtras.setBackground(new Color(245, 196, 74));
		botonAtras.setBounds(100, 571, 145, 32);
		add(botonAtras);

		JLabel lblEligeQueProveedor = new JLabel("Elige que producto quieres modificar");
		lblEligeQueProveedor.setHorizontalAlignment(SwingConstants.CENTER);
		lblEligeQueProveedor.setForeground(new Color(245, 196, 74));
		lblEligeQueProveedor.setFont(new Font("Eras Medium ITC", Font.BOLD, 25));
		lblEligeQueProveedor.setBackground(new Color(245, 196, 74));
		lblEligeQueProveedor.setBounds(100, 120, 600, 32);
		add(lblEligeQueProveedor);

		JLabel lblYPulsaAceptar = new JLabel("y pulsa aceptar para confirmar.");
		lblYPulsaAceptar.setHorizontalAlignment(SwingConstants.CENTER);
		lblYPulsaAceptar.setForeground(new Color(245, 196, 74));
		lblYPulsaAceptar.setFont(new Font("Eras Medium ITC", Font.BOLD, 25));
		lblYPulsaAceptar.setBackground(new Color(245, 196, 74));
		lblYPulsaAceptar.setBounds(100, 206, 600, 32);
		add(lblYPulsaAceptar);

		JLabel lblModificaElO = new JLabel("modifica el campo, o los campos, que quieras");
		lblModificaElO.setHorizontalAlignment(SwingConstants.CENTER);
		lblModificaElO.setForeground(new Color(245, 196, 74));
		lblModificaElO.setFont(new Font("Eras Medium ITC", Font.BOLD, 25));
		lblModificaElO.setBackground(new Color(245, 196, 74));
		lblModificaElO.setBounds(100, 163, 600, 32);
		add(lblModificaElO);
		
		JLabel labelUsuario = new JLabel("Estas conectado como "+ventana.usuarioLogueado.getNombre());
		labelUsuario.setHorizontalAlignment(SwingConstants.LEFT);
		labelUsuario.setForeground(new Color(245, 196, 74));
		labelUsuario.setBackground(new Color(245, 196, 74));
		labelUsuario.setBounds(50, 24, 230, 14);
		add(labelUsuario);
		
		BotonLogOut botonLogOut = new BotonLogOut();
		botonLogOut.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ventana.cambiarAPantalla(PantallaLogin.class);
			}
		});
		botonLogOut.setBounds(658, 20, 80, 23);
		add(botonLogOut);
	}
}
