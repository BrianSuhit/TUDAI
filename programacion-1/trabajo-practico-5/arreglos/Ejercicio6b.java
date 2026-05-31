public class Ejercicio6b {

    public static final int TAM = 4;

    public static void main(String[] args) {
        
        //            0;  1;  2;  3;
        int[] arr = {10, 20, 30, 40};

        // int aux = arr[0];
        // arr[0] = arr[3];
        // arr[3] = aux;

        invertirArreglo(arr);
        mostrarArreglo(arr);
    }

    public static void mostrarArreglo(int[] arrenteros){
        for (int pos = 0; pos < TAM; pos++){
        System.out.println("arrenteros["+pos+"] -> "+arrenteros[pos]);
        }
    }

    public static void invertirArreglo(int[] arreglo){

        for(int pos = 0; pos <  TAM / 2; pos++){

            int derecho = (TAM - 1) - pos;
            
            int aux = arreglo[pos];
            arreglo[pos] = arreglo[derecho];
            arreglo[derecho] = aux;
        }
    }
}
