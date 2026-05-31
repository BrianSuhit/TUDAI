public class HackeoLimpio {
/*
El Dominio: Tenés el registro de un servidor guardado en un int[] logs. Los IDs de los usuarios están separados por ceros. Ejemplo: logs = {0, 0, 102, 14, 0, 88, 9, 21, 0, 102, 14, 0}
El equipo de ciberseguridad te pasa la "firma" de un hacker. Esa firma es una secuencia exacta de IDs, guardada en un arreglo int[] firma. La ventaja es que la firma está limpia, no tiene separadores. Ejemplo: firma = {88, 9, 21}
La Consigna: Se pide recorrer los logs y simplemente contar cuántas veces aparece la firma exacta del hacker.
*/
    public static final int SEPARADOR = 0;
    public static void main(String[] args) {
        
        int[] logs = {0, 0, 102, 14, 0, 88, 9, 21, 0, 102, 14, 0};
        int[] firma = {88, 9, 21};

        procesarSecuencia(logs, firma);
    }

    public static void procesarSecuencia(int[] logs, int[] arrB){
        int ini = 0;
        int fin = -1;
        int contadorDeFirmas = 0;

        while(ini < logs.length){
            ini = buscarInicio(logs, fin + 1);

            if(ini < logs.length){
                fin = buscarFin(logs, ini);

                if(esPatron(logs, ini, fin, arrB)){
                    contadorDeFirmas++;
                }
            }
        }
        System.out.println("la firma aparece: " + contadorDeFirmas + " veces.");
    }

    public static boolean esPatron(int[] arrA, int ini, int fin, int[] arrP){
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
