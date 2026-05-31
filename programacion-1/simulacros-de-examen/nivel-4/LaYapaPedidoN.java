public class LaYapaPedidoN {
/*
SIMULACRO 3 (Nivel 4): "La yapa del pedido N" (Búsqueda por ubicación)
El Dominio: El sistema de una panadería guarda los pedidos del día en un arreglo de secuencias (cada pedido es un vagón de códigos de productos, separados por ceros). Por el aniversario del local, el gerente decide que al tercer cliente del día (es decir, el tercer pedido que aparezca en el arreglo) se le va a regalar una "docena extra" (código de producto 888).
La Consigna: Recorrer el arreglo, identificar exactamente cuál es la tercera secuencia, e insertarle el código promocional exactamente al final de sus productos.
*/
    public static final int SEPARADOR = 0;
    public static final int CLIENTE_PREMIADO = 3;
    
    public static void main(String[] args) {
        
        // Arreglo de pedidos. Separados por 0.
        // 1er pedido: 10, 12. 2do: 5. 3er pedido (EL PREMIADO): 8, 9, 14. 4to: 11.
        int[] pedidos = {0, 10, 12, 0, 0, 5, 0, 8, 9, 14, 0, 0, 11, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        int docenaExtra = 888;
        
        System.out.println("Pedidos iniciales:");
        mostrarArreglo(pedidos);
        
        // --- EL DIRECTOR ---
        int ini = 0;
        int fin = -1;

        boolean seEncontroCliente = false;
        int contador = 0;

        while(ini < pedidos.length && !seEncontroCliente){
            ini = buscarInicio(pedidos, fin + 1);

            if(ini < pedidos.length){
                fin = buscarFin(pedidos, ini);
                contador++;

                if(contador >= CLIENTE_PREMIADO){
                    seEncontroCliente = true;
                    corrimientoDerecha(pedidos, fin + 1);
                    pedidos[fin + 1] = docenaExtra;
                    fin = fin + 1;
                }
            }
        }
        
        System.out.println("\nPedidos despues de la promocion:");
        mostrarArreglo(pedidos);
    }

    public static int buscarInicio(int[] arr, int pos) {
            while(pos < arr.length && arr[pos] == SEPARADOR){
            pos++;
        }
        return pos;
    }

    public static int buscarFin(int[] arr, int pos) {
        while(pos < arr.length && arr[pos] != SEPARADOR){
            pos++;
        }
        return pos -1;
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
