public class Ejercicio4 {
/*
4. Hacer un programa que dada una matriz de enteros de tamaño
5*10 que se encuentra precargada, obtenga la posición (fila y
columna) del menor elemento y la imprima.
*/
    public static void main(String[] args) {
        int[][] matriz = {
            {28, 2, 3, 4, 5, 6, 7, 8, 9, 10},
            {11, 12, 13, 14, 15, 16, 17, 18, 19, 20},
            {21, 22, 23, 24, 25, 26, 27, 28, 29, 30},
            {31, 32, 33, 34, 35, 36, 37, 38, 39, 40},
            {41, 42, 43, 44, 45, 46, 47, 48, 49, 50}
        };

        System.out.println("Matriz original:");
        imprimirMatriz(matriz);

        buscarPosMenor(matriz);
    }

    public static void buscarPosMenor(int[][] matriz){
        int menorAbsoluto = matriz[0][0];
        int filaMenor = 0;
        int columnaMenor = 0;

        for(int fila = 0; fila < matriz.length; fila++){
             int columnaGanadora = buscarColumnaDelMenor(matriz[fila]);

            if(matriz[fila][columnaGanadora] < menorAbsoluto){
                menorAbsoluto = matriz[fila][columnaGanadora];
                filaMenor = fila;
                columnaMenor = columnaGanadora;
            } 
        }
        System.out.println("El menor elemento es " + menorAbsoluto + " y se encuentra en la fila " + filaMenor + " y columna " + columnaMenor);
    }

    public static int buscarColumnaDelMenor(int[] fila){
        int posMenor = 0;

        for(int i = 0; i < fila.length; i++){
            if(fila[i] < fila[posMenor]){
                posMenor = i;
            }
        }
        return posMenor;
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
