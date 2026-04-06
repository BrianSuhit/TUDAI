public class Ejercicio10 {
/*
Pedir al usuario una temperatura en grados Fahrenheit.
Convertirla a Celsius usando la fórmula C=(F-32)/1.8 y mostrar el
resultado por pantalla.
*/
    public static void main(String[] args) {
        
        double temperaturaF = 0.0;

        final double AJUSTE_CERO_FAHRENHEIT = 32.0;
        final double FACTOR_CONVERSION = 1.8;

        System.out.println("Ingrese la temperatura en Fahrenheit:");
        temperaturaF = Utils.leerDouble();

        // double celcius = (temperaturaF - 32) / 1.8;

        double celcius = (temperaturaF - AJUSTE_CERO_FAHRENHEIT) / FACTOR_CONVERSION;

        System.out.println("La temperatura en Celcius es: " + celcius);
    }
}
