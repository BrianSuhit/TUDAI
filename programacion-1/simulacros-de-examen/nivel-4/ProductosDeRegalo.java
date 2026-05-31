public class ProductosDeRegalo {
/*
SIMULACRO 10: "Productos de Regalo" (Ejercicio 6)
El Dominio (Consigna Oficial): Un reconocido supermercado de venta online ha decidido regalar productos a modo de promoción en todos sus pedidos [cite: 401]. Cada producto está identificado con un valor numérico mayor a 0. Los pedidos recibidos se almacenan en un arreglo P de tamaño MAXP que comienza y finaliza con uno o más 0 [cite: 401]. Cada pedido está compuesto por una serie de productos y separados entre sí también por uno o más 0. Dentro de cada pedido, los productos están ordenados de forma ascendente [cite: 401].
Se pide realizar un programa en Java que permita incorporar a cada pedido los productos promocionados que están almacenados en un arreglo R de tamaño MAXR [cite: 402]. La incorporación de los productos se deberá realizar respetando el orden ascendente de los productos de cada pedido [cite: 402]. Se pide además informar la cantidad de productos regalados en total [cite: 402].
*/  
    public static final int SEPARADOR = 0;
    
    public static void main(String[] args) {
        
        // Pedidos (P). Separados por 0. Ordenados ascendentemente internamente.
        // Hay mucho espacio al final (ceros) para que el arreglo pueda crecer.
        int[] P = {0, 0, 9, 12, 18, 0, 1, 5, 43, 73, 88, 0, 52, 89, 0, 1, 10, 90, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        
        // Arreglo de regalos (R). 
        int[] R = {44, 6};
        
        int totalRegalados = 0;
        
        System.out.println("Pedidos originales:");
        mostrarArreglo(P);
        
        // --- EL DIRECTOR ---
        // Tu turno de razonar...
        int ini = 0;
        int fin = -1;

        while(ini < P.length){
            ini = buscarInicio(P, fin + 1);

            if(ini < P.length){
                fin = buscarFin(P, ini);

                insertarRegalos(P, ini, fin, R);
                fin = fin + R.length;
            }
        }
        
        
        
        System.out.println("\nPedidos con regalos:");
        mostrarArreglo(P);
        System.out.println("\nTotal de productos regalados: " + totalRegalados);
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
        }
    }

    public static void mostrarArreglo(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " | ");
        }
    }
}
