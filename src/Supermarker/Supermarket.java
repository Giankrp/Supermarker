package Supermarker;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Supermarket extends JFrame implements ActionListener {

    JLabel lblTitulo, lblProducto1, lblProducto2, lblProducto3, lblPrecio1, lblPrecio2, lblPrecio3, lblTotal;
    JTextField txtCantidad1, txtCantidad2, txtCantidad3;
    JButton btnAgregar1, btnQuitar1, btnAgregar2, btnQuitar2, btnAgregar3, btnQuitar3, btnPagar;

    int precio1 = 10;
    int precio2 = 15;
    int precio3 = 20;
    int cantidad1 = 0;
    int cantidad2 = 0;
    int cantidad3 = 0;
    int total = 0;

    public Supermarket() {

        super("Supermercado");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Panel para el título
        JPanel panelTitulo = new JPanel(new FlowLayout(FlowLayout.LEFT));
        lblTitulo = new JLabel("Producto");

        panelTitulo.add(lblTitulo);
        lblTitulo = new JLabel("Precio");
        lblTitulo.setBounds(150, 3, 90, 25);
        panelTitulo.add(new JLabel(" "));
        add(lblTitulo);
        add(panelTitulo, BorderLayout.PAGE_START);

        // Panel para los productos
        JPanel panelProductos = new JPanel(new GridLayout(3, 4));
        lblProducto1 = new JLabel("Manzanas");
        panelProductos.add(lblProducto1);
        lblPrecio1 = new JLabel("$" + precio1);
        panelProductos.add(new JLabel(" "));
        panelProductos.add(lblPrecio1);
        txtCantidad1 = new JTextField(5);
        panelProductos.add(txtCantidad1);
        btnAgregar1 = new JButton("Agregar");
        btnAgregar1.addActionListener(this);
        panelProductos.add(btnAgregar1);
        btnQuitar1 = new JButton("Quitar");
        btnQuitar1.addActionListener(this);
        panelProductos.add(btnQuitar1);

        lblProducto2 = new JLabel("Leche");
        panelProductos.add(lblProducto2);
        lblPrecio2 = new JLabel("$" + precio2);
        panelProductos.add(new JLabel(" "));
        panelProductos.add(lblPrecio2);
        txtCantidad2 = new JTextField(5);
        panelProductos.add(txtCantidad2);
        btnAgregar2 = new JButton("Agregar");
        btnAgregar2.addActionListener(this);
        panelProductos.add(btnAgregar2);
        btnQuitar2 = new JButton("Quitar");
        btnQuitar2.addActionListener(this);
        panelProductos.add(btnQuitar2);

        lblProducto3 = new JLabel("Pan");
        panelProductos.add(lblProducto3);
        lblPrecio3 = new JLabel("$" + precio3);
        panelProductos.add(new JLabel(" "));
        panelProductos.add(lblPrecio3);
        txtCantidad3 = new JTextField(5);
        panelProductos.add(txtCantidad3);
        btnAgregar3 = new JButton("Agregar");
        btnAgregar3.addActionListener(this);
        panelProductos.add(btnAgregar3);
        btnQuitar3 = new JButton("Quitar");
        btnQuitar3.addActionListener(this);
        panelProductos.add(btnQuitar3);

        add(panelProductos, BorderLayout.CENTER);

        // Panel para el total y botón de pagar
        JPanel panelTotal = new JPanel(new FlowLayout(FlowLayout.CENTER));
        lblTotal = new JLabel("Total: $" + total);
        panelTotal.add(lblTotal);
        panelTotal.add(new JLabel(" "));
        panelTotal.add(new JLabel(" "));
        btnPagar = new JButton("Pagar");
        btnPagar.addActionListener(this);
        panelTotal.add(btnPagar);
        add(panelTotal, BorderLayout.SOUTH);

        pack();
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();

        try {
            // Agregar o quitar productos del Producto1
            if (source == btnAgregar1) {
                cantidad1 += Integer.parseInt(txtCantidad1.getText());
            } else if (source == btnQuitar1) {
                cantidad1 -= Integer.parseInt(txtCantidad1.getText());
            }

            // Agregar o quitar productos del Producto2
            if (source == btnAgregar2) {
                cantidad2 += Integer.parseInt(txtCantidad2.getText());
            } else if (source == btnQuitar2) {
                cantidad2 -= Integer.parseInt(txtCantidad2.getText());
            }
            if (source == btnAgregar3) {
                cantidad3 += Integer.parseInt(txtCantidad3.getText());
            } else if (source == btnQuitar3) {
                cantidad3 -= Integer.parseInt(txtCantidad3.getText());
            }

            // Actualizar el total
            // Actualizar el total
            total = (precio1 * cantidad1) + (precio2 * cantidad2) + (precio3 * cantidad3);

            lblTotal.setText("Total: $" + total);

            // Mostrar el monto total a pagar
            if (source == btnPagar) {
                JOptionPane.showMessageDialog(this, "Total a pagar: $" + total);
            }

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Ingrese una cantidad válida");
        }
    }

    public static void main(String[] args) {
        Supermarket supermercado = new Supermarket();
    }
}
