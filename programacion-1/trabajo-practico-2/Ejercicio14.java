public class Ejercicio14 {
/*
Pedir números enteros positivos por teclado. En cada iteración
el usuario puede ingresar 0 para salir del programa. Si ingresa un
número distinto de 0 se debe pedir el ingreso de un carácter.
a. Si es ‘a’ se debe permitir al usuario escribir un texto libre e
imprimirlo por pantalla.
b. Si es ‘b’ se deben pedir 5 números positivos e informar si
fueron ingresados en orden ascendente.
c. Si es ‘c’ se deben pedir dos números enteros negativos e
imprimir la raíz cuadrada de su multiplicación. La raíz
cuadrada de un número se calcula con la sentencia:
Math.sqrt(numero).
d. Ante cualquier otro carácter ingresado se debe informar un
error y pedir nuevamente el carácter.
*/
    public static void main(String[] args) {
        

        int numero = 0;
        final int MAX = 5;

        System.out.println("ingrese un numero entero positivo");
        numero = Utils.leerInt();

        while (numero != 0) {
           
            System.out.println("ingrese un caracter");
            char caracter = Utils.leerChar();

            while (caracter != 'a' && caracter != 'b' && caracter != 'c'){
                System.out.println("Error. Ingrese nuevamente el carácter ('a', 'b' o 'c'):");
                caracter = Utils.leerChar();
            }

                switch (caracter) {
                    case 'a':
                        System.out.println("ingrese una frase");
                        String frase = Utils.leerString();
                        System.out.println("su frase ingresada es: " + frase);
                        break;
                    case 'b':
                        /*
                        int numeroanterior = -1
                        boolean esAscendente = true
                        final int MAX = 5

                        System.out.println("ingrese un numero positivo");
                        numeroActual = Utils.leerInt();
                        for(int i = 0; i < 5; i++){
                            if ( i > 0 && numeroActual <= anterior){
                                esascentente = false
                            }
                            numeroanterior = numeroActual
                        }
                        */
                        boolean esAscendente = true;
                        int numeroAnterior = -1;
                        int numeroActual = 0;

                        for(int i = 0; i < MAX; i++){
                            System.out.println("ingrese un numero positivo");
                            numeroActual = Utils.leerInt();

                            if(numeroActual <= numeroAnterior){
                                esAscendente = false;
                            }
                            numeroAnterior = numeroActual;
                        }

                        if (esAscendente) {
                            System.out.println("Los números fueron ingresados en orden ascendente");
                        } else {
                            System.out.println("El orden NO fue ascendente");
                        }
                        break;
                    case 'c':
                        int numero1 = 0;
                        int numero2 = 0;

                        System.out.println("Ingrese el primer numero entero negativo");
                        numero1 = Utils.leerInt();

                        System.out.println("Ingrese el segundo numero entero negativo");
                        numero2 = Utils.leerInt();
                        /*
                            int multiplicacion = numero1 * numero2;
                            double raiz = Math.sqrt(multiplicacion);
                            System.out.println("la raiz cuadrada de la multiplicacion es: " + raiz);
                        */
                        double raiz = Math.sqrt(numero1 * numero2);

                        System.out.println("la raiz cuadrada de la multiplicacion es: " + raiz);
                        break;
                    default:
                        System.out.println("Error. Ingrese nuevamente el carácter ('a', 'b' o 'c'):");
                        caracter = Utils.leerChar();
                        break;
                }
            System.out.println("ingrese un numero entero positivo");
            numero = Utils.leerInt();
        }
        System.out.println("Fin del programa, gracias por utilizar el sistema");
    }
}
