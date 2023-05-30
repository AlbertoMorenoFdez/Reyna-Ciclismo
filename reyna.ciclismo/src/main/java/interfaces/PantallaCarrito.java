package interfaces;

import java.awt.BorderLayout;
import java.awt.Font;
import java.util.LinkedHashSet;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import clases.Producto;
import clases.ProductosComprados;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

//public class PantallaCarrito extends JPanel {
//    private Ventana ventana;
//
//    public PantallaCarrito(Ventana v) {
//        this.ventana = v;
//
//        setLayout(new BorderLayout());
//
//        JLabel etiquetaTitulo = new JLabel("Carrito de Compras");
//        etiquetaTitulo.setHorizontalAlignment(SwingConstants.CENTER);
//        etiquetaTitulo.setFont(new Font("Eras Medium ITC", Font.BOLD, 24));
//        add(etiquetaTitulo, BorderLayout.NORTH);
//
//        JPanel panelProductos = new JPanel();
//        panelProductos.setLayout(new BoxLayout(panelProductos, BoxLayout.X_AXIS));
//        JScrollPane scrollPane = new JScrollPane(panelProductos);
//        add(scrollPane, BorderLayout.CENTER);
//
//        LinkedHashSet<ProductosComprados> productosComprados = ventana.getCarrito().getProductosComprados();
//
//        for (ProductosComprados pc : productosComprados) {
//            JLabel etiquetaProducto = new JLabel("Productos:");
//            etiquetaProducto.setFont(new Font("Eras Medium ITC", Font.PLAIN, 16));
//            panelProductos.add(etiquetaProducto);
//
//            for (Producto producto : pc.getProductos()) {
//            	
//            	JLabel etiquetaMarca = new JLabel("Marca: " + producto.getMarca());
//                etiquetaMarca.setFont(new Font("Eras Medium ITC", Font.PLAIN, 14));
//                panelProductos.add(etiquetaMarca, BorderLayout.CENTER);
//
//                
//                JLabel etiquetaNombreProducto = new JLabel(producto.getModelo());
//                etiquetaNombreProducto.setFont(new Font("Eras Medium ITC", Font.PLAIN, 14));
//                panelProductos.add(etiquetaNombreProducto);
//                
//                JLabel etiquetaPrecio = new JLabel("Precio: " + producto.getPrecio() + " €");
//                etiquetaPrecio.setFont(new Font("Eras Medium ITC", Font.PLAIN, 14));
//                panelProductos.add(etiquetaPrecio, BorderLayout.EAST);
//            }
//
//            panelProductos.add(new JSeparator());
//        }
//
//        JButton botonVolver = new JButton("Volver");
//        botonVolver.addMouseListener(new MouseAdapter() {
//        	@Override
//        	public void mouseClicked(MouseEvent e) {
//        		ventana.cambiarAPantalla(PantallaMenuProductos.class);
//        	}
//        });
//        botonVolver.setFont(new Font("Eras Medium ITC", Font.PLAIN, 16));
//        
//        add(botonVolver, BorderLayout.SOUTH);
//    }
//}

//public class PantallaCarrito extends JPanel {
//    private Ventana ventana;
//
//    public PantallaCarrito(Ventana v) {
//        this.ventana = v;
//        float totalImporte=(float) 0.0;
//        setLayout(new BorderLayout());
//
//        JLabel etiquetaTitulo = new JLabel("Carrito de Compras");
//        etiquetaTitulo.setHorizontalAlignment(SwingConstants.CENTER);
//        etiquetaTitulo.setFont(new Font("Eras Medium ITC", Font.BOLD, 24));
//        add(etiquetaTitulo, BorderLayout.NORTH);
//
//        // Crear el modelo de datos para la tabla
//        DefaultTableModel modeloTabla = new DefaultTableModel();
//        modeloTabla.addColumn("Marca");
//        modeloTabla.addColumn("Modelo");
//        modeloTabla.addColumn("Precio");
//
//        // Obtener los productos del carrito
//        LinkedHashSet<ProductosComprados> productosComprados = ventana.getCarrito().getProductosComprados();
//
//        // Recorrer los productos y agregarlos al modelo de datos
//        for (ProductosComprados pc : productosComprados) {
//            for (Producto producto : pc.getProductos()) {
//            	float importeProducto=producto.getPrecio();
//            	totalImporte+=importeProducto;
//                Object[] fila = {
//                        producto.getMarca(),
//                        producto.getModelo(),
//                        producto.getPrecio()
//                };
//                modeloTabla.addRow(fila);
//            }
//        }
//
//        // Crear la tabla y asignarle el modelo de datos
//        JTable tablaProductos = new JTable(modeloTabla);
//
//        // Agregar la tabla a un JScrollPane
//        JScrollPane scrollPane = new JScrollPane(tablaProductos);
//        add(scrollPane, BorderLayout.CENTER);
        
//     // Etiqueta para mostrar el total del importe
//        JLabel etiquetaTotal = new JLabel("Total: " + totalImporte + " €");
//        etiquetaTotal.setFont(new Font("Eras Medium ITC", Font.PLAIN, 16));
//        add(etiquetaTotal, BorderLayout.SOUTH);

//        JButton botonVolver = new JButton("Volver");
//      botonVolver.addMouseListener(new MouseAdapter() {
//      	@Override
//      	public void mouseClicked(MouseEvent e) {
//      		ventana.cambiarAPantalla(PantallaMenuProductos.class);
//      	}
//      });
//      botonVolver.setFont(new Font("Eras Medium ITC", Font.PLAIN, 16));
//      
//      add(botonVolver, BorderLayout.SOUTH);
//    }
//}

public class PantallaCarrito extends JPanel {
    private Ventana ventana;

    public PantallaCarrito(Ventana v) {
        this.ventana = v;
        float totalImporte = (float) 0.0;
        setLayout(new BorderLayout());

        JPanel panelPrincipal = new JPanel(new BorderLayout()); // JPanel principal

        JLabel etiquetaTitulo = new JLabel("Carrito de Compras");
        etiquetaTitulo.setHorizontalAlignment(SwingConstants.CENTER);
        etiquetaTitulo.setFont(new Font("Eras Medium ITC", Font.BOLD, 24));
        panelPrincipal.add(etiquetaTitulo, BorderLayout.NORTH);

        // Crear el modelo de datos para la tabla
        DefaultTableModel modeloTabla = new DefaultTableModel();
        modeloTabla.addColumn("Marca");
        modeloTabla.addColumn("Modelo");
        modeloTabla.addColumn("Precio");

        // Obtener los productos del carrito
        LinkedHashSet<ProductosComprados> productosComprados = ventana.getCarrito().getProductosComprados();

        // Recorrer los productos y agregarlos al modelo de datos
        for (ProductosComprados pc : productosComprados) {
            for (Producto producto : pc.getProductos()) {
                float importeProducto = producto.getPrecio();
                totalImporte += importeProducto;
                Object[] fila = {
                        producto.getMarca(),
                        producto.getModelo(),
                        producto.getPrecio()
                };
                modeloTabla.addRow(fila);
            }
        }

        // Crear la tabla y asignarle el modelo de datos
        JTable tablaProductos = new JTable(modeloTabla);

        // Agregar la tabla a un JScrollPane
        JScrollPane scrollPane = new JScrollPane(tablaProductos);
        panelPrincipal.add(scrollPane, BorderLayout.CENTER);

        // Agregar el panel principal al panel PantallaCarrito
        add(panelPrincipal, BorderLayout.CENTER);

        // JPanel para el botón de volver y la etiqueta del total del importe
        JPanel panelFooter = new JPanel(new BorderLayout());
        
        JButton botonVolver = new JButton("Volver");
        botonVolver.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                ventana.cambiarAPantalla(PantallaMenuProductos.class);
            }
        });
        botonVolver.setFont(new Font("Eras Medium ITC", Font.PLAIN, 16));
        panelFooter.add(botonVolver, BorderLayout.WEST);
        
        JLabel etiquetaTotal = new JLabel("Total: " + totalImporte + " €");
        etiquetaTotal.setFont(new Font("Eras Medium ITC", Font.PLAIN, 16));
        etiquetaTotal.setHorizontalAlignment(SwingConstants.RIGHT);
        panelFooter.add(etiquetaTotal, BorderLayout.EAST);
        
        add(panelFooter, BorderLayout.SOUTH);
    }
    
}



