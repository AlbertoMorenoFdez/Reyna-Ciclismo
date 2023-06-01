package interfaces;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.SwingConstants;

import clases.Bicicleta;
import excepciones.ProveedorNoExisteException;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.border.LineBorder;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;

public class PantallaListadoBicicletas extends JPanel{
	private Ventana ventana;
	
	public PantallaListadoBicicletas(Ventana v) {
		setBackground(new Color(78, 1, 23));
		this.ventana=v;
		setLayout(new BorderLayout(0, 0));
		
		JScrollPane lista = new JScrollPane();
		lista.setViewportBorder(new LineBorder(new Color(78, 1, 23), 15));
		add(lista, BorderLayout.CENTER);
		
//		JPanel contenedorElementos = new JPanel();
//		contenedorElementos.setBorder(new EmptyBorder(2, 2, 2, 2));
//        lista.setViewportView(contenedorElementos);
//        contenedorElementos.setLayout(new BoxLayout(contenedorElementos, BoxLayout.Y_AXIS));
		
		JPanel contenedorElementos = new JPanel();
		contenedorElementos.setBorder(new EmptyBorder(2, 2, 2, 2));
		contenedorElementos.setLayout(new BoxLayout(contenedorElementos, BoxLayout.Y_AXIS));

		Dimension panelSize = new Dimension(10, 50); // Definir las dimensiones deseadas (ancho x alto)
		contenedorElementos.setPreferredSize(panelSize); // Establecer las dimensiones preferidas del panel

		lista.setViewportView(contenedorElementos);
		
		JPanel panelCabecera = new JPanel();
		panelCabecera.setBackground(new Color(78, 1, 23));
		add(panelCabecera, BorderLayout.NORTH);
		GridBagLayout gbl_panelCabecera = new GridBagLayout();
		gbl_panelCabecera.columnWidths = new int[]{10, 0, 0, 50, 0};
		gbl_panelCabecera.rowHeights = new int[]{0, 0};
		gbl_panelCabecera.columnWeights = new double[]{0.0, 1.0, 1.0, 0.0, Double.MIN_VALUE};
		gbl_panelCabecera.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		panelCabecera.setLayout(gbl_panelCabecera);
		
		JLabel labelUsuario = new JLabel("Estas conectado como "+ventana.usuarioLogueado.getNombre());
		labelUsuario.setHorizontalAlignment(SwingConstants.LEFT);
		labelUsuario.setForeground(new Color(245, 196, 74));
		GridBagConstraints gbc_labelUsuario = new GridBagConstraints();
		gbc_labelUsuario.anchor = GridBagConstraints.WEST;
		gbc_labelUsuario.insets = new Insets(0, 0, 0, 5);
		gbc_labelUsuario.gridx = 1;
		gbc_labelUsuario.gridy = 0;
		panelCabecera.add(labelUsuario, gbc_labelUsuario);
		
		JLabel etiquetaBicicletas = new JLabel("BICICLETAS");
		etiquetaBicicletas.setHorizontalAlignment(SwingConstants.CENTER);
		etiquetaBicicletas.setForeground(new Color(245, 196, 74));
		etiquetaBicicletas.setFont(new Font("Eras Medium ITC", Font.BOLD, 50));
		etiquetaBicicletas.setBackground(new Color(245, 196, 74));
		GridBagConstraints gbc_etiquetaBicicletas = new GridBagConstraints();
		gbc_etiquetaBicicletas.anchor = GridBagConstraints.EAST;
		gbc_etiquetaBicicletas.insets = new Insets(0, 0, 0, 5);
		gbc_etiquetaBicicletas.gridx = 2;
		gbc_etiquetaBicicletas.gridy = 0;
		panelCabecera.add(etiquetaBicicletas, gbc_etiquetaBicicletas);
		
		JPanel panelPie = new JPanel();
		panelPie.setBackground(new Color(78, 1, 23));
		add(panelPie, BorderLayout.SOUTH);
		GridBagLayout gbl_panelPie = new GridBagLayout();
		gbl_panelPie.columnWidths = new int[]{50, 0, 0, 0, 0, 0, 50, 0};
		gbl_panelPie.rowHeights = new int[]{10, 0, 10, 0};
		gbl_panelPie.columnWeights = new double[]{0.0, 0.0, 1.0, 0.0, 1.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_panelPie.rowWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		panelPie.setLayout(gbl_panelPie);
		
		JButton botonAtras = new JButton("Volver");
		botonAtras.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ventana.cambiarAPantalla(PantallaMenuProductos.class);
			}
		});
		botonAtras.setForeground(new Color(78, 1, 23));
		botonAtras.setFont(new Font("Eras Medium ITC", Font.PLAIN, 25));
		botonAtras.setBackground(new Color(245, 196, 74));
		GridBagConstraints gbc_botonAtras = new GridBagConstraints();
		gbc_botonAtras.insets = new Insets(0, 0, 5, 5);
		gbc_botonAtras.gridx = 1;
		gbc_botonAtras.gridy = 1;
		panelPie.add(botonAtras, gbc_botonAtras);
		
		JButton botonIrCarrito = new JButton("Ver carrito");
		botonIrCarrito.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ventana.cambiarAPantalla(PantallaCarrito.class);
			}
		});
		
		BotonLogOut botonLogOut = new BotonLogOut();
		botonLogOut.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ventana.cambiarAPantalla(PantallaLogin.class);
			}
			
		});
		GridBagConstraints gbc_botonLogOut = new GridBagConstraints();
		gbc_botonLogOut.fill = GridBagConstraints.BOTH;
		gbc_botonLogOut.insets = new Insets(0, 0, 5, 5);
		gbc_botonLogOut.gridx = 3;
		gbc_botonLogOut.gridy = 1;
		panelPie.add(botonLogOut, gbc_botonLogOut);
		botonIrCarrito.setForeground(new Color(78, 1, 23));
		botonIrCarrito.setFont(new Font("Eras Medium ITC", Font.PLAIN, 25));
		botonIrCarrito.setBackground(new Color(245, 196, 74));
		GridBagConstraints gbc_botonIrCarrito = new GridBagConstraints();
		gbc_botonIrCarrito.insets = new Insets(0, 0, 5, 5);
		gbc_botonIrCarrito.gridx = 5;
		gbc_botonIrCarrito.gridy = 1;
		panelPie.add(botonIrCarrito, gbc_botonIrCarrito);

        ArrayList<Bicicleta> todasLasBicicletas = null;
        try {
            todasLasBicicletas = Bicicleta.getTodos();
        } catch (SQLException | ProveedorNoExisteException e) {
            e.printStackTrace();
        }

        for (Bicicleta bicicleta : todasLasBicicletas) {
            ElementoListaBici elemento = new ElementoListaBici(ventana,bicicleta);
            contenedorElementos.add(elemento);
        }
		
		
	}

}
