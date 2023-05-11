package interfaces;

import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class PantallaAltaProveedor extends JPanel {
	private Ventana ventana;
	private JTextField campoEmail;
	private JTextField campoCif;
	private JTextField campoTelefono;
	private JTextField campoDireccion;
	private JTextField campoNombre;
	
	
	public PantallaAltaProveedor(Ventana v) {
		this.ventana=v;
		setSize(800, 700);
		setBackground(new Color(78, 1, 23));
		setLayout(null);
		
		JLabel etiquetaAltaProveedor = new JLabel("ALTA DE PROVEEDOR");
		etiquetaAltaProveedor.setHorizontalAlignment(SwingConstants.CENTER);
		etiquetaAltaProveedor.setForeground(new Color(245, 196, 74));
		etiquetaAltaProveedor.setFont(new Font("Eras Medium ITC", Font.BOLD, 50));
		etiquetaAltaProveedor.setBackground(new Color(245, 196, 74));
		etiquetaAltaProveedor.setBounds(100, 50, 600, 58);
		add(etiquetaAltaProveedor);
		
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
		
		JLabel etiquetaCif = new JLabel("CIF");
		etiquetaCif.setForeground(new Color(245, 196, 74));
		etiquetaCif.setFont(new Font("Eras Medium ITC", Font.BOLD, 25));
		etiquetaCif.setBackground(new Color(245, 196, 74));
		etiquetaCif.setBounds(101, 315, 120, 44);
		add(etiquetaCif);
		
		JLabel etiquetaEmail = new JLabel("Email");
		etiquetaEmail.setForeground(new Color(245, 196, 74));
		etiquetaEmail.setFont(new Font("Eras Medium ITC", Font.BOLD, 25));
		etiquetaEmail.setBackground(new Color(245, 196, 74));
		etiquetaEmail.setBounds(101, 370, 120, 44);
		add(etiquetaEmail);
		
		campoEmail = new JTextField();
		campoEmail.setFont(new Font("Arial Black", Font.PLAIN, 25));
		campoEmail.setColumns(10);
		campoEmail.setBounds(245, 378, 452, 36);
		add(campoEmail);
		
		campoCif = new JTextField();
		campoCif.setHorizontalAlignment(SwingConstants.CENTER);
		campoCif.setFont(new Font("Arial Black", Font.PLAIN, 25));
		campoCif.setColumns(10);
		campoCif.setBounds(245, 323, 452, 36);
		add(campoCif);
		
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
		
		JButton botonAlta = new JButton("Alta");
		botonAlta.setForeground(new Color(78, 1, 23));
		botonAlta.setFont(new Font("Eras Medium ITC", Font.PLAIN, 25));
		botonAlta.setBackground(new Color(245, 196, 74));
		botonAlta.setBounds(552, 571, 145, 32);
		add(botonAlta);
		
		JButton botonAtras = new JButton("<-- Atrás");
		botonAtras.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ventana.cambiarAPantalla(PantallaAdministracion.class);
			}
		});
		
		botonAtras.setForeground(new Color(78, 1, 23));
		botonAtras.setFont(new Font("Eras Medium ITC", Font.PLAIN, 25));
		botonAtras.setBackground(new Color(245, 196, 74));
		botonAtras.setBounds(100, 571, 145, 32);
		add(botonAtras);
	}
}
