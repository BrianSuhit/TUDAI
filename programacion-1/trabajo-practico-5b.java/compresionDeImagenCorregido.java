public class compresionDeImagenCorregido {
    
    public static final int SEPARADOR = 0;
    public static final int X = 3;

    public static void main(String[] args) {
        
        int ini = 0;
        int fin = -1;

        int[] arreglo = {0, 67, 67, 67, 67, 67, 67, 67, 67, 0, 14, 0, 33, 33, 33, 33, 0, 5, 98, 0};

        while(ini < arreglo.length){
            ini = buscarInicio(arreglo, fin + 1);

            if(ini < arreglo.length){
                fin = buscarFin(arreglo, ini);

                int tamanio = fin - ini + 1;

                if(tamanio > X && sonTodosIguales(arreglo, ini, fin)){

                    for(int i = 0; i < tamanio - 2; i++){
                        corrimientoIzquierda(arreglo, ini);
                    }
                    arreglo[ini] = -tamanio;
                    fin = ini + 1; 
                }
            }
        }
    }

    // Tu método intacto
    public static void corrimientoIzquierda(int[] arr, int posElim){
        for(int pos = posElim; pos < arr.length - 1; pos++){
            arr[pos] = arr[pos + 1];
        }
    }

    public static boolean sonTodosIguales(int[] arr, int ini, int fin){
        while(ini < fin && arr[ini] == arr[ini + 1]){
            ini++;
        }
        return ini == fin; 
    }

    // Tus métodos intactos
    public static int buscarInicio(int[] arr, int pos) {
        while (pos < arr.length && arr[pos] == SEPARADOR) {
            pos++;
        }
        return pos;
    }

    public static int buscarFin(int[] arr, int ini){
        while(ini < arr.length && arr[ini] != SEPARADOR){
            ini++;
        }
        return ini - 1;
    }
}
