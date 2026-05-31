public class SimulacroCensura {
/*
🛑 Simulacro 2: "Censura de Mensajes" (Nivel 2 + Nivel 5)
Para terminar de matar ese miedo al for en el main, vamos a subir la apuesta. Vamos a mezclar la "Lectura Cruzada" con la "Trituradora Masiva" [cite: 449].
El Dominio (Consigna Pura): Un sistema de chat gubernamental intercepta mensajes en un arreglo de caracteres T de tamaño MAX. Las palabras (secuencias) están separadas por uno o más espacios en blanco (' '). El arreglo empieza y termina con espacios. El departamento de inteligencia te provee un segundo arreglo P (el Patrón), que contiene una única palabra prohibida exacta. Este arreglo P NO tiene espacios ni al principio ni al final, solo contiene los caracteres de la palabra prohibida (por ejemplo: {'b', 'o', 'm', 'b', 'a'}).
La Regla de Censura: Tenés que recorrer el arreglo T. Si encontrás una palabra que coincida exactamente (mismo tamaño y mismos caracteres) con la palabra prohibida del arreglo P, debés eliminar el vagón completo del arreglo T [cite: 449, 467, 474].
*/
    public static final char SEPARADOR = ' ';

    public static void main(String[] args) {

        // Patrón P: "bomba" (limpio, sin espacios)
        char[] P = {'b', 'o', 'm', 'b', 'a'};
        
        // T: " bomba hola bomba bo bomba "
        // Esperado: Al final solo debe quedar " hola bo " y el resto espacios.
        char[] T = {' ', 'b', 'o', 'm', 'b', 'a', ' ', 'h', 'o', 'l', 'a', ' ', 'b', 'o', 'm', 'b', 'a', ' ', 'b', 'o', ' ', 'b', 'o', 'm', 'b', 'a', ' ', ' ', ' ', ' '};

        System.out.println("Mensaje Original:");
        mostrarArreglo(T);

        int ini = 0;
        int fin = -1;

        while(ini < T.length){
            ini = buscarInicio(T, fin + 1);

            if(ini < T.length){
                fin = buscarFin(T, ini);

                
                if(sonIguales(T, ini, fin, P)){

                    int tamaño = fin - ini + 1;

                    for(int i = 0; i < tamaño; i++){
                        corrimientoIzquierda(T, ini);
                    }
                    fin = fin - tamaño;
                }
            }
        }
        System.out.println("\nMensaje Censurado:");
        mostrarArreglo(T);
    }

    public static boolean sonIguales(char[] arrA, int ini, int fin, char[] arrB){
        if(fin - ini + 1 != arrB.length){
            return false;
        }

        int j = 0;

        while(ini <= fin && arrA[ini] == arrB[j]){
            ini++;
            j++;
        }
        return ini > fin;
    }
    
    public static void corrimientoIzquierda(char[] arr, int pos){
        for(int i = pos; i < arr.length - 1; i++){
            arr[i] = arr[i + 1];
        }
    }

    public static int buscarInicio(char[] arr, int pos){
        while(pos < arr.length && arr[pos] == SEPARADOR){
            pos++;
        }
        return pos;
    }

    public static int buscarFin(char[] arr, int pos){
        while(pos < arr.length && arr[pos] != SEPARADOR){
            pos++;
        }
        return pos - 1;
    }

    public static void mostrarArreglo(char[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print("[" + arr[i] + "]");
        }
        System.out.println("");
    }
}
