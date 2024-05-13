package UD10_exceptions;

import java.util.Random;

public class Password {
    private int longitud;
    private String contraseña;

    // Constructor por defecto
    public Password() {
        this.longitud = 8; // Longitud por defecto
        generarPassword();
    }

    // Constructor con longitud especificada
    public Password(int longitud) {
        this.longitud = longitud;
        generarPassword();
    }

    // Método para verificar si la contraseña es fuerte
    public boolean esFuerte() {
        int mayusculas = 0;
        int minusculas = 0;
        int numeros = 0;

        for (int i = 0; i < contraseña.length(); i++) {
            char c = contraseña.charAt(i);
            if (Character.isUpperCase(c)) {
                mayusculas++;
            } else if (Character.isLowerCase(c)) {
                minusculas++;
            } else if (Character.isDigit(c)) {
                numeros++;
            }
        }

        return (mayusculas > 2 && minusculas > 1 && numeros > 5);
    }

    // Método para generar una contraseña aleatoria
    public void generarPassword() {
        StringBuilder sb = new StringBuilder();
        Random random = new Random();

        for (int i = 0; i < longitud; i++) {
            int tipoCaracter = random.nextInt(3); // 0: mayúscula, 1: minúscula, 2: número

            switch (tipoCaracter) {
                case 0:
                    sb.append((char) (random.nextInt(26) + 'A'));
                    break;
                case 1:
                    sb.append((char) (random.nextInt(26) + 'a'));
                    break;
                case 2:
                    sb.append(random.nextInt(10));
                    break;
            }
        }

        contraseña = sb.toString();
    }

    // Métodos get y set
    public String getContraseña() {
        return contraseña;
    }

    public int getLongitud() {
        return longitud;
    }

    public void setLongitud(int longitud) {
        this.longitud = longitud;
        generarPassword(); // Regenerar la contraseña con la nueva longitud
    }

    public static void main(String[] args) {
        Password password1 = new Password();
        System.out.println("Contraseña generada: " + password1.getContraseña());
        System.out.println("¿Es fuerte? " + password1.esFuerte());

        Password password2 = new Password(10);
        System.out.println("Contraseña generada: " + password2.getContraseña());
        System.out.println("¿Es fuerte? " + password2.esFuerte());
    }
}
