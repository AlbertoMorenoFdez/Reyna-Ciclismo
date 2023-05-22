package interfaces;

import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import clases.Accesorio;
import clases.Alimentacion;
import clases.Bicicleta;
import clases.Producto;
import clases.Proveedor;
import excepciones.ProveedorNoExisteException;

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
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;

public class PantallaPreviaModificarProducto extends JPanel {
	private Ventana ventana;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JComboBox comboBoxTipoBicicleta;

	public PantallaPreviaModificarProducto(Ventana v) {
		this.ventana = v;
		setSize(800, 700);
		setBackground(new Color(78, 1, 23));
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 70, 178, 135, 123, 148, 70, 0 };
		gridBagLayout.rowHeights = new int[] { 50, 58, 84, 0, 0, 250, 128, 0, 32, 50, 0 };
		gridBagLayout.columnWeights = new double[] { 0.0, 1.0, 1.0, 1.0, 1.0, 0.0, Double.MIN_VALUE };
		gridBagLayout.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		setLayout(gridBagLayout);

		JLabel etiquetaAltaProducto = new JLabel("MODIFICAR PRODUCTO");
		etiquetaAltaProducto.setHorizontalAlignment(SwingConstants.CENTER);
		etiquetaAltaProducto.setForeground(new Color(245, 196, 74));
		etiquetaAltaProducto.setFont(new Font("Eras Medium ITC", Font.BOLD, 50));
		etiquetaAltaProducto.setBackground(new Color(245, 196, 74));
		GridBagConstraints gbc_etiquetaAltaProducto = new GridBagConstraints();
		gbc_etiquetaAltaProducto.anchor = GridBagConstraints.NORTH;
		gbc_etiquetaAltaProducto.fill = GridBagConstraints.HORIZONTAL;
		gbc_etiquetaAltaProducto.insets = new Insets(0, 0, 5, 5);
		gbc_etiquetaAltaProducto.gridwidth = 4;
		gbc_etiquetaAltaProducto.gridx = 1;
		gbc_etiquetaAltaProducto.gridy = 1;
		add(etiquetaAltaProducto, gbc_etiquetaAltaProducto);

		JLabel etiquetacategoria = new JLabel("¿Qué categoría quieres modificar?");
		etiquetacategoria.setFont(new Font("Eras Medium ITC", Font.PLAIN, 15));
		etiquetacategoria.setForeground(new Color(245, 196, 75));
		GridBagConstraints gbc_etiquetacategoria = new GridBagConstraints();
		gbc_etiquetacategoria.fill = GridBagConstraints.HORIZONTAL;
		gbc_etiquetacategoria.insets = new Insets(0, 0, 5, 5);
		gbc_etiquetacategoria.gridx = 1;
		gbc_etiquetacategoria.gridy = 3;
		add(etiquetacategoria, gbc_etiquetacategoria);

		final JRadioButton radioBotonBicicleta = new JRadioButton("Bicicleta");
		buttonGroup.add(radioBotonBicicleta);
		radioBotonBicicleta.setHorizontalAlignment(SwingConstants.CENTER);
		radioBotonBicicleta.setBackground(new Color(245, 196, 75));
		radioBotonBicicleta.setFont(new Font("Eras Medium ITC", Font.PLAIN, 15));
		GridBagConstraints gbc_radioBotonBicicleta = new GridBagConstraints();
		gbc_radioBotonBicicleta.fill = GridBagConstraints.VERTICAL;
		gbc_radioBotonBicicleta.insets = new Insets(0, 0, 5, 5);
		gbc_radioBotonBicicleta.gridx = 2;
		gbc_radioBotonBicicleta.gridy = 3;
		add(radioBotonBicicleta, gbc_radioBotonBicicleta);

		radioBotonBicicleta.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JScrollPane scrollPane = new JScrollPane();
				scrollPane.setBounds(100, 193, 600, 250);
				add(scrollPane);

				ArrayList<Bicicleta> bicicletas = null;

				try {
					bicicletas = Bicicleta.getTodos();
				} catch (SQLException | ProveedorNoExisteException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

				// Crear el modelo de tabla y agregar las columnas correspondientes a los datos
				DefaultTableModel model = new DefaultTableModel();
				model.addColumn("marca");
				model.addColumn("modelo");
				model.addColumn("color");
				model.addColumn("descripcion");
				model.addColumn("ean");
				model.addColumn("precio");
				model.addColumn("modalidad");
				model.addColumn("talla_bicicleta");
				model.addColumn("nombre_proveedor");
				// Agregar las filas con los datos de los usuarios
				for (Bicicleta bicicleta : bicicletas) {
					model.addRow(new Object[] { bicicleta.getMarca(), bicicleta.getModelo(), bicicleta.getColor(),
							bicicleta.getDescripcion(), bicicleta.getEan(), bicicleta.getPrecio(),
							bicicleta.getModalidad(), bicicleta.getTallaBicicleta(), bicicleta.getProveedor() });
				}

				// Crear la tabla con el modelo de datos
				JTable tablaBicicletas = new JTable(model);

				// Establecer la tabla como contenido visible del JScrollPane
				scrollPane.setViewportView(tablaBicicletas);

				
			}
		});

		final JRadioButton radioBotonAlimentacion = new JRadioButton("Alimentación");
		buttonGroup.add(radioBotonAlimentacion);
		radioBotonAlimentacion.setHorizontalAlignment(SwingConstants.CENTER);
		radioBotonAlimentacion.setFont(new Font("Eras Medium ITC", Font.PLAIN, 15));
		radioBotonAlimentacion.setBackground(new Color(245, 196, 75));
		GridBagConstraints gbc_radioBotonAlimentacion = new GridBagConstraints();
		gbc_radioBotonAlimentacion.fill = GridBagConstraints.VERTICAL;
		gbc_radioBotonAlimentacion.insets = new Insets(0, 0, 5, 5);
		gbc_radioBotonAlimentacion.gridx = 3;
		gbc_radioBotonAlimentacion.gridy = 3;
		add(radioBotonAlimentacion, gbc_radioBotonAlimentacion);

		radioBotonAlimentacion.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JScrollPane scrollPane = new JScrollPane();
				scrollPane.setBounds(100, 193, 600, 250);
				add(scrollPane);

				ArrayList<Alimentacion> todoAlimentacion = null;

				try {
					todoAlimentacion = Alimentacion.getTodos();
				} catch (SQLException | ProveedorNoExisteException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

				// Crear el modelo de tabla y agregar las columnas correspondientes a los datos
				DefaultTableModel model = new DefaultTableModel();
				model.addColumn("marca");
				model.addColumn("modelo");
				model.addColumn("color");
				model.addColumn("descripcion");
				model.addColumn("ean");
				model.addColumn("precio");
				model.addColumn("calorias");
				model.addColumn("nombre_proveedor");
				// Agregar las filas con los datos de los usuarios
				for (Alimentacion alimentacion : todoAlimentacion) {
					model.addRow(new Object[] { alimentacion.getMarca(), alimentacion.getModelo(), alimentacion.getColor(),
							alimentacion.getDescripcion(), alimentacion.getEan(), alimentacion.getPrecio(),
							alimentacion.getCalorias(), alimentacion.getProveedor() });
				}

				// Crear la tabla con el modelo de datos
				JTable tablaAlimentacion = new JTable(model);

				// Establecer la tabla como contenido visible del JScrollPane
				scrollPane.setViewportView(tablaAlimentacion);

				
			}

		});

		final JRadioButton radioBotonAccesorio = new JRadioButton("Accesorio");
		buttonGroup.add(radioBotonAccesorio);
		radioBotonAccesorio.setHorizontalAlignment(SwingConstants.CENTER);
		radioBotonAccesorio.setFont(new Font("Eras Medium ITC", Font.PLAIN, 15));
		radioBotonAccesorio.setBackground(new Color(245, 196, 75));
		GridBagConstraints gbc_radioBotonAccesorio = new GridBagConstraints();
		gbc_radioBotonAccesorio.fill = GridBagConstraints.VERTICAL;
		gbc_radioBotonAccesorio.insets = new Insets(0, 0, 5, 5);
		gbc_radioBotonAccesorio.gridx = 4;
		gbc_radioBotonAccesorio.gridy = 3;
		add(radioBotonAccesorio, gbc_radioBotonAccesorio);

		radioBotonAccesorio.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JScrollPane scrollPane = new JScrollPane();
				scrollPane.setBounds(100, 193, 600, 250);
				add(scrollPane);

				ArrayList<Accesorio> todoAccesorio = null;

				try {
					todoAccesorio = Accesorio.getTodos();
				} catch (SQLException | ProveedorNoExisteException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

				// Crear el modelo de tabla y agregar las columnas correspondientes a los datos
				DefaultTableModel model = new DefaultTableModel();
				model.addColumn("marca");
				model.addColumn("modelo");
				model.addColumn("color");
				model.addColumn("descripcion");
				model.addColumn("ean");
				model.addColumn("precio");
				model.addColumn("talla_accesorio");
				model.addColumn("nombre_proveedor");
				// Agregar las filas con los datos de los usuarios
				for (Accesorio accesorio : todoAccesorio) {
					model.addRow(new Object[] { accesorio.getMarca(), accesorio.getModelo(), accesorio.getColor(),
							accesorio.getDescripcion(), accesorio.getEan(), accesorio.getPrecio(),
							accesorio.getTalla(), accesorio.getProveedor() });
				}

				// Crear la tabla con el modelo de datos
				JTable tablaAccesorio = new JTable(model);

				// Establecer la tabla como contenido visible del JScrollPane
				scrollPane.setViewportView(tablaAccesorio);

				
			}
		});

		JButton botonAceptar = new JButton("Aceptar");
		botonAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ventana.cambiarAPantalla(PantallaModificarProducto.class);

			}
		});

		JButton botonCancelar = new JButton("Cancelar");
		botonCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ventana.cambiarAPantalla(PantallaAdministracion.class);
			}
		});
		botonCancelar.setForeground(new Color(78, 1, 23));
		botonCancelar.setFont(new Font("Eras Medium ITC", Font.PLAIN, 25));
		botonCancelar.setBackground(new Color(245, 196, 74));
		GridBagConstraints gbc_botonCancelar = new GridBagConstraints();
		gbc_botonCancelar.fill = GridBagConstraints.BOTH;
		gbc_botonCancelar.insets = new Insets(0, 0, 5, 5);
		gbc_botonCancelar.gridx = 1;
		gbc_botonCancelar.gridy = 8;
		add(botonCancelar, gbc_botonCancelar);
		botonAceptar.setForeground(new Color(78, 1, 23));
		botonAceptar.setFont(new Font("Eras Medium ITC", Font.PLAIN, 25));
		botonAceptar.setBackground(new Color(245, 196, 74));
		GridBagConstraints gbc_botonAceptar = new GridBagConstraints();
		gbc_botonAceptar.insets = new Insets(0, 0, 5, 5);
		gbc_botonAceptar.fill = GridBagConstraints.BOTH;
		gbc_botonAceptar.gridx = 4;
		gbc_botonAceptar.gridy = 8;
		add(botonAceptar, gbc_botonAceptar);

	}
}
