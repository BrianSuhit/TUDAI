public class GondolasSupermercado {
/*
8. Góndolas de supermercado
Un supermercado organiza sus góndolas utilizando una matriz de NxM. La matriz representa una góndola
vista de frente en donde cada fila son sus estantes y las columnas la posición donde se ubica un determinado
producto. El valor almacenado en cada elemento de la matriz es el precio de cada producto. Cada estante
posee separadores que son representados en la matriz con uno o más ceros.
Por ejemplo en la siguiente matriz podemos ver una góndola de 3 estantes (filas). En la primera fila, se
encuentran los productos que cuestan $120, $250 y $80, luego dos separadores y otros productos.
El gerente desea ordenar el diseño de las góndolas y para ello solicitó un programa que indique cómo
quedaría la góndola si los grupos (secuencias) de productos que se encuentran ordenados
descendentemente, se invirtieran en orden ascendente. Además, desea conocer en cuáles estantes al menos
se reordenaron X grupos de productos.
Además, debe informar, para un X = 2, que en el estante 2 (fila 1) hubo al menos 2 reordenamientos.
*/
    public static final int SEPARADOR = 0;
    public static void main(String[] args) {
        int[][] matriz = {
            {0, 120, 250, 80, 0, 0, 620, 410, 645, 0, 0, 240, 960, 0, 0},
            {0, 250, 155, 90, 85, 0, 150, 625, 0, 0, 900, 750, 225, 0, 0},
            {0, 580, 550, 850, 0, 0, 220, 110, 0, 0, 150, 480, 690, 0, 0}
        };

        int X = 2;

        procesarMatriz(matriz, X);
        imprimirMatriz(matriz);
    }

    public static void procesarMatriz(int[][] mat, int X){
        for(int fila = 0; fila < mat.length; fila++){
            int contadorOrdenados = 0;
            
            contadorOrdenados = procesarEstante(mat[fila]);

            if(contadorOrdenados >= X){
                System.out.println("en el estante: " + fila + " hubo almenos: " + contadorOrdenados + " reordenamientos");
            }
        }
    }

    public static int procesarEstante(int[] fila){
        int ini = 0, fin = -1, contadorOrdenados = 0;

        while(ini < fila.length){
            ini = buscarInicio(fila, fin + 1);

            if(ini < fila.length){
                fin = buscarFin(fila, ini);

                if(esDescendente(fila, ini, fin)){
                    ordenarAscendente(fila, ini, fin);
                    contadorOrdenados++;
                }
            }
        }
        return contadorOrdenados;
    }

    public static void ordenarAscendente(int[] arr, int ini, int fin){
        int izq = ini, der = fin;

        while(izq < der){
            int aux = arr[izq];
            arr[izq] = arr[der];
            arr[der] = aux;
            izq++;
            der--;
        }
    }

    public static boolean esDescendente(int[] arr, int ini, int fin){
        int i = ini;
        while(i < fin && arr[i] > arr[i + 1]){
            i++;
        }
        return i == fin;
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

    public static void imprimirMatriz(int[][] mat) {
        for (int fila = 0; fila < mat.length; fila++) {
            
            for (int columna = 0; columna < mat[fila].length; columna++) {
                System.out.print(mat[fila][columna] + "\t");
            }            
            System.out.println(""); 
        }
    }
}
