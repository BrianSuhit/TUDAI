public class AlarmaDeIntrusion {
/*
 SIMULACRO NIVEL 2 (Fase 1 - Simple): "Alarma de Intrusión"
La Consigna: El sistema de seguridad de una bóveda registra los números de identificación (ID) de los empleados que ingresan a la zona de cajas. Los ingresos se guardan en un arreglo de secuencias separadas por ceros (0). Cada secuencia representa los ingresos que hubo durante una hora.
El gerente de seguridad detectó que una banda organizada siempre ingresa en grupo usando exactamente la misma combinación de tres tarjetas robadas: los IDs 99, 88 y 77 en ese orden exacto.
Se te pide recorrer el arreglo de ingresos y buscar si esa secuencia sospechosa aparece. Como el patrón exacto ya lo conocemos, está guardado en un arreglo patronSospechoso que no tiene separadores. Debés contar cuántas veces aparece esta banda y mostrarlo por pantalla.
*/
    public static final int SEPARADOR = 0;

    public static void main(String[] args) {
        
        // Hora 1: ingresan 101, 102
        // Hora 2: ingresan 99, 88, 77 -> ¡COINCIDENCIA EXACTA!
        // Hora 3: ingresa 201
        // Hora 4: ingresan 99, 88, 77 -> ¡COINCIDENCIA EXACTA!
        
        int[] arrIngresos = {0, 101, 102, 0, 99, 88, 77, 0, 201, 0, 99, 88, 77, 0, 0};
        
        int[] patronSospechoso = {99, 88, 77};

        int ini = 0;
        int fin = -1;
        int contadorBanda = 0;

        while( ini < arrIngresos.length){
            ini = buscarInicio(arrIngresos, fin + 1);

            if(ini < arrIngresos.length){
                fin = buscarFin(arrIngresos, ini);

                if(cumplePatron(arrIngresos, ini, fin, patronSospechoso)){
                    contadorBanda++;
                }
            }
        }        
        System.out.println("La banda ingresó " + contadorBanda + " veces.");
    }

    public static boolean cumplePatron(int[] arrA, int ini, int fin, int[] arrP){
        int i = ini;
        int j = 0;

        if(fin - ini + 1 != arrP.length){
            return false;
        }

        while(i <= fin && arrA[i] == arrP[j]){
            i++;
            j++;
        }
        return i > fin;
    }
    
    public static int buscarInicio(int[] arr, int pos){
        while(pos < arr.length && arr[pos] == SEPARADOR){
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
