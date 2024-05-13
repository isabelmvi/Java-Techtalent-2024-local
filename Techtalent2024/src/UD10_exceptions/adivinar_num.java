package UD10_exceptions;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class adivinar_num {
    private int numeroAdivinar;
    private int intentos;

    public adivinar_num() {
        Random rand = new Random();
        this.numeroAdivinar = rand.nextInt(500) + 1;
        this.intentos = 0;
    }

    public void jugar() {
        Scanner scanner = new Scanner(System.in);
        boolean adivinado = false;

        System.out.println("Bienvenido al juego de adivinar el número!");
        System.out.println("Introduce un número entre 1 y 500:");

        while (!adivinado) {
            try {
                int intento = scanner.nextInt();
                this.intentos++;

                if (intento < 1 || intento > 500) {
                    System.out.println("Por favor, introduce un número entre 1 y 500.");
                } else if (intento < this.numeroAdivinar) {
                    System.out.println("El número a adivinar es mayor.");
                } else if (intento > this.numeroAdivinar) {
                    System.out.println("El número a adivinar es menor.");
                } else {
                    adivinado = true;
                    System.out.println("¡Felicidades! Has adivinado el número " + this.numeroAdivinar +
                            " en " + this.intentos + " intentos.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Por favor, introduce un número válido.");
                scanner.next(); // Limpiar el buffer del scanner
                this.intentos++;
            }
        }

        scanner.close();
    }

    public static void main(String[] args) {
        adivinar_num juego = new adivinar_num();
        juego.jugar();
    }
}
