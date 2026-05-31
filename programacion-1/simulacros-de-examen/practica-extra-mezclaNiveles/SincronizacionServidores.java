public class SincronizacionServidores {
    
    public static final int SEPARADOR = 0;

    public static void main(String[] args) {

        // A tiene 3 secuencias: (10, 20), (30, 40) y (50, 60).
        int[] A = {0, 10, 20, 0, 30, 40, 0, 50, 60, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        
        // B tiene 3 secuencias: (99, 99), (10, 20) y (77, 88).
        // NOTA: (10, 20) existe en ambos. En A debe desaparecer. En B debe quedar (-10, -20).
        int[] B = {0, 99, 99, 0, 10, 20, 0, 77, 88, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};

        System.out.println("Servidores ANTES de la sincronizacion:");
        System.out.print("A: ");
        mostrarArreglo(A);
        System.out.print("B: ");
        mostrarArreglo(B);

        int ini = 0;
        int fin = -1;

        while(ini < A.length){
            ini = buscarInicio(A, fin + 1);

            if(ini < A.length){
                fin = buscarFin(A, ini);

                int posB = buscarSecuenciaEnB(A, ini, fin, B);

                if (posB != -1) {
        
                    int tamaño = fin - ini + 1;
                    marcarProcesado(B, posB, tamaño);

                    for (int i = 0; i < tamaño; i++) {
                        corrimientoIzquierda(A, ini);
                    }
                    fin = fin - tamaño;
                }
            }
        }
        
        System.out.println("\nServidores DESPUES de la sincronizacion:");
        System.out.print("A: ");
        mostrarArreglo(A);
        System.out.print("B: ");
        mostrarArreglo(B);
    }

    public static void marcarProcesado(int[] arrB, int iniB, int tamaño) {
        for (int i = 0; i < tamaño; i++) {
            arrB[iniB + i] = arrB[iniB + i] * -1; 
        }
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

    public static int buscarSecuenciaEnB(int[] arrA, int iniA, int finA, int[] arrB){
        int iniB = 0;
        int finB = -1;
        boolean loEncontre = false;

        while(iniB < arrB.length && !loEncontre){ 
            iniB = buscarInicio(arrB, finB + 1);

            if(iniB < arrB.length){
                finB = buscarFin(arrB, iniB);

                if(cumplePatron(arrA, iniA, finA, arrB, iniB, finB)){
                    loEncontre = true;
                }
            }
        }
        
        if (loEncontre) {
            return iniB;
        } else {
            return -1;
        }
    }

    public static void corrimientoIzquierda(int[] arr, int pos){
        for(int i = pos; i < arr.length - 1; i++){
            arr[i] = arr[i + 1];
        }
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
    // -------------------------------
    
    public static void mostrarArreglo(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + "|");
        }
        System.out.println();
    }
}
