public class FrecuenciasCardiacas {
/*

*/
    public static int SEPARADOR = 0;
    public static void main(String[] args) {
        int E = 20;

        int[] F = {2, 3, 1, 5};

        int[][] M = {
            {-6, 12, 26, 20, 24, 18, -9, -3, 51, 17, 83, 50, -1, 69, 74, 58, -6, 25, 33, 34, -8, 10, 25, 25, 44, -9},
            {-1,  -2, 85, 86, 88, -9, -5, 12, 15, 18, 20, 35, 38, -7, 60, 61, 64, 50, -5, 18, 18, -8, 77, 62, 99, -2},
            {-4, 13, 20, 19, 31, 37, -5, -6, -8, 26, 28, 40, 39, -2, 36, 38, 34, 32, -9, 38, 15, -8, 12, 25, 20, -6},
            {-7, 85, 58, 57, 96, -5, 36, 42, 52, 41, -5, 25, 28, 36, 40, -8, 63, 66, 70, -6, 28, 21, 16, 23, 17, -3}
        };

        procesarMatriz(M,F,E);
    }

    public static void procesarMatriz(int[][] mat, int[] arregloF, int E){
        int totalEliminadas = 0;
        for(int fila = 0; fila < mat.length; fila++){
            totalEliminadas += procesarFila(mat[fila], arregloF[fila], E);
        }
        System.out.println("el total de frecuencias eliminadas fue: " + totalEliminadas);
    }

    public static int procesarFila(int[] fila, int pos, int valor){
        int ini = 0, fin = -1, contadorEliminadas = 0, contadorSecuencias = 0;
        boolean encontreSecuencia = false;

        while(ini < fila.length && !encontreSecuencia){
            ini = buscarInicio(fila, fin + 1);

            if(ini < fila.length){
                fin = buscarFin(fila, ini);
                contadorSecuencias++;

                if(contadorSecuencias == pos){
                    contadorEliminadas += ModificarSecuencia(fila, ini, fin, valor);
                    encontreSecuencia = true;
                    fin -= contadorEliminadas;
                }
            }
        }
        return contadorEliminadas;
    }

    public static int ModificarSecuencia(int[] arr, int ini, int fin, int valor){
        int i = ini, eliminadasEnSecuencia = 0;

        while(i <= fin){
            if(arr[i] < valor){
                corrimientoIzquierda(arr, i);
                fin--;
                eliminadasEnSecuencia++;
            }else{
                arr[i] -= valor;
                i++;
            }
        }
        return eliminadasEnSecuencia;
    }

    public static void corrimientoIzquierda(int[] arr, int pos){
        for(int i = pos; i < arr.length - 1; i++){
            arr[i] = arr[i + 1];
        }
    }

    public static int buscarInicio(int[] arr, int pos){
        while(pos < arr.length && arr[pos] < SEPARADOR){
            pos++;
        }
        return pos;
    }

    public static int buscarFin(int[] arr, int pos){
        while(pos < arr.length && arr[pos] >= SEPARADOR){
            pos++;
        }
        return pos - 1;
    }
}
