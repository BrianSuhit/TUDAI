public class Ejercicio20 {
/*
20. Hacer un programa que dado un arreglo de enteros de tamaño
10 que se encuentra precargado, solicite al usuario un número
entero y elimine la primera ocurrencia del número (un número
igual) en el arreglo (si existe). Para ello tendrá que buscar la
posición y si está, realizar un corrimiento a izquierda (queda una
copia de la última posición del arreglo en la anteúltima posición).
*/

    public static final int TAM = 10;
    public static final int RED_FLAG = -1;
    public static void main(String[] args) {
        
        int[] arreglo = {1, 2, 3, 4, 32, 6, 7, 8, 9, 10};

        int numero = validarNumero();

        int posEncontrada = buscarPosicion(arreglo, numero);

        if (posEncontrada != RED_FLAG) {
            corrimientoIzquierda(arreglo, posEncontrada);
            mostrarArreglo(arreglo);
        }
        else{
            System.out.println("NO existe el número en el arreglo");
        }
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
