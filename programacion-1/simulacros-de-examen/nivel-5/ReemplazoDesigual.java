public class ReemplazoDesigual {
    
    public static final int SEPARADOR = 0;

    public static void main(String[] args) {
        
        // Ticket 1: 15, 8, 99, 4 -> Tamaño 4. Tiene el 99. Se borra y se inserta {10, 20}.
        // Ticket 2: 3, 5 -> Tamaño 2. NO tiene el 99. Queda igual.
        // Ticket 3: 99 -> Tamaño 1. Tiene el 99. Se borra y se inserta {10, 20}.
        int[] P = {0, 15, 8, 99, 4, 0, 3, 5, 0, 99, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        
        // El pedido de cortesía (Limpio, sin ceros)
        int[] R = {10, 20}; 
        int productoMalo = 99;

        System.out.println("Tickets Originales:");
        mostrarArreglo(P);

        // --- TU LÓGICA DEL DIRECTOR ACÁ ---
        int ini = 0;
        int fin = -1;

        while(ini < P.length){
            ini = buscarInicio(P, fin + 1);

            if(ini < P.length){
                fin = buscarFin(P, ini);

                int tamaño = fin - ini + 1;

                if(tieneProducto(P, ini, fin, productoMalo)){

                    for(int i = 0; i < tamaño; i++){
                        corrimientoIzquierda(P, ini);
                    }
                    
                    for(int i = 0; i < R.length; i++){
                        corrimientoDerecha(P, ini + i);
                        P[ini + i] = R[i];
                    }
                    fin = fin - tamaño + R.length;
                }
            }
        }

        System.out.println("\nTickets Modificados:");
        mostrarArreglo(P);
    }
    
    // --- TUS MÉTODOS OBREROS ACÁ ---
    public static boolean tieneProducto(int[] arr, int ini, int fin, int valor){
        int i = ini;
        boolean loEncontre = false;

        while(i <= fin && !loEncontre){
            if(arr[i] == valor){
                loEncontre = true;
            }
            i++;
        }
        return loEncontre;
    }

    public static void corrimientoIzquierda(int[] arr, int pos){
        for(int i = pos; i < arr.length - 1; i++){
            arr[i] = arr[i + 1]; 
        }
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
    }

}
