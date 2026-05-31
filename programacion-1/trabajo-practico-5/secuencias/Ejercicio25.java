public class Ejercicio25 {
/*
25. Hacer un programa que devuelva la posición de inicio y fin de la
primera secuencia de números distinta de ceros.
*/

    public static final int MAX = 10;
    public static final int SEPARADOR = 0;
    public static void main(String[] args) {

        int[] arrEnteros = {0, 1, 2, 0, 3, 4, 0, 8, 6, 0};

        procesarSecuencias(arrEnteros);                
    }

    public static int obtener_inicio_secuencia(int[] arrEnteros, int ini) {
        while (ini<MAX && arrEnteros[ini]== SEPARADOR)
        ini++;
        return ini;
    }

    public static int obtener_fin_secuencia(int[] arrEnteros, int ini) {
        while (ini<MAX && arrEnteros[ini]!=SEPARADOR)
        ini++;
        return ini-1;
    }

    public static void procesarSecuencias(int[] arrEnteros) {
        int inicio = 0;
        int fin = -1;

        boolean primeraEncontrada  = false;

        while(inicio < MAX && !primeraEncontrada){

            inicio = obtener_inicio_secuencia(arrEnteros, fin+1);

            if (inicio < MAX){
                fin = obtener_fin_secuencia(arrEnteros, inicio);
                primeraEncontrada = true;
                System.out.println("la primera secuencia es:" + inicio + "-" + fin);
            }
        }
    }
}
