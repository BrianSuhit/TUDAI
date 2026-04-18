public class Ejercicio13 {
/*
Escribir un programa que imprima por pantalla los números
perfectos que existen entre 2 y 10000. Un número perfecto es
aquel cuya suma de sus divisores (excepto sí mismo) es igual al
propio número. Ejemplo: 6 es un número perfecto dado que sus
divisores (excepto sí mismo) son 1, 2 y 3 cuya suma da 6. En
cambio 12, no es un número perfecto dado que sus divisores
(excepto sí mismo) 1, 2, 3, 4 y 6 cuya suma es 16.

*/

    public static final int MIN = 2;
    public static final int MAX = 10000;

    public static void main(String[] args) {
        
        for(int i = MIN; i <= MAX; i++){

            if(esPerfecto(i)){
                System.out.println("El número " + i + " es perfecto.");
            }
        }
    }

    public static boolean esPerfecto(int numero){

        int suma = 0;

        for(int i = 1; i <= numero-1; i++){

            if(numero % i == 0){
                suma += i;
            }
        }
        return suma == numero;
    }
}
