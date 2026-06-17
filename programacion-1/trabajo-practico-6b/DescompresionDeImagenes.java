public class DescompresionDeImagenes {
/*
7. Descompresión de imágenes
Un dispositivo que toma imágenes de un fenómeno natural está corriendo sobre una plataforma tecnológica
con recursos limitados. Cada imagen (representada por una matriz de NxM) está compuesta por píxeles con
valores entre 0 y 255. Se tiene implementado un algoritmo de compresión que comprime aquellas porciones
de la imagen distintas del color negro (0 en la escala de valores del pixel). Dicho algoritmo procede de la
siguiente manera: por cada una de las filas de la matriz, toma cada secuencia delimitada por uno o mas
pixeles de color negro (valor 0) con más de X repeticiones de un valor de píxel (para ser comprimida, todos
los elementos de la secuencia deben ser iguales), comprime la secuencia poniendo en la primera posición el
valor negado de la cantidad de ocurrencias y a continuación el valor del pixel que se repite. Cada fila de la
matriz empieza y termina con uno o más pixeles negros.
Se pide implementar el algoritmo de descompresión que restablezca la matriz original. Asumir que cada
fila posee suficientes lugares como para realizar la descompresión.
Además se debe informar la cantidad total de píxeles descomprimidos y la fila en la cual se encuentra
la mayor cantidad de píxeles descomprimidos (la primera, si hubiese más de una). En este ejemplo, la
cantidad total de píxeles descomprimidos fue 32 y la fila con más píxeles descomprimidos fue la fila 0.
*/
    public static final int SEPARADOR = 0;
    public static void main(String[] args) {
        
        int[][] matriz = {
            {0, -8, 67, 0, 14, 0, -4, 33, 0, 5, 98, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 25, 25, 0, -5, 3, 0, 25, 44, 44, 0, -4, 1, 0, 0, 0, 0, 0, 0},
            {0, 44, 44, 44, 0, -7, 15, 0, -4, 9, 0, 12, 0, 0, 0, 0, 0, 0, 0, 0}
        };

        int X = 3;

        procresarMatriz(matriz, X);
    }

    public static void procresarMatriz(int[][] mat, int tamImg){
        int fFilaMayorPixeles = 0;
        int totalPixeles = 0;
        int contadorPixeles = -1;
        for(int fila = 0; fila < mat.length; fila ++){

            int contador = procesarFilas(mat[fila], tamImg);

            if(contador > contadorPixeles){
                contadorPixeles = contador;
                fFilaMayorPixeles = fila;
            }
            totalPixeles += contador;
        }

        System.out.println("cantidad total de pixeles descomprimidos fue: " + totalPixeles);
        System.out.println("y la fila con mas pixeles descomprimidos fue: " + fFilaMayorPixeles);
    }

    public static int procesarFilas(int[] fila, int valor){
        int ini = 0, fin = -1, pixelesDescomprimidos = 0;

        while(ini < fila.length){
            ini = buscarInicio(fila, fin + 1);

            if(ini < fila.length){
                fin = buscarFin(fila, ini);

                if(fila[ini] < 0){

                    int tamReal = fila[ini] * -1;
                    int valorAgregar = fila[ini + 1];
                    int huecos = tamReal - 2;

                    for(int i = 0; i < huecos; i++){
                        corrimientoDerecha(fila, ini);
                    }
                    fin = fin + huecos; 

                    for(int k = ini; k <= fin; k++){
                        fila[k] = valorAgregar;
                    }
                    pixelesDescomprimidos += tamReal;
                }
            }
        }
        return pixelesDescomprimidos;
    }

    public static void agrandarSecuencia(int[] arr, int tam, int pos, int valorAgregar){
        for(int i = 0; i < tam; i++){
            corrimientoDerecha(arr, pos);
            arr[i] = valorAgregar;
        }
    }

    public static void corrimientoDerecha(int[] arr, int pos){
        for(int i = arr.length - 1; i > pos; i--){
            arr[i] = arr[i - 1];
        }
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
        return pos -1;
    }
}
