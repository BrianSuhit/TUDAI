public class Ejercicio9 {
/*
Escribir un programa que pida al usuario base y altura de un
rectángulo en centímetros. Convertir a metros y mostrar por
pantalla su área y su perímetro.
*/
    public static void main(String[] args) {
        
        double baseCm = 0.0;
        double alturaCm = 0.0;
        double area = 0.0;
        double perimetro = 0.0;

        
        final double CONVERSOR_MTS = 100.0;
        final double MULTIPLICADOR_PERIMETRO = 2.0;


        System.out.println("Ingrese la base del rectangulo");
        baseCm = Utils.leerDouble();

        System.out.println("Ingrese la altura del rectangulo");
        alturaCm = Utils.leerDouble();

        double baseMTS = baseCm / CONVERSOR_MTS;
        double alturaMTS = alturaCm / CONVERSOR_MTS;

        area = baseMTS * alturaMTS;
        perimetro = (baseMTS * MULTIPLICADOR_PERIMETRO) + (alturaMTS * MULTIPLICADOR_PERIMETRO);

        System.out.println("El area del rectangulo en metros cuadrados es: " + area);
        System.out.println("El perimetro del rectangulo es: " + perimetro);
    }
}
