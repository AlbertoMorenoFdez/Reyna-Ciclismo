package clases;

import java.util.ArrayList;

public class ProductosComprados {
private ArrayList<Producto>productos;
private int cantidad;

public int getCantidad() {
	return cantidad;
}

public void setCantidad(int cantidad) {
	this.cantidad = cantidad;
}

public ProductosComprados(ArrayList<Producto> productos) {
	super();
	this.productos = productos;
}

public ArrayList<Producto> getProductos() {
	return productos;
}

public void setProductos(ArrayList<Producto> productos) {
	this.productos = productos;
}


}
