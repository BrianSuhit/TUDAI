public class Ejercicio28 {
/*
28. Hacer un programa que devuelva la posición de inicio y de fin
de la secuencia de mayor tamaño.
*/
    public static final int MAX = 10;
    public static void main(String[] args) {
        
        int[] arrEnteros = {0, 1, 2, 3, 0, 0, 0, 8, 6, 0};

        procesar_secuencias(arrEnteros);
    }

    public static int obtener_inicio_secuencia(int[] arrEnteros, int ini) {
        while (ini<MAX && arrEnteros[ini]==0)
        ini++;
        return ini;
    }

    public static int obtener_fin_secuencia(int[] arrEnteros, int ini) {
        while (ini<MAX && arrEnteros[ini]!=0)
        ini++;
        return ini-1;
    }

    public static void procesar_secuencias(int[] arrEnteros) {
        int inicio = 0;
        int fin = -1;
        int tamanioMayor = 0;
        int inicioMayor = 0;
        int finMayor = 0;

        while(inicio < MAX){
            inicio = obtener_inicio_secuencia(arrEnteros, fin+1);

            if (inicio < MAX){
                fin = obtener_fin_secuencia(arrEnteros, inicio);

                int cantElementos = fin - inicio + 1;

                if(cantElementos > tamanioMayor){
                    tamanioMayor = cantElementos;
                    inicioMayor = inicio;
                    finMayor = fin;
                }
            }
        }
    System.out.println("La secuencia de mayor tamanio inicia en la posición " + inicioMayor + " y termina en la posición " + finMayor);
    }
}
