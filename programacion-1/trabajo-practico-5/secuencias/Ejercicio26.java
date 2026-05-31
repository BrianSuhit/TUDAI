public class Ejercicio26 {
/*
Hacer un programa que devuelva la posición de inicio y fin de la
secuencia de números distintos de ceros cuya suma del contenido
sea la mayor.
*/
    public static final int MAX = 10;
    public static void main(String[] args) {
        
        int[] arrEnteros = {0, 1, 2, 0, 3, 4, 0, 8, 6, 0};

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

    public static int obtener_suma_secuencia(int[] arrEnteros, int ini, int fin) {
        int suma = 0;
        while (ini <= fin) {
            suma = suma + arrEnteros[ini];
            ini++;
        }
        return suma;
    }

    public static void procesar_secuencias(int[] arrEnteros) {
        int inicio = 0;
        int fin = -1;
        int suma = 0;
        int sumaMayorHastaElMomento = -1;
        int inicioMayor = 0;
        int finMayor = 0;

        while(inicio < MAX){

            inicio = obtener_inicio_secuencia(arrEnteros, fin+1);

            if (inicio < MAX){
                fin = obtener_fin_secuencia(arrEnteros, inicio);
                suma = obtener_suma_secuencia(arrEnteros, inicio, fin);

                if(suma > sumaMayorHastaElMomento){
                    sumaMayorHastaElMomento = suma;
                    inicioMayor = inicio;
                    finMayor = fin;
                }
            }
        }
        System.out.println("Inicia en la posición " + inicioMayor + " y termina en la posición " + finMayor);
    }
}
