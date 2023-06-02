package interfaces;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

import clases.Alimentacion;
import clases.Bicicleta;
import clases.Producto;
import clases.ProductosComprados;

public class ElementoListaAlimentacion extends JPanel{
	Ventana ventana;
	Alimentacion alimentacion;
	
	public ElementoListaAlimentacion(Ventana v, Alimentacion alim) {
		this.ventana=v;
		this.alimentacion=alim;
		
		setBackground(new Color(245, 196, 75));
		setForeground(new Color(78, 1, 23));
		setBorder(new LineBorder(new Color(78, 1, 23), 3));
		FlowLayout flowLayout = (FlowLayout) getLayout();
		flowLayout.setHgap(10);
		
		JLabel labelMarca = new JLabel("Marca "+alimentacion.getMarca());
		labelMarca.setFont(new Font("Calibri", Font.PLAIN, 15));
		add(labelMarca);

		JLabel labelModelo = new JLabel("Modelo "+alimentacion.getModelo());
		labelModelo.setFont(new Font("Calibri", Font.PLAIN, 15));
		add(labelModelo);	

		JLabel labelTalla = new JLabel("Calorias "+alimentacion.getCalorias());
		labelTalla.setFont(new Font("Calibri", Font.PLAIN, 15));
		add(labelTalla);
		
		JLabel labelPrecio = new JLabel("Precio "+String.valueOf(alimentacion.getPrecio())+" €");
		labelPrecio.setFont(new Font("Calibri", Font.PLAIN, 15));
		add(labelPrecio);

		/*JLabel labelColor = new JLabel("Color "+alimentacion.getColor());
		labelColor.setFont(new Font("Calibri", Font.PLAIN, 15));
		add(labelColor);

		JLabel labelEan = new JLabel(String.valueOf(alimentacion.getEan()));
		labelEan.setFont(new Font("Calibri", Font.PLAIN, 15));
		add(labelEan);

		JLabel labelProveedor = new JLabel(alimentacion.getProveedor().getNombre());
		labelProveedor.setFont(new Font("Calibri", Font.PLAIN, 15));
		add(labelProveedor);

		JLabel labelDescripcion = new JLabel(alimentacion.getDescripcion());
		labelDescripcion.setFont(new Font("Calibri", Font.PLAIN, 15));
		add(labelDescripcion);*/
		
		JButton botonVer = new JButton("Ver mas detalles");
		botonVer.setFont(new Font("Calibri", Font.PLAIN, 15));
		botonVer.setForeground(new Color(78, 1, 23));
		botonVer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			String marca = alimentacion.getMarca();
			String modelo = alimentacion.getModelo();
			String imagenAlimentacion = "";

			if (marca.equals("NUTRINOVEX") && modelo.equals("Glucobar")) {
				imagenAlimentacion = ".\\imagenes\\glucobar.jpg";
			} else if (marca.equals("NUTRINOVEX") && modelo.equals("Longovit")) {
				imagenAlimentacion = ".\\imagenes\\gel.jpg";
			} else if (marca.equals("INFISPORT") && modelo.equals("ND4")) {
				imagenAlimentacion = ".\\imagenes\\nd4.jpg";
			} else if (marca.equals("INFISPORT") && modelo.equals("Magnesio")) {
				imagenAlimentacion = ".\\imagenes\\magnesio.jpg";
			} else if (marca.equals("226ers") && modelo.equals("Race Day Bar")) {
				imagenAlimentacion = ".\\imagenes\\barrita226.jpg";
			} else if (marca.equals("NUTRINOVEX") && modelo.equals("Suproplex Recovery 3.1")) {
				imagenAlimentacion = ".\\imagenes\\recuperador.jpg";
			} else {
			    // Imagen por defecto si no se cumple ninguna condición
				imagenAlimentacion = ".\\imagenes\\icono alimentacion.png";
			}
			String mensaje = "Marca: " + alimentacion.getMarca() + "\n" +
	                "Modelo: " + alimentacion.getModelo() + "\n" +
	                "Color: " + alimentacion.getColor() + "\n" +
	                "Calorias : " + alimentacion.getCalorias() + "\n" +
	                "Precio: " + alimentacion.getPrecio() + " €\n" +
	                "EAN: " + alimentacion.getEan() + "\n" +
	                "Proveedor: " + alimentacion.getProveedor().getNombre() + "\n" +
	                "Descripción: " + alimentacion.getDescripcion();
			try {
			    BufferedImage imagen = ImageIO.read(new File(imagenAlimentacion));
			    ImageIcon icono = new ImageIcon(imagen.getScaledInstance(500, 500, Image.SCALE_SMOOTH));

			    JOptionPane.showMessageDialog(ventana, mensaje, "Ver mas detalles",
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
			        Alimentacion alimentoSeleccionado = alimentacion;

			        // Crear un objeto de la clase ProductosComprados con la bicicleta seleccionada
			        ArrayList<Producto> productos = new ArrayList<>();
			        productos.add(alimentoSeleccionado);
			        ProductosComprados productosComprados = new ProductosComprados(productos);

			        // Añadir el objeto de ProductosComprados al carrito
			        ventana.getCarrito().añadirCarrito(productosComprados);

			        // Mostrar un mensaje de éxito
			        JOptionPane.showMessageDialog(ventana, "El producto se agregó al carrito.", "Enhorabuena",
			                JOptionPane.INFORMATION_MESSAGE);
			        ventana.cambiarAPantalla(PantallaCarrito.class);
			    }
			});
			add(botonAgregar);
	}

}
