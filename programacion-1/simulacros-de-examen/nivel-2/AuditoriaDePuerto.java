public class AuditoriaDePuerto {
    
    public static final int SEPARADOR = 0;

    public static void main(String[] args) {
        
        int[] arrIngresos = {0, 0, 12, 34, 0, 56, 78, 0, 91, 23, 0, 44, 55, 0, 0};
        int[] arrEgresos  = {0, 91, 23, 0, 0, 12, 34, 0, 0, 0, 0, 0, 0, 0, 0};
        
        // 1. NUESTRO TERCER ARREGLO (Java lo inicializa automáticamente lleno de ceros)
        int[] arrAuditoria = new int[arrIngresos.length];

        int ini = 0;
        int fin = -1;
        
        // 2. NUESTRO ÍNDICE INDEPENDIENTE PARA ESCRIBIR
        int posLibre = 0; 

        while(ini < arrIngresos.length){
            ini = buscarInicio(arrIngresos, fin+1);

            if(ini < arrIngresos.length){
                fin = buscarFin(arrIngresos, ini);

                // Si NO salió, lo copiamos al arreglo de auditoría
                if (!existeEnEgresos(arrIngresos, ini, fin, arrEgresos)) {
                    
                    // LLAMO AL NUEVO OBRERO Y ACTUALIZO MI POSICIÓN LIBRE
                    posLibre = copiarSecuencia(arrIngresos, ini, fin, arrAuditoria, posLibre);
                    
                }
            }
        }

        // Mostrar el arreglo de auditoría para comprobar
        System.out.println("Arreglo de contenedores faltantes:");
        for (int i = 0; i < posLibre; i++) {
            System.out.print(arrAuditoria[i] + " | ");
        }
    }

    // 3. EL NUEVO OBRERO: Copiador de Secuencias
    public static int copiarSecuencia(int[] origen, int ini, int fin, int[] destino, int posLibre) {
        
        // ACÁ ADENTRO ARMÁS TU LÓGICA DE COPIA:
        // Hacés un for o while que arranque en 'ini' y vaya hasta 'fin'
        // Adentro asignás: destino[posLibre] = origen[i];
        // Y avanzás tu iterador 'posLibre' (y también la 'i').
        for(int i = ini; i <= fin; i++){
            destino[posLibre] = origen[i];
            posLibre++;
        }
        
        // TIP MENTAL FINAL:
        // Como querés que las secuencias en el arreglo destino estén separadas por ceros,
        // cuando termine tu ciclo, avanzá 'posLibre' un paso más (posLibre++) para saltear
        // un cero que ya viene por defecto en el arreglo nuevo.
        destino[posLibre] = SEPARADOR;
        posLibre++;
        
        // Retornás la posición libre actualizada para que el próximo contenedor 
        // no pise al que acabamos de guardar.
        return posLibre;
    }

    public static boolean cumplePatron(int[] arrA, int iniA, int finA, int[] arrB, int iniB, int finB){
        if(finA - iniA + 1 != finB - iniB + 1){
            return false;
        }

        while(iniA <= finA && arrA[iniA] == arrB[iniB]){
            iniA++;
            iniB++;
        }

        return iniA > finA;
    }

    public static boolean existeEnEgresos(int[] arrA, int iniA, int finA, int[] arrB){
        int iniB = 0;
        int finB = -1;

        while(iniB < arrB.length){
            iniB = buscarInicio(arrB, finB + 1);

            if(iniB < arrB.length){
                finB = buscarFin(arrB, iniB);

                if(cumplePatron(arrA, iniA, finA, arrB, iniB, finB)){
                    return true;
                }
            }
        }
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

