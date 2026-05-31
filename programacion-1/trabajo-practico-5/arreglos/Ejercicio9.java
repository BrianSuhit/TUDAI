public class Ejercicio9 {
/*
9. Hacer un programa que dado un arreglo de enteros y un número
N, genere un arreglo con las posiciones donde se encuentra dicho
número. A continuación, multiplicar por un número M todas las
ocurrencias del número N en el arreglo original.
*/ 
    public static final int TAM = 10;
    public static final int N = 9;
    public static final int M = 2;

    public static void main(String[] args) {
             
        int[] arreglo = {2, 5, 9, 8, 9, 6, 10, 7, 5, 4};
   
        int[] arregloDePosiciones = generarArreglo(arreglo);
        System.out.println("El nuevo arreglo con las posiciones es:");
        mostrarArreglo(arregloDePosiciones);

        for(int posActual = 0; posActual < arregloDePosiciones.length; posActual++){
            
            if(arreglo[arregloDePosiciones[posActual]] == N){
                arreglo[arregloDePosiciones[posActual]] = arreglo[arregloDePosiciones[posActual]] * M;
            }
        }

        System.out.println("El arreglo original modificado es:");
        mostrarArreglo(arreglo);
    }

    public static int[] generarArreglo(int[] arreglo){

        int[] nuevoArreglo = new int[TAM];
        int indexNuevoArreglo = 0;

        for(int pos = 0; pos < TAM; pos++){

            if(arreglo[pos] == N){
                nuevoArreglo[indexNuevoArreglo] = pos;
                indexNuevoArreglo++;
            }
        }
        return nuevoArreglo;
    }

    public static void mostrarArreglo(int[] arreglo){
        for (int pos = 0; pos < arreglo.length; pos++){
            System.out.println("arreglo[" + pos + "] -> " + arreglo[pos]);
        }
    }
}
