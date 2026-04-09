public class Ejercicio11 {
/*
Pedir por consola el ingreso de números enteros. Cuando se
ingrese un 0 se debe terminar el programa informando el
promedio de los números ingresados, cuál fue el mayor número y
cuál fue el menor número.
*/
    public static void main(String[] args) {
        
        int numero = 0;

        int cantidad = 0;
        int total = 0; 

        int min = 0;
        int max = 0;

        System.out.println("ingrese un numero entero");
        numero = Utils.leerInt();

        // si ingresa un 0 el min siempre es 0, se inicializan los min y max afuera del while
        min = numero;
        max = numero;
        double promedio = 0.0;

        while(numero != 0){
  

            cantidad++;
            total = total + numero;

            if(numero < min){
                min = numero;
            }
            else if(numero > max){
                max = numero;
            }

            System.out.println("ingrese un numero entero");
            numero = Utils.leerInt();
        }
        
        // se come los decimales debe ir (double)
        // si ingresa un 0 lanza excepcion NaN debe ir un if
        if(cantidad > 0){
            promedio = (double) total / cantidad;
        }

        System.out.println("el promedio de los numeros ingresados es: " + promedio);
        System.out.println("el numero menor ingresado fue: " + min);
        System.out.println("el numero mayor ingresado fue: " + max);
    }
}
