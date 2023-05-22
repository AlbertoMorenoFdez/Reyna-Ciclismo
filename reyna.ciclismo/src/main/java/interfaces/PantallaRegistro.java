package interfaces;

import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;

import clases.Usuario;
import excepciones.NombreConNumeroException;

import javax.swing.JButton;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;

import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PantallaRegistro extends JPanel {
	private Ventana ventana;
	private JTextField campoEmail;
	private JTextField campoDNI;
	private JTextField campoTelefono;
	private JTextField campoDireccion;
	private JTextField campoNombre;
	private JPasswordField campoContraseña;
	private JTextField textField;

	public PantallaRegistro(Ventana v) {
		this.ventana = v;
		setSize(800, 700);
		setBackground(new Color(78, 1, 23));
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 70, 0, 0, 0, 70, 0 };
		gridBagLayout.rowHeights = new int[] { 30, 58, 42, 44, 44, 44, 44, 44, 44, 30, 50, 0, 0, 0, 0, 0 };
		gridBagLayout.columnWeights = new double[] { 0.0, 1.0, 1.0, 1.0, 0.0, Double.MIN_VALUE };
		gridBagLayout.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0,
				0.0, Double.MIN_VALUE };
		setLayout(gridBagLayout);

		JLabel etiquetaRegistro = new JLabel("REGISTRO");
		etiquetaRegistro.setForeground(new Color(245, 196, 74));
		etiquetaRegistro.setFont(new Font("Eras Medium ITC", Font.BOLD, 50));
		etiquetaRegistro.setBackground(new Color(245, 196, 74));
		GridBagConstraints gbc_etiquetaRegistro = new GridBagConstraints();
		gbc_etiquetaRegistro.gridwidth = 3;
		gbc_etiquetaRegistro.anchor = GridBagConstraints.NORTH;
		gbc_etiquetaRegistro.insets = new Insets(0, 0, 5, 5);
		gbc_etiquetaRegistro.gridx = 1;
		gbc_etiquetaRegistro.gridy = 1;
		add(etiquetaRegistro, gbc_etiquetaRegistro);

		JLabel etiquetaNombre = new JLabel("Nombre");
		etiquetaNombre.setForeground(new Color(245, 196, 74));
		etiquetaNombre.setFont(new Font("Eras Medium ITC", Font.BOLD, 25));
		etiquetaNombre.setBackground(new Color(245, 196, 74));
		GridBagConstraints gbc_etiquetaNombre = new GridBagConstraints();
		gbc_etiquetaNombre.fill = GridBagConstraints.BOTH;
		gbc_etiquetaNombre.insets = new Insets(0, 0, 5, 5);
		gbc_etiquetaNombre.gridx = 1;
		gbc_etiquetaNombre.gridy = 3;
		add(etiquetaNombre, gbc_etiquetaNombre);

		campoNombre = new JTextField();
		campoNombre.setFont(new Font("Arial Black", Font.PLAIN, 25));
		campoNombre.setColumns(10);
		GridBagConstraints gbc_campoNombre = new GridBagConstraints();
		gbc_campoNombre.fill = GridBagConstraints.HORIZONTAL;
		gbc_campoNombre.gridwidth = 2;
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
		gbc_etiquetaDireccion.fill = GridBagConstraints.BOTH;
		gbc_etiquetaDireccion.insets = new Insets(0, 0, 5, 5);
		gbc_etiquetaDireccion.gridx = 1;
		gbc_etiquetaDireccion.gridy = 4;
		add(etiquetaDireccion, gbc_etiquetaDireccion);

		campoDireccion = new JTextField();
		campoDireccion.setFont(new Font("Arial Black", Font.PLAIN, 25));
		campoDireccion.setColumns(10);
		GridBagConstraints gbc_campoDireccion = new GridBagConstraints();
		gbc_campoDireccion.fill = GridBagConstraints.HORIZONTAL;
		gbc_campoDireccion.gridwidth = 2;
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
		gbc_etiquetaTelefono.fill = GridBagConstraints.BOTH;
		gbc_etiquetaTelefono.insets = new Insets(0, 0, 5, 5);
		gbc_etiquetaTelefono.gridx = 1;
		gbc_etiquetaTelefono.gridy = 5;
		add(etiquetaTelefono, gbc_etiquetaTelefono);

		campoTelefono = new JTextField();
		campoTelefono.setFont(new Font("Arial Black", Font.PLAIN, 25));
		campoTelefono.setColumns(10);
		GridBagConstraints gbc_campoTelefono = new GridBagConstraints();
		gbc_campoTelefono.fill = GridBagConstraints.HORIZONTAL;
		gbc_campoTelefono.gridwidth = 2;
		gbc_campoTelefono.anchor = GridBagConstraints.SOUTH;
		gbc_campoTelefono.insets = new Insets(0, 0, 5, 5);
		gbc_campoTelefono.gridx = 2;
		gbc_campoTelefono.gridy = 5;
		add(campoTelefono, gbc_campoTelefono);

		JLabel etiquetaDNI = new JLabel("DNI");
		etiquetaDNI.setForeground(new Color(245, 196, 74));
		etiquetaDNI.setFont(new Font("Eras Medium ITC", Font.BOLD, 25));
		etiquetaDNI.setBackground(new Color(245, 196, 74));
		GridBagConstraints gbc_etiquetaDNI = new GridBagConstraints();
		gbc_etiquetaDNI.fill = GridBagConstraints.BOTH;
		gbc_etiquetaDNI.insets = new Insets(0, 0, 5, 5);
		gbc_etiquetaDNI.gridx = 1;
		gbc_etiquetaDNI.gridy = 6;
		add(etiquetaDNI, gbc_etiquetaDNI);

		campoDNI = new JTextField();
		campoDNI.setFont(new Font("Arial Black", Font.PLAIN, 25));
		campoDNI.setColumns(10);
		GridBagConstraints gbc_campoDNI = new GridBagConstraints();
		gbc_campoDNI.fill = GridBagConstraints.HORIZONTAL;
		gbc_campoDNI.gridwidth = 2;
		gbc_campoDNI.anchor = GridBagConstraints.SOUTH;
		gbc_campoDNI.insets = new Insets(0, 0, 5, 5);
		gbc_campoDNI.gridx = 2;
		gbc_campoDNI.gridy = 6;
		add(campoDNI, gbc_campoDNI);

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
		gbc_campoEmail.fill = GridBagConstraints.HORIZONTAL;
		gbc_campoEmail.gridwidth = 2;
		gbc_campoEmail.anchor = GridBagConstraints.SOUTH;
		gbc_campoEmail.insets = new Insets(0, 0, 5, 5);
		gbc_campoEmail.gridx = 2;
		gbc_campoEmail.gridy = 7;
		add(campoEmail, gbc_campoEmail);

		JLabel etiquetaContraseña = new JLabel("Contraseña");
		etiquetaContraseña.setForeground(new Color(245, 196, 74));
		etiquetaContraseña.setFont(new Font("Eras Medium ITC", Font.BOLD, 25));
		etiquetaContraseña.setBackground(new Color(245, 196, 74));
		GridBagConstraints gbc_etiquetaContraseña = new GridBagConstraints();
		gbc_etiquetaContraseña.fill = GridBagConstraints.BOTH;
		gbc_etiquetaContraseña.insets = new Insets(0, 0, 5, 5);
		gbc_etiquetaContraseña.gridx = 1;
		gbc_etiquetaContraseña.gridy = 8;
		add(etiquetaContraseña, gbc_etiquetaContraseña);

		campoContraseña = new JPasswordField();
		GridBagConstraints gbc_campoContraseña = new GridBagConstraints();
		gbc_campoContraseña.gridwidth = 2;
		gbc_campoContraseña.insets = new Insets(0, 0, 5, 5);
		gbc_campoContraseña.fill = GridBagConstraints.BOTH;
		gbc_campoContraseña.gridx = 2;
		gbc_campoContraseña.gridy = 8;
		add(campoContraseña, gbc_campoContraseña);

		JButton botonRegistro = new JButton("Registrarse");
		botonRegistro.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				
				
				try {String direccion = campoDireccion.getText();
				String DNI = campoDNI.getText();
				String email = campoEmail.getText();
				String contraseña = new String(campoContraseña.getPassword());
					String nombre = campoNombre.getText();
					int telefono = Integer.parseInt(campoTelefono.getText());
					new Usuario(email, nombre, telefono, contraseña, DNI, direccion);
					JOptionPane.showMessageDialog(ventana, "Usuario registrado correctamente",
							"Bienvenido a Reyna Ciclismo", JOptionPane.INFORMATION_MESSAGE);
					ventana.cambiarAPantalla(PantallaLogin.class);
					
				} catch (NombreConNumeroException e1) {
					JOptionPane.showMessageDialog(ventana, "El nombre no puede contener números", "Error en el campo nombre",
							JOptionPane.ERROR_MESSAGE);
					e1.printStackTrace();
					
				} catch (SQLIntegrityConstraintViolationException e3) {
					JOptionPane.showMessageDialog(ventana, "El email ya está registrado", "No se pudo registrar",
							JOptionPane.ERROR_MESSAGE);

				} catch (SQLException e4) {
					JOptionPane.showMessageDialog(ventana, e4.getMessage(), "No se puede conectar a la base de datos",
							JOptionPane.ERROR_MESSAGE);
					e4.printStackTrace();
					
				} catch (NumberFormatException e2) {
					JOptionPane.showMessageDialog(ventana, "Tienes que poner un número de telefono que sea número",
							"Error en el campo teléfono", JOptionPane.ERROR_MESSAGE);

				}
			}

		});
		botonRegistro.setForeground(new Color(78, 1, 23));
		botonRegistro.setFont(new Font("Eras Medium ITC", Font.PLAIN, 25));
		botonRegistro.setBackground(new Color(245, 196, 74));
		GridBagConstraints gbc_botonRegistro = new GridBagConstraints();
		gbc_botonRegistro.insets = new Insets(0, 0, 5, 5);
		gbc_botonRegistro.fill = GridBagConstraints.BOTH;
		gbc_botonRegistro.gridx = 2;
		gbc_botonRegistro.gridy = 10;
		add(botonRegistro, gbc_botonRegistro);

		JButton botonLimpiar = new JButton("Limpiar datos");
		botonLimpiar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				campoNombre.setText("");
				campoDireccion.setText("");
				campoTelefono.setText("");
				campoDNI.setText("");
				campoEmail.setText("");
				campoContraseña.setText("");
			}
		});
		botonLimpiar.setForeground(new Color(78, 1, 23));
		botonLimpiar.setFont(new Font("Eras Medium ITC", Font.PLAIN, 25));
		botonLimpiar.setBackground(new Color(245, 196, 74));
		GridBagConstraints gbc_botonLimpiar = new GridBagConstraints();
		gbc_botonLimpiar.insets = new Insets(0, 0, 5, 5);
		gbc_botonLimpiar.gridx = 1;
		gbc_botonLimpiar.gridy = 13;
		add(botonLimpiar, gbc_botonLimpiar);

		JButton botonCancelar = new JButton("Cancelar");
		botonCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ventana.cambiarAPantalla(PantallaLogin.class);
			}
		});
		botonCancelar.setForeground(new Color(78, 1, 23));
		botonCancelar.setFont(new Font("Eras Medium ITC", Font.PLAIN, 25));
		botonCancelar.setBackground(new Color(245, 196, 74));
		GridBagConstraints gbc_botonCancelar = new GridBagConstraints();
		gbc_botonCancelar.insets = new Insets(0, 0, 5, 5);
		gbc_botonCancelar.gridx = 3;
		gbc_botonCancelar.gridy = 13;
		add(botonCancelar, gbc_botonCancelar);
	}
}
