public class Ejercicio8 {
/*
Escribir un programa que mientras que el usuario ingrese un
número entero entre 1 y 10 inclusive, lleve la suma de los
números ingresados. Finalmente, cuando sale del ciclo muestre
por pantalla el resultado de la suma. ¿En qué casos termina?
*/
    public static void main(String[] args) {
        
        int suma = 0;
        int numero = 0;

        final int MIN = 1;
        final int MAX = 10;

        System.out.println("ingrese un numero entre 1 y 10");
        numero = Utils.leerInt();

        while (numero >= MIN && numero <= MAX) {

            suma = suma + numero;

            System.out.println("ingrese un numero entre 1 y 10");
            numero = Utils.leerInt();
        }

        System.out.println("la suma total de los numeros es: " + suma);
    }

    /*
    el bucle finaliza cuando el usuario ingresa un numero menor a 1 o mayor a 10
    */
}
