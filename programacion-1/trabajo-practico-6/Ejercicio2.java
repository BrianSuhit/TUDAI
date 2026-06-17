public class Ejercicio2 {
/*
2. Hacer un programa que dada una matriz de enteros de tamaño
5*10 que se encuentra precargada, obtenga la cantidad de
números pares que tiene y la imprima.
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
        System.out.println("la cantidad de pares en la matriz es: " + calcularPares(matriz));
    }

    public static int calcularPares(int[][] matriz){
        int contadorTotal = 0;
        for(int fila = 0; fila < matriz.length; fila++){
            contadorTotal = contadorTotal + contadorPares(matriz[fila]);
        }
        return contadorTotal;
    }

    public static int contadorPares(int[] fila){
        int paresEnFila = 0;
        for(int i = 0; i < fila.length; i++){
            if(fila[i] % 2 == 0){
                paresEnFila++;
            }
        }
        return paresEnFila;
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
