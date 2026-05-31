public class DonPepe2 {
/*
El restaurante Don Pepe busca modernizar el sistema del restaurante incorporando el cálculo de propinas para sus mozos. El sistema viejo ya cuenta con las órdenes diarias las cuales están plasmadas en un arreglo de secuencias separadas por ceros, donde cada secuencia representan un pedido y están organizadas de la siguiente forma [cite: 424]:
Para cada secuencia, el primer elemento representa el número de mozo que atendió el pedido. A continuación, aparecen una serie de tuplas, las cuales representan las órdenes tomadas por ese mesero. Cada tupla (x, y) representan una orden, donde x es el ítem de la carta e y la cantidad pedida. Por ejemplo, la tupla (13, 3) representa que se ordenó al mozo el ítem 13 de la carta 3 veces.
Ahora bien, el sistema también posee un arreglo 'Carta' donde se encuentra el precio de cada ítem de la carta, donde el primer elemento corresponde al ítem de la carta 1, el siguiente al 2 y así sucesivamente [cite: 425].
El objetivo es desarrollar un método calcule la cantidad de propina que le corresponde a cada mesero y la misma sea almacenada en un arreglo, utilizando el arreglo de pedidos diarios ya existente. El nuevo arreglo donde se almacenará la propina de cada mozo será de tamaño M (la cantidad de mozos del restaurante). El cálculo de la propina para cada mozo es el 15% de la venta total realizada por cada mesero en el día
*/
    public static final int SEPARADOR = 0;
    public static void main(String[] args) {
        
        int[] pedidos = {0, 2, 1, 2, 3, 1, 0, 1, 2, 1, 0, 0};

        double[] carta = {0.0, 1000.0, 1500.0, 2000.0};

        double[] propinas = procesarPropina(pedidos, carta);

        mostrarArreglo(propinas);
    }

    public static double[] procesarPropina(int[] pedidos, double[] carta){
        int ini = 0, fin = -1;

        double porcentajeVnetaTotal = 0.15;

        double[] arregloPropinas = new double[pedidos.length];

        while(ini < pedidos.length){
            ini = buscarInicio(pedidos, fin + 1);

            if(ini < pedidos.length){
                fin = buscarFin(pedidos, ini);

                int mozoActual = pedidos[ini];

                double propina = calcularPropina(pedidos, carta, ini, fin);

                arregloPropinas[mozoActual] += propina * porcentajeVnetaTotal; 
            }
        }

        return arregloPropinas;
    }

    public static double calcularPropina(int[] pedidos, double[] carta, int ini, int fin){
        double suma = 0;

        for(int i = ini + 1; i <= fin; i+=2){
            suma = suma + carta[pedidos[i]] * pedidos[i + 1];
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

    public static void mostrarArreglo(double[] arr){
        for(int i = 0; i < arr.length; i++){
            System.out.print(arr[i] + "|");
        }
        System.out.println();
    }
}
