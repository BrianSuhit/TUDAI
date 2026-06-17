public class Ejercicio7 {
/*
7. Hacer un programa que dada una matriz de enteros de tamaño
5*10 que se encuentra precargada, solicite al usuario un número
entero y elimine la primera ocurrencia de número en la matriz (un
número igual) si existe. Para ello tendrá que buscar la posición y si
está, realizar un corrimiento a izquierda y no continuar buscando.
*/
    public static void main(String[] args) {
        int[][] matriz = {
            {28, 2, 3, 4, 5, 6, 7, 8, 9, 10},
            {11, 12, 13, 14, 15, 16, 17, 18, 19, 20},
            {21, 22, 23, 24, 25, 26, 27, 28, 29, 30},
            {31, 32, 33, 34, 35, 36, 37, 38, 39, 40},
            {41, 42, 43, 44, 45, 46, 47, 48, 49, 50}
        };

        int valorEliminar = 35;

        eliminarElemento(matriz, valorEliminar);

        imprimirMatriz(matriz);

    }

    public static void eliminarElemento(int[][] matriz, int valor){
        int fila = 0;
        boolean loEncontre = false;

        while(fila < matriz.length && !loEncontre){
            
            int posColuma = buscarPosicion(matriz[fila], valor);

            if(posColuma != -1){
                corrimientoIzquierda(matriz[fila], posColuma);
                loEncontre = true;
            }
            fila++;
        }
    }

    public static int buscarPosicion(int[] arr, int valor){
        int i = 0;
        boolean loEncontre = false;

        while(i < arr.length && !loEncontre){
            if(arr[i] == valor){
                loEncontre = true;
            }
            else{
                i++;
            }
        }

        if(loEncontre){
            return i;
        }else{
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
