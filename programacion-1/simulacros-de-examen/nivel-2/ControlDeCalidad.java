public class ControlDeCalidad {
/*
📝 SIMULACRO NIVEL 2 (Fase 1 - Ejercicio 3 de 10): "Control de Calidad (Corte Temprano)"
La Consigna: En una fábrica de procesadores, las lecturas de voltaje de los chips en la línea de ensamblaje se registran en un arreglo separadas por ceros (0).
El ingeniero de planta sabe que si en cualquier momento aparece una secuencia exacta de voltajes defectuosos (guardada en el arreglo arrFalla que viene con basura en los bordes), significa que la máquina soldadora se descalibró y hay que detener toda la fábrica inmediatamente.
A diferencia del ejercicio anterior, acá no nos importa contar cuántas veces aparece la falla. Si aparece UNA sola vez, el sistema debe arrojar la alerta y dejar de procesar el resto del arreglo para ahorrar recursos.
Se te pide recorrer el arreglo de la línea de ensamblaje buscando el patrón de falla. Si se encuentra, detener la búsqueda e imprimir "¡ALERTA! Falla detectada en la línea.". Si el motor revisa toda la línea y no encuentra nada, imprimir "Línea de ensamblaje en perfectas condiciones."
*/
     public static final int SEPARADOR = 0;

    public static void main(String[] args) {
        
        // Chips:
        // Secuencia 1: 220, 215
        // Secuencia 2: 10, 15, 20 -> ¡Falla encontrada! ¡Acá el while se tiene que cortar!
        // Secuencia 3: 220, 220 (Esta ya ni se debería evaluar)
        int[] lineaEnsamblaje = {0, 220, 215, 0, 10, 15, 20, 0, 220, 220, 0, 0};

        int[] arrFalla = {0, 0, 10, 15, 20, 0};

        int ini = 0;
        int fin = -1;

        int iniP = buscarInicio(arrFalla, 0);
        int finP = buscarFin(arrFalla, iniP);
        
        boolean fallaEncontrada = false;

        while(ini < lineaEnsamblaje.length && !fallaEncontrada){
            ini = buscarInicio(lineaEnsamblaje, fin + 1);

            if(ini < lineaEnsamblaje.length){
                fin = buscarFin(lineaEnsamblaje, ini);

                fallaEncontrada = cumplePatron(lineaEnsamblaje, ini, fin, arrFalla, iniP, finP);
            }
        }
        if(fallaEncontrada){
            System.out.println("¡ALERTA! Falla detectada en la línea.");
        }else {
            System.out.println("Línea de ensamblaje en perfectas condiciones.");
        }
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

    public static boolean cumplePatron(int[] arrA, int ini, int fin, int[] arrP, int iniP, int finP){
        if(fin - ini + 1 != finP - iniP + 1){
            return false;
        }

        while(ini <= fin && arrA[ini] == arrP[iniP]){
            ini++;
            iniP++;
        }
        return ini > fin;
    }
}
