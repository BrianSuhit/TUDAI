public class InspeccionLotesPremium {
    
    // ¡OJO ACÁ! El separador ya no es 0. 
    public static final int SEPARADOR = -1;
    
    public static final int TAMANIO_MINIMO = 4;
    public static final int MINIMO_PARES = 2; // Tiene que tener MÁS de 2 pares (> 2)

    public static void main(String[] args) {
        
        // Lote 1: 10, 15, 20 (Tamaño 3). -> Falla por tamaño.
        // Lote 2: 12, 14, 16, 18 (Tamaño 4, Pares: 4). -> ¡LOTE PREMIUM! (Cumple tamaño y tiene > 2 pares).
        // Lote 3: 11, 13, 22, 24, 25 (Tamaño 5, Pares: 2). -> Falla (los pares no son MAYORES a 2).
        // Lote 4: 8, 33, 44, 55, 66 (Tamaño 5, Pares: 3). -> ¡LOTE PREMIUM!
        // Resultado esperado final: "Se detectaron 2 lotes premium"
        
        int[] arrLotes = {-1, 10, 15, 20, -1, 12, 14, 16, 18, -1, 11, 13, 22, 24, 25, -1, 8, 33, 44, 55, 66, -1, -1};

        int ini = 0;
        int fin = -1;
        int contadorPremium = 0;

        while(ini < arrLotes.length){
            ini = buscarInicio(arrLotes, fin + 1);
            if(ini < arrLotes.length){
                fin = buscarFin(arrLotes, ini);

                int tamaño = fin - ini + 1;

                if(tamaño >= TAMANIO_MINIMO && tieneMayoriaPares(arrLotes, ini, fin)){
                    contadorPremium++;
                }
            }
        }
        System.out.println("Se detectaron " + contadorPremium + " lotes premium");    
    }
    
    public static boolean tieneMayoriaPares(int[] arr, int ini, int fin){
    int i = ini;
    int contadorPares = 0;

    // Condición 1: Solo me preocupo por no caerme del vagón
    while(i <= fin){ 
        
        // Condición 2: ¿Es par?
        if(arr[i] % 2 == 0){
            contadorPares++; // Si es par, lo cuento
            
            // LA OPTIMIZACIÓN (El freno de mano)
            // Apenas lo cuento, pregunto si ya superé el mínimo. 
            // Si MINIMO_PARES es 2, apenas el contador llegue a 3, esto da 'true'
            if(contadorPares > MINIMO_PARES){
                return true; // Corto la ejecución del método acá mismo y le aviso al main
            }
        }
        
        i++; // Doy el paso al siguiente casillero
    }

    // Si el while terminó de dar todas las vueltas y llegó acá abajo, 
    // significa que NUNCA logró entrar al "return true" de arriba. 
    // O sea, no le alcanzaron los pares.
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
        return pos -1;
    }
}
