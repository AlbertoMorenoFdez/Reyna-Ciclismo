package interfaces;

import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JCheckBoxMenuItem;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PantallaAdministracion extends JPanel {
	private Ventana ventana;

	public PantallaAdministracion(Ventana v) {
		this.ventana = v;
		setSize(800, 700);
		setBackground(new Color(78, 1, 23));
		setLayout(null);
		
		JLabel etiquetaAdministracion = new JLabel("Administración");
		etiquetaAdministracion.setHorizontalAlignment(SwingConstants.CENTER);
		etiquetaAdministracion.setForeground(new Color(245, 196, 74));
		etiquetaAdministracion.setFont(new Font("Eras Medium ITC", Font.BOLD, 50));
		etiquetaAdministracion.setBackground(new Color(245, 196, 74));
		etiquetaAdministracion.setBounds(217, 50, 365, 58);
		add(etiquetaAdministracion);
		
		JLabel etiquetaMenuAdministracion = new JLabel("¿Qué deseas hacer?");
		etiquetaMenuAdministracion.setFont(new Font("Eras Medium ITC", Font.PLAIN, 25));
		etiquetaMenuAdministracion.setForeground(new Color(245, 196, 75));
		etiquetaMenuAdministracion.setHorizontalAlignment(SwingConstants.CENTER);
		etiquetaMenuAdministracion.setBounds(262, 172, 276, 42);
		add(etiquetaMenuAdministracion);
		
		JButton botonAltaProducto = new JButton("Dar alta producto");
		botonAltaProducto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ventana.cambiarAPantalla(PantallaAltaProducto.class);
			}
		});
		botonAltaProducto.setForeground(new Color(78, 1, 23));
		botonAltaProducto.setBackground(new Color(245, 196, 75));
		botonAltaProducto.setFont(new Font("Eras Medium ITC", Font.PLAIN, 25));
		botonAltaProducto.setBounds(100, 315, 265, 40);
		add(botonAltaProducto);
		
		JButton botonModificarProducto = new JButton("Modificar producto");
		botonModificarProducto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ventana.cambiarAPantalla(PantallaModificarProducto.class);
			}
		});
		botonModificarProducto.setForeground(new Color(78, 1, 23));
		botonModificarProducto.setFont(new Font("Eras Medium ITC", Font.PLAIN, 25));
		botonModificarProducto.setBackground(new Color(245, 196, 75));
		botonModificarProducto.setBounds(440, 315, 265, 40);
		add(botonModificarProducto);
		
		JButton botonAltaProveedor = new JButton("Dar alta proveedor");
		botonAltaProveedor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ventana.cambiarAPantalla(PantallaAltaProveedor.class);
			}
		});
		botonAltaProveedor.setForeground(new Color(78, 1, 23));
		botonAltaProveedor.setFont(new Font("Eras Medium ITC", Font.PLAIN, 25));
		botonAltaProveedor.setBackground(new Color(245, 196, 75));
		botonAltaProveedor.setBounds(100, 437, 265, 40);
		add(botonAltaProveedor);
		
		JButton botonModificarProveedor = new JButton("Modificar proveedor");
		botonModificarProveedor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ventana.cambiarAPantalla(PantallaModificarProveedor.class);
			}
		});
		botonModificarProveedor.setForeground(new Color(78, 1, 23));
		botonModificarProveedor.setFont(new Font("Eras Medium ITC", Font.PLAIN, 25));
		botonModificarProveedor.setBackground(new Color(245, 196, 75));
		botonModificarProveedor.setBounds(440, 437, 265, 40);
		add(botonModificarProveedor);
		
		JButton botonModificarCliente = new JButton("Modificar cliente");
		botonModificarCliente.setForeground(new Color(78, 1, 23));
		botonModificarCliente.setFont(new Font("Eras Medium ITC", Font.PLAIN, 25));
		botonModificarCliente.setBackground(new Color(245, 196, 75));
		botonModificarCliente.setBounds(100, 550, 265, 40);
		add(botonModificarCliente);
		
		JButton botonConsultarVentas = new JButton("Consultar ventas");
		botonConsultarVentas.setForeground(new Color(78, 1, 23));
		botonConsultarVentas.setFont(new Font("Eras Medium ITC", Font.PLAIN, 25));
		botonConsultarVentas.setBackground(new Color(245, 196, 75));
		botonConsultarVentas.setBounds(440, 550, 265, 40);
		add(botonConsultarVentas);
	}
}
