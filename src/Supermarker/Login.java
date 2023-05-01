package Supermarker; // Aca importamos el paquete supermarker

import javax.swing.*; //importamos la biblioteca swing que nos da interfaces ya usuario ya hechas

import java.awt.event.*;// importamos la biblioteca awt.event para los eventos de click en los botones

public class Login extends JFrame implements ActionListener {// creamos la clase Supermarket que extienede de
    // JFrame para la interfaz
    // y ActionListener para los eventos


    // Componentes de la interfaz de usuario
    JPanel panel; //Creamos el panel principal de la intefaz
    JLabel userLabel, passwordLabel, messageLabel;//Aca creamos los labels
    JTextField userTextField; //Aca creamos los campos de texto para las credenciales de usuraio
    JPasswordField passwordField; //Y aca las credeciales de la contraseña
    JButton loginButton; //Y aca el boton de login que acciona un evento si las credenciales de usuario son correctas, si no
    //se dispara otro eveneto

    // Constructor
    public Login() {
        // Configuración de la ventana de inicio de sesión
        setTitle("Login");
        setSize(540, 360);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Creación de componentes de la interfaz de usuario
        userLabel = new JLabel("User Name:");
        passwordLabel = new JLabel("Password:");
        userTextField = new JTextField(20);
        passwordField = new JPasswordField(20);
        loginButton = new JButton("Log in");
        messageLabel = new JLabel("");

        // Configuración de los componentes de la interfaz de usuario
        userLabel.setBounds(140, 90, 90, 25);
        userTextField.setBounds(230, 90, 120, 25);
        passwordLabel.setBounds(140, 130, 90, 25);
        passwordField.setBounds(230, 130, 120, 25);
        loginButton.setBounds(200, 200, 90, 25);
        messageLabel.setBounds(10, 120, 280, 25);

        // Agregar componentes a la ventana de inicio de sesión
        add(userLabel);
        add(userTextField);
        add(passwordLabel);
        add(passwordField);
        add(loginButton);
        add(messageLabel);

        // Agregar ActionListener al botón de inicio de sesión
        loginButton.addActionListener(this);
    }

    // Método para verificar si las credenciales son correctas
    public boolean login(String user, String password) {
        // Aquí se realizaría la verificación de las credenciales.
        // En este caso, simplemente comprobamos si el nombre de usuario
        // es "admin" y la contraseña es "admin".
        return user.equals("admin") && password.equals("admin");
    }

    // ActionListener para el botón de inicio de sesión
    public void actionPerformed(ActionEvent event) {
        try { //hacemos un try catch para manejar algun posible error
            if (login(userTextField.getText(), new String(passwordField.getPassword()))) {
                // Si las credenciales son correctas, mostrar la interfaz de usuario
                JOptionPane.showMessageDialog(null, "Bienvenido al supermercado :DDDDDDD");
                Supermarket supermarket = new Supermarket();
                supermarket.setVisible(true);
                setVisible(false);
            } else {
                // Si las credenciales son incorrectas, mostrar un mensaje de error
                JOptionPane.showMessageDialog(null, "La contraseña o usuario son invalidos");
            }
            
        } catch (Exception exception) {// aca manejamos el error
           JOptionPane.showMessageDialog(null,"Ingrese el tipo de dato adecuado");
        }
       
    }

    // Método principal
    public static void main(String[] args) { //aqui la funcion main para ejecutar el programa

        Login loginGUI = new Login();
        loginGUI.setVisible(true);
    }
}