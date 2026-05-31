public class DonPepe {
    
    public static final int SEPARADOR = 0;

    public static void main(String[] args) {
        int[] arregloA = {/* Pedidos precargados */};
        int[] arregloCarta = {/* Precios precargados */};
        
        double[] arregloPropina = new double[8];

        int ini = 0;
        int fin = -1;

        // EL MOTOR
        while (ini < arregloA.length) {
            ini = buscarInicio(arregloA, fin + 1);
            
            if (ini < arregloA.length) {
                fin = buscarFin(arregloA, ini);
                
                procesarPropina(arregloA, arregloCarta, arregloPropina, ini, fin);
            }
        }
    }

    // LA ACCIÓN (El procesamiento del vagón)
    public static void procesarPropina(int[] arrPedidos, int[] arrCarta, double[] arrPropina, int ini, int fin) {
        
        int mozo = arrPedidos[ini]; 
        
        int pos = ini + 1; 
        int totalVentaPedido = 0;

        while (pos <= fin) {
            int item = arrPedidos[pos];
            int cantidad = arrPedidos[pos + 1]; 

            int precio = arrCarta[item - 1]; 

            totalVentaPedido += (precio * cantidad);

            pos = pos + 2; 
        }
        double propina = totalVentaPedido * 0.15;
        arrPropina[mozo] += propina; 
    }
    
    public static int buscarInicio(int[] arr, int pos) {
        while (pos < arr.length && arr[pos] == SEPARADOR) {
            pos++;
        }
        return pos;
    }

    public static int buscarFin(int[] arr, int ini) {
        while (ini < arr.length && arr[ini] != SEPARADOR) {
            ini++;
        }
        return ini - 1;
    }
}
