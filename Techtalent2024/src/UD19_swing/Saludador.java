package UD19_swing;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.event.*;

public class Saludador extends JFrame implements ActionListener {
    private JTextField textField;
    private JButton button;
    private boolean textoBorrado = false;
    
    public Saludador() {
        setTitle("Saludador personalizable");
        setSize(300, 150);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        // Configuración del panel principal
        JPanel mainPanel = new JPanel(null); // Cambiado de null a un layout más flexible
        mainPanel.setBackground(Color.WHITE); // Establecer color de fondo blanco

        // Configuración del campo de texto
        textField = new JTextField("Escriba un nombre para saludar");
        textField.setBounds(50, 20, 200, 30);
        textField.setForeground(Color.GRAY); // Color del texto inicial
        textField.setEditable(false); // Deshabilitar la edición del campo de texto
        textField.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (!textoBorrado) {
                    textField.setText("");
                    textField.setForeground(Color.BLACK); // Cambia el color del texto al negro cuando se empieza a escribir
                    textField.setEditable(true); // Permitir la edición del campo de texto
                    textField.requestFocus(); // Establecer el foco en el campo de texto
                    textoBorrado = true;
                }
            }
        });
        mainPanel.add(textField);

        textField.setBorder(BorderFactory.createCompoundBorder(
                new LineBorder(new Color(173, 255, 47), 2, true),
                new EmptyBorder(5, 5, 5, 5)));

        // Configuración del botón
        button = new JButton("Saludar");
        button.setBounds(100, 60, 100, 30);
        button.setBackground(Color.GREEN);
        button.addActionListener(this);
        mainPanel.add(button);

        // Configuración del panel de contenido
        getContentPane().add(mainPanel);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == button) {
            String nombre = textField.getText();
            JOptionPane.showMessageDialog(this, "Hola " + nombre + "!");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Saludador saludador = new Saludador();
            saludador.setResizable(true);
            saludador.setVisible(true);
        });
    }
}
