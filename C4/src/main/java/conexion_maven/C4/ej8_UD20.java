package conexion_maven.C4;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class ej8_UD20 {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }

    private static void createAndShowGUI() {
        // Crear el marco
        final JFrame frame = new JFrame("Conversor de Pesetas y Euros");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Crear paneles
        JPanel inputPanel = new JPanel(new GridLayout(3, 2));
        JPanel resultPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));

        // Crear componentes
        JLabel pesetasLabel = new JLabel("Pesetas: ");
        JLabel eurosLabel = new JLabel("Euros: ");
        final JTextField pesetasField = new JTextField(10);
        final JTextField eurosField = new JTextField(10);
        JButton toEurosButton = new JButton("A Euros");
        JButton toPesetasButton = new JButton("A Pesetas");
        JButton clearButton = new JButton("Limpiar");

        // Agregar componentes al panel de entrada
        inputPanel.add(pesetasLabel);
        inputPanel.add(pesetasField);
        inputPanel.add(eurosLabel);
        inputPanel.add(eurosField);
        inputPanel.add(toEurosButton);
        inputPanel.add(toPesetasButton);

        // Agregar componentes al panel de resultados
        resultPanel.add(clearButton);

        // Agregar paneles al marco
        frame.getContentPane().setLayout(new BorderLayout());
        frame.getContentPane().add(inputPanel, BorderLayout.NORTH);
        frame.getContentPane().add(resultPanel, BorderLayout.CENTER);

        // Configurar el tamaño y la visibilidad del marco
        frame.setSize(300, 150);
        frame.setVisible(true);

        // Configurar los eventos de clic de los botones de conversión
        toEurosButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                convertToEuros(pesetasField, eurosField, frame);
            }
        });

        toPesetasButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                convertToPesetas(pesetasField, eurosField, frame);
            }
        });

        // Configurar el evento de clic del botón de limpieza
        clearButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                pesetasField.setText("");
                eurosField.setText("");
            }
        });

        // Permitir operar con los botones desde el teclado
        pesetasField.addKeyListener(new KeyListener() {
            public void keyTyped(KeyEvent e) {
            }

            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    convertToEuros(pesetasField, eurosField, frame);
                }
            }

            public void keyReleased(KeyEvent e) {
            }
        });

        eurosField.addKeyListener(new KeyListener() {
            public void keyTyped(KeyEvent e) {
            }

            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    convertToPesetas(pesetasField, eurosField, frame);
                }
            }

            public void keyReleased(KeyEvent e) {
            }
        });
    }

    private static void convertToEuros(JTextField pesetasField, JTextField eurosField, JFrame frame) {
        try {
            double pesetas = Double.parseDouble(pesetasField.getText());
            double euros = pesetas / 166.386;
            eurosField.setText(String.format("%.2f", euros));
        } catch (NumberFormatException ex) {
            showError(frame, "Ingrese un valor numérico válido para las pesetas");
        }
    }

    private static void convertToPesetas(JTextField pesetasField, JTextField eurosField, JFrame frame) {
        try {
            double euros = Double.parseDouble(eurosField.getText());
            double pesetas = euros * 166.386;
            pesetasField.setText(String.format("%.2f", pesetas));
        } catch (NumberFormatException ex) {
            showError(frame, "Ingrese un valor numérico válido para los euros");
        }
    }

    private static void showError(JFrame frame, String message) {
        JOptionPane.showMessageDialog(frame, message, "Error", JOptionPane.ERROR_MESSAGE);
    }
}
