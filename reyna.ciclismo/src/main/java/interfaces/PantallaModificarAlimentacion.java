package interfaces;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import clases.Alimentacion;
import clases.Bicicleta;
import excepciones.ProveedorNoExisteException;
import utils.DAO;

public class PantallaModificarAlimentacion extends JPanel {
	Ventana ventana;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private final JTable tablaAlimentacion;
	private final DefaultTableModel model;

	public PantallaModificarAlimentacion(Ventana v) {
		this.ventana = v;
		this.tablaAlimentacion = new JTable();
		this.model = new DefaultTableModel();
		setSize(800, 700);
		setBackground(new Color(78, 1, 23));
		setLayout(null);

		JLabel etiquetaModificarAlimentacion = new JLabel("MODIFICAR ALIMENTACIÓN");
		etiquetaModificarAlimentacion.setHorizontalAlignment(SwingConstants.CENTER);
		etiquetaModificarAlimentacion.setForeground(new Color(245, 196, 74));
		etiquetaModificarAlimentacion.setFont(new Font("Eras Medium ITC", Font.BOLD, 50));
		etiquetaModificarAlimentacion.setBackground(new Color(245, 196, 74));
		etiquetaModificarAlimentacion.setBounds(53, 51, 694, 58);
		add(etiquetaModificarAlimentacion);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(100, 263, 600, 250);
		add(scrollPane);

		ArrayList<Alimentacion> todaLaAlimentacion = null;

		
			try {
				todaLaAlimentacion = Alimentacion.getTodos();
			} catch (SQLException e4) {
				// TODO Auto-generated catch block
				e4.printStackTrace();
			} catch (ProveedorNoExisteException e4) {
				// TODO Auto-generated catch block
				e4.printStackTrace();
			}
		

		// Crear el modelo de tabla y agregar las columnas correspondientes a los datos
		final DefaultTableModel model = new DefaultTableModel();
		model.addColumn("Marca");
		model.addColumn("Modelo");
		model.addColumn("EAN");
		model.addColumn("Color");
		model.addColumn("Descripcion");
		model.addColumn("Precio");
		model.addColumn("Calorias");
		model.addColumn("Proveedor");

		// Agregar las filas con los datos de la alimentacion
		for (Alimentacion alimentacion : todaLaAlimentacion) {
			model.addRow(new Object[] { alimentacion.getMarca(), alimentacion.getModelo(),
					String.valueOf(alimentacion.getEan()), alimentacion.getColor(), alimentacion.getDescripcion(),
					String.valueOf(alimentacion.getPrecio()), alimentacion.getCalorias(),
					alimentacion.getProveedor().getNombre() });
		}

		// Crear la tabla con el modelo de datos
		final JTable tablaAlimentacion = new JTable(model);

		// Establecer la tabla como contenido visible del JScrollPane
		scrollPane.setViewportView(tablaAlimentacion);
		
		JButton botonAceptar = new JButton("Aceptar");
		botonAceptar.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		    	if (tablaAlimentacion.getCellEditor() != null) {
	                tablaAlimentacion.getCellEditor().stopCellEditing();
	            }
		        	
		        	
		            // Obtener los datos seleccionados en la tabla
		        	String marca = (String) model.getValueAt(tablaAlimentacion.getSelectedRow(), 0);
		            String modelo = (String) model.getValueAt(tablaAlimentacion.getSelectedRow(), 1);
		            String color = (String) model.getValueAt(tablaAlimentacion.getSelectedRow(), 3);
		            String eanStr = (String) model.getValueAt(tablaAlimentacion.getSelectedRow(), 2);
		            Integer eanInt;
		            try {
		                eanInt = Integer.parseInt(eanStr);
		            } catch (NumberFormatException ex) {
		                // El valor en la tabla no es un número válido
		                // Asigna un valor predeterminado o muestra un mensaje de error según sea necesario
		                eanInt = 0; // Por ejemplo, asignamos 0 como valor predeterminado
		            }
		            String descripcion = (String) model.getValueAt(tablaAlimentacion.getSelectedRow(), 4);
		            String precioStr = (String) model.getValueAt(tablaAlimentacion.getSelectedRow(), 5);
		            Float precioFloat;
		            try {
		                precioFloat = Float.parseFloat(precioStr);
		            } catch (NumberFormatException ex) {
		                // El valor en la tabla no es un número válido
		                // Asigna un valor predeterminado o muestra un mensaje de error según sea necesario
		                precioFloat = 0.0f; // Por ejemplo, asignamos 0.0 como valor predeterminado
		            }
		            String calorias = (String) model.getValueAt(tablaAlimentacion.getSelectedRow(), 6);
		            String nombreProveedor = (String) model.getValueAt(tablaAlimentacion.getSelectedRow(), 7);

		            // Crear los HashMap de datos a modificar y restricciones
		            HashMap<String, Object> datosAModificar = new HashMap<>();
		            datosAModificar.put("marca", marca);
		            datosAModificar.put("modelo", modelo);
		            datosAModificar.put("color", color);
		            datosAModificar.put("ean", eanInt);
		            datosAModificar.put("descripcion", descripcion);
		            datosAModificar.put("precio", precioFloat);
		            datosAModificar.put("calorias", calorias);
		            datosAModificar.put("nombre_proveedor", nombreProveedor);

		            HashMap<String, Object> restricciones = new HashMap<>();
		            // Agrega las restricciones necesarias para identificar el registro a modificar
		            restricciones.put("ean", eanInt);
		            
		           

		            try {
		                DAO.actualizar("alimentacion", datosAModificar, restricciones);
		                DAO.actualizar("productos", datosAModificar, restricciones);
		                String mensaje="El producto se ha actualizado con éxito:\n" +
		                        "Marca: " + marca + "\n" +
		                        "Modelo: " + modelo + "\n"+
		                        "Color: " + color + "\n" +
		                        "EAN: " + eanInt + "\n" +
		                        "Descripción: " + descripcion + "\n" +
		                        "Precio: " + precioFloat + "\n" +
		                        "Calorias: " + calorias + "\n" +
		                        "Proveedor: " + nombreProveedor + "\n" ;
		                JOptionPane.showMessageDialog(ventana, mensaje,
		                		"Producto modificado correctamente", JOptionPane.INFORMATION_MESSAGE);
		                
		            } catch (SQLIntegrityConstraintViolationException e1) {
						JOptionPane.showMessageDialog(ventana, "Este EAN ya figura en la base de datos", "¡Ups, algo salió mal!",
								JOptionPane.ERROR_MESSAGE);

					} catch (SQLException e2) {
						JOptionPane.showMessageDialog(ventana, e2.getMessage(), "No se puede conectar a la base de datos",
								JOptionPane.ERROR_MESSAGE);
						e2.printStackTrace();

					} catch (NumberFormatException e3) {
						JOptionPane.showMessageDialog(ventana, "Tienes que poner un número que sea número", "Error",
								JOptionPane.ERROR_MESSAGE);
					}
		        
		    }
		});

		
		botonAceptar.setForeground(new Color(78, 1, 23));
		botonAceptar.setFont(new Font("Eras Medium ITC", Font.PLAIN, 25));
		botonAceptar.setBackground(new Color(245, 196, 74));
		botonAceptar.setBounds(552, 571, 145, 32);
		add(botonAceptar);

		JButton botonAtras = new JButton("Cancelar");
		botonAtras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ventana.cambiarAPantalla(PantallaAdministracion.class);
			}
		});
		botonAtras.setForeground(new Color(78, 1, 23));
		botonAtras.setFont(new Font("Eras Medium ITC", Font.PLAIN, 25));
		botonAtras.setBackground(new Color(245, 196, 74));
		botonAtras.setBounds(100, 571, 145, 32);
		add(botonAtras);

		JLabel lblEligeQueProveedor = new JLabel("Elige que producto quieres modificar,");
		lblEligeQueProveedor.setHorizontalAlignment(SwingConstants.CENTER);
		lblEligeQueProveedor.setForeground(new Color(245, 196, 74));
		lblEligeQueProveedor.setFont(new Font("Eras Medium ITC", Font.BOLD, 25));
		lblEligeQueProveedor.setBackground(new Color(245, 196, 74));
		lblEligeQueProveedor.setBounds(100, 120, 600, 32);
		add(lblEligeQueProveedor);

		JLabel lblYPulsaAceptar = new JLabel("y pulsa aceptar para confirmar.");
		lblYPulsaAceptar.setHorizontalAlignment(SwingConstants.CENTER);
		lblYPulsaAceptar.setForeground(new Color(245, 196, 74));
		lblYPulsaAceptar.setFont(new Font("Eras Medium ITC", Font.BOLD, 25));
		lblYPulsaAceptar.setBackground(new Color(245, 196, 74));
		lblYPulsaAceptar.setBounds(100, 207, 600, 32);
		add(lblYPulsaAceptar);
		
		JLabel lblModificaElO = new JLabel("modifica el campo, o los campos, que quieras");
		lblModificaElO.setHorizontalAlignment(SwingConstants.CENTER);
		lblModificaElO.setForeground(new Color(245, 196, 74));
		lblModificaElO.setFont(new Font("Eras Medium ITC", Font.BOLD, 25));
		lblModificaElO.setBackground(new Color(245, 196, 74));
		lblModificaElO.setBounds(100, 164, 600, 32);
		add(lblModificaElO);

	}
}
