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
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;

public class PantallaAdministracion extends JPanel {
	private Ventana ventana;

	public PantallaAdministracion(Ventana v) {
		this.ventana = v;
		setSize(800, 700);
		setBackground(new Color(78, 1, 23));
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{70, 265, 75, 265, 70, 0};
		gridBagLayout.rowHeights = new int[]{0, 58, 64, 42, 60, 40, 82, 40, 73, 40, 0, 0};
		gridBagLayout.columnWeights = new double[]{1.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JButton botonModificarCliente = new JButton("Modificar cliente");
		botonModificarCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ventana.cambiarAPantalla(PantallaPreviaModificarCliente.class);
			}
		});
		
		JButton botonAltaProducto = new JButton("Dar alta producto");
		botonAltaProducto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ventana.cambiarAPantalla(PantallaAltaProducto.class);
			}
		});
		
		JLabel labelUsuario = new JLabel("Estas conectado como "+ventana.usuarioLogueado.getNombre());
		labelUsuario.setHorizontalAlignment(SwingConstants.LEFT);
		labelUsuario.setForeground(new Color(245, 196, 74));
		labelUsuario.setBackground(new Color(245, 196, 74));
		GridBagConstraints gbc_labelUsuario = new GridBagConstraints();
		gbc_labelUsuario.anchor = GridBagConstraints.WEST;
		gbc_labelUsuario.gridwidth = 2;
		gbc_labelUsuario.insets = new Insets(0, 0, 5, 5);
		gbc_labelUsuario.gridx = 1;
		gbc_labelUsuario.gridy = 0;
		add(labelUsuario, gbc_labelUsuario);
		
		JLabel etiquetaAdministracion = new JLabel("Administración");
		etiquetaAdministracion.setHorizontalAlignment(SwingConstants.CENTER);
		etiquetaAdministracion.setForeground(new Color(245, 196, 74));
		etiquetaAdministracion.setFont(new Font("Eras Medium ITC", Font.BOLD, 50));
		etiquetaAdministracion.setBackground(new Color(245, 196, 74));
		GridBagConstraints gbc_etiquetaAdministracion = new GridBagConstraints();
		gbc_etiquetaAdministracion.anchor = GridBagConstraints.NORTH;
		gbc_etiquetaAdministracion.insets = new Insets(0, 0, 5, 5);
		gbc_etiquetaAdministracion.gridwidth = 3;
		gbc_etiquetaAdministracion.gridx = 1;
		gbc_etiquetaAdministracion.gridy = 1;
		add(etiquetaAdministracion, gbc_etiquetaAdministracion);
		
		JLabel etiquetaMenuAdministracion = new JLabel("¿Qué deseas hacer?");
		etiquetaMenuAdministracion.setFont(new Font("Eras Medium ITC", Font.PLAIN, 25));
		etiquetaMenuAdministracion.setForeground(new Color(245, 196, 75));
		etiquetaMenuAdministracion.setHorizontalAlignment(SwingConstants.CENTER);
		GridBagConstraints gbc_etiquetaMenuAdministracion = new GridBagConstraints();
		gbc_etiquetaMenuAdministracion.fill = GridBagConstraints.VERTICAL;
		gbc_etiquetaMenuAdministracion.insets = new Insets(0, 0, 5, 5);
		gbc_etiquetaMenuAdministracion.gridwidth = 3;
		gbc_etiquetaMenuAdministracion.gridx = 1;
		gbc_etiquetaMenuAdministracion.gridy = 3;
		add(etiquetaMenuAdministracion, gbc_etiquetaMenuAdministracion);
		botonAltaProducto.setForeground(new Color(78, 1, 23));
		botonAltaProducto.setBackground(new Color(245, 196, 75));
		botonAltaProducto.setFont(new Font("Eras Medium ITC", Font.PLAIN, 25));
		GridBagConstraints gbc_botonAltaProducto = new GridBagConstraints();
		gbc_botonAltaProducto.fill = GridBagConstraints.BOTH;
		gbc_botonAltaProducto.insets = new Insets(0, 0, 5, 5);
		gbc_botonAltaProducto.gridx = 1;
		gbc_botonAltaProducto.gridy = 5;
		add(botonAltaProducto, gbc_botonAltaProducto);
		
		JButton botonModificarProveedor = new JButton("Modificar proveedor");
		botonModificarProveedor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ventana.cambiarAPantalla(PantallaPreviaModificarProveedor.class);
			}
		});
		
		JButton botonAltaProveedor = new JButton("Dar alta proveedor");
		botonAltaProveedor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ventana.cambiarAPantalla(PantallaAltaProveedor.class);
			}
		});
		
		JButton botonModificarProducto = new JButton("Modificar producto");
		botonModificarProducto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ventana.cambiarAPantalla(PantallaPreviaModificarProducto.class);
			}
		});
		botonModificarProducto.setForeground(new Color(78, 1, 23));
		botonModificarProducto.setFont(new Font("Eras Medium ITC", Font.PLAIN, 25));
		botonModificarProducto.setBackground(new Color(245, 196, 75));
		GridBagConstraints gbc_botonModificarProducto = new GridBagConstraints();
		gbc_botonModificarProducto.fill = GridBagConstraints.BOTH;
		gbc_botonModificarProducto.insets = new Insets(0, 0, 5, 5);
		gbc_botonModificarProducto.gridx = 3;
		gbc_botonModificarProducto.gridy = 5;
		add(botonModificarProducto, gbc_botonModificarProducto);
		botonAltaProveedor.setForeground(new Color(78, 1, 23));
		botonAltaProveedor.setFont(new Font("Eras Medium ITC", Font.PLAIN, 25));
		botonAltaProveedor.setBackground(new Color(245, 196, 75));
		GridBagConstraints gbc_botonAltaProveedor = new GridBagConstraints();
		gbc_botonAltaProveedor.fill = GridBagConstraints.BOTH;
		gbc_botonAltaProveedor.insets = new Insets(0, 0, 5, 5);
		gbc_botonAltaProveedor.gridx = 1;
		gbc_botonAltaProveedor.gridy = 7;
		add(botonAltaProveedor, gbc_botonAltaProveedor);
		botonModificarProveedor.setForeground(new Color(78, 1, 23));
		botonModificarProveedor.setFont(new Font("Eras Medium ITC", Font.PLAIN, 25));
		botonModificarProveedor.setBackground(new Color(245, 196, 75));
		GridBagConstraints gbc_botonModificarProveedor = new GridBagConstraints();
		gbc_botonModificarProveedor.fill = GridBagConstraints.BOTH;
		gbc_botonModificarProveedor.insets = new Insets(0, 0, 5, 5);
		gbc_botonModificarProveedor.gridx = 3;
		gbc_botonModificarProveedor.gridy = 7;
		add(botonModificarProveedor, gbc_botonModificarProveedor);
		botonModificarCliente.setForeground(new Color(78, 1, 23));
		botonModificarCliente.setFont(new Font("Eras Medium ITC", Font.PLAIN, 25));
		botonModificarCliente.setBackground(new Color(245, 196, 75));
		GridBagConstraints gbc_botonModificarCliente = new GridBagConstraints();
		gbc_botonModificarCliente.fill = GridBagConstraints.BOTH;
		gbc_botonModificarCliente.insets = new Insets(0, 0, 5, 5);
		gbc_botonModificarCliente.gridx = 1;
		gbc_botonModificarCliente.gridy = 9;
		add(botonModificarCliente, gbc_botonModificarCliente);
		
		JButton botonConsultarVentas = new JButton("Consultar ventas");
		botonConsultarVentas.setForeground(new Color(78, 1, 23));
		botonConsultarVentas.setFont(new Font("Eras Medium ITC", Font.PLAIN, 25));
		botonConsultarVentas.setBackground(new Color(245, 196, 75));
		GridBagConstraints gbc_botonConsultarVentas = new GridBagConstraints();
		gbc_botonConsultarVentas.insets = new Insets(0, 0, 5, 5);
		gbc_botonConsultarVentas.fill = GridBagConstraints.BOTH;
		gbc_botonConsultarVentas.gridx = 3;
		gbc_botonConsultarVentas.gridy = 9;
		add(botonConsultarVentas, gbc_botonConsultarVentas);
	}
}
