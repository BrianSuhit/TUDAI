public class Ejercicio10 {
/*
10. Hacer un programa que determine si los valores almacenados
en un arreglo de enteros se encuentran en orden ascendente.
*/
    public static final int TAM = 10;

    public static void main(String[] args) {

        int[] arreglo = {7, 5, 9, 8, 9, 6, 10, 7, 5, 4};

        if(mostrarSiEsAscendente(arreglo)){
            System.out.println("el arreglo es ascendente");
        }else{
            System.out.println("el arreglo no es ascendente");
        }
    }

    public static boolean mostrarSiEsAscendente(int[] arreglo){
        int pos = 0;
        boolean esAscendente = true;

        while( pos < TAM - 1 && esAscendente){
            if(arreglo[pos] > arreglo[pos + 1]){
                esAscendente = false;
            }
            pos++;
        }
        return esAscendente;
    }
}
