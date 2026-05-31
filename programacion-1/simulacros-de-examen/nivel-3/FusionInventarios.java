public class FusionInventarios {
/*
📝 SIMULACRO 7 (Nivel 3): "Fusión de Inventarios" (Lectura Cruzada + Inserción)
Este ejercicio es la contraparte exacta del que acabás de hacer. En lugar de cruzar para eliminar, vamos a cruzar para agrandar (insertar).
El Dominio:
Tenés un arreglo stock principal que ya está ordenado ascendentemente. Los ceros al final son lugares libres en el depósito.
Llegó un camión con una caja de productos nuevos (desordenados y sin ceros) que tenés que acomodar en el depósito.
La Consigna (Pensala con tu machete):
El Director: Tenés que recorrer los productos nuevos uno por uno.
El Obrero Búsqueda (Pregunta 1 - Caso B): Para cada producto nuevo, tenés que buscar en qué posición exacta del stock debería ir para que siga quedando ordenado ascendentemente.
La Acción (Pregunta 2 - Caso B): Al arreglo de stock le hacés un corrimiento a la derecha a partir de esa posición para hacer el hueco. Luego, insertás el producto nuevo en el stock.
*/
    public static void main(String[] args) {
        
        // Stock principal ordenado (Ascendente)
        int[] stock = {10, 25, 30, 45, 50, 0, 0, 0, 0, 0};
        
        // Productos que llegaron en el camión
        int[] nuevos = {15, 35, 40};
        
        System.out.println("Stock inicial:");
        mostrarArreglo(stock);
        
        for(int i = 0; i < nuevos.length; i++){
            int productoNuevo = nuevos[i];

            int posicion = buscarPosicionInsercion(stock, productoNuevo);
            corrimientoDerecha(stock, posicion);
            stock[posicion] = productoNuevo;
        }
        
        System.out.println("\nStock después de la fusión:");
        mostrarArreglo(stock);
    }

    public static int buscarPosicionInsercion(int[] arr, int valor) {
        int pos = 0;
        while(pos < arr.length && arr[pos] != 0 && arr[pos] < valor){
            pos++;
        }
        return pos;
    }

    // EL MÉTODO DE ACCIÓN
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
