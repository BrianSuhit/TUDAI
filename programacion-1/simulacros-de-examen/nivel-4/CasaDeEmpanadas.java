public class CasaDeEmpanadas {
/*
SIMULACRO 7: Casa de Empanadas (Ejercicio 5 - Práctica 5.b)
El Dominio Oficial: Los pedidos se almacenan en un arreglo E de tamaño MAXE. Cada tipo de empanada es un número positivo (ej: 5 es carne, 7 es roquefort). Cada pedido está separado por uno o más números negativos [cite: 399]. Adentro del pedido, las empanadas están ordenadas de forma ascendente [cite: 399].
El cliente ingresa el número de pedido (ej: 2 para el segundo pedido) y el gusto de la empanada que se olvidó. Tenés que aislar ese pedido específico, buscar la posición correcta e incorporar la empanada manteniendo el orden [cite: 400].
*/
    public static final int SEPARADOR = 0;
    public static void main(String[] args) {
        
        // Pedidos separados por un negativo. Ordenados ascendentemente.
        int[] E = {-1, 5, 5, 7, 7, -6, 4, 9, 10, -4, 1, 1, 2, 7, -9, -8, 0, 0, 0, 0};
        
        int pedidoBuscado = 2; // El cliente quiere agregar al 2do pedido (el del medio)
        int empanadaOlvidada = 7; // Quiere agregar una de roquefort (7)
        
        System.out.println("Pedidos originales:");
        mostrarArreglo(E);
        
        // --- EL DIRECTOR ---
        int ini = 0;
        int fin = -1;
        int contadorPedidos = 0;

        while(ini < E.length){
            ini = buscarInicio(E, fin + 1);

            if(ini < E.length){
                fin = buscarFin(E, ini);

                contadorPedidos++;
                boolean posEncontrada = false;

                if(contadorPedidos == pedidoBuscado){
                    int posActual = ini;

                    while(posActual <= fin && !posEncontrada){

                        if(E[posActual] > empanadaOlvidada){
                            posEncontrada = true;
                        }
                        else{
                            posActual++;
                        }   
                    }
                    corrimientoDerecha(E, posActual); // posActual ya está en el lugar perfecto (el final del vagón)
                    E[posActual] = empanadaOlvidada;
                    fin = fin + 1; // Ajuste obligatorio del Patrón Agrandar
                }
            }
        }
        System.out.println("\nPedidos tras el agregado:");
        mostrarArreglo(E);
    }

    public static int buscarInicio(int[] arr, int pos) {
        while(pos < arr.length && arr[pos] < SEPARADOR){
            pos++;
        }
        return pos;
    }

    public static int buscarFin(int[] arr, int pos) {
        while(pos < arr.length && arr[pos] >= SEPARADOR){
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
