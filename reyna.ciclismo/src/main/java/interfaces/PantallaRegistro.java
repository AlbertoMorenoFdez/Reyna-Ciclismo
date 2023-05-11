package interfaces;

import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;

public class PantallaRegistro extends JPanel {
	private JTextField campoContraseña;
	private JTextField campoEmail;
	private JTextField campoDNI;
	private JTextField campoTelefono;
	private JTextField campoDireccion;
	private JTextField campoNombre;
	public PantallaRegistro(Ventana v) {
		setSize(800, 700);
		setBackground(new Color(78, 1, 23));
		setLayout(null);
		
		JLabel etiquetaRegistro = new JLabel("REGISTRO");
		etiquetaRegistro.setForeground(new Color(245, 196, 74));
		etiquetaRegistro.setFont(new Font("Eras Medium ITC", Font.BOLD, 50));
		etiquetaRegistro.setBackground(new Color(245, 196, 74));
		etiquetaRegistro.setBounds(278, 50, 244, 58);
		add(etiquetaRegistro);
		
		JLabel etiquetaNombre = new JLabel("Nombre");
		etiquetaNombre.setForeground(new Color(245, 196, 74));
		etiquetaNombre.setFont(new Font("Eras Medium ITC", Font.BOLD, 25));
		etiquetaNombre.setBackground(new Color(245, 196, 74));
		etiquetaNombre.setBounds(101, 150, 120, 44);
		add(etiquetaNombre);
		
		JLabel etiquetaDireccion = new JLabel("Direccion");
		etiquetaDireccion.setForeground(new Color(245, 196, 74));
		etiquetaDireccion.setFont(new Font("Eras Medium ITC", Font.BOLD, 25));
		etiquetaDireccion.setBackground(new Color(245, 196, 74));
		etiquetaDireccion.setBounds(101, 205, 120, 44);
		add(etiquetaDireccion);
		
		JLabel etiquetaTelefono = new JLabel("Telefono");
		etiquetaTelefono.setForeground(new Color(245, 196, 74));
		etiquetaTelefono.setFont(new Font("Eras Medium ITC", Font.BOLD, 25));
		etiquetaTelefono.setBackground(new Color(245, 196, 74));
		etiquetaTelefono.setBounds(101, 260, 120, 44);
		add(etiquetaTelefono);
		
		JLabel etiquetaDNI = new JLabel("DNI");
		etiquetaDNI.setForeground(new Color(245, 196, 74));
		etiquetaDNI.setFont(new Font("Eras Medium ITC", Font.BOLD, 25));
		etiquetaDNI.setBackground(new Color(245, 196, 74));
		etiquetaDNI.setBounds(101, 315, 120, 44);
		add(etiquetaDNI);
		
		JLabel etiquetaEmail = new JLabel("Email");
		etiquetaEmail.setForeground(new Color(245, 196, 74));
		etiquetaEmail.setFont(new Font("Eras Medium ITC", Font.BOLD, 25));
		etiquetaEmail.setBackground(new Color(245, 196, 74));
		etiquetaEmail.setBounds(101, 370, 120, 44);
		add(etiquetaEmail);
		
		JLabel etiquetaContraseña = new JLabel("Contraseña");
		etiquetaContraseña.setForeground(new Color(245, 196, 74));
		etiquetaContraseña.setFont(new Font("Eras Medium ITC", Font.BOLD, 25));
		etiquetaContraseña.setBackground(new Color(245, 196, 74));
		etiquetaContraseña.setBounds(101, 425, 145, 44);
		add(etiquetaContraseña);
		
		campoContraseña = new JTextField();
		campoContraseña.setFont(new Font("Arial Black", Font.PLAIN, 25));
		campoContraseña.setBounds(245, 433, 452, 36);
		add(campoContraseña);
		campoContraseña.setColumns(10);
		
		campoEmail = new JTextField();
		campoEmail.setFont(new Font("Arial Black", Font.PLAIN, 25));
		campoEmail.setColumns(10);
		campoEmail.setBounds(245, 378, 452, 36);
		add(campoEmail);
		
		campoDNI = new JTextField();
		campoDNI.setFont(new Font("Arial Black", Font.PLAIN, 25));
		campoDNI.setColumns(10);
		campoDNI.setBounds(245, 323, 452, 36);
		add(campoDNI);
		
		campoTelefono = new JTextField();
		campoTelefono.setFont(new Font("Arial Black", Font.PLAIN, 25));
		campoTelefono.setColumns(10);
		campoTelefono.setBounds(245, 268, 452, 36);
		add(campoTelefono);
		
		campoDireccion = new JTextField();
		campoDireccion.setFont(new Font("Arial Black", Font.PLAIN, 25));
		campoDireccion.setColumns(10);
		campoDireccion.setBounds(245, 213, 452, 36);
		add(campoDireccion);
		
		campoNombre = new JTextField();
		campoNombre.setFont(new Font("Arial Black", Font.PLAIN, 25));
		campoNombre.setColumns(10);
		campoNombre.setBounds(245, 158, 452, 36);
		add(campoNombre);
		
		JButton botonLogin = new JButton("Registrarse");
		botonLogin.setForeground(new Color(78, 1, 23));
		botonLogin.setFont(new Font("Eras Medium ITC", Font.PLAIN, 30));
		botonLogin.setBackground(new Color(245, 196, 74));
		botonLogin.setBounds(310, 543, 180, 50);
		add(botonLogin);
	}
}
