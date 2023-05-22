package interfaces;

import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import clases.Proveedor;
import clases.Usuario;
import excepciones.NombreConNumeroException;

import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class PantallaPreviaModificarProveedor extends JPanel {
	private Ventana ventana;
	private final ButtonGroup buttonGroup = new ButtonGroup();

	public PantallaPreviaModificarProveedor(Ventana v) {
		this.ventana = v;
		setSize(800, 700);
		setBackground(new Color(78, 1, 23));
		setLayout(null);

		JLabel etiquetaModificarProveedor = new JLabel("MODIFICAR PROVEEDOR");
		etiquetaModificarProveedor.setHorizontalAlignment(SwingConstants.CENTER);
		etiquetaModificarProveedor.setForeground(new Color(245, 196, 74));
		etiquetaModificarProveedor.setFont(new Font("Eras Medium ITC", Font.BOLD, 50));
		etiquetaModificarProveedor.setBackground(new Color(245, 196, 74));
		etiquetaModificarProveedor.setBounds(100, 51, 600, 58);
		add(etiquetaModificarProveedor);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(100, 193, 600, 250);
		add(scrollPane);
		
		ArrayList<Proveedor> todosLosProveedores = null;
		
		try {
			todosLosProveedores=Proveedor.getTodos();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		// Crear el modelo de tabla y agregar las columnas correspondientes a los datos
				DefaultTableModel model = new DefaultTableModel();
				model.addColumn("Correo Electrónico");
				model.addColumn("Nombre");
				model.addColumn("Teléfono");
				model.addColumn("CIF");
				model.addColumn("Dirección");
				// Agregar las filas con los datos de los usuarios
				for (Proveedor proveedor  : todosLosProveedores) {
					model.addRow(new Object[] { proveedor.getEmailProveedor(), proveedor.getNombre(), proveedor.getTelefonoProveedor(),
							proveedor.getCIF(), proveedor.getDireccion() });
				}

				// Crear la tabla con el modelo de datos
				JTable tablaProveedores = new JTable(model);

				// Establecer la tabla como contenido visible del JScrollPane
				scrollPane.setViewportView(tablaProveedores);

		JButton botonAceptar = new JButton("Aceptar");
		botonAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ventana.cambiarAPantalla(PantallaModificarProveedor.class);
				
			}
		});
		botonAceptar.setForeground(new Color(78, 1, 23));
		botonAceptar.setFont(new Font("Eras Medium ITC", Font.PLAIN, 25));
		botonAceptar.setBackground(new Color(245, 196, 74));
		botonAceptar.setBounds(552, 571, 145, 32);
		add(botonAceptar);

		JButton botonAtras = new JButton("<-- Atrás");
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
		
		JLabel lblEligeQueProveedor = new JLabel("Elige que proveedor quieres modificar");
		lblEligeQueProveedor.setHorizontalAlignment(SwingConstants.CENTER);
		lblEligeQueProveedor.setForeground(new Color(245, 196, 74));
		lblEligeQueProveedor.setFont(new Font("Eras Medium ITC", Font.BOLD, 25));
		lblEligeQueProveedor.setBackground(new Color(245, 196, 74));
		lblEligeQueProveedor.setBounds(100, 150, 600, 32);
		add(lblEligeQueProveedor);
		
		JLabel lblYPulsaAceptar = new JLabel("y pulsa aceptar para continuar.");
		lblYPulsaAceptar.setHorizontalAlignment(SwingConstants.CENTER);
		lblYPulsaAceptar.setForeground(new Color(245, 196, 74));
		lblYPulsaAceptar.setFont(new Font("Eras Medium ITC", Font.BOLD, 25));
		lblYPulsaAceptar.setBackground(new Color(245, 196, 74));
		lblYPulsaAceptar.setBounds(100, 450, 600, 32);
		add(lblYPulsaAceptar);
	}
}
