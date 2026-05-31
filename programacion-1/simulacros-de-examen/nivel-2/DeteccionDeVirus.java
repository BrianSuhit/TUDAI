public class DeteccionDeVirus {
/*
📝 SIMULACRO NIVEL 2 (Fase 2 - Ejercicio 6 de 10): "Detección de Virus"
La Consigna: Un sistema antivirus escanea la memoria de una computadora. Los archivos están representados como secuencias de enteros en un arreglo, separados por ceros (0). Se descubrió un nuevo virus cuya "firma" maliciosa es la secuencia exacta 99, 88. El problema es que el virus se esconde adentro de archivos sanos (es decir, el vagón puede tener números limpios antes o después del virus).
Se te pide recorrer el disco duro (arreglo principal) y contar cuántos archivos están infectados.
*/
    public static final int SEPARADOR = 0;

    public static void main(String[] args) {
        
        // Archivos en disco:
        // Archivo 1: 15, 20 (Limpio)
        // Archivo 2: 10, 99, 88, 30 -> ¡Infectado! (El virus está en el medio)
        // Archivo 3: 99, 88 -> ¡Infectado! (Sigue funcionando si es exacto)
        // Archivo 4: 7, 4, 1 (Limpio)
        int[] discoDuro = {0, 15, 20, 0, 10, 99, 88, 30, 0, 99, 88, 0, 7, 4, 1, 0, 0};
        
        // Firma del virus (Patrón limpio, usamos .length)
        int[] firmaVirus = {99, 88};

        int ini = 0;
        int fin = -1;
        int archivosInfectados = 0;
        
        while(ini < discoDuro.length){
            ini = buscarInicio(discoDuro, fin + 1);

            if(ini < discoDuro.length){
                fin = buscarFin(discoDuro, ini);

                if(contienePatron(discoDuro, ini, fin, firmaVirus)){
                    archivosInfectados++;
                }
            }
        }
        
        System.out.println("Se encontraron " + archivosInfectados + " archivos infectados.");
    }
    
    // EL NUEVO OBRERO: Búsqueda de Subcadena
    public static boolean contienePatron(int[] arrA, int ini, int fin, int[] arrP){
        // 1. NUEVO FILTRO DE TAMAÑO: 
        // Si el vagón es MÁS CHICO que el virus, es imposible que lo contenga.
        if (fin - ini + 1 < arrP.length) {
            return false;
        }

        // 2. EL DESLIZAMIENTO
        // Nuestra "ancla" k va a caminar por el vagón. 
        // ¿Hasta dónde puede caminar k? Hasta un punto donde el patrón todavía entre.
        int k = ini;
        int limiteParaAnclar = fin - arrP.length + 1; 

        while (k <= limiteParaAnclar) {
            
            // A partir de esta ancla 'k', comprobamos si está el patrón
            int i = k; // i arranca en el ancla
            int j = 0; // j arranca en 0 (el patrón)

            // Tu while clásico de comprobación en paralelo
            while (i <= fin && j < arrP.length && arrA[i] == arrP[j]) {
                i++;
                j++;
            }

            // Si j logró llegar al tamaño del patrón, ¡encontramos el virus completo!
            if (j == arrP.length) {
                return true;
            }

            // Si no lo encontramos, movemos el ancla un paso a la derecha y volvemos a intentar
            k++;
        }

        // Si el ancla recorrió todo el vagón y nunca retornó true, el virus no está
        return false;
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
