public class Ejercicio8 {
/*
8. Hacer un programa que dada una matriz de enteros de tamaño
5*10 que se encuentra precargada, solicite al usuario un número
entero y elimine todas las ocurrencia de número en la matriz si
existe. Mientras exista (en cada iteración tiene que buscar la
posición fila y columna) tendrá que usar dicha posición para
realizar un corrimiento a izquierda (quedarán tantas copias de la
última posición de cada fila como cantidad de ocurrencias del
número). Tener en cuenta, como se hizo en arreglos, si el
elemento a eliminar es el último de alguna fila de la matriz.
*/
    public static void main(String[] args){
        int[][] matriz = {
            {28, 2, 3, 4, 5, 6, 7, 8, 9, 10},
            {11, 12, 13, 14, 15, 16, 17, 18, 19, 20},
            {21, 22, 23, 24, 25, 26, 27, 28, 29, 30},
            {31, 32, 33, 34, 35, 36, 37, 38, 39, 40},
            {41, 42, 43, 35, 45, 35, 47, 48, 49, 50}
        };

        int valorEliminar = 35;

        eliminarElementos(matriz, valorEliminar);

        imprimirMatriz(matriz);
    }


    public static void eliminarElementos(int[][] matriz, int valorEliminar){

        for(int fila = 0; fila < matriz.length; fila++){

            int limite = matriz[fila].length;

            int posColuma = buscarPosicion(matriz[fila], valorEliminar, limite);

            while(posColuma != -1){
                corrimientoIzquierda(matriz[fila], posColuma);
                limite--;

                posColuma = buscarPosicion(matriz[fila], valorEliminar, limite);
            }
        }
    }

    public static int buscarPosicion(int[] arr, int pos, int limite){
        int i = 0;
        boolean loEncontre = false;

        while( i < limite && !loEncontre){
            if(arr[i] == pos){
                loEncontre = true;
            }
            else{
                i++;
            }
        }

        if(loEncontre){
            return i;
        }
        else{
            return -1;
        }
    }

    public static void corrimientoIzquierda(int[] arr, int pos){
        for(int i = pos; i < arr.length - 1; i++){
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
