public class Ejercicio34 {
/*
34. Se tiene un arreglo de enteros con secuencias de números
entre 1 y 9, separadas por 0. El arreglo está precargado, y
además empieza y termina con uno o más separadores 0. Hacer
un programa que permita obtener a través de métodos la posición
de inicio y la posición de fin de la secuencia ubicada a partir de
una posición entera ingresada por el usuario. Finalmente, si
existen imprima por pantalla ambas posiciones obtenidas.
*/
    public static final int SEPARADOR = 0;
    public static void main(String[] args) {
        
        int[] arreglo = {0, 0, 5, 8, 9, 0};

        int ini = 0;
        int fin = -1;

        System.out.println("Ingrese una posicion");
        int posIngresada = Utils.leerInt();

        ini = buscarInicio(arreglo, posIngresada);

        if( posIngresada < arreglo.length && ini == posIngresada){
            fin = buscarFin(arreglo, ini);
            System.out.println("la posicion de inicio es: " + ini + " y la posicion de fin es: " + fin);
        }
        else{
            System.out.println("No existe secuencia en la posicion ingresada");
        }
    }

    public static int buscarInicio(int[] arr, int pos) {

        while (pos < arr.length && arr[pos] == SEPARADOR) {
            pos++;
        }

        return pos;
    }

    public static int buscarFin(int[] arr, int ini) {
        while (ini < arr.length && arr[ini] != SEPARADOR) {
            ini++;
        }

        return ini - 1;
    }

    public static void mostrarArreglo(int[] arr) {
        for (int pos = 0; pos < arr.length; pos++)
            System.out.print(" | " + arr[pos]);
        System.out.println();
    }
}
