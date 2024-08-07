package UD19_swing;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridBagLayout;
import java.awt.event.*;
import javax.swing.*;

public class miniEncuesta extends JFrame {

    private JRadioButton radioButtonWindows, radioButtonLinux, radioButtonMac;
    private JCheckBox checkBoxProgramacion, checkBoxDisenoGrafico, checkBoxAdministracion;
    private JSlider sliderHoras;
    private JButton buttonEnviar;
    private JTextField textFieldResultado;

    public miniEncuesta() {
        setTitle("Mini Encuesta");
        setSize(400, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        // Panel principal
        JPanel panelPrincipal = new JPanel();
        panelPrincipal.setLayout(new BoxLayout(panelPrincipal, BoxLayout.Y_AXIS));

        // Panel para el sistema operativo
        JPanel panelSistemaOperativo = new JPanel();
        panelSistemaOperativo.setBorder(BorderFactory.createTitledBorder("Sistema Operativo"));
        panelSistemaOperativo.setLayout(new FlowLayout(FlowLayout.LEFT));
        
        ButtonGroup grupoSistemaOperativo = new ButtonGroup(); // Agrupar los JRadioButtons
        radioButtonWindows = new JRadioButton("Windows");
        radioButtonLinux = new JRadioButton("Linux");
        radioButtonMac = new JRadioButton("Mac");
        grupoSistemaOperativo.add(radioButtonWindows);
        grupoSistemaOperativo.add(radioButtonLinux);
        grupoSistemaOperativo.add(radioButtonMac);
        panelSistemaOperativo.add(radioButtonWindows);
        panelSistemaOperativo.add(radioButtonLinux);
        panelSistemaOperativo.add(radioButtonMac);
        panelPrincipal.add(panelSistemaOperativo);

        // Panel para la especialidad
        JPanel panelEspecialidad = new JPanel();
        panelEspecialidad.setBorder(BorderFactory.createTitledBorder("Especialidad"));
        panelEspecialidad.setLayout(new BoxLayout(panelEspecialidad, BoxLayout.Y_AXIS));
        checkBoxProgramacion = new JCheckBox("Programación");
        checkBoxDisenoGrafico = new JCheckBox("Diseño gráfico");
        checkBoxAdministracion = new JCheckBox("Administración");
        panelEspecialidad.add(checkBoxProgramacion);
        panelEspecialidad.add(checkBoxDisenoGrafico);
        panelEspecialidad.add(checkBoxAdministracion);
        panelPrincipal.add(panelEspecialidad);

        // Panel para las horas dedicadas
        JPanel panelHoras = new JPanel();
        panelHoras.setBorder(BorderFactory.createTitledBorder("Horas Dedicadas en el Ordenador"));
        panelHoras.setLayout(new FlowLayout(FlowLayout.LEFT));
        sliderHoras = new JSlider(0, 10, 0);
        sliderHoras.setMajorTickSpacing(1);
        sliderHoras.setPaintTicks(true);
        sliderHoras.setPaintLabels(true);
        panelHoras.add(sliderHoras);
        panelPrincipal.add(panelHoras);

        // Panel para el botón y el resultado
        JPanel panelBotonResultado = new JPanel();
        panelBotonResultado.setLayout(new BorderLayout());
        buttonEnviar = new JButton("Enviar");
        textFieldResultado = new JTextField();
        textFieldResultado.setEditable(false);
        panelBotonResultado.add(buttonEnviar, BorderLayout.NORTH);
        panelBotonResultado.add(textFieldResultado, BorderLayout.CENTER);
        panelPrincipal.add(panelBotonResultado);

        // Escuchadores de eventos
        buttonEnviar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mostrarResultado();
            }
        });

        // Añadir el panel principal al JFrame
        add(panelPrincipal);
    }

    private void mostrarResultado() {
        StringBuilder resultado = new StringBuilder();
        resultado.append("SISTEMA OPERATIVO: ");
        if (radioButtonWindows.isSelected()) {
            resultado.append("Windows\n");
        } else if (radioButtonLinux.isSelected()) {
            resultado.append("Linux\n");
        } else if (radioButtonMac.isSelected()) {
            resultado.append("Mac\n");
        }
        resultado.append("ESPECIALIDAD: ");
        if (checkBoxProgramacion.isSelected()) {
            resultado.append("Programación\n");
        }
        if (checkBoxDisenoGrafico.isSelected()) {
            resultado.append("Diseño gráfico\n");
        }
        if (checkBoxAdministracion.isSelected()) {
            resultado.append("Administración\n");
        }
        resultado.append("\nHORAS DEDICADAS AL ORDENADOR: ").append(sliderHoras.getValue());

        textFieldResultado.setText(resultado.toString());
        textFieldResultado.setAlignmentY(CENTER_ALIGNMENT);
        textFieldResultado.setBounds(30, 40, 1200, 30);
        textFieldResultado.setHorizontalAlignment(JTextField.CENTER);
        setLayout(new GridBagLayout());
        add(textFieldResultado);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                miniEncuesta encuesta = new miniEncuesta();
                encuesta.setVisible(true);
            }
        });
    }
}
