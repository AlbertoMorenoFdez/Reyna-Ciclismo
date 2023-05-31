package interfaces;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import clases.Alimentacion;
import excepciones.ProveedorNoExisteException;

public class PantallaListadoAlimentacion extends JPanel{
	private Ventana ventana;
	
	public PantallaListadoAlimentacion(Ventana v) {
		this.ventana=v;
		setBackground(new Color(78, 1, 23));
		setLayout(new BorderLayout(0, 0));
		
		JLabel etiquetaAlimentacion = new JLabel("ALIMENTACIÓN");
		etiquetaAlimentacion.setHorizontalAlignment(SwingConstants.CENTER);
		etiquetaAlimentacion.setForeground(new Color(245, 196, 74));
		etiquetaAlimentacion.setFont(new Font("Eras Medium ITC", Font.BOLD, 50));
		etiquetaAlimentacion.setBackground(new Color(245, 196, 74));
		add(etiquetaAlimentacion, BorderLayout.NORTH);
		
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
		add(botonAtras, BorderLayout.SOUTH);
		
		JScrollPane lista = new JScrollPane();
		lista.setViewportBorder(new LineBorder(new Color(78, 1, 23), 15));
		add(lista, BorderLayout.CENTER);
		
		JPanel contenedorElementos = new JPanel();
		contenedorElementos.setBorder(new EmptyBorder(2, 2, 2, 2));
		contenedorElementos.setLayout(new BoxLayout(contenedorElementos, BoxLayout.Y_AXIS));

		Dimension panelSize = new Dimension(10, 50); // Definir las dimensiones deseadas (ancho x alto)
		contenedorElementos.setPreferredSize(panelSize); // Establecer las dimensiones preferidas del panel
		
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
		
		JLabel etiquetaAlimentos = new JLabel("ACCESORIOS");
		etiquetaAlimentos.setHorizontalAlignment(SwingConstants.CENTER);
		etiquetaAlimentos.setForeground(new Color(245, 196, 74));
		etiquetaAlimentos.setFont(new Font("Eras Medium ITC", Font.BOLD, 50));
		etiquetaAlimentos.setBackground(new Color(245, 196, 74));
		GridBagConstraints gbc_etiquetaAlimentos = new GridBagConstraints();
		gbc_etiquetaAlimentos.anchor = GridBagConstraints.EAST;
		gbc_etiquetaAlimentos.insets = new Insets(0, 0, 0, 5);
		gbc_etiquetaAlimentos.gridx = 2;
		gbc_etiquetaAlimentos.gridy = 0;
		panelCabecera.add(etiquetaAlimentos, gbc_etiquetaAlimentos);

		lista.setViewportView(contenedorElementos);
		
		ArrayList<Alimentacion>todaLaAlimentacion = null;
		
		try {
			todaLaAlimentacion=Alimentacion.getTodos();
		} catch (SQLException | ProveedorNoExisteException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		for(Alimentacion alimentacion:todaLaAlimentacion) {
			ElementoListaAlimentacion elemento=new ElementoListaAlimentacion(ventana, alimentacion);
			contenedorElementos.add(elemento);
		}
		
	}

}
