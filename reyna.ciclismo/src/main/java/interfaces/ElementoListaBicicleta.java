package interfaces;

import javax.swing.JPanel;

import clases.Bicicleta;
import excepciones.ProveedorNoExisteException;

import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.SwingConstants;

public class ElementoListaBicicleta extends JPanel {
	Ventana ventana;
	Bicicleta bicicletaActual;
	
	private String marca;
    private String modelo;
    private String color;
    private String descripcion;
    private int EAN;
    private float precio;
    private String modalidad;
    private String talla;
    private String proveedor;
    
    private JLabel labelMarca;
    private JLabel labelModelo;
    private JLabel labelColor;
    

	public ElementoListaBicicleta(Ventana v) {
		this.ventana = v;
		//this.bicicletaActual = bicicletas;
		setSize(800, 700);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		gridBagLayout.rowHeights = new int[] { 0, 0, 0 };
		gridBagLayout.columnWeights = new double[] { 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0 };
		gridBagLayout.rowWeights = new double[] { 0.0, 0.0, Double.MIN_VALUE };
		setLayout(gridBagLayout);

//		JLabel labelMarcaT = new JLabel("Marca");
//		GridBagConstraints gbc_labelMarcaT = new GridBagConstraints();
//		gbc_labelMarcaT.insets = new Insets(0, 0, 5, 5);
//		gbc_labelMarcaT.gridx = 0;
//		gbc_labelMarcaT.gridy = 0;
//		add(labelMarcaT, gbc_labelMarcaT);
//
//		JLabel labelModeloT = new JLabel("Modelo");
//		GridBagConstraints gbc_labelModeloT = new GridBagConstraints();
//		gbc_labelModeloT.insets = new Insets(0, 0, 5, 5);
//		gbc_labelModeloT.gridx = 1;
//		gbc_labelModeloT.gridy = 0;
//		add(labelModeloT, gbc_labelModeloT);
//
//		JLabel labelColorT = new JLabel("Color");
//		GridBagConstraints gbc_labelColorT = new GridBagConstraints();
//		gbc_labelColorT.insets = new Insets(0, 0, 5, 5);
//		gbc_labelColorT.gridx = 2;
//		gbc_labelColorT.gridy = 0;
//		add(labelColorT, gbc_labelColorT);
//
//		JLabel labelDescripcionT = new JLabel("Descripcion");
//		GridBagConstraints gbc_labelDescripcionT = new GridBagConstraints();
//		gbc_labelDescripcionT.insets = new Insets(0, 0, 5, 5);
//		gbc_labelDescripcionT.gridx = 3;
//		gbc_labelDescripcionT.gridy = 0;
//		add(labelDescripcionT, gbc_labelDescripcionT);
//
//		JLabel labelEANT = new JLabel("EAN");
//		GridBagConstraints gbc_labelEANT = new GridBagConstraints();
//		gbc_labelEANT.insets = new Insets(0, 0, 5, 5);
//		gbc_labelEANT.gridx = 4;
//		gbc_labelEANT.gridy = 0;
//		add(labelEANT, gbc_labelEANT);
//
//		JLabel labelPrecioT = new JLabel("Precio");
//		GridBagConstraints gbc_labelPrecioT = new GridBagConstraints();
//		gbc_labelPrecioT.insets = new Insets(0, 0, 5, 5);
//		gbc_labelPrecioT.gridx = 5;
//		gbc_labelPrecioT.gridy = 0;
//		add(labelPrecioT, gbc_labelPrecioT);
//
//		JLabel labelModalidadT = new JLabel("Modalidad");
//		GridBagConstraints gbc_labelModalidadT = new GridBagConstraints();
//		gbc_labelModalidadT.insets = new Insets(0, 0, 5, 5);
//		gbc_labelModalidadT.gridx = 6;
//		gbc_labelModalidadT.gridy = 0;
//		add(labelModalidadT, gbc_labelModalidadT);
//
//		JLabel labelTallaT = new JLabel("Talla");
//		GridBagConstraints gbc_labelTallaT = new GridBagConstraints();
//		gbc_labelTallaT.insets = new Insets(0, 0, 5, 5);
//		gbc_labelTallaT.gridx = 7;
//		gbc_labelTallaT.gridy = 0;
//		add(labelTallaT, gbc_labelTallaT);
//
//		JLabel labelProveedorT = new JLabel("Proveedor");
//		GridBagConstraints gbc_labelProveedorT = new GridBagConstraints();
//		gbc_labelProveedorT.insets = new Insets(0, 0, 5, 0);
//		gbc_labelProveedorT.gridx = 8;
//		gbc_labelProveedorT.gridy = 0;
//		add(labelProveedorT, gbc_labelProveedorT);

		ArrayList<Bicicleta> todasLasBicicletas;

		try {
			int row = 1;

			todasLasBicicletas = Bicicleta.getTodos();

			for (Bicicleta bicicleta : todasLasBicicletas) {
				JLabel labelMarca = new JLabel(bicicleta.getMarca());
				GridBagConstraints gbc_labelMarca = new GridBagConstraints();
				gbc_labelMarca.insets = new Insets(0, 0, 0, 5);
				gbc_labelMarca.gridx = 0;
				gbc_labelMarca.gridy = row;
				add(labelMarca, gbc_labelMarca);

				JLabel labelModelo = new JLabel(bicicleta.getModelo());
				GridBagConstraints gbc_labelModelo = new GridBagConstraints();
				gbc_labelModelo.insets = new Insets(0, 0, 0, 5);
				gbc_labelModelo.gridx = 1;
				gbc_labelModelo.gridy = row;
				add(labelModelo, gbc_labelModelo);

				JLabel labelColor = new JLabel(bicicleta.getColor());
				GridBagConstraints gbc_labelColor = new GridBagConstraints();
				gbc_labelColor.insets = new Insets(0, 0, 0, 5);
				gbc_labelColor.gridx = 2;
				gbc_labelColor.gridy = row;
				add(labelColor, gbc_labelColor);

				JLabel labelDescripcion = new JLabel(bicicleta.getDescripcion());
				GridBagConstraints gbc_labelDescripcion = new GridBagConstraints();
				gbc_labelDescripcion.insets = new Insets(0, 0, 0, 5);
				gbc_labelDescripcion.gridx = 3;
				gbc_labelDescripcion.gridy = row;
				add(labelDescripcion, gbc_labelDescripcion);

				JLabel labelEAN = new JLabel(String.valueOf(bicicleta.getEan()));
				labelEAN.setHorizontalAlignment(SwingConstants.CENTER);
				GridBagConstraints gbc_labelEAN = new GridBagConstraints();
				gbc_labelEAN.anchor = GridBagConstraints.SOUTH;
				gbc_labelEAN.insets = new Insets(0, 0, 0, 5);
				gbc_labelEAN.gridx = 4;
				gbc_labelEAN.gridy = row;
				add(labelEAN, gbc_labelEAN);

				JLabel labelPrecio = new JLabel(String.valueOf(bicicleta.getPrecio()));
				GridBagConstraints gbc_labelPrecio = new GridBagConstraints();
				gbc_labelPrecio.insets = new Insets(0, 0, 0, 5);
				gbc_labelPrecio.gridx = 5;
				gbc_labelPrecio.gridy = row;
				add(labelPrecio, gbc_labelPrecio);

				JLabel labelModalidad = new JLabel(bicicleta.getModalidad().toString());
				GridBagConstraints gbc_labelModalidad = new GridBagConstraints();
				gbc_labelModalidad.insets = new Insets(0, 0, 0, 5);
				gbc_labelModalidad.gridx = 6;
				gbc_labelModalidad.gridy = row;
				add(labelModalidad, gbc_labelModalidad);

				JLabel labelTalla = new JLabel(String.valueOf(bicicleta.getTallaBicicleta()));
				GridBagConstraints gbc_labelTalla = new GridBagConstraints();
				gbc_labelTalla.insets = new Insets(0, 0, 0, 5);
				gbc_labelTalla.gridx = 7;
				gbc_labelTalla.gridy = row;
				add(labelTalla, gbc_labelTalla);

				JLabel labelProveedor = new JLabel(bicicleta.getProveedor().getNombre());
				GridBagConstraints gbc_labelProveedor = new GridBagConstraints();
				gbc_labelProveedor.gridx = 8;
				gbc_labelProveedor.gridy = row;
				add(labelProveedor, gbc_labelProveedor);

				row++;
				ventana = v;
				//bicicletaActual=bicicletas;
			}
		} catch (SQLException | ProveedorNoExisteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		

	}
	
	public String getMarca() {
        return labelMarca.getText();
    }

    public String getModelo() {
        return labelModelo.getText();
    }

    public String getColor() {
        return labelColor.getText();
    }
	

}