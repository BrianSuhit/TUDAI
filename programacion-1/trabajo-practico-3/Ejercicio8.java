public class Ejercicio8 {
/*
Escribir un programa que solicite un número entero entre 1 y 10, y
realice:
a. Si el numero ingresado es múltiplo de 3 pida ingresar un
caracter y para el caracter ingresado imprima a qué tipo de
carácter está asociado:
i. “letra minúscula” si el carácter es una letra del
abecedario en minúscula;
ii. “letra mayúscula” si el carácter es una letra del
abecedario en mayúscula;
iii. “dígito” si el carácter corresponde a un número;
iv. “otro” para los restantes casos de caracteres.
b.  Si el número ingresado es múltiplo de 5 imprima la tabla de
multiplicar del número ingresado.

*/
public static final int MULT_5 = 5;

public static final int MULT_3 = 3;
    public static void main(String[] args) {

        int numero = obtenerNumero();

        /* ---- NOTAS DE RAZONAMIENTO ---
            1. obtener numero podia ser un metodo de nuevo
            2. la tabla del 5 podia ser un metodo
            3. VALIDAR QUE EL NUMERO ESTRE ENTRE EL 1 Y 10
            4. 
        */

       if(numero % MULT_3 == 0){

            /*
                TODO: HACER PROCEDIMIENTO obtenerCaracter()
                todos los if podian ir dentro
            */
            System.out.println("ingrese un caracter");
            char caracter = Utils.leerChar();

            if(esMinuscula(caracter)){
                System.out.println("letra minuscula");
            }
            else if(esMayuscula(caracter)){
                System.out.println("letra mayuscula");
            }
            else if(esDigito(caracter)){
                System.out.println("digito");
            }
            else{
                System.out.println("otro");
            }
       }
       else if(numero % MULT_5 == 0){
        imprimirTablaDel5();
       }
    }


    public static int obtenerNumero(){

        // TODO: que pasa si mañana es entre otra cosa que es 1 y 10?
        // int numero = DESDE -1 ( opcion robusta )
        int numero = 0;
        System.out.println("ingrese un numero entre 1 y 10");
        numero = Utils.leerInt();

        // TODO: opcion robusta para que no ingresen al revez los valores
        /*
            tomo una variable auxiliar para verificar el orden
        */

        // TODO: 1 Y 10 COMO CONSTANTES
        // TODO: while !(numero >= DESDE && numero <= HASTA)
        while (numero < 1 || numero > 10) {

            // TODO: no hardcodear los mensajes - 1 y 10 debe ser la variable misma
            System.out.println("error ingrese un numero entre 1 y 10");
            numero = Utils.leerInt();
        }
        return numero;
    }

    public static boolean esMinuscula(char c){
        return (c >= 'a' && c <= 'z');
    }

    public static boolean esMayuscula(char c){
        return (c >= 'A' && c <= 'Z');
    }

    public static boolean esDigito(char c){
        return (c >= '0' && c <= '9');
    }

    // TODO: EL NUMERO DEBE SER PASADO COMO PARAMETRO imprimirTablaDel5(int numero)
    public static void imprimirTablaDel5()
    {
        System.out.println("tabla de multiplicar del 5:");
            for(int i = 1; i <= 10; i++){
                System.out.println(MULT_5 + " X " + i + " = " + (i * MULT_5));
            }
    }
}
