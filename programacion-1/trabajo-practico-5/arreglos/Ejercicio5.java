public class Ejercicio5 {
/*
Hacer un programa que permita obtener el menor y el mayor
elemento de un arreglo de enteros.
*/
    public static final int TAM = 10;

    public static void main(String[] args) {
        int[] arreglo = {2, 5, 9, 8, 9, 6, 10, 7, 5, 4};

        System.out.println("el elemento mayor es: " + buscarMayor(arreglo));
        System.out.println("el elemento menor es: " + buscarMenor(arreglo));
    }

    public static int buscarMayor(int[] arreglo){
        int mayor = arreglo[0];
        for(int pos = 0; pos < TAM; pos++){
            if(arreglo[pos] > mayor){
                mayor = arreglo[pos];
            }
        }
        return mayor;
    }

    public static int buscarMenor(int[] arreglo){
        int menor = arreglo[0];
        for(int pos = 0; pos < TAM; pos++){
            if(arreglo[pos] < menor){
                menor = arreglo[pos];
            }
        }
        return menor;
    }
}
