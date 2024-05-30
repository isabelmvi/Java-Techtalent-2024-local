package conexion_maven.C4;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ej6_UD20 {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }

    private static void createAndShowGUI() {
        // Crear el marco
        JFrame frame = new JFrame("Calculadora de IMC");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Crear paneles
        JPanel inputPanel = new JPanel(new GridLayout(2, 2));
        JPanel resultPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));

        // Crear componentes
        JLabel weightLabel = new JLabel("Peso (kg): ");
        JLabel heightLabel = new JLabel("Altura (m): ");
        final JTextField weightField = new JTextField(10);
        final JTextField heightField = new JTextField(10);
        JButton calculateButton = new JButton("Calcular IMC");
        final JLabel resultLabel = new JLabel("");

        // Agregar componentes al panel de entrada
        inputPanel.add(weightLabel);
        inputPanel.add(weightField);
        inputPanel.add(heightLabel);
        inputPanel.add(heightField);

        // Agregar componentes al panel de resultados
        resultPanel.add(calculateButton);
        resultPanel.add(resultLabel);

        // Agregar paneles al marco
        frame.getContentPane().setLayout(new BorderLayout());
        frame.getContentPane().add(inputPanel, BorderLayout.NORTH);
        frame.getContentPane().add(resultPanel, BorderLayout.CENTER);

        // Configurar el tamaño y la visibilidad del marco
        frame.setSize(300, 150);
        frame.setVisible(true);

        // Configurar el evento de clic del botón de cálculo
        calculateButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Obtener el peso y la altura
                double weight = Double.parseDouble(weightField.getText());
                double height = Double.parseDouble(heightField.getText());

                // Calcular el IMC
                double bmi = weight / (height * height);

                // Mostrar el resultado en el JLabel
                resultLabel.setText(String.format("Tu IMC es: %.2f", bmi));
            }
        });
    }
}
