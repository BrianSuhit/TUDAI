public class Ejercicio2 {
/*
 * Escribir un programa que declare una variable de tipo double y una
 * constante de tipo double con valor 1.0. Luego, deberá asignar el
 * doble del valor de la constante a la variable y mostrar ambos por
 * pantalla.
 */
    public static void main(String[] args) {
        
        double variable = 0;

        final double CONSTANTE = 1.0;

        final double MULTIPLICADOR = 2.0;

        variable = CONSTANTE * MULTIPLICADOR;

        System.out.println("el valor de la constante es: " + CONSTANTE);
        System.out.println("el valor del doble de la constante es: " + variable);
    }
}