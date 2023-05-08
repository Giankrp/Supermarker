package Supermarker; //importamos el paquete Supermarker

import javax.swing.*; //importamos la biblioteca swing que nos da interfaces ya usuario ya hechas
import java.awt.*; //importamos la biblioteca awt para los paneles, campos de texto y bonotnes
import java.awt.event.*;// importamos la biblioteca awt.event para los eventos de click en los botones

public class Supermarket extends JFrame implements ActionListener { // creamos la clase Supermarket que extienede de
                                                                    // JFrame para la interfaz
    // y ActionListener para los eventos

    JLabel lblTitulo, lblProducto1, lblProducto2, lblProducto3, lblPrecio1, lblPrecio2, lblPrecio3, lblTotal;// creamos
                                                                                                             // las
                                                                                                             // labels
    JTextField txtCantidad1, txtCantidad2, txtCantidad3; // En esta liena creamos los campos de texto
    JButton btnAgregar1, btnQuitar1, btnAgregar2, btnQuitar2, btnAgregar3, btnQuitar3, btnPagar; // y en esta los
                                                                                                 // botones

    int precio1 = 10;
    int precio2 = 15;
    int precio3 = 20;
    int cantidad1 = 0;
    int cantidad2 = 0; // En estas lineas creamos las variables en donde se vam a guardar cada una de
                       // las cantiadades, precios y totales
    int cantidad3 = 0;
    int total = 0;

    public Supermarket() { // creamos la funcion supermarket

        super("Supermercado"); // Aca colocamos el super ya que hereda de JFrame y de ActionListener
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocation(450, 270);

        // Panel para el título
        JPanel panelTitulo = new JPanel(new FlowLayout(FlowLayout.LEFT));
        lblTitulo = new JLabel("Producto");

        panelTitulo.add(lblTitulo);
        lblTitulo = new JLabel("Precio");
        lblTitulo.setBounds(150, 3, 90, 25);
        panelTitulo.add(new JLabel(" "));
        add(lblTitulo);
        add(panelTitulo, BorderLayout.PAGE_START);

        // Aca creamos el panel para los productos
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

        // Aca creamos el panel para el total y botón de pagar
        JPanel panelTotal = new JPanel(new FlowLayout(FlowLayout.CENTER));
        lblTotal = new JLabel("Total: $" + total);
        panelTotal.add(lblTotal);
        panelTotal.add(new JLabel(" "));
        panelTotal.add(new JLabel(" "));
        btnPagar = new JButton("Pagar");
        btnPagar.addActionListener(this);
        panelTotal.add(btnPagar);
        add(panelTotal, BorderLayout.SOUTH);

        pack(); // Empaquetamos para que se ajuste tanto a lo que mejor queda, como a los
                // cambios que le hicimos arriba
        setVisible(true);
    }

    public void actionPerformed(ActionEvent event) { // creamos la funcion para los eventos del boton
        Object source = event.getSource(); // Aqui generamos el evento

        try { // Agregamos un try catch para el evento de los botones
              // Agregar o quitar productos del Producto1
            if (source == btnAgregar1) {
                cantidad1 += Integer.parseInt(txtCantidad1.getText());
            } else if (source == btnQuitar1) {
                if (cantidad1 > 0) {
                    cantidad1 -= Integer.parseInt(txtCantidad1.getText());
                }
            }

            // Agregar o quitar productos del Producto2
            if (source == btnAgregar2) {
                cantidad2 += Integer.parseInt(txtCantidad2.getText());
            } else if (source == btnQuitar2) {
                if (cantidad2 > 0) {
                    cantidad2 -= Integer.parseInt(txtCantidad2.getText());
                }
            }
            // Agregar o quitar productos del Producto3
            if (source == btnAgregar3) {
                cantidad3 += Integer.parseInt(txtCantidad3.getText());
            } else if (source == btnQuitar3) {
                if (cantidad3 > 0) {
                    cantidad3 -= Integer.parseInt(txtCantidad3.getText());
                }
            }

            // Actualizar el total
            total = (precio1 * cantidad1) + (precio2 * cantidad2) + (precio3 * cantidad3);
            if (total < 0) {

                throw new NumberFormatException();

            }

            lblTotal.setText("Total: $" + total);

            // Mostrar el monto total a pagar
            if (source == btnPagar) {
                JOptionPane.showMessageDialog(this, "Total a pagar: $" + total);
            }

        } catch (NumberFormatException exception) {
            JOptionPane.showMessageDialog(this, "Ingrese una cantidad válida");
        }
    }

    public static void main(String[] args) {
        Supermarket supermercado = new Supermarket();
    }
}
