public class RestauranteDonPepeLite {
/*
Parcial: "Control de Ventas - Restaurante Don Pepe" (Versión Adaptada)
El restaurante Don Pepe busca auditar el rendimiento individual de su personal. El sistema cuenta con las órdenes diarias, las cuales están plasmadas en un arreglo de secuencias separadas por ceros, donde cada secuencia representa un pedido y está organizada de la siguiente forma:
Para cada secuencia, el primer elemento representa el número de mozo que atendió el pedido. A continuación, aparecen una serie de tuplas, las cuales representan las órdenes tomadas por ese mesero. Cada tupla (x, y) representa una orden, donde x es el ítem de la carta e y la cantidad pedida. Por ejemplo, la secuencia delimitada por ceros 4, 13, 3, 5, 2 representa que el mozo 4 sirvió el ítem 13 (3 veces) y el ítem 5 (2 veces).
Se pide implementar un programa en Java que, dado un arreglo de pedidos ya cargado y un número de mozo a auditar (ejemplo: Mozo 4), calcule e informe por consola la cantidad total de platos (unidades pedidas) que sirvió dicho mozo en todo el día.
IMPORTANTE: El ejemplo es meramente ilustrativo, la solución planteada debe ser válida para cualquier arreglo. Aplicar TODAS las buenas prácticas vistas en la materia. No usar estructuras auxiliares.
--------------------------------------------------------------------------------
int[] pedidos = {0, 4, 12, 1, 5, 2, 0, 7, 8, 3, 0, 4, 10, 2, 0, 0, 0}; 
int mozoAuditar = 4;
*/
    public static final int SEPARADOR = 0;
    public static void main(String[] args){
        int[] pedidos = {0, 4, 12, 1, 5, 2, 0, 7, 8, 3, 0, 4, 10, 2, 0, 0, 0};

        int mozoAuditar = 4;

        procesarSecuencia(pedidos, mozoAuditar);
    }

    public static void procesarSecuencia(int[] pedidos, int mozo){
        int ini = 0, fin = -1, sumaDePlatos = 0;

        while(ini < pedidos.length){
            ini = buscarInicio(pedidos, fin + 1);

            if(ini < pedidos.length){
                fin = buscarFin(pedidos, ini);

                if(pedidos[ini] == mozo){
                    sumaDePlatos += calcularSuma(pedidos, ini, fin);
                }
            }
        }
        System.out.println("la cantidad de platos vendidas por el mozo: " + mozo + " es: " + sumaDePlatos);
    }

    public static int calcularSuma(int[] pedidos, int ini, int fin){
        int suma = 0;

        for(int i = ini + 2; i <= fin; i+=2){
            suma = suma + pedidos[i];
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
