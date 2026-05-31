public class Ejercicio2 {
/*
2. Hacer un programa que dado un arreglo ya cargado con 10
enteros, calcule el promedio real y lo muestre por la consola.
 */

    public static final int TAM = 10;

    public static void main(String[] args) {
        
        int[] arreglo = {2, 5, 9, 8, 9, 6, 10, 7, 5, 4};

        double promedio = promedioArreglo(arreglo);
        System.out.println("El promedio del arreglo es: " + promedio);
    }

    public static double promedioArreglo(int[] arreglo){
        int suma = 0;
        for(int pos = 0; pos < TAM; pos++){
            suma = suma + arreglo[pos];
        }
        return ((double) suma / TAM);
    }
}
