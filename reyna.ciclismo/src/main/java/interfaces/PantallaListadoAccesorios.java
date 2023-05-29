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

import clases.Accesorio;
import excepciones.ProveedorNoExisteException;
import javax.swing.border.LineBorder;

public class PantallaListadoAccesorios extends JPanel{
	private Ventana ventana;
	
	public PantallaListadoAccesorios(Ventana v) {
		setBackground(new Color(78, 1, 23));
		this.ventana=v;
		setLayout(new BorderLayout(0, 0));
		
		JLabel etiquetaAccesorios = new JLabel("ACCESORIOS");
		etiquetaAccesorios.setHorizontalAlignment(SwingConstants.CENTER);
		etiquetaAccesorios.setForeground(new Color(245, 196, 74));
		etiquetaAccesorios.setFont(new Font("Eras Medium ITC", Font.BOLD, 50));
		etiquetaAccesorios.setBackground(new Color(245, 196, 74));
		add(etiquetaAccesorios, BorderLayout.NORTH);
		
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
		
		ArrayList<Accesorio> todosLosAccesorios = null;
		
		try {
			todosLosAccesorios=Accesorio.getTodos();
		} catch (SQLException | ProveedorNoExisteException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		for (Accesorio accesorio : todosLosAccesorios) {
			ElementoListaAccesorio elemento=new ElementoListaAccesorio(ventana, accesorio);
			contenedorElementos.add(elemento);
		}
		
	}
	

}
