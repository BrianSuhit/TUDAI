public class Ejercicio10 {
/*
Pedir por consola el ingreso de 10 números enteros positivos.
Contar cuántas veces se ingresaron números pares y mostrarlo
por pantalla.
*/
    public static void main(String[] args) {
        
        int numero = 0;
        int suma = 0;

        final int MIN = 1; // habia un 0, eran 11 numeros, pedia 10
        final int MAX = 10;


        for(int i = MIN; i <= MAX; i++){
            System.out.println("ingrese un numero positivo");
            numero = Utils.leerInt();

            if(numero % 2 == 0){
                suma++;
            }
        }
        System.out.println("se ingresaron: " + suma + " pares");
    }
}
