package interfaces;

import javax.swing.JFrame;
import javax.swing.JPanel;

import clases.Bicicleta;
import clases.Producto;
import clases.ProductosComprados;
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
import java.awt.FlowLayout;
import java.awt.Font;
import javax.swing.border.LineBorder;

public class ElementoListaBici extends JPanel {
	Ventana ventana;
	Bicicleta bicicleta;

	public ElementoListaBici(Ventana v, Bicicleta b) {
		setBackground(new Color(245, 196, 75));
		setBorder(new LineBorder(new Color(78, 1, 23), 3));
		setForeground(new Color(78, 1, 23));
		this.ventana = v;
		this.bicicleta = b;
		FlowLayout flowLayout = new FlowLayout(FlowLayout.CENTER, 10, 5);
		setLayout(flowLayout);

		JLabel labelModalidad = new JLabel("Bicicleta "+bicicleta.getModalidad().toString());
		labelModalidad.setFont(new Font("Calibri", Font.PLAIN, 15));
		add(labelModalidad);
		
		JLabel labelMarca = new JLabel("Marca "+bicicleta.getMarca());
		labelMarca.setFont(new Font("Calibri", Font.PLAIN, 15));
		add(labelMarca);

		JLabel labelModelo = new JLabel("Modelo " +bicicleta.getModelo());
		labelModelo.setFont(new Font("Calibri", Font.PLAIN, 15));
		add(labelModelo);

		JLabel labelColor = new JLabel("Color " +bicicleta.getColor());
		labelColor.setFont(new Font("Calibri", Font.PLAIN, 15));
		add(labelColor);

		JLabel labelTalla = new JLabel("Talla "+bicicleta.getTallaBicicleta());
		labelTalla.setFont(new Font("Calibri", Font.PLAIN, 15));
		add(labelTalla);

		JLabel labelPrecio = new JLabel("Precio "+String.valueOf(bicicleta.getPrecio())+" €");
		labelPrecio.setFont(new Font("Calibri", Font.PLAIN, 15));
		add(labelPrecio);

/*		JLabel labelEan = new JLabel(String.valueOf(bicicleta.getEan()));
		labelEan.setFont(new Font("Calibri", Font.PLAIN, 15));
		add(labelEan);

		JLabel labelProveedor = new JLabel(bicicleta.getProveedor().getNombre());
		labelProveedor.setFont(new Font("Calibri", Font.PLAIN, 15));
		add(labelProveedor);

		JLabel labelDescripcion = new JLabel(bicicleta.getDescripcion());
		labelDescripcion.setFont(new Font("Calibri", Font.PLAIN, 15));
		add(labelDescripcion);*/

		JButton botonVer = new JButton("Ver mas detalles");
		botonVer.setFont(new Font("Calibri", Font.PLAIN, 15));
		botonVer.setForeground(new Color(78, 1, 23));
		botonVer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String marca = bicicleta.getMarca();
				String modelo = bicicleta.getModelo();
				String imagenBici = "";

				if (marca.equals("KTM") && modelo.equals("Scarp")) {
					imagenBici = ".\\imagenes\\scarp.jpg";
				} else if (marca.equals("BH") && modelo.equals("Lynx 6.5")) {
					imagenBici = ".\\imagenes\\lynx6_5.jpg";
				} else if (marca.equals("FACTOR") && modelo.equals("Ostro Van")) {
					imagenBici = ".\\imagenes\\ostro.jpg";
				} else if (marca.equals("RIDLEY") && modelo.equals("Noah Disc")) {
					imagenBici = ".\\imagenes\\noah.jpg";
				} else if (marca.equals("FOCUS") && modelo.equals("Jam2")) {
					imagenBici = ".\\imagenes\\jam2.png";
				} else if (marca.equals("BH") && modelo.equals("ILynx Trail")) {
					imagenBici = ".\\imagenes\\ilynx.jpg";
				} else if (marca.equals("EOVOLT") && modelo.equals("Afternoon")) {
					imagenBici = ".\\imagenes\\eovolt.jpg";
				} else if (marca.equals("BROMPTON") && modelo.equals("C Line Explore")) {
					imagenBici = ".\\imagenes\\brompton.jpg";
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
		
		JButton botonAgregar = new JButton("Agregar al carrito");
		botonAgregar.setFont(new Font("Calibri", Font.PLAIN, 15));
		botonAgregar.setForeground(new Color(78, 1, 23));
		botonAgregar.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        // Obtener el objeto de la bicicleta seleccionada
		        Bicicleta bicicletaSeleccionada = bicicleta;

		        // Crear un objeto de la clase ProductosComprados con la bicicleta seleccionada
		        ArrayList<Producto> productos = new ArrayList<>();
		        productos.add(bicicletaSeleccionada);
		        ProductosComprados productosComprados = new ProductosComprados(productos);

		        // Añadir el objeto de ProductosComprados al carrito
		        ventana.getCarrito().añadirCarrito(productosComprados);

		        // Mostrar un mensaje de éxito
		        JOptionPane.showMessageDialog(ventana, "La bicicleta se agregó al carrito.", "Enhorabuena",
		                JOptionPane.INFORMATION_MESSAGE);
		        ventana.cambiarAPantalla(PantallaCarrito.class);
		    }
		});
		add(botonAgregar);
		
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
