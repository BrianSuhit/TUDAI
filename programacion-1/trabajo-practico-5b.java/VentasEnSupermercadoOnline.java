public class VentasEnSupermercadoOnline {
/*
Ventas en supermercado online
Un reconocido supermercado de venta online ha decidido incorporar productos a modo de promoción en
aquellos pedidos que cumplen con ciertos requisitos. Cada producto está identificado con un valor numérico
mayor a 0. Los pedidos recibidos se almacenan en un arreglo P de tamaño MAXP que comienza y finaliza con
uno o más 0. Cada pedido está compuesto por una serie de productos y separados entre sí también por uno o
más 0. A modo de ejemplo, en el siguiente arreglo P, el primer pedido está compuesto por los productos 12, 9
y 18. En total hay 4 pedidos.
0 0 12 9 18 0 15 5 4 7 10 0 8 9 12 0 19 10 9 0 0 0 0 0 0
Se pide realizar un programa en Java que permita incorporar un producto promocionado R en aquellos
pedidos que posean al menos uno de los productos almacenados en un arreglo T de tamaño MAXT

(ordenado en forma ascendente). Debido a que solo se cuenta con una cantidad C del producto
promocionado R, sólo serán incorporados en los primeros pedidos que cumplan con el requisito antes
mencionado. La incorporación del producto se realiza al final del pedido.
Continuando con el ejemplo, dado un arreglo T = {8, 9} con MAXT = 2, un producto promocionado R = 22 y
una cantidad C = 2, el arreglo resultante será:
0 0 12 9 18 22 0 15 5 4 7 10 0 8 9 12 22 0 19 10 9 0 0 0 0
Por último, se debe indicar cuántos productos R quedaron sin agregar a los pedidos. En dicho ejemplo no
quedaron productos por agregar.
*/

    public static final int SEPARADOR = 0;

    public static void main(String[] args) {
        
        int[] arregloP = {0, 0, 12, 9, 18, 0, 15, 5, 4, 7, 10, 0, 8, 9, 12, 0, 19, 10, 9, 0, 0, 0, 0, 0, 0};

        int[] arregloT = {8, 9};

        int R = 22;

        int C = 2;

        int ini = 0;
        int fin = -1;
        int contador = 0;

        while(ini < arregloP.length){
            ini = buscarInicio(arregloP, fin + 1);

            if(ini < arregloP.length){
                fin = buscarFin(arregloP, ini);

                if(estanTodosElementos(arregloP, arregloT, ini, fin) && contador < C){
                    corrimientoDerecha(arregloP, fin + 1);
                    arregloP[fin + 1] = R;
                    fin = fin + 1;
                    contador++;
                }
            }
        }
        mostrarArreglo(arregloP);
        System.out.println("Productos R sin agregar: " + (C - contador));

    }

    public static void corrimientoDerecha(int[] arr, int pos){
        for(int i = arr.length -2; i >= pos; i--){
            arr[i + 1] = arr[i];
        }
    }

    public static boolean estanTodosElementos(int[] arregloP, int[] arregloT, int ini, int fin){
        while(ini <= fin && !existeElementoEnArr(arregloT, arregloP[ini])){
            ini++;
        }
        return ini <= fin;
    }

    public static boolean existeElementoEnArr(int[] arrA, int valor){
        int pos = 0;
        while(pos < arrA.length && arrA[pos] != valor){
            pos++;
        }
        return pos < arrA.length;
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

    public static void mostrarArreglo(int[] arr) {
        for (int pos = 0; pos < arr.length; pos++)
            System.out.print(" | " + arr[pos]);
        System.out.println();
    }
}
