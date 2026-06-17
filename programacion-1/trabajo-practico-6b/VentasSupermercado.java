public class VentasSupermercado {
/*
9. Ventas supermercado
Un supermercado almacena los importes de sus ventas anuales en una matriz de NxM, en donde cada fila
representa las ventas de cada mes. Dentro de un mes, la información es almacenada en secuencias
separadas por 0 donde cada secuencia representa las ventas realizadas dentro de un día. Por ejemplo, en la
siguiente tabla, en el mes 1 se realizaron 3 ventas el primer día por $150, $200 y $165.
0 0 150 200 165 0 154 352 240 256 0 900 750 0 0
0 940 105 265 845 215 0 245 765 348 0 741 125 541 0
0 851 543 625 845 914 0 754 184 452 637 917 0 0 0
El gerente desea solicitar distintas estadísticas según el mes que se quiere analizar. En algunos casos le
interesa conocer el promedio mensual de las ventas de mayor importe registradas en cada día y en
otros casos, necesita saber si el promedio diario de ventas fue todos los días superior a X durante el
mes. Para ello informa en un arreglo A1 los meses que desea la primera estadística y en un arreglo A2 los de
la segunda. A1 y A2 son de tamaño N, rellenados con 0.
Por ejemplo, si A1 = {1,2,0} y A2 = {3,0,0} para los meses 1 y 2 se informará que el promedio es $484 (200 +
352 + 900 / 3) y 815.33 (940 + 765 + 741 / 3), respectivamente. Para el mes 3, dado un X = 600, informará
que no se cumplió.
*/
    public static final int SEPARADOR = 0;
    public static void main(String[] args) {
        
        int[][] matriz = {
           {0, 0, 150, 200, 165, 0, 154, 352, 240, 256, 0, 900, 750, 0, 0},
            {0, 940, 105, 265, 845, 215, 0, 245, 765, 348, 0, 741, 125, 541, 0},
            {0, 851, 543, 625, 845, 914,0, 754, 184, 452, 637, 917, 0, 0, 0}
        };

        int[] A1 = {1,2,0,0,0}, A2 = {0,0,3,0,0};
        int X = 600;


        procesarMatriz(matriz, A1, A2, X);
    }

    public static void procesarMatriz(int[][] matriz, int[] arr1, int[] arr2, int X){

        for(int fila = 0; fila < matriz.length; fila++){
            int mes = fila + 1;

            boolean pideMaximos = estaEnArr(arr1, mes);
            boolean pidePromedios = estaEnArr(arr2, mes); 

            if(pideMaximos || pidePromedios){
                procesarMes(matriz[fila], pideMaximos, pidePromedios, mes, X);
            }
        }
    }

    public static void procesarMes(int[] fila, boolean pideMaximos, boolean pidePromedios, int mes, int X) {
        int ini = 0, fin = -1, contVentasMayor = 0, ventaMayor = 0;
        double promedioMensual = 0.0, promedioDiario = 0.0;
        boolean superiorX = true;

        while (ini < fila.length) {
            ini = buscarInicio(fila, fin + 1);

            if (ini < fila.length) {
                fin = buscarFin(fila, ini);
                
                if (pideMaximos) { 
                    ventaMayor += buscarVentaMayor(fila, ini, fin);
                    contVentasMayor++;
                }
                if (pidePromedios) {
                    int tamaño = fin - ini + 1;

                    int sumaDiaria = calcularSuma(fila, ini, fin);

                    promedioDiario = (double) sumaDiaria / tamaño;
                    if(promedioDiario <= X){
                        superiorX = false;
                    }
                }
            }
        }
        
        if (pideMaximos && contVentasMayor > 0) {
            promedioMensual = (double) ventaMayor / contVentasMayor;
            System.out.println("Para el mes: " + mes + " el promedio de la mayor venta diaria es: " + promedioMensual);
        }

        if (pidePromedios) {
            System.out.println("¿El promedio diario en el mes: " + mes + " fue siempre superior al mínimo?: " + superiorX);
        }
    }

    public static int calcularSuma(int[] arr, int ini, int fin){
        int suma = 0;
        for(int i = ini; i <= fin; i++){
            suma += arr[i];
        }
        return suma;
    }

    public static int buscarVentaMayor(int[] arr, int ini, int fin){
        int mayor = 0, i = ini;

        while(i <= fin){
            if(arr[i] > mayor){
                mayor = arr[i];
            }
            i++;
        }
        return mayor;
    }

    public static boolean estaEnArr(int[] arr, int mes) {
        boolean cumple = false;
        int i = 0;
        while (i < arr.length && !cumple) {
            if (arr[i] == mes) { cumple = true; }
            i++;
        }
        return cumple;
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
