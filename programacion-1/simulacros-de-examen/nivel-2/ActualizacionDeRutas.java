public class ActualizacionDeRutas {
/*
📝 SIMULACRO NIVEL 2 (Fase 1 - Ejercicio 4 de 10): "Actualización de Rutas de Red"
La Consigna: El sistema de ruteo de un servidor de internet guarda los "saltos" de red en un arreglo separados por ceros (0). La empresa acaba de cambiar de proveedor de fibra óptica, por lo que una ruta específica antigua (ej: 192, 168, 1) quedó obsoleta y cada vez que aparezca en el servidor debe ser reemplazada inmediatamente por la ruta nueva (255, 255, 2).
Se te pide recorrer el arreglo general del servidor. Cada vez que encuentres la ruta obsoleta exacta, debes reemplazarla pisando sus valores con los de la ruta nueva.
Nota: Como te da directamente los datos útiles, los arreglos rutaObsoleta y rutaNueva están limpios (sin separadores), por lo que caemos en el "Caso A" de tu apunte de Notion.
*/
    public static final int SEPARADOR = 0;

    public static void main(String[] args) {
        
        // Servidor:
        // Ruta 1: 10, 20
        // Ruta 2: 192, 168, 1 -> ¡Ruta obsoleta! (Reemplazar por 255, 255, 2)
        // Ruta 3: 8, 8, 8, 8
        // Ruta 4: 192, 168, 1 -> ¡Ruta obsoleta! (Reemplazar por 255, 255, 2)
        
        int[] arrRutas = {0, 10, 20, 0, 192, 168, 1, 0, 8, 8, 8, 8, 0, 192, 168, 1, 0, 0};
        
        // Patrón limpio (sin separadores). Tamaño: rutaObsoleta.length
        int[] rutaObsoleta = {192, 168, 1}; 
        
        // Arreglo de reemplazo (mismo tamaño que el patrón)
        int[] rutaNueva = {255, 255, 2};

        int ini = 0;
        int fin = -1;
        
        while(ini < arrRutas.length){
            ini = buscarInicio(arrRutas, fin + 1);
                
            if(ini < arrRutas.length){
                fin = buscarFin(arrRutas, ini);

                if(cumplePatron(arrRutas, ini, fin, rutaObsoleta)){
                    reemplazarSecuencia(arrRutas, ini, fin, rutaNueva);
                }
            }
        }

        System.out.println("Nuevas rutas del servidor:");
        for(int i = 0; i < arrRutas.length; i++){
            System.out.print(arrRutas[i] + " | ");
        }
    }

    public static void reemplazarSecuencia(int[] arrA, int ini, int fin, int[] arrR){
        int j = 0;

        for(int i = ini; i <= fin; i++){
            arrA[i] = arrR[j];
            j++;
        }
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
