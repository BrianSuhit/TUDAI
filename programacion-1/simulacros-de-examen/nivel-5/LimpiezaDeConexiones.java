public class LimpiezaDeConexiones {
/*
Simulacro 1 - "Limpieza de Tareas Cortas" (Nivel 5)
El Dominio (Consigna Oficial): Un servidor registra los tiempos de conexión de sus usuarios. Cada tiempo (en segundos) es un número entero positivo y se almacena en un arreglo de tamaño MAX. Las conexiones de cada sesión están agrupadas en secuencias y separadas entre sí por uno o más 0 [cite: 372].
Se ha detectado que las conexiones que duran exactamente N segundos (es decir, secuencias cuyo tamaño total es igual a N) son intentos de ping o bots que ensucian el registro [cite: 373].
Se pide realizar un programa en Java que, dado un número N, elimine por completo todas las secuencias que tengan exactamente ese tamaño [cite: 373]. Se deben aplicar las buenas prácticas de la cátedra, utilizando procedimientos (void) para la eliminación y manteniendo la consistencia del arreglo principal [cite: 312, 385, 431].
*/
    public static final int SEPARADOR = 0;

    public static void main(String[] args) {

        int[] conexiones = {0, 12, 45, 0, 8, 0, 33, 14, 55, 0, 9, 10, 0, 0, 0, 0, 0, 0, 0, 0};
        int N = 2; 

        System.out.println("Registro original:");
        mostrarArreglo(conexiones);

        // LOGICA ACA
        int ini = 0;
        int fin = -1;

        while(ini < conexiones.length){
            ini = buscarInicio(conexiones, fin+1);

            if(ini < conexiones.length){
                fin = buscarFin(conexiones, ini);

                int tamaño = fin - ini + 1;
                if(tamaño == N){

                    for(int i = 0; i < tamaño; i++){
                        corrimientoIzquierda(conexiones, ini);
                    }
                    fin = fin - tamaño;
                }
            }
        }
        System.out.println("\nRegistro después de la limpieza:");
        mostrarArreglo(conexiones);
    }

    public static void corrimientoIzquierda(int[] arr, int pos){
        for(int i = pos; i < arr.length - 1; i++){
            arr[i] = arr[i + 1];
        }
    }

    public static int buscarInicio(int[] arr, int pos) {
        while(pos < arr.length && arr[pos] == SEPARADOR){
            pos++;
        }
        return pos;
    }

    public static int buscarFin(int[] arr, int pos) {
        while(pos < arr.length && arr[pos] != SEPARADOR){
            pos++;
        }
        return pos - 1;
    }

    public static void mostrarArreglo(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " | ");
        }
    }
    
    // Tus métodos acá
}
