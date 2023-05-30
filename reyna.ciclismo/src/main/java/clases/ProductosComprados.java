package clases;

import java.util.ArrayList;

public class ProductosComprados {
private ArrayList<Producto>productos;

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
