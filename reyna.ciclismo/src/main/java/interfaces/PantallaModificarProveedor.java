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

public class PantallaModificarProveedor extends JPanel {
	private Ventana ventana;
	private JTextField campoEmail;
	private JTextField campoCif;
	private JTextField campoTelefono;
	private JTextField campoDireccion;
	private JTextField campoNombre;
	
	//public PantallaModificarProveedor(Ventana v) {}
	
	
	
	public PantallaModificarProveedor(Ventana v) {
		this.ventana=v;
		setSize(800, 700);
		setBackground(new Color(78, 1, 23));
		setLayout(null);
		
		JLabel etiquetaModificarProveedor = new JLabel("MODIFICAR PROVEEDOR");
		etiquetaModificarProveedor.setHorizontalAlignment(SwingConstants.CENTER);
		etiquetaModificarProveedor.setForeground(new Color(245, 196, 74));
		etiquetaModificarProveedor.setFont(new Font("Eras Medium ITC", Font.BOLD, 50));
		etiquetaModificarProveedor.setBackground(new Color(245, 196, 74));
		etiquetaModificarProveedor.setBounds(90, 50, 620, 58);
		add(etiquetaModificarProveedor);
		
		JLabel etiquetaNombre = new JLabel("Nombre");
		etiquetaNombre.setForeground(new Color(245, 196, 74));
		etiquetaNombre.setFont(new Font("Eras Medium ITC", Font.BOLD, 25));
		etiquetaNombre.setBackground(new Color(245, 196, 74));
		etiquetaNombre.setBounds(101, 183, 120, 44);
		add(etiquetaNombre);
		
		JLabel etiquetaDireccion = new JLabel("Direccion");
		etiquetaDireccion.setForeground(new Color(245, 196, 74));
		etiquetaDireccion.setFont(new Font("Eras Medium ITC", Font.BOLD, 25));
		etiquetaDireccion.setBackground(new Color(245, 196, 74));
		etiquetaDireccion.setBounds(101, 241, 120, 44);
		add(etiquetaDireccion);
		
		JLabel etiquetaTelefono = new JLabel("Teléfono");
		etiquetaTelefono.setForeground(new Color(245, 196, 74));
		etiquetaTelefono.setFont(new Font("Eras Medium ITC", Font.BOLD, 25));
		etiquetaTelefono.setBackground(new Color(245, 196, 74));
		etiquetaTelefono.setBounds(101, 298, 120, 44);
		add(etiquetaTelefono);
		
		JLabel etiquetaCif = new JLabel("CIF");
		etiquetaCif.setForeground(new Color(245, 196, 74));
		etiquetaCif.setFont(new Font("Eras Medium ITC", Font.BOLD, 25));
		etiquetaCif.setBackground(new Color(245, 196, 74));
		etiquetaCif.setBounds(101, 357, 120, 44);
		add(etiquetaCif);
		
		JLabel etiquetaEmail = new JLabel("Email");
		etiquetaEmail.setForeground(new Color(245, 196, 74));
		etiquetaEmail.setFont(new Font("Eras Medium ITC", Font.BOLD, 25));
		etiquetaEmail.setBackground(new Color(245, 196, 74));
		etiquetaEmail.setBounds(101, 418, 120, 44);
		add(etiquetaEmail);
		
		campoEmail = new JTextField();
		campoEmail.setFont(new Font("Arial Black", Font.PLAIN, 25));
		campoEmail.setColumns(10);
		campoEmail.setBounds(245, 420, 452, 36);
		String email = null;
		campoEmail.setText(email);
		add(campoEmail);
		
		campoCif = new JTextField();
		campoCif.setHorizontalAlignment(SwingConstants.CENTER);
		campoCif.setFont(new Font("Arial Black", Font.PLAIN, 25));
		campoCif.setColumns(10);
		campoCif.setBounds(245, 359, 452, 36);
		String cif = null;
		campoCif.setText(cif);
		add(campoCif);
		
		campoTelefono = new JTextField();
		campoTelefono.setFont(new Font("Arial Black", Font.PLAIN, 25));
		campoTelefono.setColumns(10);
		campoTelefono.setBounds(245, 300, 452, 36);
		int telefono = 0;
		campoTelefono.setText(Integer.toString(telefono));
		add(campoTelefono);
		
		campoDireccion = new JTextField();
		campoDireccion.setFont(new Font("Arial Black", Font.PLAIN, 25));
		campoDireccion.setColumns(10);
		campoDireccion.setBounds(245, 243, 452, 36);
		String direccion = null;
		campoDireccion.setText(direccion);
		add(campoDireccion);
		
		campoNombre = new JTextField();
		campoNombre.setFont(new Font("Arial Black", Font.PLAIN, 25));
		campoNombre.setColumns(10);
		campoNombre.setBounds(245, 185, 452, 36);
		String nombre = null;
		campoNombre.setText(nombre);
		add(campoNombre);
		
		JButton botonModificar = new JButton("Modificar");
		botonModificar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
			}
		});
		botonModificar.setForeground(new Color(78, 1, 23));
		botonModificar.setFont(new Font("Eras Medium ITC", Font.PLAIN, 25));
		botonModificar.setBackground(new Color(245, 196, 74));
		botonModificar.setBounds(552, 571, 145, 32);
		add(botonModificar);
		
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
		
		JLabel lblquProveedorQuieres = new JLabel("¿Qué datos quieres modificar?");
		lblquProveedorQuieres.setHorizontalAlignment(SwingConstants.CENTER);
		lblquProveedorQuieres.setForeground(new Color(245, 196, 75));
		lblquProveedorQuieres.setFont(new Font("Eras Medium ITC", Font.PLAIN, 15));
		lblquProveedorQuieres.setBounds(250, 140, 300, 14);
		add(lblquProveedorQuieres);
	}
}
