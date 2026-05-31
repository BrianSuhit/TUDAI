public class VentasDeSupermercadoOnlinePromoLimitada {
/*

*/
    public static final int SEPARADOR = 0;
    public static void main(String[] args){
        int[] P = {0, 9, 12, 18, 0, 4, 5, 7, 10, 15, 0, 8, 9, 12, 0, 9, 10, 19, 0, 0, 0, 0, 0, 0};
        int[] T = {8, 9}; // Arreglo de ofertas
        int R = 22; // Código del producto de regalo
        int C = 2; // Stock máximo

        procesarVenta(P, T, R, C);
    }

    public static void procesarVenta(int[] P, int[] T, int R, int C){
        int ini = 0, fin = -1;

        while(ini < P.length && C > 0){
            ini = buscarInicio(P, fin + 1);

            if(ini <  P.length){
                fin = buscarFin(P, ini);

               if(contieneOferta(P, ini, fin, T)){
                    insertarElemento(P, fin, R);
                    fin = fin + 1;
                    C--;
               }
            }
        }
    }

    public static void insertarElemento(int[] P, int fin, int regalo){
        corrimientoDerecha(P, fin + 1);
        P[fin + 1] = regalo;
    }

    public static void corrimientoDerecha(int[] arr, int pos){
        for(int i = arr.length - 1; i > pos; i--){
            arr[i] = arr[i - 1];
        }
    }

    public static boolean contieneOferta(int[] P, int ini, int fin, int[] T){
        boolean encontreOferta = false;
        int i = ini;
        int j = 0;

        while(i <= fin && j  < T.length && !encontreOferta){
            if(P[i] == T[j]){
                encontreOferta = true;
            }
            else if(P[i] < T[j]){
                i++;
            }
            else{
                j++;
            }
        }

        return encontreOferta;


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
}
