package reyna.ciclismo;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Scanner;

import clases.Accesorio;
import clases.Alimentacion;
import clases.Bicicleta;

import clases.Producto;
import clases.Proveedor;
import clases.Usuario;
import enumReyna.ModalidadBicicleta;

import excepciones.ContraseñaInvalidaException;
import excepciones.NombreConNumeroException;
import excepciones.ProductoNoExisteException;
import excepciones.ProveedorNoExisteException;
import excepciones.UsuarioNoExisteException;
import interfaces.Ventana;

public class ReynaCiclismo {

	public static void main(String[] args)  {

		Ventana v=new Ventana();

//		// Proveedor proveedor=new Proveedor("proveedor prueba", "calle del proveedor",
//		// "B12345678", "email del proveedor", 12345678);
//
//		Scanner sc = new Scanner(System.in);// Proveedor proveedorInsertar=new Proveedor("proveedor prueba", "calle
//											// del proveedor", "12345678A", "proveedor@proveedor", 91000000);
////Bicicleta productoInsertar=new Bicicleta("marca bici prueba", "bici prueba", "color prueba", "descripcion prueba", 123456789, (float)3000.50, (short)2, ModalidadBicicleta.MTB, "Mediana","proveedor prueba");
//		Scanner scanner = new Scanner(System.in);
//	    boolean cifValido=false;
//	    
//	   do {System.out.println("Ingrese el CIF del proveedor a modificar: ");
//	    	String cifProveedor = scanner.nextLine();
//
//	    try {
//	        // Crear una instancia de Proveedor usando el CIF proporcionado
//	        Proveedor proveedor = new Proveedor(cifProveedor);
//	        cifValido=true;
//
//	        // Imprimir los datos del proveedor recuperados
//	        System.out.println("Datos del proveedor:");
//	        System.out.println("Nombre: " + proveedor.getNombre());
//	        System.out.println("Dirección: " + proveedor.getDireccion());
//	        System.out.println("CIF: " + proveedor.getCIF());
//	        System.out.println("Teléfono: " + proveedor.getTelefonoProveedor());
//	        System.out.println("Email: " + proveedor.getEmailProveedor());
//
//	        // Realizar las operaciones de modificación de datos necesarias
//
//	    } catch (ProveedorNoExisteException e) {
//	        System.out.println("El proveedor con CIF " + cifProveedor + " no existe en la base de datos.");
//	        cifValido=false;
//	    }
//	   }while(!cifValido);
	}
}
