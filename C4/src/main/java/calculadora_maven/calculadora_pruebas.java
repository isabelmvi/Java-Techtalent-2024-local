package calculadora_maven;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class calculadora_pruebas extends JFrame {

    private JTextField campoEntrada;
    private JTextField campoResultado;
    private JTextField campoNumerosSeleccionados;
    private JLabel labelResultado;

    private String operacionActual = "";
    private StringBuilder numerosSeleccionados = new StringBuilder();

    public calculadora_pruebas() {
        setLayout(new BorderLayout());

        // Definir colores
        Color azulOscuro = new Color(0, 0, 139); // Azul oscuro
        Color blanco = Color.WHITE;


        // Creamos el panel para los campos de entrada y resultado
        JPanel panelCampos = new JPanel(new BorderLayout());

        // Creamos los campos de texto
        campoEntrada = new JTextField(10);
        campoResultado = new JTextField(10);
        campoResultado.setEditable(false);
        campoNumerosSeleccionados = new JTextField(10);
        campoNumerosSeleccionados.setEditable(false);

        // Añadimos los campos de texto al panel
        panelCampos.add(campoEntrada, BorderLayout.NORTH);

        // Creamos los labels
        labelResultado = new JLabel("Resultado:");

        // Creamos los botones numéricos
        JPanel panelNumerico = new JPanel(new GridLayout(4, 3));
        for (int i = 1; i <= 9; i++) {
            JButton botonNumero = new JButton(String.valueOf(i));
            botonNumero.setBackground(azulOscuro);
            botonNumero.setForeground(blanco);
            botonNumero.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    JButton source = (JButton) e.getSource();
                    String numeroSeleccionado = source.getText();
                    campoEntrada.setText(campoEntrada.getText() + numeroSeleccionado);
                    numerosSeleccionados.append(numeroSeleccionado);
                    campoNumerosSeleccionados.setText(numerosSeleccionados.toString());
                }
            });
            panelNumerico.add(botonNumero);
        }
        // Botón cero
        JButton botonCero = new JButton("0");
        botonCero.setBackground(azulOscuro);
        botonCero.setForeground(blanco);
        botonCero.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                campoEntrada.setText(campoEntrada.getText() + "0");
                numerosSeleccionados.append("0");
                campoNumerosSeleccionados.setText(numerosSeleccionados.toString());
            }
        });
        panelNumerico.add(botonCero);
        // Botón para borrar
        JButton botonBorrar = new JButton("C");
        botonBorrar.setBackground(Color.LIGHT_GRAY);
        botonBorrar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                campoEntrada.setText("");
                campoResultado.setText("");
                operacionActual = "";
                numerosSeleccionados.setLength(0);
                campoNumerosSeleccionados.setText("");
            }
        });
        panelNumerico.add(botonBorrar);

        // Creamos los botones de operaciones
        JPanel panelOperaciones = new JPanel(new FlowLayout());
        JButton botonSuma = new JButton("+");
        botonSuma.setBackground(Color.LIGHT_GRAY);
        botonSuma.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                agregarOperacion("+");
            }
        });
        panelOperaciones.add(botonSuma);

        JButton botonResta = new JButton("-");
        botonResta.setBackground(Color.LIGHT_GRAY);
        botonResta.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                agregarOperacion("-");
            }
        });
        panelOperaciones.add(botonResta);

        JButton botonMultiplicacion = new JButton("*");
        botonMultiplicacion.setBackground(Color.LIGHT_GRAY);
        botonMultiplicacion.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                agregarOperacion("*");
            }
        });
        panelOperaciones.add(botonMultiplicacion);

        JButton botonDivision = new JButton("/");
        botonDivision.setBackground(Color.LIGHT_GRAY);
        botonDivision.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                agregarOperacion("/");
            }
        });
        panelOperaciones.add(botonDivision);

        JButton botonIgual = new JButton("=");
        botonIgual.setBackground(Color.LIGHT_GRAY);
        botonIgual.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                mostrarResultado();
            }
        });
        panelNumerico.add(botonIgual);

        // Agregamos los componentes a la ventana
        add(panelCampos, BorderLayout.NORTH); // Usamos panelCampos en lugar de campoEntrada y campoResultado
        add(panelNumerico, BorderLayout.CENTER);
        add(panelOperaciones, BorderLayout.SOUTH);
      
        // Ocultar el campo de resultado al inicio
        campoResultado.setVisible(false);

        // Tamaño y título de la ventana
        setSize(300, 300);
        setTitle("MiniCalculadora");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }

    private void agregarOperacion(String op) {
        if (campoEntrada.getText().isEmpty() && !campoResultado.getText().isEmpty()) {
            operacionActual = campoResultado.getText() + op;
        } else {
            operacionActual += campoEntrada.getText() + op;
        }
        campoEntrada.setText("");
        numerosSeleccionados.setLength(0);
        campoNumerosSeleccionados.setText("");
    }

    private void mostrarResultado() {
        if (!operacionActual.isEmpty()) {
            String expresion = operacionActual + campoEntrada.getText();
            double resultado = evaluarExpresion(expresion);
            campoEntrada.setText(resultado + ""); // Mostrar el resultado en el campoEntrada
            campoResultado.setText(""); // Limpiar el campoResultado
            campoResultado.setVisible(false); // Ocultar el campoResultado
        }
    }

    private double evaluarExpresion(String expresion) {
        double resultado = 0;
        try {
            resultado = evaluarExpresionSimple(expresion);
        } catch (ArithmeticException | NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Error en la expresión");
        }
        return resultado;
    }

    private double evaluarExpresionSimple(String expresion) {
        String[] partes = expresion.split("(?<=[-+*/])|(?=[-+*/])");
        double acumulador = Double.parseDouble(partes[0].trim());

        for (int i = 1; i < partes.length; i += 2) {
            String operador = partes[i].trim();
            double operando = Double.parseDouble(partes[i + 1].trim());

            switch (operador) {
                case "+":
                    acumulador += operando;
                    break;
                case "-":
                    acumulador -= operando;
                    break;
                case "*":
                    acumulador *= operando;
                    break;
                case "/":
                    if (operando != 0) {
                        acumulador /= operando;
                    } else {
                        throw new ArithmeticException("División por cero");
                    }
                    break;
                default:
                    throw new IllegalArgumentException("Operador desconocido: " + operador);
            }
        }

        return acumulador;
    }

    public static void main(String[] args) {
        new calculadora_pruebas();
    }
}
