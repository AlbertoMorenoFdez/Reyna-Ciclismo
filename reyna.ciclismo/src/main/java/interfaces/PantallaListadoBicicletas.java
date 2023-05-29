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

public class PantallaListadoBicicletas extends JPanel{
	private Ventana ventana;
	
	public PantallaListadoBicicletas(Ventana v) {
		setBackground(new Color(78, 1, 23));
		this.ventana=v;
		setLayout(new BorderLayout(0, 0));
		
		JLabel etiquetaBicicletas = new JLabel("BICICLETAS");
		etiquetaBicicletas.setHorizontalAlignment(SwingConstants.CENTER);
		etiquetaBicicletas.setForeground(new Color(245, 196, 74));
		etiquetaBicicletas.setFont(new Font("Eras Medium ITC", Font.BOLD, 50));
		etiquetaBicicletas.setBackground(new Color(245, 196, 74));
		add(etiquetaBicicletas, BorderLayout.NORTH);
		
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
