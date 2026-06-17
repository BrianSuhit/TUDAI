public class Ejercicio14 {
/*
14. Hacer un programa que dada la matriz de secuencias de
caracteres definida y precargada, permita encontrar por cada fila
la posición de inicio y fin de la anteúltima secuencia (considerar
comenzar a buscarla a partir de la última posición de la fila).
*/
    public static final char SEPARADOR = ' ';
    public static void main(String[] args) {

        char[][] matrizCaracteres = {
            {' ', 'h', 'o', 'l', 'a', ' ', ' ', 'm', 'u', 'n', 'd', 'o', ' ', ' ', 'p', 'a', 'z', ' ', ' ', ' '},
            {' ', ' ', 'j', 'a', 'v', 'a', ' ', 'e', 's', ' ', 'g', 'e', 'n', 'i', 'a', 'l', ' ', ' ', ' ', ' '},
            {' ', 'u', 'n', 'a', ' ', 'd', 'o', 's', ' ', 't', 'r', 'e', 's', ' ', 'c', 'u', 'a', ' ', ' ', ' '},
            {' ', ' ', ' ', 'a', ' ', 'b', 'c', ' ', 'd', 'e', 'f', ' ', 'g', 'h', ' ', 'i', ' ', ' ', ' ', ' '}
        };

        for(int fila = 0; fila < matrizCaracteres.length; fila++){

            int posicionFondo = matrizCaracteres[fila].length - 1;

            int finUltima = buscarFinInverso(matrizCaracteres[fila], posicionFondo);
            int iniUltima = buscarInicioInverso(matrizCaracteres[fila], finUltima);

            int finAnteultima = buscarFinInverso(matrizCaracteres[fila], iniUltima - 1);
            int iniAnteultima = buscarInicioInverso(matrizCaracteres[fila], finAnteultima);

            System.out.println("En la fila " + fila + " la anteúltima va de " + iniAnteultima + " a " + finAnteultima);
        }
    }

    public static int buscarFinInverso(char[] arr, int pos) {
        while (pos >= 0 && arr[pos] == SEPARADOR) {
            pos--;
        }
        return pos;
    }

    public static int buscarInicioInverso(char[] arr, int pos){
        while( pos >= 0 && arr[pos] != SEPARADOR){
            pos--;
        }
        return pos + 1;
    }
}
