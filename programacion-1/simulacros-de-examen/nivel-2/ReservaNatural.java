public class ReservaNatural {
    
    public static final char SEPARADOR = ' ';

    public static void main(String[] args) {
        
        // Patentes que INGRESO la cámara
        char[] arrI = {' ', 'A', 'A', '1', '2', '3', 'Z', 'Z', ' ', 'F', 'O', 'R', '0', '0', '1', ' ', ' '};
        
        // Patentes que EGRESO la cámara
        char[] arrE = {' ', 'P', 'R', 'G', '0', '1', '0', ' ', 'A', 'A', '1', '2', '3', 'Z', 'Z', ' ', ' '};

        char[] arrNoE = new char[arrI.length]; 
        char[] arrNoI = new char[arrE.length];

        int posNoE = 0;
        int ini = 0;
        int fin = -1;

        // MOTOR 1: Recorre Ingresos buscando cruzado en Egresos
        while(ini < arrI.length){
            ini = buscarInicio(arrI, fin + 1);

            if(ini < arrI.length){
                fin = buscarFin(arrI, ini);

                // Si la patente de Ingreso NO existe en el arreglo de Egresos...
                if(!existeEnArreglo(arrI, ini, fin, arrE)){
                    posNoE = copiarSecuencia(arrI, ini, fin, arrNoE, posNoE);
                }
            }
        }

        int posNoI = 0;
        // Reseteo los iteradores para el segundo motor
        ini = 0; 
        fin = -1;

        // MOTOR 2: Recorre Egresos buscando cruzado en Ingresos
        while(ini < arrE.length){
            ini = buscarInicio(arrE, fin + 1);

            if(ini < arrE.length){
                fin = buscarFin(arrE, ini);

                // Si la patente de Egreso NO existe en el arreglo de Ingresos...
                if(!existeEnArreglo(arrE, ini, fin, arrI)){
                    posNoI = copiarSecuencia(arrE, ini, fin, arrNoI, posNoI);
                }
            }
        }

        // --- IMPRESIONES DE COMPROBACIÓN ---
        System.out.print("Entraron pero NO salieron (arrNoE): ");
        for (int i = 0; i < posNoE; i++) {
            System.out.print(arrNoE[i]);
        }
        System.out.println();

        System.out.print("Salieron pero NO entraron (arrNoI): ");
        for (int i = 0; i < posNoI; i++) {
            System.out.print(arrNoI[i]);
        }

    }

        public static boolean cumplePatron(char[] arrA, int iniA, int finA, char[] arrB, int iniB, int finB){
        if(finA - iniA + 1 != finB - iniB + 1){
            return false;
        }

        while(iniA <= finA && arrA[iniA] == arrB[iniB]){
            iniA++;
            iniB++;
        }
        return iniA > finA;
    }

    public static boolean existeEnArreglo(char[] arrA, int iniA, int finA, char[] arrB){
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

    public static int copiarSecuencia(char[] origen, int ini, int fin, char[] destino, int posLibre) {
        for(int i = ini; i <= fin; i++){
            destino[posLibre] = origen[i];
            posLibre++;
        }
        
        destino[posLibre] = SEPARADOR;
        posLibre++;
        
        return posLibre;
    }
    
    public static int buscarInicio(char[] arr, int pos){
        while(pos < arr.length && arr[pos] == SEPARADOR){
            pos++;
        }
        return pos;
    }

    public static int buscarFin(char[] arr, int pos){
        while(pos < arr.length && arr[pos] != SEPARADOR){
            pos++;
        }
        return pos - 1;
    }
}
