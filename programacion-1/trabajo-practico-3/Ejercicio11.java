public class Ejercicio11 {
/*
11. Escribir un programa que solicite al usuario el ingreso de un
número entero natural, llame a un método que calcule la
sumatoria desde 1 a dicho número (Ej: si n= 5 sumatoria =
1+2+3+4+5=15) y retorne el resultado.
*/

    public static final int MIN = 1;
    
    public static void main(String[] args) {

        int numIngresado = obtenerNumero();

        int resultado = secuenciaSumatoria(numIngresado);

        System.out.println("el resultado de la sumatorio desde " + MIN + " hasta " + numIngresado + " es: " + resultado);
    }

    /*
    TODO:
     que pasa si el usuario es un mono e ingresado algo que no sea un NUMERO ENTERO NATURAL?
    */
    public static int obtenerNumero(){

        int numero = 0;

        while(numero <= 0){
            System.out.println("ingrese un numero entero natural");
            numero = Utils.leerInt();
        }
        return numero;
    }

    public static int secuenciaSumatoria(int n){
        int suma = 0;

        for(int i = MIN; i <= n; i++){

            suma += i;
        }
        return suma;
    }
}
