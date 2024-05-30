package conexion_maven.C4;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ej7_UD20 {

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
        JPanel inputPanel = new JPanel(new GridLayout(2, 2));
        JPanel resultPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));

        // Crear componentes
        JLabel pesetasLabel = new JLabel("Pesetas: ");
        JLabel eurosLabel = new JLabel("Euros: ");
        final JTextField pesetasField = new JTextField(10);
        final JTextField eurosField = new JTextField(10);
        JButton toEurosButton = new JButton("A Euros");
        JButton toPesetasButton = new JButton("A Pesetas");

        // Agregar componentes al panel de entrada
        inputPanel.add(pesetasLabel);
        inputPanel.add(pesetasField);
        inputPanel.add(eurosLabel);
        inputPanel.add(eurosField);

        // Agregar componentes al panel de resultados
        resultPanel.add(toEurosButton);
        resultPanel.add(toPesetasButton);

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
                try {
                    double pesetas = Double.parseDouble(pesetasField.getText());
                    double euros = pesetas / 166.386;
                    eurosField.setText(String.format("%.2f", euros));
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(frame, "Ingrese un valor numérico válido para las pesetas", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        toPesetasButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    double euros = Double.parseDouble(eurosField.getText());
                    double pesetas = euros * 166.386;
                    pesetasField.setText(String.format("%.2f", pesetas));
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(frame, "Ingrese un valor numérico válido para los euros", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
    }
}
