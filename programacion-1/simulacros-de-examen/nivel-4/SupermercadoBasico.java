public class SupermercadoBasico {
/*
SIMULACRO 8: "Ventas en supermercado BÁSICO" (Filtro cruzado)
El Dominio: Tenés los pedidos en el Arreglo P. Si un pedido contiene al menos un producto que figure en la lista de ofertas (Arreglo T), le insertás un producto de regalo (R) exactamente al final del pedido.
*/
    public static final int SEPARADOR = 0;
    
    public static void main(String[] args) {
        
        // Pedidos (P). Separados por 0. 
        // Pedido 1: 12, 9, 18. (El 9 está en oferta, lleva regalo)
        // Pedido 2: 15, 5, 4, 7, 10. (Ninguno en oferta, no lleva regalo)
        int[] P = {0, 12, 9, 18, 0, 15, 5, 4, 7, 10, 0, 8, 9, 12, 0, 0, 0, 0, 0, 0, 0, 0};
        
        // Arreglo de ofertas (T).
        int[] T = {8, 9};
        
        // Producto de regalo (R)
        int R = 22;
        
        System.out.println("Pedidos originales:");
        mostrarArreglo(P);
        
        // --- EL DIRECTOR ---
        int ini = 0;
        int fin = -1;

        while(ini < P.length){
            ini = buscarInicio(P, fin + 1);

            if(ini < P.length){
                fin = buscarFin(P, ini);
                
                if(tieneProductoEnOferta(P, ini, fin, T)){
                    corrimientoDerecha(P, fin + 1);
                    P[fin + 1] = R;
                    fin = fin + 1;
                }
            }
        }
        
        System.out.println("\nPedidos con regalos:");
        mostrarArreglo(P);
    }

    public static boolean tieneProductoEnOferta(int[] P, int ini, int fin, int[] T) {
        int i = ini;

        while(i <= fin){
            int j = 0;
            while(j < T.length){
                if(P[i] == T[j]){
                    return true;
                }
                j++;
            }
            i++;
        }
        return false;
    }


    public static int buscarInicio(int[] arr, int pos) {
        while(pos  < arr.length && arr[pos] == SEPARADOR){
            pos++;
        }
        return pos;
    }

    public static int buscarFin(int[] arr, int pos) {
        while(pos < arr.length && arr[pos] != SEPARADOR){
            pos++;
        }
        return pos - 1;
    }

    public static void corrimientoDerecha(int[] arr, int pos) {
        for(int i = arr.length - 1; i > pos; i--){
            arr[i] = arr[i - 1];
        }
    }

    public static void mostrarArreglo(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " | ");
        }
    }
}
