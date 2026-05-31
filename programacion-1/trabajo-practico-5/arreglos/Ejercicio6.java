public class Ejercicio6 {
/*
6. Hacer un programa que permita obtener las posiciones del menor
y el mayor elemento de un arreglo de enteros.
*/
    public static final int TAM = 10;

    public static void main(String[] args) {

        int[] arreglo = {2, 5, 9, 8, 9, 6, 10, 7, 5, 4};
        
        System.out.println("la posicion mayor es: " + buscarPosMayor(arreglo));
        System.out.println("el posicion menor es: " + buscarPosMenor(arreglo));
    }

    public static int buscarPosMayor(int[] arreglo){
        int posMayor = 0;
        for(int pos = 0; pos < TAM; pos++){
            if(arreglo[pos] > arreglo[posMayor]){
                posMayor = pos;
            }
        }
        return posMayor;
    }

    public static int buscarPosMenor(int[] arreglo){
        int posMenor = 0;
        for(int pos = 0; pos < TAM; pos++){
            if(arreglo[pos] < arreglo[posMenor]){
                posMenor = pos;
            }
        }
        return posMenor;
    }
}
