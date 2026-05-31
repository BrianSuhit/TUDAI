public class TorneoEsport {

    public static final int SEPARADOR = 0;
    public static void main(String[] args){
        int[] A = {0, 150, 120, 90, 40, 0, 300, 250, 200, 0, 80, 70, 60, 45, 0, 400, 30, 0, 0};

        int B = 85;
        int C = 2;

        procesarPartidas(A, B, C);

        mostrarArreglo(A);
    }

    public static void procesarPartidas(int[] arr, int B, int C){
        int ini = 0, fin = -1, peorPuntaje = 50;

        while(ini < arr.length  && C > 0){
            ini = buscarInicio(arr, fin + 1);

            if(ini < arr.length){
                fin = buscarFin(arr, ini);

                if(arr[fin] < peorPuntaje){

                    int posInsertar = buscarPosicion(arr, ini, fin, B);

                    insertarPuntaje(arr, posInsertar, B);
                    fin = fin + 1;
                    C--;
                }
            }
        }
    }

    public static void insertarPuntaje(int[] arr, int pos, int valor){
        corrimientoDerecha(arr, pos);
        arr[pos] = valor;
    }

    public static int buscarPosicion(int[] arr, int ini, int fin, int valor){
        int i = ini;
        boolean posEncontrada = false;

        while(i <= fin && !posEncontrada){
            if(arr[i] < valor){
                posEncontrada = true;
            }
            else{
                i++;
            }
        }
        return i;
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
