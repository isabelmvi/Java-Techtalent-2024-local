package conexion_maven.C4;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class ej1_UD20 {

    public static void main(String[] args) {
        // Create the frame
        JFrame frame = new JFrame("Mi Aplicación de Ejemplo");

        // Create a label
        JLabel label = new JLabel("¡Hola, Mundo!", SwingConstants.CENTER);

        // Add the label to the frame
        frame.getContentPane().add(label, BorderLayout.CENTER);

        // Set default close operation
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Set the size of the frame
        frame.setSize(400, 300);

        // Allow the user to resize the frame
        frame.setResizable(true);

        // Center the frame on the screen
        frame.setLocationRelativeTo(null);

        // Add a window listener to handle closing the window
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });

        // Make the frame visible
        frame.setVisible(true);
    }
}
