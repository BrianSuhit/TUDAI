public class AtencionVentanilla {
/*
📝 SIMULACRO 1 (Nivel 3): "Atención en ventanilla" (Corrimiento a Izquierda Básico)
El Dominio: Tenés una fila de clientes en un banco esperando a ser atendidos. Están representados por su número de ticket en un arreglo simple. Los ceros al final representan lugares vacíos en la fila.
La Consigna: El cajero toca el timbre y atiende al primer cliente de la fila (el que está en la posición 0). Como ese cliente ya fue atendido, tenés que eliminarlo del arreglo. Para que la fila no quede con un hueco en el medio, tenés que hacer un corrimiento a izquierda a partir de esa posición, haciendo que todos los demás avancen un paso hacia adelante.
*/
    public static final int MAX = 10;

    public static void main(String[] args) {
        
        // Fila de clientes (los ceros al final son lugares libres)
        int[] fila = {45, 12, 89, 3, 22, 0, 0, 0, 0, 0};
        
        System.out.println("Fila inicial:");
        mostrarFila(fila);
        
        System.out.println("\nAtendiendo al cliente con ticket: " + fila);
        
        corrimientoIzquierda(fila, 0);
        
        System.out.println("\nFila después de atender:");
        mostrarFila(fila);
    }

    // 2. EL MÉTODO DE ACCIÓN: Corrimiento a Izquierda
    public static void corrimientoIzquierda(int[] arr, int pos) {
        for(int i = pos; i < arr.length - 1; i++){
            arr[i] = arr[i + 1];
        }
    }

    // Método auxiliar para no ensuciar el main
    public static void mostrarFila(int[] arr) {
        for (int i = 0; i < MAX; i++) {
            System.out.print(arr[i] + " | ");
        }
    }
}
