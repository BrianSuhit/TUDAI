public class VentasEnSupermercadoOnline {
    
    public static final int SEPARADOR = 0;

    public static void main(String[] args) {
        
        int[] arregloP = {0, 0, 12, 9, 18, 0, 15, 5, 4, 7, 10, 0, 8, 9, 12, 0, 19, 10, 9, 0, 0, 0, 0, 0, 0};

        int[] arregloT = {8, 9};

        int R = 22;

        int C = 2;

        int ini = 0;
        int fin = -1;
        int contador = 0;

        while(ini < arregloP.length){
            ini = buscarInicio(arregloP, fin + 1);

            if(ini < arregloP.length){
                fin = buscarFin(arregloP, ini);

                if(estanTodosElementos(arregloP, arregloT, ini, fin) && contador < C){
                    corrimientoDerecha(arregloP, fin + 1);
                    arregloP[fin + 1] = R;
                    fin = fin + 1;
                    contador++;
                }
            }
        }
        mostrarArreglo(arregloP);
        System.out.println("Productos R sin agregar: " + (C - contador));

    }

    public static void corrimientoDerecha(int[] arr, int pos){
        for(int i = arr.length -2; i >= pos; i--){
            arr[i + 1] = arr[i];
        }
    }

    public static boolean estanTodosElementos(int[] arregloP, int[] arregloT, int ini, int fin){
        while(ini <= fin && !existeElementoEnArr(arregloT, arregloP[ini])){
            ini++;
        }
        return ini <= fin;
    }

    public static boolean existeElementoEnArr(int[] arrA, int valor){
        int pos = 0;
        while(pos < arrA.length && arrA[pos] != valor){
            pos++;
        }
        return pos < arrA.length;
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
        for (int pos = 0; pos < arr.length; pos++)
            System.out.print(" | " + arr[pos]);
        System.out.println();
    }
}
