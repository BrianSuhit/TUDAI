public class Ejercicio32 {
/*
32. Hacer un programa que reemplace de un arreglo A todas las
ocurrencias de una secuencia patrón dada en un arreglo P, por la
secuencia contenida en el arreglo R de igual tamaño.
*/
    public static final int TAM = 15;
    public static void main(String[] args) {
        int[] A = {0, 1, 2, 0, 3, 4, 0, 1, 2, 0, 5, 0, 1, 2, 0};

        int[] P = {1, 2};

        int[] R = {8, 9};

        procesar_secuencias(A, P, R);
        mostrarArreglo(A);
    }

    public static void procesar_secuencias(int[] arrEnteros, int[] patron, int[] reemplazo) {
        int inicio = 0;
        int fin = -1;

        while(inicio < TAM){
            inicio = obtener_inicio_secuencia(arrEnteros, fin+1);

            if (inicio < TAM){
                fin = obtener_fin_secuencia(arrEnteros, inicio);
                                
                int tamaño = fin - inicio + 1;

                if(tamaño == patron.length && sonSecuenciasIguales(arrEnteros, patron, inicio, fin)){
                    reemplazar_secuencia(arrEnteros, inicio, fin, reemplazo);
                }
            }
        }
    }

    public static void reemplazar_secuencia(int[] arrEnteros, int inicio, int fin, int[] reemplazo){
        int j = 0;

        for(int i = inicio; i <= fin; i++){
            arrEnteros[i] = reemplazo[j];
            j++;
        }

    } 
    
    public static boolean sonSecuenciasIguales(int[] arrEnteros, int[] patron, int inicio, int fin){
        int i = inicio;
        int j = 0;

        while(i <= fin){
            if(arrEnteros[i] != patron[j]){
                return false;
            }
            i++;
            j++;
        }
        return true;
    }

    public static int obtener_inicio_secuencia(int[] arrEnteros, int ini) {
        while (ini<arrEnteros.length && arrEnteros[ini]==0)
        ini++;
        return ini;
    }

    public static int obtener_fin_secuencia(int[] arrEnteros, int ini) {
        while (ini<arrEnteros.length && arrEnteros[ini]!=0)
        ini++;
        return ini-1;
    }

    public static void mostrarArreglo(int[] arrenteros){
        for (int pos = 0; pos < arrenteros.length; pos++){
        System.out.println("arrenteros["+pos+"] -> "+arrenteros[pos]);
        }
    }
}
