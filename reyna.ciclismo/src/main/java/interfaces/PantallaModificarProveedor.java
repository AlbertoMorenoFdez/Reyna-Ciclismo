package interfaces;

import java.awt.Color;


import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import clases.Proveedor;
import clases.Usuario;
import excepciones.NombreConNumeroException;
import excepciones.ProveedorNoExisteException;
import utils.DAO;

import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;
import java.util.HashMap;
import java.awt.event.ActionEvent;

public class PantallaModificarProveedor extends JPanel {
	private Ventana ventana;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private final JTable tablaProveedores;
	private final DefaultTableModel model;

	private void actionPerformed(ActionEvent e) {
		// Obtenemos el primer dato del renglon seleccionado
		if (tablaProveedores.getSelectedRow() != -1) {
			String codigo = (String) model.getValueAt(tablaProveedores.getSelectedRow(), 0);

			// Lo imprimimos en pantalla
			System.out.println(codigo);
		} else {
			System.out.println("Seleccione un renglon primero");
		}
	}

	public PantallaModificarProveedor(Ventana v) {
		this.ventana = v;
		this.tablaProveedores = new JTable();
		this.model = new DefaultTableModel();
		setSize(800, 700);
		setBackground(new Color(78, 1, 23));
		setLayout(null);

		JLabel etiquetaModificarProveedor = new JLabel("MODIFICAR PROVEEDOR");
		etiquetaModificarProveedor.setHorizontalAlignment(SwingConstants.CENTER);
		etiquetaModificarProveedor.setForeground(new Color(245, 196, 74));
		etiquetaModificarProveedor.setFont(new Font("Eras Medium ITC", Font.BOLD, 50));
		etiquetaModificarProveedor.setBackground(new Color(245, 196, 74));
		etiquetaModificarProveedor.setBounds(100, 51, 600, 58);
		add(etiquetaModificarProveedor);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(100, 252, 600, 250);
		add(scrollPane);

		ArrayList<Proveedor> todosLosProveedores = null;

		try {
			todosLosProveedores = Proveedor.getTodos();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		// Crear el modelo de tabla y agregar las columnas correspondientes a los datos
		final DefaultTableModel model = new DefaultTableModel();
		model.addColumn("CIF");
		model.addColumn("Nombre");
		model.addColumn("Direccion");
		model.addColumn("Telefono");
		model.addColumn("Correo electronico");
		// Agregar las filas con los datos de los proveedores
		for (Proveedor proveedor : todosLosProveedores) {
			model.addRow(new Object[] { proveedor.getCIF(), proveedor.getNombre(), proveedor.getDireccion(),
					String.valueOf(proveedor.getTelefonoProveedor()), proveedor.getEmailProveedor() });
			System.out.println(proveedor);
		}

		// Crear la tabla con el modelo de datos
		final JTable tablaProveedores = new JTable(model);

		// Establecer la tabla como contenido visible del JScrollPane
		scrollPane.setViewportView(tablaProveedores);

		JButton botonAceptar = new JButton("Aceptar");
		botonAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Proveedor proveedor = new Proveedor();
				if (tablaProveedores.getCellEditor() != null) {
					tablaProveedores.getCellEditor().stopCellEditing();
					// Obtener los datos seleccionados en la tabla
					String nombre = (String) model.getValueAt(tablaProveedores.getSelectedRow(), 1);
					String direccion = (String) model.getValueAt(tablaProveedores.getSelectedRow(), 2);
					String telefonoStr = (String) model.getValueAt(tablaProveedores.getSelectedRow(), 3);
					Integer telefonoInt;
					try {
						telefonoInt = Integer.parseInt(telefonoStr);
					} catch (NumberFormatException ex) {
						// El valor en la tabla no es un número válido
						// Asigna un valor predeterminado o muestra un mensaje de error según sea
						// necesario
						telefonoInt = 0; // Por ejemplo, asignamos 0 como valor predeterminado
					}
					String cif = (String) model.getValueAt(tablaProveedores.getSelectedRow(), 0);
					String email = (String) model.getValueAt(tablaProveedores.getSelectedRow(), 4);
					
					// Crear los HashMap de datos a modificar y restricciones
					HashMap<String, Object> datosAModificar = new HashMap<>();
					datosAModificar.put("correo_electronico", email);
					datosAModificar.put("nombre", nombre);
					datosAModificar.put("numero_telefono", telefonoInt);
					datosAModificar.put("CIF", cif);
					datosAModificar.put("direccion", direccion);

					// Agrega las restricciones necesarias para identificar el registro a modificar
					HashMap<String, Object> restricciones = new HashMap<>();
					restricciones.put("nombre", nombre);

					try {
						DAO.actualizar("proveedores", datosAModificar, restricciones);
						String mensaje = "El proveedor se ha actualizado con éxito:\n" + "Nombre: " + nombre + "\n"
								+ "Email: " + email + "\n" + "Direccion: " + direccion + "\n" + "Telefono: "
								+ telefonoInt + "\n" + "CIF: " + cif;
						JOptionPane.showMessageDialog(ventana, mensaje, "Proveedor modificado correctamente",
								JOptionPane.INFORMATION_MESSAGE);
					} catch (SQLIntegrityConstraintViolationException e3) {
						JOptionPane.showMessageDialog(ventana, "El nombre ya está en uso", "No se pudo actualizar",
								JOptionPane.ERROR_MESSAGE);

					} catch (SQLException e4) {
						JOptionPane.showMessageDialog(ventana, e4.getMessage(),
								"No se puede conectar a la base de datos", JOptionPane.ERROR_MESSAGE);
						e4.printStackTrace();

					} catch (NumberFormatException e2) {
						JOptionPane.showMessageDialog(ventana, "Tienes que poner un número de telefono que sea número",
								"Error en el campo teléfono", JOptionPane.ERROR_MESSAGE);

					}

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

		JLabel lblEligeQueProveedor = new JLabel("Elige que proveedor quieres modificar");
		lblEligeQueProveedor.setHorizontalAlignment(SwingConstants.CENTER);
		lblEligeQueProveedor.setForeground(new Color(245, 196, 74));
		lblEligeQueProveedor.setFont(new Font("Eras Medium ITC", Font.BOLD, 25));
		lblEligeQueProveedor.setBackground(new Color(245, 196, 74));
		lblEligeQueProveedor.setBounds(100, 113, 600, 32);
		add(lblEligeQueProveedor);

		JLabel lblYPulsaAceptar = new JLabel("y pulsa aceptar para confirmar.");
		lblYPulsaAceptar.setHorizontalAlignment(SwingConstants.CENTER);
		lblYPulsaAceptar.setForeground(new Color(245, 196, 74));
		lblYPulsaAceptar.setFont(new Font("Eras Medium ITC", Font.BOLD, 25));
		lblYPulsaAceptar.setBackground(new Color(245, 196, 74));
		lblYPulsaAceptar.setBounds(100, 184, 600, 32);
		add(lblYPulsaAceptar);

		JLabel lblrealizaCambios = new JLabel("realiza los cambios que quieras");
		lblrealizaCambios.setHorizontalAlignment(SwingConstants.CENTER);
		lblrealizaCambios.setForeground(new Color(245, 196, 74));
		lblrealizaCambios.setFont(new Font("Eras Medium ITC", Font.BOLD, 25));
		lblrealizaCambios.setBackground(new Color(245, 196, 74));
		lblrealizaCambios.setBounds(100, 149, 600, 32);
		add(lblrealizaCambios);

		JLabel labelUsuario = new JLabel("Estas conectado como " + ventana.usuarioLogueado.getNombre());
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
		botonLogOut.setBounds(659, 20, 80, 23);
		add(botonLogOut);
	}
}
