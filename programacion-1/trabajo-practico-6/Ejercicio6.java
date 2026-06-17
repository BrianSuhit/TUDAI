public class Ejercicio6 {
/*
6. Hacer un programa que dada una matriz de enteros de tamaño
5*10 que se encuentra precargada, solicite al usuario un número
entero y una posición fila, columna. Con estos datos tendrá que
realizar un corrimiento a derecha (se pierde el último valor en
dicha fila) y colocar el número en la matriz en la posición fila,
columna indicada.
*/
    public static void main(String[] args) {
        int[][] matriz = {
            {28, 2, 3, 4, 5, 6, 7, 8, 9, 10},
            {11, 12, 13, 14, 15, 16, 17, 18, 19, 20},
            {21, 22, 23, 24, 25, 26, 27, 28, 29, 30},
            {31, 32, 33, 34, 35, 36, 37, 38, 39, 40},
            {41, 42, 43, 44, 45, 46, 47, 48, 49, 50}
        };

        int filaObjetivo = 2;
        int columnaObjetivo = 4;

        int valorInsertar = 666;

        corrimientoDerecha(matriz[filaObjetivo], columnaObjetivo);
        matriz[filaObjetivo][columnaObjetivo] = valorInsertar;

        imprimirMatriz(matriz);
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
