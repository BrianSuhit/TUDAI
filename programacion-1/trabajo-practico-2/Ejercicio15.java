public class Ejercicio15 {
/*
Pedir por consola un número entero e informar si es un número
primo. Un número es primo si solo es divisible por 1 y por sí
mismo.
*/
    public static void main(String[] args) {
        
        int numero = 0;

        boolean esPrimo = true;

        int divisor = 2;

        System.out.println("ingrese un numero");
        numero = Utils.leerInt();

        while((divisor < numero) && esPrimo){
            if(numero % divisor == 0){
                esPrimo = false;
            }
            divisor++;
        }

        if (esPrimo && numero > 1) {
            System.out.println("El numero ingresado ES primo");
        } else {
            System.out.println("El numero ingresado NO es primo");
        }
    }   
}
