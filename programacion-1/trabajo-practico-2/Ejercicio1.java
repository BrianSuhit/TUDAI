public class Ejercicio1 {
/*
Escribir un programa completo (declaración de constantes y
variables, carga de datos, procesamiento e impresión de
resultados) para cada caso o ítem que:
a. solicite un número e indique si es positivo o negativo.
b. solicite un número e imprima “grande” si es mayor a 100 y
“chico “ si es menor.
c. solicite un número del 1 al 7 e imprima el día de la semana.
d. solicite una letra e imprima si es vocal o consonante.
e. solicite 3 números e imprima “creciente” si los tres números
están en orden creciente, “decreciente” si están en orden
decreciente o “error” si no cumplen ningún orden
*/
    public static void main(String[] args) {
        
        final int CONDICION_A = 0;
        final int CONDICION_B = 100;
        int numero = 0;

        System.out.println("Ingrese un numero entero");

        numero = Utils.leerInt();

        if(numero > CONDICION_A){
            System.out.println("el numero es positivo");
        }
        else if (numero == CONDICION_A){ // si la consigna no lo pide no mostrarr - igual es ambiguo
            System.out.println("el numero es cero");
        }
        else {
            System.out.println("el numero es negativo");
        }

        if(numero > CONDICION_B){
            System.out.println("Grande");
        }
        else{
            System.out.println("Chico");
        }

    //-----------------------------------------------------------
        int numeroAdeterminar = 0;

        System.out.println("ingrese un numero del 1 al 7");
        numeroAdeterminar = Utils.leerInt();

        switch (numeroAdeterminar) {
            case 1:
                System.out.println("Lunes");
                break;
            case 2:
                System.out.println("Martes");
                break;
            case 3:
                System.out.println("Miercoles");
                break;
            case 4:
                System.out.println("Jueves");
                break;
            case 5:
                System.out.println("Viernes");
                break;
            case 6:
                System.out.println("Sabado");
                break;
            case 7:
                System.out.println("Domingo");
                break;
            default:
                // System.out.println("ingrese un numero del 1 al 7 por favor");
                // numeroAdeterminar = Utils.leerInt(); NO FUNCIONA SI NO HAY UN WHILE
                System.out.println("error");
                break;
        }

    //-----------------------------------------------------------
    // D -
        char letra = ' ';

        System.out.println("Ingrese una letra");
        letra = Utils.leerChar();

        // switch (letra) {
        //     case 'a':
        //         System.out.println("Es la vocal A");
        //         break;
        //     case 'e':
        //         System.out.println("Es la vocal E");
        //         break;
        //     case 'i':
        //         System.out.println("Es la vocal I");
        //         break;
        //     case 'o':
        //         System.out.println("Es la vocal O");
        //         break;
        //     case 'u':
        //         System.out.println("Es la vocal U");
        //         break;
        //     default:
        //         System.out.println("ingreso la consonante: " + letra);
        //         break;
        // }
        // NOTA DEL PROFE: SE PODIA HACER UN SOLO PRINT

        switch (letra) {
            case 'a': case 'e': case 'i': case 'o': case 'u':
                System.out.println("Es una vocal");
                break;
            default:
                System.out.println("ingreso la consonante: " + letra);
                break;
        }
    
    //----------------------------------------------------------------------
    // E -
        int a = 0;
        int b = 0;
        int c = 0;

        System.out.println("Ingrese el primer numero");
        a = Utils.leerInt();

        System.out.println("Ingrese el segundo numero");
        b = Utils.leerInt();

        System.out.println("Ingrese el tercer numero");
        c = Utils.leerInt();

        if(a < b && b < c){
            System.out.println("Creciente");
        }
        else if(a > b && b > c){
            System.out.println("Decreciente");
        }
        else{
            System.out.println("error");
        }
    }
}
