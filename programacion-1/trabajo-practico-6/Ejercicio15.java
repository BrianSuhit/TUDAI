public class Ejercicio15 {
/*
15. Hacer un programa que dada la matriz de secuencias de
enteros definida y precargada, y un número entero ingresado por
el usuario, elimine de cada fila las secuencias de tamaño igual al número ingresado.
*/
    public static final int SEPARADOR = 0;
    public static void main(String[] args) {
        int[][] matrizEnteros = {
            {0, 2, 4, 5, 0, 8, 0, 7, 2, 2, 0, 1, 2, 3, 0, 0, 9, 0, 0, 0},
            {0, 0, 1, 2, 0, 3, 4, 5, 0, 6, 7, 0, 8, 9, 1, 0, 2, 3, 0, 0},
            {0, 9, 8, 7, 0, 0, 6, 5, 0, 4, 3, 2, 0, 1, 0, 0, 5, 0, 0, 0},
            {0, 0, 0, 1, 2, 3, 4, 0, 5, 6, 7, 8, 0, 9, 0, 0, 0, 0, 0, 0}
        };

        System.out.println("matriz original:");
        imprimirMatriz(matrizEnteros);

        for(int posFila = 0; posFila < matrizEnteros.length; posFila++){

            int ini = 0, fin = -1, tamañoEliminar = 3;

            while(ini < matrizEnteros[posFila].length){
                ini = buscarInicio(matrizEnteros[posFila], fin + 1);

                if(ini < matrizEnteros[posFila].length){
                    fin = buscarFin(matrizEnteros[posFila], ini);

                    int tamaño = fin - ini + 1;

                    if(tamaño == tamañoEliminar){
                        eliminarSecuencia(matrizEnteros[posFila], tamañoEliminar, ini);
                        fin = fin - tamaño;
                    }
                }
            }
        }

        System.out.println("matriz procesada:");
        imprimirMatriz(matrizEnteros);
    }

    public static void eliminarSecuencia(int[] arr, int tamaño, int ini){
        for(int i = 0; i < tamaño; i++){
            corrimientoIzquierda(arr, ini);
        }
    }

    public static void corrimientoIzquierda(int[] arr, int pos){
        for(int i = pos; i < arr.length - 1; i++){
            arr[i] = arr[i + 1];
        }
    }

    public static int buscarInicio(int[] arr, int pos){
        while(pos < arr.length && arr[pos] == SEPARADOR){
            pos++;
        }
        return pos;
    }

    public static int buscarFin(int[] arr, int pos){
        while(pos < arr.length && arr[pos] != SEPARADOR){
            pos++;
        }
        return pos - 1;
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
