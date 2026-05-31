public class Ejercicio35 {
/*
35. Hacer un programa que dado el arreglo definido y precargado,
y un número entero ingresado por el usuario, copie de forma
continua las secuencias de tamaño igual al número ingresado en
otro arreglo de iguales características e inicializado con 0. La
copia en este último arreglo deben comenzar desde el principio
del mismo.
*/    
    public static final int SEPARADOR = 0;

    public static void main(String[] args){
            System.out.println("ingrese un numero");
            int numero = Utils.leerInt();

            int[] arregloA = {0, 0, 5, 8, 9, 0, 2, 2, 0, 15, 12, 6, 0, 1, 0};

            int[] arregloB = new int[arregloA.length];
            
            int ini = 0;
            int fin = -1;
            int proximoLugarB = 0;

            while(ini < arregloA.length){
                ini = buscarInicio(arregloA, fin + 1);

                if(ini < arregloA.length){
                    fin = buscarFin(arregloA, ini);

                    int tamanio = fin - ini + 1;

                    if(tamanio == numero){

                        proximoLugarB = copiarSecuencia(arregloA, arregloB, ini, fin, proximoLugarB);
                    }
                }
            }
            mostrarArreglo(arregloB);
    }

    public static int copiarSecuencia(int[] arregloA, int[] arregloB, int ini, int fin, int indexB){

        for(int i = ini; i <= fin; i++){
            arregloB[indexB] = arregloA[i];
            indexB++;
        }
        return indexB;
    }

    public static void mostrarArreglo(int[] arr) {
        for (int pos = 0; pos < arr.length; pos++)
            System.out.print(" | " + arr[pos]);
        System.out.println();
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
}
