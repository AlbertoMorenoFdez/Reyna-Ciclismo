package clases;

public class Accesorio extends Producto{
private byte talla;

public Accesorio(String marca, String modelo, String color, String descripcion, int ean, float precio,short cantidad,
		Proveedor proveedor, byte talla) {
	super(marca, modelo, color, descripcion, ean, precio, cantidad, proveedor);
	this.talla = talla;
}

public byte getTalla() {
	return talla;
}

public void setTalla(byte talla) {
	this.talla = talla;
}

@Override
public String toString() {
	return super.toString()+"Accesorio [talla=" + talla + "]";
}




}
