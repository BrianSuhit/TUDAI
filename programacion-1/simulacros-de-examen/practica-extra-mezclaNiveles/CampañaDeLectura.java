public class CampañaDeLectura {
    
    public static final int SEPARADOR = 0;
    public static void main(String[] args){
        int[] A = {0, 10, 25, 0, 15, 0, 5, 30, 40, 0, 12, 18, 0, 8, 22, 0};

        int R = 20;

        int C = 2;

        procesarCampaña(A, R, C);
        mostrarArreglo(A);
    }

    public static void procesarCampaña(int[] arr, int R, int C){
        int ini = 0, fin = -1, cantLibros = 2;

        while(ini < arr.length  && C > 0){
            ini = buscarInicio(arr, fin+1);

            if(ini < arr.length){
                fin = buscarFin(arr, ini);

                int tamaño = fin - ini + 1;

                if(tamaño == cantLibros){

                    int posInsertar = buscarPosicion(arr, ini, fin, R);
                    insertarRegalo(arr, posInsertar, R);
                    fin = fin + 1;
                    C--;
                }
            }
        }
        System.out.println("sobraron: " + C + " libros.");
    }

    public static int buscarPosicion(int[] arr, int ini, int fin, int valorAInsertar){
        int i = ini;
        boolean posEncontrada = false;

        while(i <= fin && !posEncontrada){
            if(arr[i] > valorAInsertar){
                posEncontrada = true;
            }
            else{
                i++;
            }
        }
        return i;
    }

    public static void insertarRegalo(int[] arr, int pos, int regalo){
        corrimientoDerecha(arr, pos);
        arr[pos] = regalo;
    }

    public static void corrimientoDerecha(int[] arr, int pos){
        for(int i = arr.length - 1; i > pos; i--){
            arr[i] = arr[i - 1];
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

    public static void mostrarArreglo(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + "|");
        }
        System.out.println();
    }
}
