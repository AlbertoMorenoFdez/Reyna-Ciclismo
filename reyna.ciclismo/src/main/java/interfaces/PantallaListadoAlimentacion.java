package interfaces;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
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
