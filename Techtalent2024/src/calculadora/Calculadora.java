package calculadora;

public class Calculadora {
    public double sumar(double num1, double num2) {
        return num1 + num2;
    }

    public double restar(double num1, double num2) {
        return num1 - num2;
    }

    public double multiplicar(double num1, double num2) {
        return num1 * num2;
    }

    public double dividir(double num1, double num2) throws ArithmeticException {
        if (num2 == 0) {
            throw new ArithmeticException("Error: división por cero");
        }
        return num1 / num2;
    }

    public double potencia(double base, double exponente) {
        return Math.pow(base, exponente);
    }

    public double raizCuadrada(double num) throws ArithmeticException {
        if (num < 0) {
            throw new ArithmeticException("Error: raíz cuadrada de un número negativo");
        }
        return Math.sqrt(num);
    }

    public double raizCubica(double num) {
        return Math.cbrt(num);
    }
}
