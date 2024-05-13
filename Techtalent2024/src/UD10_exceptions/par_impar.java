package UD10_exceptions;

import java.util.Random;

//Definición de la excepción personalizada
class ParImparException extends Exception {
 public ParImparException(String message) {
     super(message);
 }
}

//Clase principal que genera el número aleatorio y verifica si es par o impar
class ParImparChecker {
 public void verificarParImpar() throws ParImparException {
     // Generar número aleatorio entre 0 y 999
     Random rand = new Random();
     int numero = rand.nextInt(1000);
     System.out.println("Generando número aleatorio ...");
     System.out.println("El numero aleatorio generado es: " + numero);

     // Verificar si el número es par o impar
     if (numero % 2 == 0) {
         // Si es par, lanzar una excepción con el mensaje correspondiente
         throw new ParImparException("El número es par.");
     } else {
         // Si es impar, lanzar una excepción con el mensaje correspondiente
         throw new ParImparException("El número es impar.");
     }
 }
}

//Clase principal que ejecuta el programa
public class par_impar {
 public static void main(String[] args) {
     ParImparChecker checker = new ParImparChecker();
     try {
         checker.verificarParImpar();
     } catch (ParImparException e) {
         // Capturar la excepción y mostrar el mensaje asociado
         System.out.println(e.getMessage());
     }
 }
}
