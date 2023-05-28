package interfaces;

import java.awt.Color;


import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JInternalFrame;
import javax.imageio.ImageIO;
import javax.swing.Box;
import javax.swing.border.LineBorder;


import clases.Usuario;

import excepciones.ContraseñaInvalidaException;
import excepciones.UsuarioNoExisteException;

import java.awt.Component;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Cursor;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;

import javax.swing.SwingConstants;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;

public class PantallaLogin extends JPanel {
	private JTextField campoUsuario;
	private JPasswordField campoContraseña;
	private Ventana ventana;
	
	@Override
	protected void paintComponent(Graphics g) {
		// TODO Auto-generated method stub
		super.paintComponent(g);
		try {
			BufferedImage fondo=ImageIO.read(new File("./imagenes/logo rojo.png"));
			g.drawImage(fondo, 0, 0, this);
			g.drawImage(fondo, 0, 0, this.getWidth(), this.getHeight(), new Color(0,0,0), null);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public PantallaLogin(Ventana v) {
		this.ventana=v;
		setSize(800, 700);
		setBackground(new Color(78, 1, 23));
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{70, 172, 320, 160, 70, 0};
		gridBagLayout.rowHeights = new int[]{70, 112, 75, 44, 0, 44, 55, 50, 114, 50, 70, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 1.0, 1.0, 1.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JLabel etiquetaBienvenidoReyna = new JLabel("A REYNA CICLISMO");
		etiquetaBienvenidoReyna.setHorizontalAlignment(SwingConstants.CENTER);
		etiquetaBienvenidoReyna.setForeground(new Color(245, 196, 74));
		etiquetaBienvenidoReyna.setFont(new Font("Eras Medium ITC", Font.BOLD, 50));
		etiquetaBienvenidoReyna.setBackground(new Color(245, 196, 74));
		GridBagConstraints gbc_etiquetaBienvenidoReyna = new GridBagConstraints();
		gbc_etiquetaBienvenidoReyna.anchor = GridBagConstraints.SOUTH;
		gbc_etiquetaBienvenidoReyna.insets = new Insets(0, 0, 5, 5);
		gbc_etiquetaBienvenidoReyna.gridwidth = 3;
		gbc_etiquetaBienvenidoReyna.gridx = 1;
		gbc_etiquetaBienvenidoReyna.gridy = 1;
		add(etiquetaBienvenidoReyna, gbc_etiquetaBienvenidoReyna);
		
		JLabel etiquetaBienvenido = new JLabel("BIENVENIDO");
		etiquetaBienvenido.setHorizontalAlignment(SwingConstants.CENTER);
		etiquetaBienvenido.setForeground(new Color(245, 196, 74));
		etiquetaBienvenido.setFont(new Font("Eras Medium ITC", Font.BOLD, 50));
		etiquetaBienvenido.setBackground(new Color(245, 196, 74));
		GridBagConstraints gbc_etiquetaBienvenido = new GridBagConstraints();
		gbc_etiquetaBienvenido.anchor = GridBagConstraints.NORTH;
		gbc_etiquetaBienvenido.fill = GridBagConstraints.HORIZONTAL;
		gbc_etiquetaBienvenido.insets = new Insets(0, 0, 5, 5);
		gbc_etiquetaBienvenido.gridx = 2;
		gbc_etiquetaBienvenido.gridy = 1;
		add(etiquetaBienvenido, gbc_etiquetaBienvenido);
		
		JLabel etiquetaUsuario = new JLabel("Usuario");
		etiquetaUsuario.setForeground(new Color(245, 196, 74));
		etiquetaUsuario.setFont(new Font("Eras Medium ITC", Font.BOLD, 30));
		etiquetaUsuario.setBackground(new Color(245, 196, 74));
		GridBagConstraints gbc_etiquetaUsuario = new GridBagConstraints();
		gbc_etiquetaUsuario.anchor = GridBagConstraints.WEST;
		gbc_etiquetaUsuario.fill = GridBagConstraints.VERTICAL;
		gbc_etiquetaUsuario.insets = new Insets(0, 0, 5, 5);
		gbc_etiquetaUsuario.gridx = 1;
		gbc_etiquetaUsuario.gridy = 3;
		add(etiquetaUsuario, gbc_etiquetaUsuario);
		
		campoUsuario = new JTextField();
		campoUsuario.setText("admin@admin");
		campoUsuario.setFont(new Font("Arial Black", Font.PLAIN, 25));
		GridBagConstraints gbc_campoUsuario = new GridBagConstraints();
		gbc_campoUsuario.fill = GridBagConstraints.HORIZONTAL;
		gbc_campoUsuario.anchor = GridBagConstraints.NORTH;
		gbc_campoUsuario.insets = new Insets(0, 0, 5, 5);
		gbc_campoUsuario.gridwidth = 2;
		gbc_campoUsuario.gridx = 2;
		gbc_campoUsuario.gridy = 3;
		add(campoUsuario, gbc_campoUsuario);
		campoUsuario.setColumns(10);
		
		JLabel etiquetaContraseña = new JLabel("Contraseña");
		etiquetaContraseña.setForeground(new Color(245, 196, 74));
		etiquetaContraseña.setFont(new Font("Eras Medium ITC", Font.BOLD, 30));
		etiquetaContraseña.setBackground(new Color(245, 196, 74));
		GridBagConstraints gbc_etiquetaContraseña = new GridBagConstraints();
		gbc_etiquetaContraseña.fill = GridBagConstraints.BOTH;
		gbc_etiquetaContraseña.insets = new Insets(0, 0, 5, 5);
		gbc_etiquetaContraseña.gridx = 1;
		gbc_etiquetaContraseña.gridy = 5;
		add(etiquetaContraseña, gbc_etiquetaContraseña);
		
		campoContraseña = new JPasswordField();
		campoContraseña.setFont(new Font("Arial Black", Font.PLAIN, 25));
		GridBagConstraints gbc_campoContraseña = new GridBagConstraints();
		gbc_campoContraseña.fill = GridBagConstraints.HORIZONTAL;
		gbc_campoContraseña.anchor = GridBagConstraints.NORTH;
		gbc_campoContraseña.insets = new Insets(0, 0, 5, 5);
		gbc_campoContraseña.gridwidth = 2;
		gbc_campoContraseña.gridx = 2;
		gbc_campoContraseña.gridy = 5;
		add(campoContraseña, gbc_campoContraseña);
		
		JButton botonRegistro = new JButton("Registro");
		botonRegistro.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ventana.cambiarAPantalla(PantallaRegistro.class);
			}
		});
		
		JButton botonLogin = new JButton("Login");
		botonLogin.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String usuario = campoUsuario.getText();
				String contraseña = new String(campoContraseña.getPassword());
				System.out.println(usuario + " : " + contraseña);
				boolean esAdmin=usuario.equals("admin@admin")&&contraseña.equals("admin");
				try {
					ventana.usuarioLogueado = new Usuario(usuario, contraseña);
					JOptionPane.showMessageDialog(ventana, "Bienvenid@, " + ventana.usuarioLogueado.getNombre(),
							"Inicio de sesión existoso", JOptionPane.INFORMATION_MESSAGE);
					if(esAdmin) {
						ventana.cambiarAPantalla(PantallaAdministracion.class);
					}else {
						ventana.cambiarAPantalla(PantallaMenuProductos.class);
					}
					
				} catch (SQLException e1) {
					JOptionPane.showMessageDialog(ventana, e1.getMessage(), "Login fallido", JOptionPane.ERROR_MESSAGE);
					e1.printStackTrace();
				} catch (UsuarioNoExisteException e1) {
					JOptionPane.showMessageDialog(ventana, "El cliente no existe", "Login fallido",
							JOptionPane.ERROR_MESSAGE);
					e1.printStackTrace();
				} catch (ContraseñaInvalidaException e1) {
					JOptionPane.showMessageDialog(ventana, "Contraseña incorrecta", "Login fallido",
							JOptionPane.ERROR_MESSAGE);
					e1.printStackTrace();
				}
			}
		});
		botonLogin.setForeground(new Color(78, 1, 23));
		botonLogin.setFont(new Font("Eras Medium ITC", Font.PLAIN, 30));
		botonLogin.setBackground(new Color(245, 196, 74));
		GridBagConstraints gbc_botonLogin = new GridBagConstraints();
		gbc_botonLogin.fill = GridBagConstraints.VERTICAL;
		gbc_botonLogin.insets = new Insets(0, 0, 5, 5);
		gbc_botonLogin.gridx = 2;
		gbc_botonLogin.gridy = 7;
		add(botonLogin, gbc_botonLogin);
		
		JLabel etiquetaSinRegistro = new JLabel("¿Aún no tienes cuenta? Regístrate");
		etiquetaSinRegistro.setForeground(new Color(245, 196, 74));
		etiquetaSinRegistro.setBackground(new Color(245, 196, 74));
		etiquetaSinRegistro.setFont(new Font("Eras Medium ITC", Font.BOLD, 30));
		GridBagConstraints gbc_etiquetaSinRegistro = new GridBagConstraints();
		gbc_etiquetaSinRegistro.fill = GridBagConstraints.HORIZONTAL;
		gbc_etiquetaSinRegistro.insets = new Insets(0, 0, 5, 5);
		gbc_etiquetaSinRegistro.gridwidth = 2;
		gbc_etiquetaSinRegistro.gridx = 1;
		gbc_etiquetaSinRegistro.gridy = 9;
		add(etiquetaSinRegistro, gbc_etiquetaSinRegistro);
		botonRegistro.setForeground(new Color(78, 1, 23));
		botonRegistro.setFont(new Font("Eras Medium ITC", Font.PLAIN, 30));
		botonRegistro.setBackground(new Color(245, 196, 74));
		GridBagConstraints gbc_botonRegistro = new GridBagConstraints();
		gbc_botonRegistro.insets = new Insets(0, 0, 5, 5);
		gbc_botonRegistro.fill = GridBagConstraints.BOTH;
		gbc_botonRegistro.gridx = 3;
		gbc_botonRegistro.gridy = 9;
		add(botonRegistro, gbc_botonRegistro);
	}
}
