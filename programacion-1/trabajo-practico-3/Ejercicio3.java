public class Ejercicio3 {
/*
Escribir un diseño de programa que mientras que el usuario
ingrese un número natural, pida ingresar otro número cualquiera y
lo imprima
*/
    public static void main(String[] args) {

        int numero = obtenerNumero();

        while (numero > 0) {
            
            System.out.println("El numero ingresado es: " + numero);
            numero = obtenerNumero();
        }
        System.out.println("Fin del programa.");
    }

    public static int obtenerNumero(){

        int numero = 0;
        System.out.println("Ingrese un numero (0 para salir):");
        numero = Utils.leerInt();
        return numero;
    }
}
