public class compresionDeImagen {
/*
Compresión de imagen
Un dispositivo que toma imágenes de un fenómeno natural está corriendo sobre una plataforma tecnológica
con recursos limitados. Cada imagen (representada por una matriz de NxM) está compuesta por píxeles con
valores entre 0 y 255. Se desea implementar un algoritmo de compresión que comprima aquellas porciones
de la imagen distintas del color negro (0 en la escala de valores del pixel). Se debe implementar la solución
para un arreglo (luego dicha solución se reutilizará en un futuro para cada fila de la matriz). Para ello, se pide
realizar un programa en JAVA que, dado un arreglo de tamaño M, para cada secuencia delimitada por uno o
mas pixeles de color negro (valor 0) con más de X repeticiones de un valor de píxel (todos los elementos de la
secuencia deben ser iguales), comprima la secuencia poniendo en la primera posición el valor negado de la
cantidad de ocurrencias y a continuación el valor del pixel que se repite. El arreglo empieza y termina con un
separador 0 (color negro). Implementar usando las buenas prácticas de programación estructurada vistas en
la cátedra.
Ejemplo:
Arreglo que tiene una fila de la imagen:
0 67 67 67 67 67 67 67 67 0 14 0 33 33 33 33 0 5 98 0
El arreglo quedaría de la siguiente forma, para un X=3:
0 -8 67 0 14 0 -4 33 0 5 98 0 0 0 0 0 0 0 0 0
*/

    public static final int SEPARADOR = 0;
    public static final int X = 3;

    public static void main(String[] args) {
        
        int ini = 0;
        int fin = -1;

        int[] arreglo = {0, 67, 67, 67, 67, 67, 67, 67, 67, 0, 14, 0, 33, 33, 33, 33, 0, 5, 98, 0};

        while(ini < arreglo.length){
            ini = buscarInicio(arreglo, fin + 1);

            if(ini < arreglo.length){
                fin = buscarFin(arreglo, ini);

                int tamanio = fin - ini + 1;

                if(tamanio > X && sonTodosIguales(arreglo, ini, fin)){

                    for(int i = 0; i < tamanio - 2; i++){
                        corrimientoIzquierda(arreglo, ini);
                    }
                    arreglo[ini] = -tamanio;
                    fin = ini + 1; 
                }
            }
        }
    }

    // Tu método intacto
    public static void corrimientoIzquierda(int[] arr, int posElim){
        for(int pos = posElim; pos < arr.length - 1; pos++){
            arr[pos] = arr[pos + 1];
        }
    }

    public static boolean sonTodosIguales(int[] arr, int ini, int fin){
        while(ini < fin && arr[ini] == arr[ini + 1]){
            ini++;
        }
        return ini == fin; 
    }

    // Tus métodos intactos
    public static int buscarInicio(int[] arr, int pos) {
        while (pos < arr.length && arr[pos] == SEPARADOR) {
            pos++;
        }
        return pos;
    }

    public static int buscarFin(int[] arr, int ini){
        while(ini < arr.length && arr[ini] != SEPARADOR){
            ini++;
        }
        return ini - 1;
    }
}
