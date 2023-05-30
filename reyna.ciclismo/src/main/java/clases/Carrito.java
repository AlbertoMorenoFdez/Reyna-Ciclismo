package clases;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.LinkedList;

public class Carrito {
private LinkedHashSet<ProductosComprados>productosComprados;

public Carrito() {
	super();
	this.productosComprados = new LinkedHashSet<ProductosComprados>();
}

public void añadirCarrito(ProductosComprados productosComprados) {
	this.productosComprados.add(productosComprados);
	
}

public void quitarCarrito(ProductosComprados productosComprados) {
	this.productosComprados.remove(productosComprados);
	
}

public int cantidadCarrito() {
	return this.productosComprados.size();
	
}

public LinkedHashSet<ProductosComprados> getProductosComprados() {
	return productosComprados;
}



}
