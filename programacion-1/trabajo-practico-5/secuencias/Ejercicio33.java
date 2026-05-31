public class Ejercicio33 {
/*
33. Hacer un programa que invierta el orden de la última secuencia
en un arreglo.
*/
    public static final int TAM = 15;

    public static void main(String[] args) {
        
        int[] arreglo = {0, 1, 2, 0, 3, 4, 0, 1, 2, 0, 5, 0, 1, 2, 0};

        procesar_secuencias(arreglo);

        mostrarArreglo(arreglo);
    }

    public static void procesar_secuencias(int[] arrEnteros) {
        int inicio = 0;
        int fin = -1;
        
        int ultimoInicio = 0;
        int ultimoFin = 0;

        while(inicio < TAM){
            inicio = obtener_inicio_secuencia(arrEnteros, fin+1);

            if (inicio < TAM){
                fin = obtener_fin_secuencia(arrEnteros, inicio);
                
                ultimoInicio = inicio;
                ultimoFin = fin;      
            }
        }

        invertir_secuencia(arrEnteros, ultimoInicio, ultimoFin);
    }

    public static void invertir_secuencia(int[] arrEnteros, int inicio, int fin){
        int izquierda = inicio;
        int derecha = fin;

        while(izquierda < derecha) {
            int aux = arrEnteros[izquierda];
            arrEnteros[izquierda] = arrEnteros[derecha];
            arrEnteros[derecha] = aux;
            izquierda++;
            derecha--;
        }
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
