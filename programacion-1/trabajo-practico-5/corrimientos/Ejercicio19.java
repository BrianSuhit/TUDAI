public class Ejercicio19 {
/*
19. Hacer un programa que dado un arreglo de enteros de tamaño
10 que se encuentra cargado, solicite al usuario un número entero
y lo agregue al principio del arreglo (posición 0). Para ello tendrá
que realizar un corrimiento a derecha (se pierde el último valor del
arreglo) y colocar el número en el arreglo en la posición indicada.
*/
    public static final int TAM = 10;
    public static void main(String[] args) {
        
        int[] arreglo = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

        int posHueco = 0;

        int numero = validarNumero();
        corrimientoDerecha(arreglo, posHueco, numero);
        mostrarArreglo(arreglo);
    }

    public static void corrimientoDerecha(int[] arreglo, int posHueco, int numero) {
        for(int pos = TAM - 2; pos >= posHueco; pos--) {
            arreglo[pos + 1] = arreglo[pos];
        }
        arreglo[posHueco] = numero;
    }

    public static void mostrarArreglo(int[] arrenteros){
        for (int pos = 0; pos < TAM; pos++){
        System.out.println("arrenteros["+pos+"] -> "+arrenteros[pos]);
        }
    }

    public static int validarNumero(){
        int numero = 0;
        System.out.println("Ingrese un numero");
        numero = Utils.leerInt();
        return numero; 
    }
}
