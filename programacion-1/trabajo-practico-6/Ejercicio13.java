public class Ejercicio13 {
/*
13. Hacer un programa que dada la matriz de secuencias de
enteros definida y precargada permita encontrar por cada fila la
posición de inicio y fin de la secuencia cuya suma de valores sea
mayor.
*/
    public static final int SEPARADOR = 0;
    public static void main(String[] args) {
        int[][] matrizEnteros = {
            {0, 2, 4, 5, 0, 8, 0, 7, 2, 2, 0, 1, 2, 3, 0, 0, 9, 0, 0, 0},
            {0, 0, 1, 2, 0, 3, 4, 5, 0, 6, 7, 0, 8, 9, 1, 0, 2, 3, 0, 0},
            {0, 9, 8, 7, 0, 0, 6, 5, 0, 4, 3, 2, 0, 1, 0, 0, 5, 0, 0, 0},
            {0, 0, 0, 1, 2, 3, 4, 0, 5, 6, 7, 8, 0, 9, 0, 0, 0, 0, 0, 0}
        };

        for(int posFila = 0; posFila < matrizEnteros.length; posFila++){

            int ini = 0, fin = -1, mayorSuma = -1, mejorIni = 0, mejorFin = 0;

            while(ini < matrizEnteros[posFila].length){
                ini = buscarInicio(matrizEnteros[posFila], fin + 1);

                if(ini < matrizEnteros[posFila].length){
                    fin = buscarFin(matrizEnteros[posFila], ini);

                    int suma = calcularSuma(matrizEnteros[posFila], ini, fin);

                    if(suma > mayorSuma){
                        mayorSuma = suma;
                        mejorIni = ini;
                        mejorFin = fin;
                    }
                }
            }
            System.out.println("En la fila " + posFila + " la secuencia mayor es: " + mayorSuma +  " y va de " + mejorIni + " a " + mejorFin);
        }
    }

    public static int calcularSuma(int[] arr, int ini, int fin){
        int suma = 0;
        
        for(int i = ini; i <= fin; i++){
           suma = suma + arr[i];
        }
        return suma;
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
}
