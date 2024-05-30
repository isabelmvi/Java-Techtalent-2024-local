package conexion_maven.C4;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class ej4_UD20 {

    public static void main(String[] args) {
        // Crear el marco
        JFrame frame = new JFrame("Aplicación de Ejemplo");

        // Crear una etiqueta
        JLabel label = new JLabel("Eventos de la Ventana", SwingConstants.CENTER);

        // Crear un área de texto
        final JTextArea textArea = new JTextArea();
        textArea.setEditable(false); // Hacer que el área de texto no sea editable
        JScrollPane scrollPane = new JScrollPane(textArea);

        // Añadir un WindowListener para capturar eventos de la ventana
        frame.addWindowListener(new WindowListener() {
            @Override
            public void windowOpened(WindowEvent e) {
                textArea.append("Ventana abierta\n");
            }

            @Override
            public void windowClosing(WindowEvent e) {
                textArea.append("Ventana cerrándose\n");
            }

            @Override
            public void windowClosed(WindowEvent e) {
                textArea.append("Ventana cerrada\n");
            }

            @Override
            public void windowIconified(WindowEvent e) {
                textArea.append("Ventana minimizada\n");
            }

            @Override
            public void windowDeiconified(WindowEvent e) {
                textArea.append("Ventana restaurada\n");
            }

            @Override
            public void windowActivated(WindowEvent e) {
                textArea.append("Ventana activada\n");
            }

            @Override
            public void windowDeactivated(WindowEvent e) {
                textArea.append("Ventana desactivada\n");
            }
        });

        // Configurar el diseño del frame
        frame.setLayout(new BorderLayout());
        frame.add(label, BorderLayout.NORTH);
        frame.add(scrollPane, BorderLayout.CENTER);

        // Configurar la operación de cierre del frame
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Establecer el tamaño del frame
        frame.setSize(400, 300);

        // Permitir al usuario cambiar el tamaño del frame
        frame.setResizable(true);

        // Centrar el frame en la pantalla
        frame.setLocationRelativeTo(null);

        // Hacer visible el frame
        frame.setVisible(true);
    }
}
