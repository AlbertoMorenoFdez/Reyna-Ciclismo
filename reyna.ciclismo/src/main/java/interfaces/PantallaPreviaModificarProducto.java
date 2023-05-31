package interfaces;

import java.awt.Color;

import interfaces.Ventana;

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
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class PantallaPreviaModificarProducto extends JPanel {
	private Ventana ventana;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JComboBox comboBoxTipoBicicleta;
	private final ButtonGroup buttonGroup_1 = new ButtonGroup();

	public PantallaPreviaModificarProducto(Ventana v) {
		this.ventana = v;
		setSize(800, 700);
		setBackground(new Color(78, 1, 23));
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 50, 0, 135, 148, 50, 0 };
		gridBagLayout.rowHeights = new int[] { 70, 0, 58, 84, 0, 50, 50, 10, 50, 10, 50, -100, 32, 50, 0 };
		gridBagLayout.columnWeights = new double[] { 0.0, 1.0, 1.0, 1.0, 0.0, Double.MIN_VALUE };
		gridBagLayout.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0,
				Double.MIN_VALUE };
		setLayout(gridBagLayout);
		
		JLabel labelUsuario = new JLabel("Estas conectado como "+ventana.usuarioLogueado.getNombre());
		labelUsuario.setHorizontalAlignment(SwingConstants.LEFT);
		labelUsuario.setForeground(new Color(245, 196, 74));
		labelUsuario.setBackground(new Color(245, 196, 74));
		GridBagConstraints gbc_labelUsuario = new GridBagConstraints();
		gbc_labelUsuario.anchor = GridBagConstraints.WEST;
		gbc_labelUsuario.gridwidth = 2;
		gbc_labelUsuario.insets = new Insets(0, 0, 5, 5);
		gbc_labelUsuario.gridx = 1;
		gbc_labelUsuario.gridy = 0;
		add(labelUsuario, gbc_labelUsuario);

		JLabel etiquetaAltaProducto = new JLabel("MODIFICAR PRODUCTO");
		etiquetaAltaProducto.setHorizontalAlignment(SwingConstants.CENTER);
		etiquetaAltaProducto.setForeground(new Color(245, 196, 74));
		etiquetaAltaProducto.setFont(new Font("Eras Medium ITC", Font.BOLD, 50));
		etiquetaAltaProducto.setBackground(new Color(245, 196, 74));
		GridBagConstraints gbc_etiquetaAltaProducto = new GridBagConstraints();
		gbc_etiquetaAltaProducto.anchor = GridBagConstraints.NORTH;
		gbc_etiquetaAltaProducto.insets = new Insets(0, 0, 5, 5);
		gbc_etiquetaAltaProducto.gridwidth = 3;
		gbc_etiquetaAltaProducto.gridx = 1;
		gbc_etiquetaAltaProducto.gridy = 2;
		add(etiquetaAltaProducto, gbc_etiquetaAltaProducto);

		JButton botonCancelar = new JButton("Cancelar");
		botonCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ventana.cambiarAPantalla(PantallaAdministracion.class);
			}
		});

		JLabel etiquetacategoria = new JLabel("¿Qué categoría quieres modificar?");
		etiquetacategoria.setFont(new Font("Eras Medium ITC", Font.PLAIN, 25));
		etiquetacategoria.setForeground(new Color(245, 196, 75));
		GridBagConstraints gbc_etiquetacategoria = new GridBagConstraints();
		gbc_etiquetacategoria.gridwidth = 3;
		gbc_etiquetacategoria.insets = new Insets(0, 0, 5, 5);
		gbc_etiquetacategoria.gridx = 1;
		gbc_etiquetacategoria.gridy = 4;
		add(etiquetacategoria, gbc_etiquetacategoria);

		final JRadioButton radioBicicleta = new JRadioButton("Bicicletas");
		buttonGroup_1.add(radioBicicleta);
		radioBicicleta.setFont(new Font("Tahoma", Font.PLAIN, 20));
		radioBicicleta.setBackground(new Color(245, 196, 75));
		radioBicicleta.setForeground(new Color(78, 1, 23));
		GridBagConstraints gbc_radioBicicleta = new GridBagConstraints();
		gbc_radioBicicleta.fill = GridBagConstraints.BOTH;
		gbc_radioBicicleta.insets = new Insets(0, 0, 5, 5);
		gbc_radioBicicleta.gridx = 2;
		gbc_radioBicicleta.gridy = 6;
		add(radioBicicleta, gbc_radioBicicleta);

		final JRadioButton radioAlimentacion = new JRadioButton("Alimentacion");
		buttonGroup_1.add(radioAlimentacion);
		radioAlimentacion.setFont(new Font("Tahoma", Font.PLAIN, 20));
		radioAlimentacion.setForeground(new Color(78, 1, 23));
		radioAlimentacion.setBackground(new Color(245, 196, 75));
		GridBagConstraints gbc_radioAlimentacion = new GridBagConstraints();
		gbc_radioAlimentacion.fill = GridBagConstraints.BOTH;
		gbc_radioAlimentacion.insets = new Insets(0, 0, 5, 5);
		gbc_radioAlimentacion.gridx = 2;
		gbc_radioAlimentacion.gridy = 8;
		add(radioAlimentacion, gbc_radioAlimentacion);

		final JRadioButton radioAccesorio = new JRadioButton("Accesorios");
		buttonGroup_1.add(radioAccesorio);
		radioAccesorio.setFont(new Font("Tahoma", Font.PLAIN, 20));
		radioAccesorio.setForeground(new Color(78, 1, 23));
		radioAccesorio.setBackground(new Color(245, 196, 75));
		GridBagConstraints gbc_radioAccesorio = new GridBagConstraints();
		gbc_radioAccesorio.fill = GridBagConstraints.BOTH;
		gbc_radioAccesorio.insets = new Insets(0, 0, 5, 5);
		gbc_radioAccesorio.gridx = 2;
		gbc_radioAccesorio.gridy = 10;
		add(radioAccesorio, gbc_radioAccesorio);
		botonCancelar.setForeground(new Color(78, 1, 23));
		botonCancelar.setFont(new Font("Eras Medium ITC", Font.PLAIN, 25));
		botonCancelar.setBackground(new Color(245, 196, 74));
		GridBagConstraints gbc_botonCancelar = new GridBagConstraints();
		gbc_botonCancelar.fill = GridBagConstraints.BOTH;
		gbc_botonCancelar.insets = new Insets(0, 0, 5, 5);
		gbc_botonCancelar.gridx = 1;
		gbc_botonCancelar.gridy = 12;
		add(botonCancelar, gbc_botonCancelar);

		JButton botonAceptar = new JButton("Aceptar");
		botonAceptar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(radioBicicleta.isSelected()) {
					ventana.cambiarAPantalla(PantallaModificarBicicleta.class);
				}
				else if(radioAlimentacion.isSelected()) {
					ventana.cambiarAPantalla(PantallaModificarAlimentacion.class);
				}else if(radioAccesorio.isSelected()) {
					ventana.cambiarAPantalla(PantallaModificarAccesorio.class);
					}
			}
		});
		botonAceptar.setForeground(new Color(78, 1, 23));
		botonAceptar.setFont(new Font("Eras Medium ITC", Font.PLAIN, 25));
		botonAceptar.setBackground(new Color(245, 196, 74));
		GridBagConstraints gbc_botonAceptar = new GridBagConstraints();
		gbc_botonAceptar.fill = GridBagConstraints.BOTH;
		gbc_botonAceptar.insets = new Insets(0, 0, 5, 5);
		gbc_botonAceptar.gridx = 3;
		gbc_botonAceptar.gridy = 12;
		add(botonAceptar, gbc_botonAceptar);

	}
}
