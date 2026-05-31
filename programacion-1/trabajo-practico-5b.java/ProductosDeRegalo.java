public class ProductosDeRegalo {
    
    public static final int SEPARADOR = 0;

    public static void main(String[] args) {
        
        int[] arregloP = {0, 0, 9, 12, 18, 0, 1, 5, 43, 73, 88, 0, 8, 9, 52, 0, 1, 10, 90, 0, 0, 0, 0, 0, 0, 0, 0, 0};

        int[] R = {44, 6};

        int ini = 0;
        int fin = -1;

        while(ini < arregloP.length){
            ini = buscarInicio(arregloP, fin +1);

            if(ini < arregloP.length){
                fin = buscarFin(arregloP, ini);

                insertarRegalos(arregloP, ini, fin, R);
                fin = fin + R.length;
            }
        }
        mostrarArreglo(arregloP);
    }

    public static void insertarRegalos(int[] arregloP, int ini, int fin, int[] R){

        for(int i = 0; i < R.length; i++){
            int regaloActual = R[i];

                int pos = ini;
                boolean posEncontrada = false;

                while(pos <= fin && !posEncontrada){
                if(arregloP[pos] > regaloActual){
                    posEncontrada = true;
                }
                else{
                    pos++;
                }
            }

            corrimientoDerecha(arregloP, pos);
            arregloP[pos] = regaloActual;
            fin = fin + 1; 
        }
    }

    public static void corrimientoDerecha(int[] arreglo, int pos){
        for(int i = arreglo.length - 2; i >= pos; i--){
            arreglo[i + 1] = arreglo[i];
        }
    }

    public static int buscarInicio(int[] arreglo, int pos){
        while(pos < arreglo.length && arreglo[pos] == SEPARADOR){
            pos++;
        }
        return pos;
    }

    public static int buscarFin(int[] arreglo, int pos){
        while(pos < arreglo.length && arreglo[pos] != SEPARADOR){
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
