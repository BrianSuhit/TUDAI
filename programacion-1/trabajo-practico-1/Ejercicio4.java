public class Ejercicio4 {
/*
 * Escribir un programa que solicite nombre, edad, altura y ocupación, y
 * los imprima por pantalla.
 */
    public static void main(String[] args) {
        
        String nombre = "";
        int edad = 0;
        double altura = 0.0;
        String ocupacion = "";

        System.out.println("Ingrese su nombre");
        nombre = Utils.leerString();

        System.out.println("Ingrese su edad");
        edad = Utils.leerInt();

        System.out.println("Ingrese su altura");
        altura = Utils.leerDouble();

        System.out.println("Ingrese su ocupacion");
        ocupacion = Utils.leerString();

        System.out.println("Su nombre es: " + nombre);
        System.out.println("Su edad es: " + edad);
        System.out.println("Su altura es: " + altura);
        System.out.println("Su ocupacion es: " + ocupacion);
    }
}
