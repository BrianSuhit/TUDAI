public class ControlDeTemperatura {
/*
📝 SIMULACRO NIVEL 1: "Control de Temperaturas"
La Consigna: Una estación meteorológica registra las temperaturas (en números enteros) de diferentes días en un arreglo de secuencias separadas por ceros (0). Cada secuencia representa las temperaturas medidas durante un mismo día.
Se te pide recorrer el arreglo y contar cuántos días (secuencias) registraron al menos una temperatura que supere un valor UMBRAL definido.
Al finalizar de recorrer todo el arreglo, el programa simplemente debe imprimir: "Hubo X días de calor extremo".
*/
    public static final int SEPARADOR = 0;
    public static final int UMBRAL = 35;

    public static void main(String[] args) {
        
        // El 1er día (30, 32) no supera el umbral.
        // El 2do día (28, 36, 31) SÍ lo supera (tiene un 36).
        // El 3er día (38, 39) SÍ lo supera.
        // Resultado esperado al final: "Hubo 2 días de calor extremo"
        
        int[] arrTemperaturas = {0, 30, 32, 0, 28, 36, 31, 0, 38, 39, 0, 0};

        int ini = 0;
        int fin = -1;
        int contadorDias = 0;


        while(ini < arrTemperaturas.length){
            ini = buscarInicio(arrTemperaturas, fin + 1);

            if( ini < arrTemperaturas.length){
                fin = buscarFin(arrTemperaturas, ini);

                if(hayUmbral(arrTemperaturas, ini, fin)){ 
                    contadorDias++; 
                }
            }
        }
        System.out.println("Hubo " +  contadorDias + " días de calor extremo");
    }

    public static boolean hayUmbral(int[] arr, int ini, int fin){
    int i = ini;
    while(i <= fin) {
        if(arr[i] > UMBRAL) {
            return true; 
        }
        i++; 
    }
    return false; 
    }

    public static int buscarInicio(int[] arr, int pos){
        while(pos < arr.length && arr[pos] == 0){
            pos++;
        }
        return pos;
    }

    public static int buscarFin(int[] arr, int pos){
        while(pos < arr.length && arr[pos] != 0){
            pos++;
        }
        return pos;
    }
}
