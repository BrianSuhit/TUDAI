public class Ejercicio21 {
/*
21. Hacer un programa que dado un arreglo de enteros de tamaño
10 que se encuentra precargado, solicite al usuario un número
entero y elimine todas las ocurrencia de número en el arreglo.
Mientras exista (en cada iteración tiene que buscar la posición
dentro del arreglo) tendrá que usar la posición para realizar un
corrimiento a izquierda (quedarán tantas copias de la última
posición del arreglo como cantidad de ocurrencias del número).
*/

    public static final int TAM = 10;
    public static final int RED_FLAG = -1;
    public static void main(String[] args) {

        // int[] arreglo = {1, 2, 3, 4, 32, 6, 7, 8, 9, 10};
        int[] arreglo = {1, 2, 3, 4, 3, 6, 3, 3, 9, 10};

        int numero = validarNumero();

        int posEncontrada = buscarPosicion(arreglo, numero);
        
        while(posEncontrada != RED_FLAG){
            corrimientoIzquierda(arreglo, posEncontrada);
            posEncontrada = buscarPosicion(arreglo, numero);
        }
        mostrarArreglo(arreglo);
    }

        public static int buscarPosicion(int[] arreglo, int numero){
        int pos = 0;
        while(pos < TAM){
            if(numero == arreglo[pos]){
                return pos;
            }
            pos++;
        }
        return RED_FLAG;
    }


    public static void corrimientoIzquierda(int[] arreglo, int posHueco) {
        for(int pos = posHueco; pos < TAM - 1; pos++){
            arreglo[pos] = arreglo[pos + 1];
        }
    }

    public static int validarNumero(){
        int numero = 0;
        System.out.println("Ingrese un numero");
        numero = Utils.leerInt();
        return numero; 
    }

    public static void mostrarArreglo(int[] arrenteros){
        for (int pos = 0; pos < TAM; pos++){
        System.out.println("arrenteros["+pos+"] -> "+arrenteros[pos]);
        }
    }
}
