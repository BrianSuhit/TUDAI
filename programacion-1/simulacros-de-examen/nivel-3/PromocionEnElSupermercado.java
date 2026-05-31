public class PromocionEnElSupermercado {
/*
📝 SIMULACRO NIVEL 3: "Promoción en el Supermercado"
El Dominio Real (La Saraza): Un supermercado online guarda los pedidos de sus clientes en un arreglo arrPedidos separados por ceros (0). Cada número adentro de un "vagón" es el código de un producto. Por el HotSale, el supermercado decidió que si un cliente compró el producto estrella (código 77), se le debe regalar un producto promocional (código 88).
La Consigna: Escribir un programa que recorra los pedidos. Si encuentra que el pedido contiene al menos un producto 77, debe insertar el producto de regalo 88 exactamente al final de ese pedido.
*/
    public static final int SEPARADOR = 0;
    public static final int ESTRELLA = 77;
    public static final int REGALO = 88;

    public static void main(String[] args) {
        
        int[] arrPedidos = {0, 12, 77, 18, 0, 15, 5, 4, 0, 8, 9, 77, 0, 0, 0, 0, 0};

        int ini = 0;
        int fin = -1;

        while(ini < arrPedidos.length){
            ini = buscarInicio(arrPedidos, fin + 1);

            if(ini < arrPedidos.length){
                fin = buscarFin(arrPedidos, ini);

                if(tienePromocion(arrPedidos, ini, fin, ESTRELLA)){
                    corrimientoDerecha(arrPedidos, fin +1);
                    arrPedidos[fin + 1] = REGALO;
                    fin = fin + 1;
                }
            }
        }
    }

    public static int buscarInicio(int[] arr, int pos){
        while(pos < arr.length && arr[pos] == 0){
            pos++;
        }
        return pos;
    }

    public static int buscarFin(int[] arr, int pos){
        while(pos < arr.length && arr[pos] != 0){
            pos++;
        }
        return pos - 1;
    }

    public static void corrimientoDerecha(int[] arr, int pos){
        for(int i = arr.length - 1; i > pos; i--){
            arr[i] = arr[i - 1];
        }
    }

    public static boolean tienePromocion(int[] arr, int ini, int fin, int valor){
       int i = ini;

        while(i <= fin && arr[i] != valor){
            i++;
        }
       return (i <= fin);
    }
}
