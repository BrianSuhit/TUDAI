public class Ejercicio3 {
/*
3. Hacer un programa que dada una matriz de enteros de tamaño
5*10 que se encuentra precargada, obtenga el mayor elemento y
lo imprima.
*/
    public static void main(String[] args) {
        
        int[][] matriz = {
            {1, 2, 3, 4, 5, 6, 7, 8, 9, 10},
            {11, 12, 13, 14, 15, 16, 17, 18, 19, 20},
            {21, 22, 23, 24, 25, 26, 27, 28, 29, 30},
            {31, 32, 33, 34, 540, 36, 37, 38, 39, 40},
            {41, 42, 43, 44, 45, 46, 47, 48, 49, 50}
        };

        System.out.println("Matriz original:");
        imprimirMatriz(matriz);
        
        int mayorElemento = procesarMayor(matriz);
        System.out.println("el mayor elemento de la matriz es: " + mayorElemento);
    }

    public static int procesarMayor(int[][] matriz){
        int mayorEnMatriz = 0;
        for(int fila = 0; fila < matriz.length; fila++){
            int mayorEnFila = buscarMayor(matriz[fila]);
            if(mayorEnFila > mayorEnMatriz){
                mayorEnMatriz = mayorEnFila;
            }
        }
        return mayorEnMatriz;
    }

    public static int buscarMayor(int[] fila){
        int mayorMax = 0;
        
        for(int i = 0; i < fila.length; i++){
            if(fila[i] > mayorMax){
                mayorMax = fila[i];
            }
        }
        return mayorMax;
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
