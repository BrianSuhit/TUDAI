public class Recuperatorio2026 {
/*
Un fabricante de figuritas quiere automatizar la incorporación de Extra Stickers a los sobres de figuritas del Mundial 2026. Para garantizar la aleatoriedad, dicho fabricante almacena en una matriz de enteros F las figuritas que debe contener cada sobre. En la matriz F, cada fila representa una caja de sobres de figuritas. Dentro de una fila, las figuritas de un mismo paquete se agrupan en secuencias separadas por números negativos y ordenadas de forma ascendente. La cantidad de sobres por caja y la cantidad de figuritas que vienen en cada sobre no son siempre las mismas.

En el siguiente ejemplo, la matriz F contiene 3 cajas (filas) de sobres de figuritas. La primera caja contiene 3 sobres y el primero de ellos contiene las figuritas 7, 14, 22, 34, 55 y 66.

[ -2 |  7 | 14 | 22 | 34 | 55 | 66 | -3 | -2 |  2 | 24 | 38 | 44 | 67 | 93 | -5 | -1 |  9 | 12 | 15 | 45 | 48 | 78 | -8 | -9 | -6 | -8 ]
[ -5 | -1 |  2 |  5 |  8 | 39 | -7 | 44 | 54 | 85 | 96 | 99 | -1 |  2 |  9 | 24 | 36 | 88 | 94 | -3 |  1 | 15 | 18 | 63 | -3 | -4 | -1 ]
[ -2 | 12 | 16 | 25 | 28 | 77 | 79 | 96 | -9 | 54 | 58 | 59 | 62 | 72 | 73 | -3 | -3 |  7 |  8 | 16 | 26 | 37 | 48 | -2 | -2 | -7 |  9 ]

Las Extra Stickers son figuritas cuyo número es múltiplo de 10 (ej. 10, 20, 30, etc). Además, existen figuritas brillantes (escudos, copas, campeones históricos, etc.) cuyo número puede variar, pero siempre es múltiplo de un número B.

Se pide implementar un programa en Java que incorpore figuritas Extra Stickers sólo en aquellas cajas indicadas en un arreglo C. El arreglo C es un arreglo de enteros en donde se indican las cajas (filas) que deberán contener sobres con Extra Stickers.

Es importante destacar que para incorporar Extra Stickers en un sobre no debe haber figuritas brillantes y que la incorporación debe mantener el orden ascendente dentro del sobre.
Además se debe informar la cantidad total de figuritas Extra Stickers agregadas en la matriz.

La figurita Extra Sticker que se agrega es determinada de forma aleatoria para cada sobre con la siguiente función: public static int obtenerExtraStickerAleatorio() (no es necesario implementarla).

Siguiendo el ejemplo anterior, con un arreglo C = {0, 2} y un B=5 la matriz F resultante sería:

[ -2 |  7 | 14 | 22 | 34 | 55 | 66 | -3 | -2 |  2 | 24 | 30 | 38 | 44 | 67 | 93 | -5 | -1 |  9 | 12 | 15 | 45 | 48 | 78 | -8 | -9 | -6 | -8 ]
[ -5 | -1 |  2 |  5 |  8 | 39 | -7 | 44 | 54 | 85 | 96 | 99 | -1 |  2 |  9 | 24 | 36 | 88 | 94 | -3 |  1 | 15 | 18 | 63 | -3 | -4 | -1 ]
[ -2 | 12 | 16 | 25 | 28 | 77 | 79 | 96 | -9 | 54 | 58 | 59 | 60 | 62 | 72 | 73 | -3 | -3 |  7 |  8 | 16 | 26 | 37 | 48 | 50 | -2 | -2 ]

y debería informarse que se incorporaron 3 Extra Stickers.

IMPORTANTE: El ejemplo es meramente ilustrativo, la solución planteada debe ser válida para cualquier matriz F, valor B y arreglo C. Suponer que siempre existe lugar en el arreglo para insertar los Extra Stickers y que el arreglo C contiene números de filas válidos para la matriz F. Aplicar TODAS las buenas prácticas vistas en la materia. No usar estructuras auxiliares.

*/
    public static void main(String[] args) {
        int[][] matriz = {
                { -2, 7, 14, 22, 34, 55, 66, -3, -2, 2, 24, 38, 44, 67, 93, -5, -1, 9, 12, 15, 45, 48, 78, -8, -9, -6},
                { -5, -1, 2, 5, 8, 39, -7, 44, 54, 85, 96, 99, -1, 2, 9, 24, 36, 88, 94, -3, 1, 15, 18, 63, -3, -4, -1 },
                { -2, 12, 16, 25, 28, 77, 79, 96, -9, 54, 58, 59, 62, 72, 73, -3, -3, 7, 8, 16, 26, 37, 48, -2, -2, -7, -9}
        };
        int[] arrC = { 0, 2 };
        int numeroB = 5;
        mostrarMatriz(matriz);
        int cantidadExtraStickers = agregarExtraStickers(matriz, arrC, numeroB);
        System.out.println("La cantidad de Extra Stickers agregada fue: " + cantidadExtraStickers);
        mostrarMatriz(matriz);
    }

    public static int agregarExtraStickers(int[][] matriz, int[] arrC, int numeroB) {
        int cantidad = 0;
        int i = 0;

        while(i < arrC.length && arrC[i] >= 0){
            cantidad += agregarExtraStickersEnCaja(matriz[arrC[i]], numeroB);
            i++;
        } 
        return cantidad;
    }

    public static int agregarExtraStickersEnCaja(int[] fila, int numeroB) {
        int ini = 0;
        int fin = -1;
        int cantidad = 0;
        while (ini < fila.length) {
            ini = buscarInicio(fila, fin + 1);
            if (ini < fila.length) {
                fin = buscarFin(fila, ini);
                if (!tieneBrillante(fila, ini, fin, numeroB)) {
                    agregarExtraStickerASobre(fila, ini, fin);
                    fin++;
                    cantidad++;
                }
            }
        }
        return cantidad;
    }

    public static boolean tieneBrillante(int[] arr, int ini, int fin, int numeroB) {
        while (ini <= fin && arr[ini] % numeroB != 0)
            ini++;
        return ini <= fin;
    }

    public static void agregarExtraStickerASobre(int[] arr, int ini, int fin) {
        int extraSticker = obtenerExtraStickerAleatorio();
        int pos = obtenerPosicionDondeInsertar(arr, ini, fin, extraSticker);
        correrADerecha(arr, pos);
        arr[pos] = extraSticker;
    }

    public static void correrADerecha(int[] arr, int pos) {
        for (int i = arr.length - 1; i > pos; i--)
            arr[i] = arr[i - 1];
    }

    public static int obtenerPosicionDondeInsertar(int[] arr, int ini, int fin, int extraSticker) {
        while (ini <= fin && arr[ini] < extraSticker) {
            ini++;
        }
        return ini;
    }

    public static int obtenerExtraStickerAleatorio() {
        return (int) (Math.random() * 101) * 10;
    }

    public static int buscarInicio(int[] arr, int pos) {
        while (pos < arr.length && arr[pos] < 0)
            pos++;
        return pos;
    }

    public static int buscarFin(int[] arr, int pos) {
        while (pos < arr.length && arr[pos] >= 0)
            pos++;
        return pos - 1;
    }

    public static void mostrarArreglo(int[] arreglo) {
        for (int i = 0; i < arreglo.length; i++) {
            System.out.print(" | " + arreglo[i]);
        }
        System.out.println();
    }

    public static void mostrarMatriz(int[][] matriz) {
        for (int i = 0; i < matriz.length; i++)
            mostrarArreglo(matriz[i]);
    }
}
