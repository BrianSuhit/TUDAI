public class AsignacionMesas {
/*
📝 SIMULACRO 6 (Nivel 3): "Asignación de Mesas" (Lectura Cruzada + Eliminación)
Este es literalmente el núcleo del Ejercicio 2 de tu Práctica 5.b (Ejercicios tipo parcial)
, pero adaptado a nuestra regla de Nivel 3 (sin secuencias, solo números sueltos).
El Dominio:
Tenés un arreglo de clientes esperando por una mesa. Cada número representa la cantidad de personas en el grupo. Los ceros son espacios vacíos en la fila.
Tenés un arreglo de mesas con su capacidad. Este arreglo está ordenado ascendentemente.
La Consigna:
Recorrer la fila de clientes.
Para cada cliente, tenés que buscarle una mesa que lo pueda alojar. Como las mesas están ordenadas, la primera mesa cuya capacidad sea mayor o igual a la cantidad del grupo, es la ideal.
Si encontrás mesa:
La ocupás multiplicando su valor por -1 en el arreglo de mesas (así no se le asigna a otro).
El cliente se sienta, por lo tanto lo ELIMINÁS de la fila de clientes (acá entra tu corrimiento a izquierda).
Si no encontrás mesa, el cliente se queda en la fila.
*/
    public static void main(String[] args) {
        
        // Fila de clientes (números sueltos, la basura al final)
        int[] clientes = {4, 3, 8, 6, 2, 12, 0, 0, 0, 0};
        
        // Capacidad de las mesas (Ordenado ascendente)
        int[] mesas = {2, 3, 5, 6, 12};
        
        // ... ¡TODO TUYO! ...
        // Aplicá tu instinto de Diseño Descendente.
        // Hacé un while que recorra clientes.
        // Llamá a un obrero para que busque la mesa.
        // Si encuentra, hacé las acciones (ocupar mesa y corrimiento).
        // Si no encuentra, avanzá.
        int i = 0;

        while(i < clientes.length && clientes[i] != 0){
            int posMesa = buscarMesa(mesas, clientes[i]);

            if(posMesa != -1){

                // ACCIÓN 1: Ocupo la mesa (la multiplico por -1)
                mesas[posMesa] = mesas[posMesa] * -1;

                // ACCIÓN 2: El cliente se sentó, lo borro de la fila (tu método está perfecto)
                corrimientoIzquierda(clientes, i);
            }
            else{
                i++;
            }
        }
        
        System.out.println("Fila de clientes restante:");
        mostrarArreglo(clientes);
        
        System.out.println("\nEstado de las mesas (negativas = ocupadas):");
        mostrarArreglo(mesas);
    }

    // MÉTODO OBRERO 1: buscarMesa
    // Tip: Recibís el arreglo de mesas y la cantidad de personas. 
    // Devolve el índice de la mesa, o -1 si no hay mesa disponible.
    public static int buscarMesa(int[] mesas, int cantidadPersonas){

        int j = 0;
        while(j < mesas.length){

            if(mesas[j] >= cantidadPersonas && mesas[j] > 0){
                return j;
            }
            j++;
        }
        return -1;
    }

    // MÉTODO DE ACCIÓN: corrimientoIzquierda
    public static void corrimientoIzquierda(int[] arr, int pos){
        for( int i = pos; i < arr.length - 1; i++){
            arr[i] = arr[i + 1];
        }
    }
    
    public static void mostrarArreglo(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " | ");
        }
    }
}
