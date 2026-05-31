public class Ejercicio8 {
/*
8. Hacer un programa que dado un arreglo de enteros de tamaño 10
que se encuentra cargado, obtenga la cantidad de números pares
que tiene y la imprima.
*/
    public static final int TAM = 10;

    public static void main(String[] args) {

        int[] arreglo = {2, 5, 9, 8, 9, 6, 10, 7, 5, 4};

        System.out.println("la cantidad de pares es: " + contarPares(arreglo));
    }

    public static int contarPares(int[] arreglo) {
        int pares = 0;
        for(int pos = 0; pos < TAM; pos++){
            if(arreglo[pos] % 2 == 0){
                pares++;
            }
        }
        return pares;
    }
}
