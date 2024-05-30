package conexion_maven.C4;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ej3_UD20 {

    public static void main(String[] args) {
        // Crear el marco
        JFrame frame = new JFrame("Aplicación de Ejemplo");

        // Crear etiquetas
        final JLabel label1 = new JLabel("Botón 1 clics: 0", SwingConstants.CENTER);
        final JLabel label2 = new JLabel("Botón 2 clics: 0", SwingConstants.CENTER);

        // Crear botones
        JButton button1 = new JButton("Botón 1");
        JButton button2 = new JButton("Botón 2");

        // Contadores para los clics
        final int[] clickCount1 = {0};
        final int[] clickCount2 = {0};

        // Añadir listeners a los botones
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                clickCount1[0]++;
                label1.setText("Botón 1 clics: " + clickCount1[0]);
            }
        });

        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                clickCount2[0]++;
                label2.setText("Botón 2 clics: " + clickCount2[0]);
            }
        });

        // Configurar el diseño del frame
        frame.setLayout(new GridLayout(2, 2));
        frame.add(label1);
        frame.add(label2);
        frame.add(button1);
        frame.add(button2);

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
