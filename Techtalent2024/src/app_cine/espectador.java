package app_cine;

import java.util.Scanner;

public class espectador {
    private String nombre;
    private int edad;
    private double dinero;

    // Constructor
    public espectador(String nombre, int edad, double dinero) {
        this.nombre = nombre;
        this.edad = edad;
        this.dinero = dinero;
    }

    // Getter y setter para el nombre
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    // Getter y setter para la edad
    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    // Getter y setter para el dinero
    public double getDinero() {
        return dinero;
    }

    public void setDinero(double dinero) {
        this.dinero = dinero;
    }

//    // Método para solicitar la cantidad de dinero que pagará el espectador
//    public void solicitarPago() {
//        Scanner scanner = new Scanner(System.in);
//        System.out.println(nombre + ", ¿cuánto dinero vas a pagar por la entrada?");
//        double pago = scanner.nextDouble();
//        setDinero(pago);
//    }
//
//    // Método para solicitar la edad del espectador
//    public void solicitarEdad() {
//        Scanner scanner = new Scanner(System.in);
//        System.out.println(nombre + ", ¿cuál es tu edad?");
//        int age = scanner.nextInt();
//        setEdad(age);
//    }
}
