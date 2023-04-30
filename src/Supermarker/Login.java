package Supermarker;

import javax.swing.*;


import java.awt.event.*;

public class Login extends JFrame implements ActionListener {
    // Componentes de la interfaz de usuario
    JPanel panel;
    JLabel userLabel, passwordLabel, messageLabel;
    JTextField userTextField;
    JPasswordField passwordField;
    JButton loginButton;

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
    public void actionPerformed(ActionEvent e) {
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
    }

    // Método principal
    public static void main(String[] args) {

        Login loginGUI = new Login();
        loginGUI.setVisible(true);
    }
}