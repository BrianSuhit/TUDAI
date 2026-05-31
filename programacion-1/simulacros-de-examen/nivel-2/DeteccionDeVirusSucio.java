public class DeteccionDeVirusSucio {
/*
📝 SIMULACRO NIVEL 2 (Fase 2 - Ejercicio 7 de 10): "Virus Escondido con Basura"
La Consigna: Es idéntico al anterior, pero ahora el arreglo de la firma del virus (firmaVirus) fue extraído de un sensor defectuoso y viene con ceros de basura en los bordes. Tenés que aislar el patrón primero en el main y luego hacer la búsqueda de subcadena (deslizamiento) usando esos índices.
*/
    public static final int SEPARADOR = 0;

    public static void main(String[] args) {
        
        int[] discoDuro = {0, 15, 20, 0, 10, 99, 88, 30, 0, 99, 88, 0, 7, 4, 1, 0, 0};
        
        // ¡OJO ACÁ! El patrón ahora tiene basura
        int[] firmaVirus = {0, 0, 0, 99, 88, 0, 0};

        // ... ¡Todo tuyo!
        int ini = 0;
        int fin = -1;

        int iniP = buscarInicio(firmaVirus, 0);
        int finP = buscarFin(firmaVirus, iniP);

        int archivosInfectados = 0;

        while(ini < discoDuro.length){
            ini = buscarInicio(discoDuro, fin + 1);

            if(ini < discoDuro.length){
                fin = buscarFin(discoDuro, ini);

                if(cumplePatron(discoDuro, ini, fin, firmaVirus, iniP, finP)){
                    archivosInfectados++;
                }
            }
        }
        System.out.println("Se encontraron " + archivosInfectados + " archivos infectados.");
    }

    public static boolean cumplePatron(int[] arrA, int ini, int fin, int[] arrP, int iniP, int finP){

        int tamañoPatron = finP - iniP + 1;

        if(fin - ini + 1 < tamañoPatron){
            return false;
        }

        int k = ini;
         int limiteParaAnclar = fin - tamañoPatron + 1; // Para no caernos del vagón

        while (k <= limiteParaAnclar) {
            
            int i = k; 
            int j = iniP; 

            // Ojo: ahora la condición de j no es 'j < arrP.length', es 'j <= finP'
            while (i <= fin && j <= finP && arrA[i] == arrP[j]) {
                i++;
                j++;
            }

            // 5. ¿LO ENCONTRÓ?
            // Si la j logró dar todos los pasos y superó el límite útil, el virus está.
            if (j > finP) {
                return true;
            }

            // Si no lo encontró desde esta ancla, muevo el ancla un paso a la derecha
            k++;
        }
        return false; // Si recorrió todo y no salió por el true, no está.
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
