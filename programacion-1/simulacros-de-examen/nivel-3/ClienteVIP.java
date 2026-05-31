public class ClienteVIP {
/*
 SIMULACRO 2 (Nivel 3): "Cliente VIP" (Corrimiento a Derecha Básico)
El Dominio: Seguimos en el mismo banco, con la misma fila. De repente entra al banco el dueño de la ciudad (un Cliente VIP con el ticket 99). Por su estatus, no hace fila. Se tiene que insertar primero en la fila (posición 0).
La Consigna:
Tenés que hacerle un "hueco" en la posición 0 haciendo que todos los que ya estaban en la fila den un paso hacia atrás (Corrimiento a Derecha). Recordá que el último lugar del arreglo se pierde (cae al vacío)
.
Una vez hecho el hueco, insertás al cliente VIP en esa posición.
*/
    public static final int MAX = 10;

    public static void main(String[] args) {
        
        // Fila actual
        int[] fila = {45, 12, 89, 3, 22, 0, 0, 0, 0, 0};
        int ticketVIP = 99;
        int posInsercion = 0; // El VIP va primero
        
        System.out.println("Fila antes del VIP:");
        mostrarFila(fila);
        
        // 1. LLAMADA A LA ACCIÓN: Hacer el hueco
        corrimientoDerecha(fila, posInsercion);
        fila[posInsercion] = ticketVIP;
        
        System.out.println("\nFila después de que entró el VIP:");
        mostrarFila(fila);
    }

    // EL NUEVO MÉTODO DE ACCIÓN: Corrimiento a Derecha
    public static void corrimientoDerecha(int[] arr, int pos) {
        for(int i = MAX - 1; i > pos; i--){
            arr[i] = arr[i - 1];
        }
    }

    public static void mostrarFila(int[] arr) {
        for (int i = 0; i < MAX; i++) {
            System.out.print(arr[i] + " | ");
        }
    }
}
