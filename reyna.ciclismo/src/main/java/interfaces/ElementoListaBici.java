package interfaces;

import javax.swing.JFrame;
import javax.swing.JPanel;

import clases.Bicicleta;
import excepciones.ProveedorNoExisteException;

import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Image;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;

import java.awt.BorderLayout;
import java.awt.Color;

public class ElementoListaBici extends JPanel {
	Ventana ventana;
	Bicicleta bicicleta;

	public ElementoListaBici(Ventana v, Bicicleta b) {
		this.ventana = v;
		this.bicicleta = b;

//		setSize(800, 700);
//		GridBagLayout gridBagLayout = new GridBagLayout();
//		gridBagLayout.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
//		gridBagLayout.rowHeights = new int[]{0, 0};
//		gridBagLayout.columnWeights = new double[]{1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 0.0, 1.0, 0.0, Double.MIN_VALUE};
//		gridBagLayout.rowWeights = new double[]{0.0, Double.MIN_VALUE};
//		setLayout(gridBagLayout);
//		
//		ArrayList<Bicicleta> todasLasBicicletas = null;
//		
//		
//			try {
//				todasLasBicicletas=Bicicleta.getTodos();
//			} catch (SQLException | ProveedorNoExisteException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		for(Bicicleta bicicleta:todasLasBicicletas) {
//			JLabel labelMarca = new JLabel(bicicleta.getMarca());
//		GridBagConstraints gbc_labelMarca = new GridBagConstraints();
//		gbc_labelMarca.insets = new Insets(0, 0, 0, 5);
//		gbc_labelMarca.gridx = 0;
//		gbc_labelMarca.gridy = 0;
//		add(labelMarca, gbc_labelMarca);
//		
//		JLabel labelModelo = new JLabel(bicicleta.getModelo());
//		GridBagConstraints gbc_labelModelo = new GridBagConstraints();
//		gbc_labelModelo.insets = new Insets(0, 0, 0, 5);
//		gbc_labelModelo.gridx = 1;
//		gbc_labelModelo.gridy = 0;
//		add(labelModelo, gbc_labelModelo);
//		
//		JLabel labelColor = new JLabel(bicicleta.getColor());
//		GridBagConstraints gbc_labelColor = new GridBagConstraints();
//		gbc_labelColor.insets = new Insets(0, 0, 0, 5);
//		gbc_labelColor.gridx = 2;
//		gbc_labelColor.gridy = 0;
//		add(labelColor, gbc_labelColor);
//		
//		JLabel labelModalidad = new JLabel(bicicleta.getModalidad().toString());
//		GridBagConstraints gbc_labelModalidad = new GridBagConstraints();
//		gbc_labelModalidad.insets = new Insets(0, 0, 0, 5);
//		gbc_labelModalidad.gridx = 3;
//		gbc_labelModalidad.gridy = 0;
//		add(labelModalidad, gbc_labelModalidad);
//		
//		JLabel labelTalla = new JLabel(bicicleta.getTallaBicicleta());
//		GridBagConstraints gbc_labelTalla = new GridBagConstraints();
//		gbc_labelTalla.insets = new Insets(0, 0, 0, 5);
//		gbc_labelTalla.gridx = 4;
//		gbc_labelTalla.gridy = 0;
//		add(labelTalla, gbc_labelTalla);
//		
//		JLabel labelPrecio = new JLabel(String.valueOf(bicicleta.getPrecio()));
//		GridBagConstraints gbc_labelPrecio = new GridBagConstraints();
//		gbc_labelPrecio.insets = new Insets(0, 0, 0, 5);
//		gbc_labelPrecio.gridx = 5;
//		gbc_labelPrecio.gridy = 0;
//		add(labelPrecio, gbc_labelPrecio);
//		
//		JLabel labelEan = new JLabel(String.valueOf(bicicleta.getEan()));
//		GridBagConstraints gbc_labelEan = new GridBagConstraints();
//		gbc_labelEan.insets = new Insets(0, 0, 0, 5);
//		gbc_labelEan.gridx = 6;
//		gbc_labelEan.gridy = 0;
//		add(labelEan, gbc_labelEan);
//		
//		JLabel labelProveeedor = new JLabel(bicicleta.getProveedor().getNombre());
//		GridBagConstraints gbc_labelProveeedor = new GridBagConstraints();
//		gbc_labelProveeedor.insets = new Insets(0, 0, 0, 5);
//		gbc_labelProveeedor.gridx = 7;
//		gbc_labelProveeedor.gridy = 0;
//		add(labelProveeedor, gbc_labelProveeedor);
//		
//		JLabel labelDescripcion = new JLabel(bicicleta.getDescripcion());
//		GridBagConstraints gbc_labelDescripcion = new GridBagConstraints();
//		gbc_labelDescripcion.insets = new Insets(0, 0, 0, 5);
//		gbc_labelDescripcion.gridx = 8;
//		gbc_labelDescripcion.gridy = 0;
//		add(labelDescripcion, gbc_labelDescripcion);
//		
//		JButton botonVer = new JButton("Ver");
//		botonVer.setForeground(new Color(78, 1, 23));
//		GridBagConstraints gbc_botonVer = new GridBagConstraints();
//		gbc_botonVer.insets = new Insets(0, 0, 0, 5);
//		gbc_botonVer.gridx = 10;
//		gbc_botonVer.gridy = 0;
//		add(botonVer, gbc_botonVer);
//		ventana=v;
//		bicicletas=b;
//		}
//		add(botonVer);
		setSize(100, 700);
		setLayout(new GridLayout(1, 11));

		JLabel labelMarca = new JLabel(bicicleta.getMarca());
		add(labelMarca);

		JLabel labelModelo = new JLabel(bicicleta.getModelo());
		add(labelModelo);

		JLabel labelColor = new JLabel(bicicleta.getColor());
		add(labelColor);

		JLabel labelModalidad = new JLabel(bicicleta.getModalidad().toString());
		add(labelModalidad);

		JLabel labelTalla = new JLabel(bicicleta.getTallaBicicleta());
		add(labelTalla);

		JLabel labelPrecio = new JLabel(String.valueOf(bicicleta.getPrecio()));
		add(labelPrecio);

		JLabel labelEan = new JLabel(String.valueOf(bicicleta.getEan()));
		add(labelEan);

		JLabel labelProveedor = new JLabel(bicicleta.getProveedor().getNombre());
		add(labelProveedor);

		JLabel labelDescripcion = new JLabel(bicicleta.getDescripcion());
		add(labelDescripcion);

		JButton botonVer = new JButton("Ver");
		botonVer.setForeground(new Color(78, 1, 23));
		botonVer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String marca = bicicleta.getMarca();
				String modelo = bicicleta.getModelo();
				String imagenBici = "";

				if (marca.equals("KTM") && modelo.equals("Scarp")) {
					imagenBici = ".\\imagenes\\scarp.jpg";
				} else if (marca.equals("bh") && modelo.equals("Lynx 6.5")) {
					imagenBici = ".\\imagenes\\lynx6_5.jpg";
				
				} else {
				    // Imagen por defecto si no se cumple ninguna condición
					imagenBici = ".\\imagenes\\mtb.jpg";
				}
				String mensaje = "Marca: " + bicicleta.getMarca() + "\n" +
		                "Modelo: " + bicicleta.getModelo() + "\n" +
		                "Color: " + bicicleta.getColor() + "\n" +
		                "Modalidad: " + bicicleta.getModalidad().toString() + "\n" +
		                "Talla: " + bicicleta.getTallaBicicleta() + "\n" +
		                "Precio: " + bicicleta.getPrecio() + "\n" +
		                "EAN: " + bicicleta.getEan() + "\n" +
		                "Proveedor: " + bicicleta.getProveedor().getNombre() + "\n" +
		                "Descripción: " + bicicleta.getDescripcion();

		try {
		    BufferedImage imagen = ImageIO.read(new File(imagenBici));
		    ImageIcon icono = new ImageIcon(imagen.getScaledInstance(500, 500, Image.SCALE_SMOOTH));

		    JOptionPane.showMessageDialog(ventana, mensaje, "Detalles de la bicicleta",
		            JOptionPane.INFORMATION_MESSAGE, icono);
		} catch (IOException e1) {
		    e1.printStackTrace();
		}
			}
		});
		add(botonVer);
		
//		public void actionPerformed(ActionEvent e) {
		// Acción al hacer clic en el botón "Ver"
//		JFrame ventanaEmergente = new JFrame("Detalles de la bicicleta");
//		ventanaEmergente.setSize(400, 300);
//		ventanaEmergente.setLocationRelativeTo(null);
//		ventanaEmergente.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
//
//		// Crear y configurar los componentes para mostrar los datos de la bicicleta
//		JLabel labelMarca = new JLabel("Marca: " + bicicleta.getMarca());
//		JLabel labelModelo = new JLabel("Modelo: " + bicicleta.getModelo());
//		JLabel labelColor = new JLabel("Color: " + bicicleta.getColor());
//		JLabel labelModalidad = new JLabel("Modalidad: " + bicicleta.getModalidad().toString());
//		JLabel labelTalla = new JLabel("Talla: " + bicicleta.getTallaBicicleta());
//		JLabel labelPrecio = new JLabel("Precio: " + bicicleta.getPrecio());
//		JLabel labelEan = new JLabel("EAN: " + bicicleta.getEan());
//		JLabel labelProveedor = new JLabel("Proveedor: " + bicicleta.getProveedor().getNombre());
//		JLabel labelDescripcion=new JLabel("Descripción: "+bicicleta.getDescripcion());
//
//		JLabel labelImagen = new JLabel("");
//		try {
//			BufferedImage imagen = ImageIO.read(new File(".\\imagenes\\folleto rojo.jpg"));
//			Image enIcono = imagen.getScaledInstance(200, 100, imagen.SCALE_SMOOTH);
//			labelImagen.setIcon(new ImageIcon(enIcono));
//		} catch (IOException e2) {
//			// TODO Auto-generated catch block
//			e2.printStackTrace();
//		}
//
//		// Crear un panel para organizar los componentes
//		JPanel panelDetalles = new JPanel();
//		panelDetalles.setLayout(new GridLayout(9, 1));
//		panelDetalles.add(labelMarca);
//		panelDetalles.add(labelModelo);
//		panelDetalles.add(labelColor);
//		panelDetalles.add(labelModalidad);
//		panelDetalles.add(labelTalla);
//		panelDetalles.add(labelPrecio);
//		panelDetalles.add(labelEan);
//		panelDetalles.add(labelProveedor);
//		panelDetalles.add(labelImagen);
//
//		ventanaEmergente.add(panelDetalles);
//		ventanaEmergente.setVisible(true);

	}
}
