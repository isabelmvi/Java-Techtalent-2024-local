package conexion_maven.C4;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ej5_UD20 {

    public static void main(String[] args) {
        // Crear el marco
        JFrame frame = new JFrame("Aplicación de Ejemplo");

        // Crear un área de texto
        final JTextArea textArea = new JTextArea();
        textArea.setEditable(false); // Hacer que el área de texto no sea editable
        JScrollPane scrollPane = new JScrollPane(textArea);

        // Crear un botón para limpiar el área de texto
        JButton clearButton = new JButton("Limpiar");

        // Añadir un MouseListener para capturar eventos de ratón en el área de texto
        textArea.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                textArea.append("Ratón clicado en (" + e.getX() + ", " + e.getY() + ")\n");
            }

            @Override
            public void mousePressed(MouseEvent e) {
                textArea.append("Ratón presionado en (" + e.getX() + ", " + e.getY() + ")\n");
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                textArea.append("Ratón liberado en (" + e.getX() + ", " + e.getY() + ")\n");
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                textArea.append("Ratón entró en el área de texto\n");
            }

            @Override
            public void mouseExited(MouseEvent e) {
                textArea.append("Ratón salió del área de texto\n");
            }
        });

        // Añadir un ActionListener al botón para limpiar el área de texto
        clearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textArea.setText("");
            }
        });

        // Configurar el diseño del frame
        frame.setLayout(new BorderLayout());
        frame.add(scrollPane, BorderLayout.CENTER);
        frame.add(clearButton, BorderLayout.SOUTH);

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

