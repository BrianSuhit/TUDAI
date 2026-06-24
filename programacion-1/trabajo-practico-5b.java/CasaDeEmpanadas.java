public class CasaDeEmpanadas {
/*
Casa de empanadas
Los pedidos que recibe una casa de empanadas se almacenan en un arreglo E de tamaño MAXE. Cada tipo
de empanada se almacena con un número diferente, por ejemplo, el 5 representa la empanada de carne
cortada a cuchillo mientras que el 7 representa la empanada de roquefort. Cada pedido está separado por
uno o más números negativos (ya que los códigos son todos valores positivos incluyendo el 0). Para facilitar
el proceso de producción los códigos de las empanadas están almacenadas en forma ascendente. En el
siguiente ejemplo, tenemos 3 pedidos. El primero incluye 2 empanadas de carne cortada a cuchillo (5) y 2 de
roquefort (7).
-1 5 5 7 7 -6 4 9 10 -4 1 1 2 7 -9 -8
Si un cliente se olvida de alguna empanada, puede agregarla luego de realizado el pedido. Para ellos debe
indicar el número de pedido (es el orden del pedido dentro del arreglo) y el gusto de la empanada que quiere
agregar.
Se pide implementar un programa en Java que permita incorporar la empanada faltante al pedido del cliente.
Siguiendo con el ejemplo, si el cliente quiere agregar una empanada de roquefort en el pedido 2. El arreglo
resultante debería ser:
-1 5 5 7 7 -6 4 7 9 10 -4 1 1 2 7 -9
*/
    public static final int SEC_PEDIDO = 2;

    public static void main(String[] args){

        int[] arreglo = {-1, 5, 5, 7, 7, -6, 4, 9, 10, -4, 1, 1, 2, 7, -9, -8};

        int ini = 0;
        int fin = -1;

        int contador = 0;
        boolean pedidoEncontrado = false;
        int empanadaAAgregar = 7;

        while(ini < arreglo.length && !pedidoEncontrado){

            ini = buscarInicio(arreglo, fin + 1);

            if(ini < arreglo.length){
                fin = buscarFin(arreglo, ini);
                contador++;

                if(contador == SEC_PEDIDO){
                    pedidoEncontrado = true;

                    insertarEmpanada(arreglo, ini, fin, empanadaAAgregar);
                    fin = fin + 1; 
                }
            }
        }
        
        for(int i=0; i<arreglo.length; i++){
            System.out.print(arreglo[i] + " | ");
        }
    }

    public static void insertarEmpanada(int[] arreglo, int ini, int fin, int valorAgregar){
        int pos = ini; 
        boolean posEncontrada = false;

        while(pos <= fin && !posEncontrada){
            if(arreglo[pos] > valorAgregar){
                posEncontrada = true;
            } else {
                pos++;
            }
        }
        corrimientoDerecha(arreglo, pos);
        arreglo[pos] = valorAgregar;
    }

    public static void corrimientoDerecha(int[] arreglo, int pos){
        for(int i = arreglo.length - 2; i >= pos; i--){
            arreglo[i + 1] = arreglo[i];
        }
    }

    public static int buscarInicio(int[]arr, int pos){
        while(pos < arr.length && arr[pos] < 0){
            pos++;
        }
        return pos;
    }

    public static int buscarFin(int[]arr, int ini){
        while(ini < arr.length && arr[ini] >= 0){
            ini++;
        }
        return ini - 1;
    }
}
