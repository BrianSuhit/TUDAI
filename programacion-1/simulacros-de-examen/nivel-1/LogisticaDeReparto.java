public class LogisticaDeReparto {
/*
La Consigna: Una empresa de correos organiza los paquetes que deben entregarse en diferentes rutas. Los números de identificación de los paquetes (números enteros positivos) se guardan en un arreglo de secuencias separadas por ceros (0). Cada secuencia representa una ruta de entrega individual.
El gerente de logística detectó un problema: por un error en el sistema del depósito, todas las rutas que tienen exactamente una cantidad N de paquetes, fueron cargadas al camión al revés.
Se te pide recorrer el arreglo y, cada vez que encuentres una ruta que tenga exactamente N paquetes (es decir, el tamaño de la secuencia es igual a N), inviertas el orden de los paquetes dentro de esa misma ruta para corregir el error.
Al finalizar, el programa simplemente debe terminar (las modificaciones se hacen sobre el mismo arreglo).
(Pista conceptual: Pensá en cómo harías que el iterador ini y el iterador fin caminen uno hacia el otro intercambiando sus cajas hasta encontrarse en el medio).
*/
    public static final int SEPARADOR = 0;
    public static final int CANTIDAD_ERROR = 4; // Rutas con exactamente 4 paquetes están al revés

    public static void main(String[] args) {
        
        // Ruta 1: 10, 20, 30 (Tamaño 3) -> Está bien, no se toca.
        // Ruta 2: 41, 42, 43, 44 (Tamaño 4) -> ¡ERROR! Se debe invertir para que quede: 44, 43, 42, 41
        // Ruta 3: 15, 16 (Tamaño 2) -> Está bien, no se toca.
        // Ruta 4: 91, 92, 93, 94 (Tamaño 4) -> ¡ERROR! Se debe invertir para que quede: 94, 93, 92, 91
        
        int[] arrRutas = {0, 10, 20, 30, 0, 41, 42, 43, 44, 0, 15, 16, 0, 91, 92, 93, 94, 0, 0};

        int ini = 0;
        int fin = -1;

        while(ini < arrRutas.length){
            ini = buscarInicio(arrRutas, fin + 1);

            if(ini < arrRutas.length){
                fin = buscarFin(arrRutas, ini);

                int tamaño = fin - ini + 1;

                if(tamaño == CANTIDAD_ERROR){
                    invertirRuta(arrRutas, ini, fin);
                }
            }
        } 
    }
    
    public static void invertirRuta(int[] arr, int ini, int fin){

        int izq = ini;
        int der = fin;

        while(izq < der){
            int aux = arr[izq];
            arr[izq] = arr[der];
            arr[der] = aux;
            izq++;
            der--;
        }
    }

    public static int buscarInicio(int[] arr, int pos){
        while(pos < arr.length && arr[pos] == SEPARADOR){
            pos++;
        }
        return pos;
    }

    public static int buscarFin(int[] arr, int pos){
        while( pos < arr.length && arr[pos] != SEPARADOR){
            pos++;
        }
        return pos - 1;
    }
}
