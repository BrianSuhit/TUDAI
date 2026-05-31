public class Ejercicio29 {
/*
29. Hacer un programa que dado un número N ingresado por el
usuario, elimine las secuencias de tamaño N de números distintos
de cero.
*/
    public static final int TAM = 10;
    public static void main(String[] args) {
        
        int[] arrEnteros = {0, 1, 2, 3, 0, 0, 0, 8, 6, 0};

        int N = obtener_ingreso();

        procesar_secuencias(arrEnteros, N);
        mostrarArreglo(arrEnteros);
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

    public static void procesar_secuencias(int[] arrEnteros, int numero) {
        int inicio = 0;
        int fin = -1;

        while(inicio < TAM){
            inicio = obtener_inicio_secuencia(arrEnteros, fin+1);

            if (inicio < TAM){
                fin = obtener_fin_secuencia(arrEnteros, inicio);

                int cantElementos = fin - inicio + 1;

                if(cantElementos == numero){
                    for(int i = 0; i < numero; i++){

                        corrimientoIzquierda(arrEnteros, inicio);
                    }
                fin = inicio - 1;
                }
            }
        }
    }



    public static void corrimientoIzquierda(int[] arreglo, int posHueco) {
        for(int pos = posHueco; pos < TAM - 1; pos++){
            arreglo[pos] = arreglo[pos + 1];
        }
    }

    public static void mostrarArreglo(int[] arrenteros){
        for (int pos = 0; pos < arrenteros.length; pos++){
        System.out.println("arrenteros["+pos+"] -> "+arrenteros[pos]);
        }
    }

    public static int obtener_ingreso(){
        int numero = 0;
        System.out.println("Ingrese un numero");
        numero = Utils.leerInt();
        return numero; 
    }
}
