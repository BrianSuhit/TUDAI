public class CompresionDeImagen {
/*
5. Compresión de imágenes
Un dispositivo que toma imágenes de un fenómeno natural está corriendo sobre una plataforma tecnológica
con recursos limitados. Cada imagen (representada por una matriz de NxM) está compuesta por píxeles con
valores entre 0 y 255. Se desea implementar un algoritmo para comprimir aquellas porciones de la imagen
distintas del color negro (0 en la escala de valores del pixel). Se pide realizar un programa en JAVA que, dada
una matriz de tamaño NxM, para cada secuencia delimitada por uno o mas pixeles de color negro (valor 0)
con más de X repeticiones de un valor de píxel (todos los elementos de la secuencia deben ser iguales),
comprima la secuencia poniendo en la primera posición el valor negado de la cantidad de ocurrencias y a
continuación el valor del pixel que se repite. Deberá informar cuánto espacio de almacenamiento se ha
ahorrado con este algoritmo y cuál fila tuvo una mayor compresión. Cada fila de la matriz empieza y termina
con un separador 0 (color negro). Implementar usando las buenas prácticas de programación estructurada
vistas en la cátedra.
El ahorro de almacenamiento es 6+2+3+3 = 14 enteros (int). Si cada int ocupa 4 bytes como es en JAVA, se
ahorraron en total 56 bytes. La fila más comprimida fue la fila 0.
*/
    public static final int SEPARADOR = 0;
    public static void main(String[] args) {
        int[][] matriz = {
            {0, 67, 67, 67, 67, 67, 67, 67, 67, 0, 14, 0, 33, 33, 33, 33, 0, 5, 98, 0},
            {0, 23, 45, 45, 45, 45, 23, 0, 88, 88, 88, 88, 88, 0, 0, 0, 78, 78, 0, 0},
            {0, 0, 0, 45, 45, 45, 0, 45, 45, 45, 45, 45, 0, 45, 45, 0, 45, 0, 0, 0}
        };

        int X = 3;

        procesarMatriz(matriz, X);
    }

    public static void procesarMatriz(int[][] mat, int X){
        int filaMayorPixeles = 0;
        int totalPixeles = 0;
        int contadorPixeles = -1;
        for(int fila = 0; fila < mat.length; fila++){

            int contador = procesarFila(mat[fila], X);

            if(contador > contadorPixeles){
                contadorPixeles = contador;
                filaMayorPixeles = fila;
            }
            totalPixeles += contador;
        }
        System.out.println("cantidad total de pixeles comprimidos ( parseado a byte ) fue: " + totalPixeles);
        System.out.println("y la fila con mas pixeles comprimidos fue: " + filaMayorPixeles);
    }

    public static int procesarFila(int[] fila, int X){
        int ini = 0, fin = -1, tamByte = 4, pixelesComprimidos = 0; 

        while(ini < fila.length){
            ini = buscarInicio(fila, fin + 1);

            if(ini < fila.length){
                fin = buscarFin(fila, ini);

                int tam = fin - ini + 1;
                if(tam > X && sonTodosIguales(fila, ini, fin)){

                    fila[ini] = -tam;
                    int huecos = tam - 2;

                    for(int i = 0; i < huecos; i++){
                        corrimientoIzquierda(fila, ini + 2);
                    }
                    fin = fin - huecos;
                    pixelesComprimidos += huecos;
                }
            }
        }
        return pixelesComprimidos * tamByte;
    }

    public static void corrimientoIzquierda(int[] arr, int pos){
        for(int i = pos; i < arr.length - 1; i++){
            arr[i] = arr[i + 1];
        }
    }

    public static boolean sonTodosIguales(int[] arregloImagen, int inicio, int fin) {
        while (inicio < fin && arregloImagen[inicio] == arregloImagen[inicio+1]) {
            inicio++;
        }
        return (inicio == fin);
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
