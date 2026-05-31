public class buscarSecuenciaMasRepetida {
    
    public static void main(String[] args) {
        
        int ini = 0;
        int fin = -1;

        int maxRepeticiones = 0;
        int mejorIni = 0;
        int mejorFin = 0;

        while (ini < arr.length) {
            ini = buscarInicio(arr, fin + 1);
            
            if (ini < arr.length) {
                fin = buscarFin(arr, ini);

                // 2. EL DIRECTOR DELEGA EN EL OBRERO
                // Le pasamos la "foto" del vagón que acabamos de aislar
                int cantidad = contarOcurrencias(arr, ini, fin);

                if(cantidad > maxRepeticiones){
                    maxRepeticiones = cantidad;
                    mejorIni = ini;
                    mejorFin = fin;
                }
            }
        }
        System.out.println("La más repetida empieza en " + mejorIni + " y termina en " + mejorFin);
    }

    public static int contarOcurrencias(int[] arr, int iniMuestra, int finMuestra) {
        int iniC = 0; 
        int finC = -1; 
        int contador = 0;

        while (iniC < arr.length) {
            iniC = buscarInicio(arr, finC + 1);
            
            if (iniC < arr.length) {
                finC = buscarFin(arr, iniC);


                if (sonIguales(arr, iniMuestra, finMuestra, arr, iniC, finC)) {
                    contador++;
                }
            }
        }
        return contador;
    }

    public static boolean sonIguales(int[] arrA, int ini, int fin, int[] arrB, int iniB, int finB){
        if(fin - ini + 1 != finB - iniB + 1){
            return false;
        }

        while(ini <= fin && arrA[ini] == arrB[iniB]){
            ini++;
            iniB++;
        }
        return ini > fin;
    }

    public static int buscarInicio(char[] arr, int pos){
        while(pos < arr.length && arr[pos] == 0){
            pos++;
        }
        return pos;
    }

    public static int buscarFin(char[] arr, int pos){
        while(pos < arr.length && arr[pos] != 0){
            pos++;
        }
        return pos - 1;
    }
}
