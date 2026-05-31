public class PrimerRegalo {
/*
SIMULACRO 1 (Nivel 4): "El primer regalo" (Agrandar una secuencia)
El Dominio: Un sistema de un supermercado almacena los pedidos de los clientes en un arreglo. Cada pedido (vagón) es una secuencia de códigos de producto (enteros positivos). Los pedidos están separados por uno o más 0. La gerencia lanzó una promoción: hay que agregar un producto de regalo al primer pedido que aparezca en el sistema.
La Consigna: Encontrar el primer pedido válido en el arreglo e insertarle el código del producto de regalo exactamente al final de ese pedido (es decir, el regalo debe ser el último ítem de ese pedido, antes del cero delimitador).
*/    

    public static final int SEPARADOR = 0;
    public static void main(String[] args) {
        
        // Arreglo de pedidos. Separados por 0.
        int[] pedidos = {0, 12, 8, 45, 0, 0, 7, 14, 0, 3, 0, 0, 0, 0, 0};
        int productoRegalo = 99;
        
        System.out.println("Pedidos iniciales:");
        mostrarArreglo(pedidos);
        
        // --- EL DIRECTOR ---
        // (Tu razonamiento lógico acá, siguiendo tu fórmula base)
        int ini = 0;
        int fin = -1;

        boolean primerPedido = false;

        while(ini < pedidos.length && !primerPedido){
            ini = buscarInicio(pedidos, fin + 1);

            if(ini < pedidos.length){
                fin = buscarFin(pedidos, ini);

                primerPedido = true;
                corrimientoDerecha(pedidos, fin + 1);
                pedidos[fin + 1] = productoRegalo;
                fin = fin + 1;
            }
        }
        
        System.out.println("\nPedidos despues de la promocion:");
        mostrarArreglo(pedidos);
    }

    public static void corrimientoDerecha(int[] arr, int pos){
        for(int i = arr.length - 1; i > pos; i--){
            arr[i] = arr[i - 1];
        }
    }
    
    public static void mostrarArreglo(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " | ");
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
        return pos -1;
    }
}
