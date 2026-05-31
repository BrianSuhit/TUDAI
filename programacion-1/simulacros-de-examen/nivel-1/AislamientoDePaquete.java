public class AislamientoDePaquete {
/*
📝 SIMULACRO NIVEL 1 FINAL: "Aislamiento de Paquete Corrupto"
La Consigna: Un satélite meteorológico transmite paquetes de datos a la base terrestre. Estos datos se guardan en un arreglo de secuencias separadas por ceros (0), donde cada secuencia es un paquete de telemetría.
El sistema antivirus detectó que una ráfaga de radiación corrompió un dato específico en la memoria RAM y arrojó una alarma indicando la posición exacta del arreglo donde ocurrió el impacto (la posicionFalla).
Como ingeniero de software, se te pide recorrer el arreglo para aislar el paquete completo que resultó afectado. Debes encontrar dónde empieza y dónde termina la secuencia que contiene a esa posición dañada. (Podés asumir que la posición de falla siempre caerá sobre un dato válido, nunca sobre un separador).
Al finalizar, el programa debe imprimir: "El paquete afectado empieza en la posición X y termina en la posición Y".
*/
    public static final int SEPARADOR = 0;

    public static void main(String[] args) {
        
        // Paquete 1: 10, 20, 30 (Posiciones 1 a 3)
        // Paquete 2: 44, 55 (Posiciones 5 a 6)
        // Paquete 3: 99, 88, 77, 66 (Posiciones 8 a 11) -> ¡Acá adentro está la falla!
        
        int[] arrDatos = {0, 10, 20, 30, 0, 44, 55, 0, 99, 88, 77, 66, 0, 0};
        
        // El antivirus arroja que la radiación pegó en el índice 9 (donde está el número 88)
        int posicionFalla = 9; 

        int ini = 0;
        int fin = -1;
        
        // Variables para guardar tu resultado
        int paqueteIni = -1;
        int paqueteFin = -1;

        while(ini < arrDatos.length){
            ini = buscarInicio(arrDatos, fin + 1);

            if(ini < arrDatos.length){
                fin = buscarFin(arrDatos, ini);

                if(posicionFalla >= ini && posicionFalla <= fin){
                    paqueteIni = ini;
                    paqueteFin = fin;
                }
            }
        }
        System.out.println("El paquete afectado empieza en la posición: " + paqueteIni + " y termina en la posición: " + paqueteFin);
        
    }
    
    public static int buscarInicio(int[] arr, int pos){
        while( pos < arr.length && arr[pos] == SEPARADOR){
            pos++;
        }
        return pos;
    }

    public static int buscarFin(int[] arr, int pos){
        while(pos < arr.length && arr[pos] != SEPARADOR){
            pos++;
        }
        return pos - 1;
    }
}
