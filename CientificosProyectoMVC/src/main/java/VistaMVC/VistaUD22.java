package VistaMVC;

import ModeloMVC.ClienteUD22;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.util.List;

public class VistaUD22 extends JFrame {

    private JTextField idField;
    private JTextField nombreField;
    private JTextField apellidoField;
    private JTextField direccionField;
    private JTextField dniField;
    private JTextField fechaField;
    private JButton insertButton;
    private JButton listButton;
    private JButton updateButton;
    private JButton deleteButton;
    private JTextArea displayArea;

    public VistaUD22() {
        setTitle("Cliente CRUD");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Cambiar color de fondo del JFrame
        getContentPane().setBackground(Color.BLACK);

        // Panel superior para campos de entrada
        JPanel topPanel = new JPanel(new GridLayout(7, 2, 10, 10));
        topPanel.setBorder(new EmptyBorder(20, 20, 20, 20));
        topPanel.setBackground(Color.BLACK); // Fondo negro

        idField = new JTextField(20);
        nombreField = new JTextField(20);
        apellidoField = new JTextField(20);
        direccionField = new JTextField(20);
        dniField = new JTextField(20);
        fechaField = new JTextField(20);

        insertButton = new JButton("Insertar");
        listButton = new JButton("Listar Todos");
        updateButton = new JButton("Actualizar");
        deleteButton = new JButton("Eliminar");

        // Personalización de los colores
        insertButton.setBackground(new Color(50, 150, 50)); // Botón verde
        listButton.setBackground(new Color(50, 50, 150)); // Botón azul
        updateButton.setBackground(new Color(150, 50, 50)); // Botón rojo
        deleteButton.setBackground(new Color(200, 100, 50)); // Botón naranja

        // Cambiar color de texto de los botones
        insertButton.setForeground(Color.WHITE);
        listButton.setForeground(Color.WHITE);
        updateButton.setForeground(Color.WHITE);
        deleteButton.setForeground(Color.WHITE);

        topPanel.add(new JLabel("ID:"));
        topPanel.add(idField);
        topPanel.add(new JLabel("Nombre:"));
        topPanel.add(nombreField);
        topPanel.add(new JLabel("Apellido:"));
        topPanel.add(apellidoField);
        topPanel.add(new JLabel("Dirección:"));
        topPanel.add(direccionField);
        topPanel.add(new JLabel("DNI:"));
        topPanel.add(dniField);
        topPanel.add(new JLabel("Fecha (YYYY-MM-DD):"));
        topPanel.add(fechaField);

        // Panel para botones CRUD
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 10));
        buttonPanel.setBorder(new EmptyBorder(10, 10, 10, 10));
        buttonPanel.setBackground(Color.BLACK); // Fondo negro

        buttonPanel.add(insertButton);
        buttonPanel.add(listButton);
        buttonPanel.add(updateButton);
        buttonPanel.add(deleteButton);

        // Agregar los paneles al panel superior combinado
        JPanel combinedTopPanel = new JPanel(new BorderLayout());
        combinedTopPanel.add(topPanel, BorderLayout.CENTER);
        combinedTopPanel.add(buttonPanel, BorderLayout.SOUTH);
        combinedTopPanel.setBackground(Color.BLACK); // Fondo negro

        displayArea = new JTextArea(15, 50);
        displayArea.setEditable(false);
        displayArea.setBackground(Color.BLACK); // Fondo negro
        displayArea.setForeground(Color.WHITE); // Texto blanco
        JScrollPane scrollPane = new JScrollPane(displayArea);
        scrollPane.setBorder(new EmptyBorder(10, 10, 10, 10));
        scrollPane.setBackground(Color.BLACK); // Fondo negro

        // Agregar paneles al marco principal
        add(combinedTopPanel, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);

        setVisible(true);
    }

    public int getId() {
        return Integer.parseInt(idField.getText());
    }

    public String getNombre() {
        return nombreField.getText();
    }

    public String getApellido() {
        return apellidoField.getText();
    }

    public String getDireccion() {
        return direccionField.getText();
    }

    public int getDni() {
        return Integer.parseInt(dniField.getText());
    }

    public Date getFecha() {
        return Date.valueOf(fechaField.getText());
    }

    public void addInsertListener(ActionListener listener) {
        insertButton.addActionListener(listener);
    }

    public void addListListener(ActionListener listener) {
        listButton.addActionListener(listener);
    }

    public void addUpdateListener(ActionListener listener) {
        updateButton.addActionListener(listener);
    }

    public void addDeleteListener(ActionListener listener) {
        deleteButton.addActionListener(listener);
    }

    public void displayClientes(List<ClienteUD22> clientes) {
        displayArea.setText("");
        for (ClienteUD22 cliente : clientes) {
            displayArea.append(cliente.toString() + "\n");
        }
    }

    public void showMessage(String message) {
        JOptionPane.showMessageDialog(this, message);
    }

    public void showError(String error) {
        JOptionPane.showMessageDialog(this, error, "Error", JOptionPane.ERROR_MESSAGE);
    }
}
