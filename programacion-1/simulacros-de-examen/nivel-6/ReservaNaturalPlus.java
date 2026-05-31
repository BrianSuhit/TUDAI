public class ReservaNaturalPlus {

    public static final char SEPARADOR = ' ';
    
    public static void main(String[] args) {
        // En este ejemplo, entraron "AA123" y "FOR001". 
        // Solo salió "FOR001". El infractor es "AA123".
        char[] arrI = {' ', 'A', 'A', '1', '2', '3', 'Z', 'Z', ' ', 'F', 'O', 'R', '0', '0', '1', ' ', ' '};

        char[] arrE = {' ', 'P', 'R', 'G', '0', '1', '0', ' ', 'A', 'A', '1', '2', '3', 'Z', 'Z', ' ', ' '};
        
        
        char[] arrNoSalieron = procesarSecuencia(arrI, arrE);
        char[] arrNoIngresaron = procesarSecuencia(arrE, arrI);

        System.out.println("autos que entraron pero no salieron:");
        mostrarArreglo(arrNoSalieron);

        System.out.println("autos que salieron y nunca entraron:");
        mostrarArreglo(arrNoIngresaron);
    }

    public static char[] procesarSecuencia(char[] arrA, char[] arrB){
        int ini = 0, fin = -1, indiceResultado = 0;

        char[] resultado = new char[arrA.length];

        while(ini < arrA.length){
            ini = buscarInicio(arrA, fin + 1);

            if(ini < arrA.length){
                fin = buscarFin(arrA, ini);

                if(!apareceDom(arrA, ini, fin, arrB)){
                    indiceResultado = copiarDominio(arrA, ini, fin, resultado, indiceResultado);
                }
            }
        }
        return resultado;
    }

    public static int copiarDominio(char[] arrA, int iniA, int finA, char[] arrB, int indexNuevo){
        for(int i = iniA; i <= finA; i++){
            arrB[indexNuevo] = arrA[i];
            indexNuevo++;
        }
        arrB[indexNuevo] = SEPARADOR;
        indexNuevo++;

        return indexNuevo;
    }

    public static boolean apareceDom(char[] arrA, int iniA, int finA, char[] arrB){
        int iniB = 0;
        int finB = -1;

        boolean sonSecuenciasIugles = false;

        while(iniB < arrB.length && !sonSecuenciasIugles){
            iniB = buscarInicio(arrB, finB + 1);

            if(iniB < arrB.length){
                finB = buscarFin(arrB, iniB);

                if(esDominio
                    (arrA, iniA, finA, arrB, iniB, finB)){
                    sonSecuenciasIugles = true;
                }
            }
        }
        return sonSecuenciasIugles;
    }

    public static boolean esDominio(char[] arrA, int iniA, int finA, char[] arrB, int iniB, int finB){
        if(finA - iniA + 1 != finB - iniB + 1){
            return false;
        }

        while(iniA <= finA && arrA[iniA] == arrB[iniB]){
            iniA++;
            iniB++;
        }
        return iniA > finA;
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

    public static void mostrarArreglo(char[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + "|");
        }
        System.out.println();
    }
}
