package interfaces;

import javax.swing.JPanel;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Insets;

public class ElementoListaBicicletas extends JPanel{
	Ventana ventana;
	
	public ElementoListaBicicletas(Ventana v) {
		this.ventana=v;
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JLabel labelMarca = new JLabel("New label");
		GridBagConstraints gbc_labelMarca = new GridBagConstraints();
		gbc_labelMarca.insets = new Insets(0, 0, 0, 5);
		gbc_labelMarca.gridx = 0;
		gbc_labelMarca.gridy = 0;
		add(labelMarca, gbc_labelMarca);
		
		JLabel labelModelo = new JLabel("New label");
		GridBagConstraints gbc_labelModelo = new GridBagConstraints();
		gbc_labelModelo.insets = new Insets(0, 0, 0, 5);
		gbc_labelModelo.gridx = 1;
		gbc_labelModelo.gridy = 0;
		add(labelModelo, gbc_labelModelo);
		
		JLabel lblNewLabel = new JLabel("New label");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.gridx = 2;
		gbc_lblNewLabel.gridy = 0;
		add(lblNewLabel, gbc_lblNewLabel);
		
	}

}
