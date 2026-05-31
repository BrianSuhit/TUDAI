public class Ejercicio22 {
/*
22. Suponer a partir de lo resuelto en el ejercicio anterior que el
elemento a eliminar coincide con el último que hay en el arreglo.
¿Qué pasa en este caso? ¿Cómo daría una solución al problema?
*/
    public static final int TAM = 10;
    public static final int RED_FLAG = -1;

    public static void main(String[] args) {
        
        int[] arreglo = {1, 2, 3, 4, 3, 6, 3, 3, 9, 10};

        int numero = validarNumero();

        if(buscarPosicion(arreglo, numero) != RED_FLAG){
            corrimientoIzquierda(arreglo, buscarPosicion(arreglo, numero));
            mostrarArreglo(arreglo);
        }else{
            System.out.println("NO existe el número en el arreglo");
        }

    }
    
    public static void corrimientoIzquierda(int[] arreglo, int posHueco) {
        for(int pos = posHueco; pos < TAM - 1; pos++){
            arreglo[pos] = arreglo[pos + 1];
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
