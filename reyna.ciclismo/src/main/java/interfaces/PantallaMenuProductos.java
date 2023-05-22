package interfaces;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class PantallaMenuProductos extends JPanel {
	private Ventana ventana;

	public PantallaMenuProductos(Ventana v) {
		this.ventana = v;
		setSize(800, 700);
		setBackground(new Color(78, 1, 23));
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 70, 0, 0, 0, 0, 70, 0 };
		gridBagLayout.rowHeights = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		gridBagLayout.columnWeights = new double[] { 0.0, 1.0, 1.0, 1.0, 1.0, 0.0, Double.MIN_VALUE };
		gridBagLayout.rowWeights = new double[] { 1.0, 1.0, 1.0, 0.0, 1.0, 0.0, 1.0, 0.0, 1.0, 1.0, 1.0,
				Double.MIN_VALUE };
		setLayout(gridBagLayout);

		JLabel labelUsuario = new JLabel("Estas conectado como \"" + ventana.usuarioLogueado.getNombre() + " \"");
		labelUsuario.setHorizontalAlignment(SwingConstants.LEFT);
		labelUsuario.setForeground(new Color(245, 196, 74));
		labelUsuario.setBackground(new Color(245, 196, 74));
		GridBagConstraints gbc_labelUsuario = new GridBagConstraints();
		gbc_labelUsuario.gridwidth = 3;
		gbc_labelUsuario.insets = new Insets(0, 0, 5, 5);
		gbc_labelUsuario.gridx = 0;
		gbc_labelUsuario.gridy = 0;
		add(labelUsuario, gbc_labelUsuario);

		JLabel etiquetaProductos = new JLabel("Productos");
		etiquetaProductos.setHorizontalAlignment(SwingConstants.CENTER);
		etiquetaProductos.setForeground(new Color(245, 196, 74));
		etiquetaProductos.setFont(new Font("Eras Medium ITC", Font.BOLD, 50));
		etiquetaProductos.setBackground(new Color(245, 196, 74));
		GridBagConstraints gbc_etiquetaProductos = new GridBagConstraints();
		gbc_etiquetaProductos.gridwidth = 2;
		gbc_etiquetaProductos.insets = new Insets(0, 0, 5, 5);
		gbc_etiquetaProductos.gridx = 2;
		gbc_etiquetaProductos.gridy = 1;
		add(etiquetaProductos, gbc_etiquetaProductos);

		ImageIcon iconoBicicleta = new ImageIcon("./imagenes/icono bicicleta.png");
		ImageIcon iconoAccesorio = new ImageIcon("./imagenes/icono casco.png");
		ImageIcon iconoAlimentacion = new ImageIcon("./imagenes/icono alimentacion.png");

		JLabel labelIconoBicicleta = new JLabel(iconoBicicleta);
		GridBagConstraints gbc_labelIconoBicicleta = new GridBagConstraints();
		gbc_labelIconoBicicleta.insets = new Insets(0, 0, 5, 5);
		gbc_labelIconoBicicleta.gridx = 2;
		gbc_labelIconoBicicleta.gridy = 3;
		add(labelIconoBicicleta, gbc_labelIconoBicicleta);

		JButton botonBicicletas = new JButton("Bicicletas");
		botonBicicletas.addMouseListener(new MouseAdapter() {

			public void mouseClicked(MouseEvent e) {
				ventana.cambiarAPantalla(PantallaMenuBicicletas.class);
			}
		});
		botonBicicletas.setFont(new Font("Eras Medium ITC", Font.PLAIN, 25));
		botonBicicletas.setForeground(new Color(78, 1, 23));
		botonBicicletas.setBackground(new Color(245, 196, 74));
		GridBagConstraints gbc_botonBicicletas = new GridBagConstraints();
		gbc_botonBicicletas.fill = GridBagConstraints.BOTH;
		gbc_botonBicicletas.insets = new Insets(0, 0, 5, 5);
		gbc_botonBicicletas.gridx = 3;
		gbc_botonBicicletas.gridy = 3;
		add(botonBicicletas, gbc_botonBicicletas);

		JLabel labelIconoAccesorios = new JLabel(iconoAccesorio);
		GridBagConstraints gbc_labelIconoAccesorios = new GridBagConstraints();
		gbc_labelIconoAccesorios.insets = new Insets(0, 0, 5, 5);
		gbc_labelIconoAccesorios.gridx = 2;
		gbc_labelIconoAccesorios.gridy = 5;
		add(labelIconoAccesorios, gbc_labelIconoAccesorios);

		JButton botonAccesorios = new JButton("Accesorios");
		botonAccesorios.setForeground(new Color(78, 1, 23));
		botonAccesorios.setFont(new Font("Eras Medium ITC", Font.PLAIN, 25));
		botonAccesorios.setBackground(new Color(245, 196, 74));
		GridBagConstraints gbc_botonAccesorios = new GridBagConstraints();
		gbc_botonAccesorios.fill = GridBagConstraints.BOTH;
		gbc_botonAccesorios.insets = new Insets(0, 0, 5, 5);
		gbc_botonAccesorios.gridx = 3;
		gbc_botonAccesorios.gridy = 5;
		add(botonAccesorios, gbc_botonAccesorios);

		JLabel labelIconoAlimentacion = new JLabel(iconoAlimentacion);
		GridBagConstraints gbc_labelIconoAlimentacion = new GridBagConstraints();
		gbc_labelIconoAlimentacion.insets = new Insets(0, 0, 5, 5);
		gbc_labelIconoAlimentacion.gridx = 2;
		gbc_labelIconoAlimentacion.gridy = 7;
		add(labelIconoAlimentacion, gbc_labelIconoAlimentacion);

		JButton botonAlimentacion = new JButton("Alimentación");
		botonAlimentacion.setForeground(new Color(78, 1, 23));
		botonAlimentacion.setFont(new Font("Eras Medium ITC", Font.PLAIN, 25));
		botonAlimentacion.setBackground(new Color(245, 196, 74));
		GridBagConstraints gbc_botonAlimentacion = new GridBagConstraints();
		gbc_botonAlimentacion.fill = GridBagConstraints.BOTH;
		gbc_botonAlimentacion.insets = new Insets(0, 0, 5, 5);
		gbc_botonAlimentacion.gridx = 3;
		gbc_botonAlimentacion.gridy = 7;
		add(botonAlimentacion, gbc_botonAlimentacion);

	}

}
