package resto;

import UD10_exceptions.dentro_package;

public class fuera_package_UD10 {
 public static void main(String[] args) {
     try {
         System.out.println("Comenzando el bloque try...");
         throw new dentro_package("Este es un mensaje explicativo de la excepción customizada.");
     } catch (dentro_package e) {
         System.out.println("¡Se ha capturado la excepción!");
         System.out.println("Mensaje de la excepción: " + e.getMessage());
     }
 }
}
