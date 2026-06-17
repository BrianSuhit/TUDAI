public class Ejercicio16 {
/*
16. Hacer un programa que dada la matriz de secuencias de
caracteres definida y precargada, elimine de cada fila todas las
ocurrencias de una secuencia patrón dada por un arreglo de
caracteres de tamaño igual al tamaño de columnas de la matriz
(sólo tiene esa secuencia con separadores al inicio y al final). Al
eliminar en cada fila se pierden los valores haciendo los
corrimientos.
*/
    public static final char SEPARADOR = ' ';
    public static void main(String[] args) {

        char[][] matrizCaracteres = {
            {' ', 'h', 'o', 'l', 'a', ' ', ' ', 'm', 'u', 'n', 'd', 'o', ' ', ' ', 'p', 'a', 'z', ' ', ' ', ' '},
            {' ', ' ', 'j', 'a', 'v', 'a', ' ', 'e', 's', ' ', 'g', 'e', 'n', 'i', 'a', 'l', ' ', ' ', ' ', ' '},
            {' ', 'u', 'n', 'a', ' ', 'd', 'o', 's', ' ', 't', 'r', 'e', 's', ' ', 'c', 'u', 'a', ' ', ' ', ' '},
            {' ', ' ', ' ', 'a', ' ', 'b', 'c', ' ', 'd', 'e', 'f', ' ', 'g', 'h', ' ', 'i', ' ', ' ', ' ', ' '}
        };

        char[] arregloPatron = {' ', ' ', ' ', ' ', ' ', 'd', 'o', 's', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '};

        int iniP = buscarInicio(arregloPatron, 0);
        int finP = buscarFin(arregloPatron, iniP);

        for(int posFila = 0; posFila < matrizCaracteres.length; posFila++){
            int ini = 0, fin = -1;
                
            while(ini < matrizCaracteres[posFila].length){
                ini = buscarInicio(matrizCaracteres[posFila], fin + 1);

                if(ini < matrizCaracteres[posFila].length){
                    fin = buscarFin(matrizCaracteres[posFila], ini);

                    int tamaño = fin - ini + 1;

                    if(sonIugales(matrizCaracteres[posFila], ini, fin, arregloPatron, iniP, finP)){
                        
                        eliminarSecuencia(matrizCaracteres[posFila], tamaño, ini);
                        fin = fin - tamaño;
                    }
                }
            }
        }

        System.out.println("matriz procesada:");
        imprimirMatriz(matrizCaracteres);
    }

    public static boolean sonIugales(char[] arr, int ini, int fin, char[] arrP, int iniP, int finP){
        if(fin - ini + 1 != finP - iniP + 1){
            return false;
        }

        while(ini <= fin && arr[ini] == arrP[iniP]){
            ini++;
            iniP++;
        }
        return ini > fin;
    }

    public static void eliminarSecuencia(char[] arr, int tamaño, int ini){
        for(int i = 0; i < tamaño; i++){
            corrimientoIzquierda(arr, ini);
        }
    }

    public static void corrimientoIzquierda(char[] arr, int pos){
        for(int i = pos; i < arr.length - 1; i++){
            arr[i] = arr[i + 1];
        }
    }

    public static int buscarInicio(char[] arr, int pos){
        while(pos < arr.length  && arr[pos] == SEPARADOR){
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

    public static void imprimirMatriz(char[][] mat) {
        for (int fila = 0; fila < mat.length; fila++) {
            
            for (int columna = 0; columna < mat[fila].length; columna++) {
                System.out.print(mat[fila][columna] + "\t");
            }            
            System.out.println(""); 
        }
    }
}
