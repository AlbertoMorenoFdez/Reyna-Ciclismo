package clases;

public class Producto {
private String marca;
private String modelo;
private String color;
private String descripcion;
private int EAN;
private float precio;
private short cantidad;
private Proveedor proveedor;



public Producto(String marca, String modelo, String color, String descripcion, int ean, float precio, short cantidad,
		Proveedor proveedor) {
	super();
	this.marca = marca;
	this.modelo = modelo;
	this.color = color;
	this.descripcion = descripcion;
	this.EAN = ean;
	this.precio = precio;
	this.cantidad = cantidad;
	this.proveedor = proveedor;
}

public String getMarca() {
	return marca;
}

public void setMarca(String marca) {
	this.marca = marca;
}

public String getModelo() {
	return modelo;
}

public void setModelo(String modelo) {
	this.modelo = modelo;
}

public String getColor() {
	return color;
}

public void setColor(String color) {
	this.color = color;
}

public String getDescripcion() {
	return descripcion;
}

public void setDescripcion(String descripcion) {
	this.descripcion = descripcion;
}

public int getEan() {
	return EAN;
}

public void setEan(int ean) {
	this.EAN = ean;
}

public float getPrecio() {
	return precio;
}

public void setPrecio(float precio) {
	this.precio = precio;
	
}

public short getCantidad() {
	return cantidad;
}

public void setCantidad(short cantidad) {
	this.cantidad = cantidad;
}

public Proveedor getProveedor() {
	return proveedor;
}

public void setProveedor(Proveedor proveedor) {
	this.proveedor = proveedor;
}

@Override
public String toString() {
	return "Producto [marca=" + marca + ", modelo=" + modelo + ", color=" + color + ", descripcion=" + descripcion
			+ ", EAN=" + EAN + ", precio=" + precio + ", cantidad=" + cantidad + ", proveedor=" + proveedor + "]";
}






}
