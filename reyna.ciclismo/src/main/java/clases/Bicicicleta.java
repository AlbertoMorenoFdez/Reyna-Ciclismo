package clases;

import enumReyna.ModalidadBicicleta;

public class Bicicicleta extends Producto{
private ModalidadBicicleta modalidad;
private char tallaBicicleta;


public Bicicicleta(String marca, String modelo, String color, String descripcion, int ean, float precio, short cantidad,
		Proveedor proveedor, ModalidadBicicleta modalidad, char tallaBicicleta) {
	super(marca, modelo, color, descripcion, ean, precio, cantidad, proveedor);
	this.modalidad = modalidad;
	this.tallaBicicleta = tallaBicicleta;
}


public ModalidadBicicleta getModalidad() {
	return modalidad;
}


public void setModalidad(ModalidadBicicleta modalidad) {
	this.modalidad = modalidad;
}


public char getTallaBicicleta() {
	return tallaBicicleta;
}


public void setTallaBicicleta(char tallaBicicleta) {
	this.tallaBicicleta = tallaBicicleta;
}


@Override
public String toString() {
	return super.toString()+"Bicicicleta [modalidad=" + modalidad + ", tallaBicicleta=" + tallaBicicleta + "]";
}



}
