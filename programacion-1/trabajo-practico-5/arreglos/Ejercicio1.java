public class Ejercicio1{
/*
1. Cargar un arreglo de tamaño 15, pidiendo el ingreso por teclado
de valores entre 1 y 12. Luego mostrar cómo quedó cargado.
*/
    public static final int MIN = 1;
    public static final int MAX = 12;
    public static final int TAM = 15;

    public static void main(String[] args) {
       
        int[] arreglo = new int[TAM];

        cargarArreglo(arreglo);
        mostrarArreglo(arreglo);
    }
    
    public static void cargarArreglo(int[] arrenteros){
        for ( int pos = 0; pos < arrenteros.length; pos++){

            arrenteros[pos] = validarNumero();
        }
    }


    public static void mostrarArreglo(int[] arrenteros){
        for (int pos = 0; pos < arrenteros.length; pos++){
        System.out.println("arrenteros["+pos+"] -> "+arrenteros[pos]);
        }
    }

    public static int validarNumero(){

        int numero = MIN -1;
            
        while(numero < MIN || numero > MAX){
            System.out.println("Ingrese un numero entre " + MIN + " y " + MAX);
            numero = Utils.leerInt();
        }
        return numero; 
    }
}