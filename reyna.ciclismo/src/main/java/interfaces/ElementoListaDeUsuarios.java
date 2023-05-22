package interfaces;

import javax.swing.JPanel;

import clases.Usuario;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Insets;

public class ElementoListaDeUsuarios extends JPanel{
	Ventana ventana;
	Usuario usuarioActual;
	
	public ElementoListaDeUsuarios(Ventana v, Usuario u) {
		this.ventana=v;
		this.usuarioActual=u;
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JLabel labelNombre = new JLabel(usuarioActual.getNombre());
		GridBagConstraints gbc_labelNombre = new GridBagConstraints();
		gbc_labelNombre.insets = new Insets(0, 0, 0, 5);
		gbc_labelNombre.gridx = 1;
		gbc_labelNombre.gridy = 1;
		add(labelNombre, gbc_labelNombre);
		
		JLabel labelDireccion = new JLabel(usuarioActual.getDireccion());
		GridBagConstraints gbc_labelDireccion = new GridBagConstraints();
		gbc_labelDireccion.insets = new Insets(0, 0, 0, 5);
		gbc_labelDireccion.gridx = 3;
		gbc_labelDireccion.gridy = 1;
		add(labelDireccion, gbc_labelDireccion);
		
		JLabel labelTelefono = new JLabel(""+usuarioActual.getTelefono());
		GridBagConstraints gbc_labelTelefono = new GridBagConstraints();
		gbc_labelTelefono.insets = new Insets(0, 0, 0, 5);
		gbc_labelTelefono.gridx = 5;
		gbc_labelTelefono.gridy = 1;
		add(labelTelefono, gbc_labelTelefono);
		
		
		JLabel labelDNI = new JLabel(usuarioActual.getDNI());
		GridBagConstraints gbc_labelDNI = new GridBagConstraints();
		gbc_labelDNI.insets = new Insets(0, 0, 0, 5);
		gbc_labelDNI.gridx = 7;
		gbc_labelDNI.gridy = 1;
		add(labelDNI, gbc_labelDNI);
		
		JLabel labelEmail = new JLabel(usuarioActual.getEmail());
		GridBagConstraints gbc_labelEmail = new GridBagConstraints();
		gbc_labelEmail.gridx = 9;
		gbc_labelEmail.gridy = 1;
		add(labelEmail, gbc_labelEmail);
		ventana=v;
		usuarioActual= u;
		
	}

}
