public class Ejercicio18 {
/*
18. Hay dos matrices MAT1 y MAT2 de secuencias de caracteres
letras separados por espacios de tamaño MAXF x MAXC que
están precargadas. Ambas matrices están precargadas y cada fila
empieza y termina con caracteres espacios. Además se tiene el
siguiente método:
Un método que retorna el índice inicial de la secuencia de
mayor tamaño de un arreglo de secuencias (de caracteres
letras minúsculas separados por espacios) de tamaño
MAXFIL.
Se pide realizar un programa que:
a. Contenga la definición de los encabezados de los métodos
de carga de la matriz y del método mencionado en el
enunciado (se supone que existen y no se requiere
implementarlos).
b. Para MAT1 y MAT2 elimine de cada secuencia el primer
carácter vocal.
c. Para MAT1 agregue al principio de cada secuencia el primer
carácter de la secuencia de mayor tamaño de dicha fila.
Considere agregar un espacio al final de la fila para
mantener la estructura de secuencia delimitada por
separadores espacio.
d. En cada fila, si se verifica que la secuencia de mayor
tamaño de la fila para MAT1 es mayor que la primera
secuencia en dicha fila para MAT2, las intercambie (la que
está en MAT1 pasa a MAT2 y la que está en MAT2 pasa a
MAT1) sin usar estructuras auxiliares (otros arreglos o
matrices).
e. Para un valor de fila ingresado por el usuario verifique e
imprima si la primera secuencia de MAT1 en dicha fila es
igual a la primera secuencia de MAT2 en dicha fila.
*/

    public static final char SEPARADOR = ' ';
    public static void main(String[] args) {
        
        char[][] MAT1 = {
            {' ', 'h', 'o', 'l', 'a', ' ', ' ', 'm', 'u', 'n', 'd', 'o', ' ', ' ', 'p', 'a', 'z', ' ', ' ', ' '},
            {' ', ' ', 'j', 'a', 'v', 'a', ' ', 'e', 's', ' ', 'g', 'e', 'n', 'i', 'a', 'l', ' ', ' ', ' ', ' '},
            {' ', 'u', 'n', 'a', ' ', 'd', 'o', 's', ' ', 't', 'r', 'e', 's', ' ', 'c', 'u', 'a', ' ', ' ', ' '}
        };

        char[][] MAT2 = {
            {' ', 's', 'o', 'l', ' ', ' ', 'l', 'u', 'n', 'a', ' ', ' ', 'm', 'a', 'r', ' ', ' ', ' ', ' ', ' '},
            {' ', ' ', 'j', 'a', 'v', 'a', ' ', 'e', 's', ' ', 'd', 'u', 'r', 'o', ' ', ' ', ' ', ' ', ' ', ' '},
            {' ', 'u', 'n', 'a', ' ', 'd', 'o', 's', ' ', 't', 'r', 'e', 's', ' ', 'c', 'u', 'a', ' ', ' ', ' '}
        };

        // INCISO B
        procesarMatriz(MAT1);
        procesarMatriz(MAT2);

        // INCISO E
    }

    public static void procesarMatriz(char[][] matriz){

        for(int fila = 0; fila < matriz.length; fila++){
            int ini = 0, fin = -1;

            while(ini < matriz[fila].length){
                ini = buscarInicio(matriz[fila], fin + 1);

                if(ini < matriz[fila].length){
                    fin = buscarFin(matriz[fila], ini);

                    int posVocal = esPrimeraVocal(matriz[fila], ini, fin);

                    if(posVocal <= fin){
                        corrimientoIzquierda(matriz[fila], posVocal);
                        fin = fin - 1;
                    }
                }
            }

        }
    }

    public static int esPrimeraVocal(char[] arr, int ini, int fin){                
        while(ini <= fin && !esVocal(arr[ini])){
            ini++;
        }
        return ini;
    }

    public static boolean esVocal(char letra){
        switch (letra) {
            case 'a': case 'e': case 'i': case 'o': case 'u':
                return true;
            default:
                return false;
        }
    }

    public static void corrimientoIzquierda(char[] arr, int pos){
        for(int i = pos; i < arr.length - 1; i++){
            arr[i] = arr[i + 1];
        }
    }

    public static int buscarInicio(char[] arr, int pos){
        while(pos < arr.length && arr[pos] == SEPARADOR){
            pos++;
        }
        return pos;
    }

    public static int buscarFin(char[] arr, int pos){
        while(pos < arr.length && arr[pos] != SEPARADOR){
            pos++;
        }
        return pos - 1;
    }
}
