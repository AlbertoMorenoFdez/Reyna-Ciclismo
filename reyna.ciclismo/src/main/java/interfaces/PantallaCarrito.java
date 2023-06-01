package interfaces;
import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import clases.Producto;
import clases.ProductosComprados;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;

public class PantallaCarrito extends JPanel {
    private Ventana ventana;
    private HashMap<Producto, Integer> productosCantidad; // Mapa para almacenar los productos y sus cantidades

    public PantallaCarrito(Ventana v) {
        this.ventana = v;
        float totalImporte = 0.0f;
        productosCantidad = new HashMap<>(); // Inicializar el mapa de productos y cantidades

        setLayout(new BorderLayout());

        JPanel panelPrincipal = new JPanel(new BorderLayout());

        // Crear el modelo de datos para la tabla
        DefaultTableModel modeloTabla = new DefaultTableModel();
        modeloTabla.addColumn("Marca");
        modeloTabla.addColumn("Modelo");
        modeloTabla.addColumn("Precio (€)");
        modeloTabla.addColumn("Cantidad"); // Nueva columna para la cantidad

     // Obtener los productos del carrito
        LinkedHashSet<ProductosComprados> productosComprados = ventana.getCarrito().getProductosComprados();

        // Recorrer los productos y agregarlos al modelo de datos
        for (ProductosComprados pc : productosComprados) {
            ArrayList<Producto> listaProductos = pc.getProductos(); // Obtener la lista de productos
            
            for (Producto producto : listaProductos) {
                float importeProducto = producto.getPrecio();

                // Verificar si el producto ya se encuentra en el mapa de productos y cantidades
                if (productosCantidad.containsKey(producto)) {
                    int cantidadActual = productosCantidad.get(producto);
                    productosCantidad.put(producto, cantidadActual + 1); // Incrementar la cantidad
                } else {
                    productosCantidad.put(producto, 1); // Agregar el producto al mapa con cantidad 1
                }

                totalImporte += importeProducto;
                Object[] fila = { producto.getMarca(), producto.getModelo(), producto.getPrecio() + " €",
                        productosCantidad.get(producto) // Obtener la cantidad del producto
                };
                modeloTabla.addRow(fila);
            }
        }


        // Crear la tabla y asignarle el modelo de datos
        JTable tablaProductos = new JTable(modeloTabla);

        // Agregar la tabla a un JScrollPane
        JScrollPane listaCarrito = new JScrollPane(tablaProductos);
        listaCarrito.setViewportBorder(new LineBorder(new Color(78, 1, 23), 15));
        panelPrincipal.add(listaCarrito, BorderLayout.CENTER);

        // Agregar el panel principal al panel PantallaCarrito
        add(panelPrincipal, BorderLayout.CENTER);

        JPanel panelTitulo = new JPanel();
        panelTitulo.setBackground(new Color(78, 1, 23));
        panelPrincipal.add(panelTitulo, BorderLayout.NORTH);
        GridBagLayout gbl_panelTitulo = new GridBagLayout();
        gbl_panelTitulo.columnWidths = new int[] { 10, 173, 49, 50, 0 };
        gbl_panelTitulo.rowHeights = new int[] { 14, 0 };
        gbl_panelTitulo.columnWeights = new double[] { 0.0, 1.0, 1.0, 0.0, Double.MIN_VALUE };
        gbl_panelTitulo.rowWeights = new double[] { 0.0, Double.MIN_VALUE };
        panelTitulo.setLayout(gbl_panelTitulo);

        JLabel labelUsuario = new JLabel("Estas conectado como " + ventana.usuarioLogueado.getNombre());
        labelUsuario.setForeground(new Color(245, 196, 74));
        GridBagConstraints gbc_labelUsuario = new GridBagConstraints();
        gbc_labelUsuario.anchor = GridBagConstraints.WEST;
        gbc_labelUsuario.insets = new Insets(0, 0, 0, 5);
        gbc_labelUsuario.gridx = 1;
        gbc_labelUsuario.gridy = 0;
        panelTitulo.add(labelUsuario, gbc_labelUsuario);

        JLabel etiquetaCarrito = new JLabel("CARRITO");
        etiquetaCarrito.setHorizontalAlignment(SwingConstants.CENTER);
        etiquetaCarrito.setForeground(new Color(245, 196, 74));
        etiquetaCarrito.setFont(new Font("Eras Medium ITC", Font.BOLD, 50));
        etiquetaCarrito.setBackground(new Color(245, 196, 74));
        GridBagConstraints gbc_etiquetaCarrito = new GridBagConstraints();
        gbc_etiquetaCarrito.anchor = GridBagConstraints.EAST;
        gbc_etiquetaCarrito.insets = new Insets(0, 0, 0, 5);
        gbc_etiquetaCarrito.gridx = 2;
        gbc_etiquetaCarrito.gridy = 0;
        panelTitulo.add(etiquetaCarrito, gbc_etiquetaCarrito);

        // JPanel para el botón de volver y la etiqueta del total del importe
        JPanel panelFooter = new JPanel(new BorderLayout());

        add(panelFooter, BorderLayout.SOUTH);

        JPanel panelBajoCarrito = new JPanel();
        panelBajoCarrito.setBackground(new Color(78, 1, 23));
        panelFooter.add(panelBajoCarrito, BorderLayout.NORTH);
        GridBagLayout gbl_panelBajoCarrito = new GridBagLayout();
        gbl_panelBajoCarrito.columnWidths = new int[] { 50, 78, 0, 0, 0, 78, 50, 0 };
        gbl_panelBajoCarrito.rowHeights = new int[] { 10, 50, 10, 0 };
        gbl_panelBajoCarrito.columnWeights = new double[] { 0.0, 0.0, 1.0, 1.0, 1.0, 0.0, 0.0, Double.MIN_VALUE };
        gbl_panelBajoCarrito.rowWeights = new double[] { 0.0, 0.0, 0.0, Double.MIN_VALUE };
        panelBajoCarrito.setLayout(gbl_panelBajoCarrito);

        JButton botonVolver = new JButton("Volver");
        botonVolver.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                ventana.cambiarAPantalla(PantallaMenuProductos.class);
            }
        });
        botonVolver.setForeground(new Color(78, 1, 23));
        botonVolver.setBackground(new Color(245, 196, 74));
        botonVolver.setFont(new Font("Eras Medium ITC", Font.PLAIN, 25));
        GridBagConstraints gbc_botonVolver = new GridBagConstraints();
        gbc_botonVolver.fill = GridBagConstraints.BOTH;
        gbc_botonVolver.insets = new Insets(0, 0, 5, 5);
        gbc_botonVolver.gridx = 1;
        gbc_botonVolver.gridy = 1;
        panelBajoCarrito.add(botonVolver, gbc_botonVolver);
        
        BotonLogOut botonLogOut = new BotonLogOut();
        botonLogOut.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ventana.cambiarAPantalla(PantallaLogin.class);
			}
			
		});
        GridBagConstraints gbc_botonLogOut = new GridBagConstraints();
        gbc_botonLogOut.insets = new Insets(0, 0, 5, 5);
        gbc_botonLogOut.gridx = 3;
        gbc_botonLogOut.gridy = 1;
        panelBajoCarrito.add(botonLogOut, gbc_botonLogOut);

        JLabel etiquetaTotal = new JLabel("Total: " + totalImporte + " €");
        etiquetaTotal.setForeground(new Color(245, 196, 74));
        etiquetaTotal.setHorizontalAlignment(SwingConstants.RIGHT);
        etiquetaTotal.setFont(new Font("Eras Medium ITC", Font.PLAIN, 16));
        GridBagConstraints gbc_etiquetaTotal = new GridBagConstraints();
        gbc_etiquetaTotal.gridwidth = 2;
        gbc_etiquetaTotal.anchor = GridBagConstraints.EAST;
        gbc_etiquetaTotal.insets = new Insets(0, 0, 5, 5);
        gbc_etiquetaTotal.gridx = 4;
        gbc_etiquetaTotal.gridy = 1;
        panelBajoCarrito.add(etiquetaTotal, gbc_etiquetaTotal);
    }
}

//import java.awt.BorderLayout;
//import java.awt.Font;
//import java.util.LinkedHashSet;
//
//import javax.swing.BoxLayout;
//import javax.swing.JButton;
//import javax.swing.JLabel;
//import javax.swing.JPanel;
//import javax.swing.JScrollPane;
//import javax.swing.JSeparator;
//import javax.swing.JTable;
//import javax.swing.SwingConstants;
//import javax.swing.table.DefaultTableModel;
//
//import clases.Producto;
//import clases.ProductosComprados;
//import java.awt.event.MouseAdapter;
//import java.awt.event.MouseEvent;
//import java.awt.GridBagLayout;
//import java.awt.GridBagConstraints;
//import java.awt.Insets;
//import java.awt.Color;
//import javax.swing.border.LineBorder;
//
//
//
//public class PantallaCarrito extends JPanel {
//    private Ventana ventana;
//
//    public PantallaCarrito(Ventana v) {
//        this.ventana = v;
//        float totalImporte = (float) 0.0;
//        setLayout(new BorderLayout());
//
//        JPanel panelPrincipal = new JPanel(new BorderLayout());
//
//        // Crear el modelo de datos para la tabla
//        DefaultTableModel modeloTabla = new DefaultTableModel();
//        
//        modeloTabla.addColumn("Marca");
//        modeloTabla.addColumn("Modelo");
//        modeloTabla.addColumn("Precio (€)");
//
//        // Obtener los productos del carrito
//        LinkedHashSet<ProductosComprados> productosComprados = ventana.getCarrito().getProductosComprados();
//
//        // Recorrer los productos y agregarlos al modelo de datos
//        for (ProductosComprados pc : productosComprados) {
//            for (Producto producto : pc.getProductos()) {
//                float importeProducto = producto.getPrecio();
//                totalImporte += importeProducto;
//                Object[] fila = {
//                		
//                        producto.getMarca(),
//                        producto.getModelo(),
//                        producto.getPrecio()+" €"
//                };
//                modeloTabla.addRow(fila);
//            }
//        }
//
//        // Crear la tabla y asignarle el modelo de datos
//        JTable tablaProductos = new JTable(modeloTabla);
//
//        // Agregar la tabla a un JScrollPane
//        JScrollPane listaCarrito = new JScrollPane(tablaProductos);
//        listaCarrito.setViewportBorder(new LineBorder(new Color(78, 1, 23), 15));
//        panelPrincipal.add(listaCarrito, BorderLayout.CENTER);
//
//        // Agregar el panel principal al panel PantallaCarrito
//        add(panelPrincipal, BorderLayout.CENTER);
//        
//        JPanel panelTitulo = new JPanel();
//        panelTitulo.setBackground(new Color(78, 1, 23));
//        panelPrincipal.add(panelTitulo, BorderLayout.NORTH);
//        GridBagLayout gbl_panelTitulo = new GridBagLayout();
//        gbl_panelTitulo.columnWidths = new int[]{10, 173, 49, 50, 0};
//        gbl_panelTitulo.rowHeights = new int[]{14, 0};
//        gbl_panelTitulo.columnWeights = new double[]{0.0, 1.0, 1.0, 0.0, Double.MIN_VALUE};
//        gbl_panelTitulo.rowWeights = new double[]{0.0, Double.MIN_VALUE};
//        panelTitulo.setLayout(gbl_panelTitulo);
//        
//        JLabel labelUsuario = new JLabel("Estas conectado como "+ventana.usuarioLogueado.getNombre());
//        labelUsuario.setForeground(new Color(245, 196, 74));
//        GridBagConstraints gbc_labelUsuario = new GridBagConstraints();
//        gbc_labelUsuario.anchor = GridBagConstraints.WEST;
//        gbc_labelUsuario.insets = new Insets(0, 0, 0, 5);
//        gbc_labelUsuario.gridx = 1;
//        gbc_labelUsuario.gridy = 0;
//        panelTitulo.add(labelUsuario, gbc_labelUsuario);
//        
//        JLabel etiquetaCarrito = new JLabel("CARRITO");
//        etiquetaCarrito.setHorizontalAlignment(SwingConstants.CENTER);
//        etiquetaCarrito.setForeground(new Color(245, 196, 74));
//        etiquetaCarrito.setFont(new Font("Eras Medium ITC", Font.BOLD, 50));
//        etiquetaCarrito.setBackground(new Color(245, 196, 74));
//        GridBagConstraints gbc_etiquetaCarrito = new GridBagConstraints();
//        gbc_etiquetaCarrito.anchor = GridBagConstraints.EAST;
//        gbc_etiquetaCarrito.insets = new Insets(0, 0, 0, 5);
//        gbc_etiquetaCarrito.gridx = 2;
//        gbc_etiquetaCarrito.gridy = 0;
//        panelTitulo.add(etiquetaCarrito, gbc_etiquetaCarrito);
//
//        // JPanel para el botón de volver y la etiqueta del total del importe
//        JPanel panelFooter = new JPanel(new BorderLayout());
//        
//        add(panelFooter, BorderLayout.SOUTH);
//        
//        JPanel panelBajoCarrito = new JPanel();
//        panelBajoCarrito.setBackground(new Color(78, 1, 23));
//        panelFooter.add(panelBajoCarrito, BorderLayout.NORTH);
//        GridBagLayout gbl_panelBajoCarrito = new GridBagLayout();
//        gbl_panelBajoCarrito.columnWidths = new int[]{50, 78, 0, 77, 50, 0};
//        gbl_panelBajoCarrito.rowHeights = new int[]{20, 27, 20, 0};
//        gbl_panelBajoCarrito.columnWeights = new double[]{0.0, 0.0, 1.0, 0.0, 0.0, Double.MIN_VALUE};
//        gbl_panelBajoCarrito.rowWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
//        panelBajoCarrito.setLayout(gbl_panelBajoCarrito);
//        
//        JButton botonVolver = new JButton("Volver");
//        botonVolver.addMouseListener(new MouseAdapter() {
//        	@Override
//        	public void mouseClicked(MouseEvent e) {
//        		ventana.cambiarAPantalla(PantallaMenuProductos.class);
//        	}
//        });
//        botonVolver.setForeground(new Color(78, 1, 23));
//        botonVolver.setBackground(new Color(245, 196, 74));
//        botonVolver.setFont(new Font("Eras Medium ITC", Font.PLAIN, 16));
//        GridBagConstraints gbc_botonVolver = new GridBagConstraints();
//        gbc_botonVolver.insets = new Insets(0, 0, 5, 5);
//        gbc_botonVolver.anchor = GridBagConstraints.NORTHWEST;
//        gbc_botonVolver.gridx = 1;
//        gbc_botonVolver.gridy = 1;
//        panelBajoCarrito.add(botonVolver, gbc_botonVolver);
//        
//        JLabel etiquetaTotal = new JLabel("Total: " + totalImporte + " €");
//        etiquetaTotal.setForeground(new Color(245, 196, 74));
//        etiquetaTotal.setHorizontalAlignment(SwingConstants.RIGHT);
//        etiquetaTotal.setFont(new Font("Eras Medium ITC", Font.PLAIN, 16));
//        GridBagConstraints gbc_etiquetaTotal = new GridBagConstraints();
//        gbc_etiquetaTotal.anchor = GridBagConstraints.WEST;
//        gbc_etiquetaTotal.insets = new Insets(0, 0, 5, 5);
//        gbc_etiquetaTotal.gridx = 3;
//        gbc_etiquetaTotal.gridy = 1;
//        panelBajoCarrito.add(etiquetaTotal, gbc_etiquetaTotal);
//    }
//    
//}
//
//
//


