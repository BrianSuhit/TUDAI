public class Ejercicio23 {
/*
23. Hacer un programa que inserte un elemento en un arreglo
(ordenado decrecientemente).
*/
    public static final int RED_FLAG = -1;
    public static void main(String[] args) {
        
        int[] arreglo = {90, 80, 50, 40, 10, 0, 0, 0, 0, 0};

        int numero = 60;

        int posicionEncontrada = buscarPosicion(arreglo, numero);

        if (posicionEncontrada != RED_FLAG) {
            corrimientoDerecha(arreglo, posicionEncontrada);
            arreglo[posicionEncontrada] = numero;
        }
        mostrarArreglo(arreglo);
    }

    public static void corrimientoDerecha(int[] arreglo, int posHueco) {
        for(int pos = arreglo.length - 2; pos >= posHueco; pos--) {
            arreglo[pos + 1] = arreglo[pos];
        }
    }

    public static int buscarPosicion(int[] arreglo, int numero){
        int pos = 0;
        while(pos < arreglo.length){
            if(arreglo[pos] < numero){
                return pos;
            }
            pos++;
        }
        return RED_FLAG;
    }

    public static void mostrarArreglo(int[] arrenteros){
        for (int pos = 0; pos < arrenteros.length; pos++){
        System.out.println("arrenteros["+pos+"] -> "+arrenteros[pos]);
        }
    }
}
