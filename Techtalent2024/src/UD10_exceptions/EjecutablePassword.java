package UD10_exceptions;

import java.util.Scanner;

public class EjecutablePassword {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Pedir al usuario la longitud de los Passwords
        System.out.print("Ingrese la longitud de los Passwords: ");
        int longitud = scanner.nextInt();
        scanner.nextLine(); // Consumir el salto de línea

        // Pedir al usuario el tamaño del array de Passwords
        System.out.print("Ingrese la cantidad de contraseñas a generar: ");
        int tamañoArray = scanner.nextInt();
        scanner.nextLine(); // Consumir el salto de línea

        // Crear un array de Passwords
        Password[] passwords = new Password[tamañoArray];
        // Crear un array de booleanos para almacenar si los passwords son fuertes o no
        boolean[] fuertes = new boolean[tamañoArray];

        // Crear un objeto Password para cada posición del array
        for (int i = 0; i < tamañoArray; i++) {
            passwords[i] = new Password(longitud);
            fuertes[i] = passwords[i].esFuerte();
        }

        // Mostrar las contraseñas y si son fuertes o no
        System.out.println("Contraseñas generadas y si son fuertes o no:");
        for (int i = 0; i < tamañoArray; i++) {
            System.out.println(passwords[i].getContraseña() + " " + fuertes[i]);
        }

        scanner.close();
    }
}
