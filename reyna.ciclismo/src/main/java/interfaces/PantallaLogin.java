package interfaces;

import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JInternalFrame;
import javax.swing.Box;
import javax.swing.border.LineBorder;
import java.awt.Component;
import java.awt.Font;
import java.awt.Cursor;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.SwingConstants;

public class PantallaLogin extends JPanel {
	private JTextField campoUsuario;
	private JPasswordField campoContraseña;
	private Ventana ventana;

	public PantallaLogin(Ventana v) {
		this.ventana=v;
		setSize(800, 700);
		setBackground(new Color(78, 1, 23));
		setLayout(null);
		
		JLabel etiquetaBienvenido = new JLabel("BIENVENIDO");
		etiquetaBienvenido.setHorizontalAlignment(SwingConstants.CENTER);
		etiquetaBienvenido.setForeground(new Color(245, 196, 74));
		etiquetaBienvenido.setFont(new Font("Eras Medium ITC", Font.BOLD, 50));
		etiquetaBienvenido.setBackground(new Color(245, 196, 74));
		etiquetaBienvenido.setBounds(240, 50, 320, 58);
		add(etiquetaBienvenido);
		
		JLabel etiquetaUsuario = new JLabel("Usuario");
		etiquetaUsuario.setForeground(new Color(245, 196, 74));
		etiquetaUsuario.setFont(new Font("Eras Medium ITC", Font.BOLD, 30));
		etiquetaUsuario.setBackground(new Color(245, 196, 74));
		etiquetaUsuario.setBounds(60, 237, 120, 44);
		add(etiquetaUsuario);
		
		JLabel etiquetaBienvenidoReyna = new JLabel("A REYNA CICLISMO");
		etiquetaBienvenidoReyna.setHorizontalAlignment(SwingConstants.CENTER);
		etiquetaBienvenidoReyna.setForeground(new Color(245, 196, 74));
		etiquetaBienvenidoReyna.setFont(new Font("Eras Medium ITC", Font.BOLD, 50));
		etiquetaBienvenidoReyna.setBackground(new Color(245, 196, 74));
		etiquetaBienvenidoReyna.setBounds(167, 104, 466, 58);
		add(etiquetaBienvenidoReyna);
		
		JLabel etiquetaContraseña = new JLabel("Contraseña");
		etiquetaContraseña.setForeground(new Color(245, 196, 74));
		etiquetaContraseña.setFont(new Font("Eras Medium ITC", Font.BOLD, 30));
		etiquetaContraseña.setBackground(new Color(245, 196, 74));
		etiquetaContraseña.setBounds(60, 306, 172, 44);
		add(etiquetaContraseña);
		
		campoUsuario = new JTextField();
		campoUsuario.setFont(new Font("Arial Black", Font.PLAIN, 25));
		campoUsuario.setBounds(260, 237, 424, 38);
		add(campoUsuario);
		campoUsuario.setColumns(10);
		
		campoContraseña = new JPasswordField();
		campoContraseña.setFont(new Font("Arial Black", Font.PLAIN, 25));
		campoContraseña.setBounds(260, 306, 424, 38);
		add(campoContraseña);
		
		JButton botonLogin = new JButton("Login");
		botonLogin.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String usuario = campoUsuario.getText();
				String contraseña = new String(campoContraseña.getPassword());
				System.out.println(usuario + " : " + contraseña);
			}
		});
		botonLogin.setForeground(new Color(78, 1, 23));
		botonLogin.setFont(new Font("Eras Medium ITC", Font.PLAIN, 30));
		botonLogin.setBackground(new Color(245, 196, 74));
		botonLogin.setBounds(320, 405, 160, 50);
		add(botonLogin);
		
		JLabel etiquetaSinRegistro = new JLabel("¿Aún no tienes cuenta? Regístrate");
		etiquetaSinRegistro.setForeground(new Color(245, 196, 74));
		etiquetaSinRegistro.setBackground(new Color(245, 196, 74));
		etiquetaSinRegistro.setFont(new Font("Eras Medium ITC", Font.BOLD, 30));
		etiquetaSinRegistro.setBounds(60, 581, 500, 38);
		add(etiquetaSinRegistro);
		
		JButton botonRegistro = new JButton("Registro");
		botonRegistro.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ventana.cambiarAPantalla(PantallaRegistro.class);
			}
		});
		botonRegistro.setForeground(new Color(78, 1, 23));
		botonRegistro.setFont(new Font("Eras Medium ITC", Font.PLAIN, 30));
		botonRegistro.setBackground(new Color(245, 196, 74));
		botonRegistro.setBounds(575, 569, 160, 50);
		add(botonRegistro);
	}
}
