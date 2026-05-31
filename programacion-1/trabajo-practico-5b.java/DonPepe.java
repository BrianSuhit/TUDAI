public class DonPepe {
    
    public static final int SEPARADOR = 0;

    public static void main(String[] args) {
        int[] arregloA = {/* Pedidos precargados */};
        int[] arregloCarta = {/* Precios precargados */};
        
        // Usamos double porque el 15% genera decimales
        double[] arregloPropina = new double[8]; // Suponiendo M = 5 mozos

        int ini = 0;
        int fin = -1;

        // EL MOTOR
        while (ini < arregloA.length) {
            ini = buscarInicio(arregloA, fin + 1);
            
            if (ini < arregloA.length) {
                fin = buscarFin(arregloA, ini);
                
                // Le pasamos los 3 arreglos y las coordenadas. ¡Es void!
                procesarPropina(arregloA, arregloCarta, arregloPropina, ini, fin);
            }
        }
    }

    // LA ACCIÓN (El procesamiento del vagón)
    public static void procesarPropina(int[] arrPedidos, int[] arrCarta, double[] arrPropina, int ini, int fin) {
        
        // 1. El primer elemento de la secuencia es el ID del mozo
        int mozo = arrPedidos[ini]; 
        
        // 2. Recorremos los ítems. Empezamos un lugar a la derecha del mozo
        int pos = ini + 1; 
        int totalVentaPedido = 0;

        // CORRECCIÓN 2: Recorrer toda la serie de tuplas
        while (pos <= fin) {
            int item = arrPedidos[pos];
            int cantidad = arrPedidos[pos + 1]; // El que le sigue es la cantidad

            // CORRECCIÓN 3: Trampa de la carta (item - 1)
            int precio = arrCarta[item - 1]; 

            // Sumamos el costo de esta tupla al total del pedido
            totalVentaPedido += (precio * cantidad);

            // ¡CLAVE! Avanzamos de a 2 porque ya leímos la tupla (item y cantidad)
            pos = pos + 2; 
        }

        // CORRECCIÓN 4: Calcular el 15% y ACUMULARLO en el arreglo del mozo
        // (Asumimos que el número de mozo sirve directamente como índice)
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
