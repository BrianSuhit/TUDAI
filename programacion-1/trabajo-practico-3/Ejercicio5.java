public class Ejercicio5 {
/*
5. Implemente los siguientes métodos e invóquelos desde el main,
en donde se debe mostrar el dato solicitado. En todos los casos,
debe continuar solicitando el dato solicitado hasta que el usuario
lo ingrese correctamente:

a. Un método que permita leer desde teclado una letra
minúscula. Dicho método debe utilizar internamente la
función Utils.leerChar().

b. Un método que permita leer desde teclado un número
natural (número entero mayor a 0). Dicho método debe
utilizar internamente la función Utils.leerInt().

c. Un método que permita leer desde teclado un número entero
dentro de un rango determinado por dos valores: min y max.
Dicho método debe utilizar internamente la función
Utils.leerInt().

d. Un método que permita leer desde teclado un carácter
dentro de un rango determinado por dos valores:
caracter_min y caracter_max. Dicho método debe utilizar
internamente la función Utils.leerChar().

e. Un método que permita leer desde teclado una v. Dicho
método debe utilizar internamente la función Utils.leerChar().

f. Un método que permita leer desde teclado números enteros
múltiplos de un determinado valor numérico. Dicho método
debe utilizar internamente la función Utils.leerInt().
*/
    public static final int MIN = 25;
    public static final int MAX = 75;

    public static final int MULTIPLO = 5;

    public static void main(String[] args) {
        
        char letra = leerLetraMinuscula();
        System.out.println("la letra ingresada es: " + letra);


        int numeroNatural = leerNumeroNatural();
        System.out.println("el numero ingresado es: " + numeroNatural);

        int numeroEntero = leerNumeroEntero();
        System.out.println("el numero ingresado es: " + numeroEntero);

        char caracterValido = validarCaracter();
        System.out.println("el caracter ingresado es: " + caracterValido);

        char leerVocal = leerVocal();
        System.out.println("la v ingresada es: " + leerVocal);

        int numeroMultiplo = leerMultiplo();
        System.out.println("el numero ingresado es: " + numeroMultiplo);
    }

    public static char leerLetraMinuscula(){
        char c = (char)-1;

        while(c < 'a' || c > 'z'){
            System.out.println("ingrese una letra minuscula");
            c = Utils.leerChar();
        }
        return c;
    }

    public static int leerNumeroNatural(){
        /* mientras el numero no sea natural osea mayor a 0*/
        int numero = -1;

        while(numero <= 0){
        System.out.println("ingrese  un numero natural");
        numero = Utils.leerInt();
        }
        return numero;
    }

    private static int leerNumeroEntero() {

        int n = -1;

        while (n < MIN || n > MAX) {
            System.out.println("ingrese un numero entero");
            n = Utils.leerInt();
        }
        return n;
    }

    private static char validarCaracter() {
        char c = ' ';
        char caracter_min = 'A', caracter_max = 'M';

        while (c < caracter_min || c > caracter_max) {
            System.out.println("ingrese un caracter");
            c = Utils.leerChar();
        }
        return c;
    }

    private static char leerVocal(){

        char v = (char)-1;

        while(v != 'a' && v != 'e' && v != 'i' && v != 'o' && v != 'u'){
            System.out.println("ingrese una v");
            v = Utils.leerChar();
        }
        return v;
    }

    private static int leerMultiplo(){

        int n = 0;

        while(n <= 0 ||n % MULTIPLO != 0){
            System.out.println("ingrese un numero multiplo de " + MULTIPLO);
            n = Utils.leerInt();
        }
        return n;
    }
}
