public class RestauracionDeBackupCONSULTAR {
/*
📝 SIMULACRO NIVEL 1: "Restauración de Copia de Seguridad"
La Consigna: El sistema de un banco guarda los registros de transacciones en un arreglo de secuencias separadas por ceros (0). Cada secuencia representa un Lote de Backup diario.
El servidor principal acaba de sufrir un colapso justo cuando estaba escribiendo el último lote del día. Por protocolo de seguridad del banco, el último lote guardado se considera "corrupto" y no se puede utilizar.
El gerente de sistemas te pide recorrer el arreglo para encontrar la posición de inicio y fin del anteúltimo lote de backup (el último lote que se guardó de forma 100% segura), para poder restaurar el servidor desde ahí. (Se asume que el arreglo siempre tiene al menos dos lotes).
Al finalizar, el programa debe imprimir: "El backup seguro para restaurar está entre las posiciones X e Y".
*/
    public static final int SEPARADOR = 0;

    public static void main(String[] args) {
        
        int[] arrBackups = {0, 101, 102, 0, 201, 202, 203, 0, 0, 301, 302, 0, 401, 402, 403, 0, 0};

        // Arrancamos desde la última posición del arreglo
        int pos = arrBackups.length - 1;

        // 1. Buscamos el final de la ÚLTIMA secuencia (salteando los ceros del final)
        pos = buscarFinReversa(arrBackups, pos);

        if (pos >= 0) { // Si encontramos algo válido y no nos caímos del arreglo
            
            // 2. Saltamos la ÚLTIMA secuencia entera (el backup corrupto)
            pos = buscarInicioReversa(arrBackups, pos);
            // Acá 'pos' quedó parado justo en el separador 0 que está ANTES de la última secuencia
            
            // 3. Ahora sí, buscamos el final de la ANTEÚLTIMA secuencia
            int anteFin = buscarFinReversa(arrBackups, pos);
            
            if (anteFin >= 0) {
                // 4. Buscamos dónde empieza esa anteúltima secuencia
                // Le sumamos 1 porque el método nos deja parados sobre el separador 0
                int anteIni = buscarInicioReversa(arrBackups, anteFin) + 1;
                
                System.out.println("El backup seguro para restaurar está entre las posiciones " + anteIni + " y " + anteFin);
            }
        }
    }

    // Camina hacia atrás saltando DATOS VÁLIDOS hasta chocar con el separador anterior 
    public static int buscarInicioReversa(int[] arr, int pos) {
        while (pos >= 0 && arr[pos] != SEPARADOR) {
            pos--;
        }
        return pos; 
    }

    // Camina hacia atrás saltando SEPARADORES hasta encontrar un dato válido (el FIN de una secuencia)
    public static int buscarFinReversa(int[] arr, int pos) {
        while (pos >= 0 && arr[pos] == SEPARADOR) {
            pos--;
        }
        return pos;
    }
}
