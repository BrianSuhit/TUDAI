public class Ejercicio27 {
/*
Hacer un programa que devuelva la posición de inicio y fin de la
anteúltima secuencia de números distintos de ceros.
*/
    public static final int MAX = 10;
    public static void main(String[] args) {

        int[] arrEnteros = {0, 1, 2, 0, 3, 4, 0, 8, 6, 0};

        procesar_secuencias(arrEnteros);
    }

    public static void procesar_secuencias(int[] arrEnteros) {
        int finUltima = obtener_fin_secuencia_reversa(arrEnteros, MAX - 1);
        int iniUltima = obtener_inicio_secuencia_reversa(arrEnteros, finUltima);

        int finAnte = obtener_fin_secuencia_reversa(arrEnteros, iniUltima - 1);
        int iniAnte = obtener_inicio_secuencia_reversa(arrEnteros, finAnte);

        System.out.println("La anteúltima secuencia inicia en la posición: " + iniAnte + " y termina en la posición: " + finAnte);
    }

    public static int obtener_fin_secuencia_reversa(int[] arrEnteros, int pos) {
        while (pos > 0 && arrEnteros[pos] == 0) {
            pos--;
        }
        return pos; 
    }

    public static int obtener_inicio_secuencia_reversa(int[] arrEnteros, int pos) {
        while (pos > 0 && arrEnteros[pos] != 0) {
            pos--;
        }
        return pos + 1; 
    }
}
