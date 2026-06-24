public class ProductosDeRegalo {
/*
Productos de regalo
Un reconocido supermercado de venta online ha decidido regalar productos a modo de promoción en todos
sus pedidos. Cada producto está identificado con un valor numérico mayor a 0. Los pedidos recibidos se
almacenan en un arreglo P de tamaño MAXP que comienza y finaliza con uno o más 0. Cada pedido está
compuesto por una serie de productos y separados entre sí también por uno o más 0. Dentro de cada pedido,
los productos están ordenados de forma ascendente. A modo de ejemplo, en el siguiente arreglo P, el primer
pedido está compuesto por los productos 9, 12 y 18. En total hay 4 pedidos.
0 0 9 12 18 0 1 5 43 73 88 0 8 9 52 0 1 10 90 0 0 0 0 0 0 0 0 0
Se pide realizar un programa en Java que permita incorporar a cada pedido los productos promocionados
que están almacenados en un arreglo R de tamaño MAXR. La incorporación de los productos se deberá
realizar respetando el orden ascendente de los productos de cada pedido. Se pide además informar la
cantidad de productos regalados en total.
Continuando con el ejemplo, dado un arreglo R = {44, 6} con MAXR = 2 el arreglo resultante será:
0 0 6 9 12 18 44 0 1 5 6 43 44 73 88 0 6 8 9 44 52 0 1 6 10 44 90 0

En el ejemplo, la cantidad total de productos regalados fue 8.
*/
    public static final int SEPARADOR = 0;

    public static void main(String[] args) {
        
        int[] arregloP = {0, 0, 9, 12, 18, 0, 1, 5, 43, 73, 88, 0, 8, 9, 52, 0, 1, 10, 90, 0, 0, 0, 0, 0, 0, 0, 0, 0};

        int[] R = {44, 6};

        int ini = 0;
        int fin = -1;

        while(ini < arregloP.length){
            ini = buscarInicio(arregloP, fin +1);

            if(ini < arregloP.length){
                fin = buscarFin(arregloP, ini);

                insertarRegalos(arregloP, ini, fin, R);
                fin = fin + R.length;
            }
        }
        mostrarArreglo(arregloP);
    }

    public static void insertarRegalos(int[] arregloP, int ini, int fin, int[] R){

        for(int i = 0; i < R.length; i++){
            int regaloActual = R[i];

                int pos = ini;
                boolean posEncontrada = false;

                while(pos <= fin && !posEncontrada){
                if(arregloP[pos] > regaloActual){
                    posEncontrada = true;
                }
                else{
                    pos++;
                }
            }

            corrimientoDerecha(arregloP, pos);
            arregloP[pos] = regaloActual;
            fin = fin + 1; 
        }
    }

    public static void corrimientoDerecha(int[] arreglo, int pos){
        for(int i = arreglo.length - 2; i >= pos; i--){
            arreglo[i + 1] = arreglo[i];
        }
    }

    public static int buscarInicio(int[] arreglo, int pos){
        while(pos < arreglo.length && arreglo[pos] == SEPARADOR){
            pos++;
        }
        return pos;
    }

    public static int buscarFin(int[] arreglo, int pos){
        while(pos < arreglo.length && arreglo[pos] != SEPARADOR){
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
