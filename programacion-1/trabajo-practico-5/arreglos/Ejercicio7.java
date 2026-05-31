public class Ejercicio7 {
/*
7. Hacer un programa que dado un arreglo de caracteres de tamaño
MAX que se encuentra cargado, invierta el orden del contenido.
*/
    public static final int TAM = 5;

    public static void main(String[] args) {

        char[] arreglo = {'a', 'b', 'c', 'd', 'e'};

        invertirArreglo(arreglo);
        mostrarArreglo(arreglo);
    }

    public static void mostrarArreglo(char[] arrenteros){
        for (int pos = 0; pos < TAM; pos++){
        System.out.println("arrenteros["+pos+"] -> "+arrenteros[pos]);
        }
    }

    public static void invertirArreglo(char[] arreglo){
        for(int pos = 0; pos <  TAM / 2; pos++){

            int derecho = (TAM - 1) - pos;
        
            char aux = arreglo[pos];
            arreglo[pos] = arreglo[derecho];
            arreglo[derecho] = aux;
        }
    }
}
