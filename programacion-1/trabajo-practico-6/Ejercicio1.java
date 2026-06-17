public class Ejercicio1 {
/*
1. Hacer un programa que dada una matriz de enteros de tamaño
5*10 que se encuentra precargada, invierta el orden del contenido
por fila. Este intercambio no se debe realizar de manera explícita,
hay que hacer un método que incluya una iteración de
intercambio.
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

        invertirMatriz(matriz);

        System.out.println("Matriz invertida:");
        imprimirMatriz(matriz);
    }

    public static void invertirMatriz(int[][] matriz){
        for(int fila = 0; fila < matriz.length; fila++){
            swap(matriz[fila]);
        }
    }

    public static void swap(int[] fila){
        for(int pos = 0; pos <  fila.length / 2; pos++){

            int derecho = (fila.length - 1) - pos;
            
            int aux = fila[pos];
            fila[pos] = fila[derecho];
            fila[derecho] = aux;
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
