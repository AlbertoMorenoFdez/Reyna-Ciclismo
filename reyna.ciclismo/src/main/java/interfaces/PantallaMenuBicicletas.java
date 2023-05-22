package interfaces;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;

public class PantallaMenuBicicletas extends JPanel{
	private Ventana ventana;
	public PantallaMenuBicicletas(Ventana v) {
		this.ventana=v;
		this.ventana=v;
		setSize(800, 700);
		setBackground(new Color(78, 1, 23));
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{70, 0, 0, 0, 0, 70, 0};
		gridBagLayout.rowHeights = new int[]{70, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 70, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 1.0, 1.0, 1.0, 1.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		/*
		 * JLabel labelUsuario = new
		 * JLabel("Estas conectado como \""+ventana.usuarioLogueado.getNombre()+" \"");
		 * labelUsuario.setHorizontalAlignment(SwingConstants.LEFT);
		 * labelUsuario.setForeground(new Color(245, 196, 74));
		 * labelUsuario.setBackground(new Color(245, 196, 74)); GridBagConstraints
		 * gbc_labelUsuario = new GridBagConstraints(); gbc_labelUsuario.gridwidth = 3;
		 * gbc_labelUsuario.insets = new Insets(0, 0, 5, 5); gbc_labelUsuario.gridx = 0;
		 * gbc_labelUsuario.gridy = 0; add(labelUsuario, gbc_labelUsuario);
		 */
		
		ImageIcon iconoMTB=new ImageIcon("./imagenes/mtb.png");
		ImageIcon iconoRoad=new ImageIcon("./imagenes/road.png");
		ImageIcon iconoEBike=new ImageIcon("./imagenes/ebike.png");
		ImageIcon iconoUrban=new ImageIcon("./imagenes/urban.png");
		
		JLabel etiquetaBicicletas = new JLabel("Bicicletas");
		etiquetaBicicletas.setHorizontalAlignment(SwingConstants.CENTER);
		etiquetaBicicletas.setForeground(new Color(245, 196, 74));
		etiquetaBicicletas.setFont(new Font("Eras Medium ITC", Font.BOLD, 50));
		etiquetaBicicletas.setBackground(new Color(245, 196, 74));
		GridBagConstraints gbc_etiquetaBicicletas = new GridBagConstraints();
		gbc_etiquetaBicicletas.gridwidth = 2;
		gbc_etiquetaBicicletas.insets = new Insets(0, 0, 5, 5);
		gbc_etiquetaBicicletas.gridx = 2;
		gbc_etiquetaBicicletas.gridy = 1;
		add(etiquetaBicicletas, gbc_etiquetaBicicletas);
		
		JLabel labelMTB = new JLabel(iconoMTB);
		GridBagConstraints gbc_labelMTB = new GridBagConstraints();
		gbc_labelMTB.insets = new Insets(0, 0, 5, 5);
		gbc_labelMTB.gridx = 2;
		gbc_labelMTB.gridy = 3;
		add(labelMTB, gbc_labelMTB);
		
		JButton botonMTB = new JButton("Bicicleta de Montaña");
		botonMTB.setForeground(new Color(78, 1, 23));
		botonMTB.setFont(new Font("Eras Medium ITC", Font.PLAIN, 25));
		botonMTB.setBackground(new Color(245, 196, 74));
		GridBagConstraints gbc_botonMTB = new GridBagConstraints();
		gbc_botonMTB.fill = GridBagConstraints.BOTH;
		gbc_botonMTB.insets = new Insets(0, 0, 5, 5);
		gbc_botonMTB.gridx = 3;
		gbc_botonMTB.gridy = 3;
		add(botonMTB, gbc_botonMTB);
		
		JLabel labelRoad = new JLabel(iconoRoad);
		GridBagConstraints gbc_labelRoad = new GridBagConstraints();
		gbc_labelRoad.insets = new Insets(0, 0, 5, 5);
		gbc_labelRoad.gridx = 2;
		gbc_labelRoad.gridy = 5;
		add(labelRoad, gbc_labelRoad);
		
		JButton botonCarretera = new JButton("Bicicleta de Carretera");
		botonCarretera.setForeground(new Color(78, 1, 23));
		botonCarretera.setFont(new Font("Eras Medium ITC", Font.PLAIN, 25));
		botonCarretera.setBackground(new Color(245, 196, 74));
		GridBagConstraints gbc_botonCarretera = new GridBagConstraints();
		gbc_botonCarretera.fill = GridBagConstraints.BOTH;
		gbc_botonCarretera.insets = new Insets(0, 0, 5, 5);
		gbc_botonCarretera.gridx = 3;
		gbc_botonCarretera.gridy = 5;
		add(botonCarretera, gbc_botonCarretera);
		
		JLabel labelEbike = new JLabel(iconoEBike);
		GridBagConstraints gbc_labelEbike = new GridBagConstraints();
		gbc_labelEbike.insets = new Insets(0, 0, 5, 5);
		gbc_labelEbike.gridx = 2;
		gbc_labelEbike.gridy = 7;
		add(labelEbike, gbc_labelEbike);
		
		JButton btnEBike = new JButton("Bicicletas eléctricas");
		btnEBike.setForeground(new Color(78, 1, 23));
		btnEBike.setFont(new Font("Eras Medium ITC", Font.PLAIN, 25));
		btnEBike.setBackground(new Color(245, 196, 74));
		GridBagConstraints gbc_btnEBike = new GridBagConstraints();
		gbc_btnEBike.fill = GridBagConstraints.BOTH;
		gbc_btnEBike.insets = new Insets(0, 0, 5, 5);
		gbc_btnEBike.gridx = 3;
		gbc_btnEBike.gridy = 7;
		add(btnEBike, gbc_btnEBike);
		
		JLabel labelUrban = new JLabel(iconoUrban);
		GridBagConstraints gbc_labelUrban = new GridBagConstraints();
		gbc_labelUrban.insets = new Insets(0, 0, 5, 5);
		gbc_labelUrban.gridx = 2;
		gbc_labelUrban.gridy = 9;
		add(labelUrban, gbc_labelUrban);
		
		JButton btnBicicletasUrbanas = new JButton("Bicicletas urbanas");
		btnBicicletasUrbanas.setForeground(new Color(78, 1, 23));
		btnBicicletasUrbanas.setFont(new Font("Eras Medium ITC", Font.PLAIN, 25));
		btnBicicletasUrbanas.setBackground(new Color(245, 196, 74));
		GridBagConstraints gbc_btnBicicletasUrbanas = new GridBagConstraints();
		gbc_btnBicicletasUrbanas.fill = GridBagConstraints.BOTH;
		gbc_btnBicicletasUrbanas.insets = new Insets(0, 0, 5, 5);
		gbc_btnBicicletasUrbanas.gridx = 3;
		gbc_btnBicicletasUrbanas.gridy = 9;
		add(btnBicicletasUrbanas, gbc_btnBicicletasUrbanas);
		
		
	}

}
