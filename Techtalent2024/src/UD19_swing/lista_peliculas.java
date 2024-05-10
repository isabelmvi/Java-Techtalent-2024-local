package UD19_swing;

import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

public class lista_peliculas extends JFrame {
    private JComboBox<String> comboBoxPeliculas;
    private JTextField textFieldNuevaPelicula;
    private JButton buttonAgregar;
    
    public lista_peliculas() {
        setTitle("Lista de Películas");
        setSize(400, 200);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        // Crear JLabel para etiqueta "Películas:"
        JLabel labelPeliculas = new JLabel("Películas:");
        add(labelPeliculas);

        // Crear JComboBox para almacenar las películas
        comboBoxPeliculas = new JComboBox<>();
        comboBoxPeliculas.setPreferredSize(new Dimension(300, 20));
        comboBoxPeliculas.addItem("El Padrino");
        comboBoxPeliculas.addItem("Forrest Gump");
        comboBoxPeliculas.addItem("La La Land");
        comboBoxPeliculas.addItem("Inception");
        comboBoxPeliculas.addItem("Pulp Fiction");
        add(comboBoxPeliculas);

        // Crear JLabel para etiqueta "Introduce el título de una película:"
        JLabel labelIntroducirPelicula = new JLabel("Introduce el título de una película:");
        add(labelIntroducirPelicula);

        // Crear panel para centrar el botón y el JTextField
        JPanel panelCentrado = new JPanel(new FlowLayout(FlowLayout.CENTER));

        // Crear JTextField para introducir nuevas películas
        textFieldNuevaPelicula = new JTextField(20);
        panelCentrado.add(textFieldNuevaPelicula);

        // Crear JButton para agregar películas
        buttonAgregar = new JButton("Añadir");
        buttonAgregar.addActionListener(e -> {
            String nombrePelicula = textFieldNuevaPelicula.getText();
            if (!nombrePelicula.isEmpty()) {
                comboBoxPeliculas.addItem(nombrePelicula);
                textFieldNuevaPelicula.setText("");
            } else {
                JOptionPane.showMessageDialog(this, "Por favor, introduce el nombre de la película.");
            }
        });
        panelCentrado.add(buttonAgregar);

        add(panelCentrado);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            lista_peliculas listaPeliculas = new lista_peliculas();
            listaPeliculas.setVisible(true);
        });
    }
}
