package interfaces;

import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JList;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import clases.Usuario;
import excepciones.NombreConNumeroException;

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
import java.util.ArrayList;
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
		scrollPane.setBounds(100, 193, 600, 250);
		add(scrollPane);

		ArrayList<Usuario> todosLosUsuarios = null;
		try {
			todosLosUsuarios = Usuario.getTodos();
		} catch (SQLException | NombreConNumeroException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		// Crear el modelo de tabla y agregar las columnas correspondientes a los datos
		DefaultTableModel model = new DefaultTableModel();
		model.addColumn("Correo Electrónico");
		model.addColumn("Nombre");
		model.addColumn("Teléfono");
		model.addColumn("DNI");
		model.addColumn("Dirección");
		// Agregar las filas con los datos de los usuarios
		for (Usuario usuario : todosLosUsuarios) {
			model.addRow(new Object[] { usuario.getEmail(), usuario.getNombre(), usuario.getTelefono(),
					usuario.getDNI(), usuario.getDireccion() });
		}

		// Crear la tabla con el modelo de datos
		final JTable tablaUsuarios = new JTable(model);

		// Establecer la tabla como contenido visible del JScrollPane
		scrollPane.setViewportView(tablaUsuarios);
		
		tablaUsuarios.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
		    @Override
		    public void valueChanged(ListSelectionEvent e) {
		        if (!e.getValueIsAdjusting()) {
		            int selectedRow = tablaUsuarios.getSelectedRow();
		            if (selectedRow != -1) {
		                String email = tablaUsuarios.getValueAt(selectedRow, 0).toString();
		                String nombre = tablaUsuarios.getValueAt(selectedRow, 1).toString();
		                String telefono = tablaUsuarios.getValueAt(selectedRow, 2).toString();
		                String dni = tablaUsuarios.getValueAt(selectedRow, 3).toString();
		                String direccion = tablaUsuarios.getValueAt(selectedRow, 4).toString();

		                PantallaModificarCliente pantallaModificarCliente = new PantallaModificarCliente(ventana);
		                pantallaModificarCliente.setDatosCliente(email, nombre, telefono, dni, direccion);
		                //ventana.cambiarAPantalla(pantallaModificarCliente);
		            }
		        }
		    }
		});

		JButton botonAceptar = new JButton("Aceptar");
		botonAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ventana.cambiarAPantalla(PantallaModificarCliente.class);
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

		JLabel lblEligeQueCliente = new JLabel("Elige qué cliente quieres modificar");
		lblEligeQueCliente.setHorizontalAlignment(SwingConstants.CENTER);
		lblEligeQueCliente.setForeground(new Color(245, 196, 74));
		lblEligeQueCliente.setFont(new Font("Eras Medium ITC", Font.BOLD, 25));
		lblEligeQueCliente.setBackground(new Color(245, 196, 74));
		lblEligeQueCliente.setBounds(100, 150, 600, 32);
		add(lblEligeQueCliente);

		JLabel lblYPulsaAceptar = new JLabel("y pulsa aceptar para continuar.");
		lblYPulsaAceptar.setHorizontalAlignment(SwingConstants.CENTER);
		lblYPulsaAceptar.setForeground(new Color(245, 196, 74));
		lblYPulsaAceptar.setFont(new Font("Eras Medium ITC", Font.BOLD, 25));
		lblYPulsaAceptar.setBackground(new Color(245, 196, 74));
		lblYPulsaAceptar.setBounds(100, 450, 600, 32);
		add(lblYPulsaAceptar);
	}

}
