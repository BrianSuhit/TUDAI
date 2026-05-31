public class ReemplazoLoteDefectuoso {
/*
📝 SIMULACRO NIVEL 2 (Fase 1 - Ejercicio 5 de 10): "Reemplazo de Lote Defectuoso"
La Consigna: En una fábrica, los lotes de productos se registran en una cinta transportadora virtual representados por un arreglo de enteros separados por ceros (0).
Se detectó que una máquina falló y generó una secuencia específica de productos fallados (el loteDefectuoso, ej: 99, 88). La fábrica preparó una secuencia de productos sanos para sustituirlos (el loteCorregido, ej: 77, 77).
Como los datos provienen de los sensores de la máquina, ambos arreglos extra (el defectuoso y el corregido) vienen con ceros de basura en los extremos.
Se te pide recorrer la cinta transportadora. Cada vez que encuentres la secuencia defectuosa exacta, debes reemplazarla pisando sus valores con los de la secuencia corregida. Asumí que la parte útil de ambos arreglos extra tiene exactamente el mismo tamaño (no hay corrimientos).
*/
    public static final int SEPARADOR = 0;

    public static void main(String[] args) {
        
        // Cinta transportadora:
        // Lote 1: 10, 20
        // Lote 2: 99, 88 -> ¡Defectuoso! (Reemplazar por 77, 77)
        // Lote 3: 30, 40
        // Lote 4: 99, 88 -> ¡Defectuoso! (Reemplazar por 77, 77)
        
        int[] cinta = {0, 10, 20, 0, 99, 88, 0, 30, 40, 0, 99, 88, 0, 0};
        
        // Patrón a buscar (viene con basura)
        int[] loteDefectuoso = {0, 0, 0, 99, 88, 0, 0}; 
        
        // Arreglo de reemplazo (viene con basura, parte útil mismo tamaño)
        int[] loteCorregido = {0, 77, 77, 0};

        int ini = 0;
        int fin = -1;
        
        // 1. AISLÁ AMBOS ARREGLOS ACÁ UNA SOLA VEZ
        int iniP = buscarInicio(loteDefectuoso, 0);
        int finP = buscarFin(loteDefectuoso, iniP);
        int iniR = buscarInicio(loteCorregido, 0);
        //int finR = buscarFin(loteCorregido, iniR);

        while(ini < cinta.length){
            ini = buscarInicio(cinta, fin + 1);

            if( ini < cinta.length){
                fin = buscarFin(cinta, ini);

                if(cumplePatron(cinta, ini, fin, loteDefectuoso, iniP, finP)){
                    reemplazarSecuencia(cinta, ini, fin, loteCorregido, iniR);
                }
            }
        }

        System.out.println("Cinta actualizada:");
        for(int i = 0; i < cinta.length; i++){
            System.out.print(cinta[i] + " | ");
        }
    }
    

    public static boolean cumplePatron(int[] arrA, int ini, int fin, int[] arrP, int iniP, int finP) { 
        if(fin - ini + 1 != finP - iniP + 1){
            return false;
        }

        while(ini <= fin && arrA[ini] == arrP[iniP]){
            ini++;
            iniP++;
        }
        return ini > fin;
    }
    
    public static void reemplazarSecuencia(int[] arrA, int ini, int fin, int[] arrR, int iniR) { 
        int j = iniR;

        for(int i = ini; i <= fin; i++){
            arrA[i] = arrR[j];
            j++;
        }
    }
    
    public static int buscarInicio(int[] arr, int pos){
        while( pos < arr.length && arr[pos] == SEPARADOR){
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
