public class Ejercicio17 {
/*
17. Implementar un método que realice un corrimiento a derecha
en un arreglo ordenado de tamaño 10 a partir de una posición.
*/

    public static final int TAM = 10;
    public static void main(String[] args) {
        
        int[] arreglo = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

        int posHueco = 1;

        corrimientoDerecha(arreglo, posHueco);

        mostrarArreglo(arreglo);
    }

    public static void corrimientoDerecha(int[] arreglo, int pos) {
        for(int i = arreglo.length - 2; i >= pos; i--) {
            arreglo[i + 1] = arreglo[i];
        }
        arreglo[pos +1] = 3;
    }

    public static void mostrarArreglo(int[] arrenteros){
        for (int pos = 0; pos < TAM; pos++){
        System.out.println("arrenteros["+pos+"] -> "+arrenteros[pos]);
        }
    }
}
