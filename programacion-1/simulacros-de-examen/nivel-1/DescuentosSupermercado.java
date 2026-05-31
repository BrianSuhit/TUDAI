public class DescuentosSupermercado {
/*
📝 SIMULACRO NIVEL 1: "Descuento por Volumen"
La Consigna: El sistema de un supermercado registra los tickets de compra de los clientes en un arreglo de secuencias separadas por ceros (0). Cada secuencia representa los precios de los productos llevados por un cliente en una sola compra.
Por el aniversario del supermercado, el gerente estableció una promoción: Si el monto total de un ticket supera los $1000, se le debe aplicar un descuento directo de $50 a cada uno de los productos de ese ticket.
Se te pide recorrer el arreglo, identificar los tickets que superen los $1000 en total, y restarle $50 al valor de cada producto dentro de esa misma secuencia. Al finalizar, el programa termina (todo se modifica sobre el mismo arreglo).
*/
    public static final int SEPARADOR = 0;
    public static final int MONTO_PROMOCION = 1000; 
    public static final int DESCUENTO = 50;

    public static void main(String[] args) {
        
        // Ticket 1: 300 + 400 + 100 = 800 (NO supera 1000, no se toca).
        // Ticket 2: 600 + 500 = 1100 (¡SUPERA! Se restan 50 a cada uno -> queda 550, 450).
        // Ticket 3: 200 = 200 (NO supera, no se toca).
        // Ticket 4: 800 + 400 + 200 = 1400 (¡SUPERA! -> queda 750, 350, 150).
        
        int[] arrTickets = {0, 300, 400, 100, 0, 600, 500, 0, 200, 0, 800, 400, 200, 0, 0};

        int ini = 0;
        int fin = -1;

        while(ini < arrTickets.length){
            ini = buscarInicio(arrTickets, fin + 1);

            if(ini < arrTickets.length){
                fin  = buscarFin(arrTickets, ini);

                int montoTotal = calcularSuma(arrTickets, ini, fin);

                if(montoTotal > MONTO_PROMOCION){
                    aplicarDescuento(arrTickets, ini, fin);
                }
            }
        } 
    }

    public static void aplicarDescuento(int[] arr, int ini, int fin){
        for(int i = ini; i <= fin; i++){
            arr[i] = arr[i] - DESCUENTO;
        }
    }

    public static int calcularSuma(int[] arr, int ini, int fin){
        int suma = 0;
        for(int i = ini; i <= fin; i++){
            suma = suma + arr[i];
        }
        return suma;
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
        return pos - 1;
    }
}
