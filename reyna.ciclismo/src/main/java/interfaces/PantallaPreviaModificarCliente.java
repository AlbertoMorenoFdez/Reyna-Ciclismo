package interfaces;

import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import clases.Usuario;
import excepciones.NombreConNumeroException;
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
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;
import java.util.HashMap;
import java.awt.event.ActionEvent;

public class PantallaPreviaModificarCliente extends JPanel {
	private Ventana ventana;
	private final ButtonGroup buttonGroup = new ButtonGroup();

	public PantallaPreviaModificarCliente(Ventana v) {
		this.ventana = v;
		setSize(800, 700);
		setBackground(new Color(78, 1, 23));
		setLayout(null);

		JLabel etiquetaModificarCliente = new JLabel("MODIFICAR CLIENTE");
		etiquetaModificarCliente.setHorizontalAlignment(SwingConstants.CENTER);
		etiquetaModificarCliente.setForeground(new Color(245, 196, 74));
		etiquetaModificarCliente.setFont(new Font("Eras Medium ITC", Font.BOLD, 50));
		etiquetaModificarCliente.setBackground(new Color(245, 196, 74));
		etiquetaModificarCliente.setBounds(100, 51, 600, 58);
		add(etiquetaModificarCliente);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(100, 258, 600, 250);
		add(scrollPane);

		ArrayList<Usuario> todosLosUsuarios = null;
		try {
			todosLosUsuarios = Usuario.getTodos();
		} catch (SQLException | NombreConNumeroException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		// Crear el modelo de tabla y agregar las columnas correspondientes a los datos
		final DefaultTableModel model = new DefaultTableModel();
		model.addColumn("Correo Electrónico");
		model.addColumn("Nombre");
		model.addColumn("Teléfono");
		model.addColumn("DNI");
		model.addColumn("Dirección");
		// Agregar las filas con los datos de los usuarios
		for (Usuario usuario : todosLosUsuarios) {
			model.addRow(new Object[] { usuario.getEmail(), usuario.getNombre(), String.valueOf(usuario.getTelefono()),
					usuario.getDNI(), usuario.getDireccion() });
		}

		// Crear la tabla con el modelo de datos
		final JTable tablaUsuarios = new JTable(model);

		// Establecer la tabla como contenido visible del JScrollPane
		scrollPane.setViewportView(tablaUsuarios);

		JButton botonAceptar = new JButton("Aceptar");
		botonAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (tablaUsuarios.getCellEditor() != null) {
					tablaUsuarios.getCellEditor().stopCellEditing();
					// Obtener los datos seleccionados en la tabla
					String email = (String) model.getValueAt(tablaUsuarios.getSelectedRow(), 0);
					String nombre = (String) model.getValueAt(tablaUsuarios.getSelectedRow(), 1);
					String telefonoStr = (String) model.getValueAt(tablaUsuarios.getSelectedRow(), 2);
					Integer telefonoInt;
					try {
						telefonoInt = Integer.parseInt(telefonoStr);
					} catch (NumberFormatException ex) {
						// El valor en la tabla no es un número válido
						// Asigna un valor predeterminado o muestra un mensaje de error según sea
						// necesario
						telefonoInt = 0; // Por ejemplo, asignamos 0 como valor predeterminado
					}
					String dni = (String) model.getValueAt(tablaUsuarios.getSelectedRow(), 3);
					String direccion = (String) model.getValueAt(tablaUsuarios.getSelectedRow(), 4);

					// Crear los HashMap de datos a modificar y restricciones
					HashMap<String, Object> datosAModificar = new HashMap<>();
					datosAModificar.put("correo_electronico", email);
					datosAModificar.put("nombre", nombre);
					datosAModificar.put("numero_telefono", telefonoInt);

					datosAModificar.put("DNI", dni);
					datosAModificar.put("direccion", direccion);

					// Agrega las restricciones necesarias para identificar el registro a modificar
					HashMap<String, Object> restricciones = new HashMap<>();
					restricciones.put("DNI", dni);

					try {
						DAO.actualizar("usuarios", datosAModificar, restricciones);
						String mensaje = "El cliente se ha actualizado con éxito:\n" + "Nombre: " + nombre + "\n"
								+ "Email: " + email + "\n" + "Direccion: " + direccion + "\n" + "Telefono: "
								+ telefonoInt + "\n" + "DNI: " + dni;
						JOptionPane.showMessageDialog(ventana, mensaje, "Cliente modificado correctamente",
								JOptionPane.INFORMATION_MESSAGE);
					} catch (SQLIntegrityConstraintViolationException e3) {
						JOptionPane.showMessageDialog(ventana, "El email ya está registrado", "No se pudo actualizar",
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

		JButton botonCancelar = new JButton("Cancelar");
		botonCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ventana.cambiarAPantalla(PantallaAdministracion.class);
			}
		});
		botonCancelar.setForeground(new Color(78, 1, 23));
		botonCancelar.setFont(new Font("Eras Medium ITC", Font.PLAIN, 25));
		botonCancelar.setBackground(new Color(245, 196, 74));
		botonCancelar.setBounds(100, 571, 145, 32);
		add(botonCancelar);

		JLabel lblEligeQueCliente = new JLabel("Elige qué cliente quieres modificar,");
		lblEligeQueCliente.setHorizontalAlignment(SwingConstants.CENTER);
		lblEligeQueCliente.setForeground(new Color(245, 196, 74));
		lblEligeQueCliente.setFont(new Font("Eras Medium ITC", Font.BOLD, 25));
		lblEligeQueCliente.setBackground(new Color(245, 196, 74));
		lblEligeQueCliente.setBounds(100, 112, 600, 32);
		add(lblEligeQueCliente);

		JLabel lblYPulsaAceptar = new JLabel("y pulsa aceptar para confirmar.");
		lblYPulsaAceptar.setHorizontalAlignment(SwingConstants.CENTER);
		lblYPulsaAceptar.setForeground(new Color(245, 196, 74));
		lblYPulsaAceptar.setFont(new Font("Eras Medium ITC", Font.BOLD, 25));
		lblYPulsaAceptar.setBackground(new Color(245, 196, 74));
		lblYPulsaAceptar.setBounds(100, 193, 600, 32);
		add(lblYPulsaAceptar);

		JLabel lblModificaCAmpos = new JLabel("modifica los campos");
		lblModificaCAmpos.setHorizontalAlignment(SwingConstants.CENTER);
		lblModificaCAmpos.setForeground(new Color(245, 196, 74));
		lblModificaCAmpos.setFont(new Font("Eras Medium ITC", Font.BOLD, 25));
		lblModificaCAmpos.setBackground(new Color(245, 196, 74));
		lblModificaCAmpos.setBounds(100, 155, 600, 32);
		add(lblModificaCAmpos);
	}

}
