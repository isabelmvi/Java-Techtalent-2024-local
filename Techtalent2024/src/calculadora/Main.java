package calculadora;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Calculadora calculadora = new Calculadora();

        try {
            System.out.println("Ingrese el primer número:");
            double num1 = scanner.nextDouble();
            System.out.println("Ingrese el segundo número:");
            double num2 = scanner.nextDouble();

            System.out.println("Suma: " + calculadora.sumar(num1, num2));
            System.out.println("Resta: " + calculadora.restar(num1, num2));
            System.out.println("Multiplicación: " + calculadora.multiplicar(num1, num2));
            System.out.println("División: " + calculadora.dividir(num1, num2));
            System.out.println("Potencia: " + calculadora.potencia(num1, num2));
            System.out.println("Raíz cuadrada del primer número: " + calculadora.raizCuadrada(num1));
            System.out.println("Raíz cúbica del segundo número: " + calculadora.raizCubica(num2));
        } catch (ArithmeticException e) {
            System.out.println("Error de cálculo: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}
