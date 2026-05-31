public class Ejercicio31 {
/*
31. Hacer un programa que elimine de un arreglo todas las
secuencias que tienen orden descendente entre sus elementos.
*/
    public static void main(String[] args) {

        int[] arreglo = {0, 5, 8, 12, 0, 15, 10, 5, 0, 3, 7, 0, 20, 15, 10, 5, 2, 0};

        procesar_secuencias(arreglo);
        mostrarArreglo(arreglo);
    }

    public static void corrimientoIzquierda(int[] arreglo, int posHueco) {
        for(int pos = posHueco; pos < arreglo.length - 1; pos++){
            arreglo[pos] = arreglo[pos + 1];
        }
    }

    public static void procesar_secuencias(int[] arrEnteros) {
        int inicio = 0;
        int fin = -1;

        while(inicio < arrEnteros.length){
            inicio = obtener_inicio_secuencia(arrEnteros, fin+1);

            if (inicio < arrEnteros.length){
                fin = obtener_fin_secuencia(arrEnteros, inicio);

                if(es_orden_descendente(arrEnteros, inicio, fin)){
                    for(int i = 0; i < fin - inicio + 1; i++){

                        corrimientoIzquierda(arrEnteros, inicio);
                    }
                    fin = inicio - 1;
                }
            }
        }
    }

    public static boolean es_orden_descendente(int[] arrEnteros, int inicio, int fin){
        boolean esDescendente = true;

        // porque un paso antes de fin?
        while(inicio < fin){
            if(arrEnteros[inicio] <= arrEnteros[inicio + 1]){
                esDescendente = false;
            }
            inicio++;
        }
        return esDescendente;
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
