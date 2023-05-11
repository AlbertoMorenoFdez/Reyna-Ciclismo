package clases;

public class Alimentacion extends Producto{
private short calorias;

public Alimentacion(String marca, String modelo, String color, String descripcion, int ean, float precio,short cantidad,
		Proveedor proveedor, short calorias) {
	super(marca, modelo, color, descripcion, ean, precio, cantidad, proveedor);
	this.calorias = calorias;
}

public short getCalorias() {
	return calorias;
}

public void setCalorias(short calorias) {
	this.calorias = calorias;
}

@Override
public String toString() {
	return super.toString()+"Alimentacion [calorias=" + calorias + "]";
}


}
