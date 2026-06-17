public class Ejercicio9 {
/*
9. Hacer un programa que dada una matriz de enteros ordenada
creciente por filas de tamaño 4*5 que se encuentra precargada,
solicite al usuario un número entero y una fila, y luego inserte el
número en la matriz en la fila indicada manteniendo su orden.
*/

    public static void main(String[] args) {

        int[][] matriz = {
            {1, 2, 3, 4, 5, 6, 7, 8, 9, 10},
            {11, 12, 13, 14, 15, 16, 17, 18, 19, 20},
            {21, 22, 23, 24, 25, 26, 27, 28, 29, 30},
            {31, 32, 33, 34, 35, 36, 37, 38, 39, 40},
            {41, 42, 43, 44, 45, 46, 47, 48, 49, 50}
        };

        System.out.println("Matriz original:");
        imprimirMatriz(matriz);

        int fila = 2;
        int valorInsertar = 333;

        procesarMatriz(matriz, valorInsertar, fila);

        System.out.println("Matriz con el valor insertado:");
        imprimirMatriz(matriz);
    }

    public static void procesarMatriz(int[][] matriz, int valorInsertar, int fila){

        int columna = buscarPosicion(matriz[fila], valorInsertar);

        if(columna != -1){
            corrimientoDerecha(matriz[fila], columna);
            matriz[fila][columna] = valorInsertar;
        }
    }

    public static int buscarPosicion(int[] arr, int valorInsertar){
        int i = 0;
        boolean posEncontra = false;

        while(i < arr.length && !posEncontra){
            if(arr[i] > valorInsertar){
                posEncontra = true;
            }
            else{
                i++;
            }
        }

        if(posEncontra){
            return i;
        }
        else{
            return -1;
        }
    }

    public static void corrimientoDerecha(int[] arr, int pos){
        for(int i = arr.length - 1; i > pos; i--){
            arr[i] = arr[i - 1];
        }
    }

    public static void imprimirMatriz(int[][] mat) {
        for (int fila = 0; fila < mat.length; fila++) {
            
            for (int columna = 0; columna < mat[fila].length; columna++) {
                System.out.print(mat[fila][columna] + "\t");
            }            
            System.out.println(""); 
        }
    }
}
