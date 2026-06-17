public class Ejercicio12 {
/*
Se tiene una matriz de enteros de tamaño 4*20 de secuencias de
números entre 1 y 9 (por cada fila), separadas por 0. La matriz
está precargada, y además cada fila empieza y termina con uno o
más separadores 0. Además, se tiene una matriz de caracteres de
tamaño 4*20 de secuencias de caracteres letras minúsculas entre
‘a’ y ‘z’ (por cada fila), separadas por ‘ ’ (espacios). La matriz está
precargada, y además cada fila empieza y termina con uno o más
separadores ‘ ’. Considere para los siguientes ejercicios estos dos
tipos de matriz.
12. Hacer un programa que dada la matriz de secuencias de
enteros definida y precargada, permita obtener a través de
métodos la posición de inicio y la posición de fin de la secuencia
ubicada a partir de una posición entera y una fila, ambas
ingresadas por el usuario. Finalmente, si existen imprima por
pantalla ambas posiciones obtenidas.
*/
    public static final int SEPARADOR = 0;
    public static void main(String[] args) {
        
        int[][] matrizEnteros = {
            {0, 2, 4, 5, 0, 8, 0, 7, 2, 2, 0, 1, 2, 3, 0, 0, 9, 0, 0, 0},
            {0, 0, 1, 2, 0, 3, 4, 5, 0, 6, 7, 0, 8, 9, 1, 0, 2, 3, 0, 0},
            {0, 9, 8, 7, 0, 0, 6, 5, 0, 4, 3, 2, 0, 1, 0, 0, 5, 0, 0, 0},
            {0, 0, 0, 1, 2, 3, 4, 0, 5, 6, 7, 8, 0, 9, 0, 0, 0, 0, 0, 0}
        };

        int posFila = 0, posColumna = 4;

        int ini = 0;
        int fin = -1;
        

        ini = buscarInicio(matrizEnteros[posFila],posColumna);

            if(ini < matrizEnteros[posFila].length){

                fin = buscarFin(matrizEnteros[posFila], ini);

                System.out.println("la secuencia empieza en la columna " + ini + " y termina en la columna " + fin);
            }
    }

    public static int buscarInicio(int[] arr, int pos){
        while(pos < arr.length && arr[pos] == SEPARADOR){
            pos++;
        }
        return pos;
    }

    public static int buscarFin(int[] arr, int pos){
        while(pos < arr.length && arr[pos] != SEPARADOR){
            pos++;
        }
        return pos - 1;
    }
}
