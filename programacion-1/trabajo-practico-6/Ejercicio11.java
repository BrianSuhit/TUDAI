public class Ejercicio11 {
/*
11. Hacer un programa que dada una matriz de enteros de tamaño
4*5 que se encuentra precargada, solicite al usuario el ingreso de
una fila y dos números enteros (columnas de la matriz), y ordene
de forma creciente la matriz en la fila indicada entre las dos
posiciones columnas ingresadas.
*/
    public static void main(String[] args) {
        int[][] matriz = {
            {45, 12, 89, 3, 27},
            {8, 99, 14, 55, 2},
            {77, 33, 11, 44, 22},
            {6, 19, 81, 7, 50}
        };
        
        System.out.println("Matriz original:");
        imprimirMatriz(matriz);

        int fila = 1, columnaIni = 1, columnaFin = 3;

        burbujeo(matriz[fila], columnaIni, columnaFin);

        System.out.println("\nMatriz con la porción ordenada:");
        imprimirMatriz(matriz);
    }

    public static void burbujeo(int[] arr, int ini, int fin){
        int temp;
        for(int i = ini; i < fin;i++){

            for (int j = ini ; j < fin; j++){
                
                if (arr[j] > arr[j+1]){
                    temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
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
