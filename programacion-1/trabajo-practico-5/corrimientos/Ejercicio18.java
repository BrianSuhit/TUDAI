public class Ejercicio18 {
/*
18. Implementar un método que realice un corrimiento a izquierda
en un arreglo ordenado de tamaño 10 a partir de una posición.
*/
    public static final int TAM = 10;
    public static void main(String[] args) {
        
    int[] arreglo = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

    int posHueco = 7;

    corrimientoIzquierda(arreglo, posHueco);

    mostrarArreglo(arreglo);

    }

    public static void corrimientoIzquierda(int[] arr, int pos) {
        for (int i = pos; i < arr.length - 1; i++)
            arr[i] = arr[i + 1];
    }

    public static void mostrarArreglo(int[] arrenteros){
        for (int pos = 0; pos < TAM; pos++){
        System.out.println("arrenteros["+pos+"] -> "+arrenteros[pos]);
        }
    }
}
