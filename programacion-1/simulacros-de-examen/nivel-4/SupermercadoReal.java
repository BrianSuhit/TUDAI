public class SupermercadoReal {
/*
SIMULACRO 9 NIVEL 4: "Ventas en supermercado REAL"
El Dominio (Consigna Oficial): Un reconocido supermercado de venta online ha decidido incorporar productos a modo de promoción en aquellos pedidos que cumplen con ciertos requisitos [cite: 397]. Los pedidos recibidos se almacenan en un arreglo P que comienza y finaliza con uno o más 0. Cada pedido está compuesto por una serie de productos separados entre sí también por uno o más 0 [cite: 397].
Se pide realizar un programa que permita incorporar un producto promocionado R en aquellos pedidos que posean al menos uno de los productos almacenados en un arreglo T (ordenado en forma ascendente) [cite: 398].
La Trampa del Nivel Parcial: Debido a que solo se cuenta con una cantidad C del producto promocionado R, sólo serán incorporados en los primeros pedidos que cumplan con el requisito [cite: 398]. La incorporación del producto se realiza al final del pedido [cite: 398]. Por último, se debe indicar cuántos productos R quedaron sin agregar a los pedidos [cite: 399].
*/

     public static final int SEPARADOR = 0;
    
    public static void main(String[] args) {
        
        // Pedidos (P). Separados por uno o más 0.
        int[] P = {0, 0, 12, 9, 18, 0, 15, 5, 4, 7, 10, 0, 8, 9, 12, 0, 19, 10, 9, 0, 0, 0, 0, 0, 0, 0};
        
        // Arreglo de ofertas (T).
        int[] T = {8, 9};
        
        // Producto de regalo (R)
        int R = 22;
        
        // Cantidad de productos de regalo en stock (C)
        int C = 2;
        
        System.out.println("Pedidos originales:");
        mostrarArreglo(P);
        
        // --- EL DIRECTOR ---
        int ini = 0;
        int fin = -1;
        int contadorCantidad = 0;

        while(ini < P.length){

            ini = buscarInicio(P, fin + 1);

            if(ini < P.length){
                fin = buscarFin(P, ini);

                if(tieneProductoEnOferta(P, ini, fin, T) && contadorCantidad < C){
                    corrimientoDerecha(P, fin + 1);
                    P[fin + 1] = R;
                    fin = fin + 1;
                    contadorCantidad++;
                }
            }
        }
        
        
        System.out.println("\nPedidos con regalos:");
        mostrarArreglo(P);
        System.out.println("\nProductos R sin agregar (Stock sobrante): " + C);
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

    public static boolean tieneProductoEnOferta(int[] P, int ini, int fin, int[] T) {
    int i = ini;
    // Mientras no termine el vagón Y el producto actual NO sea oferta
    while(i <= fin && !esOferta(P[i], T)){
        i++;
    }
    // Si i <= fin, significa que el while se frenó antes de caerse, ¡porque encontró oferta!
    return i <= fin; 
    }

    public static boolean esOferta(int valor, int[] T){
        int j = 0;
        // Mientras no caiga del arreglo de ofertas Y no sea el valor que busco
        while(j < T.length && T[j] != valor){
            j++;
        }
        // Si j < T.length, lo encontró antes de llegar al final
        return j < T.length; 
    }

    public static void mostrarArreglo(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " | ");
        }
    }
}
