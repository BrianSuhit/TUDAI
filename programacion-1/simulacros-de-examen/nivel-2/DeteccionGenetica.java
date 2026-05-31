public class DeteccionGenetica {
/*
 SIMULACRO NIVEL 2 (Fase 1 - Patrón con Separadores): "Detección Genética"
La Consigna: El sistema de un laboratorio analiza muestras de ADN de pacientes. La secuencia genética del paciente se carga en un arreglo de enteros separados por ceros (0).
Los investigadores están buscando si el paciente posee una mutación genética específica. Esta mutación está guardada en otro arreglo llamado arrMutacion. El problema es que la máquina que lee la mutación siempre agrega ceros de basura al principio y al final del arreglo.
Se te pide:
Aislar la secuencia útil de la mutación.
Recorrer el ADN del paciente y contar cuántas veces aparece exactamente esa mutación genética.
*/
    public static final int SEPARADOR = 0;

    public static void main(String[] args) {
        
        // ADN del paciente.
        // Secuencia 1: 10, 15
        // Secuencia 2: 99, 88 -> ¡Mutación encontrada!
        // Secuencia 3: 7, 4, 1
        // Secuencia 4: 99, 88 -> ¡Mutación encontrada!
        int[] arrADN = {0, 10, 15, 0, 99, 88, 0, 7, 4, 1, 0, 99, 88, 0, 0};
        
        int[] arrMutacion = {0, 0, 0, 99, 88, 0, 0};

        int ini = 0;
        int fin = -1;

        int iniP = buscarInicio(arrMutacion, 0);
        int finP = buscarFin(arrMutacion, iniP);
        int contadorMutaciones = 0;
        
        while(ini < arrADN.length){
            ini = buscarInicio(arrADN, fin + 1);

            if(ini < arrADN.length){
                fin = buscarFin(arrADN, ini);

                if(cumplePatron(arrADN, ini, fin, arrMutacion, iniP, finP)){
                    contadorMutaciones++;
                }
            }
        }
        System.out.println("La mutación se encontró " + contadorMutaciones + " veces.");
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
