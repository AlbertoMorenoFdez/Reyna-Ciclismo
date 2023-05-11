package interfaces;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class Ventana extends JFrame{
	public Ventana(){
		this.setSize(800,700); //Establece el tamaño
		this.setTitle("Tienda Online Reyna Ciclismo");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		ImageIcon icono=new ImageIcon("./imagenes/logo amarillo.png");
		this.setIconImage(icono.getImage());
		this.setContentPane(new PantallaLogin(this));
		this.setContentPane(new PantallaRegistro(this));
		this.setContentPane(new PantallaAdministracion(this));
//		this.setContentPane(new PantallaAltaProducto(this));
//		this.setContentPane(new PantallaModificarProducto(this));
//		this.setContentPane(new PantallaAltaProveedor(this));
//		this.setContentPane(new PantallaModificarProveedor(this));
		this.setVisible(true); //Siempre tiene que ser la ultima fila
	}
	
	public void cambiarAPantalla(Class<?>clase) {  
		this.getContentPane().setVisible(false);
		if(clase.equals(PantallaLogin.class)) {
			this.setContentPane(new PantallaLogin(this));
		}
		if(clase.equals(PantallaRegistro.class)) {
			this.setContentPane(new PantallaRegistro(this));
		}
		if(clase.equals(PantallaAdministracion.class)) {
			this.setContentPane(new PantallaAdministracion(this));
		
		}
		if(clase.equals(PantallaAltaProducto.class)) {
			this.setContentPane(new PantallaAltaProducto(this));}
		
		if(clase.equals(PantallaModificarProducto.class)) {
			this.setContentPane(new PantallaModificarProducto(this));
		}
		
		if(clase.equals(PantallaAltaProveedor.class)) {
			this.setContentPane(new PantallaAltaProveedor(this));
		}
		
		if(clase.equals(PantallaModificarProveedor.class)) {
			this.setContentPane(new PantallaModificarProveedor(this));
		}
		
		
		this.getContentPane().setVisible(true);
	}
}
