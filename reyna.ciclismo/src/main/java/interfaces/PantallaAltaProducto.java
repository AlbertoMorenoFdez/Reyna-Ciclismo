package interfaces;

import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
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
		setLayout(null);

		JLabel etiquetaAltaProducto = new JLabel("ALTA DE PRODUCTO");
		etiquetaAltaProducto.setHorizontalAlignment(SwingConstants.CENTER);
		etiquetaAltaProducto.setForeground(new Color(245, 196, 74));
		etiquetaAltaProducto.setFont(new Font("Eras Medium ITC", Font.BOLD, 50));
		etiquetaAltaProducto.setBackground(new Color(245, 196, 74));
		etiquetaAltaProducto.setBounds(150, 51, 500, 58);
		add(etiquetaAltaProducto);

		JLabel etiquetaTipoArticulo = new JLabel("¿Que quieres dar de alta?");
		etiquetaTipoArticulo.setFont(new Font("Eras Medium ITC", Font.PLAIN, 15));
		etiquetaTipoArticulo.setForeground(new Color(245, 196, 75));
		etiquetaTipoArticulo.setBounds(41, 149, 179, 14);
		add(etiquetaTipoArticulo);

		JRadioButton radioBotonBicicleta = new JRadioButton("Bicicleta");
		buttonGroup.add(radioBotonBicicleta);
		radioBotonBicicleta.setHorizontalAlignment(SwingConstants.CENTER);
		radioBotonBicicleta.setBackground(new Color(245, 196, 75));
		radioBotonBicicleta.setFont(new Font("Eras Medium ITC", Font.PLAIN, 15));
		radioBotonBicicleta.setBounds(242, 146, 90, 23);
		add(radioBotonBicicleta);

		JRadioButton radioBotonAlimentacion = new JRadioButton("Alimentación");
		buttonGroup.add(radioBotonAlimentacion);
		radioBotonAlimentacion.setHorizontalAlignment(SwingConstants.CENTER);
		radioBotonAlimentacion.setFont(new Font("Eras Medium ITC", Font.PLAIN, 15));
		radioBotonAlimentacion.setBackground(new Color(245, 196, 75));
		radioBotonAlimentacion.setBounds(412, 145, 115, 23);
		add(radioBotonAlimentacion);

		JRadioButton radioBotonAccesorio = new JRadioButton("Accesorio");
		buttonGroup.add(radioBotonAccesorio);
		radioBotonAccesorio.setHorizontalAlignment(SwingConstants.CENTER);
		radioBotonAccesorio.setFont(new Font("Eras Medium ITC", Font.PLAIN, 15));
		radioBotonAccesorio.setBackground(new Color(245, 196, 75));
		radioBotonAccesorio.setBounds(601, 146, 115, 23);
		add(radioBotonAccesorio);

		JLabel etiquetaMarca = new JLabel("Marca:");
		etiquetaMarca.setForeground(new Color(245, 196, 75));
		etiquetaMarca.setFont(new Font("Eras Medium ITC", Font.PLAIN, 15));
		etiquetaMarca.setBounds(41, 200, 179, 14);
		add(etiquetaMarca);

		JLabel etiquetaModelo = new JLabel("Modelo");
		etiquetaModelo.setForeground(new Color(245, 196, 75));
		etiquetaModelo.setFont(new Font("Eras Medium ITC", Font.PLAIN, 15));
		etiquetaModelo.setBounds(41, 225, 179, 14);
		add(etiquetaModelo);

		JLabel etiquetaEAN = new JLabel("EAN");
		etiquetaEAN.setForeground(new Color(245, 196, 75));
		etiquetaEAN.setFont(new Font("Eras Medium ITC", Font.PLAIN, 15));
		etiquetaEAN.setBounds(41, 250, 179, 14);
		add(etiquetaEAN);

		JLabel etiquetaColor = new JLabel("Color");
		etiquetaColor.setForeground(new Color(245, 196, 75));
		etiquetaColor.setFont(new Font("Eras Medium ITC", Font.PLAIN, 15));
		etiquetaColor.setBounds(41, 275, 179, 14);
		add(etiquetaColor);

		JLabel etiquetaDescripcion = new JLabel("Descripción");
		etiquetaDescripcion.setForeground(new Color(245, 196, 75));
		etiquetaDescripcion.setFont(new Font("Eras Medium ITC", Font.PLAIN, 15));
		etiquetaDescripcion.setBounds(41, 300, 179, 14);
		add(etiquetaDescripcion);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(242, 296, 476, 87);
		add(scrollPane);

		textAreaDescripcion = new JTextArea();
		textAreaDescripcion.setFont(new Font("Arial", Font.PLAIN, 15));
		scrollPane.setViewportView(textAreaDescripcion);

		JLabel etiquetaPrecio = new JLabel("Precio");
		etiquetaPrecio.setForeground(new Color(245, 196, 75));
		etiquetaPrecio.setFont(new Font("Eras Medium ITC", Font.PLAIN, 15));
		etiquetaPrecio.setBounds(41, 418, 179, 14);
		add(etiquetaPrecio);

		JLabel etiquetaModalidadBicicleta = new JLabel("Tipo de Bicicleta");
		etiquetaModalidadBicicleta.setForeground(new Color(245, 196, 75));
		etiquetaModalidadBicicleta.setFont(new Font("Eras Medium ITC", Font.PLAIN, 15));
		etiquetaModalidadBicicleta.setBounds(41, 443, 179, 14);
		add(etiquetaModalidadBicicleta);

		comboBoxTipoBicicleta = new JComboBox();
		comboBoxTipoBicicleta
				.setModel(new DefaultComboBoxModel(new String[] { "MTB", "ROAD", "EBIKE", "URBAN", "INFANTIL" }));
		comboBoxTipoBicicleta.setFont(new Font("Arial Black", Font.PLAIN, 15));
		comboBoxTipoBicicleta.setBounds(242, 438, 170, 23);
		add(comboBoxTipoBicicleta);

		JLabel etiquetaTallaBicicleta = new JLabel("Talla de Bicicleta");
		etiquetaTallaBicicleta.setForeground(new Color(245, 196, 75));
		etiquetaTallaBicicleta.setFont(new Font("Eras Medium ITC", Font.PLAIN, 15));
		etiquetaTallaBicicleta.setBounds(41, 468, 179, 14);
		add(etiquetaTallaBicicleta);

		comboBoxTallaBicicleta = new JComboBox();
		comboBoxTallaBicicleta.setModel(new DefaultComboBoxModel(new String[] {"XS", "S", "M", "L", "XL"}));
		comboBoxTallaBicicleta.setFont(new Font("Arial Black", Font.PLAIN, 15));
		comboBoxTallaBicicleta.setBounds(242, 463, 170, 23);
		add(comboBoxTallaBicicleta);

		JLabel etiquetaCalorias = new JLabel("Calorias");
		etiquetaCalorias.setForeground(new Color(245, 196, 75));
		etiquetaCalorias.setFont(new Font("Eras Medium ITC", Font.PLAIN, 15));
		etiquetaCalorias.setBounds(41, 493, 179, 14);
		add(etiquetaCalorias);

		JLabel etiquetaTallaAccesorio = new JLabel("Talla");
		etiquetaTallaAccesorio.setForeground(new Color(245, 196, 75));
		etiquetaTallaAccesorio.setFont(new Font("Eras Medium ITC", Font.PLAIN, 15));
		etiquetaTallaAccesorio.setBounds(41, 518, 179, 14);
		add(etiquetaTallaAccesorio);

		JLabel etiquetaProveedor = new JLabel("Proveedor");
		etiquetaProveedor.setForeground(new Color(245, 196, 75));
		etiquetaProveedor.setFont(new Font("Eras Medium ITC", Font.PLAIN, 15));
		etiquetaProveedor.setBounds(41, 543, 179, 14);
		add(etiquetaProveedor);

		campoMarca = new JTextField();
		campoMarca.setBounds(242, 198, 474, 20);
		add(campoMarca);
		campoMarca.setColumns(10);

		campoModelo = new JTextField();
		campoModelo.setColumns(10);
		campoModelo.setBounds(242, 223, 474, 20);
		add(campoModelo);

		campoEAN = new JTextField();
		campoEAN.setColumns(10);
		campoEAN.setBounds(242, 248, 237, 20);
		add(campoEAN);

		campoColor = new JTextField();
		campoColor.setColumns(10);
		campoColor.setBounds(242, 273, 237, 20);
		add(campoColor);

		campoPrecio = new JTextField();
		campoPrecio.setColumns(10);
		campoPrecio.setBounds(242, 412, 170, 20);
		add(campoPrecio);

		campoCalorias = new JTextField();
		campoCalorias.setColumns(10);
		campoCalorias.setBounds(242, 491, 170, 20);
		add(campoCalorias);

		campoTalla = new JTextField();
		campoTalla.setColumns(10);
		campoTalla.setBounds(242, 516, 170, 20);
		add(campoTalla);

		campoProveedor = new JTextField();
		campoProveedor.setColumns(10);
		campoProveedor.setBounds(242, 541, 474, 20);
		add(campoProveedor);

		JButton botonAlta = new JButton("Alta");
		botonAlta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String marca = campoMarca.getText();
				String modelo = campoModelo.getText();
				String ean=campoEAN.getText();
				String color = campoColor.getText();
				String descripcion=textAreaDescripcion.getText();
				String precio=campoPrecio.getText();
				String modalidad=(String) comboBoxTipoBicicleta.getSelectedItem();
				String tallaBicicleta=(String) comboBoxTallaBicicleta.getSelectedItem();
				String caloraias=campoCalorias.getText();
				String talla=campoTalla.getText();
				String proveedor=campoProveedor.getText();
						
				
				
			}
		});
		botonAlta.setForeground(new Color(78, 1, 23));
		botonAlta.setFont(new Font("Eras Medium ITC", Font.PLAIN, 25));
		botonAlta.setBackground(new Color(245, 196, 74));
		botonAlta.setBounds(571, 606, 145, 32);
		add(botonAlta);

		JButton botonAtras = new JButton("<-- Atrás");
		botonAtras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ventana.cambiarAPantalla(PantallaAdministracion.class);
			}
		});
		botonAtras.setForeground(new Color(78, 1, 23));
		botonAtras.setFont(new Font("Eras Medium ITC", Font.PLAIN, 25));
		botonAtras.setBackground(new Color(245, 196, 74));
		botonAtras.setBounds(41, 606, 145, 32);
		add(botonAtras);
	}
}
