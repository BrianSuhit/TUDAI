public class Ejercicio24 {
/*
24. Hacer un programa que elimine los valores pares en un arreglo.
*/
    public static final int TAM = 10;
    public static final int RED_FLAG = -1;

    public static void main(String[] args) {
        
        int[] arreglo = {1, 2, 3, 4, 3, 6, 3, 3, 9, 10};

        eliminarPares(arreglo);
        mostrarArreglo(arreglo);
    }

    public static void eliminarPares(int[] arreglo){
        int pos = 0;
        int limite = arreglo.length;

        while (pos < limite) {
            if(esPar(arreglo[pos])){
                corrimientoIzquierda(arreglo, pos);
                limite--;
            }
            else{
                pos++;
            }
        }
    }

    public static boolean esPar(int numero){
        return (numero % 2 == 0);
    }

    public static void corrimientoIzquierda(int[] arreglo, int posHueco) {
        for(int pos = posHueco; pos < TAM - 1; pos++){
            arreglo[pos] = arreglo[pos + 1];
        }
    }

    public static void mostrarArreglo(int[] arrenteros){
        for (int pos = 0; pos < arrenteros.length; pos++){
        System.out.println("arrenteros["+pos+"] -> "+arrenteros[pos]);
        }
    }
}
