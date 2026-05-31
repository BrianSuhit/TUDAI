public class VipBanco {
/*
SIMULACRO 6 (Nivel 4): "El VIP del banco" (Insertar manteniendo el orden)
El Dominio: El sistema de un banco organiza las filas de sus cajas en un arreglo de secuencias (separadas por 0). Adentro de cada fila, los clientes están representados por un número de prioridad, ordenados de menor a mayor (ej: 1, 3, 5, 8). De repente, llega un "Cliente VIP" con prioridad 4 que debe ser ingresado únicamente a la primera fila del día (la primera secuencia del arreglo).
La Consigna: Aislar solo el primer vagón, recorrerlo buscando en qué posición exacta debería insertarse el 4 para que la fila siga perfectamente ordenada de menor a mayor, hacer el hueco ahí, y meter al VIP.
*/
    public static final int SEPARADOR = 0;
    
    public static void main(String[] args) {
        
        // Filas de clientes ordenadas por prioridad. 
        // Primera fila: 1, 3, 5, 8. Acá tiene que entrar el 4.
        int[] filas = {0, 1, 3, 5, 8, 0, 0, 2, 6, 9, 0, 1, 2, 0, 0, 0, 0, 0, 0, 0};
        int clienteVip = 4;
        
        System.out.println("Filas iniciales:");
        mostrarArreglo(filas);
        
        // --- EL DIRECTOR ---
        int ini = 0;
        int fin = -1;
        boolean filaEncontrada = false;

        while(ini < filas.length && !filaEncontrada){
            ini = buscarInicio(filas, fin + 1);

            if(ini < filas.length){
                fin = buscarFin(filas, ini);

                int posActual = ini;
                boolean vipEncontrado = false;

                while(posActual <= fin && !vipEncontrado){
                    filaEncontrada = true;

                    if(filas[posActual] > clienteVip){
                        corrimientoDerecha(filas, posActual);
                        filas[posActual] = clienteVip;
                        fin = fin + 1;
                        vipEncontrado = true;
                    }
                    else{
                        posActual++;
                    }
                }
            }
        }
        
        System.out.println("\nFilas despues del VIP:");
        mostrarArreglo(filas);
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
