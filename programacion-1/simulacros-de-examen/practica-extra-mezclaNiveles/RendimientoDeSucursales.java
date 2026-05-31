public class RendimientoDeSucursales {
/*
Dominio: Rendimiento de Sucursales
Una cadena de tiendas registra las ventas diarias de sus sucursales en un arreglo de secuencias A (separadas por ceros). Cada secuencia representa las ventas de una sucursal distinta (la primera secuencia corresponde a la Sucursal 0, la segunda a la Sucursal 1, etc.). Por otro lado, la gerencia tiene un arreglo normal B que contiene el objetivo de venta promedio diario esperado para cada sucursal.
int[] A = {0, 100, 120, 110, 0, 300, 100, 0, 450, 450, 0}; int[] B = {100, 250, 400}; int[] C = new int; (vacío, mismo tamaño que B)
Consigna: Recorrer el arreglo A. Por cada secuencia, calcular el promedio de ventas de esa sucursal. Luego, calcular la diferencia entre ese promedio obtenido y el objetivo estipulado para esa sucursal en el arreglo B. Guardar ese resultado final en la posición correspondiente del arreglo C y retornarlo.
*/
    public static final int SEPARADOR = 0;
    public static void main(String[] args) {
        int[] A = {0, 100, 120, 110, 0, 300, 100, 0, 450, 450, 0};
        int[] B = {100, 250, 400};

        int[] C = procesarSecuencia(A, B);

        mostrarArreglo(C);
    }

    public static int[] procesarSecuencia(int[] arrA, int [] arrB){
        int ini = 0, fin = -1;

        int contadorSucursal = 0;

        int[] arregloDiferencia = new int[arrB.length];

        while (ini < arrA.length && contadorSucursal < arrB.length){
            ini = buscarInicio(arrA, fin+1);

            if(ini < arrA.length){
                fin = buscarFin(arrA, ini);

                int promedio = calcularPromedio(arrA, ini, fin);

                int diferencia = promedio - arrB[contadorSucursal];

                arregloDiferencia[contadorSucursal] = diferencia;
                contadorSucursal++;
            }
        }
        return arregloDiferencia;
    }

    public static int calcularPromedio(int[] arr, int ini, int fin){
        int suma = 0;

        for(int i = ini; i <= fin; i++){
            suma = suma + arr[i];
        }

        // double promedioExacto = (double) suma / (fin - ini + 1);
        int promedio = suma / (fin - ini + 1);
        return promedio;
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
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + "|");
        }
        System.out.println();
    }
}