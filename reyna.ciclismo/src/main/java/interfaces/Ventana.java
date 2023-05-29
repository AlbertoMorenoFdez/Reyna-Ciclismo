package interfaces;

import javax.swing.ImageIcon;

import javax.swing.JFrame;
import javax.swing.JLabel;

import clases.Usuario;

public class Ventana extends JFrame {

	protected Usuario usuarioLogueado;

	public Ventana() {

		this.setSize(800, 800); // Establece el tamaño
		this.setTitle("Tienda Online Reyna Ciclismo");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		ImageIcon icono = new ImageIcon("./imagenes/logo amarillo.png");

		this.setIconImage(icono.getImage());

		// Establecer imagen de fondo
		ImageIcon imagenFondo = new ImageIcon("./imagenes/folleto rojo.png");
		JLabel labelFondo = new JLabel(imagenFondo);
		this.setContentPane(labelFondo);

		this.setContentPane(new PantallaLogin(this));
// 		this.setContentPane(new PantallaRegistro(this));
// 		this.setContentPane(new PantallaAdministracion(this));
//		this.setContentPane(new PantallaAltaProducto(this));
//		this.setContentPane(new PantallaPreviaModificarProducto(this));
//		this.setContentPane(new PantallaModificarProducto(this));
// 		this.setContentPane(new PantallaAltaProveedor(this));
//		this.setContentPane(new PantallaModificarProveedor(this));
// 		this.setContentPane(new PantallaPreviaModificarProveedor(this));
// 		this.setContentPane(new PantallaMenuProductos(this));
// 		this.setContentPane(new PantallaMenuBicicletas(this));
//		this.setContentPane(new PantallaListadoBicicletas(this));

		this.setVisible(true); // Siempre tiene que ser la ultima fila
	}

	public void cambiarAPantalla(Class<?> clase) {
		this.getContentPane().setVisible(false);
		if (clase.equals(PantallaLogin.class)) {
			this.setContentPane(new PantallaLogin(this));
		}
		if (clase.equals(PantallaRegistro.class)) {
			this.setContentPane(new PantallaRegistro(this));
		}
		if (clase.equals(PantallaAdministracion.class)) {
			this.setContentPane(new PantallaAdministracion(this));
		}
		if (clase.equals(PantallaAltaProducto.class)) {
			this.setContentPane(new PantallaAltaProducto(this));
		}
		if (clase.equals(PantallaPreviaModificarProducto.class)) {
			this.setContentPane(new PantallaPreviaModificarProducto(this));
		}
		if (clase.equals(PantallaModificarBicicleta.class)) {
			this.setContentPane(new PantallaModificarBicicleta(this));
		}
		if (clase.equals(PantallaModificarAlimentacion.class)) {
			this.setContentPane(new PantallaModificarAlimentacion(this));
		}
		if (clase.equals(PantallaModificarAccesorio.class)) {
			this.setContentPane(new PantallaModificarAccesorio(this));
		}
		if (clase.equals(PantallaModificarProducto.class)) {
			this.setContentPane(new PantallaModificarProducto(this));
		}
		if (clase.equals(PantallaAltaProveedor.class)) {
			this.setContentPane(new PantallaAltaProveedor(this));
		}
		if (clase.equals(PantallaPreviaModificarProveedor.class)) {
			this.setContentPane(new PantallaPreviaModificarProveedor(this));
		}
		if (clase.equals(PantallaModificarProveedor.class)) {
			this.setContentPane(new PantallaModificarProveedor(this));
		}
		if (clase.equals(PantallaPreviaModificarCliente.class)) {
			this.setContentPane(new PantallaPreviaModificarCliente(this));
		}
		if (clase.equals(PantallaModificarCliente.class)) {
			this.setContentPane(new PantallaModificarCliente(this));
		}
		if (clase.equals(PantallaMenuProductos.class)) {
			this.setContentPane(new PantallaMenuProductos(this));
		}
		if (clase.equals(PantallaMenuBicicletas.class)) {
			this.setContentPane(new PantallaMenuBicicletas(this));
		}
		if (clase.equals(PantallaListadoBicicletas.class)) {
			this.setContentPane(new PantallaListadoBicicletas(this));
		}

		this.getContentPane().setVisible(true);
	}
}
