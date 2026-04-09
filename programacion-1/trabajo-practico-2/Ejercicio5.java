public class Ejercicio5 {
/*
Escribir un programa que mientras el usuario ingrese un número
entero menor que 100 y mayor a 1, muestre por pantalla si el
número es múltiplo de 2 y múltiplo de 3 simultáneamente. (¿Los
valores mencionados en el enunciado deberían ser constantes?.
De a poco habría que definirlos como constantes).
*/
    public static void main(String[] args) {
                
        int numero = 0;

        final int MIN = 1; 
        final int MAX = 100; 
        final int MULT2 = 2; 
        final int MULT3 = 3;

        System.out.println("ingrese un numero");
        numero = Utils.leerInt();

        while(numero > MIN && numero < MAX){

            if((numero % MULT2 == 0) && (numero % MULT3 == 0)){
                System.out.println("el numero es multiplo de 2 y 3");
            }
            else{
                System.out.println("el numero no es multiplo de 2 y 3");
            }
            System.out.println("ingrese un numero");
            numero = Utils.leerInt();
        }
    }
}
