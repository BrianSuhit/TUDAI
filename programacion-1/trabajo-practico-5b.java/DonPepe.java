public class DonPepe {
/*
"El restaurante Don Pepe busca modernizar el sistema del restaurante
incorporando el cálculo de propinas para sus mozos. El sistema viejo ya cuenta
con las órdenes diarias las cuales están plasmadas en un arreglo de secuencias
separadas por ceros, donde cada secuencia representan un pedido y están
organizadas de la siguiente forma:
Para cada secuencia, el primer elemento representa el número de mozo que atendió el pedido. A
continuación, aparecen una serie de tuplas, las cuales
representan las órdenes tomadas por ese mesero. Cada tupla (x, y) representan una orden,
donde x es el ítem de la carta e y la cantidad pedida. Por ejemplo, la tupla 3 (13, 3) representa
que se ordenó al mozo el ítem 13 de la carta 3 veces. Ahora bien, el sistema también posee un
arreglo ‘Carta’ donde se encuentra el precio de cada ítem de la carta, donde el primer elemento
corresponde al ítem de la carta 1, el siguiente al 2 y así sucesivamente.
El objetivo es desarrollar un método calcule la cantidad de propina que le corresponde a cada
mesero y la misma sea almacenada en un arreglo, utilizando el arreglo de pedidos diarios ya
existente. El nuevo arreglo donde se almacenará la propina de cada mozo será de tamaño M (la
cantidad de mozos del restaurante). El cálculo de la propina para cada mozo es el 15% de la
venta total realizada por cada mesero en el día. A continuación se muestra un ejemplo del
arreglo de propinas esperado para el ejemplo dado. Con esta actualización el restaurante Don
Pepe espera que este sistema automatizado simplifique el cálculo de propinas para así
ahorrarse posibles discusiones entre los mozos.
*/

    public static final int SEPARADOR = 0;
    public static void main(String[] args) {
        int[] arregloA = {/* Pedidos precargados */};
        int[] arregloCarta = {/* Precios precargados */};
        
        double[] arregloPropina = new double[8];

        int ini = 0;
        int fin = -1;

        while (ini < arregloA.length) {
            ini = buscarInicio(arregloA, fin + 1);
            
            if (ini < arregloA.length) {
                fin = buscarFin(arregloA, ini);
                
                procesarPropina(arregloA, arregloCarta, arregloPropina, ini, fin);
            }
        }
    }

    public static void procesarPropina(int[] arrPedidos, int[] arrCarta, double[] arrPropina, int ini, int fin) {
        
        int mozo = arrPedidos[ini]; 
        
        int pos = ini + 1; 
        int totalVentaPedido = 0;

        while (pos <= fin) {
            int item = arrPedidos[pos];
            int cantidad = arrPedidos[pos + 1]; 

            int precio = arrCarta[item - 1]; 

            totalVentaPedido += (precio * cantidad);

            pos = pos + 2; 
        }
        double propina = totalVentaPedido * 0.15;
        arrPropina[mozo] += propina; 
    }
    
    public static int buscarInicio(int[] arr, int pos) {
        while (pos < arr.length && arr[pos] == SEPARADOR) {
            pos++;
        }
        return pos;
    }

    public static int buscarFin(int[] arr, int ini) {
        while (ini < arr.length && arr[ini] != SEPARADOR) {
            ini++;
        }
        return ini - 1;
    }
}
