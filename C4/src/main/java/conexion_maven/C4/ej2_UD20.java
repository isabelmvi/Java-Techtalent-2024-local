package conexion_maven.C4;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ej2_UD20 {

    public static void main(String[] args) {
        // Crear el marco
        JFrame frame = new JFrame("Aplicación de Ejemplo");

        // Crear una etiqueta
        final JLabel label = new JLabel("Presiona un botón", SwingConstants.CENTER);

        // Crear botones
        JButton button1 = new JButton("Botón 1");
        JButton button2 = new JButton("Botón 2");

        // Añadir listeners a los botones
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                label.setText("Último botón presionado: Botón 1");
            }
        });

        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                label.setText("Último botón presionado: Botón 2");
            }
        });

        // Configurar el diseño del frame
        frame.setLayout(new BorderLayout());
        frame.add(label, BorderLayout.NORTH);
        frame.add(button1, BorderLayout.WEST);
        frame.add(button2, BorderLayout.EAST);

        // Configurar la operación de cierre del frame
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Establecer el tamaño del frame
        frame.setSize(400, 200);

        // Permitir al usuario cambiar el tamaño del frame
        frame.setResizable(true);

        // Centrar el frame en la pantalla
        frame.setLocationRelativeTo(null);

        // Hacer visible el frame
        frame.setVisible(true);
    }
}
