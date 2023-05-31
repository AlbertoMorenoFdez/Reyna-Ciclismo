package interfaces;

import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;

import clases.Accesorio;
import clases.Alimentacion;
import clases.Bicicleta;
import clases.Producto;
import enumReyna.ModalidadBicicleta;
import excepciones.ProveedorNoExisteException;

import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;

public class PantallaAltaProducto extends JPanel {
	private Ventana ventana;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JTextField campoMarca;
	private JTextField campoModelo;
	private JTextField campoColor;
	private JTextArea textAreaDescripcion;
	private JTextField campoEAN;
	private JTextField campoPrecio;
	private JTextField campoCalorias;
	private JComboBox comboBoxTallaBicicleta;
	private JComboBox comboBoxTipoBicicleta;
	private JTextField campoTalla;
	private JTextField campoProveedor;

	public PantallaAltaProducto(Ventana v) {
		this.ventana = v;
		setSize(800, 700);
		setBackground(new Color(78, 1, 23));
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 50, 179, 170, 115, 147, 50, 0 };
		gridBagLayout.rowHeights = new int[] { 51, 58, 36, 24, 20, 20, 20, 20, 87, 20, 23, 23, 20, 20, 20, 45, 32, 50,
				0 };
		gridBagLayout.columnWeights = new double[] { 0.0, 1.0, 1.0, 1.0, 1.0, 0.0, Double.MIN_VALUE };
		gridBagLayout.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0,
				0.0, 1.0, 0.0, 0.0, Double.MIN_VALUE };
		setLayout(gridBagLayout);
		
		JLabel lblNewLabel = new JLabel("Estas conectado como "+ventana.usuarioLogueado.getNombre());
		lblNewLabel.setForeground(new Color(245, 196, 74));
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.gridwidth = 2;
		gbc_lblNewLabel.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 1;
		gbc_lblNewLabel.gridy = 0;
		add(lblNewLabel, gbc_lblNewLabel);

		JLabel etiquetaAltaProducto = new JLabel("ALTA DE PRODUCTO");
		etiquetaAltaProducto.setHorizontalAlignment(SwingConstants.CENTER);
		etiquetaAltaProducto.setForeground(new Color(245, 196, 74));
		etiquetaAltaProducto.setFont(new Font("Eras Medium ITC", Font.BOLD, 50));
		etiquetaAltaProducto.setBackground(new Color(245, 196, 74));
		GridBagConstraints gbc_etiquetaAltaProducto = new GridBagConstraints();
		gbc_etiquetaAltaProducto.anchor = GridBagConstraints.NORTH;
		gbc_etiquetaAltaProducto.insets = new Insets(0, 0, 5, 5);
		gbc_etiquetaAltaProducto.gridwidth = 4;
		gbc_etiquetaAltaProducto.gridx = 1;
		gbc_etiquetaAltaProducto.gridy = 1;
		add(etiquetaAltaProducto, gbc_etiquetaAltaProducto);

		JLabel etiquetaTipoArticulo = new JLabel("¿Qué quieres dar de alta?");
		etiquetaTipoArticulo.setFont(new Font("Eras Medium ITC", Font.PLAIN, 15));
		etiquetaTipoArticulo.setForeground(new Color(245, 196, 75));
		GridBagConstraints gbc_etiquetaTipoArticulo = new GridBagConstraints();
		gbc_etiquetaTipoArticulo.fill = GridBagConstraints.HORIZONTAL;
		gbc_etiquetaTipoArticulo.insets = new Insets(0, 0, 5, 5);
		gbc_etiquetaTipoArticulo.gridx = 1;
		gbc_etiquetaTipoArticulo.gridy = 3;
		add(etiquetaTipoArticulo, gbc_etiquetaTipoArticulo);

		final JRadioButton radioBotonBicicleta = new JRadioButton("Bicicleta");
		buttonGroup.add(radioBotonBicicleta);
		radioBotonBicicleta.setHorizontalAlignment(SwingConstants.CENTER);
		radioBotonBicicleta.setBackground(new Color(245, 196, 75));
		radioBotonBicicleta.setFont(new Font("Eras Medium ITC", Font.PLAIN, 15));
		GridBagConstraints gbc_radioBotonBicicleta = new GridBagConstraints();
		gbc_radioBotonBicicleta.anchor = GridBagConstraints.WEST;
		gbc_radioBotonBicicleta.fill = GridBagConstraints.VERTICAL;
		gbc_radioBotonBicicleta.insets = new Insets(0, 0, 5, 5);
		gbc_radioBotonBicicleta.gridx = 2;
		gbc_radioBotonBicicleta.gridy = 3;
		add(radioBotonBicicleta, gbc_radioBotonBicicleta);

		radioBotonBicicleta.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				campoCalorias.setEnabled(false);
				campoTalla.setEnabled(false);
			}
		});

		final JRadioButton radioBotonAlimentacion = new JRadioButton("Alimentación");
		buttonGroup.add(radioBotonAlimentacion);
		radioBotonAlimentacion.setHorizontalAlignment(SwingConstants.CENTER);
		radioBotonAlimentacion.setFont(new Font("Eras Medium ITC", Font.PLAIN, 15));
		radioBotonAlimentacion.setBackground(new Color(245, 196, 75));
		GridBagConstraints gbc_radioBotonAlimentacion = new GridBagConstraints();
		gbc_radioBotonAlimentacion.anchor = GridBagConstraints.WEST;
		gbc_radioBotonAlimentacion.fill = GridBagConstraints.VERTICAL;
		gbc_radioBotonAlimentacion.insets = new Insets(0, 0, 5, 5);
		gbc_radioBotonAlimentacion.gridx = 3;
		gbc_radioBotonAlimentacion.gridy = 3;
		add(radioBotonAlimentacion, gbc_radioBotonAlimentacion);

		radioBotonAlimentacion.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				comboBoxTipoBicicleta.setEnabled(false);
				comboBoxTallaBicicleta.setEnabled(false);
				campoTalla.setEnabled(false);
			}

		});

		final JRadioButton radioBotonAccesorio = new JRadioButton("Accesorio");
		buttonGroup.add(radioBotonAccesorio);
		radioBotonAccesorio.setHorizontalAlignment(SwingConstants.CENTER);
		radioBotonAccesorio.setFont(new Font("Eras Medium ITC", Font.PLAIN, 15));
		radioBotonAccesorio.setBackground(new Color(245, 196, 75));
		GridBagConstraints gbc_radioBotonAccesorio = new GridBagConstraints();
		gbc_radioBotonAccesorio.anchor = GridBagConstraints.EAST;
		gbc_radioBotonAccesorio.fill = GridBagConstraints.VERTICAL;
		gbc_radioBotonAccesorio.insets = new Insets(0, 0, 5, 5);
		gbc_radioBotonAccesorio.gridx = 4;
		gbc_radioBotonAccesorio.gridy = 3;
		add(radioBotonAccesorio, gbc_radioBotonAccesorio);

		radioBotonAccesorio.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				comboBoxTipoBicicleta.setEnabled(false);
				comboBoxTallaBicicleta.setEnabled(false);
				campoCalorias.setEnabled(false);
			}
		});

		JLabel etiquetaMarca = new JLabel("Marca:");
		etiquetaMarca.setForeground(new Color(245, 196, 75));
		etiquetaMarca.setFont(new Font("Eras Medium ITC", Font.PLAIN, 15));
		GridBagConstraints gbc_etiquetaMarca = new GridBagConstraints();
		gbc_etiquetaMarca.anchor = GridBagConstraints.NORTH;
		gbc_etiquetaMarca.fill = GridBagConstraints.HORIZONTAL;
		gbc_etiquetaMarca.insets = new Insets(0, 0, 5, 5);
		gbc_etiquetaMarca.gridx = 1;
		gbc_etiquetaMarca.gridy = 4;
		add(etiquetaMarca, gbc_etiquetaMarca);

		campoMarca = new JTextField();
		GridBagConstraints gbc_campoMarca = new GridBagConstraints();
		gbc_campoMarca.anchor = GridBagConstraints.NORTH;
		gbc_campoMarca.fill = GridBagConstraints.HORIZONTAL;
		gbc_campoMarca.insets = new Insets(0, 0, 5, 5);
		gbc_campoMarca.gridwidth = 3;
		gbc_campoMarca.gridx = 2;
		gbc_campoMarca.gridy = 4;
		add(campoMarca, gbc_campoMarca);
		campoMarca.setColumns(10);

		JLabel etiquetaModelo = new JLabel("Modelo");
		etiquetaModelo.setForeground(new Color(245, 196, 75));
		etiquetaModelo.setFont(new Font("Eras Medium ITC", Font.PLAIN, 15));
		GridBagConstraints gbc_etiquetaModelo = new GridBagConstraints();
		gbc_etiquetaModelo.anchor = GridBagConstraints.NORTH;
		gbc_etiquetaModelo.fill = GridBagConstraints.HORIZONTAL;
		gbc_etiquetaModelo.insets = new Insets(0, 0, 5, 5);
		gbc_etiquetaModelo.gridx = 1;
		gbc_etiquetaModelo.gridy = 5;
		add(etiquetaModelo, gbc_etiquetaModelo);

		campoModelo = new JTextField();
		campoModelo.setColumns(10);
		GridBagConstraints gbc_campoModelo = new GridBagConstraints();
		gbc_campoModelo.anchor = GridBagConstraints.NORTH;
		gbc_campoModelo.fill = GridBagConstraints.HORIZONTAL;
		gbc_campoModelo.insets = new Insets(0, 0, 5, 5);
		gbc_campoModelo.gridwidth = 3;
		gbc_campoModelo.gridx = 2;
		gbc_campoModelo.gridy = 5;
		add(campoModelo, gbc_campoModelo);

		JLabel etiquetaEAN = new JLabel("EAN");
		etiquetaEAN.setForeground(new Color(245, 196, 75));
		etiquetaEAN.setFont(new Font("Eras Medium ITC", Font.PLAIN, 15));
		GridBagConstraints gbc_etiquetaEAN = new GridBagConstraints();
		gbc_etiquetaEAN.anchor = GridBagConstraints.NORTH;
		gbc_etiquetaEAN.fill = GridBagConstraints.HORIZONTAL;
		gbc_etiquetaEAN.insets = new Insets(0, 0, 5, 5);
		gbc_etiquetaEAN.gridx = 1;
		gbc_etiquetaEAN.gridy = 6;
		add(etiquetaEAN, gbc_etiquetaEAN);

		campoEAN = new JTextField();
		campoEAN.setColumns(10);
		GridBagConstraints gbc_campoEAN = new GridBagConstraints();
		gbc_campoEAN.anchor = GridBagConstraints.NORTH;
		gbc_campoEAN.fill = GridBagConstraints.HORIZONTAL;
		gbc_campoEAN.insets = new Insets(0, 0, 5, 5);
		gbc_campoEAN.gridwidth = 2;
		gbc_campoEAN.gridx = 2;
		gbc_campoEAN.gridy = 6;
		add(campoEAN, gbc_campoEAN);

		JLabel etiquetaColor = new JLabel("Color");
		etiquetaColor.setForeground(new Color(245, 196, 75));
		etiquetaColor.setFont(new Font("Eras Medium ITC", Font.PLAIN, 15));
		GridBagConstraints gbc_etiquetaColor = new GridBagConstraints();
		gbc_etiquetaColor.anchor = GridBagConstraints.NORTH;
		gbc_etiquetaColor.fill = GridBagConstraints.HORIZONTAL;
		gbc_etiquetaColor.insets = new Insets(0, 0, 5, 5);
		gbc_etiquetaColor.gridx = 1;
		gbc_etiquetaColor.gridy = 7;
		add(etiquetaColor, gbc_etiquetaColor);

		campoColor = new JTextField();
		campoColor.setColumns(10);
		GridBagConstraints gbc_campoColor = new GridBagConstraints();
		gbc_campoColor.anchor = GridBagConstraints.NORTH;
		gbc_campoColor.fill = GridBagConstraints.HORIZONTAL;
		gbc_campoColor.insets = new Insets(0, 0, 5, 5);
		gbc_campoColor.gridwidth = 2;
		gbc_campoColor.gridx = 2;
		gbc_campoColor.gridy = 7;
		add(campoColor, gbc_campoColor);

		JLabel etiquetaDescripcion = new JLabel("Descripción");
		etiquetaDescripcion.setForeground(new Color(245, 196, 75));
		etiquetaDescripcion.setFont(new Font("Eras Medium ITC", Font.PLAIN, 15));
		GridBagConstraints gbc_etiquetaDescripcion = new GridBagConstraints();
		gbc_etiquetaDescripcion.anchor = GridBagConstraints.NORTH;
		gbc_etiquetaDescripcion.fill = GridBagConstraints.HORIZONTAL;
		gbc_etiquetaDescripcion.insets = new Insets(0, 0, 5, 5);
		gbc_etiquetaDescripcion.gridx = 1;
		gbc_etiquetaDescripcion.gridy = 8;
		add(etiquetaDescripcion, gbc_etiquetaDescripcion);

		JScrollPane scrollPane = new JScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.insets = new Insets(0, 0, 5, 5);
		gbc_scrollPane.gridwidth = 3;
		gbc_scrollPane.gridx = 2;
		gbc_scrollPane.gridy = 8;
		add(scrollPane, gbc_scrollPane);

		textAreaDescripcion = new JTextArea();
		textAreaDescripcion.setFont(new Font("Arial", Font.PLAIN, 15));
		scrollPane.setViewportView(textAreaDescripcion);

		JLabel etiquetaPrecio = new JLabel("Precio");
		etiquetaPrecio.setForeground(new Color(245, 196, 75));
		etiquetaPrecio.setFont(new Font("Eras Medium ITC", Font.PLAIN, 15));
		GridBagConstraints gbc_etiquetaPrecio = new GridBagConstraints();
		gbc_etiquetaPrecio.anchor = GridBagConstraints.SOUTH;
		gbc_etiquetaPrecio.fill = GridBagConstraints.HORIZONTAL;
		gbc_etiquetaPrecio.insets = new Insets(0, 0, 5, 5);
		gbc_etiquetaPrecio.gridx = 1;
		gbc_etiquetaPrecio.gridy = 9;
		add(etiquetaPrecio, gbc_etiquetaPrecio);

		campoPrecio = new JTextField();
		campoPrecio.setColumns(10);
		GridBagConstraints gbc_campoPrecio = new GridBagConstraints();
		gbc_campoPrecio.anchor = GridBagConstraints.NORTH;
		gbc_campoPrecio.fill = GridBagConstraints.HORIZONTAL;
		gbc_campoPrecio.insets = new Insets(0, 0, 5, 5);
		gbc_campoPrecio.gridx = 2;
		gbc_campoPrecio.gridy = 9;
		add(campoPrecio, gbc_campoPrecio);

		JLabel etiquetaModalidadBicicleta = new JLabel("Tipo de Bicicleta");
		etiquetaModalidadBicicleta.setForeground(new Color(245, 196, 75));
		etiquetaModalidadBicicleta.setFont(new Font("Eras Medium ITC", Font.PLAIN, 15));
		GridBagConstraints gbc_etiquetaModalidadBicicleta = new GridBagConstraints();
		gbc_etiquetaModalidadBicicleta.fill = GridBagConstraints.HORIZONTAL;
		gbc_etiquetaModalidadBicicleta.insets = new Insets(0, 0, 5, 5);
		gbc_etiquetaModalidadBicicleta.gridx = 1;
		gbc_etiquetaModalidadBicicleta.gridy = 10;
		add(etiquetaModalidadBicicleta, gbc_etiquetaModalidadBicicleta);

		comboBoxTipoBicicleta = new JComboBox();
		comboBoxTipoBicicleta
				.setModel(new DefaultComboBoxModel(new String[] {"MTB", "CARRETERA", "EBIKE", "URBAN"}));
		comboBoxTipoBicicleta.setFont(new Font("Arial Black", Font.PLAIN, 15));
		GridBagConstraints gbc_comboBoxTipoBicicleta = new GridBagConstraints();
		gbc_comboBoxTipoBicicleta.fill = GridBagConstraints.BOTH;
		gbc_comboBoxTipoBicicleta.insets = new Insets(0, 0, 5, 5);
		gbc_comboBoxTipoBicicleta.gridx = 2;
		gbc_comboBoxTipoBicicleta.gridy = 10;
		add(comboBoxTipoBicicleta, gbc_comboBoxTipoBicicleta);

		JLabel etiquetaTallaBicicleta = new JLabel("Talla de Bicicleta");
		etiquetaTallaBicicleta.setForeground(new Color(245, 196, 75));
		etiquetaTallaBicicleta.setFont(new Font("Eras Medium ITC", Font.PLAIN, 15));
		GridBagConstraints gbc_etiquetaTallaBicicleta = new GridBagConstraints();
		gbc_etiquetaTallaBicicleta.fill = GridBagConstraints.HORIZONTAL;
		gbc_etiquetaTallaBicicleta.insets = new Insets(0, 0, 5, 5);
		gbc_etiquetaTallaBicicleta.gridx = 1;
		gbc_etiquetaTallaBicicleta.gridy = 11;
		add(etiquetaTallaBicicleta, gbc_etiquetaTallaBicicleta);

		comboBoxTallaBicicleta = new JComboBox();
		comboBoxTallaBicicleta.setModel(new DefaultComboBoxModel(new String[] { "XS", "S", "M", "L", "XL" }));
		comboBoxTallaBicicleta.setFont(new Font("Arial Black", Font.PLAIN, 15));
		GridBagConstraints gbc_comboBoxTallaBicicleta = new GridBagConstraints();
		gbc_comboBoxTallaBicicleta.fill = GridBagConstraints.BOTH;
		gbc_comboBoxTallaBicicleta.insets = new Insets(0, 0, 5, 5);
		gbc_comboBoxTallaBicicleta.gridx = 2;
		gbc_comboBoxTallaBicicleta.gridy = 11;
		add(comboBoxTallaBicicleta, gbc_comboBoxTallaBicicleta);

		JLabel etiquetaCalorias = new JLabel("Calorias");
		etiquetaCalorias.setForeground(new Color(245, 196, 75));
		etiquetaCalorias.setFont(new Font("Eras Medium ITC", Font.PLAIN, 15));
		GridBagConstraints gbc_etiquetaCalorias = new GridBagConstraints();
		gbc_etiquetaCalorias.anchor = GridBagConstraints.NORTH;
		gbc_etiquetaCalorias.fill = GridBagConstraints.HORIZONTAL;
		gbc_etiquetaCalorias.insets = new Insets(0, 0, 5, 5);
		gbc_etiquetaCalorias.gridx = 1;
		gbc_etiquetaCalorias.gridy = 12;
		add(etiquetaCalorias, gbc_etiquetaCalorias);

		campoCalorias = new JTextField();
		campoCalorias.setColumns(10);
		GridBagConstraints gbc_campoCalorias = new GridBagConstraints();
		gbc_campoCalorias.anchor = GridBagConstraints.NORTH;
		gbc_campoCalorias.fill = GridBagConstraints.HORIZONTAL;
		gbc_campoCalorias.insets = new Insets(0, 0, 5, 5);
		gbc_campoCalorias.gridx = 2;
		gbc_campoCalorias.gridy = 12;
		add(campoCalorias, gbc_campoCalorias);

		JLabel etiquetaTallaAccesorio = new JLabel("Talla");
		etiquetaTallaAccesorio.setForeground(new Color(245, 196, 75));
		etiquetaTallaAccesorio.setFont(new Font("Eras Medium ITC", Font.PLAIN, 15));
		GridBagConstraints gbc_etiquetaTallaAccesorio = new GridBagConstraints();
		gbc_etiquetaTallaAccesorio.anchor = GridBagConstraints.NORTH;
		gbc_etiquetaTallaAccesorio.fill = GridBagConstraints.HORIZONTAL;
		gbc_etiquetaTallaAccesorio.insets = new Insets(0, 0, 5, 5);
		gbc_etiquetaTallaAccesorio.gridx = 1;
		gbc_etiquetaTallaAccesorio.gridy = 13;
		add(etiquetaTallaAccesorio, gbc_etiquetaTallaAccesorio);

		campoTalla = new JTextField();
		campoTalla.setColumns(10);
		GridBagConstraints gbc_campoTalla = new GridBagConstraints();
		gbc_campoTalla.anchor = GridBagConstraints.NORTH;
		gbc_campoTalla.fill = GridBagConstraints.HORIZONTAL;
		gbc_campoTalla.insets = new Insets(0, 0, 5, 5);
		gbc_campoTalla.gridx = 2;
		gbc_campoTalla.gridy = 13;
		add(campoTalla, gbc_campoTalla);

		JLabel etiquetaProveedor = new JLabel("Proveedor");
		etiquetaProveedor.setForeground(new Color(245, 196, 75));
		etiquetaProveedor.setFont(new Font("Eras Medium ITC", Font.PLAIN, 15));
		GridBagConstraints gbc_etiquetaProveedor = new GridBagConstraints();
		gbc_etiquetaProveedor.anchor = GridBagConstraints.NORTH;
		gbc_etiquetaProveedor.fill = GridBagConstraints.HORIZONTAL;
		gbc_etiquetaProveedor.insets = new Insets(0, 0, 5, 5);
		gbc_etiquetaProveedor.gridx = 1;
		gbc_etiquetaProveedor.gridy = 14;
		add(etiquetaProveedor, gbc_etiquetaProveedor);

		campoProveedor = new JTextField();
		campoProveedor.setColumns(10);
		GridBagConstraints gbc_campoProveedor = new GridBagConstraints();
		gbc_campoProveedor.anchor = GridBagConstraints.NORTH;
		gbc_campoProveedor.fill = GridBagConstraints.HORIZONTAL;
		gbc_campoProveedor.insets = new Insets(0, 0, 5, 5);
		gbc_campoProveedor.gridwidth = 3;
		gbc_campoProveedor.gridx = 2;
		gbc_campoProveedor.gridy = 14;
		add(campoProveedor, gbc_campoProveedor);

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
		gbc_botonCancelar.anchor = GridBagConstraints.WEST;
		gbc_botonCancelar.fill = GridBagConstraints.VERTICAL;
		gbc_botonCancelar.insets = new Insets(0, 0, 5, 5);
		gbc_botonCancelar.gridx = 1;
		gbc_botonCancelar.gridy = 16;
		add(botonCancelar, gbc_botonCancelar);

		JButton botonAlta = new JButton("Alta");
		botonAlta.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				try {
					String marca = campoMarca.getText();
					String modelo = campoModelo.getText();
					int ean = Integer.parseInt("" + campoEAN.getText());
					String color = campoColor.getText();
					String descripcion = textAreaDescripcion.getText();
					float precio = Float.parseFloat("" + campoPrecio.getText().replace(",", "."));
					String modalidad = (String) comboBoxTipoBicicleta.getSelectedItem();
					String tallaBicicleta = (String) comboBoxTallaBicicleta.getSelectedItem();
					String calorias = campoCalorias.getText();
					String talla = "u"; // Valor por defecto si no se especifica la talla
					String campoTallaVacio = campoTalla.getText();
					if (!campoTallaVacio.isEmpty()) {
						talla = campoTallaVacio;
					}

					String proveedor = campoProveedor.getText();
					if (radioBotonBicicleta.isSelected()) {
						ModalidadBicicleta modBicicleta = ModalidadBicicleta.valueOf(modalidad);
						new Bicicleta(marca, modelo, color, descripcion, ean, precio, modBicicleta, tallaBicicleta,
								proveedor);
					} else if (radioBotonAlimentacion.isSelected()) {
						new Alimentacion(marca, modelo, color, descripcion, ean, precio, calorias, proveedor);
					} else if (radioBotonAccesorio.isSelected()) {
						new Accesorio(marca, modelo, color, descripcion, ean, precio, talla, proveedor);
					}
					JOptionPane.showMessageDialog(ventana, "Producto añadido correctamente", "¡Enhorabuena!",
							JOptionPane.INFORMATION_MESSAGE);
					// Para limpiar todos los campos
					campoMarca.setText("");
					campoModelo.setText("");
					campoEAN.setText("");
					campoColor.setText("");
					textAreaDescripcion.setText("");
					campoPrecio.setText("");
					comboBoxTipoBicicleta.setSelectedIndex(0);
					comboBoxTallaBicicleta.setSelectedIndex(0);
					campoCalorias.setText("");
					campoTalla.setText("");
					campoProveedor.setText("");
				} 
				catch (SQLIntegrityConstraintViolationException e1) {
					JOptionPane.showMessageDialog(ventana, "El producto ya está dado de alta", "¡Ups, algo salió mal!",
							JOptionPane.ERROR_MESSAGE);

				} 
				catch (SQLException e2) {
					JOptionPane.showMessageDialog(ventana, e2.getMessage(), "No se puede conectar a la base de datos",
							JOptionPane.ERROR_MESSAGE);
					e2.printStackTrace();

				} catch (NumberFormatException e3) {
					JOptionPane.showMessageDialog(ventana, "Olvidaste poner el CIF o la talla si procede", "Error",
							JOptionPane.ERROR_MESSAGE);
				} catch (ProveedorNoExisteException e4) {
					JOptionPane.showMessageDialog(ventana, "Tienes que indicar un proveedor existente", "Error",
							JOptionPane.ERROR_MESSAGE);
					e4.printStackTrace();
				}

			}
		});

		botonAlta.setForeground(new Color(78, 1, 23));
		botonAlta.setFont(new Font("Eras Medium ITC", Font.PLAIN, 25));
		botonAlta.setBackground(new Color(245, 196, 74));
		GridBagConstraints gbc_botonAlta = new GridBagConstraints();
		gbc_botonAlta.insets = new Insets(0, 0, 5, 5);
		gbc_botonAlta.fill = GridBagConstraints.BOTH;
		gbc_botonAlta.gridx = 4;
		gbc_botonAlta.gridy = 16;
		add(botonAlta, gbc_botonAlta);
	}
}
