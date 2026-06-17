public class Ejercicio5 {
/*
5. Hacer un programa que dada una matriz de enteros de tamaño
5*10 que se encuentra precargada, solicite al usuario una posición
fila, columna y realice un corrimiento a izquierda.
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

        corrimientoIzquierda(matriz[filaObjetivo], columnaObjetivo);

        imprimirMatriz(matriz);
    }

    public static void corrimientoIzquierda(int[] arr, int pos) {
        for (int i = pos; i < arr.length - 1; i++) {

            arr[i] = arr[i + 1];
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