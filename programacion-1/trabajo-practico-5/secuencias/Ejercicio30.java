public class Ejercicio30 {
/*
30. Hacer un programa que elimine de un arreglo todas las
ocurrencias de una secuencia patrón dada por otro arreglo.
*/
    public static final int TAM = 14;
    public static void main(String[] args) {
        
        int[] arreglo = {0, 8, 0, 5, 2, 0, 1, 2, 3, 0, 5, 2, 0, 0};

        int[] patron = {5, 2};

        procesar_secuencias(arreglo, patron);
        mostrarArreglo(arreglo);
    }

    public static int obtener_tamanio_secuencia(int inicio, int fin) {
        return fin - inicio + 1;
    }
    
    public static void corrimientoIzquierda(int[] arreglo, int posHueco) {
        for(int pos = posHueco; pos < TAM - 1; pos++){
            arreglo[pos] = arreglo[pos + 1];
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

    public static void procesar_secuencias(int[] arrEnteros, int[] patron) {
        int inicio = 0;
        int fin = -1;

        while(inicio < TAM){
            inicio = obtener_inicio_secuencia(arrEnteros, fin+1);

            if (inicio < TAM){
                fin = obtener_fin_secuencia(arrEnteros, inicio);

                int tamaño = obtener_tamanio_secuencia(inicio, fin);

                if(tamaño == patron.length)
                {
                    if(sonSecuenciasIguales(arrEnteros, patron, inicio, fin)){
                        for(int i = 0; i < patron.length; i++){

                            corrimientoIzquierda(arrEnteros, inicio);
                        }
                        fin = inicio - 1;
                    }
                }
            }
        }
    }

    public static int obtener_inicio_secuencia(int[] arrEnteros, int ini) {
        while (ini<TAM && arrEnteros[ini]==0)
        ini++;
        return ini;
    }

    public static int obtener_fin_secuencia(int[] arrEnteros, int ini) {
        while (ini<TAM && arrEnteros[ini]!=0)
        ini++;
        return ini-1;
    }

    public static void mostrarArreglo(int[] arrenteros){
        for (int pos = 0; pos < arrenteros.length; pos++){
        System.out.println("arrenteros["+pos+"] -> "+arrenteros[pos]);
        }
    }
}
