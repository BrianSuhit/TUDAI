public class Ejercicio14 {
/*
14. Dado dos arreglos de números enteros: un arreglo A de tamaño
MAXA y un arreglo B de tamaño MAXB con números entre 0 y
MAXA-1, determinar la suma de los elementos del arreglo A cuyas
posiciones son indicadas por el arreglo B. Por ejemplo, dado
A={3,6,31,9}, MAXA=4 y B={0,2} con MAXB=2 el sistema deberá
informar: 34 (lo cual es el resultado de sumar el 3 de la posición 0
y el 31 de la posición 2 del arreglo A).
*/

    public static final int MAXA = 4;
    public static final int MAXB = 2;

    public static void main(String[] args) {
        
        int[] arregloA = {3, 6, 31, 9};
        int[] arregloB = {0, 2};

        System.out.println("la suma del conjunto de A indicada por los valores de B es: " + sumatoriaDeConjuntos(arregloA, arregloB));
    }

    public static int sumatoriaDeConjuntos(int[] arregloA, int[] arregloB){
        int pos = 0;
        int suma = 0;
        for(pos = 0; pos < MAXB; pos++){
            
            // Machete mental de lo que ocurre en cada iteración:
            // Cuando pos = 0: arregloB[0] vale 0. Entonces buscamos arregloA[0], que vale 3.  (suma = 0 + 3)
            // Cuando pos = 1: arregloB[1] vale 2. Entonces buscamos arregloA[2], que vale 31. (suma = 3 + 31)
            
            // Descomenta este "sout" si quieres verlo impreso en pantalla paso a paso:
            // System.out.println("Posicion indicada por B: " + arregloB[pos] + " -> Valor a sumar en A: " + arregloA[arregloB[pos]]);

            suma = suma + arregloA[arregloB[pos]];
        }
        return suma;
    }
}