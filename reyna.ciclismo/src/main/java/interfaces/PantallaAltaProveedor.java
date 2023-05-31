package interfaces;

import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.SwingConstants;

import clases.Proveedor;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Font;
import javax.swing.SwingConstants;

import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;

public class PantallaAltaProveedor extends JPanel {
	private Ventana ventana;
	private JTextField campoEmail;
	private JTextField campoCif;
	private JTextField campoTelefono;
	private JTextField campoDireccion;
	private JTextField textField;
	private JTextField campoNombre;

	public PantallaAltaProveedor(Ventana v) {
		this.ventana = v;
		setSize(800, 700);
		setBackground(new Color(78, 1, 23));
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 70, 0, 0, 0, 0, 70, 0 };
		gridBagLayout.rowHeights = new int[] { 51, 58, 42, 44, 44, 44, 44, 44, 30, 0, 0, 0, 34, 32, 30, 0 };
		gridBagLayout.columnWeights = new double[] { 0.0, 1.0, 1.0, 1.0, 1.0, 0.0, Double.MIN_VALUE };
		gridBagLayout.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0,
				0.0, Double.MIN_VALUE };
		setLayout(gridBagLayout);

		JLabel labelUsuario = new JLabel("Estas conectado como " + ventana.usuarioLogueado.getNombre());
		labelUsuario.setForeground(new Color(245, 196, 74));
		GridBagConstraints gbc_labelUsuario = new GridBagConstraints();
		gbc_labelUsuario.anchor = GridBagConstraints.WEST;
		gbc_labelUsuario.gridwidth = 2;
		gbc_labelUsuario.insets = new Insets(0, 0, 5, 5);
		gbc_labelUsuario.gridx = 1;
		gbc_labelUsuario.gridy = 0;
		add(labelUsuario, gbc_labelUsuario);

		JLabel etiquetaAltaProveedor = new JLabel("ALTA DE PROVEEDOR");
		etiquetaAltaProveedor.setHorizontalAlignment(SwingConstants.CENTER);
		etiquetaAltaProveedor.setForeground(new Color(245, 196, 74));
		etiquetaAltaProveedor.setFont(new Font("Eras Medium ITC", Font.BOLD, 50));
		etiquetaAltaProveedor.setBackground(new Color(245, 196, 74));
		GridBagConstraints gbc_etiquetaAltaProveedor = new GridBagConstraints();
		gbc_etiquetaAltaProveedor.anchor = GridBagConstraints.NORTH;
		gbc_etiquetaAltaProveedor.fill = GridBagConstraints.HORIZONTAL;
		gbc_etiquetaAltaProveedor.insets = new Insets(0, 0, 5, 5);
		gbc_etiquetaAltaProveedor.gridwidth = 4;
		gbc_etiquetaAltaProveedor.gridx = 1;
		gbc_etiquetaAltaProveedor.gridy = 1;
		add(etiquetaAltaProveedor, gbc_etiquetaAltaProveedor);

		JLabel etiquetaNombre = new JLabel("Nombre");
		etiquetaNombre.setForeground(new Color(245, 196, 74));
		etiquetaNombre.setFont(new Font("Eras Medium ITC", Font.BOLD, 25));
		etiquetaNombre.setBackground(new Color(245, 196, 74));
		GridBagConstraints gbc_etiquetaNombre = new GridBagConstraints();
		gbc_etiquetaNombre.anchor = GridBagConstraints.WEST;
		gbc_etiquetaNombre.fill = GridBagConstraints.VERTICAL;
		gbc_etiquetaNombre.insets = new Insets(0, 0, 5, 5);
		gbc_etiquetaNombre.gridx = 1;
		gbc_etiquetaNombre.gridy = 3;
		add(etiquetaNombre, gbc_etiquetaNombre);

		campoNombre = new JTextField();
		campoNombre.setFont(new Font("Arial Black", Font.PLAIN, 25));
		campoNombre.setColumns(10);
		GridBagConstraints gbc_campoNombre = new GridBagConstraints();
		gbc_campoNombre.gridwidth = 3;
		gbc_campoNombre.fill = GridBagConstraints.HORIZONTAL;
		gbc_campoNombre.anchor = GridBagConstraints.SOUTH;
		gbc_campoNombre.insets = new Insets(0, 0, 5, 5);
		gbc_campoNombre.gridx = 2;
		gbc_campoNombre.gridy = 3;
		add(campoNombre, gbc_campoNombre);

		JLabel etiquetaDireccion = new JLabel("Dirección");
		etiquetaDireccion.setForeground(new Color(245, 196, 74));
		etiquetaDireccion.setFont(new Font("Eras Medium ITC", Font.BOLD, 25));
		etiquetaDireccion.setBackground(new Color(245, 196, 74));
		GridBagConstraints gbc_etiquetaDireccion = new GridBagConstraints();
		gbc_etiquetaDireccion.anchor = GridBagConstraints.WEST;
		gbc_etiquetaDireccion.fill = GridBagConstraints.VERTICAL;
		gbc_etiquetaDireccion.insets = new Insets(0, 0, 5, 5);
		gbc_etiquetaDireccion.gridx = 1;
		gbc_etiquetaDireccion.gridy = 4;
		add(etiquetaDireccion, gbc_etiquetaDireccion);

		campoDireccion = new JTextField();
		campoDireccion.setFont(new Font("Arial Black", Font.PLAIN, 25));
		campoDireccion.setColumns(10);
		GridBagConstraints gbc_campoDireccion = new GridBagConstraints();
		gbc_campoDireccion.fill = GridBagConstraints.HORIZONTAL;
		gbc_campoDireccion.gridwidth = 3;
		gbc_campoDireccion.anchor = GridBagConstraints.SOUTH;
		gbc_campoDireccion.insets = new Insets(0, 0, 5, 5);
		gbc_campoDireccion.gridx = 2;
		gbc_campoDireccion.gridy = 4;
		add(campoDireccion, gbc_campoDireccion);

		JLabel etiquetaTelefono = new JLabel("Teléfono");
		etiquetaTelefono.setForeground(new Color(245, 196, 74));
		etiquetaTelefono.setFont(new Font("Eras Medium ITC", Font.BOLD, 25));
		etiquetaTelefono.setBackground(new Color(245, 196, 74));
		GridBagConstraints gbc_etiquetaTelefono = new GridBagConstraints();
		gbc_etiquetaTelefono.anchor = GridBagConstraints.WEST;
		gbc_etiquetaTelefono.fill = GridBagConstraints.VERTICAL;
		gbc_etiquetaTelefono.insets = new Insets(0, 0, 5, 5);
		gbc_etiquetaTelefono.gridx = 1;
		gbc_etiquetaTelefono.gridy = 5;
		add(etiquetaTelefono, gbc_etiquetaTelefono);

		campoTelefono = new JTextField();
		campoTelefono.setFont(new Font("Arial Black", Font.PLAIN, 25));
		campoTelefono.setColumns(10);
		GridBagConstraints gbc_campoTelefono = new GridBagConstraints();
		gbc_campoTelefono.fill = GridBagConstraints.HORIZONTAL;
		gbc_campoTelefono.gridwidth = 3;
		gbc_campoTelefono.anchor = GridBagConstraints.SOUTH;
		gbc_campoTelefono.insets = new Insets(0, 0, 5, 5);
		gbc_campoTelefono.gridx = 2;
		gbc_campoTelefono.gridy = 5;
		add(campoTelefono, gbc_campoTelefono);

		JLabel etiquetaCif = new JLabel("CIF");
		etiquetaCif.setForeground(new Color(245, 196, 74));
		etiquetaCif.setFont(new Font("Eras Medium ITC", Font.BOLD, 25));
		etiquetaCif.setBackground(new Color(245, 196, 74));
		GridBagConstraints gbc_etiquetaCif = new GridBagConstraints();
		gbc_etiquetaCif.fill = GridBagConstraints.BOTH;
		gbc_etiquetaCif.insets = new Insets(0, 0, 5, 5);
		gbc_etiquetaCif.gridx = 1;
		gbc_etiquetaCif.gridy = 6;
		add(etiquetaCif, gbc_etiquetaCif);

		campoCif = new JTextField();
		campoCif.setHorizontalAlignment(SwingConstants.LEFT);
		campoCif.setFont(new Font("Arial Black", Font.PLAIN, 25));
		campoCif.setColumns(10);
		GridBagConstraints gbc_campoCif = new GridBagConstraints();
		gbc_campoCif.fill = GridBagConstraints.HORIZONTAL;
		gbc_campoCif.gridwidth = 3;
		gbc_campoCif.anchor = GridBagConstraints.SOUTH;
		gbc_campoCif.insets = new Insets(0, 0, 5, 5);
		gbc_campoCif.gridx = 2;
		gbc_campoCif.gridy = 6;
		add(campoCif, gbc_campoCif);

		JLabel etiquetaEmail = new JLabel("Email");
		etiquetaEmail.setForeground(new Color(245, 196, 74));
		etiquetaEmail.setFont(new Font("Eras Medium ITC", Font.BOLD, 25));
		etiquetaEmail.setBackground(new Color(245, 196, 74));
		GridBagConstraints gbc_etiquetaEmail = new GridBagConstraints();
		gbc_etiquetaEmail.fill = GridBagConstraints.BOTH;
		gbc_etiquetaEmail.insets = new Insets(0, 0, 5, 5);
		gbc_etiquetaEmail.gridx = 1;
		gbc_etiquetaEmail.gridy = 7;
		add(etiquetaEmail, gbc_etiquetaEmail);

		campoEmail = new JTextField();
		campoEmail.setFont(new Font("Arial Black", Font.PLAIN, 25));
		campoEmail.setColumns(10);
		GridBagConstraints gbc_campoEmail = new GridBagConstraints();
		gbc_campoEmail.gridwidth = 3;
		gbc_campoEmail.fill = GridBagConstraints.HORIZONTAL;
		gbc_campoEmail.anchor = GridBagConstraints.SOUTH;
		gbc_campoEmail.insets = new Insets(0, 0, 5, 5);
		gbc_campoEmail.gridx = 2;
		gbc_campoEmail.gridy = 7;
		add(campoEmail, gbc_campoEmail);

		JButton botonRegistro = new JButton("Dar Alta");
		botonRegistro.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String direccion = campoDireccion.getText();
				String email = campoEmail.getText();
				String nombre = campoNombre.getText().toString();

				try {
					String cif = campoCif.getText();
					int telefono = Integer.parseInt(campoTelefono.getText());
					new Proveedor(nombre, direccion, cif, email, telefono);
					JOptionPane.showMessageDialog(ventana, "Proveedor dado de alta correctamente", "¡Lo conseguiste!",
							JOptionPane.INFORMATION_MESSAGE);
					ventana.cambiarAPantalla(PantallaAdministracion.class);

				} catch (SQLIntegrityConstraintViolationException e1) {
					JOptionPane.showMessageDialog(ventana, "El proveedor ya está dado de alta", "¡Ups, algo salió mal!",
							JOptionPane.ERROR_MESSAGE);

				} catch (SQLException e1) {
					JOptionPane.showMessageDialog(ventana, e1.getMessage(), "No se puede conectar a la base de datos",
							JOptionPane.ERROR_MESSAGE);
					e1.printStackTrace();

				} catch (NumberFormatException e3) {
					JOptionPane.showMessageDialog(ventana, "Tienes que poner un número de telefono que sea número",
							"Error en el campo teléfono", JOptionPane.ERROR_MESSAGE);
				}

			}
		});
		botonRegistro.setForeground(new Color(78, 1, 23));
		botonRegistro.setFont(new Font("Eras Medium ITC", Font.PLAIN, 30));
		botonRegistro.setBackground(new Color(245, 196, 74));
		GridBagConstraints gbc_botonRegistro = new GridBagConstraints();
		gbc_botonRegistro.fill = GridBagConstraints.HORIZONTAL;
		gbc_botonRegistro.gridwidth = 2;
		gbc_botonRegistro.insets = new Insets(0, 0, 5, 5);
		gbc_botonRegistro.gridx = 2;
		gbc_botonRegistro.gridy = 9;
		add(botonRegistro, gbc_botonRegistro);

		JButton botonLimpiar = new JButton("Limpiar Datos");
		botonLimpiar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				campoNombre.setText("");
				campoDireccion.setText("");
				campoCif.setText("");
				campoEmail.setText("");
				campoTelefono.setText("");

			}
		});

		JButton botonCancelar = new JButton("Cancelar");
		botonCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ventana.cambiarAPantalla(PantallaAdministracion.class);
			}
		});
		botonCancelar.setForeground(new Color(78, 1, 23));
		botonCancelar.setFont(new Font("Eras Medium ITC", Font.PLAIN, 25));
		botonCancelar.setBackground(new Color(245, 196, 74));
		GridBagConstraints gbc_botonCancelar = new GridBagConstraints();
		gbc_botonCancelar.insets = new Insets(0, 0, 5, 5);
		gbc_botonCancelar.fill = GridBagConstraints.HORIZONTAL;
		gbc_botonCancelar.gridx = 1;
		gbc_botonCancelar.gridy = 13;
		add(botonCancelar, gbc_botonCancelar);

		botonLimpiar.setForeground(new Color(78, 1, 23));
		botonLimpiar.setFont(new Font("Eras Medium ITC", Font.PLAIN, 25));
		botonLimpiar.setBackground(new Color(245, 196, 74));
		GridBagConstraints gbc_botonLimpiar = new GridBagConstraints();
		gbc_botonLimpiar.fill = GridBagConstraints.HORIZONTAL;
		gbc_botonLimpiar.insets = new Insets(0, 0, 5, 5);
		gbc_botonLimpiar.gridx = 4;
		gbc_botonLimpiar.gridy = 13;
		add(botonLimpiar, gbc_botonLimpiar);
	}
}
