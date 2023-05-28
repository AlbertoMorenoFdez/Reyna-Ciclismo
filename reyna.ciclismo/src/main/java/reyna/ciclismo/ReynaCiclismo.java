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
import utils.DAO;

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
		
		/*Modificar producto*/
//		HashMap<String, Object> datosAModificar = new HashMap<>();
//        datosAModificar.put("marca", "226er");
//        datosAModificar.put("modelo", "Energy shot");
//        datosAModificar.put("color", "");
//        datosAModificar.put("ean", 1111);
//        datosAModificar.put("descripcion", "Shot de cafeina");
//        datosAModificar.put("precio", 2);
//        datosAModificar.put("calorias", "1400cal");
//        datosAModificar.put("nombre_proveedor", "p");
//
//        HashMap<String, Object> restricciones = new HashMap<>();
//        // Agrega las restricciones necesarias para identificar el registro a modificar
//        restricciones.put("ean", 1111);
//        
//        try {
//			DAO.actualizar("alimentacion", datosAModificar, restricciones);
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
		
	}
}
