package clases;

import javax.swing.JPanel;

import interfaces.Ventana;
import java.awt.BorderLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Insets;

public class Marco extends JPanel{
	private Ventana ventana;
	
	public Marco (Ventana v) {
		this.ventana=v;
		setLayout(new BorderLayout(0, 0));
		
		JPanel panelCabecera = new JPanel();
		add(panelCabecera, BorderLayout.NORTH);
		GridBagLayout gbl_panelCabecera = new GridBagLayout();
		gbl_panelCabecera.columnWidths = new int[]{0, 0};
		gbl_panelCabecera.rowHeights = new int[]{0, 0, 0};
		gbl_panelCabecera.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_panelCabecera.rowWeights = new double[]{1.0, 0.0, Double.MIN_VALUE};
		panelCabecera.setLayout(gbl_panelCabecera);
		
		JLabel labelUsuario = new JLabel("New label");
		GridBagConstraints gbc_labelUsuario = new GridBagConstraints();
		gbc_labelUsuario.insets = new Insets(0, 0, 5, 0);
		gbc_labelUsuario.gridx = 0;
		gbc_labelUsuario.gridy = 0;
		panelCabecera.add(labelUsuario, gbc_labelUsuario);
		
		JButton btnNewButton = new JButton("New button");
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.gridx = 0;
		gbc_btnNewButton.gridy = 1;
		panelCabecera.add(btnNewButton, gbc_btnNewButton);
		
	}
	
	public void ponerContenido(JPanel j) {
		this.add(j,BorderLayout.CENTER);
	}

}
