public class Ejercicio12 {
/*
Pedir al usuario el radio de la base y la altura de un cilindro en
milímetros. Convertir ambos valores a centímetros y calcular su
volumen. π. r2. h
*/
    public static void main(String[] args) {
        
        double radioMm = 0.0;
        double alturaMm = 0.0;

        final double DIVISOR_Cm = 10.0;

        System.out.println("Ingrese el radio de la base en milímetros:");
        radioMm = Utils.leerDouble();

        System.out.println("Ingrese la altura del cilindro en milímetros:");
        alturaMm = Utils.leerDouble();

        double radioCm = radioMm / DIVISOR_Cm;
        double alturaCm = alturaMm / DIVISOR_Cm;

        double volumen = Math.PI * (radioCm * radioCm) * alturaCm;

        System.out.println("El volumen del cilindro es: " + volumen);
    }
}
