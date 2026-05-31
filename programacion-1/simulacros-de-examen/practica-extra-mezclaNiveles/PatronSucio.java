public class PatronSucio {
    
    public static final int SEPARADOR = 0;

    public static void main(String[] args) {
        
        int[] logs = {0, 0, 15, 20, 0, 8, 9, 7, 0, 15, 20, 0};
        int[] firmaFalla = {0, 8, 9, 7, 0, 0};

        procesarSecuencia(logs, firmaFalla);
    }

    public static void procesarSecuencia(int[] arrA, int[] arrP){

        int ini = 0;
        int fin = -1;

        int iniP = buscarInicio(arrP, 0);
        int finP = buscarFin(arrP, iniP);

        while(ini < arrA.length){
            ini = buscarInicio(arrA, fin + 1);

            if(ini < arrA.length){
                fin = buscarFin(arrA, ini);

                if(esPatron(arrA, ini, fin, arrP, iniP, finP)){
                    System.out.println("encontre un patron entre: " + ini + " y " + fin);
                }
            }
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

    public static boolean esPatron(int[] arrA, int iniA, int finA, int[] arrP, int iniP, int finP){
        if(finA - iniA + 1 != finP - iniP + 1){
            return false;
        }

        while(iniA <= finA && arrA[iniA] == arrP[iniP]){
            iniA++;
            iniP++;
        }
        return iniA > finA;
    }
}
