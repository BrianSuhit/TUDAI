public class RendimientoDeSucursales {

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
        int tamaño = fin - ini + 1;
        int suma = 0;

        for(int i = ini; i <= fin; i++){
            suma = suma + arr[i];
        }

        int promedio = suma / tamaño; /* ahorro de calcular tamaño arriba: int promedio = suma / fin - ini + 1; */
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