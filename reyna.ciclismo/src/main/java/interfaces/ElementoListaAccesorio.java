package interfaces;

import java.awt.Color;
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

import clases.Accesorio;
import clases.Bicicleta;
import clases.Producto;
import clases.ProductosComprados;

import java.awt.Font;
import java.awt.FlowLayout;
import javax.swing.border.LineBorder;

public class ElementoListaAccesorio extends JPanel{
Ventana ventana;
Accesorio accesorio;

public ElementoListaAccesorio(Ventana v, Accesorio a) {
	setBackground(new Color(245, 196, 75));
	setForeground(new Color(78, 1, 23));
	setBorder(new LineBorder(new Color(78, 1, 23), 3));
	FlowLayout flowLayout = (FlowLayout) getLayout();
	flowLayout.setHgap(10);
	this.ventana=v;
	this.accesorio=a;
	JLabel labelMarca = new JLabel("Marca "+accesorio.getMarca());
	labelMarca.setFont(new Font("Calibri", Font.PLAIN, 15));
	add(labelMarca);

	JLabel labelModelo = new JLabel("Modelo "+accesorio.getModelo());
	labelModelo.setFont(new Font("Calibri", Font.PLAIN, 15));
	add(labelModelo);

	JLabel labelColor = new JLabel("Color "+accesorio.getColor());
	labelColor.setFont(new Font("Calibri", Font.PLAIN, 15));
	add(labelColor);

	JLabel labelTalla = new JLabel("Talla "+accesorio.getTalla());
	labelTalla.setFont(new Font("Calibri", Font.PLAIN, 15));
	add(labelTalla);

	JLabel labelPrecio = new JLabel("Precio "+String.valueOf(accesorio.getPrecio())+" €");
	labelPrecio.setFont(new Font("Calibri", Font.PLAIN, 15));
	add(labelPrecio);

/*	JLabel labelEan = new JLabel(String.valueOf(accesorio.getEan()));
	labelEan.setFont(new Font("Calibri", Font.PLAIN, 15));
	add(labelEan);

	JLabel labelProveedor = new JLabel(accesorio.getProveedor().getNombre());
	labelProveedor.setFont(new Font("Calibri", Font.PLAIN, 15));
	add(labelProveedor);

	JLabel labelDescripcion = new JLabel(accesorio.getDescripcion());
	labelDescripcion.setFont(new Font("Calibri", Font.PLAIN, 15));
	add(labelDescripcion);*/

	JButton botonVer = new JButton("Ver mas detalles");
	botonVer.setFont(new Font("Calibri", Font.PLAIN, 15));
	botonVer.setForeground(new Color(78, 1, 23));
	botonVer.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			String marca = accesorio.getMarca();
			String modelo = accesorio.getModelo();
			String imagenAccesorio = "";

			if (marca.equals("Oakley") && modelo.equals("Sutro")) {
				imagenAccesorio = ".\\imagenes\\Oakley Sutro.jpg";
			} else if (marca.equals("Shimano") && modelo.equals("XC90")) {
				imagenAccesorio = ".\\imagenes\\XC9.jpg";
			
			} else {
			    // Imagen por defecto si no se cumple ninguna condición
				imagenAccesorio = ".\\imagenes\\icono casco.png";
			}
			String mensaje = "Marca: " + accesorio.getMarca() + "\n" +
	                "Modelo: " + accesorio.getModelo() + "\n" +
	                "Color: " + accesorio.getColor() + "\n" +
	                "Talla: " + accesorio.getTalla() + "\n" +
	                "Precio: " + accesorio.getPrecio() + " €\n" +
	                "EAN: " + accesorio.getEan() + "\n" +
	                "Proveedor: " + accesorio.getProveedor().getNombre() + "\n" +
	                "Descripción: " + accesorio.getDescripcion();
			try {
			    BufferedImage imagen = ImageIO.read(new File(imagenAccesorio));
			    ImageIcon icono = new ImageIcon(imagen.getScaledInstance(500, 500, Image.SCALE_SMOOTH));

			    JOptionPane.showMessageDialog(ventana, mensaje, "Ver mas detalles",
			            JOptionPane.INFORMATION_MESSAGE, icono);
			} catch (IOException e1) {
			    e1.printStackTrace();
			}
				}
			});
			add(botonVer);
			add(botonVer);
			JButton botonAgregar = new JButton("Agregar al carrito");
			botonAgregar.setFont(new Font("Calibri", Font.PLAIN, 15));
			botonAgregar.setForeground(new Color(78, 1, 23));
			botonAgregar.addActionListener(new ActionListener() {
			    public void actionPerformed(ActionEvent e) {
			        // Obtener el objeto de la bicicleta seleccionada
			        Accesorio accesorioSeleccionado = accesorio;

			        // Crear un objeto de la clase ProductosComprados con la bicicleta seleccionada
			        ArrayList<Producto> productos = new ArrayList<>();
			        productos.add(accesorioSeleccionado);
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
